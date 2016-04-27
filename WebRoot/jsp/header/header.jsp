<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
<!--         <div class="navbar-header"> -->
<!--           <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> -->
<!--             <span class="sr-only">Toggle navigation</span> -->
<!--             <span class="icon-bar"></span> -->
<!--             <span class="icon-bar"></span> -->
<!--             <span class="icon-bar"></span> -->
<!--           </button> -->
<!--           <a class='navbar-brand' href="#"><spring:message code="emmanuel.myAccount.emmanuel"/></a> -->
<!--         </div> -->
        <ul class="nav navbar-nav">
        	<c:choose> 
        		<c:when test="${currentPage eq 'homePage'}">
        			<li class="active"><a href="#"><spring:message code="emmanuel.myAccount.emmanuel"/></a></li>
        		</c:when>
        		<c:otherwise>
        			<li><a href="#"><spring:message code="emmanuel.myAccount.emmanuel"/></a></li>
        		</c:otherwise>
        	</c:choose>
            <li><a href="#">标签1</a></li>
            <li><a href="#about">标签2</a></li>
            <li><a href="#contact">标签3</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">下拉菜单 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        <div id="navbar" class="navbar-collapse collapse">
        <c:choose> 
        	 <c:when test="${isLogin}">
        	 	<form class="navbar-form navbar-right" action="<%=path%>/j_spring_security_logout" >
		     		<button type="submit" class="btn btn-success">Log out</button>
		    	</form>
         	 </c:when>
         <c:otherwise>
         	 <form class="navbar-form navbar-right" action="<%=path%>/j_spring_security_check" method="post">
	            <div class="form-group">
	              <input type="text" placeholder="Email" class="form-control" name='j_username'>
	            </div>
	            <div class="form-group">
	              <input type="password" placeholder="Password" class="form-control" name='j_password'>
	            </div>
	            <button type="submit" class="btn btn-success">Log in</button>
	            <button class="btn btn-success">Sign up</button>
	          </form>
         </c:otherwise>
         </c:choose>  
        </div><!--/.navbar-collapse -->
      </div>
    </nav>