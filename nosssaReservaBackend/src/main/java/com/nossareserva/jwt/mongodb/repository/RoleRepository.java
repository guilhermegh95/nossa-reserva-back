package com.nossareserva.jwt.mongodb.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.nossareserva.jwt.mongodb.models.ERole;
import com.nossareserva.jwt.mongodb.models.Role;
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}