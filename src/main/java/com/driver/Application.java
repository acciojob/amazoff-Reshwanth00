package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
/*

Get Partner by partnerId: GET /orders/get-partner-by-id/{partnerId} Pass partnerId string as path variable Return
DeliveryPartner object wrapped in a ResponseEntity object Controller Name - getPartnerById

Get number of orders assigned to given partnerId: GET /orders/get-order-count-by-partner-id/{partnerId} Pass partnerId
as path variable Return Integer wrapped in a ResponseEntity object Controller Name - getOrderCountByPartnerId

Get List of all orders assigned to given partnerId: GET /orders/get-orders-by-partner-id/{partnerId} Pass partnerId
as path variable Return List of Order object wrapped in a ResponseEntity object Controller Name - getOrdersByPartnerId

Get List of all orders in the system: GET /orders/get-all-orders No params or body required Return List of Order object
wrapped in a ResponseEntity object Controller Name - getAllOrders

Get count of orders which are not assigned to any partner: GET /orders/get-count-of-unassigned-orders No params or body
required Return Integer wrapped in a ResponseEntity object Controller Name - getCountOfUnassignedOrders

Get count of orders which are left undelivered by partnerId after given time: GET /orders/get-count-of-orders-left-after
-given-time Pass time string (in HH:MM format) and partnerId string as path variable Return Integer wrapped in a
ResponseEntity object Controller Name - getOrdersLeftAfterGivenTimeByPartnerId

Get the time at which the last delivery is made by given partner: GET /orders/get-last-delivery-time/{partnerId} Pass
partnerId string as path variable Return String with format HH:MM wrapped in a ResponseEntity object Controller Name -
getLastDeliveryTimeByPartnerId

Delete a partner and the corresponding orders should be unassigned: DELETE /orders/delete-partner-by-id/{partnerId}
Pass partnerId as path variable Return success message wrapped in a ResponseEntity object Controller Name - deletePartnerById

Delete an order and the corresponding partner should be unassigned: DELETE /orders/delete-order-by-id/{orderId} Pass
orderId as path variable Return success message wrapped in a ResponseEntity object Controller Name - deleteOrderById

Please make the following classes and make sure you name them exactly as following: OrderController.java OrderService.java
OrderRepository.java Order.java DeliveryPartner.java Class

Note:

Use ResponseEntity object to return the required objects in the controllers
Make sure you follow the requirements for the controller very very carefully or your application will give compilation
error while running against hidden test cases
Test all the APIs in postman before you submit.

 */
