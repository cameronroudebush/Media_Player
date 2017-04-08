package media_player_project;

import java.io.File;

public class MediaInFolder {
    private File folder;
    private File[] listOfFiles;

    public MediaInFolder(String folderDirectory) {
        File folder = new File(folderDirectory + File.separator);
        this.folder = folder;
        this.listOfFiles = this.folder.listFiles();
    }

    public File[] getListOfFiles() {
        return listOfFiles;
    }

    public void setFolder(String folderDirectory) {
        File folder = new File(folderDirectory);
        this.folder = folder;
        this.listOfFiles = this.folder.listFiles();
    }
}