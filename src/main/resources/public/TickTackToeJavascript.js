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
	       //is_game_over();
		});
	};
	$(this).toggleClass("red-cell");
	event.preventDefault();
	
    });

});


function myFunction() {
	$.ajax({
		type: 'post',
	    url: '/newGame'
	}).done(function(result){
		$("#again").html('start again');
	});
}
