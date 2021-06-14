package ru.appline.logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sides {

/*    {

            "North": "340-25",
            "NorthEast": "26-101",
            "East": "102-135",
            "SouthEast": "136-205",
            "South": "206-271",
            "SouthWest": "272-299",
            "West": "300-315",
            "NorthWest": "316-339"

    }*/

    private String north;
    private String northEast;
    private String east;
    private String southEast;
    private String south;
    private String southWest;
    private String west;
    private String northWest;

 /*   @JsonCreator
    public Sides(@JsonProperty("East") String east,@JsonProperty("West") String west,
                 @JsonProperty("North") String north,@JsonProperty("South") String south) {
        this.East = east;
        this.west = west;
        this.north = north;
        this.south = south;
    }*/

    @JsonCreator
    public Sides(@JsonProperty("North") String north,@JsonProperty("NorthEast") String northEast,
                 @JsonProperty("East") String east,@JsonProperty("SouthEast") String southEast,
                 @JsonProperty("South") String south,@JsonProperty("SouthWest") String southWest,
                 @JsonProperty("West") String west,@JsonProperty("NorthWest") String northWest) {

        this.north = north;
        this.northEast = northEast;
        this.east = east;
        this.southEast = southEast;
        this.south = south;
        this.southWest = southWest;
        this.west = west;
        this.northWest = northWest;
    }

    public Sides() {
        super();
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getNorthEast() {
        return northEast;
    }

    public void setNorthEast(String northEast) {
        this.northEast = northEast;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouthEast() {
        return southEast;
    }

    public void setSouthEast(String southEast) {
        this.southEast = southEast;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getSouthWest() {
        return southWest;
    }

    public void setSouthWest(String southWest) {
        this.southWest = southWest;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getNorthWest() {
        return northWest;
    }

    public void setNorthWest(String northWest) {
        this.northWest = northWest;
    }
}
