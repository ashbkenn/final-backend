package edu.iu.habahram.databsedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Color {
    RED("Red"), YELLOW("Yellow"), GREEN("Green"), ORANGE("Orange"), MIXED("Mixed");

    private final String s;

    private Color(String s) {this.s = s;}


    @Override
    public String toString() {return s;}

}