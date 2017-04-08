package media_player_project;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Cameron Roudebush, Brynden Williams
 */
public class MediaPlayerGUI extends Application {

    private String directory;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String userName = System.getProperty("user.name");
        this.directory = "C:" + File.separator + "Users" + File.separator + userName + File.separator + File.separator + "Music";
        GridPane mainPane = new GridPane();
        mainPane.setHgap(20);
        mainPane.setVgap(5);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItem = new MenuItem("Change Music Directory");
        menuFile.getItems().add(menuItem);
        menuBar.getMenus().add(menuFile);
        VBox Vbox = new VBox();
        Vbox.getChildren().add(menuBar);
        Vbox.setPadding(new Insets(-10, -5, -5, -10));
        mainPane.add(Vbox, 0, 0, 25, 1);
        

        mainPane.setPadding(new Insets(10, 5, 5, 10)); // top, , ,left
        MediaInFolder files = new MediaInFolder(this.directory);
        ObservableList<File> fileList = FXCollections.observableArrayList(files.getListOfFiles());
        ListView<File> lv = new ListView<>(fileList);
        lv.setEditable(false);
        mainPane.add(lv, 0, 3, 15, 1);

        menuItem.setOnAction(e -> {
            JFrame mainFrame = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileHidingEnabled(true);
            fileChooser.setDialogTitle("Choose a folder for media");
            int returnVal = fileChooser.showOpenDialog(mainFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                this.directory = fileChooser.getSelectedFile().toString();
                files.setFolder(directory);
                fileList.clear();
                fileList.addAll(files.getListOfFiles());
            }
        });

        Button skipBackward = new Button();
        skipBackward.setGraphic(new ImageView(new Image(new FileInputStream("mediaPlayerButtons" + File.separator + "fastBackward.png"))));

        Button playButton = new Button();
        playButton.setGraphic(new ImageView(new Image(new FileInputStream("mediaPlayerButtons" + File.separator + "playButton.png"))));
        playButton.setOnAction(e -> {
            Media media = new Media(new File(lv.getSelectionModel().getSelectedItem().toString()).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        });

        Button skipForward = new Button();
        Image skipImage = new Image(new FileInputStream("mediaPlayerButtons" + File.separator + "fastForward.png"));
        skipForward.setGraphic(new ImageView(skipImage));

        ArrayList<Button> buttonList = new ArrayList<>();
        buttonList.add(skipForward);
        buttonList.add(playButton);
        buttonList.add(skipBackward);

        for (Button b : buttonList) {
            b.setPadding(Insets.EMPTY);
        }

        mainPane.add(skipBackward, 0, 1);
        mainPane.add(playButton, 1, 1);
        mainPane.add(skipForward, 2, 1);

        Scene scene = new Scene(mainPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Media Player");
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });
    }
}
