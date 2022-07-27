package com.example.api.Addition;


import org.springframework.stereotype.Service;

@Service
public class Addition {

    public int sum(int num1, int num2) {
        return num1+num2;
    }

}
