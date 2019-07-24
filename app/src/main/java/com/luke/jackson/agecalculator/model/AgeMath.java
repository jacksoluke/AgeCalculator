package com.luke.jackson.agecalculator.model;

public class AgeMath {
    private int years;
    private int months;
    private int weeks;
    private int days;
    private double hours;
    private double minutes;
    private double seconds;


    // This constructor takes the Value you entered and calculates your age
    public AgeMath(int years) {
        this.years = years;
        this.months = years * 12;
        this.weeks = this.months * 4;
        this.days = this.weeks * 7;
        this.hours = this.days * 24;
        this.minutes = this.hours * 60;
        this.seconds = this.minutes * 60;
    }


    // These getters are used to return values for the 'result' object
    public int getYears() {
        return years;
    }

    public int getMonths() {
        return months;
    }

    public int getWeeks() {
        return weeks;
    }

    public int getDays() {
        return days;
    }

    public double getHours() {
        return hours;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getSeconds() {
        return seconds;
    }
}
