# MarvelApp

Aplicación para listar a todos los personajes de Marvel guardados en su base de datos

## Configuración

La app esta basada en MVVM y se pueden distinguir dos formas de desarrollo distintas. 
En la home como en la pantalla de detalle se utiliza viewBinding para el tratamiento de las vistas y para la pantalla de filtros se utilizan un estilo más clásico, creando variables para las vistas además de la utilización de fragmentos como la navegacion entre ellos, aunque al final solo haya quedado en uno.

La home tiene un paginado infinito por lo que se podrán ver todos los personajes existentes.

La pantalla de filtros la planteé de la misma manera pero finalmente decidí dejar una sola descarga de información para no sobre cargar de llamadas esa pantalla.

## Añadidos 

Se ha creado una pantalla de filtros donde se pueden elegir comics, eventos y series, los cuales se enviarán a la home para aplicar en la llamada de obtención de personajes 