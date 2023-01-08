package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    private Map<String,Order> orders = new HashMap<String,Order>();
    private Map<String,DeliveryPartner> partners = new HashMap<String,DeliveryPartner>();
    private Map<String, List<String>> pairs = new HashMap<String, List<String>>();
    private Map<String, Boolean> status = new HashMap<String,Boolean>();

    public void addOrder(Order order) {
        status.put(order.getId(),false);
        orders.put(order.getId(), order);
    }

    public void addPartner(String partnerId) {
        partners.put(partnerId,new DeliveryPartner(partnerId));
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        List<String> list = pairs.getOrDefault(partnerId, null);
        assert list != null;
        list.add(orderId);
        Order order = orders.get(orderId);
        order.setPartner(partnerId);
        orders.put(orderId,order);
        DeliveryPartner temp = partners.get(partnerId);
        temp.setNumberOfOrders(temp.getNumberOfOrders()+1);
        partners.put(partnerId,temp);
        status.put(orderId,true);
        pairs.put(partnerId,list);
    }

    public Order getOrderById(String orderId) {
        return orders.getOrDefault(orderId, null);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return partners.getOrDefault(partnerId, null);
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        return new ArrayList<>(pairs.get(partnerId));
    }

    public List<String> getAllOrders() {
        return new ArrayList<>(orders.keySet());
    }

    public Integer getCountOfUnassignedOrders() {
        int count = 0;
        for (Map.Entry<String, Boolean> itr : status.entrySet()) {
            if (!itr.getValue()) {
                count++;
            }
        }
        return count;
    }

    public void deletePartnerById(String partnerId) {
        List<String> list = pairs.get(partnerId);
        for(int i=0;i<list.size();i++){
            status.put(list.get(i),false);
        }
        pairs.remove(partnerId);
        partners.remove(partnerId);
    }

    public void deleteOrderById(String orderId) {
        String partnerId = orders.get(orderId).getPartner();
        orders.remove(orderId);
        List<String> list = pairs.get(partnerId);
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(orderId)){
                list.remove(i);
                break;
            }
        }
    }
}
