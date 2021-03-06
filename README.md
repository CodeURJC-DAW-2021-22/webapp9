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

#### Usuario:
Id, nick, contraseña, tarjeta de crédito, Nombre, apellidos, foto perfil, correo electrónico, juegos comprados, noticias leídas.

#### Videojuego:
Id, Título, descripción, puntuación, carátula, empresa, precio, género, lista de noticias asociadas.

#### Noticias:
Id, Título, descripción, foto(opcional), autor, remesa, lista de videojuegos relacionados.

#### CódigoCompra:
Id, codigo de compra, nombre videojuego asociado, descuento.

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

La página web contará con un gráfico de barras, el cual medirá el número de ventas de un videojuego/barra, mostrando así todos los videojuegos.
Además constará de un gráfico de sectores, el cual mostrará las ventas por género a lo largo del tiempo. 

![](CapturasPantallasWEB/graficos.png)


## 5. TECNOLOGÍA COMPLEMENTARIA

1-PSPDFKit API (Por ejemplo, posteriormente se verá que tecnología usar concretamente)
* Necesario generar PDFs para contener información relacionada con la compra de un usuario.
* [Link](https://pspdfkit.com/api/pdf-generator-api/?utm_source=google&utm_medium=paid_search&utm_campaign=api&utm_content=pdf-generation&utm_term=pdf%20generator%20api&gclid=CjwKCAiAl-6PBhBCEiwAc2GOVNUbRp1KtnHSWTmey5pwUE1ecnjAEe6iSfzhM2rQBNkAWvy9hXq_ShoC-LgQAvD_BwE)


## 6. ALGORITMO O CONSULTA AVANZADA

Principalmente existirá una funcionalidad que implementa un algoritmo basado cada uno en diferentes datos de las entidades:
* Se implementará un sistema que ofrezca a los usuarios registrados videojuegos que puedan interesarles basados en su historial de compra. La decisión sobre qué juegos ha comprado el usuario previamente, concretamente con el genero del mismo. 
De esta forma se mostraran los videojuegos cuyo genero sea el mismo al genero mas comprado del usuario

## Descripción de cada una de las pantallas (FASE 1).
Destacamos que en la barra de navegación "Administrador" sólo será visible para el administrador tras acceder como tal.
1. Registro: la pantalla de registro ofrecerá la posibilidad, a los usuarios no registrados, de registrarse. Esto permitirá acceder a todas las funcionalidades personalizadas de la página: videojuegos y noticias por preferencias y comprar videojuegos.
![](CapturasPantallasWEB/registrarse.png)

2. Inicio de sesión: permite a los usuarios previamente registrados acceder a la página web con usuario.
![](CapturasPantallasWEB/login.png)

3. MenuHome: esta pantalla es principalmente la pantalla de bienvenida, con información general sobre noticias, compras y nuestro equipo, sin ahondar mucho en los detalles
![](CapturasPantallasWEB/main.png)

4.Videojuegos: en ella se muestra la lista de videojuegos disponibles en la página web: los más populares para usuarios no registrados y una lista personalizada para usuarios registrados. Si se pincha en un videojuego se redirigirá a la pantalla VerVideojuego.
![](CapturasPantallasWEB/videogames.png)
![](CapturasPantallasWEB/Videojuegos-Descubrir.png)

5. VerVideojuego es la pantalla que muestra en detalle la información de un videojuego y permite a los usuarios adquirir dicho videojuego por dinero.
![](CapturasPantallasWEB/showVideogame.png)

6. About es la pantalla donde se muestra la información relacionada al euqipo de desarrollo de la página web GameLink.
![](CapturasPantallasWEB/about.png)

7. VerNoticia: pantalla que permite ver con detalle cada noticia. Así como los videojuegos que la relacionan
![](CapturasPantallasWEB/showNews.png)

8. Noticias: pantalla que permite ver las noticias más destacadas del día, así como la opción de poder acceder a ellas para ver cada noticia en detalle si optamos por pinchar en ellas.
![](CapturasPantallasWEB/news.png)

9. Admin es la pantalla utilizada por los usuarios administradores para actualizar las noticias y videojuegos del catálogo. Además, se mostrarán los gráficos de las compras en la página web
![](CapturasPantallasWEB/admin.png)

9. Perfil es la pantalla en la que el usuario registrado podrá ver toda su información así como modificar los campos que le sean necesarios
![](CapturasPantallasWEB/perfil.png)

9. Confirmación compra es la pantalla en la que el usuario registrado podrá ver el monto a pagar y el videojuego seleccionado para poder confirmar o cancelar su pedido
![](CapturasPantallasWEB/ConfirmacionCompra.png)

10. Error compra y Error login son las pantallas de error correspondientes cuando el usuario no está registrado e intenta comprar y cuando las credenciales del login no son correctos respectivamente. 
![](CapturasPantallasWEB/errorCompra.png)
![](CapturasPantallasWEB/errorLogin.png)

11. Top videojuegos: pantalla que permite ver los videojuegos mas populares del momento en base a sus puntuaciones.
![](CapturasPantallasWEB/topVideogames.png)

## Diagrama de navegación (FASE 2)

![](CapturasPantallasWEB/DiagramaDeNavegacion.png)

## Instrucciones de Ejecución (Fase 2)

Para poder descargar el código del proyecto se debe acceder al GitHub, después pulsar el boton verde en el que pone CODE. Una vez lo hayamos pulsado aparecerá un desplegable en el que se tendrá la opción de descargar como ZIP.

El programa puede ser ejecutado tanto en Visual Studio Code como en SpringToolSuite4. Debido a que ha sido desarrollado en Visual Studio Code, las instrucciones serán para este entorno en concreto.

Para poder utilizar Visual Studio Code, deberemos dirigirnos a la página oficial y descargar el programa para el sistema operativo que se desee
![](CapturasPantallasWEB/DownloadVSCode.PNG)

La versión Java necesaria es la 17, a su vez requiere la versión PostgreSQL 6.4 y Maven 4.0.0.

Para poder usar Java y Maven, primero deberemos descargar las extensiones. El proceso será el siguiente:

Primero vamos al apartado "Extensions"


![](CapturasPantallasWEB/pluggins.PNG)


A continuación, debemos descargar el Extension Pack for Java y Spring Boot Extension Pack
![](CapturasPantallasWEB/Extensions.PNG)

Llegados a este punto necesitaremos descargar la base de datos. En este caso se ha usado PostgreSQL 6.4
![](CapturasPantallasWEB/PostgreSQLDownload.PNG)

Debemos crear un servidor en la base de datos.
![](CapturasPantallasWEB/ServerCreate.PNG)

El username y la password del servidor deben de ser los mismos que los que están en apartado application.properties. Además debemos configurar el puerto que vayamos a utilizar

![](CapturasPantallasWEB/ServerCreate2.1.PNG)
![](CapturasPantallasWEB/appproperties.PNG)

Para proceder a la ejecución del programa, primero se debe abrir la pestaña application.properties, de lo contrario no aparecerá el Spring Boot Dashboard (Instalado previamente mediante la extensión). Una vez abierta, se puede proceder a la ejecución del programa
![](CapturasPantallasWEB/SpringBoot.PNG)

# Diagrama de Clases (Fase 2)
![](CapturasPantallasWEB/diagramaClasesDAWFase2.png)
# Modelo  ER (Fase 2)
![](CapturasPantallasWEB/modeloERDAWFase2.png)
# Participación de miembros (Fase 2):

### Andrea Patricia Acuña Padrón
###### Descripción textual de las tareas realizadas en la fase: 
  - Login: Realización del login del usuario. Se debe comprobar que el usuario está en la base de datos y que los campos de nombre y contraseña coinciden. Además, si hay algún error como que no está el usuario en la base de datos saldrá una pantalla de error. 
  - Editar perfil usuario: Visualización de una pantalla del perfil del usuario con los datos del mismo. Además, se podrán modificar los campos del usuario así como la foto de perfil. Se contará con un botón para guardar los cmabios y otro para deshacer los mismos.
  - Gráfica de géneros: Consulta Query de los videojuegos vendidos por género y su visualización por gráfico en admin.html
  - Compra videojuego: Botón en cada uno de los videojuegos. Dicho botón redirige a un error si el usuario no está loggeado y a una pantalla de confirmación de compra si el usuario si está loggeado. Una vez comprado el videojuego, este pertenecerá al usuario apareciendole la compra en su perfil.

###### Listado de los 5 commits más significativos durante la fase:
 1. [Payment error id videogame](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/d14439a8e898589cee1edc0dfebf393c95931ebd)
 2. [Gráfica videojuegos genero terminada](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/5ad0b54b49bf4f347666071e44702ccffd7ea8af)
 3. [botón compra finalizado + pequeños arreglos estéticos](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/434c519edc1d4fdc92f0c623013520684dcfd985)
 4. [Modificar perfil](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/515c8b0e163bc34b55bb0439cbcda2237245e73f)
 5. [continuación del perfil](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/15f9aedc20dc3c69d736ea388c36e2a657766c4f)

###### Listado de los 5 ficheros en los que más haya participado:
1. [Login.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/login.html)
2. [UserProfile.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/userProfile.html)
3. [CSRFHandlerConfiguration.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Configuration/CSRFHandlerConfiguration.java)
4. [GamelinkController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/GamelinkController.java)
5. [UseroRepository.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Repositories/UseroRepository.java)

### Mani Victor Patel Bentz
###### Descripción textual de las tareas realizadas en la fase: 
- En esta fase me he encargado de implementar que se pueda crear/eliminar/editar videojuegos y noticias, templates y funciones de controlador. 
- Creado los templates y funciones de controlador para cargar de base de datos la información asociada a cada videojuego o noticia. 
- Implementado el protocolo https y agregado en el servicio de seguridad que dependiendo del rol de un usuario pueda o no acceder a ciertas URLs. 
- Implementado también el algoritmo de personalizado. 
- Ajustado nuestras relaciones entre entidades y lo que conlleva en el código. 
- Finalmente, algún hotfix me ha sido encargado.

###### Listado de los 5 commits más significativos durante la fase:

1. [Me he adelantado este commit no vale](https://github.com/CodeURJC-DAW-2021-22/webapp9/tree/544869dcfb29b2db7245287fb8dc071d8ba85d6e)
2. [Remove/Edit implemented, but Remove has errors](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/4176b34a9d399172164bf8545880c9134b6f7b73)
3. [Added games and news](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/46f85740e30eca420c4871ff7009868e0c058526)
4. [Various fixes, most important edit and create videogame/new works](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/c4de66fe183f8156e9b131917e98178b15f70c0f)
5. [Forms completed](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/5a065adb48ee5b4a2517ea4b8954a60e8fb57c40)

###### Listado de los 5 ficheros en los que más haya participado:

1. [GamelinkController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/GamelinkController.java)
2. [Videogame.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/tree/main/backend/gamelink/src/main/java/urjc/gamelink/Model)
3. [WebSecurityConfig.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Configuration/WebSecurityConfig.java)
4. [editNewForm.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/editNewForm.html)
5. [createVideogame.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/createNew.html)

### Carlos Fuentes Díaz
###### Descripción textual de las tareas realizadas en la fase:
- Templates mensaje de error al comprar un juego y confirmar compra: creación de las templates para el mensaje error y la confirmación de la compra
- Inicializar la BBDD: Se han introducido a la base de datos los 20 primeros videojuegos y las 20 primeras noticias de la página web.
- Estética de la página web: En este apartado se ha mejorado la estética general de toda la página web, ya sean los colores, texto o que la página web sea más atractiva a la vista.
- Hacer un navegador más dinámico: Cuando estas registrado como usuario no registrado, como usuario o como administrador, que en el navegador de la página web se muestren las pestañas que les corresponda a cada uno
- Grafica de videojuegos vendidos: Consulta Query de todos los videojuegos vendidos y su visualización por grafico en admin.html

###### Listado de los 5 commits más significativos durante la fase:
1. [1ºparte de verificacionCompra/mensaje de error](https://github.com/CodeURJC-DAW-2021-22/webapp9/tree/e271495aec51c17330652f6896364e8949936512)
2. [cambiado a ingles](https://github.com/CodeURJC-DAW-2021-22/webapp9/tree/5af0efce13629c127dc1457c634fc692b75d75cb)
3. [actualizar bbdd videojuegos 1ºparte](https://github.com/CodeURJC-DAW-2021-22/webapp9/tree/c06c23ecd9663ef69334d2a0d4817c601d87c1de)
4. [actualizar bbdd terminado](https://github.com/CodeURJC-DAW-2021-22/webapp9/tree/f979fb0ff7cddde61fb0a6f6e4262f8d482f88ad)
5. [grafica de juegos vendidos TERMINADO](https://github.com/CodeURJC-DAW-2021-22/webapp9/tree/abd347d402fbfe69e3c4a69cd4fe9022ebc2a0bf)

###### Listado de los 5 ficheros en los que más haya participado:
1. [styles.css](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/css/styles.css)
2. [paymentConfirmation.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/paymentConfirmation.html)
3. [bdinit.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Service/dbInit.java)
4. [scripts.js](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/js/scripts.js)
5. [GamelinkController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/GamelinkController.java)

### Juan Luis Rico Rus
###### Descripción textual de las tareas realizadas en la fase:
- Paginación: Todas las tareas para realizar la paginación de manera correcta. 
- Puntuación: Incorporación del sistema de puntuación para los videojuegos (Pendiente de subir al main en Juan-Deprecated)
- Pequeñas cosas como mejora: incorporación del navBar con moustache, incorporación de atributos a las entidades para el uso de las estrellas, cualquier arreglo, etc.
###### Listado de los 5 commits más significativos durante la fase:
1. [avance paginacion pero no funciona](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/b2417175fbfe16eff11043bd4c67c80fd33fd07d)
2. [pequeño avance, al menos cambia los elementos al pasar de pagina](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/a1365abc4bc88003b506098a0a0b23038b9d0b86)
3. [paginacion con ajax casi hecha](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/22dcaf450309e819dd3afac3023b1695512bf651)
4. [Ya funciona, no esta ni mucho menos perfecto pero ya funciona](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/e2ae0ead821cf8d39e4bdd6dd02013716e3dc75b)
5. [Puntuaciones medias funcionando (tienen un pequeño error tengo que solucionarlo)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/6584457312bb9d9460ea6af6000192bc44d521e2)

###### Listado de los 5 ficheros en los que más haya participado:
1. [GamelinkController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/GamelinkController.java)
2. [scripts.js](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/js/scripts.js)
3. [styles.css](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/css/styles.css)
4. [showVideogame.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/showVideogame.html)
5. [videogame](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/videogame.html)

### Jhostin Davis Ortiz Moreno
###### Descripción textual de las tareas realizadas en la fase:
- Registro: Formulario para guardar nuevos usuarios. Implementado con ciertas medidas de seguridad para no guardar usuarios sin credenciales en la BD.
- Algoritmo de consulta avanzada: Query SQL para recomendar juegos a los usuarios registrados en función de los géneros de los videojuegos que ya hayan comprado.
- Header y Footer unificados con mustache: Header y Footer implementados en forma de templates .html que se incrustarán mediante mustache en el resto de páginas html.
- Creación de las entidades: Creación de las clases que actuarán como entidades en la BD.
- Configuración inicial del proyecto con Maven: configurado el proyecto mediante plantilla Maven. pom.xml dentro de carpeta backend.

###### Listado de los 5 commits más significativos durante la fase:
1. [Primer avance algoritmo consulta avanzada](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/4043b4dcd82030654058ac1554cc5d9fedfa5fee)
2. [Usuarios Nuevos se crean correctamente (Falta formulario con js correctamente implementado)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/1c04924ea917ab3f1496572cbe80a69c46e1b2a3)
3. [Header y Footer genéricos en todas las páginas](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/731925a234f137817f699a8f0ff3f0dc03da120d)
4. [Carpeta backend](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/94b5cc989115249cef59a5bbf961db7c52d66a52)
5. [Primera versión entidades](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/159fd74109c92898ec25c4fbd5197004af544a21)

###### Listado de los 5 ficheros en los que más haya participado:
1. [script.js](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/js/scripts.js)
2. [Usero.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Model/Usero.java)
3. [GamelinkController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/GamelinkController.java)
4. [Videogame.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Model/Videogame.java)
5. [VideogameRepository.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blame/main/backend/gamelink/src/main/java/urjc/gamelink/Repositories/VideogameRepository.java)

# Documentación de la API REST(Fase 3)

## URL Aplicación en Heroku
- [Aplicación en Heroku](https://codeurjc-daw-2021-22-webapp9.herokuapp.com/)

## Especificación openAPI
- [archivo yaml](backend/gamelink/api-docs/api-docs.yaml)

## Documento HTML
- [enlace](https://rawcdn.githack.com/CodeURJC-DAW-2021-22/webapp9/7c9569b82c7b36f569e645f98066d7feb7ca2c81/backend/gamelink/api-docs/api-docs.html)

## Instrucciones de ejecución de la aplicación dockerizada
#### Para poder hacer uso del docker-compose.yml será necesario:

- tener instalado Docker desktop: [enlace docker desktop](https://docs.docker.com/desktop/windows/install/)
- Tener clonado el repositorio github: [enlace repositorio github](https://github.com/CodeURJC-DAW-2021-22/webapp9)

#### Una vez se tienen instalados los requisitos previos:

- Se entrará a la bash del SO y se posicionará en la carpeta donde estén los archivos  dockerfile y docker-compose mediante el comando cd 
Tal y como se puede observar en la imagen
![](CapturasPantallasWEB/cmdDockerFile.png)

- Una vez situados correctamente se ejecutará el siguiente comando: docker-compose up

#### Una vez ejecutado el comando y construida la imagen, el usuario podrá acceder mediante la url:
(https://localhost:8443)

## Publicación de la imagen en DockerHub y descarga

Para poder publicar una imágen en DockerHub, primero debemos dirigirnos a la carpeta donde este docker y docker-compose en nuestra aplicación:
![](CapturasPantallasWEB/dockerPath.PNG)

Una vez estemos en el directorio correcto, debemos ejecutar el siguiente comando para construir la imágen:
![](CapturasPantallasWEB/dockerBuild.PNG)

A continuación, debemos pushear la imágen al repositorio para que pueda ser descargada:
![](CapturasPantallasWEB/dockerPush.PNG)

Como se puede observar, se ha creado correctamente el repositorio con la imágen:
![](CapturasPantallasWEB/dockerHubRepository.PNG)

El siguiente paso es pullear la imágen del repositorio, para ello se utiliza el comando que se indica en el repositorio:
![](CapturasPantallasWEB/dockerHubPullCommand.PNG)

Una vez hemos realizado este paso, debemos comprobar que se ha pulleado correctamente a nuestra aplicación de docker. Para ello, debemos dirigirnos a la pestaña de imágenes.
![](CapturasPantallasWEB/imageDownloaded.PNG)

Finalmente, debemos establecer en nuestro archivo docker-compose.yml que el nombre de la imágen sea el mismo que el que nos indica DockerHub:
![](CapturasPantallasWEB/imageName.PNG)

## Instrucciones para despliegue en Heroku

Para poder desplegar una aplicación en heroku, primero es necesario crearse una cuenta en heroku e instalar el cliente para terminal.

Una vez hecho esto, necesitamos cambiar en application.properties el valor de server.port:
![](CapturasPantallasWEB/HerokuServerPort.png)

También tenemos que cambiar las dependencias del pom.xml y limitar la memoria a 512Mb:
![](CapturasPantallasWEB/HerokuMemory.png)

También necesitamos una nueva clase que se encargue de la configuración de la base de datos:
![](CapturasPantallasWEB/HerokuDB.png)

Una vez hecho esto, abrimos una terminal en el directorio de nuestra app y nos logueamos con $heroku login.

Para la creación de la app en Heroku usamos el comando:
![](CapturasPantallasWEB/HerokuCreate.png)

Usamos $heroku container:login para que docker pueda subir imágenes a heroku (sólo se hace una vez)

Una vez hecho esto, ejecutamos la siguiente serie de comandos:
![](CapturasPantallasWEB/HerokuDeploy.png)

Para desactivar los certificados usamos el comando $heroku config:set SERVER_SSL_ENABLED=false --app codeurjc-daw-2021-22-webapp9

Para añadir una base de datos usamos $heroku addons:create heroku-postgresql --app codeurjc-daw-2021-22-webapp9

# Diagrama de Clases (Fase 3)
![](CapturasPantallasWEB/diagramaDeClases.png)

# Participación de miembros (Fase 3):

### Andrea Patricia Acuña Padrón
###### Descripción textual de las tareas realizadas en la fase: 
  - Dockerizar la aplicación creando los archivos necesarios y probando los diversos mandatos
  - Creación de la imagen junto con mi compañero Juan Luis Rico Rus
  - Arreglar gráficas dinámicas
  - Creación de la página de error: URL no válida
  

###### Listado de los 5 commits más significativos durante la fase:
 1. [inicio dockerfile y docker-compose](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/fb768e2b54671848b0149da624e05a6513aec17c)
 2. [dockerfile y docker-compose avance](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/4f97a8b2265d0fcad08adad98588045f33c5810d)
 3. [fixed graphics by andrecupa](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/9d4580d7e75912d7f673ca29c8c7a8f64ba08d2a)
 4. [página error URL no válida](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/3e48d44bffc134a4a78a976f928bc0d8ec136413)
 5. [cambios de arreglos](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/8bacc5a76395e5db2a0a0d0367f08b89c93bdbab)

###### Listado de los 5 ficheros en los que más haya participado:
1. [Docker-compose.yml](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/Docker-compose.yml)
2. [Dockerfile](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/Dockerfile)
3. [pom.xml](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/pom.xml)
4. [error.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/Andrea/backend/gamelink/src/main/resources/templates/error.html)
5. [scripts.js](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/js/scripts.js)

### Mani Victor Patel Bentz
###### Descripción textual de las tareas realizadas en la fase:
 
- Desarrollado la api rest al completo, dividido en los distintos controladores rest.
- Testeado y generado el postman_collections.
- Agregado las dependecias y generado la carpeta api-docs.
- Integrado seguridad a los controladores rest y configurado las urls para evitar exploits.
- Realizado algún hotfix que me ha sido encargado.

###### Listado de los 5 commits más significativos durante la fase:

1. [Divided the rest controller and some adds](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/178bb3a704d9fcf711c7a4fd169678c606b6eab8)
2. [Added new methods, will separate in different rest controller](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/6a4bacb119377d0f487d0056445ed8809fa933ed)
3. [Fixes in the RestAPi](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/fc9dd084679c992376ec92d8e8b0c05865c41946)
4. [Rest apis fixed and added some new methods, postman collection added. Fixed querys.](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/cb1a08af9e26cf55e5b1a28b25ddc8695ba8fdc5)
5. [New urls security rules](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/4d90b1b05e54f2ba8820c00aeaf28eb49da7fc59)

###### Listado de los 5 ficheros en los que más haya participado:

1. [VideogamesRestController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/VideogamesRestController.java)
2. [UserRestController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/UserRestController.java)
3. [NewsRestController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/NewsWebController.java)
4. [LoginRestController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/LoginRestController.java)
5. [RestSecurityConfig.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Configuration/Security/RestSecurityConfig.java)

### Juan Luis Rico Rus
###### Descripción textual de las tareas realizadas en la fase:
- He dockerizado y creado la imágen de la aplicación junto con Andrea Patricia Acuña Padrón.
- He participado en Postman junto con mi compañero Carlos Fuentes en la parte de Login.
- He realizado las tareas necesarias para la incoporación de la tecnologia complementaria.

###### Listado de los 5 commits más significativos durante la fase:
1. [Dockerfile y docker-compose (no funciona aun)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/a364bd1918e1972ab4c61d957e82299f7e42e326) 
2. [Cambio a login rest controller](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/efeb21e825a396134cc16340298df5ec40d4a49e)
3. [Ajustes realizados en clase](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/c0ea1eeca5b1ddd2dbe6d0b33deb3974d9cb0f56)
4. [boton de descargar PDF (como no, no funciona, no lo reconoce pero bueno mañana lo soluciono)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/725b1f9c95a1255f97b045181b4a4defafa2b27a)
5. [generador de pdfs completo](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/4dd4102f346d43394c0228e0f703a373b8aafec4)

###### Listado de los 5 ficheros en los que más haya participado:
1. [Dockerfile](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/Dockerfile)
2. [Docker-compose.yml](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/Docker-compose.yml)
3. [scripts.js](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/js/scripts.js)
4. [paymentConfirmation.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/templates/nextPageTemplate.html)
5. [pom.xml](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/pom.xml)

### Carlos Fuentes Díaz
###### Descripción textual de las tareas realizadas en la fase:
- Separacion del controlador principal en controladores mas pequeños junto con Jhostin David Ortiz Moreno.
- Participado en Postman junto con mi compañero Juan Luis Rico Rus en la parle de Login.
- Actualizar el diagrama de clases.
- Correccion de pequeños errores.

###### Listado de los 5 commits más significativos durante la fase:
1. [division del controller (parte news)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/49eaaa364af202f595d2e48080ac8cd2fd0320ca)
2. [division del controller (parte usero)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/69a2fc7415fea1e2ff56e865baaa00d5356259f2)
3. [mini cambio](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/c44a02f24e688b365ed8ee99e33785ba9f4dc934)
4. [Update README.md](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/7b787f12a83d84d40f33d0a0dfe0c2c1d51c2148)
5. [mini cambio](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/c44a02f24e688b365ed8ee99e33785ba9f4dc934)

###### Listado de los 5 ficheros en los que más haya participado:
1. [UseroWebController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/UseroWebController.java)
2. [NewsWebController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/NewsWebController.java)
3. [Docker-compose.yml](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/Docker-compose.yml)
4. [GamelinkWebController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/GamelinkWebController.java)
5. [scripts.js](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/resources/static/js/scripts.js)

### Jhostin Davis Ortiz Moreno
###### Descripción textual de las tareas realizadas en la fase: 
  - Despliegue de la aplicación en heroku
  - Separación del controlador web (GamelinkController) en diferentes clases para mejor estilo del código.
  - Arreglo de errores en la página web (imágenes por defecto en nuevos usuarios, visualización de nuevas noticias creadas por el admin, eliminación de imports no usados)
  

###### Listado de los 5 commits más significativos durante la fase:
 1. [arreglado estilo código (Imports no usados fuera)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/3a7dd9e8bdcd27eeb47fc910a402f083548e8096)
 2. [nuevo controlador web videogame](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/5c16ffe6b7371249e05ce5d183475c1bb46ffd81)
 3. [Arregladas imágenes por defecto de nuevos usuarios](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/80734f79375c7f9c1b3fb78d907411a62c6f0ed2)
 4. [scripts heroku en main](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/6bf3ec5903df7dc184387d554ea9832b5bace9ec)
 5. [primera version controlador por entidad](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/7363714f3115a2c4344abfd4af623ae74a5cff8f)

###### Listado de los 5 ficheros en los que más haya participado:
1. [create_heroku_app.sh](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/create_heroku_app.sh)
2. [deploy_heroku_app.sh](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/deploy_heroku_app.sh)
3. [DatabaseConfig.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/DatabaseConfig.java)
4. [VideogameWebController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/VideogameWebController.java)
5. [UseroWebController.java](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/backend/gamelink/src/main/java/urjc/gamelink/Controllers/UseroWebController.java)

## Tecnología complementaria (Recuperación de la fase 2)
Dadas las multiples opciopnes de tecnología complementaria a incorporar, hemos decidido implementar un sistema de generación de PDFs para que el usuario pueda obtener un PDF de la factura que recibe al comprar un videojuego.

La generación del PDF se realiza mediante la libreria html2pdf, con su archivo js correspondiente. No ha sido incoporado en la API Rest, dado que todas las acciones de realizan en el Frontend. He aquí el tutorial que ha sido usado: https://parzibyte.me/blog/2020/09/05/html-pdf-javascript/

El procedimiento para generar un PDF es el siguiente:

Primero debemos logearnos como usuario (también valdría como administrador)
![](CapturasPantallasWEB/userLogin.PNG)

A continuación, debemos dirigirnos a la sección de videojuegos y presionar descubrir para visualizar los videojuegos. 
![](CapturasPantallasWEB/discoverVideogame.PNG)

Una vez se haya seleccionado un videojuego, se deberá pulsar la opción de comprar. 
![](CapturasPantallasWEB/buyVideogame.PNG)

A continuación nos saldrá la factura y podremos descargarla. La imágen siguiente muestra el PDF de la factura una vez se realiza la descarga.
![](CapturasPantallasWEB/PDFDownloaded.PNG)

# Implementación de la web con arquitectura SPA (Fase 4)

## Instrucciones para ejecutar la aplicacion SPA

Lo primero que debemos hacer, será instalar Node en nuestro dispositivo. Para ello, nos dirigiremos a la aplación de Node y la descargaremos.
![](CapturasPantallasWEB/DescargaNode.PNG)

A continuación, deberemos instalar @angular/cli
![](CapturasPantallasWEB/AngularCli.PNG)

El siguiente paso será hacer npm install para que se instale la carpeta node modules, el cual tiene las dependencias necesarias para que nuestra apliación SPA funcione correctamente. Deberemos hacer este comando en nuestra carpeta frontend (previamente creada).
![](CapturasPantallasWEB/npmInstall.PNG)

Como podemos observar, se ha instalado la carpeta node_modules.
![](CapturasPantallasWEB/nodeModules.PNG)

Nuestro siguiente paso será crear una carpeta llamada proxy.conf.json, la cual permitirá acceder a nuestro backend desde el frontend para obtener ls datos. Deberemos configurarla adecuadamente con la dirección ip y el puerto que esté configurado en el backend.

![](CapturasPantallasWEB/proxy.PNG)

El siguiente paso será inicializar el backend.

![](CapturasPantallasWEB/inicializarBackend.PNG)

Por último deberemos hacer ng serve (con el proxy) para lanzar nuestra apliación SPA

![](CapturasPantallasWEB/ngServeProxy.PNG)

![](CapturasPantallasWEB/ejecucion.PNG)


# Diagrama de clases y templates de la SPA
![](CapturasPantallasWEB/ImagenUMLAngular.png)

# Participación de miembros (Fase 4):

### Andrea Patricia Acuña Padrón
###### Descripción textual de las tareas realizadas en la fase: 
  - Desarrollo del login en frontend. Así ha desarrollado el componente (html y ts) del login.
  - Desarrollo del registro en frontend. Así ha desarrollado el componente (html y ts) del registro.
  - Desarrollo del perfil de usuario en frontend. Así ha desarrollado el componente (html y ts) del signUp.
  - Subida de imagenes en el perfil del usuario. 

###### Listado de los 5 commits más significativos durante la fase:
 1. [User profile + cambios en componentes](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/71cf65ad533a69c2e14dc37d6509adc44da790c0)
 2. [arreglar carpetas + signUp componente](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/cf7716f3d4f29b9b8ece6a92b6caeb5bb805bcef)
 3. [userProfile avanzado y pequeños cambios](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/a5698edba8cb65efeba1a4e345e93965d9239852)
 4. [home component + algunos cambios](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/9f81e242a3411410ab4b5d89b87580cfc8be1734)
 5. [login asociado a user profile funciona](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/bad7e16839e1088a5b5284b7de9aa0c4cae96619)

###### Listado de los 5 ficheros en los que más haya participado:
1. [login.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/login/login.component.ts)
2. [signUp.component.ts ](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/login/signUp.component.ts)
3. [userProfile.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/user/userProfile.component.ts)
4. [userProfile.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/user/userProfile.component.html)
5. [signUp.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/login/signUp.component.html)

### Juan Luis Rico Rus
###### Descripción textual de las tareas realizadas en la fase:
  - He realizado las tareas correspondientes para la realización de la parte de las noticias de la página web, a su vez que la parte de administrador para la modificación de las noticias.
  - He realizado tareas menores, como ayudar a mis compañeros en lo que necesitasen o adecuar las direciones en app.routing, app.module, etc

###### Listado de los 5 commits más significativos durante la fase:
1. [editNew y editNewForm acabados](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/7803980f8d09f93d4baa18ed2dda8b72ded9f343) 
2. [News, news template y showvideogame (sin la parte de mani) y sin paginacion completa](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/0ffa4b161fb353b29d2817e826360e8e4048d77d)
3. [showNews a la espera del tempalte de mani. Head component, no header (fallo mio)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/06339c46342e54e2af8578ca4bb552dbd17d3127)
4. [newsTemplate a priori completado con Carlos Fuentes](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/f2e24605df9f24b7a29c1dd1393c8b04295a6fdd)
5. [Paginación aplicada al home](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/00cae42cec25a387c14c379b39819def760873bc)

###### Listado de los 5 ficheros en los que más haya participado:
1. [news.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/JuanFase4/frontend/src/app/components/news/news.component.ts)
2. [newsTemplate.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/JuanFase4/frontend/src/app/components/news/newsTemplate.component.ts)
3. [showNews.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/JuanFase4/frontend/src/app/components/news/showNews.component.ts)
4. [editNewForm.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/JuanFase4/frontend/src/app/components/Admin/editNewForm.component.html)
5. [editNewForm.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/JuanFase4/frontend/src/app/components/Admin/editNewForm.component.ts)

### Mani Victor Patel Bentz
###### Descripción textual de las tareas realizadas en la fase:
 
- Desarrollado los componentes y servicios de los videojuegos.
- Implementado los modelos.
- Implementado editar y eliminar videojuegos.
- Controladore SPA
- Arreglos menores.

###### Listado de los 5 commits más significativos durante la fase:

1. [Frontend included in the backend server done](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/c9ef9323768060a3fde5a863eabce5f240ba96e9)
2. [Added juans](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/4d7083d6f3f3bd52ab504a5a1a108738acdd60a8)
3. [a]( https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/9246af595a9a841f3e54f9f6c1da0cb87d0202e3)
4. [Pagination added](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/36679bdeaeb22b00e40909443fb247912fd9a8a1)
5. [Added the card catalog compoenents](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/8c67588fa54358ff4f6eaa4fda9fa59298e9a8cc)

###### Listado de los 5 ficheros en los que más haya participado:

1. [videogame-catalog.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/videogame/videogame-catalog.component.ts)
2. [videogame-catalog.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/videogame/videogame-catalog.component.html)
3. [videogame-card.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/videogame/videogame-card.component.ts)
4. [videogame-card.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/videogame/videogame-card.component.html)
5. [videogame-detail.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/videogame/videogame-detail.component.html)

### Carlos Fuentes Díaz
###### Descripción textual de las tareas realizadas en la fase:
 
- Implementacion de los servicios (videogame y news)
- Desarrollo de la creacion de noticias y videojuegos
- desarrollo de administrador
- Arreglos menores

###### Listado de los 5 commits más significativos durante la fase:

1. [createNew y createVideogame funcionan (excepto imagenes)](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/ad1b1d513815256e72c71016dd7d4cad333829b5)
2. [createNew -> no funka](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/4c6343638f17c62bc80232261a2824aac413f6e6)
3. [createNew.component 1ºparte](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/26f9073937b84f537fe55044ae4fe21e56d9e3e9)
4. [admin hecho](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/2d0219ef9a875ddb88a6cabb1a06c27e9ee4eb56)
5. [videogame.service a medio crear](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/a82a7913a6742fce37fe15faf7b0dbb780db5bc7)

###### Listado de los 5 ficheros en los que más haya participado:

1. [news.service.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/services/news.service.ts)
2. [videogame.service.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/services/videogame.service.ts)
3. [admin.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/admin/admin.component.html)
4. [createNewForm.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/admin/createNewForm.component.ts)
5. [createVideogameForm.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/admin/createVideogameForm.component.ts)

### Jhostin Davis Ortiz Moreno
###### Descripción textual de las tareas realizadas en la fase:
 
- Registro y login de frontend, docker.

###### Listado de los 5 commits más significativos durante la fase:

1. [Registro usuario funciona (fix backend + servicio user)
 main](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/6d1c8409952bd8d432842b05170c06737209598d)
2. [videogames recommendations working](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/5326ceb9b76e8cf80fe1ecdf216c811dd535b8e5)
3. [navBar fixed + login + signup fixed](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/d99504ae430c18b487c3026375e6863cfb66367e)
4. [usero service finished](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/fddcc560694b7654e7b92b1e2a90ad5c352676f5)
5. [fixed recursion in home.component.html](https://github.com/CodeURJC-DAW-2021-22/webapp9/commit/ee1f96c7e0e93fafc2518fc5b39fa24250d26478)

###### Listado de los 5 ficheros en los que más haya participado:

1. [usero.service.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/services/usero.service.ts)
2. [videogame-recommended.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/videogame-recommended/videogame-recommended.component.ts)
3. [userProfile.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/user/userProfile.component.ts)
4. [signUp.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/login/signUp.component.ts)
5. [login.component.ts](https://github.com/CodeURJC-DAW-2021-22/webapp9/blob/main/frontend/src/app/components/login/login.component.ts)

# Video explicatorio de la web:
[enlace al video](https://youtu.be/ZdLNaKrbSrQ)
