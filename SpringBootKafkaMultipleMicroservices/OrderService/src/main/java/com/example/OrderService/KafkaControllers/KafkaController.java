package com.example.OrderService.KafkaControllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BaseModels.Dto.Order;
import com.example.BaseModels.Dto.OrderEvent;
import com.example.OrderService.KafkaProducer.KafkaProducer;

@RestController
@RequestMapping("/api/v1")
public class KafkaController {
	
	 private KafkaProducer kafkaProducer;

	    public KafkaController(KafkaProducer kafkaProducer) {
	        this.kafkaProducer = kafkaProducer;
	    }

	    @PostMapping("/orders")
	    public String placeOrder(@RequestBody Order order){

	    	order.setOrderId(UUID.randomUUID().toString());

	        OrderEvent orderEvent = new OrderEvent();
	        orderEvent.setStatus("PENDING");
	        orderEvent.setMessage("order status is in pending state");
	        orderEvent.setOrder(order);

	        kafkaProducer.sendMessage(orderEvent);

	        return "Order placed successfully ...";
	    }


}
