package ru.geekbrains.controller.data;

import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.model.User;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class RoleData {

    private Long id;

    @NotEmpty
    private String name;

    private List<User> userList;

    public RoleData() {
    }

    public RoleData(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.userList = role.getUsers();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "RoleData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userList=" + userList +
                '}';
    }
}
