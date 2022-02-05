# Nombre de la aplicación web: 
GameLink

# Integrantes del equipo de desarrollo: 
| Nombre | Correo | Usuario GutHub |
| --- | --- | --- |
| Andrea Patricia Acuña Padrón | ap.acuna.2019@alumnos.urjc.es | andrecupa |
| Carlos Fuentes Díaz | c.fuentesd.2019@alumnos.urjc.es | Xarlifue360 |
| Jhostin Davis Ortiz Moreno | jd.ortiz.2019@alumnos.urjc.es | JhostinD | 
| Mani Víctor Patel Bentz | mv.patel.2019@alumnos.urjc.es | ultramani |
| Juan Luis Rico Rus | jl.rico.2019@alumnos.urjc.es | JLRR2019 |


# Herramienta de organización para el equipo:
Link Trello: 
* [Trello](https://trello.com/b/LKtXzdMY/organizaci%C3%B3n)

# Aspectos principales de la aplicación web:

## 1.ENTIDADES

La web consta de 4 entidades:
(A pesar de no ser necesario mencionar los atributos en la Fase 0, se van a mencionar los atributos que, a priori, se han pensado)

#### Usuario:
Nombre, apellidos, foto perfil, correo electrónico, ID, juegos comprados, noticias leídas.

#### Videojuego:
Nombre, descripción, puntuación, carátula, empresa, precio general, género.

#### Noticias:
Título, descripción, foto(opcional), autor.

#### CódigoCompra:
CódigoID, nombre videojuego, precio plataforma.

Relaciones de las entidades:
El usuario administrador puede publicar de 0 a infinitas noticias, videojuegos y códigos.
 El usuario administrador puede eliminar y/o modificar de 0 a infinitas noticias, videojuegos y códigos publicados previamente.
Una noticia tiene uno o varios videojuegos asociados.
Un códigoCompra es de un videojuego.
Un usuario registrado compra de cero a infinitos videojuegos.
Un usuario puede visualizar noticias y videojuegos.


## 2.PERMISOS DE LOS USUARIOS

(la Web tiene que estar diseñada para que ciertos usuarios sean dueños de ciertos datos, importante para implementar correctamente los mecanismos de seguridad adecuados)
Para exponer los permisos de los usuarios se expondrán los tipos de usuario que se contemplan en la web y la funcionalidad que cumplen en la misma. 

#### Cliente anónimo: 
Usuario que no necesita de credenciales para acceder a la web. Podrá visualizar las noticias y los videojuegos más populares (más visitados y mejor valorados), debido a que no tiene preferencias. 
Además, no tendrá posibilidad de realizar compras

#### Cliente registrado:
Usuario que necesita credenciales para acceder a la web. Podrá visualizar noticias y videojuegos en base a sus preferencias (compras y visualizaciones anteriores). También tendrá posibilidad de realizar compras en la web.
Además, tendrá la opción de modificar sus credenciales (Nombre, Tarjeta, Foto de perfil, correo electrónico).

####  Administrador:
Usuario que necesita credenciales para acceder a la web. Podrá crear nuevas noticias y subir nuevos videojuegos (con su código 	asociado) para el consumo posterior de los usuarios cliente. 
Además, tendrá la opción de eliminar y/o modificar las noticias y los videojuegos previamente publicados.

## 3.IMÁGENES

Debido a que se trata de una página con 3 tipos de usuarios (usuario no registrado, registrado y administrador) es necesario determinar las posibilidades que tiene cada usuario de poder actualizar y subir fotografías.

### Usuario anónimo: 
no tiene permiso para poder subir fotografías.

### Usuario registrado: 
podrá subir y actualizar su foto de perfil que le caracteriza.

### Usuario administrador: 
el usuario administrador podrá cambiar cualquier imágen de la página. Esto incluye su foto de perfil, imágenes asociadas a cualquier noticia, así como las carátulas de los videojuegos en venta. En definitiva, puede cambiar cualquier imágen de la página web (excepto imágenes de perfil de usuarios registrados).

## 4. GRÁFICOS

La página web contará con un gráfico de barras, el cual medirá el número de ventas de un videojuego a lo largo de los últimos meses. Tendrá un desplegable para seleccionar el videojuego deseado y ver sus ventas correspondientes, así como las ventas generales de todos los videojuegos de la web.

![](imagenes/grafico1.png)

También contará con un gráfico de sectores, que medirá los géneros de videojuegos más vendidos a lo largo del mes.

![](imagenes/grafico2.png)

## 5. TECNOLOGÍA COMPLEMENTARIA

1-PHPMailer
* Usamos PHPMailer para automáticamente mandar correos a los usuarios para verificar cada compra.
* [Link](https://github.com/PHPMailer/PHPMailer)
2-PSPDFKit API
* Usamos PSPDFKit para generar PDF conteniendo información relacionada con la compra de un usuario.
* [Link](https://pspdfkit.com/api/pdf-generator-api/?utm_source=google&utm_medium=paid_search&utm_campaign=api&utm_content=pdf-generation&utm_term=pdf%20generator%20api&gclid=CjwKCAiAl-6PBhBCEiwAc2GOVNUbRp1KtnHSWTmey5pwUE1ecnjAEe6iSfzhM2rQBNkAWvy9hXq_ShoC-LgQAvD_BwE)
3-PAYPAL Rest API
* Usamos como intermediario para los pagos de las compras los servicios de PayPal.
* [Link](https://developer.paypal.com/api/rest/)


## 6. ALGORITMO O CONSULTA AVANZADA

Principalmente existirán dos funcionalidades que implementan un algoritmo basado cada uno en diferentes datos de las entidades:
* Se implementará un sistema que ofrezca a los usuarios registrados videojuegos que puedan interesarles basados en su historial de compra. La decisión sobre qué juegos se muestran se hará en base al género de los videojuegos adquiridos por el usuario (atributo juegos comprados del usuario correspondiente).
* Se implementará un sistema que muestre una lista de los juegos más “populares”, lista que será actualizada semanalmente. Dicha “popularidad” se medirá en función de dos factores que se reflejarán en dos listas diferenciadas:
    * Número de ventas totales del juego en cuestión.
    * Valoración global del juego.  
Cabe destacar que las valoraciones deben de tener en cuenta el número de valoraciones que tenga el videojuego (no puede haber un juego con una valoración de 5 estrellas por encima de uno con miles de valoraciones con media de 4,5 estrellas).
