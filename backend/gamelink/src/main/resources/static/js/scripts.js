/*!
* Start Bootstrap - Modern Business v5.0.5 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project


$(document).ready(function () {

    $('#getDataBtn').click(function () {

        // On click, execute the ajax call.
        $.ajax({
            type: "GET",
            url: "https://forbes400.herokuapp.com/api/forbes400?limit=400",
            dataType: 'json',
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#loader').removeClass('hidden')
            },
            success: function (data) {
                // On Success, build our rich list up and append it to the #richList div.
                if (data.length > 0) {
                    let richList = "<ol>";
                    for (let i = 0; i < data.length; i++) {
                        console.log(data[i].uri);
                        richList += "<li>" + data[i].uri + "</li>";
                    }
                    richList += "</ol>"
                    $('#richList').html(richList);
                }
            },
            complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
                $('#loader').addClass('hidden')
            },
        });
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
