# TODO List REST API

Simple and efficient RESTful API for managing TODO tasks, built with Spring Boot, JPA, and MySQL.

## 🚀 Technologies

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL 8.0**
- **Maven**

## 📋 Prerequisites

- JDK 17+
- Maven 3.6+
- MySQL 8.0+ installed and running on port 3307
- Postman (for testing the API)

## 🗄️ Database Setup

1. **Create the database in MySQL:**
```sql
CREATE DATABASE todo;
```

2. **Configure your credentials:**

You have **two options**:

### Option A: Modify the default values (Easiest)

Open `src/main/resources/application.properties` and update the values **after the colons (`:`)**:
```properties
spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3307/todo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Rome}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:your_password_here}
```

For example, if your MySQL password is `secret123`, change it to:
```properties
spring.datasource.password=${DB_PASSWORD:secret123}
```

> 💡 **Note:** The values after `:` are default values used when environment variables are not set. Simply modify these defaults to match your MySQL configuration.

### Option B: Use environment variables (Optional, for production-like setup)

Set environment variables before running the application:

**Windows (PowerShell):**
```powershell
$env:DB_URL="jdbc:mysql://localhost:3307/todo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Rome"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_password"
mvn spring-boot:run
```

**Linux/Mac:**
```bash
export DB_URL="jdbc:mysql://localhost:3307/todo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Rome"
export DB_USERNAME="root"
export DB_PASSWORD="your_password"
mvn spring-boot:run
```

3. The application will automatically create the necessary tables on first run thanks to `spring.jpa.hibernate.ddl-auto=update`.


## 🔌 API Endpoints

The `TaskController` class exposes the following REST endpoints:

| HTTP Method | Endpoint | Description | Request Body |
|-------------|----------|-------------|--------------|
| `GET` | `/tasks` | Retrieve all tasks | - |
| `GET` | `/tasks/{id}` | Retrieve a specific task by ID | - |
| `POST` | `/tasks` | Create a new task | JSON (Task) |
| `PUT` | `/tasks/{id}` | Update an existing task | JSON (Task) |
| `DELETE` | `/tasks/{id}` | Delete a task by ID | - |

## 🧪 Testing with Postman

### Setup Postman Collection

1. **Create a new Collection** in Postman called "TODO API"
2. **Add the following requests:**

---

### 1️⃣ Create a New Task (POST)

- **Method:** `POST`
- **URL:** `http://localhost:8080/tasks`
- **Headers:**
  - `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "title": "Complete project documentation",
  "description": "Write comprehensive README and test all endpoints"
}
```

**Expected Response (200 OK):**
```json
{
  "id": 1,
  "title": "Complete project documentation",
  "description": "Write comprehensive README and test all endpoints"
}
```

---

### 2️⃣ Get All Tasks (GET)

- **Method:** `GET`
- **URL:** `http://localhost:8080/tasks`
- **Headers:** None required

**Expected Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "Complete project documentation",
    "description": "Write comprehensive README and test all endpoints"
  },
  {
    "id": 2,
    "title": "Deploy to production",
    "description": "Configure production environment"
  }
]
```

---

### 3️⃣ Get Single Task (GET)

- **Method:** `GET`
- **URL:** `http://localhost:8080/tasks/1`
- **Headers:** None required

**Expected Response (200 OK):**
```json
{
  "id": 1,
  "title": "Complete project documentation",
  "description": "Write comprehensive README and test all endpoints"
}
```

---

### 4️⃣ Update a Task (PUT)

- **Method:** `PUT`
- **URL:** `http://localhost:8080/tasks/1`
- **Headers:**
  - `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "title": "Updated: Complete project documentation",
  "description": "Updated: Write comprehensive README, test endpoints, and deploy"
}
```

**Expected Response (200 OK):**
```json
{
  "id": 1,
  "title": "Updated: Complete project documentation",
  "description": "Updated: Write comprehensive README, test endpoints, and deploy"
}
```

---

### 5️⃣ Delete a Task (DELETE)

- **Method:** `DELETE`
- **URL:** `http://localhost:8080/tasks/1`
- **Headers:** None required

**Expected Response:** `200 OK` (empty body)

---

## 📁 Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/todo/todo_api/
│   │       ├── controller/
│   │       │   └── TaskController.java    # REST endpoints
│   │       ├── Task.java                  # Entity model
│   │       ├── TaskRepository.java        # JPA repository
│   │       └── TodoApiApplication.java    # Main application
│   └── resources/
│       └── application.properties          # Configuration
└── test/
```

### Key Components

- **TaskController**: Handles HTTP requests with `@RestController` and mapping annotations (`@GetMapping`, `@PostMapping`, etc.)
- **Task**: JPA Entity representing a task in the database
- **TaskRepository**: Spring Data JPA interface extending `CrudRepository` for database operations
- **TodoApiApplication**: Main Spring Boot application class

### Controller Implementation

The controller uses **constructor injection** for `TaskRepository` (Spring best practice) and provides:
- `findAll()` for retrieving all tasks
- `findById()` for single task retrieval with `orElseThrow()` exception handling
- `save()` for creating and updating tasks
- `delete()` for task removal

## 🎓 Learning Points

This project demonstrates:

- ✅ Building REST APIs with Spring Boot
- ✅ CRUD operations with Spring Data JPA
- ✅ MySQL database integration
- ✅ Proper REST controller design with annotations
- ✅ Dependency injection via constructor
- ✅ Configuration management with Spring properties
- ✅ Using environment variables for sensitive data
- ✅ Exception handling with `orElseThrow()`


## 👤 Author

**Your Name**
- GitHub: [@CostanzoMartino](https://github.com/CostanzoMartino)
- LinkedIn: [Costanzo Martino](https://linkedin.com/in/costanzomartino)

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

⭐ If you find this project useful for learning Spring Boot, consider giving it a star!
