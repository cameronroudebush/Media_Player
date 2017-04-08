package media_player_project;

import java.io.File;

public class MediaInFolder {
    private File folder;
    private String[] listOfFiles;

    public MediaInFolder(String folderDirectory) {
        File folder = new File(folderDirectory + File.separator);
        this.folder = folder;
        File[] list = this.folder.listFiles();
        listOfFiles = new String[list.length];
        for (int i = 0; i < list.length; i++){
            listOfFiles[i] = list[i].toString().replace(folderDirectory, "");
        }
    }

    public String[] getListOfFiles() {
        return listOfFiles;
    }

    public void setFolder(String folderDirectory) {
        File folder = new File(folderDirectory);
        this.folder = folder;
        File[] list = this.folder.listFiles();
        listOfFiles = new String[list.length];
        for (int i = 0; i < list.length; i++){
            listOfFiles[i] = list[i].toString().replace(folderDirectory, "");
        }
    }
}