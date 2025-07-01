# Zym Management System

## Project Overview

The **Zym Management System** is a robust and scalable application designed to streamline the operations of modern fitness centers and gyms. This full-stack solution facilitates efficient management of members, memberships, classes, staff, and financial transactions, aiming to enhance administrative productivity and improve the overall member experience. Developed with a clear separation of concerns, the system leverages a powerful Java backend and a dynamic Angular frontend to provide a responsive and reliable platform.

---

## Architecture

The system follows a classic client-server architecture, divided into distinct frontend and backend components:

* **Frontend:** Built with **Angular**, this serves as the user interface, providing interactive dashboards and forms for various administrative and operational tasks. It communicates with the backend via RESTful APIs.
* **Backend:** Developed using **Java**, this robust layer handles business logic, data processing, security, and integration with the database. It exposes a set of RESTful APIs consumed by the frontend.

---

## Technologies Used

The Zym Management System is built upon a modern and widely adopted technology stack, ensuring maintainability, performance, and scalability:

* **Backend:**
    * **Java:** The core programming language for server-side development.
    * **Spring Boot:** Framework used for building the RESTful APIs and managing the backend services.
    * **Spring Data JPA / Hibernate:** For database interaction and ORM.
    * **Maven:** Project build automation tool.
    * **SLF4J & Logback:** For logging.
    * **Razorpay SDK:** Integrated for payment processing.
* **Frontend:**
    * **Angular:** A powerful TypeScript-based framework for building dynamic single-page applications.
    * **TypeScript:** A superset of JavaScript that adds static types, enhancing code quality and maintainability.
    * **HTML5:** For structuring the web content.
    * **CSS3:** For styling and responsive design.

---

## Key Features

The system is designed to offer a comprehensive suite of features essential for gym management:

* **Member Management:**
    * Member registration and profile management.
    * Attendance tracking (implied by workout plans and schedules).
    * Membership status and history.
* **Membership Management:**
    * Creation and configuration of various membership plans (e.g., monthly, annual, class-based).
    * Membership activation, renewal, and cancellation.
* **Class & Schedule Management:**
    * Creation and scheduling of fitness classes (implied by Instructor and Workout Controllers).
    * Trainer assignment and availability management.
* **Workout Management:**
    * Creation and management of individual workouts.
    * Creation and management of comprehensive workout plans.
* **Staff Management:**
    * Management of gym instructors.
    * Management of user accounts which can represent staff.
* **Financial Management:**
    * Processing and tracking of payments, including Razorpay integration.
* **Promotional Content Management:**
    * Adding, retrieving, updating, and deleting promotional materials and reviews.
* **Zym (Gym) Information Management:**
    * Management of gym details like name and address.
* **User Authentication & Authorization:**
    * Secure user login and registration.
    * Username availability check during registration.
    * Email notification upon user registration.
    * Role-based access control (implied by different user types, though not explicitly detailed in provided code).

---

## Backend Controllers and API Endpoints

The Java backend implements a comprehensive set of RESTful APIs, organized into several controllers, to manage various aspects of the Zym Management System. All endpoints are prefixed with `/api/`.

#### 1. `PaymentController.java`
* **Base Mapping:** `/api/payments`
* **Responsibilities:** Handles all payment-related operations, including processing new payments via Razorpay, retrieving payment history, and managing individual payment records.
* **Key Endpoints:**
    * `POST /api/payments/{userId}`: Process a new payment for a given user.
    * `GET /api/payments/{paymentId}`: Verify/retrieve a payment by its ID.
    * `GET /api/payments/getall`: Retrieve a list of all payment records.
    * `GET /api/payments/getPaymentById/{paymentId}`: Get a specific payment by ID.
    * `PUT /api/payments/{paymentId}`: Update an existing payment record.
    * `DELETE /api/payments/{paymentId}`: Delete a payment record.

#### 2. `ZymController.java`
* **Base Mapping:** `/api/zym/`
* **Responsibilities:** Manages gym (Zym) specific information, such as adding new gym details and retrieving existing ones.
* **Key Endpoints:**
    * `POST /api/zym/add`: Add a new Zym (gym) entry.
    * `GET /api/zym/getAll`: Retrieve a list of all Zyms.
    * `GET /api/zym/getById/{zymId}`: Get a specific Zym by its ID.
    * `POST /api/zym/update/{zymId}`: Update details of an existing Zym.
    * `DELETE /api/zym/delete/{zymId}`: Delete a Zym entry.

