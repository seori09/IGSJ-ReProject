package ezen.project.IGSJ.order.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.order.dao.OrderDAO;
import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;
import ezen.project.IGSJ.order.domain.PaymentDTO;

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

	// 카트에 담긴 상품 정보 불러오기
	@Override
	public List<OrderDTO> productOrderPage(String userId) throws Exception {

		logger.info("카트에 담긴 상품 정보 불러오기 productOrderPage - OrderService");
		return orderDAO.productOrderPage(userId);
	}

	// 주문정보 등록하기(수령인정보)
	@Override
	public boolean pay(OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, PaymentDTO paymentDTO) throws Exception {
		logger.info("주문정보 등록하기(수령인정보) writeRecipientInfo - OrderService");
		
		List<OrderDTO> orders = orderDAO.productOrderPage(orderDTO.getUserId());
		
		List<OrderDetailDTO> orderDetails = new ArrayList<>();
		
		orders.forEach(o -> orderDetails.add(
				new OrderDetailDTO(
						orderDetailDTO.getOrderDetailNum(), 
						orderDTO.getOrderNum(), 
						o.getPno(),
						o.getProductCnt(), 
						o.getProduct_price(), 
						orderDetailDTO.getPaymentStatus())));
		
		logger.info("dfdkjsafldskfjadsiofjewiojfads" + orderDetails);
		
		return orderDAO.pay(orderDTO, orderDetails, paymentDTO);
	}

	// 주문내역조회페이지 불러오기
	@Override
	public List<OrderDTO> orderListPage(String userId) throws Exception {

		logger.info("주문내역조회페이지 불러오기 orderListPage - OrderService");
		return orderDAO.orderListPage(userId);
	}
	
	// 주문상세내역조회페이지(selelctOne) 불러오기
	@Override
	  public OrderDTO orderDetailOne(String orderNum) throws Exception {

	    logger.info("주문상세내역조회페이지(selectOne) 불러오기 orderDetailOne - OrderService");

	  return orderDAO.orderDetailOne(orderNum);
	  }
	

	// 주문상세내역조회페이지 불러오기
	@Override
	public List<OrderDTO> orderDetailPage(String orderNum) throws Exception {

		logger.info("주문상세내역조회페이지 불러오기 orderDetailPage - OrderService");
		return orderDAO.orderDetailPage(orderNum);
	}

	// 결제완료페이지 불러오기
	@Override
	public OrderDTO orderFinishPage(String orderNum) throws Exception {

		logger.info("결제완료페이지 불러오기 orderFinishPage - OrderService");
		return orderDAO.orderFinishPage(orderNum);

	}
	// 결제 완료 후 장바구니 전체 삭제

	@Override
	public int cartAllDelete(OrderDTO orderDTO) throws Exception {
		return orderDAO.cartAllDelete(orderDTO);
	}

}
