# Tarea 1, programación orientada a objetos: Creando una alarma domiciliaria

El objetivo de esta tarea fue desarrollar una alarma domiciliaria con sus componentes básicas. Esta funciona con sensores PIR para detectar movimientos anómalos dentro de la vivienda y sensores magnéticos para detectar una apertura o cerradura de puertas y/o ventanas, así poder saltar una alarma (sirena) después de notificar a una central. 

Esta tarea está dividida en cuatro etapas diferentes, además de una etapa bonus, que serán explicadas con detalle a continuación. Además, todas cuentan con un makefile para hacer más fácil su compilación y ejecución.

Además, dentro de este repositorio, las distintas etapas están separadas por *tags*, siendo el tag de *Fase1* donde se encuentran los códigos de la etapa 1, y así sucesivamente.

## Etapa 1: Propiedad con una puerta y ventana

En esta etapa el funcionamiento de la alarma se basa en detectar actividad anómala con un sensor magnético en puertas y ventanas, sin sensores PIR, ni central, ni sirena. 

Se pueden seleccionar la cantidad de puertas escribiendo 'd' las veces que sea necesario y lo mismo con las ventanas escribiendo 'w'. En cuanto al estado de estas, se utilizará 'o' en caso de que estén abiertas, y en caso contrario, se utilizará 'c'. Para salir del programa, se utilizará 'x'. Todas estas acciones desembocarán en el output que indicará las puertas y ventanas abiertas y cerradas.

Para compilar esta fase hay dos opciones:

1. Usando el makefile con el comando:
    ```
    $ make run
    ```
2. Usando el comando de compilación:
    ```
    $ javac Stage1.java 
    $ java Stage1 <configurationFile.txt>
    ```

## Etapa 2: Propiedad con dos puertas, dos ventanas, central y sirena




