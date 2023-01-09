package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addPartner(String partnerId) {
        orderRepository.addPartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId,partnerId);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return orderRepository.getPartnerById(partnerId);
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        return orderRepository.getPartnerById(partnerId).getNumberOfOrders();
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        return orderRepository.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public Integer getCountOfUnassignedOrders() {
            return orderRepository.getCountOfUnassignedOrders();
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        List<String> list = orderRepository.getOrdersByPartnerId(partnerId);
        String [] clock = time.split(":");
        int totalTime = Integer.parseInt(clock[0])*60;
        totalTime+=Integer.parseInt(clock[1]);
        int count=0;
        for (String s : list) {
            if (getOrderById(s).getDeliveryTime() < totalTime) {
                count++;
            }
        }
        return count;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        int lastTimeDelivered = 0;
        List<String> list = orderRepository.getOrdersByPartnerId(partnerId);
        for(int i=0;i<list.size();i++){
            lastTimeDelivered=Math.max(lastTimeDelivered,getOrderById(list.get(i)).getDeliveryTime());
        }
        return Integer.toString(lastTimeDelivered);
    }

    public void deletePartnerById(String partnerId) {
        orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderRepository.deleteOrderById(orderId);
    }

    public boolean check(String partnerId) {
        return getPartnerById(partnerId) != null;
    }
}
