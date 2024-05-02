package edu.iu.habahram.databsedemo.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "flowers", name="orders")
public class OrderData {
    @Id
    @GeneratedValue
    private int id;

    private int flowerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String recipientName;

    private String flowerName;
    private float totalCost;
    private String customerUserName;


    public OrderData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public OrderStatus getStatus() {
        return orderStatus;
    }

    public void setStatus(OrderStatus status) {
        this.orderStatus = status;
    }
}

