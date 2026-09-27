import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Settings extends Application {
    private Scene scene;
    private Button btBack;
    private Stage primaryStage;
    private Scene titleMenuScene;
    private MediaPlayer music;
    private Label lbMusic;
    private Label lbEffects;
    private Slider slMusic;
    private Slider slEffects;
  
    public Settings (Stage primaryStage, Scene titleMenuScene, MediaPlayer music){
        this.primaryStage = primaryStage;
        this.titleMenuScene = titleMenuScene;
        this.music = music;
    }

    public void start(Stage stage){
        //Labels
        //Music
        lbMusic = new Label();
        lbMusic.setPrefWidth(GlobalVars.secBtWidth * 1.5);
        lbMusic.setPrefHeight(GlobalVars.secBtHeight * 1.5);
        lbMusic.getStyleClass().add("lbMusic");
        
        //Effects
        lbEffects = new Label();
        lbEffects.setPrefWidth(GlobalVars.secBtWidth * 1.5);
        lbEffects.setPrefHeight(GlobalVars.secBtHeight * 1.5);
        lbEffects.getStyleClass().add("lbEffects");
        
        //Buttons
        //Back
        btBack = new Button();
        btBack.setMinWidth(GlobalVars.secBtWidth);
        btBack.setMinHeight(GlobalVars.secBtHeight);
        btBack.setOnAction(new ButtonPress());
        btBack.setFocusTraversable(false);
        btBack.getStyleClass().add("btBack");
        
        //Sliders
        //Music
        slMusic = new Slider(0, 100, 100);
        slMusic.setShowTickMarks(true);
        slMusic.setShowTickLabels(true);
        slMusic.setMajorTickUnit(25);
        slMusic.setMinorTickCount(0);
        slMusic.setValue(music.getVolume() * 100);
        slMusic.setSnapToTicks(false);
        slMusic.setPrefWidth(GlobalVars.primBtWidth);
        slMusic.setFocusTraversable(false);
        slMusic.setPadding(GlobalVars.cbInset);
        
        slMusic.valueProperty().addListener((obs, oldValue, newValue) -> {
            music.setVolume(newValue.doubleValue() / 100);
        });
        
        //Effects
        slEffects = new Slider(0, 100, 100);
        slEffects.setShowTickMarks(true);
        slEffects.setShowTickLabels(true);
        slEffects.setMajorTickUnit(25);
        slEffects.setMinorTickCount(0);
        slEffects.setValue(GlobalVars.sfx * 100);
        slEffects.setSnapToTicks(false);
        slEffects.setPrefWidth(GlobalVars.primBtWidth);
        slEffects.setFocusTraversable(false);
        slEffects.setPadding(GlobalVars.cbInset);
        
        slEffects.setUserData(false);
        
        slEffects.valueProperty().addListener((obs, oldValue, newValue) -> {
            GlobalVars.sfx = newValue.doubleValue() / 100;
            slEffects.setUserData(true);
        });
        
        slEffects.setOnMouseReleased(event -> {
            if((boolean) slEffects.getUserData()){
                String effectFile = new File("./sound/parking.mp3").toURI().toString();
                Media effectSound = new Media(effectFile);
                MediaPlayer effectPlayer = new MediaPlayer(effectSound);
                effectPlayer.setVolume(GlobalVars.sfx);
                effectPlayer.setAudioSpectrumNumBands(0);
                effectPlayer.play();
                
                slEffects.setUserData(false);
            }    
        });
        
        //VBox - lava strana
        VBox vbLeft = new VBox(10);
        vbLeft.getChildren().add(btBack);
        vbLeft.setAlignment(Pos.BOTTOM_CENTER);
        
        //GridPane - stred obrazovky
        GridPane gpCenter = new GridPane();
        gpCenter.add(lbMusic, 0, 0);
        gpCenter.add(slMusic, 1, 0);
        gpCenter.add(lbEffects, 0, 1);
        gpCenter.add(slEffects, 1, 1);
        gpCenter.setAlignment(Pos.CENTER);
        gpCenter.setMargin(slMusic, GlobalVars.cbInset);
        gpCenter.setMargin(slEffects, GlobalVars.cbInset);
        gpCenter.setMargin(lbMusic, GlobalVars.cbInset);
        gpCenter.setMargin(lbEffects, GlobalVars.cbInset);
        
        //BorderPane - rozlozenie obrazovky
        BorderPane bp = new BorderPane();
        bp.setMargin(vbLeft, GlobalVars.secBtInset);
        bp.setMargin(gpCenter, GlobalVars.secBtInset);
        bp.setStyle("-fx-background-image: url(/img/menuBackground.jpg); -fx-background-size: cover; -fx-background-postition: center; -fx-background-repeat: no-repeat;");
        
        //Border Pane - Center
        bp.setCenter(gpCenter);
        
        //BorderPane - Left
        bp.setLeft(vbLeft);
  
        scene = new Scene(bp, GlobalVars.width, GlobalVars.height);
        scene.getStylesheets().addAll(getClass().getResource("/css/Settings.css").toExternalForm(), getClass().getResource("/css/Style.css").toExternalForm());
        
        stage.setResizable(false);
    }
  
    class ButtonPress implements EventHandler<ActionEvent> {
        public void handle(ActionEvent evt){
            Stage stage = (Stage) ((Button) evt.getSource()).getScene().getWindow();
      
            if(evt.getTarget().equals(btBack)){
                stage.setScene(titleMenuScene);
                stage.setFullScreen(true);
            }     

        }
    }
  
    public Scene getScene(){
        return scene;
    }

    public static void main(String args[]){
        Application.launch(args);
    }

}
