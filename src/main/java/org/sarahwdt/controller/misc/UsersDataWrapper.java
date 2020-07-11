package org.sarahwdt.controller.misc;

import org.sarahwdt.model.entities.User;

import java.util.Collection;

public class UsersDataWrapper {
    public Collection<User> collection;

    public UsersDataWrapper(Collection<User> collection) {
        this.collection = collection;
    }

    public Collection<User> getCollection() {
        return collection;
    }

    public void setCollection(Collection<User> collection) {
        this.collection = collection;
    }
}
