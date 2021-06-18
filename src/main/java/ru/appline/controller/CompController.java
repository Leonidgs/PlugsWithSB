package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CompController {

    private HashMap<String, String> map = new HashMap<>();
    private static Result res = new Result();

    @PostMapping(value = "/setRange", consumes = "application/json")
    public void setRange(@RequestBody Sides side) {

        map.put("East", side.getEast());
        map.put("West", side.getWest());
        map.put("North", side.getNorth());
        map.put("South", side.getSouth());
        map.put("NorthEast", side.getNorthEast());
        map.put("SouthEast", side.getSouthEast());
        map.put("SouthWest", side.getSouthWest());
        map.put("NorthWest", side.getNorthWest());

    }

    @GetMapping(value = "/getResult", consumes = "application/json", produces = "application/json")
    public Result som1(@RequestBody Degree degree) {

        int grad = degree.getDegree();

        if (grad >=0 && grad <= 360) {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                ArrayList<Integer> ok = new ArrayList();

                String[] num = map.get(entry.getKey()).split("-");

                for (String n : num) {
                    ok.add(Integer.parseInt(n));
                }
                int a = ok.get(0);
                int b = ok.get(1);
                if (a < b) {
                    if (grad >= a && grad <= 360 && grad <= b) {
                        res.setSide(entry.getKey().toString());
                        return res;
                    }
                } else if (a > b) {
                    if (grad >= a && grad <= 360 && grad >= b) {
                        res.setSide(entry.getKey().toString());
                        return res;
                    } else if (grad <= a && grad <= 360 && grad <= b) {
                        res.setSide(entry.getKey().toString());
                        return res;
                    }
                }
            }
        }
        return null;
    }
}
