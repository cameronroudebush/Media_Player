package media_player_project;

import java.io.File;
import java.util.ArrayList;

public class MediaInFolder {

    private File folder;
    private ArrayList<File> listOfFiles = new ArrayList();

    public MediaInFolder(String folderDirectory) {
        this.folder = new File(folderDirectory + File.separator);
        File[] array = this.folder.listFiles();
        for (File array1 : array) {
            if (array1.toString().contains(".mp3") || array1.toString().contains(".wav")) {
                listOfFiles.add(array1);
            }
        }
    }

    public ArrayList<File> getListOfFiles() {
        return listOfFiles;
    }

    public void setFolder(String folderDirectory) {
        this.folder = new File(folderDirectory + File.separator);
        File[] array = this.folder.listFiles();
        for (File array1 : array) {
            if (array1.toString().contains(".mp3") || array1.toString().contains(".wav")) {
                listOfFiles.add(array1);
            }
        }
    }
}
