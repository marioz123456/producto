# 🛍️ Tienda API - Sistema de Gestión de Productos y Órdenes

Este proyecto es una API REST desarrollada con **Spring Boot 3.3.13** y **Java 17**, que permite gestionar productos y registrar órdenes de compra, con integraciones de PostgreSQL, validaciones, paginación, y más.

---

## Funcionalidades

### 1. Gestión de Productos
- Crear, actualizar, eliminar y listar productos
- Filtros por nombre y rangos de precio
- Paginación en listados
- Validaciones de entrada con Jakarta Bean Validation
- Auditoría con `createdAt` y `updatedAt`

### 2. Gestión de Órdenes
- Crear órdenes de compra de un producto específico
- Validación automática de stock disponible
- Actualización del stock al crear una orden
- Consulta de órdenes por usuario (paginado)
- Auditoría de creación con `createdAt`

---

## 🛠️ Tecnologías y Librerías

| Tecnología     | Descripción                         |
|----------------|-------------------------------------|
| Java 17        | Lenguaje principal                  |
| Spring Boot 3  | Framework base                      |
| Spring Data JPA| Acceso a base de datos              |
| PostgreSQL     | Motor de base de datos              |
| Lombok         | Eliminación de código boilerplate   |
| Jakarta Validation | Validaciones de datos de entrada |
| Hibernate      | ORM para persistencia               |

---

## 🚀 Cómo ejecutar el proyecto

### 1. Requisitos previos

- JDK 17
- Maven 3.8+
- PostgreSQL 13+
- IDE (IntelliJ, VSCode o Eclipse)

## documentacion de servicio
http://localhost:8080/swagger-ui/index.html

### 2. Configuración de base de datos

Crea la base de datos:

```sql
CREATE DATABASE db_producto;


#usuario inicial
INSERT INTO users (username, password, role)
VALUES ('admin', '$2a$10$3EtygWy0PqlQhmu6xWBjyexXFhoNYkTPZKVsyFSK/6OQrxKfb6XYe', 'ADMIN');