#### 3. `InstructorController.java`
* **Base Mapping:** `/api/instructors`
* **Responsibilities:** Handles the management of instructors, including adding, retrieving, updating, and deleting instructor records.
* **Key Endpoints:**
    * `POST /api/instructors`: Add a new instructor.
    * `GET /api/instructors/getall`: Retrieve all instructors.
    * `GET /api/instructors/{id}`: Get an instructor by ID.
    * `PUT /api/instructors/{id}`: Update an instructor's details.
    * `DELETE /api/instructors/{id}`: Delete an instructor.

#### 4. `MembershipTypeController.java`
* **Base Mapping:** `/api/membership-types`
* **Responsibilities:** Manages different types of memberships offered by the gym.
* **Key Endpoints:**
    * `POST /api/membership-types`: Add a new membership type.
    * `GET /api/membership-types/getall`: Retrieve all membership types.
    * `GET /api/membership-types/{id}`: Get a membership type by ID.
    * `PUT /api/membership-types/{id}`: Update a membership type.
    * `DELETE /api/membership-types/{id}`: Delete a membership type.

#### 5. `WorkoutController.java`
* **Base Mapping:** `/api/workOuts`
* **Responsibilities:** Manages individual workout details.
* **Key Endpoints:**
    * `POST /api/workOuts`: Add a new workout.
    * `GET /api/workOuts/getall`: Retrieve all workouts.
    * `GET /api/workOuts/getbyid`: Get a workout by ID (note: uses `@RequestBody` for ID).
    * `PUT /api/workOuts/{id}`: Update an existing workout.
    * `DELETE /api/workOuts/{id}`: Delete a workout.

#### 6. `WorkoutPlanController.java`
* **Base Mapping:** `/api/workoutPlans`
* **Responsibilities:** Handles the management of workout plans, which likely group individual workouts or define a regimen.
* **Key Endpoints:**
    * `POST /api/workoutPlans`: Add a new workout plan.
    * `GET /api/workoutPlans/getall`: Retrieve all workout plans.
    * `GET /api/workoutPlans/getbyid`: Get a workout plan by ID (note: uses `@RequestBody` for ID).
    * `POST /api/workoutPlans/{id}`: Update an existing workout plan.
    * `DELETE /api/workoutPlans/{id}`: Delete a workout plan.

#### 7. `MemberController.java`
* **Base Mapping:** `/api/members`
* **Responsibilities:** Manages gym members' profiles and related operations.
* **Key Endpoints:**
    * `POST /api/members`: Add a new member.
    * `GET /api/members/getall`: Retrieve all members.
    * `GET /api/members/{id}`: Get a member by ID.
    * `GET /api/members/getByUserId/{userId}`: Get a member by associated user ID.
    * `PUT /api/members/{id}`: Update a member's details.
    * `DELETE /api/members/{id}`: Delete a member.

#### 8. `PromotionalMaterialController.java`
* **Base Mapping:** `/api/promotional-materials`
* **Responsibilities:** Manages promotional content and materials for the gym.
* **Key Endpoints:**
    * `POST /api/promotional-materials`: Add new promotional material.
    * `GET /api/promotional-materials/getall`: Retrieve all promotional materials.
    * `GET /api/promotional-materials/getbyid/{promotionId}`: Get promotional material by ID.
    * `PUT /api/promotional-materials/updatebyid/{id}`: Update existing promotional material.
    * `DELETE /api/promotional-materials/{id}`: Delete promotional material.

#### 9. `UserController.java`
* **Base Mapping:** `/api/user`
* **Responsibilities:** Handles user authentication (login), registration, user management, and email notifications.
* **Key Endpoints:**
    * `POST /api/user/login`: Authenticates a user.
    * `POST /api/user/register`: Registers a new user and sends a welcome email.
    * `GET /api/user/checkusername/{username}`: Checks if a username is available.
    * `GET /api/user/getall`: Retrieve all users.
    * `GET /api/user/{id}`: Get a user by ID.
    * `PUT /api/user/{id}`: Update a user's details.
    * `DELETE /api/user/{id}`: Delete a user.

---

## Getting Started

To set up and run the Zym Management System locally for development or testing purposes, follow these detailed steps.

