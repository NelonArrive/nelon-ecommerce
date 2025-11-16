# 🛒 NELON-ECOMMERCE

**Full-stack Java Spring Boot eCommerce API**

Лёгкий и современный backend-сервис для интернет-магазина. Проект построен на базе **Spring Boot** и реализует основные функции e-commerce платформы: управление товарами, категориями, пользователями и ролями.

---

## 🚀 Основные возможности

* 🔐 **JWT-аутентификация и роли** (Admin / User)
* 📦 **CRUD для продуктов**
* 🏷️ **Категории и привязка товаров**
* 👤 **Управление пользователями**
* 🗃️ **Валидируемые DTO + MapStruct маппинги**
* 🛠️ **Глобальный обработчик ошибок**
* 📄 **Чистая архитектура + модули по слоям**

---

## 🧱 Технологии

* **Java 17+**
* **Spring Boot 3**
* **Spring Security (JWT)**
* **Spring Data JPA / Hibernate**
* **PostgreSQL**
* **MapStruct**
* **Lombok**

---

## 📂 Структура проекта

```
NELON-ECOMMERCE
 ├── controller
 ├── dto
 ├── entities
 ├── exception
 ├── mappers
 ├── repositories
 ├── security
 ├── services
 └── config
```

---

## ▶️ Запуск проекта

1. Настрой `.env` или `application.yaml`
2. Запусти PostgreSQL
3. Выполни:

```
./mvnw spring-boot:run
```

---

## 🔑 Авторизация

Используются **JWT токены**:

* `/auth/login` — вход
* `/auth/register` — регистрация
* Доступы по ролям: **ADMIN**, **USER**

---

## 📘 Планы развития

* Добавление Refresh Token
* Кэширование (Redis)
* Загрузка изображений
* Заказы и корзина
* Админ-панель

---

## 👨‍💻 Автор

**NELON**
Full-stack Developer

