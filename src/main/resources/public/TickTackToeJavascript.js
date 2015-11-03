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


    $('restart').click( function(){
	    $.ajax({
		type: "post",
		url: "/restart",
		data: null
	   
	   	}).done(function(result){
	       	$("#1").html("$");
		});
		event.preventDefault();
    });

});


