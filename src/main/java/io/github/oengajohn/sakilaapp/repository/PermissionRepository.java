package io.github.oengajohn.sakilaapp.repository;

import io.github.oengajohn.sakilaapp.entity.Permission;
import io.github.oengajohn.sakilaapp.entity.PermissionKey;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface PermissionRepository extends R2dbcRepository<Permission, PermissionKey> {



}
