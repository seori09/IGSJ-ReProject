package ezen.project.IGSJ.order.service;

import java.util.List;

import ezen.project.IGSJ.order.domain.OrderDTO;

public interface OrderService {
	
	// 주문 페이지 불러오기
	public OrderDTO orderPage(String userId) throws Exception;
	
	// 카트에 담긴 상품 정보 불러오기
	public List<OrderDTO> productOrderPage(String userId) throws Exception;
	
	//주문정보 등록하기(수령인정보)
	public void writeRecipientInfo(OrderDTO orderDTO) throws Exception;
}
