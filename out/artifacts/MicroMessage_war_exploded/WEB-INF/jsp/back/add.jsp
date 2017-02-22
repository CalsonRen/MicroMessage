<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" pageEncoding="utf-8"/>
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容添加页面</title>
		<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= basePath %>resources/js/jquery-1.8.0.min.js"></script>
		<script src="<%= basePath %>resources/js/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%=basePath%>Insert.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容添加</div>
				<div class="rightCont">
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>指令名称</th>
								    <th>描述</th>
								    <th>操作</th>
								</tr>
								<tr>
									<td>
										<input name="command" type="text" class="allInput" value=""/>
									</td>
									<td>
										<input name="description" type="text" class="allInput" value=""/>
									</td>
									<td>
										<input name="content" type="text" class="allInput" value=""/>
									</td>
								</tr>
								<tr>
									<input align="middle" type="submit" class="tabSub" value="添加" /></td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>