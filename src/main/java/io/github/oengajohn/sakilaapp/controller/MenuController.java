package io.github.oengajohn.sakilaapp.controller;

import io.github.oengajohn.sakilaapp.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaapp.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class MenuController {

    private final MenuService menuService;


    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public Mono<GenericResponse<?>> getMenuItemsForUser(@RequestParam String username) {
        return menuService.getMenuItemsForUser(username)
                .map(menuItems -> GenericResponse.success(menuItems, "Menu items fetched successfully",menuItems.size()));
    }
}
