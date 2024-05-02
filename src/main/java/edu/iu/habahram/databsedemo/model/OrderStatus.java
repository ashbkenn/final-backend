package edu.iu.habahram.databsedemo.model;

public enum OrderStatus {
    REVIEW("Review"), DELIVERY("Delivery"), DONE("Done");

    private String s;

    private OrderStatus(String s) {this.s = s;}


    @Override
    public String toString() {return s;}
}
