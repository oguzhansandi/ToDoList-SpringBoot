# 📌 ToDo List - Spring Boot & PostgreSQL

Bu proje, **Spring Boot** ve **PostgreSQL** kullanılarak geliştirilmiş bir **To-Do List** uygulamasıdır. Kullanıcılar görev ekleyebilir, tamamlandı olarak işaretleyebilir ve silebilir.

---

## 📜 Özellikler

- ✅ Yeni görev ekleme
- ✅ Görevleri tamamlandı olarak işaretleme (Toggle)
- ✅ Görevleri silme
- ✅ PostgreSQL ile kalıcı veri saklama
- ✅ Görevlerin durumunu değiştirdiğinde sayfa sırası bozulmaz

---

## 🔧 Kullanılan Teknolojiler

- **Java 17**
- **Spring Boot** (Spring MVC, Spring Data JPA)
- **Thymeleaf** (Template Engine)
- **PostgreSQL** (Kalıcı veritabanı)

---

## 📦 Kurulum & Çalıştırma

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/oguzhansandi/ToDoList-SpringBoot.git
   cd ToDoList-SpringBoot

2. Maven bağımlılıklarını yükleyin ve uygulamayı başlatın:
  ```bash
    mvn spring-boot:run
  ```
3. Uygulamayı tarayıcıda açın: 👉 http://localhost:8080
4. 🔧 PostgreSQL Konfigürasyonu
application.properties dosyasında PostgreSQL ayarlarını yapılandırın:
```bash
properties
Kodu kopyala
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```
📌 Not: PostgreSQL yüklü olmalı ve todolist adında bir veritabanı oluşturulmuş olmalıdır.

## 📂 API Endpointleri

| Method | Endpoint           | Açıklama |
|--------|--------------------|----------|
| `POST` | `/`                | Yeni görev ekler |
| `GET`  | `/delete/{id}`     | Belirtilen ID’ye sahip görevi siler |
| `GET`  | `/toogle/{id}`     | Görevin tamamlandı/tamamlanmadı durumunu değiştirir |



