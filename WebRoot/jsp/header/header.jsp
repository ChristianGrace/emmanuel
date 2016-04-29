<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
   <link rel="icon" href="<%=path%>/resource/img/favicons/favicon.ico">

    <title> <spring:message code="emmanuel.myAccount.system"/></title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://v3.bootcss.com/examples/jumbotron/jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="http://v3.bootcss.com/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
        <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=path%>/resource/js/jquery-1.9.1.js"></script>
    <script src="<%=path%>/resource/bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script>
    <style>
		body {font-family:'微软雅黑';} 
		.top-size{ font-size: 17px;}
	</style>
</head>


<nav class="navbar navbar-inverse navbar-fixed-top top-size">
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
            <li><a href="#">标签2</a></li>
            <li><a href="#">标签3</a></li>
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
		     		<button type="submit" class="btn btn-success">退出</button>
		    	</form>
         	 </c:when>
         <c:otherwise>
         	 <form class="navbar-form navbar-right">
	            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginDivModel" >登录</button>
	            <button type="button" class="btn btn-success">注册</button>
	         </form>
         </c:otherwise>
         </c:choose>  
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
<!--登陆弹窗 -->
<div class="modal fade" id="loginDivModel" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document" style="width:20%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">登录信息</h4>
      </div>
      <form action="<%=path%>/j_spring_security_check" method="post">
	      <div class="modal-body">
	        
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">账号:</label>
	            <input type="text" class="form-control" id="login_name" name='j_username'>
	          </div>
	          <div class="form-group">
	            <label for="message-text" class="control-label">密码:</label>
	           <input type="password" class="form-control" id="login_password" name='j_password'>
	          </div>
	       
	      </div>
	      <div class="modal-footer">
	        <button type="submit" class="btn btn-primary">登录</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
       </form>
    </div>
  </div>
</div>
 
</html>