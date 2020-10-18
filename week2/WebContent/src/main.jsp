<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    <link rel="stylesheet" type ="text/css" href="bootstrap/css/bootstrap.css" >  
	<link rel="stylesheet" type ="text/css" href="bootstrap/css/bootstrap-table.css" >
	<link rel="stylesheet" type ="text/css" href="bootstrap/css/toastr.min.css" >
    <script src="bootstrap/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap-table.js"></script>
    <script src="bootstrap/js/toastr.min.js"></script>    
    <script src="bootstrap/js/bootstrap-table-zh-CN.js"></script>      
    <!-- <script src="src/bootstrap/holder.min.js"></script>   -->
     
    
<title>系统主页</title>
	<style>
    *{
        margin:0;
        padding:0;
        list-style:none;
    }
/*         body{
            width: 100%;
   			height: 100%;
            background-image: url(src/img/login0.jpg);
            opacity: 1; 
		    background-repeat: no-repeat;
		    background-attachment: fixed;
		    background-size: 100% 100%;
        }  */      
	.nav {	
        width:86%;
        margin-left: 7%;
	    list-style-type: none;	    
	    padding: 0;
	    overflow: hidden;
	    background-color: #f3f3f3;
	    border: 1px solid #e7e7e7;
	}	
	.nav li {
	    float: left; 
        
	}	
	.nav li a {
        cursor:pointer;
	    display: block;
	    color: #666;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none; 
	}
	.nav li a:hover{
		background-color: #ddd;
	}
	.active {
    	color:white !important; 
    	background-color: #4CAF50 !important;
	}
    #about{
        float:right;
    }
    .header{
        width:86%;
        margin-left:7%;
        height:60px;
    }
    .header .span2{
        float:right;
        line-height:60px;
    }
    .header .span2 a{
    	 padding-left: 15px;
    	 color: #4CAF50;
    	 text-decoration: none; 
    }
    .content{
    width:86%; 
    height:580px;
    margin-left:7%;
    margin-top:20px;
    border:2px solid #e8e8e8;
    border-radius: 10px;
    }
    .span1{
    	line-height:60px;
    	font-size:26px;
    	font-family:"微软雅黑";
    	font-weight:500;
    	font-style:italic;
    }
	</style>
</head>
<body onload = "load()">
 <%-- <p>${success.userName}<p> --%>
 <div class = "header">
 	<span class = "span1">欣欣停车场管理系统</span>
    <span class = "span2" >欢迎您：${success.chrName}<a href = "" id = "return">[安全退出]</a></span>
 </div>
<ul id="nav" class="nav"> 
  <li><a class ="active" id = "main"  onclick = "load()">主页</a></li>
  <li><a id = "download" href="">下载</a></li>  
  <li><a href="">待定</a></li>
  <li><a href="">待定</a></li>
  <li><a href="">待定</a></li>
  <li><a href="">待定</a></li>
  <li><a href="">待定</a></li>
  <li><a href="">待定</a></li> 
  <li id ="about"><a href="">关于</a></li>
</ul>

<div class = "content">

</div>
<script>
	var li = $("#nav").children();
    //console.log("li", li); 
    //console.log(typeof(li)) ;
	li.click(function (e) {
		e.preventDefault();
		//alert("xx");      
        //console.log("$(this)", $(this));
        li.children().attr("class","");
        $(this).children().attr("class","active");       	  
    });
	

	$("#download").click(function(e){		
        $.ajax({
            type: "GET",
            url: "/week2/DownloadController.do",
            //contentType: "application/json; charset=utf-8",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
    		//data:{'按钮':$(this).attr("value")}, 
            dataType: "html",
            success: function (data) { 
            	$(".content").html(data);
            },
            error: function (error) {
                alert("error=" + error);
            }
        });
	});	
	
		
	function load(){		
        $.ajax({
            type: "GET",
            url: "/week2/MainController.do",
            //contentType: "application/json; charset=utf-8",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
    		//data:{'按钮':$(this).attr("value")}, 
            dataType: "html",
            success: function (data) { 
            	$(".content").html(data);
                //alert("data.d=" + data.d);
            },
            error: function (error) {
                alert("error=" + error);
            }
        });
	}  
</script>
<script>
 $("#return").click(function(e){
	e.preventDefault();   
	        $.ajax({
            type: "GET",
            url: "/week2/LoginController.do",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            dataType: "text",
            success: function (data) { 
            },
            error: function (error) {
                alert("error=" + error);
            }
        });
	 var d = new Date();
	 var saveTime = -1;// cookie保存时间（单位：天）
	 d.setDate(d.getDate() + saveTime);
	 document.cookie = "userInfo = 0;path = /week2/src;expires=" + d.toGMTString();   
	window.location.href = "login.html";   
 });
</script>
</body>
</html>