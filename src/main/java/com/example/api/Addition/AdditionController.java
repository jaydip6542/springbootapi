package com.example.api.Addition;

import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    private final Addition addition;

    public AdditionController(Addition addition) {
        this.addition = addition;
    }

    @GetMapping("/add")
    public ResponseEntity<Object> getAddition(@RequestParam Integer a, @RequestParam Integer b){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",addition.sum(a,b));
        return ResponseEntity.ok(jsonObject);
    }
}
