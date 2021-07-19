package sample.view;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public abstract class Music {

    public static String WELL = "/Music/wellSong.wav";

    public static String BEAR_GROWL = "/Music/bear_growl.mp3";

    public static final String Main_Music ="/Music/viola.mp3";
    public static final String Sec_Music ="/Music/05 Vacant Heart.mp3";


    static Music music ;

    private static void createMusic(){
        if(music == null){
            music = new Music() {};
        }
    }

    public static void playAction(String path){
        createMusic();
        AudioClip audioClip = new AudioClip(music.getClass().getResource(path).toExternalForm());
        audioClip.play();
        //System.out.println(this.getClass().getResource("../../resources/music/wellSong.wav").getPath());
    }

    public static void playMusic(){
        createMusic();
        media = new Media(music.getClass().getResource(Main_Music).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    public static MediaPlayer mediaPlayer;

    public static Media media;

    public static String HEN = "/Music/hen.mp3";

}