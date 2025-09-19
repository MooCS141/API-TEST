# API-TEST 🧪

โปรเจกต์ตัวอย่างสำหรับทดสอบ API ที่สร้างด้วย Spring Boot พร้อมระบบ Authentication และ Authorization โดยใช้ JWT (JSON Web Token)

![Java](https://img.shields.io/badge/Java-21-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green) ![Gradle](https://img.shields.io/badge/Gradle-8.x-orange)

## 🛠️ สิ่งที่ต้องมี (Prerequisites)

ก่อนเริ่มต้น โปรดตรวจสอบว่าคุณได้ติดตั้งโปรแกรมและเครื่องมือต่อไปนี้เรียบร้อยแล้ว:

-   **Visual Studio Code**: พร้อมติดตั้ง Extensions ที่จำเป็น
    -   `Extension Pack for Java`
    -   `Spring Boot Extension Pack`
-   **Java JDK 21**: ดาวน์โหลดได้ที่ [Adoptium](https://adoptium.net/)
    > ⚠️ **สำคัญมาก:** ระหว่างขั้นตอนการติดตั้ง ให้เลือกตัวเลือกเพื่อตั้งค่า `JAVA_HOME` environment variable โดยอัตโนมัติ
    > <img width="495" alt="JAVA_HOME setup option" src="https://github.com/user-attachments/assets/8387d1d7-0720-4cf0-96a6-bf950d69db50" />
-   **XAMPP**: สำหรับสร้าง Web Server และ Database (Apache & MySQL)

---

## 🚀 เริ่มต้นใช้งาน (Getting Started)

ทำตามขั้นตอนต่อไปนี้เพื่อตั้งค่าและรันโปรเจกต์

### 1. ตั้งค่าฐานข้อมูล

1.  เปิดโปรแกรม **XAMPP Control Panel** และกด **Start** ที่โมดูล `Apache` และ `MySQL`
2.  ไปที่ `phpMyAdmin` และสร้างฐานข้อมูลใหม่ชื่อว่า **`testdb`**
3.  เลือกฐานข้อมูล `testdb` ที่เพิ่งสร้าง จากนั้นไปที่แท็บ **SQL**
4.  คัดลอกคำสั่งทั้งหมดจากไฟล์ `data.sql` ในโปรเจกต์นี้มาวาง แล้วกด **Go** เพื่อสร้างตารางและข้อมูลเริ่มต้น

### 2. รัน Backend Server

1.  เปิดโปรเจกต์ใน Visual Studio Code
2.  เปิด Terminal (หรือ Windows PowerShell) แล้วเข้าไปที่โฟลเดอร์ `backend`
3.  รันคำสั่งต่อไปนี้เพื่อเริ่มการทำงานของเซิร์ฟเวอร์:
    ```sh
    ./gradlew bootrun
    ```
4.  เมื่อเซิร์ฟเวอร์ทำงานสำเร็จแล้ว คุณจะสามารถเข้าถึงหน้า API Document ของ API ผ่าน Swagger UI ได้ที่ลิงก์นี้:
    [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

    <img width="1920" alt="Swagger UI page" src="https://github.com/user-attachments/assets/4740804b-d2fe-484f-af0a-bda496062700" />

---

## 📝 วิธีการทดสอบ API (API Walkthrough)

หลังจากรันเซิร์ฟเวอร์เรียบร้อยแล้ว ให้ทำตามขั้นตอนต่อไปนี้เพื่อทดสอบ Endpoint ต่างๆ

### 1. สร้างบัญชีผู้ใช้ (Admin)

ขั้นแรกสุด ให้สร้างบัญชีผู้ใช้ที่มีสิทธิ์เป็น `ADMIN` ผ่าน Endpoint นี้:
`POST /auth/register/admin`

<img width="1920" alt="Register admin user" src="https://github.com/user-attachments/assets/03601843-1e48-4e00-b526-6dc0aeb5233f" />

### 2. เข้าสู่ระบบเพื่อรับ Token

เมื่อสร้างบัญชีสำเร็จแล้ว ให้เข้าสู่ระบบด้วยข้อมูลที่เพิ่งลงทะเบียนไปที่ Endpoint:
`POST /auth/login`

คุณจะได้รับ **`token`** กลับมาใน Response Body **ให้คัดลอก (Copy) ค่า `token` ที่ได้รับเก็บไว้**สำหรับขั้นตอนถัดไป

<img width="1920" alt="Login and receive token" src="https://github.com/user-attachments/assets/5b0b6fac-a456-4aea-8292-74cc281a5dc3" />

### 3. การยืนยันตัวตน (Authorize)

ตอนนี้ Endpoint ในส่วน `/users` จะสามารถใช้งานได้แค่ `GET` เท่านั้น หากต้องการใช้ Method อื่นๆ (เช่น `POST`, `PUT`, `DELETE`) ซึ่งจำกัดสิทธิ์ไว้สำหรับ `ADMIN` คุณต้องทำการ Authorize ก่อน

1.  ที่หน้า Swagger UI กดปุ่ม **Authorize** สีเขียวด้านขวาบน

    <img width="636" alt="Authorize button" src="https://github.com/user-attachments/assets/14560cfe-7fec-4812-9991-a4f2ce60640a" />

2.  ในหน้าต่างที่ปรากฏขึ้น ให้พิมพ์คำว่า **`Bearer`** ตามด้วยเว้นวรรค และวาง `token` ที่คัดลอกมาจากขั้นตอนก่อนหน้าลงไป จากนั้นกด **Authorize**
    > ตัวอย่าง: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ...`

3.  ตอนนี้คุณสามารถทดลองใช้งาน Endpoint อื่นๆ ใน `/users` ที่ต้องใช้สิทธิ์ `ADMIN` ได้แล้ว

<img width="1920" alt="Using an authorized endpoint" src="https://github.com/user-attachments/assets/30c56c17-e9cd-4959-9792-932ca229f309" />

> ℹ️ **หมายเหตุ:** หากคุณไม่ใส่ Token หรือ Token ที่ใช้หมดอายุ เซิร์ฟเวอร์จะตอบกลับด้วยสถานะ `HTTP 401 Unauthorized`

### (เสริม) การตรวจสอบ Token

คุณสามารถนำค่า Token ที่ได้รับไปถอดรหัสเพื่อดูข้อมูล Payload (เช่น `sub`, `iat`, `exp`) และวันหมดอายุได้ที่เว็บไซต์ [jwt.io](https://jwt.io/)

<img width="1920" alt="Checking token on jwt.io" src="https://github.com/user-attachments/assets/7b140caa-f0e1-4d31-b7d1-509f60e9a245" />

---

🎉 **Enjoy!**
ตอนนี้คุณสามารถทดลองใช้งาน API ได้อย่างเต็มที่ โปรเจกต์นี้มีการจัดการ Validation และ Exception ไว้เป็นอย่างดี ขอให้สนุกกับการทดสอบครับ!
