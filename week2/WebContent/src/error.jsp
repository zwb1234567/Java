<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>错误页面</title>
<style type="text/css">
div{
	height:100px;
	width : 750px;
 	margin: 100px auto;
    text-align: center;
}
.span1{
	color:red;
}
#Time{
	color:#4CAF50;
}
span{
   font-size:25px;
}
a{
text-decoration:none;
color:#4CAF50;
}
</style>
</head>
<body>
<div>
	<span class = "span1">${errorInfo}</span>
	<span id="Time">5</span>
	<span>秒后将跳转至主页！<a href = "login.html">点我返回!</a></span>
	<hr>
</div>
</body>

<script>
	function countDown() {
		//获取初始时间
		var time = document.getElementById("Time");

		//获取到id为time标签中的数字时间
		if (time.innerHTML == 0) {
			//等于0时清除计时，并跳转该指定页面
			window.location.href = "login.html";
		} else {
			time.innerHTML = time.innerHTML - 1;
		}
	}
	//1000毫秒调用一次
	window.setInterval("countDown()", 1000);
</script>

</html>