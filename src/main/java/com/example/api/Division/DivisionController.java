package com.example.api.Division;

import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivisionController {

      private final  Division division;

    public DivisionController(Division division) {
        this.division = division;
    }

    @GetMapping("/division")
    public ResponseEntity<Object> getdivision(@RequestParam Integer a, @RequestParam Integer b){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",division.division(a,b));
        return ResponseEntity.ok(jsonObject);
    }
}
