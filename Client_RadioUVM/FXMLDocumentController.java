/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.universome.radio.gui;

import eu.universome.radio.RadioUVM.Episode;
import eu.universome.radio.RadioUVM.Grabber;
import eu.universome.radio.RadioUVM.ResponseManager;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.json.JSONArray;
import javafx.scene.media.AudioClip;
import org.json.JSONObject;


/**
 *
 * @author gianluca
 */
public class FXMLDocumentController implements Initializable {
    
    private final Grabber grabber;
    private MediaPlayer mediaPlayer;
    
    @FXML private TableView<Episode> tableView;
    @FXML private TableColumn<Episode, String> titleCol;
    @FXML private TableColumn<Episode, String> durationCol;
    @FXML private TableColumn<Episode, Button> playCol;
    

    
    @FXML private Image image;
    @FXML private ImageView episodeImage;
    
    
    private String filePath;
    
    public FXMLDocumentController() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, URISyntaxException {
        
        // grabber initialization 
        this.grabber = new Grabber();
        System.out.println("==== Grabber Created ====");
        
        // Get the Show
        JSONArray shows = this.grabber.getUserShows();
        JSONObject show = shows.getJSONObject(0);
        String show_id = String.valueOf(show.get("show_id"));
        System.out.println("Show info: " + show.toString(4)); 
        
        // Get the Episode
        JSONArray episodes = this.grabber.getShowEpisodes(show_id);
        JSONObject episode = episodes.getJSONObject(0);
        String episode_id = String.valueOf(episode.get("episode_id"));
        
        // Get Episode info
        episode = this.grabber.getEpisodeInfo(episode_id);

        
        // Image Creation
        //image_url = "/images/gazzoli.jpg";
        //Image image = new Image(image_url);
        //imageview.setImage(image);
        
        /*
        if (filePath != null) {
            Media media = new Media(filePath);
            mediaPlayer = new MediaPlayer(media);
            //mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }*/
    }
    
    @FXML
    private void handleButtonAction (ActionEvent event) throws URISyntaxException{
        ResponseManager shows = new ResponseManager(this.grabber.getUserShows());
    }
    
    @FXML
    private void getUserShows (ActionEvent event) throws URISyntaxException {
        // Get the Show
        ResponseManager shows = new ResponseManager(this.grabber.getUserShows());
    }
    
    @FXML
    private void getEpisodes (ActionEvent event) throws URISyntaxException {
        // Get the Show
        ResponseManager episodes = new ResponseManager(this.grabber.getShowEpisodes("1593466"));
        ObservableList<Episode> data = FXCollections.observableArrayList();
        
        // List the episodes in the table
        for ( JSONObject episode : episodes ) {
            Episode e = new Episode(
                                episode.getString("title"), 
                                episode.getLong("duration") );
            
            data.add(e);
        }
        
        this.tableView.setItems(data);       
    }
    
    @FXML
    private void playEpisode (ActionEvent event) throws URISyntaxException {
    
    }
    
    @FXML
    private void setImage () {
        // load image
        this.image = new Image("images/gazzoli.jpg");
        
        // set image in ImageView
        this.episodeImage.setImage(image);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //https://gist.github.com/sharifulislam52/d17b4e1654a8214046d409b0a7d63c3b
        titleCol.setCellValueFactory(new PropertyValueFactory<Episode, String>("title"));
        durationCol.setCellValueFactory(new PropertyValueFactory<Episode, String>("duration"));
        //playCol.setCellValueFactory(new PropertyValueFactory<Episode, Button>("playCol"));
        
    }
    
}
