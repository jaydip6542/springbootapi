package com.example.api.Helloworld;

public class HelloWorld {

     private String data;

    public HelloWorld() {
    }

    public HelloWorld(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "data='" + data + '\'' +
                '}';
    }
}

