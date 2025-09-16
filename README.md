# Inventory Management System

This is a backend project developed with Java 17, Spring Boot, and PostgreSQL that provides a RESTful API for inventory management. It allows administrators to manage products, categories, and stock levels through full CRUD (create, read, update, delete) operations with data persisted in a relational database.

The project was inspired by a real business need and is designed with a focus on clean architecture, scalability, and backend best practices. It follows the Model-View-Controller (MVC) architecture, making the codebase modular, maintainable, and easy to extend.

##Features
Manage categories (create, update, delete, list).
Manage items (create, update, delete, list).
RESTful API endpoints with proper HTTP methods and response codes.

## Tech Stack
Language: Java 17
Frameworks: Spring Boot, Spring Data JPA
Database: PostgreSQL
Architecture: MVC (Model–View–Controller)
Build Tool: Maven

src/
 ├── main/java/com/efitel/inventory
 │    ├── controller/     # REST Controllers (API endpoints)
 │    ├── service/        # Business logic
 │    ├── repository/     # Database access (JPA)
 │    └── model/          # Entities & DTOs
 └── main/resources/
      ├── application.yml # Configurations
      └── schema.sql      # DB schema (if used)



## API Endpoints

### Categories

| Method | Endpoint                       | Description                          |
|--------|--------------------------------|--------------------------------------|
| POST   | `/categories`                  | Create a new category                |
| GET    | `/categories`                  | Get all categories                   |
| GET    | `/categories/{id}`             | Get category by ID                   |
| GET    | `/categories/by-name/{name}`   | Get category by exact name           |
| GET    | `/categories/search?name=abc`  | Get multiple categories by name (search) |
| PATCH  | `/categories/by-name/{name}`   | Update a category by name            |
| DELETE | `/categories/by-name/{name}`   | Delete a category by name            |