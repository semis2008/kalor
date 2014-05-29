<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- BEGIN FOOTER -->
<div class="footer">
	<div class="footer-inner">2014 &copy; <%=ICP_BEIAN %> | Designed with METRONIC.</div>
	<div class="footer-tools">
		<span class="go-top"> <i class="icon-angle-up"></i>
		</span>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<script src="<%=staticPath %>/js/jquery-1.10.1.min.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery-migrate-1.2.1.min.js<%=version %>"
	type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js<%=version %> before bootstrap.min.js<%=version %> to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<%=staticPath %>/js/jquery-ui-1.10.1.custom.min.js<%=version %>"
	type="text/javascript"></script>
<script src="<%=staticPath %>/js/bootstrap.min.js<%=version %>" type="text/javascript"></script>
<!--[if lt IE 9]>
	<script src="<%=staticPath %>/js/excanvas.min.js<%=version %>"></script>
	<script src="<%=staticPath %>/js/respond.min.js<%=version %>"></script>  
	<![endif]-->
	
<script src="<%=staticPath %>/js/jquery.slimscroll.min.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.blockui.min.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.cookie.min.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.uniform.min.js<%=version %>" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<%=staticPath %>/js/jquery.flot.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.flot.resize.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.pulsate.min.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/date.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/daterangepicker.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.gritter.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/fullcalendar.min.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.easy-pie-chart.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/jquery.sparkline.min.js<%=version %>" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->

<!-- JS TEMPLATES -->
<script src="<%=staticPath %>/js/kalor/jsViews.js<%=version %>" type="text/javascript"></script>
<!-- END JS TEMPLATES -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=staticPath %>/js/app.js<%=version %>" type="text/javascript"></script>
<script src="<%=staticPath %>/js/index.js<%=version %>" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->

<script>
	jQuery(document).ready(function() {
	    App.init(); // initlayout and core plugins
	    Index.init();
	    Index.initCalendar(); // init index page's custom scripts
	    Index.initCharts(); // init index page's custom scripts
	    Index.initChat();
	    Index.initMiniCharts();
	    Index.initDashboardDaterange();
	    Index.initIntro();
    });
</script>

<!-- END JAVASCRIPTS -->