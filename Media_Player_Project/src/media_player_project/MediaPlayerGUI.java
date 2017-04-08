package media_player_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public void start(Stage primaryStage) throws FileNotFoundException {
        GridPane mainPane = new GridPane();
        mainPane.setHgap(20);
        mainPane.setVgap(20);
        
        Button playButton = new Button();
        
        Image playImage = new Image(new FileInputStream("mediaPlayerButtons") + File.separator + "playButton.png");
        playButton.setGraphic(new ImageView(playImage));
        
        Button skipButton = new Button();
        skipButton.setGraphic(new ImageView(new Image( new FileInputStream("mediaPlayerButtons" + File.separator + "fastForward.png"))));
        
        mainPane.add(playButton, 1, 0);
        mainPane.add(skipButton, 2, 0);
        
        Scene scene = new Scene(mainPane, 300,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Player");
        primaryStage.show();
    }
    
}
