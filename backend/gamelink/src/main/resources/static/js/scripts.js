/*!
* Start Bootstrap - Modern Business v5.0.5 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

var pageValue = -1;

$(document).ready(function() {    
    $('#moreImagesButton').on('click', function(){
        //Añadimos la imagen de carga en el contenedor
        $('#loader').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        increase();
        $.ajax({
            type: "GET", //era un get
            url: '/home/' +  pageValue,
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#loader').removeClass('hidden');
            },
            success: function(data) {
                //Cargamos finalmente el contenido deseado
                //$('#masImagenes').fadeIn(1000).html(data);
                $("#moreImages").fadeIn(1000).append(data);
            },
            complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
                $('#loader').addClass('hidden');
            },
        });
    });               
});


function increase(){
    pageValue += 1;
    return pageValue;
}



function verifySignin() {
    //aqui habria que buscar en la BBDD el usuario y mirar si esta registrado
    var register = true;
    
    if (register === true) {
        location.href = 'paymentConfirmation.html';
    } else {
        location.href = 'errorMessage.html';
    }
}


function alertDataChange(){
    alert("Los datos de usuario se han guardado")
}
