(function() {
 
	var pages = [], ran = 5, $pages = $('.page-set'), i = 0, index = 0, loading = false;

	function addPage() {
		var path = $("#contextPath").val();
		var lastTime = "1";
		$.ajax({
			url:path+"/blog/list/"+lastTime,
			dateType:"json",
			success:function(date) {
				debugger;
				alert(date);
			}
		});
		
		var diaryHtml = "<section id=\"diary_<%=diary.getId()%>\" class=\"diarySec\"><div><img width=\"60px\" height=\"60px\" alt=\"\" class=\"img-polaroid left\" src=\"#\" />" +
				"<blockquote><h3 class=\"muted\">diary.getTitle	<em title=\"回复/阅读数\">[diary.getReply_nu/diary.getRead_num]</em>" +
				"</h3><small><label class=\"label\"><i class=\"icon-tag\"></i> <%=tag%></label> <em><a class=\"text-info\" title=\"查看他发布的所有博文\" href=\"#\">diary.getAuthor_name()%></a>" +
				"发布于 <%=DateUtil.formatDate(diary.getPublish_time(), 3)%></em> </small> </blockquote>\"</div><div>	<p><%=StringUtil.cutString(diary.getContent(), 150)%></p></div><div><a class=\"button\"  href=\"#\">阅读全文 <i 	class=\"icon-chevron-down\"></i> </a>" +
				"</div></section>";	
		$pages.append(diaryHtml);
		index++;
	}
	;

	for (i = 0; i < ran; i++) {
		addPage(i);
	}

	$(window).scroll(function() {

		if(index>18) 
			return;
		
		if (loading) {
			$("#loadingDIV").show();
		}

		if ($(window).scrollTop() > $(document).height() - $(window).height() - 200) {
			loading = true;
			setTimeout(function() {
				addPage();
				$(window).sausage('draw');
				loading = false;
				$("#loadingDIV").hide();
			}, 250);
		}
	});

	/*
	 * 
	 * This is where the plugin is initialized.
	 * 
	 */

	$(window).sausage();
	for ( var i = 0; i < 5; i++) {
		$(window).sausage('draw');
	}

	

}());
