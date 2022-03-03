/*!
* Start Bootstrap - Modern Business v5.0.5 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

/*$(document).ready(function () {
    $('#botonMasImagenes').click(function () {

        $('#botonMasImagenes').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        // On click, execute the ajax call.
        $.ajax({
            type: "GET",
            url: "/home/{id}/nuevasNoticias",
            dataType: 'json',
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#botonMasImagenes').removeClass('hidden');
            },
            success: function (data) {
                $("#masImagenes").fadeIn(1000).append(data);
            },
            complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
                $('#botonMasImagenes').addClass('hidden');
            },
        });
    });
});*/

$(document).ready(function() {    
    $('#botonMasImagenes').on('click', function(){
        //Añadimos la imagen de carga en el contenedor
        $('#botonMasImagenes').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
 
        $.ajax({
            type: "GET", //era un get
            url: "/home/{id}/nuevasNoticias",
            success: function(data) {
                //Cargamos finalmente el contenido deseado
                //$('#masImagenes').fadeIn(1000).html(data);
                $("#masImagenes").fadeIn(1000).append(data);
            },
        });
        return false;
    });              
});

function verifySignin() {
    //aqui habria que buscar en la BBDD el usuario y mirar si esta registrado
    var register = true;
    
    if (register === true) {
        location.href = 'paymentConfirmation.html';
    } else {
        location.href = 'errorMessage.html';
    }
}

// HAY Q REVISAR ESTA FUNCION PORQ NO HACE LO Q TIENE Q HACER
function buyProduct() {
    location.href = 'showVideogame.html';
    var comprado = true; //esta variable tendra q ser un atributo de la clase 'videojuego' o algo asi :(
    if (comprado === true) {
        document.getElementById("buyButton").innerHTML = "ADQUIRIDO";
    }
}

function changeData(){
    let input = getElementById("celdilla1");
    var x = input.placeholder;
    input.placeholder = x;
}

function alertDataChange(){
    alert("Los datos de usuario se han guardado")
}
