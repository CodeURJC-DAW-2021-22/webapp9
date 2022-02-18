/*!
* Start Bootstrap - Modern Business v5.0.5 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

function verificarRegistro() {
    //aqui habria que buscar en la BBDD el usuario y mirar si esta registrado
    var registro = false;
    
    if (registro === true) {
        location.href = 'ConfirmarCompra.html';
    } else {
        location.href = 'mensajeError.html';
    }
}

// HAY Q REVISAR ESTA FUNCION PORQ NO HACE LO Q TIENE Q HACER
function comprarProducto() {
    location.href = 'VerVideojuego.html';
    var comprado = true; //esta variable tendra q ser un atributo de la clase 'videojuego' o algo asi :(
    if (comprado === true) {
        document.getElementById("botonCompra").innerHTML = "ADQUIRIDO";
    }
}