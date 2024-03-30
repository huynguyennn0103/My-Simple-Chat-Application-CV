package Exercise2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApplication extends Application {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private TextArea chatArea; // Declare chatArea as an instance variable

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Client Application");

        // Text area to display received messages
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // Text field for typing messages
        TextField messageField = new TextField();
        messageField.setPromptText("Type your message here...");

        // Button to send message
        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> sendMessage(messageField.getText()));

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(chatArea, messageField, sendButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Connect to server
        createSocket();
        // Start a separate thread to listen for incoming messages from the server
        new Thread(this::receiveMessages).start();
    }

    private void createSocket() {
        try {
            socket = new Socket("localhost", 12345); // Example server IP and port
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        if (out != null && !message.isEmpty()) {
            out.println(message);
            chatArea.appendText("[CLIENT] " + message + "\n");
        }
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
//                System.out.println("Received message from server: " + message);
                // Display received message in the chat area
                chatArea.appendText(message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
