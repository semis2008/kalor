//判断浏览器类型
function getOs() {  
	var OsObject = "";  
	if(navigator.userAgent.indexOf("MSIE")>0) {  
		return "MSIE";  
	}  
	if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
		return "Firefox";  
	}  
	if(isSafari=navigator.userAgent.indexOf("Safari")>0) {  
		return "Safari";  
	}   
	if(isCamino=navigator.userAgent.indexOf("Camino")>0){  
		return "Camino";  
	}  
	if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){  
	     return "Gecko";  
	}  
}  
function goToTop() {
	$('body,html').animate({
		scrollTop : 0
	}, 1000);
}

function showErrorMsg(msg) {
	var msgD = $.globalMessenger().post({
		message : msg,
		type : 'error'
	});
}
function showSuccessMsg(msg) {
	var msgD = $.globalMessenger().post({
		message : msg,
		type : 'success'
	});
} 
$(window).scroll(function() {
	var t = $(document).scrollTop();
	if (t >= 300) {
		showGoToTop();
	} else {
		hideGoToTop();
	}
});
function showGoToTop() {
	$(".goToTopDiv").show();
}

function hideGoToTop() {
	$(".goToTopDiv").hide();
}

function changeTopDiary(id) {
	$.ajax({
		type : "POST",
		url : "/action/diary/changetopdiary",
		data : {
			id : id	
		},
		dataType : "html",
		success : function(msg) {
		  $("#topDiarySec").html(msg);
		}
	});
}
