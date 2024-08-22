# Java Software Engineer - Developer Test

## Description

**Employee App** is a full-stack application that provides a RESTful API backend and a frontend user interface. The backend is built with Spring Boot and Java 17, and it serves as an API to manage employee information. The frontend is developed using Angular 18 and provides a user interface to interact with the API. This application allows users to view and search employee information.

### Backend

The backend application is a Spring Boot application that consumes the following external API:
- **Employees List API**: `http://dummy.restapiexample.com/api/v1/employees`
- **Employee Detail API**: `http://dummy.restapiexample.com/api/v1/employee/{id}`

### Frontend

The frontend application is an Angular application that allows users to search for employees by ID or view all employees. It uses Angular Material for UI components and Bootstrap for additional styling.

## Requirements

### Backend

- Java 17
- Maven
- Docker (optional, for containerization)
- WildFly (optional, for deployment)

### Frontend

- Node.js (v16 or later recommended)
- Angular CLI (v18 or later)
- Bootstrap and Angular Material

## Installation and Setup

### Backend

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/employee-app.git
    cd employee-app
    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

3. **Run the application locally:**

    ```bash
    mvn spring-boot:run
    ```

4. **Containerize with Docker (optional):**

    - **Build Docker image:**

        ```bash
        docker build -t employee-app-backend .
        ```

    - **Run Docker container:**

        ```bash
        docker run -p 8080:8080 employee-app-backend
        ```

5. **Deploy on WildFly (optional):**
    - Package the application as a WAR file:

        ```bash
        mvn clean package
        ```

    - Deploy the `employee-app.war` file to your WildFly server.

### Frontend

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/developer_frontend.git
    cd developer_frontend
    ```

2. **Install dependencies:**

    ```bash
    npm install
    ```

3. **Build the application:**

    ```bash
    ng build --prod
    ```

4. **Run the application locally:**

    ```bash
    ng serve
    ```

5. **Access the application:**

    Open a browser and go to `http://localhost:4200` to view the application.

## Usage

- **Backend API Endpoints:**
  - `GET /api/employees` - Retrieves the list of all employees.
  - `GET /api/employee/{id}` - Retrieves the details of an employee by ID.

- **Frontend UI:**
  - The UI consists of a search box to input employee IDs and a button to search.
  - If the ID is empty, it will display the complete list of employees.
  - If the ID is provided, it will display the employee details for the given ID.

## Notes

- Ensure that the backend server is running before starting the frontend application.
- Configure CORS settings in the backend if you encounter cross-origin issues.

> [!WARNING]
> The external APIs used for employee data are from a dummy data provider. Please be aware that these APIs may return a `429 Too Many Requests` error if queried excessively. If you encounter this error, please wait for some time before retrying the request.


## Author

- **Nicolas Guaneme Rico**
