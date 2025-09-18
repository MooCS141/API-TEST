# API-TEST

โปรเจกต์ทดสอบ API ด้วย **Spring Boot + Java 21** พร้อมการทำงานผ่าน **Swagger UI**

---

## 📑 Table of Contents
- [สิ่งที่ต้องเตรียม](#-สิ่งที่ต้องเตรียม)
- [ขั้นตอนการติดตั้งและใช้งาน](#️-ขั้นตอนการติดตั้งและใช้งาน)
  - [ตั้งค่า Database](#1-ตั้งค่า-database)
  - [รัน Backend](#2-รัน-backend)
  - [เปิด Swagger UI](#3-เปิด-swagger-ui)
- [การใช้งาน Authentication](#-การใช้งาน-authentication)
  - [สมัครสมาชิก (Register Admin)](#1-สมัครสมาชิก-register-admin)
  - [เข้าสู่ระบบ (Login)](#2-เข้าสู่ระบบ-login)
  - [ใส่ Token เพื่อ Authorize](#3-ใส่-token-เพื่อ-authorize)
  - [ทดลองใช้งาน API](#4-ทดลองใช้งาน-api)
- [หมายเหตุ](#-หมายเหตุ)
- [สรุป](#-สรุป)

---

## 📦 สิ่งที่ต้องเตรียม

- **Visual Studio Code (IDE)**
  - ติดตั้ง Extensions ที่จำเป็น:
    - [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
    - [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=pivotal.vscode-spring-boot)

- **Java JDK 21**
  - ดาวน์โหลดได้ที่ 👉 [Adoptium.net](https://adoptium.net/)
  - **สำคัญ:** ระหว่างการติดตั้ง กด **set or override JAVA_HOME**

  <img width="495" height="387" alt="jdk-setup" src="https://github.com/user-attachments/assets/8387d1d7-0720-4cf0-96a6-bf950d69db50" />

- **XAMPP** (ใช้ Apache + MySQL)

---

## ⚙️ ขั้นตอนการติดตั้งและใช้งาน

### 1. ตั้งค่า Database
1. เปิดใช้งาน **Apache** และ **MySQL** ผ่าน XAMPP  
2. เข้า **phpMyAdmin** แล้วสร้าง Database ใหม่ชื่อ `testdb`  
3. เปิดไฟล์ `data.sql` → คัดลอกคำสั่ง SQL ไป **INSERT** ลงใน `testdb`

---

### 2. รัน Backend
ไปที่โฟลเดอร์ `backend` แล้วรันคำสั่ง:

```powershell
./gradlew runboot
