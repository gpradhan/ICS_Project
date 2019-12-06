//function preventBack() {
//	window.history.forward();
//}
//setTimeout("preventBack()", 0);
//window.onunload = function() {
//	null
//};

//disable back button
//history.pushState(null, null, location.href);
//window.onpopstate = function () {
//    history.go(1);
//};

function scrollDownChatMessages(){
	$('#messages').scrollTop($('#messages')[0].scrollHeight);
}

//disable refresh button
$(function () {  
    $(document).keydown(function (e) {  
        return (e.which || e.keyCode) != 116;  
    });  
}); 

function selectAllContacts(){
//	$('.contactClass').attr('checked',true);
	$('.contactClass').prop('checked', true);
}

function clearAllContacts(){
//	$('.contactClass').attr('checked',false);
	$('.contactClass').prop('checked', false);
}

function disableF5(e) { if ((e.which || e.keyCode) == 116) e.preventDefault(); };
$(document).on("keydown", disableF5);