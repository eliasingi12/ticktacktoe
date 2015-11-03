function clear(){
	for(var i = 1; i < 10; i++){
		$("#"+i.toString()).html("");
	}
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
	   		if("#winner"==""){
		   		if(result.charAt(1) == 't'){
		   			$("#winner").html(cell);
		   		}if(result.charAt(2) == '9'){
		   			$("#winner").html('It\'s a draw!');
		   		}else {
		   			$("#winner").html('');
		   		}
	   		}
	       	$("#" + cell).html(result.charAt(0));
		});
/*
		$.ajax({
		type: "post",
		url: "/winner",
		data:"cell=" + cell

	   	}).done(function(result){
	   		if(result == "true"){
	   			$("#winner").html('hallooo');
	   		}else {
	   			$("#winner").html('byeee');
	   		}
		});*/
	};
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


