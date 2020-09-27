## Automation Testing Task 
##### based on search system: https://www.google.com/

### Languages, technologies and patterns are used:
1. TestNG;
2. Allure (for reporting);
3. Selenium;
4. PageObject, Builder (Lombok) patterns;
5. Java 8.

### Features:
##### It's possible to: 
1. run tests from command line;
2. run tests in multithreading mode;
##### Test results appeared in Allure report;
##### Each failed step has screenshot in Allure report.

#### Running Tests from Command Line:
```bash
mvn clean test
```
#### Running Tests from Command Line in multithreading mode:
```bash
mvn clean test -Dthreads=2 
```
(count of the threads, "2 threads" -Dthreads=2 for example)

#### Running Tests in browser (by default it's Chrome):
```bash
mvn clean test -Dbrowser=firefox 
```

#### Test results in Allure report:
```bash
mvn allure:serve 
```
