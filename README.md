# Mercadona Spring Boot REST API 

Aplicación creada para el manejo de un supermercado.

## Features

- API de trabajadores
- API de informes
- Se implementaron otras API de consulta básicas
- Manejo de errores
- Global exception handling
- Validación de los input
- Internacionalización
- Integración BBDD con PostgreSQL
- Contenedores Docker

## Tecnologías

- Java 21
- Spring Boot 3.4.6
- Spring Data JPA
- Spring Web
- Spring Validation
- PostgreSQL Driver
- Lombok
- Maven


## Prerequisitos

- JDK 21 o posterior
- Maven 3.9+
- PostgreSQL Server
- Docker
- Postman

## Configuración de la BBDD

La aplicación está configurada para conectarse a una BBDD PosgreSQL. Las propiedades se encuentran en 
`src/main/resources/application.properties` 
y
`Dockerfile`

## Configuración del proyecto

La aplicación se ha integrado con Docker, para ello se han creado dos contenedores con nombres
`mercadona-app` para la aplicación
y `mercadona-bd` para contener la BBDD postgreSQL
para ello se ha definido el fichero `docker-compose.yml` y `DockerFile` donde se indican todas las configuraciones,
desde que puertos se conectan entre sí, usuarios, contraseñas, de donde se obtienen las imágenes,
nombres de contenedores...

## Construyendo y lanzando la aplicación

He dejado los dos contenedores creados, pero si se quiere generar y ver el contenido del código,
estos son los pasos:
1. Ejecutar el comando `docker-compose up` en la ruta raíz del proyecto.
2. Abrir las conexiones postman del fichero `MercadonaPrueba.postman_collection`.
3. Probar las api que se quieran(Se crearon los endpoints que se pedían en Iteración 1 y 2,
se podrían probar más pero no se han implementado en Postman, aunque si está creada la lógica,
para consultas básicas de consultar,crear,editar y borrar de todas las Entidades)


## API Endpoints (Se adjuntan en el repositorio de GitHub también en el fichero`MercadonaPrueba.postman_collection`)

### Trabajadores
API con las operaciones de consulta, creación, edición y borrado
de trabajadores de una tienda. Incluyendo la tienda a la que están
asignados y las horas disponibles según su contrato.

- GET `http://localhost:8080/trabajadores/consultarTodos` - Consultar todos los trabajadores
- GET `http://localhost:8080/trabajadores/consultarPorDni/70336574T` - Consultar un trabajador por su DNI
- POST `http://localhost:8080/trabajadores/crear` - Crear trabajador
 ``` JSON 
{
  "dni": "70336574T",
  "nombre": "Diego",
  "apellidos": "Jimenez Sanchez",
  "horasDisponibles": 8,
  "tienda": {
  "codigo": 5
  }
  }
```
- PUT `/api/products/price/{maxPrice}` - Editar trabajador a partir de su DNI
 ``` JSON 
{
  "nombre": "Irene Actualizada",
  "apellidos": "Jimenez Perez",
  "horasDisponibles": 8,
  "tienda": {
    "codigo": 1
  }
}
```
- DELETE `http://localhost:8080/trabajadores/eliminarPorDni/70896574J` - Eliminar trabajador a partir de su DNI

### Informes

API para poder asignar/desasignar a un trabajador a una sección
durante cierto número de horas. Asegurándonos de que no excedemos las
horas disponibles del trabajador.

- GET `http://localhost:8080/informes/estado-tienda` - Muestra el estado de las tiendas
- GET `http://localhost:8080/informes/secciones-incompletas` - Obtiene las secciones que no se han completado sus horas


## Manejo de errores

La aplicación incluye manejo de excepciones globales para:
- MethodArgumentTypeMismatchException
- MethodArgumentNotValidException
- ConstraintViolationException
- IllegalArgumentException
- Exception

## Validaciones

La aplicación valida los campos y el body de las request, esto está
internacionalizado en tres idiomas español, portugués e inglés.
También están controlados los campos en BBDD.

## Internacionalización
Se ha configurado en el fichero `/main/java/aplication.properties`
```
spring.messages.basename=messages
spring.messages.encoding=UTF-8
```
Los ficheros de propiedades para los siguientes idiomas, se encuentran en:

- Default: `\mercadona\src\main\resources\messages.properties`

- Español: `\mercadona\src\main\resources\messages_es.properties`

- Portugués: `\mercadona\src\main\resources\messages_pt.properties`

- Inglés: `\mercadona\src\main\resources\messages_en.properties`

## Desarrollo

EL proyecto usa la siguiente estructura de carpetas:
```      
src/main/java/com/
     └── com.irene.mercadona/
         ├── config/
         │   └── InternationalizationConfig.java
         │
         ├── controller/
         │   ├── AsignacionController.java
         │   ├── InformeController.java
         │   ├── SeccionController.java
         │   ├── TiendaController.java
         │   └── TrabajadorController.java
         │
         ├── dto/
         │   ├── AsignacionRequestDTO.java
         │   └── InformeResponseDTO.java
         │
         ├── exception/
         │   └── GlobalExceptionHandler.java
         │
         ├── model/
         │   ├── Asignacion.java
         │   ├── Seccion.java
         │   ├── Tienda.java
         │   └── Trabajador.java
         │
         ├── repository/
         │   ├── AsignacionRepository.java
         │   ├── SeccionRepository.java
         │   ├── TiendaRepository.java
         │   └── TrabajadorRepository.java
         │
         └── service/
             ├── AsignacionServicio.java
             ├── InformeServicio.java
             ├── SeccionServicio.java
             ├── TiendaServicio.java
             └── TrabajadorServicio.java
```