package edu.iu.habahram.databsedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Occasion {
    BIRTHDAY("Birthday"), MOTHERSDAY("Mother's Day"), THANKYOU("Thank You");

    private String s;

    private Occasion(String s) {this.s = s;}


    @Override
    public String toString() {return s;}


}
