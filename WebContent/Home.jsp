<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>   
<!DOCTYPE html>
<html lang="de-CH">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./Style.css">
<link href="https://fonts.googleapis.com/css?family=Pacifico|Rubik" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!--START META DATA PAGE DESCRIPTION-->
<meta name="Author" content="Calmar Solutions Schweiz - Erin McGowan - www.calmarsolutions.ch">
<meta name="Copyright" content="Calmar Solutions">
<meta name="Credit" content="https://thenounproject.com/">
<meta name="description" content="Margs Surfcamp Margaret River">
<meta name="keywords" content="Surfing, Camping, Margaret River, Western Australia">
<!--END META DATA PAGE DESCRIPTION-->
<title></title>
</head>
<body>
<div id="change_class" class="flex_container section menu_section">
	<div class="flex_item branding"><p></p></div>
	<div class="flex_item menu_item dropdown">
		<p>Menu</p>
		<div class="dropdown-content">
			<div class="menu_item menu_item_inside"><a href="#top"><p>Trang chủ</p></a></div>
			<a href=""><div class="menu_item menu_item_inside"><a href="#sale"><p>Khuyến mãi</p></a></div>
			<a href=""><div class="menu_item menu_item_inside"><a href="#product"><p>Sản phẩm</p></a></div>
				<div class="flex_item menu_item menu_item_outside"><a href="login.jsp"><p>Quản Lý</p></a></div></a>
		</div>
	</div>
	<div class="flex_item menu_item menu_item_outside"><a href="#top"><p>Trang chủ</p></a></div>
	<div class="flex_item menu_item menu_item_outside"><a href="#sale"><p>Khuyến mãi</p></a></div>
	<div class="flex_item menu_item menu_item_outside"><a href="#product"><p>Sản phẩm</p></a></div></a>
	<div class="flex_item menu_item menu_item_outside"><a href="login.jsp"><p>Quản Lý</p></a></div></a>
</div>

<div class="section page header_section">
		<div class="gradient gradient_red_blue gradient_header_section"></div>
			<div class="section_container header_section_container flex_container flex_header_container">
				<div class="text header_text">
					<h1>Iphone Giá Rẻ</h1>
				</div>
			 	<div class="text body_text flex_item flex_header_item">
			<h2 class="header_quote">Sản phẩm chất lượng, bán hàng uy tín, phục vụ tận tình, đó là phương châm kinh doanh của chúng tôi!</h2>
		</div>
			</div>
		</div>


<div class="section page second_section">
<a name="sale"></a>
<div class="section_container second_section_container flex_container flex_center">
		<div class="text header_text ">
			<h1>Khuyến Mãi</h1>
		</div>
		<c:forEach items="${listProduct }" var="h">
		<c:if test="${h.title == 'sale' }">
		<a href="#link1">
				<div class="feature flex_feature_item feature2">
					<img src="<c:out value="${h.img }" ></c:out>"class="feature_image" />
					<h2><c:out value="${h.name }"></c:out></h2>
				<center><h4 ><c:out value="${h.pricenew}"></c:out>  
					   <strike><c:out value="${h.priceold }"></c:out></strike></h4></center>
					</a>
			<p> <c:out value="${h.info }"></c:out></p>
				</div>
			</c:if>
		</c:forEach>

		</div>
		


<a name="product"></a>

	<div class="section_container third_section_container flex_container flex_center">
		<div class="text header_text">
			<h1>Sản Phẩm</h1>
		</div>
		
		<c:forEach items="${listProduct }" var="h">
		<c:if test="${h.title == 'new' }">
		<a href="#link2">
				<div class="feature flex_feature_item feature2">
					<img src="<c:out value="${h.img }" ></c:out>"class="feature_image" />
					<h2><c:out value="${h.name }"></c:out></h2>
				<center><h4><c:out value="${h.pricenew}"></c:out>
					<strike><c:out value="${h.priceold }"></c:out></strike></h4></center>
					</a>					
				<p> <c:out value="${h.info }"></c:out></p>
												
				</div>
			
			</c:if>
		</c:forEach>


		</div>
		
		


		<div class="section footer_section">
			<center><a href="https://www.facebook.com/hi.heIl">
			<p class="footer_text">Bùi Viết Nhật, @ Sinh viên Trường Đại Học Sư Phạm Đà Nẵng</p></a>
			<a href="https://www.facebook.com/nhat.arsenal.3"><p>@Ngành Công Nghệ Thông Tin</p></a></center>
		</div>

		

</body>
</html> 
