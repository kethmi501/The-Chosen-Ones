package com.example.healthopedia;

public class bmi {

    public double calculateBMIMetric(double heightCm, double weightKg) {
        return ((weightKg / ((heightCm)  * (heightCm)))*10000);
    }
}
