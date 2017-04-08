package media_player_project;

import java.io.File;

public class MediaInFolder {
    private File folder;
    private File[] listOfFiles;

    public MediaInFolder(File folder) {
        this.folder = folder;
        this.listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                System.out.println("File: " + listOfFile);
            } else if (listOfFile.isDirectory()) {
                System.out.println("Directory: " + listOfFile);
            }
        }
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