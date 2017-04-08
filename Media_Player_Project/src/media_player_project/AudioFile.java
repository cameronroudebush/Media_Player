/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package media_player_project;

import java.io.File;
import java.util.Date;

/**
 *
 * @author brynd
 */
public class AudioFile extends File{
    private String title;
    private String artist;
    private Date dateAdded;

    public AudioFile(String string) {
        super(string);
    }
    
    public String toString(){
        
        return title;
    }
    
}
