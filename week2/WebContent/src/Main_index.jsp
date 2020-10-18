<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title></title>
<style>
	.content_left{
    width:25%;
    height:100%;
    /* border:1px solid red;*/ 
    float:left;
    }
    .content_right{
    margin-top:1px;
    width:75%;
    height:96%;
    /* border:1px solid blue; */ 
    float:right; 
    } 
    .dropdown_main{
    padding-top:15%;
    padding-left:20%;
    width:50%;
    } 
    .btns{
    	font-size: 15px;
    	padding: 6px 12px;
    	border-radius: 5px;
    }
    .dropdown-toggle1
    {
        font-size: 20px;
	    padding: 10px 25px;
	    border-radius: 12px;
	    background-color:#f3f3f3; 
    }
    .dropdown-menu1{
    left:40%;
    }
    .dropdown-menu1>li>a {
        padding: 10px 20px;
    }
    .bootstrap3{
    width:95%;
    margin-right:5%; 
    }.panels{
    width:95%;
    margin-right:5%;
    margin-bottom:5px;
    height:120px;
    }/*style="margin-top:15px"*/
    .modal .control-label{
    padding-top:7px;
    }.modal-body .row{
    margin-bottom:15px;
    }.form-control{
    font-size:16px;
    }/* .modal-header{
      background-color:#33cc99;
      border-radius:5px 5px 0 0;
      }   */  
