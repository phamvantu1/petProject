# Project Name

## Overview
Mô tả ngắn gọn về dự án.

Ví dụ:
Hệ thống quản lý khách hàng được xây dựng bằng Java Spring Boot, hỗ trợ đồng bộ dữ liệu từ CRM, quản lý hợp đồng điện tử và cung cấp RESTful API cho các hệ thống khác.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Redis
- Maven
- Docker

## Features

- Quản lý khách hàng
- Quản lý hợp đồng
- Đồng bộ dữ liệu từ CRM
- RESTful API
- Redis Cache
- Redis Pub/Sub
- Logging và Monitoring

## Project Structure

```text
src
├── main
│   ├── java
│   ├── resources
│   └── webapp
└── test
```

## Installation

### Clone source code

```bash
git clone https://github.com/your-account/project-name.git
```

### Build project

```bash
mvn clean install
```

### Run project

```bash
mvn spring-boot:run
```

Hoặc:

```bash
java -jar target/project-name.jar
```

## Configuration

Cấu hình trong file:

```properties
application.properties
```

Ví dụ:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dbname
spring.datasource.username=postgres
spring.datasource.password=password

spring.redis.host=localhost
spring.redis.port=6379
```

## API Documentation

### Customer API

#### Get Customer List

```http
GET /api/customers
```

#### Get Customer Detail

```http
GET /api/customers/{id}
```

#### Create Customer

```http
POST /api/customers
```

## Database

### Main Tables

| Table | Description |
|---------|-------------|
| crm_customer | Customer information |
| crm_document | Customer documents |
| contract | Contract information |

## Deployment

Build Docker image:

```bash
docker build -t project-name .
```

Run container:

```bash
docker run -p 8080:8080 project-name
```

## Author

- Pham Tu
- Backend Developer
- Java Spring Boot

## License

This project is licensed under the MIT License.


# CRM Customer Sync System

## Demo

[![System Demo](C:\Users\ADMIN\Pictures\cancel.png)](https://www.youtube.com/watch?v=VIDEO_ID)

Click vào ảnh để xem video demo.