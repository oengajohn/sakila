package io.github.oengajohn.sakilaapp.service;

import io.github.oengajohn.sakilaapp.entity.Menu;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MenuService {
    Mono<List<Menu>> getMenuItemsForUser(String username);
}
