# AD_Practica3_LaraGarcia
Hibernate
# Programa CRUD con Conexión a Base de Datos

## Descripción

Este programa permite la conexión a una base de datos utilizando **DBeaver** como herramienta de administración y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la base de datos.

## Pasos Principales

### 1. Configurar DBeaver
   - Descarga e instala **DBeaver** desde su [sitio web](https://dbeaver.io/).
   - Conéctate a la base de datos (MySQL, PostgreSQL, etc.) utilizando la información de conexión adecuada (servidor, usuario, contraseña, puerto).

### 2. Crear una Conexión JDBC en DBeaver
   - En DBeaver, selecciona "Nueva conexión" y elige el tipo de base de datos.
   - Introduce los detalles de la base de datos (URL, usuario, contraseña, etc.) para establecer la conexión.

### 3. Operaciones CRUD

   - **Crear (Insertar)**: Usando DBeaver, puedes insertar registros con comandos SQL.
   - **Leer (Seleccionar)**: Realiza consultas SQL `SELECT` para leer datos de las tablas.
   - **Actualizar (Update)**: Actualiza registros existentes mediante el comando SQL `UPDATE`.
   - **Eliminar (Delete)**: Elimina registros con el comando SQL `DELETE`.

### 4. Implementar el CRUD en un Programa Java
   - Usando Java, puedes crear un programa que se conecte a la base de datos mediante **JDBC**.
   - Utiliza las operaciones CRUD en tu código para interactuar con la base de datos.
