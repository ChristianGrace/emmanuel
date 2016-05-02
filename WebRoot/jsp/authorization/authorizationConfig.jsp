<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	
	<head>
		 <link href="<%=path%>/resource/css/authorization/authorization.css" rel="stylesheet">
	</head>
	<body>
	
		<jsp:include page="/jsp/header/header.jsp" /> 
		
		<div class="container">
		
				<h3>用户组</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>用户id</th>
							<th>用户名称</th>
							<th>用户角色</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>123</td>
							<td>admin</td>
							<td>ROLE_ADMIN</td>
						</tr>
					</tbody>
				</table>
				
				<h3>角色组</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>角色id</th>
							<th>角色名称</th>
							<th>角色职能</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>123</td>
							<td>系统管理员</td>
							<td>查看报表，管理系统</td>
						</tr>
					</tbody>
				</table>
				
				<h3>资源组</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>资源id</th>
							<th>资源名称</th>
							<th>资源URL</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>123</td>
							<td>查看最近收入</td>
							<td>/jsp/getinput.do</td>
						</tr>
					</tbody>
				</table>
				
				
		</div>
		
	</body>
</html>


