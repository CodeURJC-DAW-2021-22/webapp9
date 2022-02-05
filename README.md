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

