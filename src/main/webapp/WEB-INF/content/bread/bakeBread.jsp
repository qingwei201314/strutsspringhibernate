<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
		<th>姓名</th>
		<th>数量</th>
		</thead>
		<s:iterator value="bakeBreadList">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="breadCount" /></td>
			</tr>
		</s:iterator>
	</table>
	<div>
		负责人：
		<s:property value="bakeBreadVo.name" />
		总数:
		<s:property value="bakeBreadVo.total" />
	</div>
	<s:form action="/bread/saveBread">
		用户名：<s:textfield name="bakeBread.account"></s:textfield>
		密码：<s:password name="bakeBread.password"></s:password>
		数量：<s:textfield name="bakeBread.breadCount"></s:textfield>
		<s:submit value="确定"></s:submit>
	</s:form>

	<div>说明：今天到目前为止，所有上报的人中，累计操作次数 最少的便是负责人。当有新上报时，负责人可能会改变。</div>
</body>
</html>