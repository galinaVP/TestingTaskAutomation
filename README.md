Testing Task base on search system: https://www.google.com/

Languages, technologies and patterns are used:
TestNG
Allure (for reporting)
Selenium
PageObject pattern
Java 8

Features:
It's possible to run tests from command line
It's possible to run tests in multithreading mode
Test results appeared in Allure report
Each failed step has screenshot in Allure report

Running Tests from Command Line:
mvn clean test

Running Tests from Command Line in multithreading mode:
mvn clean test -Dthreads=2 (count of the threads, "2 threads" -Dthreads=2 for example)

Running Tests in browser (by default it's Chrome):
mvn clean test -Dbrowser=firefox 

Test results in Allure report:
mvn allure:serve 
