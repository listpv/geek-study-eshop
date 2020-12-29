package ru.geekbrains.service;

import ru.geekbrains.controller.data.UserData;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(UserData userData);

    List<UserData> findAll();

    Optional<UserData> findById(Long id);

    void delete(Long id);
}
