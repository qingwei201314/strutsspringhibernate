<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello World!</h2>
	<a href="">WEB-INF下的测试 result input</a>
	<s:form action="test" method="post" namespace="/resultAction">
		<input type="text" name="name" value="" />
		<input type="submit" value="submit" />
	</s:form>
</body>
</html>