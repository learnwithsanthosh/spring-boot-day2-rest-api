# Spring Boot Day 2 – REST API

This project is part of my daily learning journey to become a Spring Boot expert and full-stack developer.

## 🔧 What This Project Does

- Creates a simple REST API using Spring Boot
- Supports `GET` and `POST` operations
- Handles a custom `Note` entity (with title and content)

## 🧪 Endpoints

| Method | Endpoint       | Description             |
|--------|----------------|-------------------------|
| GET    | /api/notes     | Returns all notes       |
| POST   | /api/notes     | Adds a new note (JSON)  |

## 📦 Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Web
- Maven

## 🚀 How to Run

```bash
./mvnw spring-boot:run

api endpoint:http://localhost:8080/api/notes

Sample output
[
{
"name": "Santhosh",
"subject": "Maths"
},
{
"name": "mani",
"subject": "Physics"
}
]
```
## 📅 Day 3 – Spring Boot: Layered Architecture (Service + Repository)

### ✅ What I Did
- Refactored my Notes app to follow the **three-layer architecture**:
    - **Controller Layer** – Handles HTTP requests
    - **Service Layer** – Contains business logic
    - **Repository Layer** – Interacts with the database using JPA
- Used my **Docker-based local SQL database** for data persistence
- Tested all endpoints using **Postman**
- Committed code updates with clear structure

### 🔧 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Docker (for SQL database)
- Maven
- Postman (for testing)

### 📁 Folder/Project Structure
src/
└── controller/
└── service/
└── repository/
└── dao/
└── application.properties
