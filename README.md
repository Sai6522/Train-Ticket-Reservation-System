# Train Ticket Reservation System

### About:
This project is about the Train-Ticket-Reservation-System which is used to view Train Schedule, search trains, Seat availability, Train timings. We can also enquire about fare of different trains. We can get information about train between two stations. We can book seats online. This provides a safe and secure seat reservation system. 
### Online Train Information and Reservation
<span style="color:blue">**This Website is built for following purpose:-**</span>
- View Trains Schedule
- Search Trains
- Seat Availability
- Train Timings
- Fare Enquiry
- Trains Between Stations
- Booking seats online.
- Login and Logout Security
- Password Changes
- Payment Gateway
- Ticket Booking History

<span style="color:blue">**The Admin have the following access to this website:-**</span>
- Login
- Add Trains
- Update Trains
- Remove  or cancle Trains
- View Trains
- Profile Edit
- Logout

<span style="color:blue">**The Users have the following Access:-**</span>
- Register
- Login
- View Trains
- Check Seat Availability
- Search Trains
- Train Avaiablity and Fare Between Stations
- Books Tickets
- View Booking History
- View Profile
- Update Profile
- Change Password
- Logout

### Technologies used:-
1. Front-End Development:
- HTML
- CSS
- Bootstrap

2. Back-End Development
- Java [J2EE]
- JDBC
- Servlet
- MySQL Database

### ==== Software And Tools Required ======
- Git
- Java JDK 8+
- Eclipse IDE / IntelliJ IDEA / VS Code
- Apache Maven
- Tomcat v8.0+
- MySQL Database
- MySQL Workbench (Optional)

### ========== MySQL Database Setup ===========

STEP 1: Install and start MySQL server

STEP 2: Open MySQL command line or MySQL Workbench

STEP 3: Create database and tables by running:

```SQL
CREATE DATABASE reservation;
USE reservation;

-- Run the mysql_schema.sql file provided in the project
SOURCE mysql_schema.sql;
```

STEP 4: Verify tables are created:
```SQL
SHOW TABLES;
SELECT * FROM ADMIN;
SELECT * FROM CUSTOMER;
SELECT * FROM TRAIN;
SELECT * FROM HISTORY;
```

Default Login Credentials:
- Admin: admin@demo.com / admin
- User: shashi@demo.com / shashi
	
### ====== Running the Project ===========

#### Method 1: Using Maven and Embedded Tomcat (Recommended)

Step 1: Clone the repository
```bash
git clone https://github.com/Sai6522/Train-Ticket-Reservation-System.git
cd Train-Ticket-Reservation-System
```

Step 2: Set up MySQL database (follow database setup steps above)

Step 3: Build and run the project
```bash
mvn clean install
java -jar target/dependency/webapp-runner.jar --port 8083 target/TrainBook-1.0.0-SNAPSHOT.war
```

Step 4: Access the application at: http://localhost:8083/

#### Method 2: Using IDE (Eclipse/IntelliJ)

Step 1: Import project as Maven project
Step 2: Configure Tomcat server in IDE
Step 3: Deploy and run on Tomcat server
Step 4: Access at: http://localhost:8083/trainbook/



## Project Features

### Core Functionality
- **User Registration & Authentication**: Secure login/logout system
- **Train Search & Booking**: Search trains between stations and book tickets
- **Admin Panel**: Complete train management system for administrators
- **Payment Integration**: Secure payment processing for ticket booking
- **Booking History**: Track all previous bookings and transactions
- **Profile Management**: Update user profiles and change passwords

### Technical Features
- **Database Integration**: MySQL database with optimized queries
- **Session Management**: Secure session handling and timeout
- **Input Validation**: Server-side validation for all forms
- **Responsive Design**: Mobile-friendly user interface
- **Error Handling**: Comprehensive error handling and user feedback

## Screenshots

*Screenshots showcase the main features of the application including login, booking, and admin panels.*

---

## Author

**Sai** - Full Stack Developer

## License

This project is open source and available under the [MIT License](LICENSE).
