<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="po.Customer" %>
<%@ page import="po.BaseDict" %>
<%@ page import="java.util.List" %>
<% String path=request.getContextPath()+"/";%>
<html>
<head>
<title>主界面</title>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/customer.css"/>
<link rel="stylesheet" type="text/css" href="../css/my-page.css"/>
<script src="../js/my-page.js"></script>
</head>
<body>
	<nav class="topNav">
		<a href="<%=path %>customer/getByCondition?customerName=&page=1&custSource=&custIndustry=&custLevel=" class="topNav-left">BOOT后台管理系统</a>
		<div class="topNav-right">
		<i class="iconfont icon-user"></i>
		<i class="iconfont icon-arrow"></i>
		<ul>
			<li><i class="iconfont icon-user-login"></i><%=session.getAttribute("userName")%></li>
			<a href="<%=path %>user/loginOut"><li><i class="iconfont icon-leave"></i>登出</li></a>
		</ul>
		</div>
	</nav>
	<main class="main">
		<div class="left-content">
			<div class="left-search">
				<input type="text" placeholder="查询内容" class="search-input"><button class="search-btn">查询</button>
			</div>
			<ul class="ul-link">
				<li class="li-link li-link-acitve">客户管理</li>
				<li class="li-link">客户拜访</li>
			</ul>
		</div>
		<div class="right-content">
			<h1>客户管理</h1>
			<form class="right-search" action="<%=path %>customer/getByCondition">
				<div class="div-customer-name">
					<label for="customer-name" class="search-content">客户名称</label>
					<input type="text" name="customerName" id="customer-name" placeholder="请输入">
					<input type="hidden" name="page" value="1">
				</div>
				<div class="form-group">
						<label for="customerFrom">客户来源</label> 
						<select	class="form-control" id="customerFrom" name="custSource">
							<option value="">--请选择--</option>
							<c:forEach items="${originList}" var="item">
								<option value="${item.dict_item_name}"
								       <c:if test="${item.dict_id == custSource}">selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="custIndustry">所属行业</label> 
						<select	class="form-control" id="custIndustry"  name="custIndustry">
							<option value="">--请选择--</option>
							<c:forEach items="${industList}" var="item">
								<option value="${item.dict_item_name}"
								        <c:if test="${item.dict_id == custIndustry}"> selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="custLevel">客户级别</label>
						<select	class="form-control" id="custLevel" name="custLevel">
							<option value="">--请选择--</option>
							<c:forEach items="${levelList}" var="item">
								<option value="${item.dict_item_name}"
								        <c:if test="${item.dict_id == custLevel}"> selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
					</div>
					<input type="button" value="查询" class="search-btn-right" onclick="search()">
			</form>
			<button class="new-customer" onclick="newCustomer()">新建</button>
			<div class="table-wrapper">
				<div class="table-title">客户信息列表</div>
				<table class="table-customer">
						<thead>
							<tr>
								<th>编号</th>
								<th>客户名称</th>
								<th>客户来源</th>
								<th>客户所属行业</th>
								<th>客户级别</th>
								<th>固定电话</th>
								<th>手机</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${customerList}" var="customer">
								<tr>
									<td>${customer.cust_id}</td>
									<td>${customer.cust_name}</td>
									<td>${customer.cust_source_str}</td>
									<td>${customer.cust_industry_str}</td>
									<td>${customer.cust_level_str}</td>
									<td>${customer.cust_phone}</td>
								    <td>${customer.cust_mobile}</td>
									<td>
										<a href="#" class="btn-edit" data-toggle="modal" onclick= "editCustomer('${customer.cust_id}','${customer.cust_name}','${customer.cust_source_str}','${customer.cust_industry_str}','${customer.cust_level_str}','${customer.cust_linkman }','${customer.cust_phone}','${customer.cust_zipcode}','${customer.cust_address}','${customer.cust_mobile}')">编辑</a>
										<a href="#" class="btn-delete" onclick="deleteCustomer(${customer.cust_id})">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
			<div class="page-content">
				<div class="my-page"></div>
			</div>
			
		</div>
	</main>
	<div class="popup-add">
		<div class="popup-content">
			<div class="popup-add-title">新建客户信息</div>
			<form class="form-add">
				<div class="div-content">
					<span>客户名称</span>
					<input type="text" placeholder="客户名称" class="form-content" name="custName">
				</div>
				<div class="div-content">
					<span>客户来源</span>
					<select	 name="custSource"  class="form-content">
							<option value="">--请选择--</option>
							<c:forEach items="${originList}" var="item">
								<option value="${item.dict_item_name}"
								       <c:if test="${item.dict_id == custSource}">selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
				</div>
				<div class="div-content">
					<span>所属行业</span>
					<select  name="custIndustry"  class="form-content">
							<option value="">--请选择--</option>
							<c:forEach items="${industList}" var="item">
								<option value="${item.dict_item_name}"
								        <c:if test="${item.dict_id == custIndustry}"> selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
				</div>
				<div class="div-content">
					<span>客户级别</span>
					<select	name="custLevel"  class="form-content">
							<option value="">--请选择--</option>
							<c:forEach items="${levelList}" var="item">
								<option value="${item.dict_item_name}"
								        <c:if test="${item.dict_id == custLevel}"> selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
				</div>
				<div class="div-content">
					<span>联系人</span>
					<input type="text" placeholder="联系人" class="form-content" name="custLink">
				</div>
				<div class="div-content">
					<span>固定电话</span>
					<input type="text" placeholder="固定电话" class="form-content" name="custPhone">
				</div>
				<div class="div-content">
					<span>移动电话</span>
					<input type="text" placeholder="移动电话" class="form-content" name="custMobile">
				</div>
				<div class="div-content">
					<span>邮政编码</span>
					<input type="text" placeholder="邮政编码" class="form-content" name="custZip">
				</div>
				<div class="div-content">
					<span>联系地址</span>
					<input type="text" placeholder="联系地址" class="form-content" name="custAddress">
				</div>
			</form>
			<div class="btn-list">
				<button class="btn close" onclick="closeCustomer()">关闭</button>
				<button class="btn add" onclick="addCustomer()">创建客户</button>
			</div>
		</div>
	</div>
	<div class="popup-edit">
		<div class="popup-content">
			<div class="popup-edit-title">修改客户信息</div>
			<form class="form-edit">
				<div class="div-content">
					<span>客户名称</span>
					<input type="text" placeholder="客户名称" class="form-content" name="custName">
					<input type="hidden" name="custId" class="form-content">
				</div>
				<div class="div-content">
					<span>客户来源</span>
					<select	 name="custSource"  class="form-content">
							<option value="">--请选择--</option>
							<c:forEach items="${originList}" var="item">
								<option value="${item.dict_item_name}"
								       <c:if test="${item.dict_id == custSource}">selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
				</div>
				<div class="div-content">
					<span>所属行业</span>
					<select  name="custIndustry"  class="form-content">
							<option value="">--请选择--</option>
							<c:forEach items="${industList}" var="item">
								<option value="${item.dict_item_name}"
								        <c:if test="${item.dict_id == custIndustry}"> selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
				</div>
				<div class="div-content">
					<span>客户级别</span>
					<select	name="custLevel"  class="form-content">
							<option value="">--请选择--</option>
							<c:forEach items="${levelList}" var="item">
								<option value="${item.dict_item_name}"
								        <c:if test="${item.dict_id == custLevel}"> selected</c:if>>
								    ${item.dict_item_name }
								</option>
							</c:forEach>
						</select>
				</div>
				<div class="div-content">
					<span>联系人</span>
					<input type="text" placeholder="联系人" class="form-content" name="custLink">
				</div>
				<div class="div-content">
					<span>固定电话</span>
					<input type="text" placeholder="固定电话" class="form-content" name="custPhone">
				</div>
				<div class="div-content">
					<span>移动电话</span>
					<input type="text" placeholder="移动电话" class="form-content" name="custMobile">
				</div>
				<div class="div-content">
					<span>邮政编码</span>
					<input type="text" placeholder="邮政编码" class="form-content" name="custZip">
				</div>
				<div class="div-content">
					<span>联系地址</span>
					<input type="text" placeholder="联系地址" class="form-content" name="custAddress">
				</div>
			</form>
			<div class="btn-list">
				<button class="btn close" onclick="closeEdit()">关闭</button>
				<button class="btn edit" onclick="confirmEdit()">保存修改</button>
			</div>
		</div>
	</div>
	<div class="login-none">
		<i class="iconfont icon-error"></i>未登录，三秒后返回登录页面
	</div>
