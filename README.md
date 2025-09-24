# Inventory Management System

This is a backend project developed with Java 17, Spring Boot, and PostgreSQL that provides a RESTful API for inventory management. It allows administrators to manage products, categories, and stock levels through full CRUD (create, read, update, delete) operations with data persisted in a relational database.

The project was inspired by a real business need and is designed with a focus on clean architecture, scalability, and backend best practices. It follows the Model-View-Controller (MVC) architecture, making the codebase modular, maintainable, and easy to extend.

## Features
Manage categories (create, update, delete, list).
Manage items (create, update, delete, list).
RESTful API endpoints with proper HTTP methods and response codes.

## Tech Stack
Language: Java 17
Frameworks: Spring Boot, Spring Data JPA
Database: PostgreSQL
Architecture: MVC (Model–View–Controller)
Build Tool: Maven

```bash
src/
├── main/java/com/efitel/inventory
│   ├── config/         # Application configuration (beans, messages, etc.)
│   ├── controller/     # REST controllers (API endpoints)
│   ├── exception/      # Global exception handling
│   ├── mapper/         # Entity–DTO mappers
│   ├── models/         # Entities (JPA) and DTOs
│   ├── repository/     # Data persistence layer (Spring Data JPA)
│   └── services/       # Business logic layer
└── main/resources/
    ├── application.properties   # Main application configuration
    └── messages.properties      # Message resources
```



## API Endpoints

### Categories

| method | Endpoint                       | Description                                 |
|--------|--------------------------------|---------------------------------------------|
| POST   | `/categories`                  | Create or update a category                 |
| GET    | `/categories`                  | Retrieve all categories                     |
| GET    | `/categories/{id}`             | Retrieve a category by its ID               |
| GET    | `/categories/search?name=abc`  | search categories by name                   |
| DELETE | `/categories/{id}`             | Delete a category by its ID                 |

---

### Items

| method | Endpoint                                | Description                                |
|--------|-----------------------------------------|--------------------------------------------|
| POST   | `/inventoryItem`                        | Create or update an item                   |
| GET    | `/inventoryItem`                        | Retrieve all items                         |
| GET    | `/inventoryItem/{id}`                   | Retrieve an item by its ID                 |
| GET    | `/inventoryItem/search?name=abc`        | search items by names                      |
| DELETE | `/inventoryItem/{id}`                   | Delete an item by its ID                   |


## Requirements

Before running the project, make sure you have installed:

- **Java 17 or higher**
- **Maven**
- **PostgreSQL**
- **Git (to clone the repository)**

## Installation and Execution

### 1. Clone the repository

```bash
git clone https://github.com/andres2912/inventory.git
cd inventory
```

### 2. Set up the database
Make sure PostgreSQL is running and create the database:

```bash
CREATE DATABASE inventory_db;
```

### 3. Configure application.properties
Edit the file src/main/resources/application.properties with your PostgreSQL credentials:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
spring.datasource.username=su_usuario
spring.datasource.password=su_contraseña
```

### 4. Build and run the application

```bash
mvn clean install
mvn spring-boot:run
```


### 5. API Usage

### 1. Create or update a category
**POST** `/categories`

**Request (JSON):**
```json
{
  "name": "Electronics",
  "description": "Electronic devices"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Electronics",
  "description": "Electronic devices"
}
```

### 2. Get all categories
**GET /categories**

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Electronics",
    "description": "Electronic devices"
  },
  {
    "id": 2,
    "name": "CCTV Cameras",
    "description": "Closed-circuit television security cameras"
  }
]
```

### 3. Get a category by ID
**GET /categories/{id}**

**Example:**
**GET /categories/1**

**Response (200 OK):**

```json
{
  "id": 1,
  "name": "Electrical Cables",
  "description": "Cables for residential electrical installations"
}
```

### 4. Search categories by name
**GET /categories/search?name=cctv**

**Response (200 OK):**

```json
[
  {
    "id": 2,
    "name": "CCTV Cameras",
    "description": "Closed-circuit television security cameras"
  }
]
```

### 5. Delete a category by ID

**DELETE /categories/{id}**

Example::
**DELETE /categories/1**

**Response (200 OK):**

```bash
"Category deleted successfully"
```