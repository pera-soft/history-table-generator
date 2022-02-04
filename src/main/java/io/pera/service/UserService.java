package io.pera.service;

import io.pera.model.User;
import io.pera.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> list() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(int id, User user) {
        User persistedUser = repository.getById(id);
        persistedUser.setFirstName(user.getFirstName());
        persistedUser.setLastName(user.getLastName());
        return repository.save(persistedUser);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
