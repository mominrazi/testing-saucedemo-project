# 🔐 Automated Session & File Upload Test Architecture Suite (Java, BVA/EP)

A comprehensive Quality Assurance and Test Automation suite built using **Java**, **Selenium WebDriver**, and **TestNG**. This project combines **30 structured manual test cases** with **data-driven automated scripts** applying **Boundary Value Analysis (BVA)** and **Equivalence Partitioning (EP)** to validate authentication, session timeouts, file upload thresholds, and security edge cases.

---

## 📋 Application Under Test (AUT) Business Rules

The test architecture validates the following core system requirements:
* **Authentication:** Users log in with valid credentials (`testuser@gmail.com` / `Test@123`).
* **Session Lifecycle:** User sessions expire automatically after **15 minutes** of inactivity, upon **browser closure**, **page refresh**, **network switching**, or **tab switching**.
* **File Upload Restrictions:** Authenticated users can upload **DOC, PPT, and Image** files up to **25 MB**, and **Video** files up to **100 MB**.
* **Preview & Access Control:** File previews are restricted strictly to authenticated sessions, supporting image/document previews up to **25 MB** while blocking unauthorized URL access and video previews.

---

## 🧪 Test Design Techniques Applied

* **Boundary Value Analysis (BVA):**
  * **Video Upload Size Thresholds (100 MB Limit):** Tested at `99 MB` (Pass), `100 MB` (Pass), and `101 MB` (Fail) via TestNG `@DataProvider`.
  * **File Preview Size Thresholds (25 MB Limit):** Tested at `24 MB` (Pass), `25 MB` (Pass), and `26 MB` (Fail).
  * **Session Timeout Thresholds (15-Minute Limit):** Verified active session at `14 minutes` and expired session at `16 minutes`.
* **Equivalence Partitioning (EP):**
  * **Valid vs. Invalid File Formats:** Partitioned allowed formats (`DOC`, `PPT`, `Images`) against unsupported file extensions.
  * **Network & Environment Conditions:** Validated behavior across Wi-Fi, mobile data, network switching, and device battery levels (`90%` vs. `10%`).
* **Security & Edge Case Testing:**
  * Direct URL access to file previews without an active session (`/preview?fileId=123`).
  * Session invalidation upon page refresh, tab switch, and browser restart.

---

## 📊 Manual Test Execution Summary

All **30 manual test cases** (`TC_LF_001` to `TC_LF_030`) are documented in the repository's Excel test suite:

| Metric | Count | Percentage |
| :--- | :---: | :---: |
| **Total Test Cases** | 30 | 100% |
| **Passed** | 26 | 86.67% |
| **Failed (Defects Logged)** | 4 | 13.33% |

### 🔍 Key Defects Identified During Manual Testing
1. **`TC_LF_004` (Session Expiry):** Session remained active at 16 minutes instead of expiring after the 15-minute inactivity threshold.
2. **`TC_LF_007` (Page Refresh):** Refreshing the page did not terminate the active user session as required.
3. **`TC_LF_008` (Browser Closure):** Closing the browser failed to invalidate the user session.
4. **`TC_LF_013` (Video Upload Boundary):** Uploading a `99 MB` video file failed despite being within the `100 MB` limit.

---

## 🤖 Automated Test Coverage (`SimpleSessionAndUploadTest.java`)

The automation suite translates high-priority manual scenarios into repeatable TestNG checks using **WebDriverManager** and **Explicit Waits (`WebDriverWait`)**:

* `testValidLogin` (`TC_LF_001`, `TC_LF_005`): Verifies login success and visibility of the upload container.
* `testInvalidLogin` (`TC_LF_002`): Asserts error message display on invalid credentials.
* `testSessionExpiryOnRefresh` (`TC_LF_007`, `TC_LF_025`): Simulates page refresh and verifies session termination.
* `testFileUploadSizes` (`TC_LF_013` – `TC_LF_015`): Uses `@DataProvider` to test `99 MB`, `100 MB`, and `101 MB` upload boundaries.
* `testPreviewWithoutAuth` (`TC_LF_012`): Attempts unauthenticated access to `/preview?fileId=123` and asserts access denial.

---

## 🛠️ Tech Stack

* **Language:** Java (JDK 11+)
* **Browser Automation:** Selenium WebDriver
* **Test Runner & Assertions:** TestNG (`@Test`, `@DataProvider`, `Assert`)
* **Driver Management:** WebDriverManager (`io.github.bonigarcia.wdm`)
* **Test Documentation:** Microsoft Excel (`.xlsx` / `.csv` Manual Test Suite)

---

## 📂 Project Structure

```text
manual-and-atuomation-test-cases-for-upload-file/
├── docs/
│   └── Manual_Test_Cases.xlsx           # 30 BVA/EP manual test cases & execution report
├── src/
│   └── test/
│       ├── java/
│       │   └── SimpleSessionAndUploadTest.java   # Automated TestNG suite
│       └── resources/
│           └── testdata/                # Sample 99MB, 100MB, and 101MB test files
├── testng.xml                           # TestNG suite configuration
└── pom.xml                              # Maven dependencies (Selenium, TestNG, WebDriverManager)
```

---

## ⚙️ Setup & Execution

### 1. Prerequisites
* Java JDK 11 or higher
* Maven installed
* Google Chrome browser installed

### 2. Clone the Repository
```bash
git clone https://github.com
cd manual-and-atuomation-test-cases-for-upload-file
```

### 3. Configure Test Data Paths
Update the placeholder file paths inside `@DataProvider(name = "fileSizes")` in `SimpleSessionAndUploadTest.java` to point to local sample files on your machine:
```java
{ System.getProperty("user.dir") + "/src/test/resources/testdata/file_99mb.mp4", true }
```

### 4. Run the Automated Tests
```bash
mvn clean test
```

---

## 👤 Author

**Momin Razi**
* GitHub: [@mominrazi](https://github.com)
* LinkedIn: [Momin Razi](https://linkedin.com)
