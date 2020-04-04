$(document).ready(function(){
	// 页面加载时候调用相应的js代码块
//	alert("1111111111");
	// 页面加载时候调用相应的js方法
//	test();
	
	/*
	 * 控制导航栏active属性
	 */
	$('.nav li a').each(function(){  
		if($($(this))[0].href==String(window.location))  
			$(this).parent().addClass('active');  
	});
	
	/*
	 * 用户注册
	 */
	$("#registerButton").bind("click", function() {
		var user = {};
		user.userName = $("[name='userName']").val();
		user.password = $("[name='password']").val();
		$.ajax({
			url : "/account/doRegister",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(user),
			success : function (data) {
				if (data.status == 200) {
					location.href = "/account/dashboard";
				} else {
					$("#message").html(data.message);
				}
			},
			error : function (data) {
				$("#message").html(data.responseText);
			}
		});
	});
	
	/*
	 * 点击 edit按钮，获取user数据，渲染到编辑框内
	 */
	$("[name='userEdit']").bind("click", function(){
        var userId = $(this).parents("tr").find("[name=userId]").text();
        var userName = $(this).parents("tr").find("[name=userName]").text();
        
        // ajax 获取被选中的 role list，选中相应的checkbox
        $.ajax({
        	url : "/account/roles/user/" + userId,
        	type : "get",
        	contentType: "application/json",
        	success : function (data) {
        		$.each(data, function(i, item){
        			$("input[name='roleCheckbox'][value=" + item.roleId + "]")
        				.attr("checked","checked");
        		});
        	},
        	error : function (data) {
        		$("[name=messageDiv]").show();
        		$("[name=message]").html(data.message);
        	}
        });
        
        $("#userId").val(userId);
        $("#userName").val(userName);
        $("#userList").hide();
		$("#userEdit").show();
	});
	
	/*
	 * 编辑user
	 */
	$("#userSubmit").bind("click", function(){
		var user = {};
		user.userId = $("#userId").val();
		var roles = new Array();
		$.each($("input[name='roleCheckbox']"), function(){
			if(this.checked){
				var role = {};
				role.roleId = $(this).val();
				roles.push(role);
			}
		});
		user.roles = roles;
		$.ajax({
			url : "/account/editUser",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(user),
			success : function (data) {
				if (data.status == 200) {
					location.href = "/account/users";
				} else {
					$("[name=messageDiv]").show();
					$("[name=message]").html(data.message);
				}
			},
			error : function (data) {
				$("[name=messageDiv]").show();
				$("[name=message]").html(data.message);
			}
		});
	});
	
	/*
	 * 控制role新增页面
	 */
	$("#addRole").bind("click", function(){
		$("#roleList").hide();
		$("#roleEdit").show();
	});
	
	/*
	 * 点击 edit按钮，获取role数据，渲染到编辑框内
	 */
	$("[name='editRole']").bind("click", function(){
        var roleId = $(this).parents("tr").find("[name=roleId]").text();
        var roleName = $(this).parents("tr").find("[name=roleName]").text();
        $("#roleId").val(roleId);
        $("#roleName").val(roleName);
        $("#roleList").hide();
		$("#roleEdit").show();
	});
	
	/*
	 * 新增或修改role
	 */
	$("#roleSubmit").bind("click", function(){
		var role = {};
		role.roleId = $("#roleId").val();
		role.roleName = $("#roleName").val();
		$.ajax({
			url : "/account/editRole",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(role),
			success : function (data) {
				if (data.status == 200) {
					location.href = "/account/roles";
				} else {
					$("[name=messageDiv]").show();
					$("[name=message]").html(data.message);
				}
			},
			error : function (data) {
				$("[name=messageDiv]").show();
				$("[name=message]").html(data.message);
			}
		});
	});
	
	/*
	 * 控制resource新增页面
	 */
	$("#addResource").bind("click", function(){
		$("#resourceList").hide();
		$("#resourceEdit").show();
	});
	
	/*
	 * 点击 edit按钮，获取相应数据，渲染到编辑框内
	 */
	$("[name='editResource']").bind("click", function(){
        var resourceId = $(this).parents("tr").find("[name=resourceId]").text();
        var resourceName = $(this).parents("tr").find("[name=resourceName]").text();
        var resourceUri = $(this).parents("tr").find("[name=resourceUri]").text();
        var permission = $(this).parents("tr").find("[name=permission]").text();
        
        // ajax 获取被选中的 role list，选中相应的checkbox
        $.ajax({
        	url : "/account/roles/resource/" + resourceId,
        	type : "get",
        	contentType: "application/json",
        	success : function (data) {
        		$.each(data, function(i, item){
        			$("input[name='roleCheckbox'][value=" + item.roleId + "]")
        				.attr("checked","checked");
        		});
        	},
        	error : function (data) {
        		$("[name=messageDiv]").show();
        		$("[name=message]").html(data.message);
        	}
        });
        
        $("#resourceId").val(resourceId);
        $("#resourceName").val(resourceName);
        $("#resourceUri").val(resourceUri);
        $("#permission").val(permission);
        $("#resourceList").hide();
		$("#resourceEdit").show();
	});
	
	/*
	 * 新增或修改resource
	 */
	$("#resourceSubmit").bind("click", function(){
		var resource = {};
		resource.resourceId = $("#resourceId").val();
		resource.resourceName = $("#resourceName").val();
		resource.resourceUri = $("#resourceUri").val();
		resource.permission = $("#permission").val();
		var roles = new Array();
		$.each($("input[name='roleCheckbox']"), function(){
			if(this.checked){
				var role = {};
				role.roleId = $(this).val();
				roles.push(role);
			}
		});
		resource.roles = roles;
		$.ajax({
			url : "/account/editResource",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(resource),
			success : function (data) {
				if (data.status == 200) {
					location.href = "/account/resources";
				} else {
					$("[name=messageDiv]").show();
					$("[name=message]").html(data.message);
				}
			},
			error : function (data) {
				$("[name=messageDiv]").show();
				$("[name=message]").html(data.message);
			}
		});
	});
});

// 测试方法
function test() {
	alert("22222222");
}