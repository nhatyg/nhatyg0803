<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Đăng Nhập</title>
        <style>
            @font-face {
        font-family: 'Playbox';
        src: url('fonts/Playbox-FREE.otf');
    }
body{
	border-radius:10px;
    margin: 0;
    padding: 0;
    font-family: 'Orbitron', sans-serif;
    background: url(images/cuoi.jpg);
    background-repeat:no-repeat;
    background-size: cover;
    color: white;
}
form
{
	border-radius:10px;
    width: 300px;
    padding: 60px;
    position: absolute;
    top: 40%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: rgba(0, 0, 0, 0.8);
    text-align: center;
}
input{
      width: 150px;
      height: 30px;
      border-radius: 10px;
     
}
}
    </style>
</head>
<body>
	
    <form action="/MobileShop/login" method="POST">
        <h2>Đăng nhập để quản lý sản phẩm</h2>
        
       	 <input type="text" name="username" placeholder="Username">  
     <br><br> <input type="password" name="password" placeholder="Password"> 
    <br>
     <br>  <input type="submit" name="" value="Đăng Nhập">  
     <br>
          <h3><%= request.getAttribute("msg1")!=null ? request.getAttribute("msg1"): " " %></h3> 
    </form> 
</body>
</html>