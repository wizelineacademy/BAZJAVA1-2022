
# El Proyecto
El proyecto está confirmado de los ejercicios y tareas que se van realizando en las sesiones impartidas a lo largo del curso, por lo que para cada entregable debe enviarse la liga del repositorio creado en el primer día que contendrá cada entregable para su revisión usando este Google Form: https://forms.gle/q4zFogV3ncvM2JE39

## Fechas de Entrega
1º: Lunes 12 Septiembre 6 p.m.

2º: Lunes 26 Septiembre 9 a.m.

3º: Lunes 10 Octubre 9 a.m.

## Entregables
### Para poder considerar completadas las semanas 1 y 2 de entrenamiento debe contemplar lo siguiente:
- Crear un repositorio en GitHub 
- Dockerfile ejecutable
- Archivo de Docker Compose que permita levantar el contendor
- Colección de Postman realizando una petición de cada tipo (GET, POST, PUT, DELETE, HEAD) a una API pública (por lo menos una de ellas debe ser comprimida)
- Función Lambda creada en la cuenta que permita la ejecución de código
- Captura de pantalla de logs en Cloudwatch
- Captura de pantalla de productor a consumidor en Kafka
- Base de datos de MongoDB exportada
- Impresión de pantalla de operaciones CRUD en datos reales de MongoDB
- Diagrama de clases inicial y diagrama de clases con un patrón de diseño creacional aplicado

| **Tópico**                                                                                                                                                 | **Puntaje** |
|------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|
| Dockerfile ejecutable                                                                                                                                      | 10          |
| Archivo de Docker Compose que permita levantar el contendor                                                                                                | 10          |
| Colección de Postman realizando una petición de cada tipo (GET, POST, PUT, DELETE, HEAD) a una API pública (por lo menos una de ellas debe ser comprimida) | 10          |
| Colección de Postman realizando una petición de cada tipo a una API pública                                                                                | 10          |
| Función Lambda creada en la cuenta que permita la ejecución de código                                                                                      | 10          |
| Captura de pantalla de logs en Cloudwatch                                                                                                                  | 10          |
| Captura de pantalla de productor a consumidor en Kafka                                                                                                     | 10          |
| Base de datos de MongoDB exportada                                                                                                                         | 10          |
| Impresión de pantalla de operaciones CRUD en datos reales de MongoDB                                                                                       | 10          |
| Diagrama de clases inicial y diagrama de clases con un patrón de diseño creacional aplicado                                                                | 10          |
| **Total**                                                                                                                                                  | **100**     |
| **Mínimo Aprobatorio**                                                                                                                                     | **70**      |

### Para poder considerar completadas las semanas 3 y 4 de entrenamiento debe contemplar lo siguiente:
- Proyecto en Java 11 ejecutable por línea de comandos y desplegable en el contenedor creado en el primer entregable
- Herencia en una de sus clases
- Sobrecarga de al menos uno de los métodos de alguna clase
- Sobrecarga de al menos uno de los constructores de alguna clase
- Encapsulamiento de al menos una clase
- Clase interna dentro de al menos una clase 
- Uso de por lo menos una interfaz de creación propia
- Uso de por lo menos dos tipos de datos primitivos, dos tipos de datos encapsulados y un tipo de dato abstracto
- Uso de por lo menos una expresión regular
- Uso de por lo menos un arreglo, un mapa y una lista
- Uso de API de Fechas y Tiempos en un método
- Implementación de concurrencia arrancando por lo menos tres hilos y utilizando su ejecución
- Uso de por lo menos una excepción de creación propia
- Uso de al menos tres anotaciones
- Uso de por lo menos dos beans
- Uso de por lo menos dos patrones de diseño creacionales

