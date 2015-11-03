final TickTackToe tick = new TickTackToe();    
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

});


$(document).ready(function(){
    $("#test").click(function(e){
          e.preventDefault();
        $.ajax({type: "POST",
                url: "/winning",
                data: "winning=",
                success:function(result){
          $("#sharelink").html(result);
        }});
      });
    });


