/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.universome.radio.RadioUVM;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/**
 *
 * @author gianluca
 */
public class Episode {
    
    private final String title;
    private final String duration;
    
    private JSONObject episode;
    
    public Episode(String title, long duration) {
        this.title = title;
        this.duration = this.setDuration(duration);
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDuration() {
        return this.duration;
    }
    
    public String setDuration(long milliseconds) {
        
        // Format milliseconds in hh:mm:ss
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(milliseconds),
            TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds)),
            TimeUnit.MILLISECONDS.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));
        return hms;
    }
}
