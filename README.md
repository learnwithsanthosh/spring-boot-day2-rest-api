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