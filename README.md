# FinalSprint-BinarySearchTree-DSA

Binary Search Tree Visualizer

# Overview:
This project provides a web application that allows users to input a series of numbers, constructs a binary search tree (BST) from these numbers, and displays the tree structure in JSON format. The application also enables users to view previously submitted trees and their corresponding input values. The project is built with Spring Boot and uses PostgreSQL for data storage.

# Features:
User Input Interface

Route: /enter-numbers
Description: Displays an HTML page with:
An input field for users to enter a series of numbers.
A 'Submit' button to process the numbers.
A 'Show Previous' button to view previously stored trees.
Processing Route

Route: /process-numbers
Description:
Accepts a list of numbers from the user.
Constructs a BST from the numbers.
Returns the BST as a JSON representation.
Stores both the input numbers and resulting tree structure in the PostgreSQL database.
Display Previous Trees

Route: /previous-trees
Description:
Retrieves and displays previously submitted trees and their corresponding input numbers from the database.
Testing

Includes unit tests to ensure the functionality of the application.
Database

Stores all input numbers and their resulting tree structures in a PostgreSQL database named finalsprintDSA_db.

# Getting Started

# Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven for building the project
- PostgreSQL database server
- PostgreSQL client tools (e.g., pgAdmin)

# Installation

1. Clone the Repository:
   git clone https://github.com/Jhellai04/FinalSprint-BinarySearchTree-DSA.git)
2. Set Up PostgreSQL
   Ensure PostgreSQL is installed and running.
   Create a database named finalsprintDSA_db.
   If you choose a different name, update the name in the application.properties
3. Run the Application: Once your database is created, run the RestServiceApplication file.
4. Testing the API: Open Postman and perform a GET request on http://localhost:8080/ to see the available links.
