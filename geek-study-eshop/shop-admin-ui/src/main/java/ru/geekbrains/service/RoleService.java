package ru.geekbrains.service;

import ru.geekbrains.controller.data.RoleData;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    void save(RoleData roleData);

    List<RoleData> findAll();

    Optional<RoleData> findById(Long id);

    void delete(Long id);
}
