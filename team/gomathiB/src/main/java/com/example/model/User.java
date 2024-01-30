package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_level")
    private ActivityLevel activityLevel;

    @Column(name = "bmr")
    private double bmr;

    @Column(name = "daily_calorie_needs")
    private double dailyCalorieNeeds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ActivityLevel getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(ActivityLevel activityLevel) {
		this.activityLevel = activityLevel;
	}

	public double getBmr() {
		return bmr;
	}

	public void setBmr(double bmr) {
		this.bmr = bmr;
	}

	public double getDailyCalorieNeeds() {
		return dailyCalorieNeeds;
	}

	public void setDailyCalorieNeeds(double dailyCalorieNeeds) {
		this.dailyCalorieNeeds = dailyCalorieNeeds;
	}

	public User(int age, Gender gender, double height, double weight, ActivityLevel activityLevel, double bmr,
			double dailyCalorieNeeds) {
		super();
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.activityLevel = activityLevel;
		this.bmr = bmr;
		this.dailyCalorieNeeds = dailyCalorieNeeds;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

    private static class BmrAndDailyCalorieNeeds {
        private double bmr;
        private double dailyCalorieNeeds;

        public BmrAndDailyCalorieNeeds(double bmr, double dailyCalorieNeeds) {
            this.bmr = bmr;
            this.dailyCalorieNeeds = dailyCalorieNeeds;
        }

        public double getBmr() {
            return bmr;
        }

        public void setBmr(double bmr) {
            this.bmr = bmr;
        }

        public double getDailyCalorieNeeds() {
            return dailyCalorieNeeds;
        }

        public void setDailyCalorieNeeds(double dailyCalorieNeeds) {
            this.dailyCalorieNeeds = dailyCalorieNeeds;
        }
    }
    // Constructors, getters and setters omitted for brevity
}

