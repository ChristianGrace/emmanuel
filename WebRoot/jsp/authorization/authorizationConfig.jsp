<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
		<div class="container" style="padding-top:50px;">
				
				<div>
				<h3>用户组</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="tableId">用户id</th>
							<th class="tableName">用户名称</th>
							<th class="tableResource">用户角色</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="user">
							<tr>
								<td>${user.id}</td>
								<td>${user.logname}</td>
								<td>${user.role_ids}</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
				</div>
				<div style="padding-top:10px;">
				<h3>角色组</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="tableId">角色id</th>
							<th class="tableName">角色名称</th>
							<th class="tableResource">角色职能</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${roleList}" var="role">
							<tr>
								<td>${role.id}</td>
								<td>${role.roleType}</td>
								<td>${role.powerIds}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
				<div style="padding-top:10px;">
				<h3>资源组</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="tableId">资源id</th>
							<th class="tableName">资源名称</th>
							<th class="tableResource">资源URL</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${resourceList}" var="resource">
						<tr>
							<td>${resource.id}</td>
							<td>${resource.resourceName}</td>
							<td>${resource.resourceUrl}</td>
						</tr>
					</c:forEach>
						
					</tbody>
				</table>
				</div>
				
		</div>
		
	</body>
</html>


