<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>企业资产管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="<%=basePath%>static/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=basePath%>static/css/font.css">
<link rel="stylesheet" href="<%=basePath%>static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>static/js/xadmin.js"></script>
</head>
<body>
   <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">库存管理</a>
        <a>
          <cite>资产流动记录</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" method="post" action="porchaseController/showPorchaseByUserName.do">
				<span>选择需要查看的商场：</span> <input class="layui-input" placeholder="请输入名称"
					name="propertyName" list="list"> 
					<datalist id="list">
						<option>台州万达</option>
						<option>苍山万达</option>
					</datalist>
				<button type="submit" class="layui-btn" lay-submit="sreach()" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
	  </div>
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加用户','manageEmeController/toUserAdd.do')"><i class="layui-icon">流动记录</button>
        <span class="x-right" style="line-height:40px">共有数据：<a id="total">88</a> 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th style="width: 10%">序号</th>
            <th style="width: 10%">商场名称</th>
            <th style="width: 11%">剩余可用资产</th>
            <th style="width: 20%">支出详情</th>
            <th style="width: 10%">操作员</th>
            <th style="width: 20%">操作日期</th>
            <th style="width: 20%">操作</th>
            </tr>
        </thead>
        <tbody id="users">
          <tr>
          
            <td colspan=10> 加载中<i class="layui-icon" >&#xe63e;</i></td>
          </tr>
        </tbody>
      </table>
      <div id="test1" style="text-align:center"></div>

    </div>

	</body>
<script type="text/javascript">

var userDepart=null;
var EntryStart=null;
var EntryEnd=null;
var birthRange=null;
var userName=null;
var total=0;
//删除操作
function delUser(userId){
	layer.msg('确定删除吗？', {
		  time: 0 //不自动关闭
		  ,btn: ['确定删除','取消返回']
		  ,yes: function(index){
			  $.ajax({
					type : "POST",
					async:false,
					data : {
						userId:userId
					},
					dataType : "text",
					url : "manageEmeController/userDel.ajax",
					success : function(result) {
						console.log(result);
						layer.msg("删除成功",{
		              		icon : 1,
		               		time: 500,
		               	},function () {
		               		location.replace(location.href)
		                    
		                 });
						
					},
					error : function() {
						
						layer.msg('无法连接服务器', {icon: 2});
					}
				});
		  }
		});
}
layui.use(['form', 'laypage', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
 ,laypage = layui.laypage
  ,laydate = layui.laydate;
  
  //日期
 var start=null;
 var end=null;
 laydate.render({
  elem: '#entry'
  ,range:true
  ,done: function(value, startDate, endDate){
    console.log(value); //得到日期生成的值，如：2017-08-18
    start=startDate.year+"-"+startDate.month+"-"+startDate.date;
    end=endDate.year+"-"+endDate.month+"-"+endDate.date;
    console.log(start) //得到间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
    console.log(end); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
  }
});

 
/* //自定义验证规则
form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,content: function(value){
      layedit.sync(editIndex);
    }
}); */
/* //
  form.on('submit(sreach)', function(data){
      console.log("-----"+data);
      userDepart=$("#userDepart").val();
      birthRange=$("#birthRange").val();
       userName=$("#userName").val();
    	EntryStart=start;
    	EntryEnd=end;
       showPage(-1);
       laypage.render({
    		  elem: 'test1'
    		  ,count: total //数据总数，从服务端得到
    		  ,limit:3
    		  ,jump: function(obj, first){
    		    //obj包含了当前分页的所有参数，比如：
    		    console.log("当前页："+obj.currentPage); //得到当前页，以便向服务端请求对应页的数据。
    		    console.log("每页总数："+obj.limit); //得到每页显示的条数
    		    //首次不执行
    		    if(!first){
    		    	showPage(obj.currentPage);
    		    }
    		  }
    		});
      return false;
    });
   */
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
    return false;
  });
  //分页的ajax
  function showPage(n) {
	$.ajax({
		type : "POST",
		async:false,
		data : {
			currentPage:n
		},
		dataType : "text",
		url : "<%=basePath%>account/assetsRecording.do",
		success : function(result) {
			console.log("结果:"+result);
			var tl = eval("(" + result + ")");
			if(n==-1){
				total=tl.total;
				$("#total").text(total);
			}
			$("#users").html("");
			//json遍历
			if(tl.list.length>0){
				$.each(tl.list, function(n,val){
					var str="";
				    str+="<tr>";
				    str+="<td>"+(n+1)+"</td>"
				    str+="<td>"+val.makectName+"</td>"
				    str+="<td>"+val.accountAlluse+"</td>"
				    str+="<td>"+val.accountAcoding+"</td>"
				    str+="<td>"+val.accountOper+"</td>"
				    str+="<td>"+new Date(val.accountDate).format("yyyy-MM-dd hh:mm")+"</td>"
				    str+="<td><a class=\"layui-btn  layui-btn-mini\" onclick=\"x_admin_show('修改','manageEmeController/toUserEdit.do?userId="+val.userId+"')\" ><i class=\"layui-icon\">&#xe642;</i>查看详细信息</a></td>"
				    str+="</tr>";
					$("#users").append(str);
				})
			}else{
				$("#users").append("<tr><td colspan=8 align=\"center\">暂时没有数据哦，快去添加一条吧</td></tr>");
			}
			
		},
		error : function() {
			layer.msg('无法连接服务器', {icon: 2});
		}
	});
}
  //分页
  showPage(-1);
  laypage.render({
	  elem: 'test1'
	  ,count: total //数据总数，从服务端得到
	  ,limit:4
	  ,jump: function(obj, first){
	    //obj包含了当前分页的所有参数，比如：
	    console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
	    console.log(obj.limit); //得到每页显示的条数
	    
	    //首次不执行
	    if(!first){
	    	showPage(obj.curr);
	    }
	  }
	});
});
function test() {
	$.ajax({
		type : "POST",
		async:false,
		data : {
			index:null
		},
		dataType : "text",
		url : "roleController/getUserRole.ajax",
		success : function(result) {
			alert(result);
			console.log(result);
		},
		error : function() {
			layer.msg('无法连接服务器', {icon: 2});
		}
	});
}
</script>
</html>