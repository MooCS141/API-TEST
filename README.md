# API-TEST

สิ่งที่ต้องมี
- โปรแกรม Visual Studio Code IDE
- Java JDK 21 (โหลดได้ที่ https://adoptium.net/) (ระหว่างขั้นตอน Downloads กด set or override JAVA_HOME ด้วยสำคัญมาก)
- <img width="495" height="387" alt="image" src="https://github.com/user-attachments/assets/8387d1d7-0720-4cf0-96a6-bf950d69db50" />
- โปรแกรม XAMPP

1. เปิดใช้งาน Apache และ MySQL ใน XAMPP
2. สร้างตารางใหม่ใน phpMyAdmin ตั้งชื่อว่า testdb
3. COPY คำสั่ง SQL ในไฟล์ data.sql ไป INSERT ในตาราง testdb
4. เข้าไปในโฟลเดอร์ backend พิมพ์ใน Windows PowerShell : ./gradlew runboot
5. เปิด Web Browser ไปที่ลิงค์ http://localhost:8080/swagger-ui/index.html
