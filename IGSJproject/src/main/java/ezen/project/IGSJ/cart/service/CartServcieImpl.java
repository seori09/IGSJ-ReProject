package ezen.project.IGSJ.cart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.cart.dao.CartDAO;
import ezen.project.IGSJ.cart.domain.CartDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;

@Service
public class CartServcieImpl implements CartService {

	private static final Logger logger = LoggerFactory.getLogger(CartServcieImpl.class);
	
	@Autowired
	private CartDAO cartDAO;
	
	//장바구니 등록
	@Override
	public int cartWrite(CartDTO cartDTO) throws Exception {
		
		logger.info("장바구니 등록 cartWrite - Service");
		
		return cartDAO.cartWrite(cartDTO);
		
	}
	//장바구니 목록
	@Override
	public List<CartDTO> cartList(String userId) throws Exception {
		
		logger.info("장바구니 목록 cartList - Service");
		
		List<CartDTO> cartList = cartDAO.cartList(userId);
		
		return cartList;
	}
	
	
	//장바구니 삭제
	@Override
	public int cartDelete(CartDTO cartDTO) throws Exception {
		
		logger.info("장바구니 삭제 cartDelete - Service");
		
		return cartDAO.cartDelete(cartDTO);
	}
	
}
