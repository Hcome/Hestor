<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+
request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>static/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>static/css/admin.css">
<script src="<%=basePath%>static/js/jquery.js"></script>
<script src="<%=basePath%>static/js/pintuer.js"></script>
<!-- 前端分页插件 -->
<script src="<%=basePath%>static/js/jqPaginator.js" type="text/javascript"></script>
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
    <thead>
      <tr>
        <th width="10%" style="text-align:left; padding-left:20px;">编号</th>
        <th width="20%">学号</th>
        <th width="20%">学生姓名</th>
        <th width="10%">分数</th>
        <th width="10%">是否通过</th>
        <th width="10%">班级</th>
        <th width="20%">操作</th>
      </tr>
      </thead>
      <tbody id="scores"></tbody>
      <tr>
        <td colspan="8">
        <ul class="pagination" id="pagination1"></ul>
        </td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">
var total = 0;//总条数
var totalPages = 0;//总页数
var visiblePages = 3;//显示的页码数
var currentPage = 0;//当前页码
$(document).ready(function(){
	showPage(-1);
	// 分页
	$('#pagination1').jqPaginator({
	    totalPages: totalPages,
	    visiblePages: visiblePages,
	    currentPage: currentPage,
	 
	    first: '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
	    prev: '<li class="prev"><a href="javascript:void(0);">前一页</a></li>',
	    next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
	    last: '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
	    page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
	    onPageChange: function (num) {
	    	showPage(num);
	    }
	});
});

//分页
function showPage(n) {
	$.ajax({
		type : "POST",
		async:false,
		data : {
			//当前页是第几页
			currentPage:n
		},
		dataType : "text",
		url : "<%=basePath%>student/queryStudentScoreAll",
		success : function(result) {
			console.log(result);
			//将返回对象转化成json对象
			var tl = eval("(" + result + ")");
			if(n==-1){
				total = tl.total;
				totalPages = tl.pages;
				currentPage = tl.pageNum;
			}
			$("#scores").html("");
			if(tl.list.length>0){
				$.each(tl.list, function(n,val){
					console.log(n);
					var str = "";
					str+="<tr>";
					str+="<td>"+n+"</td>"
					str+="<td>"+val.studentNum+"</td>"
					str+="<td>"+val.studentName+"</td>"
					str+="<td>"+val.score.scoreNunber+"</td>"
					str+="<td>"+val.score.isPass+"</td>"
					str+="<td>"+val.fkClassName+"</td>"
				    str+="<td><div class='button-group'><a class='button border-main' href='<%=basePath%>score/selectScoreById?id=" + val.score.scoreId + "'><span class='icon-edit'></span>修改</a><a class='button border-red' href='javascript:void(0)' onclick='del(" + val.studentId + ")'><span class='icon-trash-o'></span>删除</a></div></td>"
				    str+="</tr>";
					$("#scores").append(str);
				})
			}else{
				$("#scores").append("<tr><td colspan=8 align=\"center\">暂时没有数据哦，快去添加一条吧</td></tr>");
			}
		},
		error : function() {
			layer.msg('无法连接服务器', {icon: 2});
		}
	});
}


//搜索
function changesearch(){	
		
}

//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		$.ajax({
			type : "POST",
			async:false,
			data : {
				studentId:id
			},
			dataType : "text",
			url : "<%=basePath%>/student/deleteByPrimaryKey",
			success : function(data) {
				var result = eval("(" + data + ")");
    			if (result.status == 200) {
					console.log(result);
					location.replace(location.href);
				} else {
					alert(result.message);
				}
			},
			error : function() {
				alert("无法连接服务器");
			}
		});
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}


</script>
</body>
</html>