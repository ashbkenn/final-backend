package edu.iu.habahram.databsedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    ROSES("Roses"),
    LILIES("Lilies"),
    TULIPS("Tulips"),
    MIXED("Mixed"),
    DAISIES("Daisies");


    private final String s;

    private Type(String s) {
        this.s = s;
    }


    @Override
    public String toString() {return s;}


}