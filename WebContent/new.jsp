<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
    width:60%;
}
table,th,td{
    border:1px solid gray;
    border-collapse: collapse;
}
th,td{
    padding:7px 7px;
}
input {
	height: 40px;
}
 
</style>
   <title>ABC | XYZ</title>
        <meta charshet="utf-8" />
</head>


<body>
	<center>
		<h1>Thêm hoặc sửa sản phẩm</h1>
		<h2>
			<a href="/MobileShop/list2">Xem tất cả sản phẩm</a>
		</h2>
	</center>

	<div align="center">
		<c:if test="${product != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${product == null}">
			<form action="insert" method="post">
		</c:if>

		<table>
			<caption>
				<c:if test="${product != null}"> <%--lay tu controller --%>
					<h2>sửa sản phẩm</h2>
				</c:if>
				<c:if test="${product == null}">
				<h2>Thêm sản phẩm</h2>
				</c:if>
			</caption>
			<c:if test="${product != null}">
				<input type="hidden" name="id" value="<c:out value="${product.id}"/>" />
			</c:if>
			<tr>
				<th>Title:</th>
				<td><input type="text" name="title" size="60"    value="<c:out value="${product.title}"/>"/></td>
			</tr>
			
		
			<tr>
				<th>Img:</th>
				<td><input type="text" name="img" size="60"    value="<c:out value="${product.img}"/>"/></td>
			</tr>
			<tr>
				<th>pricenew:</th>
				<td><input type="text" name="pricenew" size="60"   
				value="<c:out value="${product.pricenew}"/>"/></td>
			</tr>
			<tr>
				<th>priceold:</th>
				<td><input type="text" name="priceold" size="60"   
				value="<c:out value="${product.priceold}"/>"/></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="name" size="60"  
				value="<c:out value="${product.name}"/>"/></td>
			</tr>
			<tr>
				<th>Info:</th>
				<td><input type="text" name="info" size="60"  
				value="<c:out value="${product.info}"/>"/></td>
			</tr>
				</table>
				
			<tr>
				<td  colspan="5" align="center"><input
				 style="height:40px;width:200px " type="submit"
					value="Save" /></td>
			</tr>
	
		</form>
	</div>
</body>
</html>