# Spring Boot - JPA
Recursos y pasos importantes para el curso

# :computer:  Actividades

## Pre-requisitos de la sesión en vivo :exclamation:

Para realizar este curso es importante tener instalado los siguientes programas::
* [JDK 11](https://www.oracle.com/java/technologies/downloads/)
* [Intellij Idea Community](https://www.jetbrains.com/idea/download/#section=windows)
* [Maven](https://maven.apache.org/download.cgi)

## Java línea de comando
Una vez que JDK y MAVEN sean instalados y configurados, procederemos a validar que este bien instalado para comenzar con la actividad.

### PASO 1: Validar entorno
Abrimos una terminal y validamos si reconoce nuestra versión de Java:

``` bash
# Iniciamos validando que nuestra consola reconosca la versión de Java

jonathan.torres@Jonathans-MacBook-Pro LearningJava1.2 % java -version
java version "11.0.15" 2022-04-19 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.15+8-LTS-149)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.15+8-LTS-149, mixed mode)

```

Ahora desde una terminal y validamos si reconoce nuestra versión de Maven:

``` bash
# Iniciamos validando que nuestra consola reconosca la versión de Java

jonathan.torres@Jonathans-MacBook-Pro BAZJAVA12022 % mvn -version
Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
Maven home: /Users/jonathan.torres/Open/apache-maven-3.8.5
Java version: 11.0.15, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk-11.0.15.jdk/Contents/Home
Default locale: en_MX, platform encoding: UTF-8
OS name: "mac os x", version: "12.3.1", arch: "x86_64", family: "mac"
jonathan.torres@Jonathans-MacBook-Pro BAZJAVA12022 %
```

## Temario Día 4

### Descarga de mongodb

Descargar e instalar Mongo DB (daemon y mongosh). Instalacion de MongoDB Compass

### Definicion de Repository

Crear un repositorio que nos permita interactuar con Mongo db

### Definicion de MongoTemplate

Mostrar cuales son algunas APIs de MongoTemplate para interactuar con los objetos en Java y manipularlos en la base de datos


## Practica
La practica y ejercicios las podemos encontrar en el directorio de learningjava

### A continuación, se listaran los pasos para a seguir para la actividad de este módulo.

1. Comenzamos con descargar/clonar lo que tengamos en el repositorio https://github.com/wizelineacademy/BAZJAVA12022 y nos vamos a la carpeta de (.5/MVC/LearningJava), que es el mismo ejercicio del SpringBootApplication dia 3 (MVC)

2. Desde IntelliJ importamos el proyecto maven, abriendo el pom.xml que se ubica bajo la carpeta de LearningJava)

3. Lo primero que tenemos que hacer es definir una interfaz que sea de tipo Repository y sea la que implemente
las operaciones que permitan interactuar con MongoDB. Para ello debemos de crear una clase llamada BankingAccountRepository
debajo del package com.wizeline.maven.learningjava.Repository

4. El cuerpo de BankingAccountRepository debera de contener lo siguiente

``` bash

package com.wizeline.maven.learningjava.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wizeline.maven.learningjava.model.BankAccountDTO;

/**
 * Class Description goes here.
 * Created by enrique.gutierrez on 27/09/22
 */
@Repository
public interface BankingAccountRepository extends MongoRepository<BankAccountDTO, Long> {
}
```

5. Dentro de la clase BankAccountServiceImpl debemos de definir dos Autowired. Uno resolvera el Dependency Injection
para BankingAccountRepository y el otro para MongoTemplate

``` bash

@Autowired
    BankingAccountRepository bankAccountRepository;

    @Autowired
    MongoTemplate mongoTemplate;

```

6. El metodo de getAccounts() dentro de la clase BankAccountServiceImpl debe ser modificado para que pueda hacer las operaciones
de salvar en la db, asi de encontrar todos los records existentes en la coleccion (bankAccountCollection) dentro de Mongo DB.

Asi debe quedar el cuerpo de la clase:

``` bash
@Override
public List<BankAccountDTO> getAccounts() {
    // Definicion de lista con la informacion de las cuentas existentes.
    List<BankAccountDTO> accountDTOList = new ArrayList<>();
    BankAccountDTO bankAccountOne = buildBankAccount("user3@wizeline.com", true, Country.MX, LocalDateTime.now().minusDays(7));
    accountDTOList.add(bankAccountOne);

    //Guardar cada record en la db de mongo (en la coleccion bankAccountCollection)
    mongoTemplate.save(bankAccountOne);

    BankAccountDTO bankAccountTwo = buildBankAccount("user1@wizeline.com", false, Country.FR, LocalDateTime.now().minusMonths(2));
    accountDTOList.add(bankAccountTwo);

    //Guardar cada record en la db de mongo (en la coleccion bankAccountCollection)
    mongoTemplate.save(bankAccountTwo);

    BankAccountDTO bankAccountThree = buildBankAccount("user2@wizeline.com" ,false, Country.US, LocalDateTime.now().minusYears(4));
    accountDTOList.add(bankAccountThree);

    //Guardar cada record en la db de mongo (en la coleccion bankAccountCollection)
    mongoTemplate.save(bankAccountThree);

    //Imprime en la Consola cuales son los records encontrados en la coleccion
    //bankAccountCollection de la mongo db
    mongoTemplate.findAll(BankAccountDTO.class).stream().map(bankAccountDTO -> bankAccountDTO.getUserName()).forEach(
            (user) -> {
                    LOGGER.info("User stored in bankAccountCollection " + user );
            });

    //Esta es la respuesta que se retorna al Controlador
    //y que sera desplegada cuando se haga la llamada a los
    //REST endpoints que la invocan (un ejemplo es el endpoint de  getAccounts)
    return accountDTOList;
}
```

7.  Agregaremos un endpoint que permita borrar todos los records de Mongo DB existentes. Esto involucra
cambios en las capas de Controlador y Servicio. Para la clase BankAccountService debemos de incluir lo siguiente:

``` bash

void deleteAccounts();

```

En BankAccountServiceImpl debemos de implementar dicha funcion

``` bash

@Override
public void deleteAccounts() {
    //Deleting all records inside of bankAccountCollection in the mongo db
    bankAccountRepository.deleteAll();
}

```

Del lado del Controlador, busquemos la clase BankingAccountController e implementemos lo siguiente:

``` bash

@DeleteMapping("/deleteAccounts")
   public ResponseEntity<String> deleteAccounts() {
       bankAccountService.deleteAccounts();
       return new ResponseEntity<>("All accounts deleted", HttpStatus.OK);
   }

```

8.  A continuación, ejecutemos el proyecto y hagamos una prueba con los siguientes request:


* [LearningJavaSpring.postman_collection.json](./Postman/LearningJavaSpring.postman_collection.json)



# :books: Para aprender mas
* [Spring Initializr](https://start.spring.io/)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [Spring REST](https://spring.io/projects/spring-restdocs)
* [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Maven Repository](https://mvnrepository.com/)
