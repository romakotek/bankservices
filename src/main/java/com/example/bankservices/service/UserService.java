package com.example.bankservices.service;

import com.example.bankservices.dto.UserDto;
import com.example.bankservices.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User register(UserDto userDto);

    public User getById(Long id);

    public List<User> getAll();

    public List<User> getBySurname(String surname);
}
