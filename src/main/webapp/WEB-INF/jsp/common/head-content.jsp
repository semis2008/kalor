<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<meta charset="utf-8" />
<title><%=title%></title>
<meta name="description" content="<%=description%>" />
<meta name="keywords" content="<%=keywords%>" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <%-- Prevent IE7/8 into quirks mode --%>

<link type="text/css" rel="stylesheet" href="<%=cssPath %>/lib/bootstrap.css<%=version%>" />
<link type="text/css" rel="stylesheet" href="<%=cssPath %>/common.css<%=version%>" />
<link type="text/css" rel="stylesheet" href="<%=cssPath %>/lib/bootstrap-responsive.css<%=version%>" />
<link type="text/css" rel="stylesheet" href="<%=cssPath %>/lib/font-awesome.min.css<%=version%>" />


<script type="text/javascript" src="<%=jsPath%>/jquery-1.8.2.js<%=version%>"></script>
<script type="text/javascript" src="<%=jsPath%>/lib/bootstrap.js<%=version%>"></script>
<script type="text/javascript" src="<%=jsPath%>/lib/require-jquery.js<%=version%>"></script>
<script type="text/javascript" src="<%=jsPath %>/jquery.scrollLoading.js<%=version%>"></script>
<script type="text/javascript" src="<%=jsPath %>/common.js"></script>
<script type="text/javascript">
	$(function() {
	    $(".scrollLoading").scrollLoading();
    });
</script>
<!--[if lt IE 9]> <script src="<%=jsPath%>/lib/shiv/html5.js"></script> <![endif]-->


 
<!-- 	<script type="text/javascript" -->
<!-- 		src="<%=ConstantsUtil.FW_DOMAIN%>/plugin/messenger/js/underscore-1.4.4.js"></script> -->
<!-- 	<script type="text/javascript" -->
<!-- 		src="<%=ConstantsUtil.FW_DOMAIN%>/plugin/messenger/js/backbone-0.9.10.js"></script> -->
<!-- 	<script type="text/javascript" -->
<!-- 		src="<%=ConstantsUtil.FW_DOMAIN%>/plugin/messenger/js/messenger.min.js"></script> -->
<!-- 	<script type="text/javascript" -->
<!-- 		src="<%=ConstantsUtil.FW_DOMAIN%>/plugin/musicplayer/js/jquery-ui.min.js"></script> -->
<!-- 	<script type="text/javascript" -->
<!-- 		src="<%=ConstantsUtil.FW_DOMAIN%>/plugin/musicplayer/js/script.js"></script> -->