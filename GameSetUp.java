import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.ColumnConstraints;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.effect.GaussianBlur;
import javafx.geometry.HPos;
import javafx.scene.Group;

public class GameSetUp extends Application {
    //Buttons - deklaracia
    private Button btBack;
    private Button btNext;
    
    //Labels - deklaracia
    private Label lbPlayNum;
    private Label lbStartCash;
    private Label lbTargetCash;
    private Label lbTimer;
    
    //Slider - deklaracia
    private Slider slPlayNum;
    
    //ComboBox - deklaracia
    private ComboBox cbStartCash;
    private ComboBox cbTargetCash;
    private ComboBox cbTimer;
  
    //deklaracia scen
    private Scene scene;
    private Scene titleMenuScene;
    private Scene gsupScene;
  
    //deklaracia datovej polozky hlavnej stage pre aplikaciu
    private Stage primaryStage;
  
    public GameSetUp(Stage primaryStage, Scene titleMenuScene){
        this.primaryStage = primaryStage;
        this.titleMenuScene = titleMenuScene;
    }

    public void start(Stage stage){
        //Label
        //PlayNum
        lbPlayNum = new Label();
        lbPlayNum.setPadding(GlobalVars.cbInset);
        lbPlayNum.setStyle("-fx-background-image: url(img/labels/lbPocHracov.png);");
        lbPlayNum.setPrefWidth(GlobalVars.secBtWidth);
        lbPlayNum.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        //StartCash
        lbStartCash = new Label();
        lbStartCash.setPadding(GlobalVars.cbInset);
        lbStartCash.setStyle("-fx-background-image: url(img/labels/lbStCash.png);");
        lbStartCash.setPrefWidth(GlobalVars.secBtWidth);
        lbStartCash.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        //TargetCash
        lbTargetCash = new Label();
        lbTargetCash.setPadding(GlobalVars.cbInset);
        lbTargetCash.setStyle("-fx-background-image: url(img/labels/lbTarCash.png);");
        lbTargetCash.setPrefWidth(GlobalVars.secBtWidth);
        lbTargetCash.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        //Timer
        lbTimer = new Label();
        lbTimer.setPadding(GlobalVars.cbInset);
        lbTimer.setStyle("-fx-background-image: url(img/labels/lbTimer.png);");
        lbTimer.setPrefWidth(GlobalVars.secBtWidth);
        lbTimer.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        //Buttons
        //Back
        btBack = new Button();
        btBack.setMinWidth(GlobalVars.secBtWidth);
        btBack.setMinHeight(GlobalVars.secBtHeight);
        btBack.setOnAction(new ButtonPress());
        btBack.setFocusTraversable(false);
        btBack.getStyleClass().add("btBack");
        
        //Next
        btNext = new Button();
        btNext.setMinWidth(GlobalVars.secBtWidth);
        btNext.setMinHeight(GlobalVars.secBtHeight);
        btNext.setOnAction(new ButtonPress());
        btNext.setFocusTraversable(false);
        btNext.getStyleClass().add("btNext");
  
        //Slider
        slPlayNum = new Slider(2, 4, 3);
        slPlayNum.setShowTickMarks(true);
        slPlayNum.setShowTickLabels(true);
        slPlayNum.setMajorTickUnit(1);
        slPlayNum.setMinorTickCount(0);
        slPlayNum.setSnapToTicks(true);
        slPlayNum.setValue(2);
        slPlayNum.setMaxWidth(GlobalVars.primBtWidth);
        slPlayNum.setFocusTraversable(false);
        slPlayNum.setPadding(GlobalVars.cbInset);

        //ComboBoxes
        //StartingCash
        ObservableList<String> startCashOptions = FXCollections.observableArrayList(
            "186 000",
            "372 000",
            "744 000"
        );
        
        cbStartCash = new ComboBox(startCashOptions);
        cbStartCash.setMinWidth(GlobalVars.primBtWidth);
        cbStartCash.getSelectionModel().selectFirst();
        cbStartCash.setFocusTraversable(false);
        cbStartCash.setPadding(GlobalVars.cbInsetPadding);
                
        //TargetCash
        ObservableList<String> targetCashOptions = FXCollections.observableArrayList(
            "1 000 000",
            "2 000 000",
            "3 000 000"
        );
        
        cbTargetCash = new ComboBox(targetCashOptions);
        cbTargetCash.setMinWidth(GlobalVars.primBtWidth);
        cbTargetCash.getSelectionModel().selectFirst();
        cbTargetCash.setFocusTraversable(false);
        cbTargetCash.setPadding(GlobalVars.cbInsetPadding);
        
        //Timer
        ObservableList<String> timerOptions = FXCollections.observableArrayList(
            "10 Min",
            "20 Min",
            "30 Min"
        );
        
        cbTimer = new ComboBox(timerOptions);
        cbTimer.setMinWidth(GlobalVars.primBtWidth);
        cbTimer.getSelectionModel().selectFirst();
        cbTimer.setFocusTraversable(false);
        cbTimer.setPadding(GlobalVars.cbInsetPadding);
  
        //Region - spacer/rozdelovac
        Region bottomSpacer = new Region();
        HBox.setHgrow(bottomSpacer, Priority.ALWAYS);
  
        //GridPane - Column Constraints
        //column0
        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(25);
        
        //column1
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);

