# Java-Consultation-Booking-System
A Java-based desktop application built with Apache NetBeans that allows university students to book, view, and reschedule consultation appointments with lecturers. The system supports user login, appointment tracking, rescheduling requests, and feedback features for both students and lecturers. All data is stored and managed using text files.

## 🚀 Features

### 👨‍🎓 Students
- **Register** with an ID starting with `ST` (e.g., `ST123`)
- **Login** to access features
- **Book** available consultation slots
- **View** upcoming and past consultation history
- **Request** a reschedule for a booked appointment
- **Leave feedback** after a consultation

### 👩‍🏫 Lecturers
- **Register** with an ID starting with `LT` (e.g., `LT456`)
- **Login** to manage their consultation slots
- **Add** new consultation slots
- **View** all upcoming bookings
- **View consultation history** and provide feedback
- **Approve or reject** student reschedule requests

---

## 🛠️ How It Works

1. **Registration and Login:**
   - **Students** register with IDs starting with `ST` (e.g., `ST123`).
   - **Lecturers** register with IDs starting with `LT` (e.g., `LT456`).
   
2. **Data Storage:**
   - When first run, the app creates two files if they don't already exist:
     - `user.txt` – stores user credentials (ID, role)
     - `consultation.txt` – stores appointment details
   
3. **Student Features:**
   - Students can book consultations, view their history, and request reschedules. 
   - Reschedule requests are sent to lecturers, who can approve or reject them.
   - Students can leave feedback for consultations in the history section.

4. **Lecturer Features:**
   - Lecturers can add new consultation slots, view all upcoming bookings, and manage reschedules.
   - They can approve or reject students' reschedule requests.
   - Lecturers can provide feedback on consultations in the history page.

---
