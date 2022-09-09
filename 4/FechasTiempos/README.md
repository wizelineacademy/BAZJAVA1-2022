# :tv: Video y Presentacion
- [TBD]
- [TBD]
- [TBD]

# API de Fechas y Tiempos

# :hammer_and_wrench:  Requisitos
- Java 11
- IDE
    * [Visual Studio Code](https://code.visualstudio.com/download)
    * [IntelliJ](https://www.jetbrains.com/idea/download)
- [Postman](https://www.postman.com/downloads/)
- [json-20220320.jar](https://repo1.maven.org/maven2/org/json/json/20220320/)

# :computer: Requests
``` bash
curl --location --request GET 'http://localhost:8080/api/getUserAccount?user=user1@wizeline.com&password=Pass1@&date=12-03-2018'
```
# :bulb: Nota
La petición anterior :point_up_2: se puede importar en Postman siemplemente copiando y pegandola en el apartado __Raw text__ que aparece despues de hacer clic en el boton de __importar__.

# :white_check_mark: 200 Response
```json
{
    "country": "Mexico",
    "accountActive": true,
    "accountName": "Dummy Account 5",
    "accountType": "AHORRO",
    "lastUsage": "2022-09-08T14:55:19.512991",
    "accountNumber": -2160093231463591361,
    "accountBalance": 2726.736854261657,
    "creationDate": "2018-03-12T00:00",
    "user": "user1@wizeline.com"
}
``` 
# :x: 400 Response
```json
{
   Formato de Fecha Incorrecto
}
``` 
# :no_entry: 401 Response
```json
{
   Password Incorrecto
}
``` 



# :books: Recursos
- [Java Date Time Tutorial](https://jenkov.com/tutorials/java-date-time/index.html)
- [Java Date-Time Packages](https://docs.oracle.com/javase/8/docs/technotes/guides/datetime/index.html)
- [Introduction to the Java 8 Date/Time API](https://www.baeldung.com/java-8-date-time-intro)
- [Chapter 17Use Java SE 8 Date/Time API](https://www.oreilly.com/library/view/oca-ocp/9781119363392/c17.xhtml)
