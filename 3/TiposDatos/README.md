# :tv: Video y Presentacion
- [TBD]
- [TBD]
- [TBD]

# Tipos de Datos

# :hammer_and_wrench:  Requisitos
- Java 11
- IDE
    * [Visual Studio Code](https://code.visualstudio.com/download)
    * [IntelliJ](https://www.jetbrains.com/idea/download)
- [Postman](https://www.postman.com/downloads/)
- [json-20220320.jar](https://repo1.maven.org/maven2/org/json/json/20220320/)

# :computer: Requests
``` bash
curl --location --request GET 'http://localhost:8080/api/getUserAccount?user=user1@wizeline.com&password=Pass1'
```
# :bulb: Nota
La petición anterior :point_up_2: se puede importar en Postman siemplemente copiando y pegandola en el apartado __Raw text__ que aparece despues de hacer clic en el boton de __importar__.

# :white_check_mark: Response
```json
{
    "country": "Mexico",
    "accountActive": true,
    "accountName": "Dummy Account",
    "accountType": "NOMINA",
    "accountNumber": 123,
    "accountBalance": 843.24,
    "user": "user1@wizeline.com"
}
``` 

# :books: Recursos
- [The Java® Language Specification](https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html)
- [Learning Java, 4th Edition by Patrick Niemeyer, Daniel Leuck](https://www.oreilly.com/library/view/learning-java-4th/9781449372477/ch10s02.html)
- [Java For Dummies Quick Reference](https://www.oreilly.com/library/view/java-for-dummies/9781118239742/a83.html)
- [Primitive and Reference Types in Java with Examples](https://www.swtestacademy.com/primitive-and-reference-types-in-java/)
