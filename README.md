# Age Calculator CLI App

This is a simple Java console application that calculates your age based on your date of birth.

## 📥 Installation

Ensure you have **Java 17+** installed.

   You can download it here:
   https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

### Cloning with IntelliJ IDEA
   - Open IntelliJ IDEA.
   - Click "Get from VCS" (on the welcome screen) or go to **File → New → Project from Version Control**.
   - Paste the repository URL and click **Clone**.
   - Open the project and wait for dependencies to load.

### Cloning with PowerShell (Windows)
   - Open **PowerShell** (`Win + X → Terminal` or `Win + R → powershell`).
   - Run the following to clone the repository:

     ```sh
     git clone https://github.com/lbaidachenko/MhrAssessmentLiudmyla
     ```
### Cloning with macOS Terminal
   - Open the **Terminal**. You can find it in **Applications → Utilities → Terminal**.
   - Run the following to clone the repository:

     ```sh
     git clone https://github.com/lbaidachenko/MhrAssessmentLiudmyla
     ```
 ## 🚀 How to Run  

There are **two ways** to run the program:  

### **1️⃣ Using IntelliJ Terminal**  

1. Open IntelliJ IDEA and navigate to the project root.  
2. Open the **terminal** (`View → Tool Windows → Terminal`).  
3. Run the JAR file with:  

   ```sh
   java -jar app.jar

### **2️⃣ Using Windows PowerShell**  

1. Open **PowerShell** (`Win + X → Terminal` or `Win + R → powershell`).  
2. Navigate to the project folder using:  

   ```sh
   cd "C:\path\to\your\project"
   ```
    (Replace with your actual project path)
3. Run the JAR file with:
   ```sh
   java -jar app.jar
   ```

### **3️⃣ Using macOS Terminal**

1. Open the **Terminal**. You can find it in **Applications → Utilities → Terminal**.
2. Navigate to the project folder using:

   ```sh
   cd /path/to/your/project
   ```
   (Replace with your actual project path)
3. Run the JAR file with:
   ```sh
   java -jar app.jar
   ```

## 🔄 Features

✔ Validates user input for correct date format (YYYY/MM/DD).  
✔ Handles leap year edge cases.  
✔ Provides a retry mechanism for incorrect input.  
✔ Asks if the user wants to restart the program.


## 🛠️ Technologies Used

*   **Java 17**
*   **Logger for logging**
*   **Scanner for user input**

### 🐛 Issue with Date Parsing

During testing the app, I found that Java's `LocalDate.parse()` method doesn't throw an exception for **29th February** on a non-leap year. Instead, it automatically adjusts the date to **28th February**.  
This was handled by adding extra validation to ensure only valid dates are accepted.

## 🧪 Tests

Here are the test cases we used for the application:

### 1. Correct format date (yyyy/MM/dd)
   - **Input:** `1995/05/15`
   - **Expected Output:**  
     `You are 29 years old. Amazing achievement :)`

### 2. Incorrect format date
   - **Input:** `1995-05-15` (Wrong separator)
   - **Expected Output:**  
     `Invalid format, try again, use YYYY/MM/DD format, you have left X attempts`

### 3. Current date - 100 years (sad path)
   - **Input:** Date set to 1925/02/05 (100 years ago)
   - **Expected Output:**  
     `You are 100 years old, what is your secret?`

### 4. Current date - (100 years + 1 day) (sad path)
   - **Input:** Date set to 1925/02/04 (100 years + 1 day)
   - **Expected Output:**  
     `You are 100 years old, what is your secret?`

### 5. Current date - (100 years - 1 day) (happy path)
   - **Input:** Date set to 1925/02/06 (100 years - 1 day)
   - **Expected Output:**  
     `You are 99 years old. Amazing achievement :)`
> **Note:** Test cases **3**, **4**, and **5** are part of **boundary testing**

### 6. Today's date
   - **Input:** `2025/02/05` (Actual current date)
   - **Expected Output:**  
     `Are you sure you born today?`

### 7. Date with same day and month as today, but different year (birthday message displaying)
   - **Input:** `1995/02/05`
   - **Expected Output:**  
     `Happy Birthday! You're turning 30 today!`

### 8. Date in future (sad path)
   - **Input:** `2026/02/05`
   - **Expected Output:**  
     `You are not born yet but you know how to program`

### 9. Leap year 29th February
   - **Input:** `2000/02/29` (Leap year)
   - **Expected Output:**  
     `You are X years old. Amazing achievement :)`

### 10. Non-leap year 29th February
   - **Input:** `2001/02/29` (Non-leap year)
   - **Expected Output:**  
     `Invalid format, try again, use YYYY/MM/DD format, you have left X attempts`
   
### 11. Valid date format but date invalid (for example, 32nd December)
   - **Input:** `2025/12/32`
   - **Expected Output:**  
     `Invalid format, try again, use YYYY/MM/DD format, you have left X attempts`

### 12. Empty or null input
   - **Input:** Empty string (`""`) or `null`
   - **Expected Output:**  
     `Invalid format, try again, use YYYY/MM/DD format, you have left X attempts`

### 13. Minimum valid date (e.g., January 1st, 0001)
   - **Input:** `0001/01/01`
   - **Expected Output:**  
      `You are 2024 years old, what is your secret?`

### 14. Maximum valid date (e.g., December 31st, 9999)
   - **Input:** `9999/12/31`
   - **Expected Output:**
     `You are not born yet but you know how to program`



### ✨ A Quick Note
This project is my tech assessment for the **QA Automation Role** at **MHR**. Thank you for reviewing it! 😊

