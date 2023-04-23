# Para la corrección
En este repositorio se encuentran todos los archivos de las fases de la tarea 1, además de un makefile para facilitar la compilación y ejecución de los códigos.

Para poder facilitar la corrección separamos la tarea en varias Branch.

En el main se pueden encontrar todos los archivos de todas las fases combinados, para poder probar el código en cada fase se debe usar las branches de cada base incluyendo la de Bonus,



# Tarea 1, programación orientada a objetos: Creando una alarma domiciliaria

El objetivo de esta tarea fue desarrollar una alarma domiciliaria con sus componentes básicas. Esta funciona con sensores PIR para detectar movimientos anómalos dentro de la vivienda y sensores magnéticos para detectar una apertura o cerradura de puertas y/o ventanas, así poder saltar una alarma (sirena) después de notificar a una central. 

Esta tarea está dividida en cuatro etapas diferentes, además de una etapa bonus, que serán explicadas con detalle a continuación. Además, todas cuentan con un makefile para hacer más fácil su compilación y ejecución.

Además, dentro de este repositorio, las distintas etapas están separadas por *tags*, siendo el tag de *Fase1* donde se encuentran los códigos de la etapa 1, y así sucesivamente.

## Etapa 1: Propiedad con una puerta y ventana

En esta etapa el funcionamiento de la alarma se basa en detectar actividad anómala con un sensor magnético en puertas y ventanas, sin sensores PIR, ni central, ni sirena. 

En el archivo estándar *configurationFile.txt* están declarados la cantidad de puertas y ventanas iniciales (se puede configurar si se desea, siempre dejando el último número como 0, ya que no hay sensores PIR en esta etapa), y a partir de estos valores, el usuario puede decidir tanto para las ventanas como las puertas, si estarán cerradas con 'c' o abiertas con 'o'. Para salir del programa, se utilizará 'x'. Todas estas acciones desembocarán en el output que indicará las puertas y ventanas abiertas y cerradas.

Para compilar esta fase hay dos opciones:

1. Usando el makefile con el comando:
    ```
    $ make
    $ make run
    ```
2. Usando el comando de compilación:
    ```
    $ javac Stage1.java 
    $ java Stage1 <configurationFile.txt>
    ```

## Etapa 2: Propiedad con dos puertas, dos ventanas, central y sirena

En esta etapa se incorporan dos clases nuevas: Central y Siren. La Central es la unidad de control de la alarma. La central puede estar en dos estados diferentes: *armada* o *desarmada*, los cuales se pueden establecer a través del teclado cuando se compila el programa. 

Consideraciones:
- Para armar la alarma, todas las zonas deben estar cerradas (entiendase **zonas** en esta etapa como las puertas y ventanas)
- En esta etapa la central sólo captará información de **puertas y ventanas**, aun no contará con armado nocturno ni detección de movimiento. 
- Al dispararse la alarma, sonará un sonido de Sirena a modo de alerta.
- Para agregar una central se debe utilizar 'k'
- Los valores iniciales de las puertas y ventanas, además del archivo de sonido de la sirena, están en el *configurationFile.txt*

Para armar la central se utiliza 'a' y para desarmar la central se utiliza 'd'. Para salir del programa, nuevamente se puede utilizar 'x'.

Para compilar esta fase hay dos opciones:

1. Usando el makefile con el comando:
    ```
    $ make
    $ make run
    ```
2. Usando el comando de compilación:
    ```
    $ javac Stage2.java 
    $ java Stage2 <configurationFile.txt>
    ```

## Etapa 3: Un sensor PIR y una persona

En esta etapa se añaden dos clases nuevas: PIR_Detector y Person. Aquí la alarma verifica las interacciones con el usuario, pudiendo generar una salida acorde. 

Con 'c' se crea una nueva persona y se deben ingresar las coordenadas (x,y) de esta. Para efectos de esta etapa, solamente se debe crear una persona. Las coordenadas son números flotantes y la persona se mueve de a 0,5 metros con las flechas del teclado.

Los detectores PIR (en este casos solo uno), están declarados en el *configurationFile.txt* junto con lo declarado en las etapas anteriores. El sensor PIR cuenta con un parámetro de posición (x,y), la orientación de su área de detección (sexagesimales), el ángulo del cono sensor (sexagesimales) y el rango de detección (metros).

Para compilar esta fase hay dos opciones:

1. Usando el makefile con el comando:
    ```
    $ make
    $ make run
    ```
2. Usando el comando de compilación:
    ```
    $ javac Stage3.java 
    $ java Stage3 <configurationFile.txt>
    ```

## Etapa 4: Alarma domiciliaria completa

En esta etapa se pueden agregar más de un sensor PIR y más de una persona. Además se agrega la opción de *armado nocturno* que permite detectar la actividad solo de puertas y ventanas, sin necesidad de detectar la circulación de los usuarios por la vivienda. 

Los comandos a ingresar son los mismos que en etapas anteriores, solo que ahora en vez de solo establecer la Central como armada o desarmada, también se puede hacer un armado perimetral con 'p'. 

Todas las configuraciones de los PIR y la cantidad de puertas y ventanas están declaradas en el configurationFile.txt.

Los archivos que contiene esta etapa son:

- Door.java
- MagneticSensor.java
- Sensor.java
- SwitchState.java
- Window.java
- State.java
- AePlayWave.java
- Central.java
- PIR_Detector.java
- Person.java
- Siren.java
- Stage4.java
- config.txt
- siren.wav

1. Usando el makefile con el comando:
    ```
    $ make
    $ make run
    ```
2. Usando el comando de compilación:
    ```
    $ javac Stage4.java 
    $ java Stage4 <configurationFile.txt>
    ```

## Extra-crédito

En esta tarea decidimos optar por la bonificación, agregando la función de salida y entrada con armado y disparo retardado.

Las instrcciones para el uso del bonus son igual a las del stage 4, ya que solo se agrego la funcion del retardo en central.



