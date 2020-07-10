package org.sarahwdt.controller.authorization;

import org.sarahwdt.model.entities.User;

import java.util.Optional;

public interface Authorization<U extends User>{
    Optional<String> authorize(U userInstance);
}
