## Geetings..!! from URL Shortner
![image](https://github.com/user-attachments/assets/8022aba0-5ba3-46f3-bea3-ada1d839d647)
![image](https://github.com/user-attachments/assets/92de67c6-57cc-4f7c-9d25-edccae184ab6)


# URL Shortener Application

A lightweight and efficient URL Shortening service built with **Kotlin** and **Spring Boot**. This application allows users to shorten long URLs into concise, easy-to-share links.

## Features

- Shorten long URLs into compact links
- Redirect shortened URLs to the original URL
- Basic URL validation for input safety
- REST API support for URL shortening
- Environment-based configurations (dev, staging, prod)

## Tech Stack

- **Backend:** Kotlin, Spring Boot
- **Database:** MySQL
- **View:** Thymeleaf (for the web interface)

## Project Structure

```
url-shortner/
├── .gitignore
├── mvnw / mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── kotlin
│   │   │   └── com.inspire17.urlshortner
│   │   │       ├── UrlShortnerApplication.kt       # Application entry point
│   │   │       ├── controllers
│   │   │       │   ├── UrlController.kt           # Handles web UI requests
│   │   │       │   └── UrlRestController.kt       # Handles REST API requests
│   │   │       ├── entity
│   │   │       │   └── URLMap.kt                 # URL entity model
│   │   │       ├── helper
│   │   │       │   └── Helper.kt                 # Utility methods (URL validation)
│   │   │       ├── interface
│   │   │       │   └── UrlRepo.kt               # JPA Repository for URL mapping
│   │   │       └── service
│   │   │           └── UrlShortenerService.kt   # Business logic for URL shortening
│   │   ├── resources
│   │   │   ├── application.properties           # Common configurations
│   │   │   ├── application-dev.properties      # Dev-specific configs
│   │   │   ├── application-staging.properties  # Staging-specific configs
│   │   │   ├── application-prod.properties     # Production-specific configs
│   │   │   └── templates
│   │   │       └── home.html                   # Web UI page
│   └── test
│       └── kotlin
│           └── com.inspire17.urlshortner
│               └── UrlShortnerApplicationTests.kt # Unit tests
```

## Getting Started

### Prerequisites

- **JDK 17+**
- **Maven**
- **MySQL** (or any SQL-compatible DB)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/inspire17/url-shortner.git
   cd url-shortner
   ```

2. **Configure Database:**
   Update `application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/urlshortner
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the Application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the Web Interface:**
   Open [http://localhost:8080](http://localhost:8080)

## API Endpoints

### Shorten URL

- **Endpoint:** `POST /shorten`
- **Request Param:** `url` (String)
- **Response:** Shortened URL

**Example:**
```bash
curl -X POST "http://localhost:8080/shorten" -d "url=https://example.com"
```

### Redirect to Original URL

- **Endpoint:** `GET /{shortcode}`
- **Behavior:** Redirects to the original URL.

**Example:**
```bash
http://localhost:8080/abc123
```
