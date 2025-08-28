# Contact Book Application - Architecture Documentation

## 📋 Table of Contents
- [Overview](#overview)
- [Application Architecture](#application-architecture)
- [How It Works](#how-it-works)
- [Key Components](#key-components)
- [Request Processing Flow](#request-processing-flow)
- [Design Patterns](#design-patterns)
- [Benefits](#benefits)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Exception Handling](#exception-handling)

---

## 🏗️ Overview

**Your Contact Book Application is a Spring Boot REST API** that follows a **layered architecture pattern** with clear separation of concerns. It provides a robust, scalable, and maintainable solution for contact management.

---

## 🎯 Application Architecture

### High-Level Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           CLIENT APPLICATIONS                               │
│                    (Web App, Mobile App, Postman, etc.)                    │
└─────────────────────┬───────────────────────────────────────────────────────┘
                      │ HTTP Requests/Responses
                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                              SPRING BOOT APP                                │
│                                                                             │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                        API LAYER (Controllers)                      │   │
│  │  ┌─────────────────────────────────────────────────────────────┐   │   │
│  │  │                    ContactController                        │   │   │
│  │  │  • GET /contacts          • POST /contact                   │   │   │
│  │  │  • GET /contact/{id}      • PUT /contact                    │   │   │
│  │  │  • DELETE /contact/{id}   • GET /search                     │   │   │
│  │  │  • GET /count                                                │   │   │
│  │  └─────────────────────────────────────────────────────────────┘   │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
│                                    │                                      │
│                                    ▼                                      │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                      SERVICE LAYER                                  │   │
│  │  ┌─────────────────────────────────────────────────────────────┐   │   │
│  │  │                    ContactService                             │   │   │
│  │  │  • Business Logic         • Validation                      │   │   │
│  │  │  • Transaction Management • Exception Handling              │   │   │
│  │  └─────────────────────────────────────────────────────────────┘   │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
│                                    │                                      │
│                                    ▼                                      │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                      DAO LAYER                                     │   │
│  │  ┌─────────────────────────────────────────────────────────────┐   │   │
│  │  │                    ContactDao                                │   │   │
│  │  │  • Database Operations    • SQL Queries                     │   │   │
│  │  │  • Row Mapping           • Connection Management            │   │   │
│  │  └─────────────────────────────────────────────────────────────┘   │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
│                                    │                                      │
│                                    ▼                                      │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                        DATABASE                                    │   │
│  │  ┌─────────────────────────────────────────────────────────────┐   │   │
│  │  │                    PostgreSQL                                │   │   │
│  │  │  • Contact Table         • UUID Primary Keys                │   │   │
│  │  │  • ACID Transactions     • Connection Pooling               │   │   │
│  │  └─────────────────────────────────────────────────────────────┘   │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
│                                                                             │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                    CROSS-CUTTING CONCERNS                          │   │
│  │  • GlobalExceptionHandler    • ApiResponse Wrapper               │   │
│  │  • Data Conversion           • Logging & Monitoring              │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
```

---

## 🔄 How It Works

### 1. Request Flow
```
Client Request → Controller → Service → DAO → Database
Response ← Controller ← Service ← DAO ← Database
```

### 2. Data Flow
```
JSON Request → DTO → Domain → Database
Database → Domain → DTO → JSON Response
```

### 3. Exception Handling
```
Any Layer → Custom Exception → GlobalExceptionHandler → Standardized Error Response
```

---

## 🔧 Key Components

### 📱 API Layer (Controllers)
- **ContactController** - Handles HTTP requests/responses
- **REST endpoints** for CRUD operations
- **Returns standardized ApiResponse** format

### ⚙️ Service Layer
- **ContactService** - Business logic interface
- **ContactServiceImpl** - Business logic implementation
- **Handles validation, business rules, and orchestration**

### 🗄️ Data Access Layer
- **ContactDao** - Data access interface
- **ContactDaoImpl** - Database operations implementation
- **ContactRowMapper** - Maps database rows to domain objects

### 🏷️ Domain & DTOs
- **Contact** - Core domain entity
- **ContactDto** - Data transfer object for API communication
- **Records** - Immutable data structures

### 🛠️ Utilities
- **ApiResponse** - Standardized response wrapper
- **ConvertorUtil** - Data conversion utilities
- **GlobalExceptionHandler** - Centralized exception handling

---

## 📊 Request Processing Flow

### 1. Create Contact Example
```
POST /api/v1/cbook/contact
↓
ContactController.createContact()
↓
ContactService.create()
↓
ContactDao.create()
↓
Database INSERT
↓
Return ApiResponse with created contact
```

### 2. Get Contact Example
```
GET /api/v1/cbook/contact/{id}
↓
ContactController.getContactById()
↓
ContactService.getContactById()
↓
ContactDao.findById()
↓
Database SELECT
↓
Return ApiResponse with contact data
```

---

## 🎨 Design Patterns

### 1. Layered Architecture
- **Separation of concerns** between layers
- **Dependency injection** for loose coupling
- **Interface-based design** for testability

### 2. DTO Pattern
- **Data transfer objects** for API communication
- **Domain objects** for business logic
- **Clean separation** of concerns

### 3. Repository Pattern
- **Data access abstraction** through DAO interface
- **Database operation encapsulation**
- **Easy to switch** database implementations

### 4. Exception Handling
- **Centralized exception handling** with GlobalExceptionHandler
- **Custom exceptions** for business logic
- **Standardized error responses** with ApiResponse

---

## 🚀 Benefits

✅ **Scalable** - Easy to add new features and endpoints  
✅ **Maintainable** - Clear separation of concerns  
✅ **Testable** - Each layer can be tested independently  
✅ **Flexible** - Easy to modify business logic or data access  
✅ **Consistent** - Standardized API responses and error handling  
✅ **Professional** - Follows industry best practices  

---

## 🌐 API Endpoints

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| `GET` | `/api/v1/cbook/contacts` | Get all contacts | `ApiResponse<List<ContactDto>>` |
| `GET` | `/api/v1/cbook/contact/{id}` | Get contact by ID | `ApiResponse<ContactDto>` |
| `POST` | `/api/v1/cbook/contact` | Create new contact | `ApiResponse<ContactDto>` |
| `PUT` | `/api/v1/cbook/contact` | Update existing contact | `ApiResponse<ContactDto>` |
| `DELETE` | `/api/v1/cbook/contact/{id}` | Delete contact | `ApiResponse<String>` |
| `GET` | `/api/v1/cbook/search` | Search contacts by name | `ApiResponse<List<ContactDto>>` |
| `GET` | `/api/v1/cbook/count` | Get total contact count | `ApiResponse<Long>` |

---

## 🗃️ Database Schema

### Contact Table Structure
```sql
CREATE TABLE contact (
    id UUID PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(150),
    mobile VARCHAR(20),
    deleted BOOLEAN
);
```

### Fields Description
| Field | Type | Description |
|-------|------|-------------|
| `id` | UUID | Primary key (auto-generated) |
| `name` | VARCHAR(100) | Contact full name |
| `email` | VARCHAR(150) | Email address |
| `mobile` | VARCHAR(20) | Mobile number |
| `deleted` | BOOLEAN | Soft delete flag |

---

## ⚠️ Exception Handling

### Custom Exceptions
- **ContactNotFoundException** - When contact doesn't exist
- **ContactAlreadyExistsException** - When creating duplicate contact

### Exception Handler
- **GlobalExceptionHandlerAdvisor** - Centralized exception handling
- **Standardized error responses** with ApiResponse format
- **Appropriate HTTP status codes** for each exception type

### HTTP Status Codes
| Exception | Status Code | Description |
|-----------|-------------|-------------|
| `ContactNotFoundException` | 404 | Not Found |
| `ContactAlreadyExistsException` | 409 | Conflict |
| `IllegalArgumentException` | 400 | Bad Request |

---

## 📁 Project Structure

```
cbook-app/
├── src/main/java/com/careerit/cbook/
│   ├── api/
│   │   ├── ContactController.java
│   │   └── GlobalExceptionHandlerAdvisor.java
│   ├── service/
│   │   ├── ContactService.java
│   │   └── ContactServiceImpl.java
│   ├── dao/
│   │   ├── ContactDao.java
│   │   ├── ContactDaoImpl.java
│   │   └── ContactRowMapper.java
│   ├── domain/
│   │   └── Contact.java
│   ├── dto/
│   │   └── ContactDto.java
│   ├── exception/
│   │   ├── ContactNotFoundException.java
│   │   └── ContactAlreadyExistsException.java
│   ├── util/
│   │   ├── ApiResponse.java
│   │   └── ConvertorUtil.java
│   └── CbookAppApplication.java
└── src/main/resources/
    └── application.properties
```

---

## 🔄 Response Format

### Success Response
```json
{
  "timestamp": "2024-01-15T10:30:45.123",
  "status": 200,
  "message": "Contacts retrieved successfully",
  "data": [...],
  "error": null,
  "path": null,
  "metadata": null
}
```

### Error Response
```json
{
  "timestamp": "2024-01-15T10:30:45.123",
  "status": 404,
  "message": "Contact with ID 123 not found",
  "data": null,
  "error": "Contact Not Found",
  "path": null,
  "metadata": null
}
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Spring Boot 3.x
- PostgreSQL database
- Maven or Gradle

### Configuration
1. Update `application.properties` with database credentials
2. Create the contact table using the provided SQL schema
3. Run the application using `mvn spring-boot:run`

### Testing
- Use Postman or any REST client to test the endpoints
- All responses follow the standardized ApiResponse format
- Check the exception handling with invalid requests

---

## 📝 Conclusion

This Contact Book application demonstrates a well-architected Spring Boot application with:

- **Clean layered architecture**
- **Standardized API responses**
- **Comprehensive exception handling**
- **Professional code structure**
- **Scalable design patterns**

The architecture provides a solid foundation for building production-ready applications and can serve as a template for future projects.

---

*Last Updated: January 2024*  
*Version: 1.0.0*

