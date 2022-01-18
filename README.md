# MarvelApp

Aplicacion para listar a todos los personajes de Marvel guardados en su base de datos

## Configuración

La app esta basada en MVVM y se pueden distinguir dos formas de desarrollo distintas. 
En la home como en la pantalla de detalle se utiliza viewBinding para el tratamiento de las vistas y para la pantalla de filtros se utilizan un estilo mas clasico, creando variables para las vistas además de la utilización de fragmentos como la navegacion entre ellos, aunque al final solo haya quedado en uno.

## Añadidos 

Se ha creado una pantalla de filtros donde se pueden elegir comics, eventos o series, los cuales se enviaran a la home para aplicar en la llamada de obtencion de personajes 