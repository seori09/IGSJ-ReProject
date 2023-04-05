package ezen.project.IGSJ.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);

	private static final String NAME_SPACE = "mappers.adminMapper";

	@Autowired
	private SqlSession sqlSession;

	// ***************************************회원***************************************
	// 전체 회원 불러오기
	@Override
	public List<MemberDTO> getAllUsers(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception {

		logger.info("관리자 페이지 전체회원 불러오기 DAO");

		HashMap<String, Object> memberPageData = new HashMap<>();
		memberPageData.put("displayTotalContent", displayTotalContent);
		memberPageData.put("pageContent", pageContent);
		memberPageData.put("searchType", searchType);
		memberPageData.put("keyword", keyword);

		return sqlSession.selectList(NAME_SPACE + ".getAllUsers", memberPageData);
	}

	// 검색 결과에 따른 회원 출력
	@Override
	public int searchMember(String searchType, String keyword) throws Exception {

		logger.info("관리자 페이지 검색 결과에 따른 회원수 출력");

		HashMap<String, String> searchData = new HashMap<>();

		searchData.put("searchType", searchType);
		searchData.put("keyword", keyword);

		return sqlSession.selectOne(NAME_SPACE + ".searchMember", searchData);
	}

	// 관리자 회원 정보 수정
	@Override
	public void adminMemberModify(MemberDTO memberDTO, MemberAddressDTO memberAddressDTO) throws Exception {

		logger.info("관리자 회원 정보 수정 DAO");

		sqlSession.update(NAME_SPACE + ".adminMemberModify", memberDTO);
		sqlSession.update(NAME_SPACE + ".adminAddressModify", memberAddressDTO);
	}

	// 관리자 회원 선택에 따른 정보 가져오기
	@Override
	public MemberDTO adminSelectMember(String userId) throws Exception {

		logger.info("관리자 회원 상세정보 조회 DAO, 조회된 회원 : {}", userId);

		return sqlSession.selectOne(NAME_SPACE + ".adminSelectMember", userId);
	}

	@Override
	public MemberAddressDTO adminSelectAddress(String userId) throws Exception {

		return sqlSession.selectOne(NAME_SPACE + ".adminSelectAddress", userId);
	}

	// 관리자 회원 삭제
	@Override
	public void adminRemoveMember(String userId) throws Exception {

		logger.info("관리자 회원 삭제 DAO");

		sqlSession.delete(NAME_SPACE + ".adminRemoveMember", userId);
	}

	// ***************************************상품***************************************
	// 전체 상품 목록 불러오기
	@Override
	public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception {

		logger.info("관리자 페이지 전체상품 불러오기 DAO");

		HashMap<String, Object> productPageData = new HashMap<>();
		productPageData.put("displayTotalContent", displayTotalContent);
		productPageData.put("pageContent", pageContent);
		productPageData.put("searchType", searchType);
		productPageData.put("keyword", keyword);

		return sqlSession.selectList(NAME_SPACE + ".getProductList", productPageData);
	}

	// 검색 결과에 따른 상품 목록 불러오기
	@Override
	public int searchProduct(String searchType, String keyword) throws Exception {

		logger.info("관리자 페이지 검색결과에 따른 상품 출력");

		HashMap<String, String> searchData = new HashMap<>();

		searchData.put("searchType", searchType);
		searchData.put("keyword", keyword);

		return sqlSession.selectOne(NAME_SPACE + ".searchProduct", searchData);
	}
	
	// 관리자 상품 조회
	@Override
	public ProductDTO adminProductViewPage(String pno) throws Exception {
		
		logger.info("관리자 상품 정보 조회 : {}", pno);
		
		return sqlSession.selectOne(NAME_SPACE + ".adminProductViewPage", pno);
	}
	
	// 관리자 상품 수정
	@Override
	public void adminProductModify(ProductDTO productDTO, ProductFileDTO productFileDTO) throws Exception {
		
		logger.info("관리자 상품 수정 DAO");
		
		sqlSession.update(NAME_SPACE + ".adminProductModify", productDTO);
		sqlSession.update(NAME_SPACE + ".adminProductFileModify", productFileDTO);
	}
	
	// ***************************************그 외***************************************
	// 관리자, 판매자 로그인
	@Override
	public MemberDTO managerLogin(MemberDTO memberDTO) throws Exception {
		
		logger.info("매니저 로그인 DAO");
		
		return sqlSession.selectOne(NAME_SPACE + ".managerLogin", memberDTO);
	}
}
