package org.sarahwdt.model;

import org.sarahwdt.model.entities.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersModel {
    private static UsersModel instance = new UsersModel();

    private List<User> model;

    public static UsersModel getInstance() {
        return instance;
    }

    private UsersModel() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }

    public User getUser(String name){
        for(User u: model) if(u.getName().equals(name)) return u;
        return null;
    }

    public List<User> getUsers(){
        return model;
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
