<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载页面</title>
<style>
.download_form{
height:100%;
width:100%;
}
.download_file{
height:25%;
width:60%;
margin-left:20%;
border-bottom: 1px solid #4CAF50;
}
.file_img{
height:100%;
width:20%;
float:left;
/* border-right:2px dashed #e8e8e8; */
border-right-height:30px;
}
.file_download{
width:20%;
height:100%;
float:right;
}.file_download button{
margin:50px;
}
.file_discript{
height:100%;
width:60%;
float:left;
}.file_discript p {
margin:30px 60px;
}

</style>
</head>
<body>

<form action = "/week2/DownloadServlet.do" method = "get" class = "download_form">
	<c:forEach items="${downloads}" var="download" varStatus="message">
		<div class = "download_file">
			<div class = "file_img">
			<img src = ${download.image} style="width:60%;height:60%;margin:20%;cursor:pointer;"/>
			</div>
			<div class = "file_discript">
			<p>文件名：${download.name}</p>
			<p>描述：${download.description}</p>
			</div>
			<div class = "file_download">
			<button  type = "submit" class = "btn btn-default" name= "button"  value = ${download.id}>点我下载</button>
			</div>
		</div>
	</c:forEach>
</form>
</body>
<script>

</script>
</html>