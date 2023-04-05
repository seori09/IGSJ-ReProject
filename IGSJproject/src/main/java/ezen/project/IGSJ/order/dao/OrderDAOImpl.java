package ezen.project.IGSJ.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.order.domain.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

	@Autowired
	private SqlSession sqlSession;

	private static final String NAME_SPACE = "mappers.orderMapper";
	
	// 주문 페이지 불러오기
	@Override
	public OrderDTO orderPage(String userId) throws Exception {
		
		logger.info("주문 페이지 불러오기 orderPage - OrderDAO");
		return sqlSession.selectOne(NAME_SPACE + ".getOrderPage" , userId);
	}
	
	// 카트에 담긴 상품 정보 불러오기
	@Override
	public List<OrderDTO> productOrderPage(String userId) throws Exception {
		
		logger.info("카트에 담긴 상품 정보 불러오기 productOrderPage - OrderDAO");
		return sqlSession.selectList(NAME_SPACE + ".getProductOrderPage", userId);
	}

	//주문정보 등록하기(수령인정보)
	@Override
	public void writeRecipientInfo(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문정보 등록하기(수령인정보) writeRecipientInfo - OrderDAO");
		sqlSession.insert(NAME_SPACE + ".writeRecipientInfo", orderDTO);
	}
	
	
}
