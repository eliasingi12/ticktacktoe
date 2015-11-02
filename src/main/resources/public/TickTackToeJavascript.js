$( function() {
    var thisID = $(this).attr('id');

    $('td').click( function() {
        if($(this).html()==""){
            $.ajax({
            type: "thisID",
            url: "/thisID",
            data:"thisID=" + thisID
           
           }).done(function(result){
               $(this).html(result);
        });
        };
        event.preventDefault();

        $(this).toggleClass("red-cell");
    } );
} );