        //column2
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);

        //GridPane - stred obrazovky
        GridPane gpCenter = new GridPane();
        gpCenter.setAlignment(Pos.CENTER_LEFT);
        
        gpCenter.getColumnConstraints().addAll(column0, column1, column2);
        
        gpCenter.setMargin(cbStartCash, GlobalVars.cbInset);
        gpCenter.setMargin(cbTargetCash, GlobalVars.cbInset);
        gpCenter.setMargin(cbTimer, GlobalVars.cbInset);
        gpCenter.setMargin(slPlayNum, GlobalVars.cbInset);
        
        gpCenter.setMargin(lbStartCash, GlobalVars.cbInset);
        gpCenter.setMargin(lbTargetCash, GlobalVars.cbInset);
        gpCenter.setMargin(lbTimer, GlobalVars.cbInset);
        gpCenter.setMargin(lbPlayNum, GlobalVars.cbInset);
        
        gpCenter.add(lbPlayNum, 0, 0);
        gpCenter.add(slPlayNum, 1, 0);
        gpCenter.add(lbStartCash, 0, 1);
        gpCenter.add(cbStartCash, 1, 1);
        gpCenter.add(lbTargetCash, 0, 2);
        gpCenter.add(cbTargetCash, 1, 2);
        gpCenter.add(lbTimer, 0, 3);
        gpCenter.add(cbTimer, 1, 3);
        
        //HBox - Spodok obrazovky
        HBox hbBottom = new HBox(10);
        hbBottom.setMaxWidth(GlobalVars.width - 40);
        hbBottom.getChildren().addAll(btBack, bottomSpacer, btNext);
      
        //BorderPane - rozlozenie obrazovky
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-image: url(/img/menuBackground.jpg); -fx-background-size: cover; -fx-background-postition: center; -fx-background-repeat: no-repeat;");
        
        //BorderPane - Center
        bp.setCenter(gpCenter);
        
        //BorderPane - Bottom
        bp.setBottom(hbBottom);
        bp.setMargin(hbBottom, GlobalVars.secBtInset);
        
        scene = new Scene(bp, GlobalVars.width, GlobalVars.height);
        scene.getStylesheets().addAll(getClass().getResource("/css/GameSetUp.css").toExternalForm(), getClass().getResource("/css/Style.css").toExternalForm());
        
        stage.setResizable(false);
    }
  
    class ButtonPress implements EventHandler<ActionEvent> {
        public void handle(ActionEvent evt){
            Stage stage = (Stage) ((Button) evt.getSource()).getScene().getWindow();
          
            if(evt.getTarget().equals(btBack)){
                stage.setScene(titleMenuScene);
                stage.setFullScreen(true);
            }
    
            if(evt.getTarget().equals(btNext)){     
                GlobalVars.playerCount = (int)slPlayNum.getValue();
                GlobalVars.startCash = Integer.parseInt(cbStartCash.getValue().toString().trim().replace(" ", ""));
                GlobalVars.targetCash = Integer.parseInt(cbTargetCash.getValue().toString().trim().replace(" ", ""));
                GlobalVars.timer = Integer.parseInt(cbTimer.getValue().toString().trim().replace("Min", "").replace(" ", ""));
                
                //vytvorenie objektu typu GameSetUpPlayers, pre dalsie nasledne pracovanie
                GameSetUpPlayers gsuPlayers = new GameSetUpPlayers(primaryStage, scene, titleMenuScene);
                gsuPlayers.start(new Stage());
                gsupScene = gsuPlayers.getScene();
                
                stage.setScene(gsupScene);
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
