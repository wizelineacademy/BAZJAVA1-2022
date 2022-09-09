# :tv: Video y Presentacion
- [TBD]
- [TBD]
- [TBD]

# Estructuras de Datos

# :hammer_and_wrench:  Requisitos
- Java 11
- IDE
    * [Visual Studio Code](https://code.visualstudio.com/download)
    * [IntelliJ](https://www.jetbrains.com/idea/download)
- [Postman](https://www.postman.com/downloads/)
- [json-20220320.jar](https://repo1.maven.org/maven2/org/json/json/20220320/)

# :computer: Requests
``` bash
curl --location --request GET 'http://localhost:8080/api/getAccounts'
```
# :bulb: Nota
La petición anterior :point_up_2: se puede importar en Postman siemplemente copiando y pegandola en el apartado __Raw text__ que aparece despues de hacer clic en el boton de __importar__.

# :white_check_mark: 200 Response
```json
[
    {
        "country": "Mexico",
        "accountActive": true,
        "accountName": "Dummy Account 9",
        "accountType": "PLATINUM",
        "lastUsage": "08-09-2021",
        "accountNumber": 672134163492917690,
        "accountBalance": 2944.27040517806,
        "user": "user3@wizeline.com"
    },
    {
        "country": "France",
        "accountActive": false,
        "accountName": "Dummy Account 6",
        "accountType": "NOMINA",
        "lastUsage": "07-09-2021",
        "accountNumber": -2809907130710493942,
        "accountBalance": 7682.979334527755,
        "user": "user1@wizeline.com"
    },
    {
        "country": "United States",
        "accountActive": false,
        "accountName": "Dummy Account 4",
        "accountType": "NOMINA",
        "lastUsage": "16-09-2021",
        "accountNumber": 690593633607299787,
        "accountBalance": 6058.225304384811,
        "user": "user2@wizeline.com"
    }
]
``` 



# :books: Recursos
- [Java in a Nutshell, 5th Edition by David Flanagan](https://www.oreilly.com/library/view/java-in-a/0596007736/ch02s08.html)
- [Interface Map<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
- [Java Map](https://jenkov.com/tutorials/java-collections/map.html)
- [Interface List<E>](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
- [Java List](https://jenkov.com/tutorials/java-collections/list.html)
