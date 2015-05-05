<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>index</title>
<meta name="viewport" content="initial-scale=1.0,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/whale/resource/css/map/map.css" rel="stylesheet">
</head>
<body>
<div id="container"></div>
<%@include file="/whale/common/common.jsp" %>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=7ddc6897622d1c81cef4bd4bca02eb1c"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/whale/resource/js/map/map.js"></script>
</body>
</html> 