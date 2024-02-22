package io.github.oengajohn.sakilaapp.service.impl;

import io.github.oengajohn.sakilaapp.entity.Menu;
import io.github.oengajohn.sakilaapp.exception.UserNotFoundException;
import io.github.oengajohn.sakilaapp.repository.MenuRepository;
import io.github.oengajohn.sakilaapp.repository.PermissionRepository;
import io.github.oengajohn.sakilaapp.repository.UserRepository;
import io.github.oengajohn.sakilaapp.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final PermissionRepository permissionRepository;
    private final UserRepository userRepository;

    public MenuServiceImpl(MenuRepository menuRepository, PermissionRepository permissionRepository, UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.permissionRepository = permissionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<List<Menu>> getMenuItemsForUser(String username) {
        return userRepository.findByUsername(username)
                .switchIfEmpty(Mono.error(new UserNotFoundException("User not found")))
                .flatMap(user -> menuRepository.retrieveAllowedMenus(username)
                        .collectList()
                        .flatMap(ids -> {
                            if (ids.isEmpty()) {
                                return Mono.just(new ArrayList<>());
                            } else {
                                return menuRepository.retrieveParentMenus(ids)
                                        .collectList()
                                        .flatMap(parentMenuList -> {
                                            List<Mono<Menu>> menuMonos = new ArrayList<>();
                                            for (Menu parentMenu : parentMenuList) {
                                                Flux<Menu> childMenus = menuRepository.retrieveChildMenus(parentMenu.getId());
                                                Mono<List<Menu>> childMenuMono = childMenus.collectList();
                                                menuMonos.add(childMenuMono.map(children -> {
                                                    parentMenu.setItems(children);
                                                    return parentMenu;
                                                }));
                                            }
                                            return Mono.zip(menuMonos, objects -> {
                                                List<Menu> result = new ArrayList<>();
                                                for (Object obj : objects) {
                                                    result.add((Menu) obj);
                                                }
                                                return result;
                                            });
                                        });
                            }
                        }));
    }


}