</style>
</head>
<body>
	<div class = "content_left">
		<div class = "dropdown_main dropdown">
			<button class="btn  dropdown-toggle dropdown-toggle1 btn-default" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    车位管理
		    <span>&nbsp&nbsp&nbsp</span>
		    <span class="glyphicon glyphicon-menu-down"></span>
		  	</button>
			  <ul class="dropdown-menu dropdown-menu1" aria-labelledby="dropdownMenu1">
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			  </ul>
		</div>
		<div class = "dropdown_main dropdown">
			<button class="btn  dropdown-toggle dropdown-toggle1 btn-default" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    收费管理
		    <span>&nbsp&nbsp&nbsp</span>
		    <span class="glyphicon glyphicon-menu-down"></span>
		  	</button>
			  <ul class="dropdown-menu dropdown-menu1" aria-labelledby="dropdownMenu2">
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			  </ul>
		</div>
		<div class = "dropdown_main dropdown">
			<button class="btn  dropdown-toggle dropdown-toggle1 btn-default" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    人员管理
		    <span>&nbsp&nbsp&nbsp</span>
		    <span class="glyphicon glyphicon-menu-down"></span>
		  	</button>
			  <ul class="dropdown-menu dropdown-menu1" aria-labelledby="dropdownMenu3">
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			  </ul>
		</div>
		<div class = "dropdown_main dropdown">
			<button class="btn  dropdown-toggle dropdown-toggle1 btn-default" type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    交互管理
		    <span>&nbsp&nbsp&nbsp</span>
		    <span class="glyphicon glyphicon-menu-down"></span>
		  	</button>
			  <ul class="dropdown-menu dropdown-menu1" aria-labelledby="dropdownMenu4">
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			  </ul>
		</div>		
		<div class = "dropdown_main dropdown">
			<button class="btn  dropdown-toggle dropdown-toggle1 btn-default" type="button" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    系统管理
		    <span>&nbsp&nbsp&nbsp</span>
		    <span class="glyphicon glyphicon-menu-down"></span>
		  	</button>
			  <ul class="dropdown-menu dropdown-menu1	" aria-labelledby="dropdownMenu5">
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Another action</a></li>
			  </ul>
		</div>						
	</div>	
	<div  class = "content_right">	
    	<div class="panel panel-default panels">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:5px">
                        <label class="control-label col-sm-2" for="txt_search_departmentname">车牌号：</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_CNO" placeholder="模糊搜索...">
                        </div>
                        <label class="control-label col-sm-2" for="txt_search_departmentname">车主姓名：</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_CarPerson" placeholder="模糊搜索...">
                        </div>                        
                        <div class="col-sm-2" style="text-align:left;">
                            <button type="button" style="margin-left:40px" id="btn_query" class="btn btn-success">查询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal_add">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-primary" >
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-danger">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
        <table id="tb_departments"></table>
	</div>
	
	 <!--新增模态框-->
	<div class="modal fade add_modle" tabindex="-1" role="dialog" id = "myModal_add">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">新增</h4>
	      </div>
	      <div class="modal-body">
 	         <div class="row">
              	<label for="AddModelCNO" class="col-sm-3 col-sm-offset-2 control-label">车牌号：</label>
              	<div class="col-sm-6" style="margin-left:-50px;">
              	<input type="text" class="form-control" id="AddModelCNO" placeholder="车牌号" name="AddModelCNO">
              	</div>	         
            </div>
            <div class="row">
              	<label for="AddModelCarNum" class="col-sm-3 col-sm-offset-2 control-label">车位号：</label>
              	<div class="col-sm-6" style="margin-left:-50px;">
              	<input type="text" class="form-control" id="AddModelCarNum" placeholder="车位号" name="AddModelCarNum">
              	</div>	         
            </div>
            <div class="row">
              	<label for="AddModelCarPerson" class="col-sm-3 col-sm-offset-2 control-label">车主姓名：</label>
              	<div class="col-sm-6" style="margin-left:-50px;">
              	<input type="text" class="form-control" id="AddModelCarPerson" placeholder="车主" name="AddModelCarPerson">
              	</div>	         
            </div>
            <div class="row">
              	<label for="AddModelCarType" class="col-sm-3 col-sm-offset-2 control-label">车位类型：</label>
              	<div class="col-sm-6" style = "margin-left:-50px;">
              	<!-- <input type="text" class="form-control" id="AddModelCarType" placeholder="车位类型" name="AddModelCarType"> -->
				    <select class="form-control" id = "AddModelCarType">
				        <option>临时车位</option>
				        <option>长期车位</option>
				    </select>  
				  </div>          				     		       
            </div>
            <div class="row">
              	<label for="AddModelCarDicretion" class="col-sm-3 col-sm-offset-2 control-label">车位方向：</label>
              	<div class="col-sm-6" style = "margin-left:-50px;">              
				    <select class="form-control" id = "AddModelCarDicretion">
				        <option>A区</option>
				        <option>B区</option>
				        <option>C区</option>
				    </select>  
              	</div>            				     		       
            </div>                                                  
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id = "addModelButton">确认</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!--修改模态框-->
	<div class="modal fade add_modle" tabindex="-1" role="dialog" id = "myModal_update">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">修改</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row">
              	<label for="UpdateModelCNO" class="col-sm-3 col-sm-offset-2 control-label">车牌号：</label>
              	<div class="col-sm-6" style="margin-left:-50px;">
              	<input type="text" class="form-control" id="UpdateModelCNO" placeholder="车牌号" name="UpdateModelCNO"  disabled>
              	</div>	         
            </div>
            <div class="row">
              	<label for="UpdateModelCarNum" class="col-sm-3 col-sm-offset-2 control-label">车位号：</label>
              	<div class="col-sm-6" style="margin-left:-50px;">
              	<input type="text" class="form-control" id="UpdateModelCarNum" placeholder="车位号" name="UpdateModelCarNum">
              	</div>	         
            </div>
            <div class="row">
              	<label for="UpdateModelCarPerson" class="col-sm-3 col-sm-offset-2 control-label">车主姓名：</label>
              	<div class="col-sm-6" style="margin-left:-50px;">
              	<input type="text" class="form-control" id="UpdateModelCarPerson" placeholder="车主" name="UpdateModelCarPerson">
              	</div>	         
            </div>
            <div class="row">
              	<label for="UpdateModelCarType" class="col-sm-3 col-sm-offset-2 control-label">车位类型：</label>
              	<div class="col-sm-6" style = "margin-left:-50px;">
              	<!-- <input type="text" class="form-control" id="AddModelCarType" placeholder="车位类型" name="AddModelCarType"> -->
				    <select class="form-control" id = "UpdateModelCarType">
				        <option>临时车位</option>
				        <option>长期车位</option>
				    </select>  
				  </div>          				     		       
            </div>
            <div class="row">
              	<label for="UpdateModelCarDicretion" class="col-sm-3 col-sm-offset-2 control-label">车位方向：</label>
              	<div class="col-sm-6" style = "margin-left:-50px;">              
				    <select class="form-control" id = "UpdateModelCarDicretion">
				        <option>A区</option>
				        <option>B区</option>
				        <option>C区</option>
				    </select>  
              	</div>            				     		       
            </div> 
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id = "UpdateModelButton">确认</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 删除模态框 -->
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id = "myModal_delete">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	     <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">删除确认</h4>
	      </div>
	      <div class="modal-body">
	        <p style = "margin:0 0 0 83px">是否确认删除?</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-success" data-dismiss="modal" id = "delete_ok">确认</button>
	      </div> 
	    </div>
	  </div>
	</div>
