/*!
* Start Bootstrap - Modern Business v5.0.5 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

function verificarRegistro() {
    //aqui habria que buscar en la BBDD el usuario y mirar si esta registrado
    var registro = true;
    
    if (registro === true) {
        location.href = 'ConfirmarCompra.html';
    } else {
        alert("Debe estar registrado para poder realizar esta opción");
    }
}