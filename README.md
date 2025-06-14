# 🧾 Todo Code Spring Boot – API para Bazar

Este proyecto es el **trabajo integrador final** del curso _"Desarrollo de APIs en Java con Spring Boot"_ de TodoCode Academy. Consiste en una API REST para la gestión de productos, clientes y ventas de un bazar.

## 🎯 Objetivo

Permitir a la dueña de un bazar registrar operaciones y manejar el stock de productos a través de un backend común para dos futuros clientes: una app web y una app mobile.

## 🛠️ Tecnologías

- Java 11+  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Postman (para pruebas manuales)

## ⚙️ Configuración

Base de datos configurada en `application.properties`:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/bazar?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
📦 Modelo de Dominio
Producto
codigo_producto: Long

nombre: String

marca: String

costo: Double

cantidad_disponible: Double

Cliente
id_cliente: Long

nombre: String

apellido: String

dni: String

Venta
codigo_venta: Long

fecha: LocalDate

total: Double

listaProductos: List<Producto>

unCliente: Cliente

🔁 Endpoints
Productos
POST /productos/crear

GET /productos

GET /productos/{codigo_producto}

PUT /productos/editar/{codigo_producto}

DELETE /productos/eliminar/{codigo_producto}

GET /productos/falta_stock – Productos con stock menor a 5

Clientes
POST /clientes/crear

GET /clientes

GET /clientes/{id_cliente}

PUT /clientes/editar/{id_cliente}

DELETE /clientes/eliminar/{id_cliente}

Ventas
POST /ventas/crear

GET /ventas

GET /ventas/{codigo_venta}

PUT /ventas/editar/{codigo_venta}

DELETE /ventas/eliminar/{codigo_venta}

GET /ventas/productos/{codigo_venta} – Lista de productos de una venta

GET /ventas/total/{fecha_venta} – Total y cantidad de ventas de un día

GET /ventas/mayor_venta – Venta con monto más alto

💡 Bonus opcional: actualización automática de stock al vender.

🧪 Pruebas
Podés importar la colección de Postman incluida en el proyecto (TodoCode.postman_collection.json) para probar los endpoints.

📂 Instalación
Clonar el repositorio:

bash
Copiar
Editar
git clone https://github.com/germanico51/TodoCodeSpringBoot.git
cd TodoCodeSpringBoot
Crear la base de datos en MySQL:

sql
Copiar
Editar
CREATE DATABASE bazar;
Ejecutar el proyecto:

bash
Copiar
Editar
mvn spring-boot:run
Acceder a la API en:
http://localhost:8080
