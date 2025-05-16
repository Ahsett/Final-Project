package fortuneteller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        FortuneTellerGUI gui = new FortuneTellerGUI();
        gui.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}