</body>
<script>
$(".dropdown-toggle").hover(function(){
    //console.log("$(this .glyphicon)", $(this .glyphicon))
	$(this).children(".glyphicon-menu-down").css({"color":"#4CAF50","font-weight":"900"});
}
,function(){$(this).children(".glyphicon-menu-down").css({"color":"","font-weight":""});
	});	
$(".dropdown-toggle").click(function(){
	$(".dropdown-toggle").css("border","");
	$(this).css("border","3px solid #4CAF50"); 
});	

$("#addModelButton").click(function(){
    $.ajax({
        type: "GET",
        url: "/week2/MainAddController.do", 
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
		//data:{ AlbumName: "shanghai", Entered: "5/9/2013" },
		data:{ CNO: $("#AddModelCNO").val(), CarNum: $("#AddModelCarNum").val(),
			CarPerson:$("#AddModelCarPerson").val(),CarType:$("#AddModelCarType").val(),
			CarDicretion:$("#AddModelCarDicretion").val()},
        dataType: "text",
        success: function (data) { 
        	if(data == "success")
        		{
	            	$("#myModal_add").modal('hide');
	            	$('#tb_departments').bootstrapTable('refresh'); 
	            	toastr.success('提交数据成功');
        		}
        	else if(data == "warning")
        		{
        			toastr.warning('请输入正确格式的数据！');
        		}
        	else if(data == "error0")
	    		{
	    			toastr.error('车牌号重复,请确认是否输出有误！');
	    		}
        	else if(data == "error1")
	    		{
	    			toastr.error('该车位已被其他车位使用！');
	    		}
        	else
	        	{
        			toastr.error('数据提交失败！');
	        	}
        },
        error: function (error) {
            alert("请求后台失败！");
        }
    });
}
);
$("#btn_delete").click(function(){
	var row=$("#tb_departments").bootstrapTable('getSelections');
	if(row.length == 0)
		{
			toastr.warning('请先选中要删除的行！');
		}
	else
		{
			$("#myModal_delete").modal("show");
		}
});
$("#delete_ok").click(function(){	
	var row=$("#tb_departments").bootstrapTable('getSelections');
	var json = JSON.stringify(row);//对象数组转成json格式传给后台		
		    $.ajax({
		        type: "GET",
		        url: "/week2/MainDeleteController.do", 
		        contentType: "application/x-www-form-urlencoded;charset=utf-8",
				data:{rows:json},
		        dataType: "text",
		        success: function (data) { 
		        	if(data == "success")
		        		{
		        			$('#tb_departments').bootstrapTable('refresh'); 
			            	toastr.success('数据删除成功！');
		        		}
		        	else
			        	{
		        			toastr.error('数据删除失败！');
			        	}
		        },
		        error: function (error) {
		            alert("请求后台失败！");
		        }
		    });		
});
$("#btn_edit").click(function(){
	var row=$("#tb_departments").bootstrapTable('getSelections');
	if(row.length == 0)
		{
			toastr.warning('请先选中要修改的行！');
		}
	else if(row.length > 1)
		{
			toastr.warning('请只选中一行进行修改！');			
		}
	else
		{
			$("#myModal_update").modal("show");
			//填数据
			$("#UpdateModelCNO").attr("value",row[0].CNO);
			$("#UpdateModelCarNum").attr("value",row[0].CarPlaceNum);
			$("#UpdateModelCarPerson").attr("value",row[0].CarPerson);
			$("#UpdateModelCarType option").each(function(){
				if($(this).text() == row[0].Type)
					{$(this).attr("selected",true);return false;}
			})
			$("#UpdateModelCarDicretion option").each(function(){
				if($(this).text() == row[0].Dicretion)
					{$(this).attr("selected",true);return false;}
			})
		}
});
$("#UpdateModelButton").click(function(){
	var row=$("#tb_departments").bootstrapTable('getSelections');
	if($("#UpdateModelCNO").val() == "" || $("#UpdateModelCarNum").val() == "" || $("#UpdateModelCarPerson").val() == "")
		{
		toastr.warning('请输入正确格式的数据！');	
		}
	else
		{
	    $.ajax({
	        type: "GET",
	        url: "/week2/MainUpdateController.do", 
	        contentType: "application/x-www-form-urlencoded;charset=utf-8",
			//data:{ AlbumName: "shanghai", Entered: "5/9/2013" },
			data:{ CNO: $("#UpdateModelCNO").val(), CarNum: $("#UpdateModelCarNum").val(),
				CarPerson:$("#UpdateModelCarPerson").val(),CarType:$("#UpdateModelCarType").val(),
				CarDicretion:$("#UpdateModelCarDicretion").val(),intime:row[0].InTime},
	        dataType: "text",
	        success: function (data) { 
	        	if(data == "success")
	        		{
		            	$("#myModal_update").modal('hide');
		            	$('#tb_departments').bootstrapTable('refresh'); 
		            	toastr.success('修改数据成功');
	        		}

	        	else if(data == "error1")
		    		{
		    			toastr.error('该车位已被其他车位使用！');
		    		}
	        	else
		        	{
	        			toastr.error('数据提交失败！');
		        	}
	        },
	        error: function (error) {
	            alert("请求后台失败！");
	        }
	    });
		}
});
</script>
<script> 

