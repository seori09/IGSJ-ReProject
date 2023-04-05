package ezen.project.IGSJ.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;
import ezen.project.IGSJ.order.domain.PaymentDTO;
import ezen.project.IGSJ.order.service.PaymentService;

@Controller("paymentController")
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/payment")
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired(required = false)
	private PaymentService paymentService;
	
	// 결제하기 - 수령인정보, 주문품목정보, 개인결제정보
//	@ResponseBody
//	@RequestMapping(value="/pay/{userId}", method=RequestMethod.POST)
//	public String pay(@PathVariable("userId") String userId, OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, PaymentDTO paymentDTO) throws Exception{
//		
//		logger.info("결제 pay - paymentController");
//		
//		
//		
//		paymentService.pay(userId, orderDTO, orderDetailDTO, paymentDTO);
//		
//	}
	
}
