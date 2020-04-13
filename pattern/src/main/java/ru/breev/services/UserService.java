package ru.breev.services;

import ru.breev.entities.User;
import ru.breev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.findAll();
    }

    public User findById(Integer id) throws SQLException {
        return userRepository.findById(id);
    }
}
