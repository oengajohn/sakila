package io.github.oengajohn.sakilaapp.repository;

import io.github.oengajohn.sakilaapp.entity.Menu;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface MenuRepository extends ReactiveCrudRepository<Menu, Integer> {

    @Query(value = "SELECT p.menu_id as menuId FROM users u INNER JOIN permissions p ON u.group_id =p.group_id INNER JOIN menu m ON p.menu_id = m.id WHERE u.username =:username ")
    Flux<Integer> retrieveAllowedMenus(@Param("username") String username);

    @Query(value = "select id, text, iconCls FROM menu WHERE menu_id IS NULL AND id in (:ids)")
    Flux<Menu> retrieveParentMenus(@Param("ids") List<Integer> ids);


    @Query(value = "select * from menu m where m.menu_id =:menuId")
    Flux<Menu> retrieveChildMenus(@Param("menuId") Integer menuId);
}
