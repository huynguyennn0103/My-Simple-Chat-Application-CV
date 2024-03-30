**Project Readme: Chat Application with TCP Socket and JavaFX**

---

## Introduction

Welcome to our chat application project! This document serves as a guide for developers interested in creating a chat application using TCP sockets with multithreading in JavaFX. Our project aims to develop a real-time chat platform where users can communicate with each other over a network using a graphical user interface (GUI) built with JavaFX.

## Project Overview

Our project involves the following key components:

- **TCP Socket Communication**: Utilizing TCP (Transmission Control Protocol) sockets for establishing communication between client and server applications over a network.

- **Multithreading**: Implementing multithreading in the server application to handle multiple client connections concurrently, each with its dedicated thread.

- **JavaFX UI**: Developing the graphical user interface (GUI) for the chat application using JavaFX, allowing for a visually appealing and user-friendly interaction experience.

## Getting Started

To get started with the project, follow these steps:

1. **Clone the Repository**:
   ```
   git clone <repository_url>
   ```

2. **Set Up Server Application**:
    - Navigate to the `server` directory.
    - Follow the instructions in the server readme file to set up the server application and configure multithreading.

3. **Set Up Client Application**:
    - Navigate to the `client` directory.
    - Follow the instructions in the client readme file to set up the client application and establish connection with the server.

4. **Run the Applications**:
    - Start the server application.
    - Launch multiple instances of the client application to simulate multiple users.
    - Communicate between clients using the chat interface provided by the JavaFX UI.

## Server Responsibilities

The server application is responsible for the following tasks:

- **Accepting Client Connections**: Listening for incoming client connections and accepting them upon request.

- **Multithreading**: Spawning a new thread for each connected client to handle their communication independently.

- **Message Broadcasting**: Relaying messages received from one client to all other connected clients for real-time communication.

## Client Responsibilities

The client application is responsible for the following tasks:

- **Establishing Connection**: Connecting to the server application over the network using TCP sockets.

- **Sending Messages**: Allowing users to type and send messages to other connected clients through the server.

- **Receiving Messages**: Displaying messages received from other clients in the chat interface for real-time communication.

## JavaFX UI

The JavaFX UI provides an intuitive and visually appealing interface for users to interact with the chat application. It includes components such as text fields for message input, chat history display area, and buttons for sending messages and managing connections.

## Contribution Guidelines

We welcome contributions from the developer community to enhance and improve our chat application project. To contribute, follow the guidelines provided in the respective readme files for the server and client applications.

## License

This project is licensed under the [huynguyenn0103@gmail.com License](LICENSE), allowing for free use, modification, and distribution of the code for both commercial and non-commercial purposes.

## Contact Information

For any inquiries or feedback regarding the project, feel free to contact us at [huynguyenn0103@gmail.com](mailto:huynguyenn0103@gmail.com).

---

Thank you for your interest in our chat application project! We hope you find this readme file helpful in understanding the project structure and getting started with development. Happy chatting!