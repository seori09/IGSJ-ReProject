package ezen.project.IGSJ.order.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;
import ezen.project.IGSJ.order.domain.PaymentDTO;

@Repository
public class PaymentDAOImpl implements PaymentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "mappers.orderMapper";
	private static final String NAME_SPACE2 = "mappers.paymentMapper";
	
	
	// 결제
	@Override
	public void pay(String userId, OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, PaymentDTO paymentDTO) throws Exception{
		
		logger.info("결제 pay - paymentDAO");
		
		sqlSession.insert(NAME_SPACE + ".writeRecipientInfo", orderDTO);		//수령인정보
		sqlSession.insert(NAME_SPACE + ".writeProductInfo", orderDetailDTO);	//주문제품정보
		sqlSession.insert(NAME_SPACE2 + ".writePaymentInfo", paymentDTO);		//개인결제정보
	}
}
