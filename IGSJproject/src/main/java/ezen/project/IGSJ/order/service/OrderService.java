package ezen.project.IGSJ.order.service;

import java.util.List;

import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;
import ezen.project.IGSJ.order.domain.PaymentDTO;

public interface OrderService {

	// 주문 페이지 불러오기
	public OrderDTO orderPage(String userId) throws Exception;

	// 카트에 담긴 상품 정보 불러오기
	public List<OrderDTO> productOrderPage(String userId) throws Exception;

	// 결제하기
	public boolean pay(OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, PaymentDTO paymentDTO) throws Exception;

	// 주문내역조회페이지 불러오기
	public List<OrderDTO> orderListPage(String userId) throws Exception;
	
	// 주문상세내역조회페이지(selelctOne) 불러오기
	public OrderDTO orderDetailOne(String orderNum) throws Exception;

	// 주문상세내역조회페이지 불러오기
	public List<OrderDTO> orderDetailPage(String orderNum) throws Exception;

	// 결제완료페이지 불러오기
	public OrderDTO orderFinishPage(String orderNum) throws Exception;
	
	// 결제 완료 후 장바구니 전체 삭제
	public int cartAllDelete (OrderDTO orderDTO)throws Exception;

}