| **Tópico**                                                                                  | **Puntaje** |
|---------------------------------------------------------------------------------------------|-------------|
| Usar Java 11 como versión del proyecto                                                      | 5           |
| Dockerfile desplegando en el contenedor                                                     | 10          |
| Herencia en una de sus clases                                                               | 5           |
| Sobrecarga de al menos uno de los métodos de alguna clase                                   | 5           |
| Sobrecarga de al menos uno de los constructores de alguna clase                             | 5           |
| Encapsulamiento de al menos una clase                                                       | 5           |
| Clase interna dentro de al menos una clase                                                  | 5           |
| Uso de por lo menos una interfaz de creación propia                                         | 10          |
| Uso de por lo menos dos tipos de datos primitivos                                           | 5           |
| Uso de dos tipos de datos encapsulados                                                      | 5           |
| Uso de un tipo de dato abstracto                                                            | 5           |
| Uso de por lo menos una expresión regular                                                   | 10          |
| Uso de por lo menos un arreglo                                                              | 5           |
| Uso de por lo menos un mapa                                                                 | 5           |
| Uso de por lo menos una lista                                                               | 5           |
| Uso de API de Fechas y Tiempos en un método                                                 | 10          |
| Implementación de concurrencia arrancando por lo menos tres hilos y utilizando su ejecución | 20          |
| Uso de por lo menos una excepción de creación propia                                        | 20          |
| Uso de al menos tres anotaciones                                                            | 5           |
| Uso de por lo menos dos beans                                                               | 5           |
| Uso de por lo menos dos patrones de diseño creacionales                                     | 20          |
| **Total**                                                                                   | **170**     |
| **Mínimo aprobatorio**                                                                      | **120**     |

### Para poder considerar completadas las semanas 5 y 6 de entrenamiento debe contemplar lo siguiente:
- Proyecto generado por Spring Initializr y desplegable en el contenedor creado en el primer entregable
- Todas sus propiedades deben estar descritas en el archivo “application.properties” con el formato de nombre correcto
- Construirse mediante su manejador de dependencias (Gradle o Maven)
- La estructura del proyecto debe ser coherente y acorde a buenas prácticas
- Debe utilizar RestTemplate para consumir por lo menos una API pública y convertir el resultado a un POJO utilizando JAXB o Jackson
- Generar una API utilizando Spring MVC y debe tener por lo menos un endpoint de cada tipo (GET, POST, PUT, DELETE, HEAD); este debe ser consumible por medio de Postman y la colección para ello debe proveerse en el entregable final
- Comunicarse con la base de datos de MongoDB creada en el primer entregable a través de Spring Data JPA con MongoTemplate y poder realizar operaciones CRUD (creación, lectura, actualización y borrado de registros)
- Comunicarse con Lambda en AWS y con Kafka empleando librerías oficiales usando dependencias
- Crear por lo menos una prueba unitaria de cada endpoint generado con Spring MVC, decada operación realizada con Spring Data JPA y de cada integración empleando Mockito generando logs en la ejecución de cada una y contemplar Happy Path y Edge Cases, usando JaCoCo o SonarCloud como herramientas de cobertura de pruebas

| **Tópico**                                                        | **Puntaje** |
|-------------------------------------------------------------------|-------------|
| Captura de pantalla de proyecto generado por Spring Initializr    | 5           |
| Dockerfile desplegando en el contenedor                           | 10          |
| Archivo application.properties con el formato correcto            | 5           |
| Archivo desplegable usando Gradle o Maven                         | 5           |
| Estructura del proyecto correcta                                  | 5           |
| Consumo de API pública usando RestTemplate                        | 5           |
| Conversión del contenido consumido usando JAXB o Jackson          | 5           |
| API generada por Spring MVC con un endpoint de cada tipo          | 10          |
| Colección de Postman para consumir la API generada                | 5           |
| Creación de enlace con MongoDB usando Spring Data JPA             | 10          |
| Uso de MongoTemplate                                              | 5           |
| Lectura de MongoDB usando MongoTemplate                           | 5           |
| Escritura en MongoDB usando MongoTemplate                         | 5           |
| Actualización en MongoDB usando MongoTemplate                     | 5           |
| Borrado en MongoDB usando MongoTemplate                           | 5           |
| Integración con librería de AWS Lambda por medio de dependencia   | 15          |
| Integración con librería de Apache Kafka por medio de dependencia | 15          |
| Prueba unitaria de cada endpoint de la API                        | 20          |
| Prueba unitaria de cada operación CRUD                            | 20          |
| Prueba unitaria para AWS Lambda                                   | 10          |
| Prueba unitaria para Apache Kafka                                 | 10          |
| Uso de Mockito en cada prueba                                     | 10          |
| Generación de logs por prueba                                     | 10          |
| Pruebas para Happy Path                                           | 10          |
| Pruebas para cada Edge Case                                       | 10          |
| Implementación de JaCoCo o SonarCloud                             | 10          |
| **Total**                                                         | **230**     |
| **Mínimo aprobatorio**                                            | **180**     |