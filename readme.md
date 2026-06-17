# Contact Management System - Spring Boot REST API

A robust Java-based backend application built with **Spring Boot** to manage contact information efficiently. This project provides a RESTful interface for performing various operations on contact data with database persistence and pagination support.

## 🚀 Features

- **RESTful Endpoints**: Clean and intuitive API for contact management.
- **Database Persistence**: Integrated with **Spring Data JPA** and **MySQL** for reliable data storage.
- **Search Capabilities**: Fuzzy name search using "like" queries.
- **Pagination**: Optimized retrieval of large datasets using Spring's `Pageable`.
- **Email Support**: Includes **Spring Mail** configuration for future notification features.

## 🛠️ Technologies & Tools

- **Java**: 17
- **Framework**: Spring Boot
- **Persistence**: Spring Data JPA / Hibernate
- **Database**: MySQL
- **Build Tool**: Maven
- **Email**: Spring Boot Starter Mail

## 📦 Dependencies

The project utilizes several core Spring Boot starters:
- `spring-boot-starter-webmvc`: For building RESTful web services.
- `spring-boot-starter-data-jpa`: For database interaction and ORM.
- `spring-boot-starter-mail`: For email sending capabilities.
- `mysql-connector-j`: MySQL JDBC driver for connectivity.

## 🚦 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/contacts/contactById/{cid}` | Retrieve a specific contact by its unique ID. |
| **GET** | `/contacts/likename/{name}` | Search for contacts with names matching the search string. |
| **GET** | `/contacts/allContacts/{pageno}/{pagesize}` | Fetch a paginated list of all contacts. |

## ⚙️ Setup & Configuration

### Prerequisites
- JDK 17 or higher
- Maven 3.x
- MySQL Server

### Database Configuration
Update the `src/main/resources/application.properties` file with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run the following command:
   ```bash
   mvn spring-boot:run
   ```

## 🏗️ Project Structure
- `org.harsh.bootrestapp1.controller`: Contains REST controllers.
- `org.harsh.bootrestapp1.services`: Business logic implementation.
- `org.harsh.bootrestapp1.entity`: JPA Entity classes.
- `org.harsh.bootrestapp1.dto`: Data Transfer Objects for API responses.
- `org.harsh.bootrestapp1.repository`: Data access layer.
