package media_player_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
        
        mainPane.setPadding(new Insets(10,5,5,10)); // top, , ,left
        
        MediaInFolder files = new MediaInFolder("mediaPlayerButtons" + File.separator);
        ObservableList fileList = FXCollections.observableArrayList(files.getListOfFiles());
        ListView lv = new ListView<>(fileList);
        lv.setEditable(false);
        mainPane.add(lv, 0, 1,3,1);
        
        Button skipBackward = new Button();
        skipBackward.setGraphic(new ImageView(new Image(new FileInputStream("mediaPlayerButtons"+ File.separator + "fastBackward.png"))));
        
        Button playButton = new Button();
        playButton.setGraphic(new ImageView(new Image(new FileInputStream("mediaPlayerButtons"+ File.separator + "playButton.png"))));
        
        
        Button skipForward = new Button();
        Image skipImage = new Image(new FileInputStream("mediaPlayerButtons"+ File.separator + "fastForward.png"));
        skipForward.setGraphic(new ImageView(skipImage));

        
        ArrayList<Button> buttonList= new ArrayList<>();
        buttonList.add(skipForward);
        buttonList.add(playButton);
        buttonList.add(skipBackward);
        
        for(Button b : buttonList){
            b.setPadding(Insets.EMPTY);
        }
        
        playButton.setOnAction(new buttonEvent());
        
        mainPane.add(skipBackward, 0, 0);
        mainPane.add(playButton, 1, 0);
        mainPane.add(skipForward, 2, 0);

        
        Scene scene = new Scene(mainPane, 600,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Player");
        primaryStage.show();
    }
    
}
