# ForoHub

## Descripción

ForoHub es una API RESTful desarrollada con Spring Boot para la gestión de foros. Los usuarios pueden crear, leer, actualizar y eliminar temas de discusión. Además, se implementa autenticación y autorización con JWT.


## Características

- CRUD de temas de discusión.
- Autenticación y autorización con JWT.
- Gestión de usuarios y perfiles.
- Seguridad configurada con Spring Security.
- Base de datos MySQL con migraciones manejadas por Flyway.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Lombok
- Flyway
- MySQL
- JWT (JSON Web Tokens)

## Requisitos Previos

Antes de empezar, asegúrate de tener instalados los siguientes requisitos en tu máquina:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 4](https://maven.apache.org/download.cgi)
- [MySQL 8](https://dev.mysql.com/downloads/mysql/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## Configuración del Proyecto

1. Clona este repositorio:
    ```sh
    git clone https://github.com/tu_usuario/forohub.git
    ```

2. Navega al directorio del proyecto:
    ```sh
    cd forohub
    ```

3. Configura la base de datos MySQL:

    - Crea una base de datos llamada `forohub`.
    - Configura las credenciales de tu base de datos en el archivo `src/main/resources/application.properties`:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/forohub
      spring.datasource.username=root
      spring.datasource.password=#123456.pass

      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true

      spring.flyway.enabled=true
      spring.flyway.url=jdbc:mysql://localhost:3306/forohub
      spring.flyway.user=root
      spring.flyway.password=#123456.pass
      ```

4. Compila el proyecto con Maven:
    ```sh
    mvn clean install
    ```

## Ejecución del Proyecto

Para ejecutar el proyecto, usa el siguiente comando:

```sh
mvn spring-boot:run

