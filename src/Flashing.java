import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Flashing extends Application {
    private String text = "";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        Text lblText = new Text("Programming is fun");
        lblText.setX(10);
        lblText.setY(0);
        pane.getChildren().add(lblText);
        Text lblText2 = new Text("Programming is fun");
        lblText2.setY(100.0);
        pane.getChildren().add(lblText2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (lblText.getText().trim().length() == 0)
                            text = "Welcome";
                        else
                            text = "Not welcome";

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lblText.setText(text);
                            }
                        });

                        Thread.sleep(10);
                    }
                }
                catch (InterruptedException ex) {
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (lblText2.getText().trim().length() == 0)
                            text = "Hest";
                        else
                            text = "Ost";

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lblText2.setText(text);
                            }
                        });

                        Thread.sleep(10);
                    }
                }
                catch (InterruptedException ex) {
                }
            }
        }).start();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("FlashText"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
