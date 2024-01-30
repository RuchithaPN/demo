package com.example.model;



public class BmrAndDailyCalorieNeeds {
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
