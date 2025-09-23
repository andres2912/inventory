# Sistema de Gestión de Inventario

Este es un proyecto backend desarrollado con Java 17, Spring Boot y PostgreSQL que proporciona una API RESTful para la gestión de inventario.  
Permite a los administradores gestionar productos, categorías y niveles de stock mediante operaciones completas CRUD (crear, leer, actualizar, eliminar), con persistencia de datos.

El proyecto fue inspirado en una necesidad empresarial real y está diseñado con un enfoque en arquitectura limpia, escalabilidad y buenas prácticas de backend.  
Sigue la arquitectura Modelo-Vista-Controlador (MVC), lo que hace que el código sea modular, mantenible y fácil de extender.


## Características
- Gestión de categorías (crear, actualizar, eliminar, listar).  
- Gestión de productos (crear, actualizar, eliminar, listar).  
- Endpoints RESTful con métodos HTTP adecuados y códigos de respuesta correctos.  


## Tecnologías
- **Lenguaje:** Java 17  
- **Frameworks:** Spring Boot, Spring Data JPA  
- **Base de datos:** PostgreSQL  
- **Arquitectura:** MVC (Modelo–Vista–Controlador)  
- **Herramienta de construcción:** Maven  


## Estructura del proyecto

```bash
src/
├── main/java/com/efitel/inventory
│   ├── config/         # Configuración de la aplicación (beans, mensajes, etc.)
│   ├── controller/     # Controladores REST (endpoints de la API)
│   ├── exception/      # Manejo global de excepciones
│   ├── mapper/         # Mapeo entre Entidades y DTOs
│   ├── models/         # Entidades (JPA) y DTOs
│   ├── repository/     # Capa de persistencia de datos (Spring Data JPA)
│   └── services/       # Lógica de negocio
└── main/resources/
    ├── application.properties   # Configuración principal de la aplicación
    └── messages.properties      # Mensajes
```


## Endpoints de la API

### Categorías

| Método | Endpoint                       | Descripción                                 |
|--------|--------------------------------|---------------------------------------------|
| POST   | `/categories`                  | Crear una ó actualiza una categoría         |
| GET    | `/categories`                  | Obtener todas las categorías                |
| GET    | `/categories/{id}`             | Obtener una categoría por ID                |
| GET    | `/categories/search?name=abc`  | Buscar múltiples categorías por nombre      |
| DELETE | `/categories/by-name/{name}`   | Eliminar una categoría por nombre           |

---

### Ítems

| Método | Endpoint                                | Descripción                                |
|--------|-----------------------------------------|--------------------------------------------|
| POST   | `/inventoryItem`                        | Crear un ítem nuevo o actualizar uno       |
| GET    | `/inventoryItem`                        | Obtener todos los ítems                    |
| GET    | `/inventoryItem/{id}`                   | Obtener un ítem por ID                     |
| GET    | `/inventoryItem/search?name=abc`        | Buscar múltiples ítems por nombre          |
| DELETE | `/inventoryItem/{id}`                   | Eliminar un ítem por ID                    |


## Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java 17 o superior**

- **Maven**

- **PostgreSQL**

- **Git (para clonar el repositorio)**


## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/andres2912/inventory.git
cd inventory
```

### 2. Configurar base de datos
Asegúrese de que PostgreSQL se encuentre en ejecución y cree la base de datos:

```bash
CREATE DATABASE inventory_db;
```

### 3. Configurar application.properties
Modifique el archivo src/main/resources/application.properties con sus credenciales de PostgreSQL:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
spring.datasource.username=su_usuario
spring.datasource.password=su_contraseña
```

### 4. Construir y ejecutar la aplicación

```bash
mvn clean install
mvn spring-boot:run
```

### 5. Consumo API

### 1. Crear o actualizar una categoría
**POST** `/categories`

**Request (JSON):**
```json
{
  "name": "Electrónica",
  "description": "Dispositivos electrónicos"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Electrónica",
  "description": "Dispositivos electrónicos"
}
```

### 2. Obtener todas las categorías
**GET /categories**

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Electrónica",
    "description": "Dispositivos electrónicos"
  },
  {
    "id": 2,
    "name": "Cámaras CCTV",
    "description": "Cámaras de seguridad para circuito cerrado de televisión"
  }
]
```

### 3. Obtener una categoría por ID
**GET /categories/{id}**

**Ejemplo:**
**GET /categories/1**

**Response (200 OK):**

```json
{
  "id": 1,
  "name": "Cables eléctricos",
  "description": "Cables para instalaciones eléctricas residenciales"
}
```

### 4. Buscar categorías por nombre
**GET /categories/search?name=cctv**

**Response (200 OK):**

```json
[
  {
    "id": 2,
    "name": "Cámaras CCTV",
    "description": "Cámaras de seguridad para circuito cerrado de televisión"
  }
]
```

### 5. Eliminar una categoría por ID

**DELETE /categories/{id}**

Ejemplo:
**DELETE /categories/1**

**Response (200 OK):**

```bash
"Categoría eliminada con éxito"
```