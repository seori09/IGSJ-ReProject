package ezen.project.IGSJ.cart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.cart.dao.CartDAO;
import ezen.project.IGSJ.cart.domain.CartDTO;

@Service
public class CartServcieImpl implements CartService {

	private static final Logger logger = LoggerFactory.getLogger(CartServcieImpl.class);

	@Autowired
	private CartDAO cartDAO;

	// 장바구니 등록
	@Override
	public int cartWrite(List<CartDTO> cartDTO) throws Exception {
		return cartDAO.cartWrite(cartDTO);
	} // cartWrite()

	// 장바구니 중복 확인
	@Override
	public int cartSelect(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 중복확인 cartSelect - Service");

		return cartDAO.cartSelect(cartDTO);
	}

	// 장바구니 중복 수량 증가
	@Override
	public int cartUpdate(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 중복 수량 증가 cartUpdate - Service");

		return cartDAO.cartUpdate(cartDTO);
	}

	// 장바구니 목록
	@Override
	public List<CartDTO> cartList(String userId) throws Exception {

		logger.info("장바구니 목록 cartList - Service");

		List<CartDTO> cartList = cartDAO.cartList(userId);

		return cartList;
	}

	// 장바구니 삭제
	@Override
	public int cartDelete(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 삭제 cartDelete - Service");

		return cartDAO.cartDelete(cartDTO);
	}

	// 장바구니 수량 수정
	@Override
	public int modifyCart(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 수정 modifyCart - Service");

		return cartDAO.modifyCart(cartDTO);
	}
}
