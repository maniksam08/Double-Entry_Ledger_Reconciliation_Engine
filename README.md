<div align="center">

# 📒 Double-Entry Ledger & Reconciliation Engine

**A backend-only banking ledger built with Spring Boot: every transaction balanced, every entry traceable, every mismatch caught.**

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

</div>

---

## ✨ Overview

This project implements the accounting backbone that real financial systems rely on: a **double-entry ledger** paired with a **reconciliation engine**.

In double-entry bookkeeping, every transaction is recorded as at least two entries, a **debit** and a **credit**, that must always sum to zero. Money is never created or destroyed, only moved. The reconciliation engine then compares ledger records against external or expected records to surface discrepancies.

> 🎓 Built for **learning and practice**, to explore how financial systems stay consistent, secure, and auditable.

It is a **pure backend service**: there is no frontend, and everything is exposed through REST APIs.

---

## 🧠 Core Concepts

| Concept | What it means here |
|---|---|
| **Double entry** | Each transaction posts balanced debit and credit entries: total debits = total credits |
| **Immutable ledger** | Entries are appended, not edited, so history stays auditable |
| **Reconciliation** | Ledger records are matched against a reference source, and mismatches are flagged |
| **Consistency first** | Transactional boundaries protect balances from partial or corrupt writes |

```text
   Transfer ₹1,000  (Account A ➜ Account B)

   ┌──────────────┬─────────┬─────────┐
   │ Account      │  Debit  │  Credit │
   ├──────────────┼─────────┼─────────┤
   │ Account A    │  1,000  │         │
   │ Account B    │         │  1,000  │
   ├──────────────┼─────────┼─────────┤
   │ Total        │  1,000  │  1,000  │  ✅ balanced
   └──────────────┴─────────┴─────────┘
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1 (Spring MVC) |
| Persistence | Spring Data JPA + PostgreSQL |
| Caching / Rate-limit store | Redis (reactive, Lettuce) |
| Rate limiting | Bucket4j |
| Security | Spring Security + JWT (jjwt) |
| Resilience | Spring Retry |
| HTTP client | OkHttp |
| Validation | Jakarta Bean Validation |
| Build | Maven (wrapper included) |
| Boilerplate | Lombok |

---

## 🔐 Highlights

- **Balanced postings**: debit and credit entries are recorded together
- **Stateless authentication** with JWT and Spring Security
- **Distributed rate limiting** with Bucket4j backed by Redis
- **Retry logic** for transient failures via Spring Retry
- **Request validation** on incoming payloads
- **Reconciliation engine** to detect mismatches between records

---

## 🚀 Getting Started

### Prerequisites

- JDK **21**
- **PostgreSQL** running locally or remotely
- **Redis** running locally or remotely
- Git (Maven wrapper is bundled, so no separate Maven install is needed)

### 1. Clone

```bash
git clone https://github.com/maniksam08/Double-Entry_Ledger_Reconciliation_Engine.git
cd Double-Entry_Ledger_Reconciliation_Engine
```

### 2. Configure

Set your database, Redis, and JWT settings in `src/main/resources/application.properties`:

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/<your_db>
spring.datasource.username=<your_user>
spring.datasource.password=<your_password>
spring.jpa.hibernate.ddl-auto=update

# Redis
spring.data.redis.host=localhost
spring.data.redis.port=6379
```


### 3. Run

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

The API starts on `http://localhost:8080` by default.

### 4. Test

```bash
./mvnw test
```

---

## 📂 Project Structure

```text
.
├── .mvn/wrapper/        # Maven wrapper
├── src/
│   ├── main/
│   │   ├── java/        # Application source (com.BankSystem.Ledger)
│   │   └── resources/   # Configuration
│   └── test/            # Tests
├── mvnw / mvnw.cmd      # Maven wrapper scripts
└── pom.xml              # Dependencies & build config
```

---

## 🗺️ Roadmap

- [ ] API documentation (OpenAPI / Swagger)
- [ ] Dockerfile and `docker-compose` for Postgres + Redis
- [ ] Expanded unit and integration test coverage
- [ ] CI pipeline with GitHub Actions
- [ ] Reconciliation reports and scheduled runs

---

## 💡 What I Learned

- Modeling money movement with **double-entry accounting** principles
- Keeping data consistent with **transactions** in JPA and PostgreSQL
- Securing REST APIs with **JWT and Spring Security**
- Protecting endpoints with **Redis-backed rate limiting**
- Designing a backend around **auditability and correctness**

---

## 📄 License

This project is for educational purposes. Add a license of your choice (e.g. MIT) before wider distribution.

---

<div align="center">

Built with ☕ and Spring Boot by [Pratham Arora](https://github.com/maniksam08)

⭐ If you found this useful, consider giving it a star!

</div>
