package com.example.bankservices.controller;

import com.example.bankservices.dto.UserDto;
import com.example.bankservices.model.User;
import com.example.bankservices.repository.UserRepository;
import com.example.bankservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("v1/user")
    public User register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }


    @GetMapping("v1/user/all")
    public List<User> getAll() {

        return userService.getAll();
    }

    @GetMapping("v1/user")
    public List<User> getBySurname(@RequestParam String surname) {
        User user1 = new User();
        user1.setAddress("Add1");
        user1.setBirthdate(LocalDate.now());
        user1.setName("Name1");
        user1.setSurname("Surname1");

        User user2 = new User();
        user2.setAddress("Add2");
        user2.setBirthdate(LocalDate.now());
        user2.setName("Name2");
        user2.setSurname("Surname2");

        userRepository.save(user1);
        userRepository.save(user2);
        return userService.getBySurname(surname);
    }
}
