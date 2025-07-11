# 📚 LiterAlura - Catálogo de Libros

Bienvenidos y bienvenidas al desafío **back-end** de Oracle Next Education en conjunto con **Alura Latam**.

Este proyecto, llamado **LiterAlura**, es una aplicación de consola escrita en **Java** que permite interactuar con un catálogo de libros utilizando una base de datos local y la API externa [Gutendex](https://gutendex.com/).

---

## 🧑‍🏫 Instrucción

Este desafío fue presentado por **Eric Monné**, instructor de Java en Alura Latam.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven
- Gutendex API

---

## 📋 Requisitos del sistema

- JDK 17 instalado
- PostgreSQL instalado y corriendo
- IDE recomendada: IntelliJ o Eclipse
- Acceso a internet para consumir la API externa
- Git (opcional, para versionado)

---

## 🛠️ Instalación y configuración

1. Crear el proyecto en [start.spring.io](https://start.spring.io):
   - Lenguaje: Java
   - Tipo de proyecto: Maven
   - Versión de Java: 17
   - Dependencias:
     - Spring Web
     - Spring Data JPA
     - PostgreSQL Driver

2. Clonar o crear tu repositorio y configurar tu archivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. ## Crear la base de datos Postrgesql
CREATE DATABASE literalura;

4.## ejecutar desde consola o el idle 
./mvnw spring-boot:run 
