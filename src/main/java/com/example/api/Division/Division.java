package com.example.api.Division;

import org.springframework.stereotype.Service;

@Service
public class Division {
    public double division(int num1, int num2) {
        return num1/num2;
    }
}
