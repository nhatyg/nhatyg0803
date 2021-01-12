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
    width:80%;
}
table,th,td{
    border:1px solid gray;
    border-collapse: collapse;
}
th,td{
    padding:7px 15px;
}
th{
    background-color: #ddd;
    color: black;
}
 
tr:hover{
    background-color: #ecece9;
}
    tr:nth-child(odd){
        background-color: #ecece9;
    }
      td{
          text-align: center;
      }
     
</style>
   <title>ABC | XYZ</title>
        <meta charshet="utf-8" />
</head>
<body>
	<center>
		<h1>Danh sách sản phẩm</h1>
		<h2>
			<a href="/MobileShop/new.jsp">Thêm sản Phẩm</a> &nbsp; &nbsp; &nbsp; 
			<a href="/MobileShop/list2">Xem tất cả sản phẩm</a>
		</h2>
	</center>
	<div align="center">
		<table border = "1" cellpadding="5">
            <caption><h2>Tất cả sản phẩm &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href ="/MobileShop/list">Trang Chủ</a></h2></caption>
            
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Img</th>
                <th>Pricenew</th>
                <th>Priceold</th>
                <th>Name</th>
                <th>Info</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${listProduct}" var="product">
				<tr>
					<td><c:out value="${product.id}"></c:out></td>
					<td><c:out value="${product.title}"></c:out></td>
					<td><c:out value="${product.img}"></c:out></td>
					<td><c:out value="${product.pricenew}"></c:out></td>
					<td><c:out value="${product.priceold}"></c:out></td>
					<td><c:out value="${product.name}"></c:out></td>
					<td><c:out value="${product.info}"></c:out></td>
					<td>
					<a href="/MobileShop/edit?id=<c:out value="${product.id}"/>">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/MobileShop/delete?id=<c:out value="${product.id}"/>">Delete</a> 
                     </td>
				</tr>
			</c:forEach>
                
           
        </table>
	</div>
</body>
</html>