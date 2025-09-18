# API-TEST

สิ่งที่ต้องมี
- โปรแกรม Visual Studio Code IDE (ลง Extention : Extension Pack for Java, Spring Boot Extension Pack)
- Java JDK 21 (โหลดได้ที่ https://adoptium.net/) (ระหว่างขั้นตอน Downloads กด set or override JAVA_HOME ด้วยสำคัญมาก)
- <img width="495" height="387" alt="image" src="https://github.com/user-attachments/assets/8387d1d7-0720-4cf0-96a6-bf950d69db50" />
- โปรแกรม XAMPP

1. เปิดใช้งาน Apache และ MySQL ใน XAMPP
2. สร้างตารางใหม่ใน phpMyAdmin ตั้งชื่อว่า testdb
3. COPY คำสั่ง SQL ในไฟล์ data.sql ไป INSERT ในตาราง testdb
4. เข้าไปในโฟลเดอร์ backend พิมพ์ใน Windows PowerShell : ./gradlew runboot
5. เปิด Web Browser ไปที่ลิงค์ http://localhost:8080/swagger-ui/index.html
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/4740804b-d2fe-484f-af0a-bda496062700" />

ขั้นแรกสร้างบัญชีผู้ใช้งานก่อน POST /auth/register/admin
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/03601843-1e48-4e00-b526-6dc0aeb5233f" />

เมื่อ Register เสร็จแล้ว ไป Login ต่อเลยที่ POST /auth/login จะได้ Token ให้ Copy Token ไว้
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/5b0b6fac-a456-4aea-8292-74cc281a5dc3" />

กด Authorize
<img width="636" height="385" alt="image" src="https://github.com/user-attachments/assets/14560cfe-7fec-4812-9991-a4f2ce60640a" />

ตอนนี้ใช้งานใน /users ได้แค่ GET
ใส่ Token หลังจากนี้จะสามารถใช้งาน Method อื่นใน /users ได้เพราะจำกัด Role ไว้ ให้ใช้ได้แค่ ADMIN
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/30c56c17-e9cd-4959-9792-932ca229f309" />

ถ้าไม่ใส่ Token หรือ Token หมดอายุจะ Return HTTP Status 401

วิธีเช็ค Token ไปที่ https://www.jwt.io/
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/7b140caa-f0e1-4d31-b7d1-509f60e9a245" />


สามารถเล่นได้เต็มที่ มีการจัดการ Validation และ Exception ไว้เป็นอย่างดี
