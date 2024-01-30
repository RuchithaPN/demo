package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Gender;
import com.example.model.User;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Calculate the BMR and daily calorie needs for the user
        double bmr = calculateBmr(user);
        double dailyCalorieNeeds = calculateDailyCalorieNeeds(user, bmr);

        // Set the calculated values for the user
        user.setBmr(bmr);
        user.setDailyCalorieNeeds(dailyCalorieNeeds);

        // Save the user to the database
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User newUser) {
        User user = userRepository.findById(userId)
                .orElseThrow();
    
        user.setAge(newUser.getAge());
        user.setGender(newUser.getGender());
        user.setHeight(newUser.getHeight());
        user.setWeight(newUser.getWeight());
        user.setActivityLevel(newUser.getActivityLevel());

        // Recalculate BMR and daily calorie needs
        double bmr = calculateBmr(user);
        double dailyCalorieNeeds = calculateDailyCalorieNeeds(user, bmr);
        user.setBmr(bmr);
        user.setDailyCalorieNeeds(dailyCalorieNeeds);

        // Save the updated user to the database
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public double calculateBmr(User user) {
        double bmr;

        if (user.getGender() == Gender.MALE) {
            bmr = (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + 5;
        } else {
            bmr = (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) - 161;
        }

        return bmr;
    }

    public double calculateDailyCalorieNeeds(User user, double bmr) {
        double dailyCalorieNeeds;

        switch (user.getActivityLevel()) {
            case SEDENTARY:
                dailyCalorieNeeds = bmr * 1.2;
                break;
            case LIGHTLY_ACTIVE:
                dailyCalorieNeeds = bmr * 1.375;
                break;
            case MODERATELY_ACTIVE:
                dailyCalorieNeeds = bmr * 1.55;
                break;
            case VERY_ACTIVE:
                dailyCalorieNeeds = bmr * 1.725;
                break;
            case EXTREMELY_ACTIVE:
                dailyCalorieNeeds = bmr * 1.9;
                break;
            default:
                dailyCalorieNeeds = bmr * 1.2;
                break;
        }

        return dailyCalorieNeeds;
    }

    public double calculateBmr(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return calculateBmr(user);
    }

    public double calculateDailyCalorieNeeds(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        double bmr = calculateBmr(user);
        return calculateDailyCalorieNeeds(user, bmr);
    }
}
