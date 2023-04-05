<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>

<style>
.listWrap {
	width: 90%;
	margin: 0 auto;
}

.ck-editor__editable {
	min-height: 600px;
}
</style>
</head>
<body>
	<!-- 사이드 바 -->
	<div class="container">
		<h2 class="adminTitle">상품등록</h2>
		<form role="form" class="listWrap" method="post" autocomplete="off" enctype="multipart/form-data">
			<label>1차 분류</label>
			<select class="category1">
				<option value="">전체</option>
			</select>
			<br>
			<label>2차 분류</label>
			<select class="category2" name="cno">
				<option value="">전체</option>
			</select>

			<div class="inputArea">
				<label for="productName">상품명</label>
				<input type="text" id="product_name" name="product_name" />
			</div>

			<div class="inputArea">
				<label for="productPrice">상품가격</label>
				<input type="text" id="product_price" name="product_price" />
			</div>

			<div class="inputArea">
				<label for="product_description">상품소개</label>
				<textarea id="product_description" name="product_description"></textarea>
			</div>


			<div class="inputArea">
				<label for="productStock">상품수량</label>
				<input type="text" id="product_stock" name="product_stock" />
			</div>

			<div class="inputArea">
				<label for="gdsImg">이미지</label>
				<input type="file" id="product_img" name="product_img" />
				<div class="select_img">
					<img src="" />
				</div>
			</div>
			
			<div class="inputArea">
				<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
			</div>

		</form>
	</div>
<script src="/resources/Outer/seller/js/register.js"></script>
</body>
</html>