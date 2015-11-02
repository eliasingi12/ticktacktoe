$( function() {
    var thisID = $(this).attr('id');

    $('td').click( function() {
      $(this).toggleClass("red-cell");
    } );
} );
