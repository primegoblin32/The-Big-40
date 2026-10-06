package The_Big_40;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrainTicketBookingSystem extends Application {

    private final ObservableList<String> records = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        Label title = new Label("Train Ticket Booking System");

        TextField field1 = new TextField();
        field1.setPromptText("Passenger");

        TextField field2 = new TextField();
        field2.setPromptText("Train");

        Button actionButton = new Button("Book Ticket");
        Button clearButton = new Button("Clear");

        ListView<String> listView = new ListView<>(records);

        actionButton.setOnAction(e -> {
            String value1 = field1.getText().trim();
            String value2 = field2.getText().trim();

            if (!value1.isEmpty() && !value2.isEmpty()) {
                records.add(value1 + " | " + value2);
                field1.clear();
                field2.clear();
            } else {
                showMessage("Please enter both fields.");
            }
        });

        clearButton.setOnAction(e -> {
            field1.clear();
            field2.clear();
        });

        VBox root = new VBox(10, title, field1, field2, actionButton, clearButton, listView);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 500, 450);
        stage.setTitle("Train Ticket Booking System");
        stage.setScene(scene);
        stage.show();
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
