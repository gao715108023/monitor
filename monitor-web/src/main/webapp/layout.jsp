<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <style type="text/css">
        /*#container {*/
        /*margin-left: auto;*/
        /*margin-right: auto;*/
        /*width: 800px;*/
        /*}*/

        /*#header {*/
        /*float: left;*/
        /*width: 800px;*/
        /*height: 100px;*/
        /*background: red;*/
        /*}*/

        /*#menu {*/
        /*float: left;*/
        /*width: 150px;*/
        /*height: 600px;*/
        /*background: blue;*/
        /*word-wrap: break-word;*/
        /*}*/

        /*#body {*/
        /*float: right;*/
        /*width: 642px;*/
        /*height: 600px;*/
        /*background: green;*/
        /*}*/

        /*#footer {*/
        /*float: left;*/
        /*width: 800px;*/
        /*height: 150px;*/
        /*background: yellow;*/
        /*}*/

        #container {
            margin-left: auto;
            margin-right: auto;
            width: 100%;
        }

        #header {
            float: left;
            width: 100%;
            height: 60px;
            /*background: red;*/
        }

        #menu {
            float: left;
            width: 10%;
            height: 500px;
            /*background: blue;*/
            word-wrap: break-word;
        }

        #body {
            float: right;
            width: 90%;
            height: 500px;
            /*background: green;*/
        }

        #footer {
            float: left;
            width: 100%;
            height: 30px;
            /*background: yellow;*/
        }
    </style>
</head>
<body>
<%--<table border="1" cellpadding="2" cellspacing="2" align="center" width="100%">--%>
<%--<tr>--%>
<%--<td height="30" colspan="2"><tiles:insertAttribute name="header"/>--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td height="250"><tiles:insertAttribute name="menu"/></td>--%>
<%--<td width="350"><tiles:insertAttribute name="body"/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td height="30" colspan="2"><tiles:insertAttribute name="footer"/>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--<div id="container" style="height: auto">--%>
<%--<div id="header">--%>
<%--<tiles:insertAttribute name="header"/>--%>
<%--</div>--%>

<%--<div id="menu">--%>
<%--<tiles:insertAttribute name="menu"/>--%>
<%--</div>--%>

<%--<div id="body" style="border: none">--%>
<%--<tiles:insertAttribute name="body"/>--%>
<%--</div>--%>

<%--&lt;%&ndash;<div id="footer" style="height: 100px">&ndash;%&gt;--%>
<%--&lt;%&ndash;<tiles:insertAttribute name="footer"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--<div id="footer">--%>
<%--<tiles:insertAttribute name="footer"/>--%>
<%--</div>--%>
<%--</div>--%>

<div id="container">
    <div id="header">
        <tiles:insertAttribute name="header"/>
    </div>

    <div id="menu">
        <tiles:insertAttribute name="menu"/>
    </div>

    <div id="body">
        <tiles:insertAttribute name="body"/>
    </div>

    <%--<div id="footer" style="height: 100px">--%>
    <%--<tiles:insertAttribute name="footer"/>--%>
    <%--</div>--%>

    <div id="footer">
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>