### Prerequisites

Ensure you have the following software installed on your system:

* **Java Development Kit (JDK):** Version 8 or higher.
* **Node.js:** Latest LTS version (includes npm).
* **Angular CLI:** Install globally via npm:
    ```bash
    npm install -g @angular/cli
    ```
* **Git:** For cloning the repository.
* **Database System:** A relational database (e.g., MySQL, PostgreSQL, H2 for development).
* **Maven:** (Assuming Maven as the build tool based on common Spring Boot practices).

### Installation

1.  **Clone the Repository:**
    Begin by cloning the project repository to your local machine:
    ```bash
    git clone [https://github.com/Vinaykumarreddy467/Zym-Management-System.git](https://github.com/Vinaykumarreddy467/Zym-Management-System.git)
    cd Zym-Management-System
    ```

2.  **Backend Setup (Java):**
    * Navigate into the `backend` directory:
        ```bash
        cd backend
        ```
    * **Database Configuration:** Locate the `application.properties` or `application.yml` file (typically in `src/main/resources`). Update the database connection properties (URL, username, password) to match your local database setup.
        ```properties
        # Example for application.properties
        spring.datasource.url=jdbc:mysql://localhost:3306/zym_db
        spring.datasource.username=your_db_user
        spring.datasource.password=your_db_password
        spring.jpa.hibernate.ddl-auto=update # Or create for first run
        ```
    * **Razorpay Configuration (if applicable):** If you are running payment features, ensure your Razorpay API Key ID and Key Secret are configured in your `PaymentController.java` or `application.properties`. As per the provided `PaymentController.java`, they are hardcoded, but for production, these should be externalized.
    * **Build and Run:** Use Maven to build and run the application.
        ```bash
        mvn clean install
        mvn spring-boot:run
        ```
        The backend server should start, typically accessible at `http://localhost:8080` (or as configured).

3.  **Frontend Setup (Angular):**
    * Navigate back to the root of the project and then into the `Frontend` directory:
        ```bash
        cd ../Frontend
        ```
    * **Install Dependencies:** Install all required Node.js packages:
        ```bash
        npm install
        ```
    * **Start the Development Server:** Launch the Angular development server:
        ```bash
        ng serve --open
        ```
        This command will compile the Angular application and open it in your default web browser, usually at `http://localhost:4200`.

---

## Database Schema (Conceptual)

The database schema would typically include tables corresponding to your models:

* `Users` (id, username, password, email, complete_name, etc.)
* `Members` (id, user_id, contact_info, etc. - linking to Users)
* `Instructors` (id, name, contact_info, specialization, etc.)
* `MembershipTypes` (id, name, duration, price, description, etc.)
* `Payments` (id, user_id, amount, date, status, razorpay_order_id, etc.)
* `Workouts` (id, name, description, duration, etc.)
* `WorkoutPlans` (id, workout_name, workout_date, workout_time, member_id, etc.)
* `Zyms` (id, zym_name, zym_address, etc.)
* `PromotionalMaterials` (id, review, file_upload, user_id, etc.)

*(An Entity-Relationship Diagram (ERD) or more detailed schema descriptions could be added here for a comprehensive understanding.)*

---

## Future Enhancements

Potential future enhancements for the Zym Management System include:

* Further integration with payment gateways and recurring billing.
* Mobile application support for members and instructors.
* Advanced reporting and analytics dashboards.
* Trainer-specific portals for managing their classes and members.
* Automated push notifications for class reminders or membership renewals.
* Integration with physical access control systems (e.g., turnstiles).
* Enhanced error handling and logging.
* Implementation of Spring Security for robust authentication and authorization.

---

## Contributing

We welcome contributions to the Zym Management System! If you wish to contribute, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Commit your changes following conventional commit messages.
4.  Push your branch to your forked repository.
5.  Submit a pull request to the `main` branch of this repository.

Please ensure your code adheres to the project's coding standards and includes appropriate tests.

---

## License

MIT License

Copyright (c) [2025] [Vinay Kumar Reddy Molakathala]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

---

## Contact

For any inquiries or feedback, please reach out to the repository owner:

* **Vinaykumarreddy467:** [https://github.com/Vinaykumarreddy467](https://github.com/Vinaykumarreddy467)
* **Email:** vinaykumarreddy467@gmail.com
  
