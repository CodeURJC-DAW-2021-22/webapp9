/*!
* Start Bootstrap - Modern Business v5.0.5 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

/*$(window).on("load", function(){
    $('#botonMasImaganes').on("click", aumentarPagina())
    $('#botonMenosImaganes').on("click", disminuirPagina())
})*/

var valorDePagina = -1;

$(document).ready(function() {    
    $('#botonMasImagenes').on('click', function(){
        //Añadimos la imagen de carga en el contenedor
        $('#loader').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        aumentar();
        $.ajax({
            type: "GET", //era un get
            url: '/home/' +  valorDePagina,
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#loader').removeClass('hidden');
            },
            success: function(data) {
                //Cargamos finalmente el contenido deseado
                //$('#masImagenes').fadeIn(1000).html(data);
                $("#masImagenes").fadeIn(1000).append(data);
            },
            complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
                $('#loader').addClass('hidden');
            },
        });
        //aumentar();
    });  
    $('#botonMenosImagenes').on('click', function(){
        //Añadimos la imagen de carga en el contenedor
        $('#loader').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        disminuir();
        $.ajax({
            type: "GET", //era un get
            url: '/home/' +  valorDePagina,
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#loader').removeClass('hidden');
            },
            success: function(data) {
                //Cargamos finalmente el contenido deseado
                //$('#masImagenes').fadeIn(1000).html(data);
                $("#masImagenes").fadeIn(1000).append(data);
            },
            complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
                $('#loader').addClass('hidden');
            },
        });
    });               
});


function aumentar(){
    valorDePagina += 1;
    return valorDePagina;
}

function disminuir(){
    valorDePagina -= 1;
    return valorDePagina;
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
