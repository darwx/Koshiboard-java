import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.io.FileInputStream;
import javafx.scene.input.KeyCombination;
import javafx.application.Platform;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.text.Normalizer;

public class TitleMenu extends Application {
    //deklaracia  komponentov
    private Label lbNazov;
    private Button btPlay, btSettings, btExit, btCredits;
      
    //deklaracia scen
    private Scene scene;
    private Scene gsuScene;
    private Scene settScene;
    private Scene crScene;
    
    //Media Player
    MediaPlayer mediaPlayer;
  
    @Override
    public void start(Stage stage){
        //label
        lbNazov = new Label("Koshiboard");
        
        //buttons
        //play
        btPlay = new Button();
        btPlay.setMinWidth(GlobalVars.primBtWidth);
        btPlay.setMinHeight(GlobalVars.primBtHeight);
        btPlay.setOnAction(new ButtonPress());
        btPlay.setFocusTraversable(false);
        btPlay.getStyleClass().add("btPlay");                         
        
        //settings
        btSettings = new Button();
        btSettings.setMinWidth(GlobalVars.primBtWidth);
        btSettings.setMinHeight(GlobalVars.primBtHeight);
        btSettings.setOnAction(new ButtonPress());
        btSettings.setFocusTraversable(false);
        btSettings.getStyleClass().add("btSettings");    
        
        //exit
        btExit = new Button();
        btExit.setMinWidth(GlobalVars.secBtWidth);
        btExit.setMinHeight(GlobalVars.secBtHeight);
        btExit.setOnAction(new ButtonPress());
        btExit.setFocusTraversable(false);
        btExit.getStyleClass().add("btExit");
        
        //credits
        btCredits = new Button();
        btCredits.setMinWidth(GlobalVars.secBtWidth);
        btCredits.setMinHeight(GlobalVars.secBtHeight);
        btCredits.setOnAction(new ButtonPress());
        btCredits.setFocusTraversable(false);
        btCredits.getStyleClass().add("btCredits");    
        
        //vrch - top
        HBox hbTop = new HBox(10);
        
        InputStream logoInputStream = getClass().getResourceAsStream("/img/KoshiboardLogo.png");    
        
        Image logo = new Image(logoInputStream);
        
        ImageView logoImageView = new ImageView();
        logoImageView.setImage(logo);
        
        hbTop.getChildren().add(logoImageView);
        hbTop.setAlignment(Pos.CENTER);
        
        //stred menu, nazov, play a Settings tlacitka
        VBox vbCenter = new VBox(20);
        vbCenter.getChildren().addAll(btPlay, btSettings);
        vbCenter.setAlignment(Pos.CENTER);
            
        //lava strana - exit
        VBox vbLeft = new VBox(10);
        vbLeft.getChildren().add(btExit);
        vbLeft.setAlignment(Pos.BOTTOM_CENTER);
                
        //prava strana - credits
        VBox vbRight = new VBox(10);
        vbRight.getChildren().add(btCredits);
        vbRight.setAlignment(Pos.BOTTOM_CENTER);
            
        //BorderPane - rozlozenie obrazovky
        BorderPane bp = new BorderPane();
        bp.setMargin(vbRight, GlobalVars.secBtInset);    
        bp.setMargin(vbLeft, GlobalVars.secBtInset);
        bp.setStyle("-fx-background-image: url(/img/menuBackground.jpg); -fx-background-size: cover; -fx-background-postition: center; -fx-background-repeat: no-repeat;");
        
        //vrch
        bp.setTop(hbTop);
        
        //stred
        bp.setCenter(vbCenter);
            
        //lava strana
        bp.setLeft(vbLeft);
            
        //prava strana
        bp.setRight(vbRight);
            
        //vytvaranie hlavnej sceny pre tuto triedu - TitleScreen
        scene = new Scene(bp, GlobalVars.width, GlobalVars.height);
        scene.getStylesheets().addAll(getClass().getResource("/css/TitleScreen.css").toExternalForm(),getClass().getResource("/css/Style.css").toExternalForm());
        
        //vytvorenie objektu typu Credits , pre dalsie nasledne pracovanie
        Credits credits = new Credits(stage, scene);
        credits.start(new Stage());
        crScene = credits.getScene();
        
        //Spustenie hudby
        //Hudba
        String musicFile = "./sound/music.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);   
        mediaPlayer.play();
        mediaPlayer.setAudioSpectrumNumBands(0);
        
        //spustenie a nastavenie hlavnej stage pre aplikaciu        
        stage.setScene(scene);
        stage.setTitle("Koshiboard");
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.getIcons().add(new Image("/img/KoshiboardLogo.png"));
        stage.show();
    }
  
    class ButtonPress implements EventHandler<ActionEvent> {
        public void handle(ActionEvent evt){
            Stage stage = (Stage) ((Button) evt.getSource()).getScene().getWindow();
            if(evt.getTarget().equals(btPlay)){
                //vytvorenie objektu typu GameSetUp , pre dalsie nasledne pracovanie
                GameSetUp gameSetup = new GameSetUp(stage, scene);
                gameSetup.start(stage);
                gsuScene = gameSetup.getScene();
      
                stage.setScene(gsuScene);
                stage.setFullScreen(true);    
            }
            
            if(evt.getTarget().equals(btSettings)){
                //vytvorenie objektu typu Settings, pre dalsie nasledne pracovanie
                Settings settings = new Settings(stage, scene, mediaPlayer);
                settings.start(new Stage());
                settScene = settings.getScene();
                stage.setScene(settScene);
                stage.setFullScreen(true);  
            }
            
            if(evt.getTarget().equals(btExit)){
                stage.close();
            }
            
            if(evt.getTarget().equals(btCredits)){
                stage.setScene(crScene);
                stage.setFullScreen(true);
            }
        }
    }
  
    public Scene getScene(){
        return scene;
    }
    
    public MediaPlayer getMusic(){
        return mediaPlayer;
    }
  
    public static void main(String[] args){
        Application.launch(args);
    }
}