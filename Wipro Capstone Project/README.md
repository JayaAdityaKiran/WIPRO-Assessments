# 🎓 DoConnect Microservices — System Documentation

The **DoConnect** system is developed as a **scalable Microservices Architecture** using **Spring Boot**.  
Each service operates independently with its own database, exception handling, and REST APIs.  
The system uses an **API Gateway** and **Eureka** for routing and service discovery.

---

## 🚀 Project Overview

This system consists of the following microservices:

- **User Service** – User registration, login, OTP flow, password reset  
- **Admin Service** – Admin authentication and moderation (user & content management)  
- **QnA Service** – Questions, answers, comments, likes, thread management  
- **Chat Service** – One-to-one messaging between users  
- **Eureka Server** – Service registry & discovery  
- **API Gateway** – Central routing for all microservices  

### Architecture Highlights
- Independent deployment  
- REST-based communication  
- Dedicated **H2 in-memory database** per microservice  
- Centralized routing via API Gateway  
- Service registration & discovery via Eureka  
- OTP-based password recovery  
- Global exception handling  

---

## 🧑‍💻 User Module — Features

### 🔐 Authentication
- User registration  
- Login with email + password  
- Forgot password (OTP sent via email)  
- Verify OTP  
- Reset password  

### ❓ Q&A Operations
- Create questions (requires admin approval)  
- View approved questions  
- Search questions  
- Submit answers (requires admin approval)  
- Like / Unlike answers  
- Comment on answers  

### 📊 User Dashboard
- Total questions asked  
- Total answers provided  
- Recent activity  

### 💬 Chat
- Send message to another user  
- Retrieve conversation history  

---

## 🛠 Admin Module — Features

### 🔐 Authentication
- Admin registration  
- Admin login  

### 📝 Moderation

#### Questions
- Approve questions  
- Close threads  
- Delete questions  

#### Answers
- Approve answers  
- Delete answers  

#### Users
- Activate / Deactivate users  
- View all users  

### 📋 Admin Dashboard
- Pending questions  
- Pending answers  
- User list  
- Moderation tools  

---

## 🧩 Microservices Overview

| Service | Responsibility |
|--------|----------------|
| **User Service** | User onboarding, OTP, password reset |
| **Admin Service** | Admin login, user management, moderation |
| **QnA Service** | Questions, answers, comments, likes |
| **Chat Service** | User messaging |
| **Eureka Server** | Service registry |
| **API Gateway** | Routing and request forwarding |

---

## 🖥️ Console Information

### H2 Database Console  
Each microservice uses its own in-memory H2 database.  
It can be accessed through the service’s local console page.

### Eureka Dashboard  
Shows all registered microservices and their statuses.

### API Gateway Entry Point  
All client requests pass through the API Gateway and are routed to the appropriate microservice.

---

## 🧪 Technologies Used

| Layer | Technologies |
|------|--------------|
| Backend | Spring Boot, Microservices, Spring MVC, Spring Data JPA |
| Database | H2 (In-memory) |
| Service Discovery | Eureka |
| API Gateway | Spring Cloud Gateway |
| Email | Spring Mail + Mailtrap |
| Communication | REST APIs |
| Build Tool | Maven |

---

## 📦 Key System Features
- Distributed microservices architecture  
- H2 database per service  
- OTP-based password reset  
- Admin approval workflow  
- Likes and comments functionality  
- One-to-one messaging microservice  
- Global exception handling  
- Clean backend implementation  

---

## ✍ Author

**Jaya Aditya**  
📧 **tjak2005@gmail.com**
