package com.driver;

public class Order {

    private String id;
    private int deliveryTime;
    private String partner;

    public Order(String id, String deliveryTime) {
        this.id=id;
        String [] time = deliveryTime.split(":");
        this.deliveryTime=Integer.parseInt(time[0])*60;
        this.deliveryTime+=Integer.parseInt(time[1]);
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
