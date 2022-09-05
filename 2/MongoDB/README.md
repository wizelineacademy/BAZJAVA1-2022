# MongoDB

## Pre-requisitos de la sesión en vivo
- Tener instalado [Docker](https://www.docker.com/)
- Revisar los conceptos básicos:

### Conceptos básicos

* [Documentos](https://www.mongodb.com/docs/manual/core/document/)

* [Colecciones](https://www.mongodb.com/docs/manual/core/databases-and-collections/)

## Comandos
### Levantar instancia de MongoDB
``` docker run --name mongodb -d mongo ```
### Conectarse a MongoDB
``` docker exec -it mongodb mongosh ```
### Mostrar bases de datos
``` show dbs ```
### Crear / Usar base de datos
``` use wizeline_baz_db ```
### Mostrar base de datos en uso
``` db ```
### Insertar documentos
* Insertar un documento

``` db.proyecto.insertOne({"nombre":"workshop"}) ```

* Insertar multiples documentos

``` db.proyectos.insertMany([ { nombre: "Proyecto multiple", responsables: ["CTO", "TL"], tipo: "multiple" }, { nombre: "Proyecto cancelado" }]) ```

### Consultar documentos
* Consultar sin filtros

``` db.proyectos.find() ```

* Consultar con filtros

``` 
db.proyectos.find({"cantidad": 1, "tipo": "single"})
db.proyectos.find({$or: [{"cantidad": 1}, {"tipo": "multiple"}]})
```

### Actualizar documentos
* Actualizar un documento

```
db.proyectos.updateOne({ cantidad: 1 }, { $set: { tipo: "prueba" } })
```

* Actualizar multiples documentos

```
db.proyectos.updateMany( { presupuesto: { $ne: 100 } }, { $set: { presupuesto: 100 } })
```

### Eliminar documentos
* Eliminar todos los documentos

``` db.proyectos.deleteMany({}) ```

* Eliminar documentos filtrados

``` db.proyectos.deleteMany({ cantidad: 1 }) ```