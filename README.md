# 🛒 Store Checkout Simulator

## Overview
The **Store Checkout Simulator** is a Java-based system that simulates the operation of a store's checkout process. Customers are assigned to the checkout register with the shortest queue, optimizing service time. This project demonstrates strong data structure implementation skills, utilizing custom-built queues, along with an object-oriented design for managing store operations.

## Features and Functionalities

### Custom Queue Implementations
Developed two custom queue interfaces:
- **Array-based Queue**: For efficient queue management using arrays.
- **Linked List Queue**: A flexible queue implementation using linked lists to accommodate dynamic queue sizes.

### Object-Oriented Design
- **Store Class**: Manages the overall simulation, including customer arrivals and register assignments.
- **Register Class**: Handles individual checkout lines, ensuring customers are served in the correct order.
- **Customer Class**: Simulates a customer’s journey through the checkout process, tracking their entry and service.

### Optimized Register Assignment
Customers are automatically assigned to the register with the shortest queue, ensuring that store operations are efficient and minimizing customer waiting times.

### Real-time Store Simulation
Simulates the store's operations over a full workday (16 hours), tracking how many customers were served and how many left due to long wait times.

## Methodology

### Custom Data Structures
Built custom queue interfaces to manage the customer flow using both array-based and linked list implementations. These queues are integral to ensuring smooth operations at each checkout register.

### Object-Oriented Store Simulation
The project features a robust design where the store dynamically updates its operations over a workday, including handling new customer arrivals, assigning them to registers, and tracking store performance.

### Simulation Logic
The simulation runs for a total of 16 hours, divided into time updates that represent customer arrival times. The system calculates the number of customers served and those who left the store due to excessive wait times, providing detailed insights into store efficiency.

## Purpose
The **Store Checkout Simulator** project showcases the use of custom data structures and object-oriented programming in a real-world simulation. It highlights the ability to design and implement efficient systems for managing customer flow and store operations.
