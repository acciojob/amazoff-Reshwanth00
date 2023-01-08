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
Error:    TestCases.testAddOrder:                           30 » NullPointer
Error:    TestCases.testAddOrderPartnerPair:                58 » NullPointer
Error:    TestCases.testAddPartner:                         39 » NullPointer
Error:    TestCases.testDeletePartnerById:                  644 » NullPointer
Error:    TestCases.testGetAllOrders:                       324 » NullPointer
Error:    TestCases.testGetCountOfOrdersLeftAfterGivenTime: 536 » NullPointer
Error:    TestCases.testGetCountOfUnassignedOrders:         394 » NullPointer
Error:    TestCases.testGetLastDeliveryTime:                598 » NullPointer
Error:    TestCases.testGetOrderById:                       93 » NullPointer
Error:    TestCases.testGetOrderCountByPartnerId:           198 » NullPointer
Error:    TestCases.testGetOrdersByPartnerId:               244 » NullPointer
Error:    TestCases.testGetPartnerById:                     147 » NullPointer
Error:    TestCases.testOrderController:                    689 » NullPointer
 */
