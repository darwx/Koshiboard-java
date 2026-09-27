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
import java.awt.Desktop;
import java.net.URI;
import javafx.scene.layout.StackPane;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;

public class Credits extends Application {
    private Scene scene;
    private Button btBack, btDavid, btSamo;
    private Stage primaryStage;
    private Scene titleMenuScene;
  
    public Credits (Stage primaryStage, Scene titleMenuScene){
        this.primaryStage = primaryStage;
        this.titleMenuScene = titleMenuScene;
    }

    public void start(Stage stage){
        //Buttons
        //Back
        btBack = new Button();
        btBack.setMinWidth(GlobalVars.secBtWidth);
        btBack.setMinHeight(GlobalVars.secBtHeight);
        btBack.setOnAction(new ButtonPress());
        btBack.setFocusTraversable(false);
        btBack.getStyleClass().add("btBack");
        
        //David
        btDavid = new Button("David");
        btDavid.setMinWidth(GlobalVars.primBtWidth);
        btDavid.setMinHeight(GlobalVars.primBtHeight);
        btDavid.setOnAction(new ButtonPress());
        btDavid.setFocusTraversable(false);
        btDavid.getStyleClass().add("bt");
        
        //Samo
        btSamo = new Button("Samo");
        btSamo.setMinWidth(GlobalVars.primBtWidth);
        btSamo.setMinHeight(GlobalVars.primBtHeight);
        btSamo.setOnAction(new ButtonPress());
        btSamo.setFocusTraversable(false);
        btSamo.getStyleClass().add("bt");
        
        //VBox - stred
        VBox vbCenter = new VBox(20);
        vbCenter.getChildren().addAll(btDavid, btSamo);
        vbCenter.setAlignment(Pos.CENTER);
                             
        //VBox - lava strana
        VBox vbLeft = new VBox(10);
        vbLeft.getChildren().add(btBack);
        vbLeft.setAlignment(Pos.BOTTOM_CENTER);
        
        //BorderPane - rozlozenie obrazovky
        BorderPane bp = new BorderPane();
        bp.setMargin(vbLeft, GlobalVars.secBtInset);
        bp.setStyle("-fx-background-image: url(/img/menuBackground.jpg); -fx-background-size: cover; -fx-background-postition: center; -fx-background-repeat: no-repeat;");
        
        //Border Pane - Center
        bp.setCenter(vbCenter);
        
        //BorderPane - Left
        bp.setLeft(vbLeft);
  
        scene = new Scene(bp, GlobalVars.width, GlobalVars.height);
        scene.getStylesheets().addAll(getClass().getResource("/css/Credits.css").toExternalForm(), getClass().getResource("/css/Style.css").toExternalForm());
    }
  
    class ButtonPress implements EventHandler<ActionEvent> {
        public void handle(ActionEvent evt){
            Stage stage = (Stage) ((Button) evt.getSource()).getScene().getWindow();
      
            if(evt.getTarget().equals(btBack)){
                stage.setScene(titleMenuScene);
                stage.setFullScreen(true);
            }
            
            if(evt.getTarget().equals(btDavid)){
                try{
                    Desktop.getDesktop().browse(new URI("https://www.instagram.com/les0__/"));    
                }catch(Exception e) {
                    
                }
            }
     
            if(evt.getTarget().equals(btSamo)){
                try{
                    Desktop.getDesktop().browse(new URI("https://www.instagram.com/kraus.samko/"));    
                }catch(Exception e) {
                    
                }
        }   }
    }
  
    public Scene getScene(){
        return scene;
    }

    public static void main(String args[]){
        Application.launch(args);
    }

}
