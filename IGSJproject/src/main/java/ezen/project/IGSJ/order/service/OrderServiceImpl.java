package ezen.project.IGSJ.order.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.order.service.OrderServiceImpl;
import ezen.project.IGSJ.order.dao.OrderDAO;
import ezen.project.IGSJ.order.domain.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDAO;
	
	// 주문 페이지 불러오기
	@Override
	public OrderDTO orderPage(String userId) throws Exception {
		
		logger.info("주문 페이지 불러오기 orderPage - OrderService");
		return orderDAO.orderPage(userId);
	}
	
	//카트에 담긴 상품 정보 불러오기
	@Override
	public List<OrderDTO> productOrderPage(String userId) throws Exception {
		
		logger.info("카트에 담긴 상품 정보 불러오기 productOrderPage - OrderService");
		return orderDAO.productOrderPage(userId);
	}

	//주문정보 등록하기(수령인정보)
	@Override
	public void writeRecipientInfo(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문정보 등록하기(수령인정보) writeRecipientInfo - OrderService");
		orderDAO.writeRecipientInfo(orderDTO);
	}
	
	
}
