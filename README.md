# 🛒 SauceDemo E-Commerce Test Automation Framework

An end-to-end automated testing framework built with **Java**, **Selenium WebDriver**, and **TestNG** to validate critical user workflows on the [SauceDemo (Swag Labs)](https://www.saucedemo.com/) e-commerce platform. 

This project follows the **Page Object Model (POM)** design pattern for scalability and maintainability, incorporating cross-browser compatibility, custom explicit wait utilities, global exception handling, and rich HTML reporting via **ExtentReports**.

---

## 🚀 Key Features

* **Page Object Model (POM) Architecture:** Separates UI locators and page actions from test scripts for maximum code reusability and easy maintenance.
* **End-to-End E-Commerce Flow:** Automates the complete user journey including authentication, product selection, cart management, and checkout completion.
* **Cross-Browser Execution:** Engineered to validate test suites across **Google Chrome**, **Mozilla Firefox**, and **Microsoft Edge**.
* **Custom Explicit Wait Utilities:** Replaces hard-coded sleeps with dynamic synchronization to handle asynchronous web elements reliably.
* **Global Exception Handling & Assertions:** Implements structured `try-catch` blocks alongside robust **TestNG assertions** to verify expected outcomes at every step.
* **Automated Reporting & Proof of Execution:** Generates detailed HTML test execution reports using **ExtentReports** and captures full-page screenshots upon checkout completion.

---

## 🛠️ Tech Stack

* **Language:** Java (JDK 11+)
* **Automation Tool:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Reporting:** ExtentReports (`com.relevantcodes.extentreports`)
* **Utilities:** Apache Commons IO (for screenshot file handling)
* **Build Tool:** Maven

---

## 📋 Automated Test Scenarios (`test_saucedemo`)

The test suite executes prioritized end-to-end test cases (`priority = 1` to `5`):

1. **User Authentication (`login`):** Launches the browser, navigates to `saucedemo.com`, maximizes the window, and logs in using valid standard credentials.
2. **Cart Management (`add_to_cart`):** Adds the *Sauce Labs Backpack* to the cart, navigates to the shopping cart view, and initiates checkout.
3. **Checkout Process (`checkout`):** Populates shipping details (First Name, Last Name, Postal Code), continues to the overview page, and finishes the order.
4. **Visual Verification (`proof`):** Captures a `.png` screenshot of the order confirmation screen as execution evidence.
5. **Teardown (`laststep` & `reportflush`):** Closes the browser session cleanly and flushes all step logs into `saucedemotest.html`.

---

## 📂 Project Structure

```text
Project_Saucedemo/
├── src/
│   ├── main/java/
│   │   ├── pages/              # Page Object classes (Login, Inventory, Cart, Checkout)
│   │   └── utils/              # Explicit wait helpers & screenshot utilities
│   └── test/java/
│       └── Project_Saucedemo/
│           └── test_saucedemo.java   # Main TestNG execution suite
├── JanuarySelenium/
│   └── saucedemotest.html      # Generated ExtentReports HTML output
├── testng.xml                  # TestNG suite configuration
└── pom.xml                     # Maven dependencies
```

---

## ⚙️ Prerequisites & Setup

### 1. Prerequisites
* **Java Development Kit (JDK)** 11 or higher installed
* **Maven** installed (or an IDE like Eclipse / IntelliJ IDEA with TestNG plugin)
* **Chrome / Firefox / Edge** browsers installed

### 2. Clone the Repository
```bash
git clone https://github.com
cd your-repo-name
```

### 3. Configure Local Paths (Important)
Before running the tests, update the local screenshot destination path inside `test_saucedemo.java` (or move it to a relative project directory):
```java
// Recommended relative path for cross-machine compatibility:
File dest = new File(System.getProperty("user.dir") + "/screenshots/Saucedemo_screenshot.png");
```

### 4. Run the Tests
Execute the suite via Maven from your terminal:
```bash
mvn clean test
```
*Alternatively, right-click `test_saucedemo.java` or `testng.xml` in your IDE and select **Run As > TestNG Test**.*

---

## 📊 Test Reports & Artifacts

* **HTML Report:** After execution completes, open `/JanuarySelenium/saucedemotest.html` in any web browser to inspect step-by-step pass/fail logs.
* **Screenshots:** Execution proof screenshots are saved automatically upon completing the checkout flow.

---

## 👤 Author

**Momin Razi**
* GitHub: [@your-username](https://github.com)
* LinkedIn: [Your LinkedIn Profile](https://linkedin.com)
