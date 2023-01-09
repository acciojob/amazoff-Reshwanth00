package com.driver;
public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {
        this.id = id;
        int time = Integer.parseInt(deliveryTime.substring(0, 2)) * 60 + Integer.parseInt(deliveryTime.substring(3));
        this.deliveryTime = time;
    }
    public String getId() {
        return id;
    }
    public int getDeliveryTime() {
        return deliveryTime;
    }
}