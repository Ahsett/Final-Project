/**
 * FortuneTellerGUI is the JavaFX user interface for the Fortune Teller app.
 * It allows the user to generate, add, and remove fortunes using buttons and lists.
 *
 * Author: Alex Sett
 *
 */

package fortuneteller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FortuneTellerGUI extends Application {
    private FortuneManager manager = new FortuneManager();

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("Fortune Teller");
        Label instruction = new Label("Click to receive a fortune or add your own!");

        TextArea display = new TextArea();
        display.setEditable(false);

        TextField input = new TextField();
        input.setPromptText("Enter your fortune");

        ListView<String> fortuneList = new ListView<>();
        fortuneList.getItems().addAll(manager.getAllFortunes());

        Button getFortuneBtn = new Button("\uD83D\uDD2E Get Your Fortune! \uD83D\uDD2E");
        Button addFortuneBtn = new Button("Add Your Own Fortune");
        Button removeFortuneBtn = new Button("Remove Selected");
        getFortuneBtn.setStyle("-fx-background-color: #0080ff; -fx-text-fill: white; -fx-font-weight: bold;");
        addFortuneBtn.setStyle("-fx-background-color: #0080ff; -fx-text-fill: white; -fx-font-weight: bold;");
        removeFortuneBtn.setStyle("-fx-background-color: #0080ff; -fx-text-fill: white; -fx-font-weight: bold;");

        getFortuneBtn.setOnAction(e -> {
            display.setText(manager.getRandomFortune());
        });

        addFortuneBtn.setOnAction(e -> {
            String newFortune = input.getText();
            if (newFortune.isEmpty()) {
                showAlert("Input Error", "Fortune cannot be empty.");
                return;
            }
            manager.addFortune(newFortune);
            fortuneList.getItems().add(newFortune);
            input.clear();
        });

        removeFortuneBtn.setOnAction(e -> {
            String selected = fortuneList.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Selection Error", "No fortune selected to remove.");
                return;
            }
            manager.removeFortune(selected);
            fortuneList.getItems().remove(selected);
        });

        VBox layout = new VBox(10, title, instruction, getFortuneBtn, display, input, addFortuneBtn, fortuneList, removeFortuneBtn);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color:#99ccff;");

        primaryStage.setScene(new Scene(layout, 400, 600));
        primaryStage.setTitle("I can see your future");
        title.setStyle("-fx-font-size: 24px; -fx-text-fill: #3d405b; -fx-font-weight: bold;");
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}