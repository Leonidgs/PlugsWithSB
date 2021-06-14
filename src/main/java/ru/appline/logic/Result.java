package ru.appline.logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {


    String Side;

    public Result(String side) {
        this.Side = side;
    }

    public Result(){
        super();
    }

    public String getSide() {
        return Side;
    }

    @JsonProperty(value = "Side")
    public void setSide(String side) {
        this.Side = side;
    }
}
