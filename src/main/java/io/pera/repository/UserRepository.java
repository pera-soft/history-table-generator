package io.pera.repository;

import io.pera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface UserRepository extends JpaRepository<User, Integer>, RevisionRepository<User, Integer, Integer> {
}