</body>
<script>
	var userId = <%=session.getAttribute("userId")%>;
	window.onload = function() {
		if(!userId) {
			document.querySelector(".right-content").style.opacity="0";
//			window.location.href = "../user/login.jsp";
			document.querySelector(".login-none").style.opacity = "1";
			setTimeout(function() {
				window.location.href = "../user/login.jsp";
			},3000)
		}
		var form = document.querySelector(".right-search");
		var customerName = "<%=session.getAttribute("customerName")%>";
		var customerOrigin = "<%=session.getAttribute("customerOrigin")%>";
		var industName = "<%=session.getAttribute("industName")%>";
		var customerLevel = "<%=session.getAttribute("customerLevel")%>";
		form.customerName.value = customerName||"";
		Array.from(form.custSource.options).forEach((item,index)=> {
			if(item.label==customerOrigin) {
				form.custSource.options.selectedIndex = index;
			}
			
		})
		Array.from(form.custIndustry.options).forEach((item,index)=> {
			if(item.label==industName) {
				form.custIndustry.options.selectedIndex = index;
			}
			
		})
		Array.from(form.custLevel.options).forEach((item,index)=> {
			if(item.label==customerLevel) {
				form.custLevel.options.selectedIndex = index;
			}
			
		})
	}
	var page1 = <%=session.getAttribute("currentPage")%> || 1;
	var totalPage = <%=session.getAttribute("totalPage")%> || 1;
	console.log(totalPage);
