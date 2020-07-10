package org.sarahwdt.model.services;

import org.sarahwdt.model.dao.DAO;
import org.sarahwdt.model.dao.UserDAO;
import org.sarahwdt.model.entities.User;

import java.util.List;
import java.util.Optional;

public class UserServices {
    private final DAO<User> userDAO = new UserDAO();

    public UserServices(){
    }

    public Optional<User> findUser(int id){
        return Optional.of(userDAO.findById(id));
    }

    public Optional<User> findUser(String name){
        return findAllUsers()
                .stream()
                .filter((user1 -> user1.getName().equals(name)))
                .findFirst();
    }

    public void saveUser(User user){
        userDAO.save(user);
    }

    public void updateUser(User user){
        userDAO.update(user);
    }

    public void deleteUser(User user){
        userDAO.delete(user);
    }

    public List<User> findAllUsers() {
        return userDAO.findAll();
    }
}