$(document).ready(function () {
	//初始化toastr
	toastr.options = {
			"positionClass":"toast-top-center",  //窗口显示位置
			"timeOut": "3000",
	};
	
  //调用函数，初始化表格
    initTable();
  
   //当点击查询按钮的时候执行,bootstrap-table前端分页是不能使用搜索功能，所以可以提取出来自定义搜索。后台代码，在后面给出
   // $("#queryBtn").bind("click", initTable);
});
$("#btn_query").click(function(){
	initTable();
	//console.log());
});
function initTable(){
	$('#tb_departments').bootstrapTable('destroy');
    $("#tb_departments").bootstrapTable({
        url: '/week2/MainViewController.do',    //请求后台的URL（*）
        method: 'GET',                      //请求方式（*）
		locale: 'zh-CN',
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色  
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式  asc升序 desc降序
        sortName :"CarPlaceNum",            //排序字段名
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize:7,                       //每页的记录行数（*） 
        pageList: [7,10,25,50,100],          //可供选择的每页的行数（*）
        //search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        queryParamsType : "limit",
        queryParams: function(params) {//上传服务器的参数
            var temp = {
            		offset: params.offset,//从数据库第几条记录开始  
                    limit: params.limit,//找多少条  
                    //搜索按钮的参数
                    CNO:$("#txt_search_CNO").val(),
                    CarPerson:$("#txt_search_CarPerson").val(),
                    //排序参数
                    sortName:this.sortName,
                    sortOrder:this.sortOrder
                };
                return temp;
            },  
        //showExport: true,                   //是否显示输出
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
       // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
        showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表       
        responseHandler: responseHandler, // 请求成功后,渲染表格
        columns : [{
            checkbox: true                //全选按钮
        }, {
            field: 'CNO',               
            title: '车牌号',
            align: 'center'
        }, {
            field: 'CarPlaceNum',
            title: '车位号',
            align: 'center'
        }, {
            field: 'CarPerson',
            title: '车主姓名',
            align: 'center'
        }, {
            field: 'Type',
            title: '车位类型',
            align: 'center'
        },{
            field: 'Dicretion',
            title: '车位方向',
            align: 'center'
        },{
            field: 'InTime',
            title: '入场时间',
            align: 'center'
        },]
    })
}


function responseHandler(result) {  
    var temp = {
        // 下面这两个参数是必须有的, 名称不能变
        // 总的数量
        total : result.total,
        // 数据
        rows : result.rows
    };
    return temp;
}
</script>
</html>