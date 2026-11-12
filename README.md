# 🛒 SauceDemo E-Commerce Test Automation Framework (Java, TestNG, POM)

An end-to-end automated testing framework built with **Java**, **Selenium WebDriver**, and **TestNG** to validate critical user workflows on the [SauceDemo (Swag Labs)](https://www.saucedemo.com/) e-commerce platform. 

Engineered from scratch using the **Page Object Model (POM)** design pattern for modularity, this framework incorporates custom explicit wait utilities, global `try-catch` exception handling, robust TestNG assertions across **Chrome, Firefox, and Edge**, and detailed HTML execution reporting via **ExtentReports**.

---

## 🚀 Key Features

* **Page Object Model (POM) Architecture:** Separates UI locators and page actions from test logic for maximum code reusability and easy maintenance.
* **End-to-End E-Commerce Flow:** Automates the complete user journey including authentication, product selection, cart management, and checkout completion.
* **Cross-Browser Execution:** Validated across **Google Chrome**, **Mozilla Firefox**, and **Microsoft Edge**.
* **Custom Explicit Wait Utilities:** Handles dynamic web elements reliably with structured synchronization utilities.
* **Global Exception Handling & Assertions:** Implements structured `try-catch` exception matrices alongside **TestNG assertions** to verify expected outcomes at every step.
* **Automated Reporting & Visual Proof:** Generates step-by-step HTML reports using **ExtentReports** and captures full-page screenshots upon checkout completion.

---

## 🛠️ Tech Stack

* **Language:** Java (JDK 11+)
* **Automation Tool:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Reporting:** ExtentReports (`com.relevantcodes.extentreports`)
* **Utilities:** Apache Commons IO (for screenshot capture and file handling)
* **Build Tool:** Maven

---

## 📋 Automated Test Scenarios (`test_saucedemo`)

The test suite executes prioritized end-to-end test cases (`priority = 1` to `5`):

1. **User Authentication (`login`):** Launches the browser, navigates to `saucedemo.com`, maximizes the window, and logs in using valid standard credentials (`standard_user`).
2. **Cart Management (`add_to_cart`):** Adds the *Sauce Labs Backpack* to the cart, navigates to the shopping cart view, and initiates checkout.
3. **Checkout Process (`checkout`):** Populates shipping details (First Name, Last Name, Postal Code), continues to the overview page, and finishes the order.
4. **Visual Verification (`proof`):** Captures a `.png` screenshot of the order confirmation screen as execution evidence.
5. **Teardown (`laststep` & `reportflush`):** Closes the browser session cleanly and flushes all step logs into `saucedemotest.html`.

---

## 📂 Project Structure

```text
testing-saucedemo-project/
├── src/
│   ├── main/java/
│   │   ├── pages/              # Page Object classes (Login, Inventory, Cart, Checkout)
│   │   └── utils/              # Custom explicit wait helpers & screenshot utilities
│   └── test/java/
│       └── Project_Saucedemo/
│           └── test_saucedemo.java   # Main TestNG execution suite
├── JanuarySelenium/
│   └── saucedemotest.html      # Generated ExtentReports HTML output
├── testng.xml                  # TestNG suite configuration
└── pom.xml                     # Maven dependencies
```

---

## ⚙️ Setup & Execution

### 1. Prerequisites
* **Java Development Kit (JDK)** 11 or higher installed
* **Maven** installed (or an IDE like Eclipse / IntelliJ IDEA with TestNG plugin)
* **Chrome / Firefox / Edge** browsers installed

### 2. Clone the Repository
```bash
git clone https://github.com
cd testing-saucedemo-project
```

### 3. Configure Local Screenshot Path
Before running the suite on a new machine, update the local screenshot destination path inside `test_saucedemo.java` to use a relative project directory:
```java
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
* GitHub: [@mominrazi](https://github.com/mominrazi)
* LinkedIn: [Momin Razi](https://www.linkedin.com/in/momin-razi-703745286/)