//	document.querySelector(".right-search").page.value = page1;
	myPageInit({
	    pages: totalPage,
	    currentPage: page1,
	    element: '.my-page',
	    callback: function(page) {
//	        var form = document.querySelector(".right-search");
//	        form.page.value = page;
//	        form.custLevel.options.selectedIndex =2        
//	        form.submit();
			if(window.location.href.includes("user")) {
				window.location.href = <%=path%>+"customer/getByCondition?customerName=&page=1&custSource=&custIndustry=&custLevel=".replace(/page=\d*/,"page="+page);
			}else {
				window.location.href=window.location.href.replace(/page=\d*/,"page="+page);
			}
	        
	        
	    }
	});
	function search() {
		document.querySelector(".right-search").submit();
	}
	function newCustomer() {
		document.querySelector(".popup-add").style.display = "block";
	}
	function closeCustomer() {
		document.querySelector(".form-add").reset();
		document.querySelector(".popup-add").style.display = "none";
	}
	function editCustomer(cust_id,cust_name,cust_source_str,cust_industry_str,cust_level_str,cust_linkman,cust_phone,cust_zipcode,cust_address,cust_mobile) {
		var formEdit = document.querySelector(".form-edit");
		formEdit.custId.value = cust_id;
		formEdit.custName.value = cust_name;
		Array.from(formEdit.custSource.options).forEach((item,index)=> {
			if(item.label==cust_source_str) {
				formEdit.custSource.options.selectedIndex = index;
			}
			
		})
		Array.from(formEdit.custIndustry.options).forEach((item,index)=> {
			if(item.label==cust_industry_str) {
				formEdit.custIndustry.options.selectedIndex = index;
			}
			
		})
		Array.from(formEdit.custLevel.options).forEach((item,index)=> {
			if(item.label==cust_level_str) {
				formEdit.custLevel.options.selectedIndex = index;
			}
			
		})
		formEdit.custLink.value = cust_linkman;
		formEdit.custPhone.value = cust_phone;
		formEdit.custZip.value = cust_zipcode;
		formEdit.custAddress.value = cust_address;
		formEdit.custMobile.value = cust_mobile;
		document.querySelector(".popup-edit").style.display = "block";
	}
	function closeEdit() {
		document.querySelector(".popup-edit").style.display = "none";
	}
	function addCustomer() {
		var formAdd = document.querySelector(".form-add");
		if(!intercept(formAdd)) {
			return;
		}
		var custName = formAdd.custName.value;
		var custSource = formAdd.custSource.value;
		var custIndustry = formAdd.custIndustry.value;
		var custLevel = formAdd.custLevel.value;
		var custLink = formAdd.custLink.value;
		var custPhone = formAdd.custPhone.value;
		var custMobile = formAdd.custMobile.value;
		var custZip = formAdd.custZip.value;
		var custAddress = formAdd.custAddress.value;
//		ajax请求部分
		var xml=new XMLHttpRequest();
		var params = 'userId='+ userId+'&custName='+ custName+ '&custSource='+ custSource+ '&custIndustry='+ custIndustry+ '&custLevel='+ custLevel+ '&custLink='+ custLink+ '&custPhone='+ custPhone+ '&custMobile='+ custMobile+ '&custZip='+ custZip+ '&custAddress='+ custAddress;
		xml.open("POST","../customer/addCustomer",true);
		xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xml.send(params);
		xml.onreadystatechange = function () {//此处为回调函数
            if (xml.readyState == 4 && xml.status == 200) {
				window.location.reload();
        	};
		}
	}
	function deleteCustomer(custId) {
		if(confirm("确定删除此客户?")) {
//			ajax请求部分
			var xml=new XMLHttpRequest();
			var params = 'custId=' + custId;
			xml.open("POST","../customer/deleteCustomer",true);
			xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xml.send(params);
			xml.onreadystatechange = function() {//此处为回调函数
	            if (xml.readyState == 4 && xml.status == 200) {
					window.location.reload();
	        	};
			}
		}
	}
	function intercept(form) {
		if(form.custName.value=="") {
			alert("客户名称不能为空！");
			return false;
		}else if(form.custSource.value =="") {
			alert("客户来源不能为空！");
			return false;
		}else if(form.custIndustry.value == "") {
			alert("所属行业不能为空！");
			return false;
		}else if(form.custLevel.value == "") {
			alert("客户级别不能为空");
			return false;
		}else if(form.custLink.value == "") {
			alert("联系人不能为空");
			return false;
		}else if(form.custPhone.value == ""|| !/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(form.custPhone.value)) {
			alert("固定电话有误，请重填");
			return false;
		}else if(form.custMobile.value == "" || !(/^1[34578]\d{9}$/.test(form.custMobile.value))) {
			alert("移动电话有误，请重填");
			return false;
		}else if(form.custZip.value == "") {
			alert("邮政编码不能为空");
			return false;
		}else if(form.custAddress.value == "") {
			alert("联系地址不能为空");
			return false;
		}
		return true;
	}
	function confirmEdit() {
		var formEdit = document.querySelector(".form-edit");
		if(!intercept(formEdit)) {
			return;
		}
		var custId = formEdit.custId.value;
		var custName = formEdit.custName.value;
		var custSource = formEdit.custSource.value;
		var custIndustry = formEdit.custIndustry.value;
		var custLevel = formEdit.custLevel.value;
		var custLink = formEdit.custLink.value;
		var custPhone = formEdit.custPhone.value;
		var custMobile = formEdit.custMobile.value;
		var custZip = formEdit.custZip.value;
		var custAddress = formEdit.custAddress.value;
//		ajax请求部分
		var xml=new XMLHttpRequest();
		var params = 'custId=' + custId + '&custName='+ custName+ '&custSource='+ custSource+ '&custIndustry='+ custIndustry+ '&custLevel='+ custLevel+ '&custLink='+ custLink+ '&custPhone='+ custPhone+ '&custMobile='+ custMobile+ '&custZip='+ custZip+ '&custAddress='+ custAddress;
		xml.open("POST","../customer/updateCustomer",true);
		xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xml.send(params);
		xml.onreadystatechange = function(){//此处为回调函数
            if (xml.readyState == 4 && xml.status == 200) {
				window.location.reload();
        	};
		}
	}
	
	
</script>
</html>
