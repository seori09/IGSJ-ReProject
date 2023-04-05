package ezen.project.IGSJ.order.controller;

import java.util.List;

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
import ezen.project.IGSJ.order.service.OrderService;

@Controller("orderController")
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired(required = false)
	private OrderService orderService;

	// 주문 페이지 불러오기
	@ResponseBody
	@RequestMapping(value="/orderPage/{userId}", method=RequestMethod.GET)
	public OrderDTO orderPage(@PathVariable("userId") String userId) throws Exception{
		
		logger.info("주문 페이지 불러오기 orderPage - Controller");
		OrderDTO orderDTO = orderService.orderPage(userId);
		
		return orderDTO;
	}

	// 카트에 담긴 상품 정보 불러오기
	@ResponseBody
	@RequestMapping(value="/productOrderPage/{userId}", method=RequestMethod.GET)
	public List<OrderDTO> productOrderPage(@PathVariable("userId") String userId) throws Exception {
		
		logger.info("카트에 담긴 상품 정보 불러오기 productOrderPage - Controller");
		return orderService.productOrderPage(userId);
		
	}
	
}
