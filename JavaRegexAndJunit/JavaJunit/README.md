# Java JUnit Practice Problems

This Maven project contains solutions to 13 JUnit testing problems, organized into basic and advanced categories. Each problem is implemented with beginner-friendly Java code and comprehensive test cases.

## Project Structure

```
JavaJunit/
├── src/
│   ├── main/java/com/junit/examples/
│   │   ├── Calculator.java
│   │   ├── StringUtils.java
│   │   ├── ListManager.java
│   │   ├── ExceptionHandler.java
│   │   ├── DatabaseConnection.java
│   │   ├── NumberUtils.java
│   │   ├── PerformanceTask.java
│   │   ├── FileProcessor.java
│   │   ├── BankAccount.java
│   │   ├── PasswordValidator.java
│   │   ├── TemperatureConverter.java
│   │   ├── DateFormatter.java
│   │   └── UserRegistration.java
│   └── test/java/com/junit/examples/
│       ├── CalculatorTest.java
│       ├── StringUtilsTest.java
│       ├── ListManagerTest.java
│       ├── ExceptionHandlerTest.java
│       ├── DatabaseConnectionTest.java
│       ├── NumberUtilsTest.java
│       ├── PerformanceTaskTest.java
│       ├── FileProcessorTest.java
│       ├── BankAccountTest.java
│       ├── PasswordValidatorTest.java
│       ├── TemperatureConverterTest.java
│       ├── DateFormatterTest.java
│       └── UserRegistrationTest.java
├── pom.xml
└── README.md
```

## Basic JUnit Problems (1-8)

### 1. Calculator Class Testing
- **File**: `Calculator.java` and `CalculatorTest.java`
- **Methods**: add, subtract, multiply, divide
- **Features**: Basic arithmetic operations with exception handling for division by zero

### 2. String Utilities Testing
- **File**: `StringUtils.java` and `StringUtilsTest.java`
- **Methods**: reverse, isPalindrome, toUpperCase
- **Features**: String manipulation with null safety

### 3. List Operations Testing
- **File**: `ListManager.java` and `ListManagerTest.java`
- **Methods**: addElement, removeElement, getSize
- **Features**: List management with proper null checks

### 4. Exception Handling Testing
- **File**: `ExceptionHandler.java` and `ExceptionHandlerTest.java`
- **Method**: divide (with ArithmeticException)
- **Features**: Testing exception throwing and handling

### 5. @BeforeEach and @AfterEach Annotations
- **File**: `DatabaseConnection.java` and `DatabaseConnectionTest.java`
- **Methods**: connect, disconnect
- **Features**: Database connection lifecycle management

### 6. Parameterized Tests
- **File**: `NumberUtils.java` and `NumberUtilsTest.java`
- **Method**: isEven
- **Features**: Testing with multiple input values using @ParameterizedTest

### 7. Performance Testing with @Timeout
- **File**: `PerformanceTask.java` and `PerformanceTaskTest.java`
- **Method**: longRunningTask
- **Features**: Testing method execution time limits

### 8. File Handling Testing
- **File**: `FileProcessor.java` and `FileProcessorTest.java`
- **Methods**: writeToFile, readFromFile
- **Features**: File I/O operations with proper cleanup

## Advanced JUnit Problems (1-5)

### 1. Banking Transactions Testing
- **File**: `BankAccount.java` and `BankAccountTest.java`
- **Methods**: deposit, withdraw, getBalance
- **Features**: Banking operations with balance validation and insufficient funds handling

### 2. Password Strength Validator Testing
- **File**: `PasswordValidator.java` and `PasswordValidatorTest.java`
- **Method**: isValidPassword
- **Features**: Password validation with rules for length, uppercase letters, and digits

### 3. Temperature Converter Testing
- **File**: `TemperatureConverter.java` and `TemperatureConverterTest.java`
- **Methods**: celsiusToFahrenheit, fahrenheitToCelsius
- **Features**: Temperature conversion between Celsius and Fahrenheit

### 4. Date Formatter Testing
- **File**: `DateFormatter.java` and `DateFormatterTest.java`
- **Method**: formatDate
- **Features**: Date format conversion from yyyy-MM-dd to dd-MM-yyyy

### 5. User Registration Testing
- **File**: `UserRegistration.java` and `UserRegistrationTest.java`
- **Method**: registerUser
- **Features**: User registration with validation for username, email, and password

## How to Run the Tests

1. **Using Maven**:
   ```bash
   mvn test
   ```

2. **Using Maven with specific test**:
   ```bash
   mvn test -Dtest=CalculatorTest
   ```

3. **Using Maven with specific method**:
   ```bash
   mvn test -Dtest=CalculatorTest#testAdd
   ```

## Dependencies

The project uses JUnit 5 (Jupiter) with the following dependencies:
- junit-jupiter-engine: 5.9.2
- junit-jupiter-api: 5.9.2
- junit-jupiter-params: 5.9.2

## Key Features

- **Beginner-friendly**: Simple, clean code with clear method names
- **Comprehensive testing**: Each method has multiple test cases
- **Exception handling**: Proper exception testing with assertThrows
- **Parameterized tests**: Using @ParameterizedTest for multiple inputs
- **Lifecycle annotations**: Using @BeforeEach and @AfterEach
- **Performance testing**: Using @Timeout for execution time testing
- **File handling**: Testing file I/O operations with proper cleanup
- **Validation**: Input validation and error handling

## Learning Outcomes

After completing these problems, you'll understand:
- Basic JUnit test structure and assertions
- Exception testing in JUnit
- Test lifecycle management with @BeforeEach and @AfterEach
- Parameterized testing with multiple inputs
- Performance testing with @Timeout
- File I/O testing
- Complex validation testing
- Banking and business logic testing

## Getting Started

1. Clone or download the project
2. Navigate to the JavaJunit directory
3. Run `mvn test` to execute all tests
4. Check individual test classes for specific examples
5. Modify and extend the code as needed for practice

Happy testing! 🧪