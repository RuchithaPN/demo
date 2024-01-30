package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BmrAndDailyCalorieNeeds;
import com.example.model.User;
import com.example.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/bmr-and-daily-calorie-needs")
    public ResponseEntity<BmrAndDailyCalorieNeeds> getBmrAndDailyCalorieNeeds(@PathVariable Long userId) {
        double bmr = userService.calculateBmr(userId);
        double dailyCalorieNeeds = userService.calculateDailyCalorieNeeds(userId);
        BmrAndDailyCalorieNeeds result = new BmrAndDailyCalorieNeeds(bmr, dailyCalorieNeeds);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    

   
}
