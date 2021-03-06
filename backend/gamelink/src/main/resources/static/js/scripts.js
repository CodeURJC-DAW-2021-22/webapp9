/*!
* Start Bootstrap - Modern Business v5.0.5 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

var pageValueNews = 0;
var pageValueVideogames = 0;
var pageValueRecommendedGames = 0;



document.addEventListener("DOMContentLoaded", () => {
    const $boton = document.querySelector("#generatePDF");
    $boton.addEventListener("click", () => {
        const $elementoParaConvertir = document.body; // <-- Here you can choose any element of the DOM
        html2pdf()
            .set({
                margin: 1,
                filename: 'documento.pdf',
                image: {
                    type: 'jpeg',
                    quality: 0.98
                },
                html2canvas: {
                    scale: 3, // Larger scale, better graphics, but more weight
                    letterRendering: true,
                },
                jsPDF: {
                    unit: "in",
                    format: "a3",
                    orientation: 'portrait' // landscape o portrait
                }
            })
            .from($elementoParaConvertir)
            .save()
            .catch(err => console.log(err));
            
    });
});

$(document).ready(function() {    
    $('#moreImagesButton').on('click', function(){
        
        $('#loader').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        increaseNews();
        $.ajax({
            type: "GET", 
            url: '/news/' +  pageValueNews,
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#loader').removeClass('hidden');
            },
            success: function (data) {
                //We finally load the desired content
                //$('#moreImgages').fadeIn(1000).html(data);
                $("#moreImages").fadeIn(1000).append(data);
            },
            complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
                $('#loader').addClass('hidden');
            },
        });
    });
});

$(document).ready(function() {    
    $('#moreRecomendedVideogame').on('click', function(){
        
        $('#loader').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        increaseRecommendedVideogames();
        $.ajax({
            type: "GET", 
            url: '/videogameStatistics/' +  pageValueRecommendedGames,
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#loader').removeClass('hidden');
            },
            success: function (data) {
                $("#moreImages").fadeIn(1000).append(data);
            },
            complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
                $('#loader').addClass('hidden');
            },
        });
    });
});

$(document).ready(function () {
    $('#moreVideogamesButton').on('click', function () {
        //A??adimos la imagen de carga en el contenedor
        $('#loader').html('<div class="loading"><img src="Photos/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        increaseVideogames();
        $.ajax({
            type: "GET", //era un get
            url: '/videogames/' + pageValueVideogames,
            beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
                $('#loader').removeClass('hidden');
            },
            success: function (data) {
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


function increaseNews() {
    pageValueNews += 1;
    return pageValueNews;
}

function increaseVideogames() {
    pageValueVideogames += 1;
    return pageValueVideogames;
}

function increaseRecommendedVideogames() {
    pageValueRecommendedGames += 1;
    return pageValueRecommendedGames;
}

function verifySignin() {
    principal = request.getUserPrincipal();

    if (getUserPrincipal() === true) {
        location.href = '/paymentConfirmation';
    } else {
        location.href = '/errorMessage';
    }
}


function alertDataChange() {
    alert("Los datos de usuario se han guardado")
}

var check = function () {
    if (document.getElementById('inputPassword1').value ==
        document.getElementById('inputPassword2').value) {
        document.getElementById('passwordMessage').style.color = 'green';
        document.getElementById('passwordMessage').innerHTML = 'contrase??as coinciden';
        document.getElementById('createUserBtn').disabled = false;
    } else {
        document.getElementById('passwordMessage').style.color = 'red';
        document.getElementById('passwordMessage').innerHTML = 'contrase??as no coinciden';
        document.getElementById('createUserBtn').disabled = true;
    }
  }

  $(document).ready(function () { 
    $('#myChart').ready(function () { 

        var games = [];
        var solds = [];

        $.ajax({
            type: "GET",
            url: '/api/videogames/stats/sales',
            success: function (data) {

                for (let item of data) {
                    games.push(item[0])
                    solds.push(item[1])
                }

                var ctx = document.getElementById("myChart");
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: games,
                        datasets: [{
                            label: 'n?? de ventas',
                            data: solds,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    }
                });
            },
        });
    })
})

  $(document).ready(function () { 
    $('#myChartSoldGenre').ready(function () { 

        var games1 = [];
        var solds1 = [];

        $.ajax({
            type: "GET",
            url: '/api/videogames/stats/genres',
            success: function (data) {

                for (let item of data) {
                    games1.push(item[0])
                    solds1.push(item[1])
                }

                var ctx = document.getElementById("myChartSoldGenre");
                var myChartSoldGenre = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: games1,
                        datasets: [{
                            label: 'n?? de ventas',
                            data: solds1,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)', 
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)',
                                'rgba(0, 0, 0, 0.2)',
                                'rgba(255, 0, 0, 0.2)',
                                'rgba(255, 255, 0, 0.2)',
                                'rgba(0, 255, 0, 0.2)',
                                'rgba(128, 0, 128, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(0, 0, 0, 1)',
                                'rgba(255, 0, 0, 1)',
                                'rgba(255, 0, 04, 1)',
                                'rgba(255, 255, 0, 1)',
                                'rgba(0, 255, 0, 1)',
                                'rgba(128, 0, 128, 1)'
                            ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    }
                });
            },
        });
    })
})
