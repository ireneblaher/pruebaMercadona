# Mercadona Spring Boot REST API 

A RESTful API built with Spring Boot for managing products. This API provides endpoints for creating, reading, updating, and deleting product information.

## Features

- CRUD operations for products
- Category-based product filtering
- Price-based product filtering
- Name-based product search
- Global exception handling
- Input validation
- MySQL database integration

## Technologies

- Java 21
- Spring Boot 3.4.6
- Spring Data JPA
- Spring Web
- Spring Validation
- PostgreSQL Driver
- Lombok
- Maven


## Prerequisites

- JDK 21 or later
- Maven 3.9+
- PostgreSQL Server

## Configuración de la BBDD

La aplicación está configurada para conectarse a una BBDD PosgreSQL. Las propiedades se encuentran en `src/main/resources/application.properties` si se necesita:

```propiedades
spring.datasource.url=jdbc:postgresql://localhost:5432/mercadona
spring.datasource.username=postgres
spring.datasource.password=0000
```

## Building and Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Build the project:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on port 8080.

## API Endpoints

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

### Asignaciones

API para poder asignar/desasignar a un trabajador a una sección
durante cierto número de horas. Asegurándonos de que no excedemos las
horas disponibles del trabajador.

- GET `/api/products` - Get all products
- GET `/api/products/{id}` - Get a specific product by ID


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
Los ficheros de propiedades se encuentran en:
Default: `\mercadona\src\main\resources\messages.properties`
Español: `\mercadona\src\main\resources\messages_es.properties`
Portugués: `\mercadona\src\main\resources\messages_pt.properties`
Inglés: `\mercadona\src\main\resources\messages_en.properties`

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