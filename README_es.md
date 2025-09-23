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
| POST   | `/categories`                  | Crear una nueva categoría                   |
| GET    | `/categories`                  | Obtener todas las categorías                |
| GET    | `/categories/{id}`             | Obtener una categoría por ID                |
| GET    | `/categories/by-name/{name}`   | Obtener una categoría por nombre exacto     |
| GET    | `/categories/search?name=abc`  | Buscar múltiples categorías por nombre      |
| PATCH  | `/categories/by-name/{name}`   | Actualizar una categoría por nombre         |
| DELETE | `/categories/by-name/{name}`   | Eliminar una categoría por nombre           |
