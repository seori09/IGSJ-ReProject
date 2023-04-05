package ezen.project.IGSJ.order.service;

import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;
import ezen.project.IGSJ.order.domain.PaymentDTO;

public interface PaymentService {

	//결제
	public void pay(String userId, OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, PaymentDTO paymentDTO) throws Exception;
	
}
