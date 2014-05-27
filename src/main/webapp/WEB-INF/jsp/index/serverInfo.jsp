<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="span6">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="icon-calendar"></i>Server Stats
			</div>
			<div class="tools">
				<a href="" class="collapse"></a> <a href="#portlet-config"
					data-toggle="modal" class="config"></a> <a href="" class="reload"></a>
				<a href="" class="remove"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="row-fluid">
				<div class="span4">
					<div class="sparkline-chart">
						<div class="number" id="sparkline_bar"></div>
						<a class="title" href="#">Network <i class="m-icon-swapright"></i></a>
					</div>
				</div>
				<div class="margin-bottom-10 visible-phone"></div>
				<div class="span4">
					<div class="sparkline-chart">
						<div class="number" id="sparkline_bar2"></div>
						<a class="title" href="#">CPU Load <i class="m-icon-swapright"></i></a>
					</div>
				</div>
				<div class="margin-bottom-10 visible-phone"></div>
				<div class="span4">
					<div class="sparkline-chart">
						<div class="number" id="sparkline_line"></div>
						<a class="title" href="#">Load Rate <i
							class="m-icon-swapright"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="span6">
	<!-- BEGIN PORTLET-->
	<div class="portlet solid bordered light-grey">
		<div class="portlet-title">
			<div class="caption">
				<i class="icon-signal"></i>Server Load
			</div>
			<div class="tools">
				<div class="btn-group pull-right" data-toggle="buttons-radio">
					<a href="" class="btn red mini active"> <span
						class="hidden-phone">Database</span> <span class="visible-phone">DB</span></a>
					<a href="" class="btn red mini">Web</a>
				</div>
			</div>
		</div>
		<div class="portlet-body">
			<div id="load_statistics_loading">
				<img src="media/image/loading.gif" alt="loading" />
			</div>
			<div id="load_statistics_content" class="hide">
				<div id="load_statistics" style="height:108px;"></div>
			</div>
		</div>
	</div>
	<!-- END PORTLET-->
</div>
