package media_player_project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Yes
 */
public class MediaPlayerGUI extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane mainPane = new GridPane();
        mainPane.setHgap(20);
        mainPane.setVgap(20);
        Button playButton = new Button("Play");
        mainPane.add(playButton, 0, 0);
        
        Scene scene = new Scene(mainPane, 300,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Player");
        primaryStage.show();
    }
    
}
