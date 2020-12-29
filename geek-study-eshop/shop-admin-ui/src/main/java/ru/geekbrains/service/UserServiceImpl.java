package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.controller.data.UserData;
import ru.geekbrains.persist.model.User;
import ru.geekbrains.persist.repo.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(UserData userData) {
        User user = new User();
        user.setId(userData.getId());
        user.setName(userData.getUsername());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setEmail(userData.getEmail());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setRoles(userData.getRoles());
        userRepository.save(user);
    }

    @Override
    public List<UserData> findAll() {
        return userRepository.findAll().stream()
                .map(UserData::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserData> findById(Long id) {
        return userRepository.findById(id).map(UserData::new);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
