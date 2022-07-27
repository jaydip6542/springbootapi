package com.example.api.Helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/helloWorld")
public class HelloWorldController {

    @GetMapping
    public HelloWorld hello(){

        return new HelloWorld(
                "Hello World"
        );
    }

}
