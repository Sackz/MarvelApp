# MarvelApp

Aplicaci�n para listar a todos los personajes de Marvel guardados en su base de datos

## Configuraci�n

La app esta basada en MVVM y se pueden distinguir dos formas de desarrollo distintas. 
En la home como en la pantalla de detalle se utiliza viewBinding para el tratamiento de las vistas y para la pantalla de filtros se utilizan un estilo m�s cl�sico, creando variables para las vistas adem�s de la utilizaci�n de fragmentos como la navegacion entre ellos, aunque al final solo haya quedado en uno.

La home tiene un paginado infinito por lo que se podr�n ver todos los personajes existentes.

La pantalla de filtros la plante� de la misma manera pero finalmente decid� dejar una sola descarga de informaci�n para no sobre cargar de llamadas esa pantalla.

## A�adidos 

Se ha creado una pantalla de filtros donde se pueden elegir comics, eventos y series, los cuales se enviar�n a la home para aplicar en la llamada de obtenci�n de personajes 