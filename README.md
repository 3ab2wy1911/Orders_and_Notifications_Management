# Orders and Notifications Management System

![Java](https://img.shields.io/badge/Java-11-orange?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-green?style=flat&logo=spring)
![License](https://img.shields.io/badge/license-FCAI-blue?style=flat)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This is a Spring Boot application that implements the Orders and Notifications Management System. It provides a set of RESTful APIs to manage customer accounts, product orders, and notifications. The system allows customers to view available products, place orders, and receive notifications about their orders.

## Features

- User account creation and management
- Viewing available products
- Placing single and compound orders
- Printing order details
- Payment and shipment of orders
- Notification system for order-related events
- Statistics for notifications sent
- (Bonus) Order cancellation and automated notification removal

## Getting Started

To run the application locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/orders-and-notifications.git
2. Navigate to the project directory:

   ```bash
    cd orders-and-notifications
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
 The application will be accessible at http://localhost:8080.
## API Endpoints

### Customer

- **GET /customer?id={customerId}**: Get customer information by ID.
- **POST /addCustomer**: Add a new customer.

### Product

- **GET /viewProducts**: View all available products.

### Order

- **POST /addSingleOrder?productId={productId}**: Add a single order.
- **POST /addCompoundOrder**: Add a compound order.
- **GET /printOrderDetails?orderId={orderId}**: Print order details.
- **GET /pay?orderId={orderId}**: Pay for an order.
- **GET /shipOrder?orderId={orderId}**: Ship an order.
- **POST /cancelOrder?orderId={orderId}**: Cancel an order.

### Notification

- **POST /notification**: Create a notification.

## Usage

Use [Postman](https://www.postman.com/) to test the APIs. Import the provided Postman collection for easy access to API endpoints.

## Contributing

1. Fork the project.
2. Create your feature branch: `git checkout -b feature/new-feature`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature/new-feature`
5. Open a pull request.
## License

This project is licensed under the [Faculty of Computers and Artificial Intelligence (FCAI) Cairo University License](LICENSE).

