package com.example.healthopedia;

public class Calculation {
    private Double BMR;
    protected double calculateCalLight(Integer age, Double height, Double weight, String gender){
        if (gender.equals("Male")){
            BMR = 66.5 + (weight*13.75) + (height*5.003) - (age*6.755);
        }
        else if(gender.equals("Female")){
            BMR = 655.1 + (weight * 9.563) + (height * 1.850) - (age * 4.676);
        }
        return BMR * 1.375;
    }
    protected double calculateCalModerate(Integer age, Double height, Double weight, String gender){
        if (gender.equals("Male")){
            BMR = 66.5 + (weight*13.75) + (height*5.003) - (age*6.755);
        }
        else if(gender.equals("Female")){
            BMR = 655.1 + (weight * 9.563) + (height * 1.850) - (age * 4.676);
        }
        return BMR * 1.55;
    }
    protected double calculateCalHigh(Integer age, Double height, Double weight, String gender){
        if (gender.equals("Male")){
            BMR = 66.5 + (weight*13.75) + (height*5.003) - (age*6.755);
        }
        else if(gender.equals("Female")){
            BMR = 655.1 + (weight * 9.563) + (height * 1.850) - (age * 4.676);
        }
        return BMR * 1.725;
    }
}
