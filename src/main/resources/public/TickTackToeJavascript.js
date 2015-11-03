function clear(){
	$("#1").html("$");
	$("#2").html("$");
	$("#3").html("$");
	$("#4").html("$");
	$("#5").html("$");
	$("#6").html("$");
	$("#7").html("$");
	$("#8").html("$");
	$("#9").html("$");
}

$(function(){

    $('td').click( function(){
	var cell = $(this).attr('id'); 
	if($(this).html()==""){
	    $.ajax({
		type: "post",
		url: "/cell",
		data:"cell=" + cell
	   
	   }).done(function(result){
	       $("#" + cell).html(result);
		});
	};
	$(this).toggleClass("red-cell");
	event.preventDefault();
	
    });


    $('#restart').click( function(){
	    $.ajax({
		type: "post",
		url: "/restart",
		data: null
	   
	   	}).done(function(result){
	       	clear();
		});
		event.preventDefault();
    });

});


