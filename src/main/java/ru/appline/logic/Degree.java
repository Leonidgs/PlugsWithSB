package ru.appline.logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Degree {
    int degree;

    @JsonCreator
    public Degree(@JsonProperty("Degree") int degree) {
        this.degree = degree;
    }

    public Degree(){
        super();
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
