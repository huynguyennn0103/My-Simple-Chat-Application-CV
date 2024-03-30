package Exercise2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication extends Application {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private TextArea chatArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Server Application");

        // Text area to display received messages
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // Button to start listening for incoming connections
        Button listenButton = new Button("Listen for Incoming Connections");
        listenButton.setOnAction(event -> listenForConnections());

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(chatArea, listenButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void listenForConnections() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(12345); // Example port number
                chatArea.appendText("Server started. Listening for incoming connections...\n");

                // Accept incoming connections
                clientSocket = serverSocket.accept();
                chatArea.appendText("Connection accepted from client: " + clientSocket.getInetAddress().getHostName() + ":" + clientSocket.getPort() + "\n");

                // Initialize input and output streams
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Start a separate thread to listen for incoming messages
                new Thread(() -> {
                    try {
                        String message;
                        while ((message = in.readLine()) != null) {
//                            System.out.println("Received message: " + message);
                            // Echo the received message back to the client
                            chatArea.appendText("[CLIENT] " + message + "\n");
                            sendMessage("[SERVER] Reply from server");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void sendMessage(String message) {
        if (out != null && !message.isEmpty()) {
            out.println(message);
            chatArea.appendText(message + "\n"); // Display sent message in the chat area
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
