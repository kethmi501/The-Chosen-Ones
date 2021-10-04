package com.example.healthopedia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class bmiTest {
    private bmi bmi;

    @BeforeEach
    public void setup(){
        bmi = new bmi();
    }

    @Test
    public void testBMI(){
        int res = (int) bmi.calculateBMIMetric(156, 45);
        assertEquals(18.0,res);
    }
}
