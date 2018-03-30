<%--
  Created by IntelliJ IDEA.
  User: gaochuanjun
  Date: 14-5-16
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<tiles:importAttribute name="index-def" scope="request"/>--%>
<html>
<head>
    <%--<title><tile><tiles:getAsString name="title"/></tile></title>--%>
</head>
<%--<body background="images/skulls.png">--%>
<body>
<%--<s:actionerror></s:actionerror>--%>
<tiles:insertDefinition name="baseLayout"/>
<%--<tiles:insertAttribute name="header"/>--%>
<%--<p id="body">--%>
<%--<tiles:insertAttribute name="main"/>--%>
<%--</p>--%>
</body>
</html>