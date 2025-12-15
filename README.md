# ContactInfoWebApp
This is a Java-based web application designed to help users securely manage their personal contacts. It allows registered users to create, view, update, and delete contact info through an intuitive web interface. The app was built using Java EE technologies with proper separation of concerns (Servlets, DAO, Entity classes).

🚀 Features
User registration and login system
Secure password storage using BCrypt hashing
Add, view, edit, and delete personal contacts
Each contact is linked to a specific user account
Session-based authentication and access control
Clean and responsive UI using JSP, HTML, CSS, and Bootstrap
Persistent data storage with Microsoft SQL Server


🛠️ Technologies Used
Java (JDK 8+)
JSP & Servlets (Jakarta EE)
JDBC
Microsoft SQL Server
BCrypt for password hashing
GlassFish Server
HTML, CSS, Bootstrap
NetBeans IDE


🧱 Application Architecture
Presentation Layer: JSP pages (UI)
Controller Layer: Servlets handle requests and responses
Data Access Layer: DAO classes manage database operations
Model Layer: Entity classes represent database tables


🔐 Security Practices
Passwords are never stored in plain text
BCrypt hashing with automatic salting
SQL Injection prevention using PreparedStatement
Session validation to restrict unauthorized access


📌 Use Case
This project demonstrates my practical experience in:
Full-stack Java web development
Secure authentication systems

Database-driven web applications

MVC-style architecture
