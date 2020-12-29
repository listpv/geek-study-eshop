package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.controller.data.RoleData;
import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.repo.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(RoleData roleData) {

        Role role = new Role();
        role.setId(roleData.getId());
        role.setName(roleData.getName());
        role.setUsers(roleData.getUserList());
        roleRepository.save(role);

    }

    @Override
    public List<RoleData> findAll() {
        return roleRepository.findAll().stream()
                .map(RoleData::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleData> findById(Long id) {
        return roleRepository.findById(id).map(RoleData::new);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

}
