Se tiene 2 proyectos:
1.- demo, es el servicio principal que realiza el tipo de cambio.
2-- ExchangeRate, es el servicio auxiliar que retorna el tipo de cambio.

Librerias:
WebFlux
Caffeine 
resilience4j
Junit 5 & Mockito


Descripción:


Se solicita implementar un microservicio que permita realizar la conversión de moneda y devuelva el tipo de cambio.

Requisitos Funcionales:

Diseñar un API que permita realizar el tipo de cambio entre diferentes monedas
El API debe recibir un valor “monto”, “moneda origen” y “moneda destino”
El API debe devolver los siguientes elementos: “monto”, “monto con tipo de cambio”, “moneda origen” y “moneda destino” y “valor de tipo de cambio“
Se debe de optimizar las operaciones de tipo de cambio, para no volver a realizar el calculo por una ventana de tiempo de 5 minutos (siempre y cuando se tenga los mismos valores de entrada).

Requisitos Técnicos:

Lenguaje de programación Java utilizando JDK 17 o superior
Framework: SpringBoot / Quarkus (preferentemente Quarkus)
Utilizar programación reactiva
Versionar el código en GitHub.
El microservicio debe estar Dockerizado
Opcional: Implementar mecanismo de seguridad en cada consulta.

Consideraciones:

La elección de la imagen al - dockerizar - es libre.
No hay un estandar en los nombres de las clases, metodos y variables creados.
En caso de alguna duda en el enunciado, tomar una decisión y luego sustentarla durante la entrevista.
El código fuente debe ser subido a su cuenta de Github e indicar la rama de trabajo.
