package media_player_project;

import java.io.File;

public class MediaInFolder {
    private File folder;
    private File[] listOfFiles;

    public MediaInFolder(String folderDirectory) {
        File folder = new File(folderDirectory);
        this.folder = folder;
        this.listOfFiles = this.folder.listFiles();
    }

    public File[] getListOfFiles() {
        return listOfFiles;
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public void setListOfFiles(File[] listOfFiles) {
        this.listOfFiles = listOfFiles;
    }
}