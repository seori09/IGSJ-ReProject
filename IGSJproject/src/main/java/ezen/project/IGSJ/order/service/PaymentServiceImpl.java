package ezen.project.IGSJ.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.order.dao.PaymentDAO;
import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;
import ezen.project.IGSJ.order.domain.PaymentDTO;

@Service
public class PaymentServiceImpl implements PaymentService{

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	//결제
	@Override
	public void pay(String userId, OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, PaymentDTO paymentDTO) throws Exception{
		
		logger.info("결제 pay - paymentService");
		
		paymentDAO.pay(userId, orderDTO, orderDetailDTO, paymentDTO);
	}
	
}
