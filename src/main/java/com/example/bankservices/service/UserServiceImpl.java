package com.example.bankservices.service;

import com.example.bankservices.dto.UserDto;
import com.example.bankservices.model.User;
import com.example.bankservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User register(UserDto userDto) {
        User user = new User();
        user.setSurname(userDto.getAddress());
        user.setName(userDto.getName());
        user.setBirthdate(userDto.getBirthdate());
        user.setAddress(userDto.getAddress());
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getBySurname(String surname) {
        List<User> users = userRepository.findBySurname(surname);
        users.sort(Comparator.comparing(User::getAddress));
        return users;
    }
}