<%--
  Created by IntelliJ IDEA.
  User: gaochuanjun
  Date: 14-6-13
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>随机计算每个工作的工作量，让你的周报再也没有烦恼！</title>
    <s:head theme="xhtml" />
</head>

<body>
<div class="ys"><h1 align="center">随机计算每个工作的工作量，让你的周报再也没有烦恼！</h1></div>

<div class="ys"><h3 align="center">此应用只供懒人专用，仅限于娱乐！</h3></div>
<s:actionerror />
<s:form action="game">
    <table width="100%" align="center" border="1">
        <s:textfield name="works" label="项目个数"></s:textfield>
        <s:textfield name="hours" label="工作小时数"></s:textfield>
        <s:submit value="计算"></s:submit>
    </table>
</s:form>
</body>
</html>