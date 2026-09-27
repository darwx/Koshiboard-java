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
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Slider;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import javafx.stage.Modality;
import java.util.Timer;
import javafx.scene.layout.Pane;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import java.text.Normalizer;


public class GameSetUpPlayers extends Application {
    //Buttons - deklaracia
    private Button btBack;
    private Button btPlay;
    
    //Labels - deklaracia
    private Label lbPlay1;
    private Label lbPlay2;
    private Label lbPlay3;
    private Label lbPlay4;
    
    private Label lbPl1Colors;
    private Label lbPl2Colors;
    private Label lbPl3Colors;
    private Label lbPl4Colors;
    
    private Label lbPl1Figures;
    private Label lbPl2Figures;
    private Label lbPl3Figures;
    private Label lbPl4Figures;
    
    //TextField - deklaracia
    private TextField tfPl1Nickname;
    private TextField tfPl2Nickname;
    private TextField tfPl3Nickname;
    private TextField tfPl4Nickname;
    
    //ChoiceBox - deklaracia
    private ChoiceBox<String> cbPl1Colors;
    private ChoiceBox<String> cbPl1Figures;
    private ChoiceBox<String> cbPl2Colors;
    private ChoiceBox<String> cbPl2Figures;
    private ChoiceBox<String> cbPl3Colors;
    private ChoiceBox<String> cbPl3Figures;
    private ChoiceBox<String> cbPl4Colors;
    private ChoiceBox<String> cbPl4Figures;
    
    //Players - deklaracia
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
  
    //deklaracia scen
    private Scene scene;
    private Scene gsuMenuScene;
    private Scene playScScene;
    private Scene titleMenuScene;
  
    //deklaracia datovej polozky hlavnej stage pre aplikaciu
    private Stage primaryStage;
    
    //ObservableList - colors, figures - definicia
    private String[] colorOptions = {
            "Vyber si farbu:",
            "Červená",
            "Modrá",
            "Zelená",
            "Fialová",
            "Oranžová"
        };
    
    private String[] figureOptions = {
            "Vyber si figurku:",
            "Drink",
            "Ryba",
            "Klobúk",
            "Hrnček"
        };
    
    //Sety pre pouzite figurky a farby
    private Set<String> selectedColors = new HashSet<>();
    private Set<String> selectedFigures = new HashSet<>();
  
    public GameSetUpPlayers(Stage primaryStage, Scene gsuMenuScene, Scene titleMenuScene){
        this.primaryStage = primaryStage;
        this.gsuMenuScene = gsuMenuScene;
        this.titleMenuScene = titleMenuScene;
    }
    
    public void updateChoiceBox(ChoiceBox<String> choiceBox, ChoiceBox<String> otherCB1, ChoiceBox<String> otherCB2, ChoiceBox<String> otherCB3){
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                otherCB1.getItems().remove(newValue);
                otherCB2.getItems().remove(newValue);
                otherCB3.getItems().remove(newValue);
            }
            
            if(oldValue != null && !oldValue.equals("Vyber si farbu:") && !oldValue.equals("Vyber si figurku:")){
                otherCB1.getItems().add(oldValue);
                otherCB2.getItems().add(oldValue);
                otherCB3.getItems().add(oldValue);
            }
            
            choiceBox.getItems().remove("Vyber si farbu:");
            choiceBox.getItems().remove("Vyber si figurku:");
        });
    }
    
    public String normalizeInput(String input){
        return input.replace("ž", "z")
                    .replace("Ž", "Z")
                    .replace("Č", "C")
                    .replace("č", "c")
                    .replace("ú", "u")
                    .replace("Ú", "U")
                    .replace("Á", "A")
                    .replace("á", "a"); 
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
        
        //Play
        btPlay = new Button();
        btPlay.setMinWidth(GlobalVars.secBtWidth);
        btPlay.setMinHeight(GlobalVars.secBtHeight);
        btPlay.setOnAction(new ButtonPress());
        btPlay.setFocusTraversable(false);
        btPlay.getStyleClass().add("btPlay");
        
        //Player1
        lbPlay1 = new Label();
        lbPlay1.setStyle("-fx-background-image: url(/img/labels/lbPl1.png);");
        lbPlay1.setPrefWidth(GlobalVars.secBtWidth);
        lbPlay1.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        lbPl1Colors = new Label();
        lbPl1Colors.setStyle("-fx-background-image: url(/img/labels/lbColor.png);");
        lbPl1Colors.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl1Colors.setPrefHeight(GlobalVars.secBtHeight );
        
        lbPl1Figures = new Label();
        lbPl1Figures.setStyle("-fx-background-image: url(/img/labels/lbFigure.png);");
        lbPl1Figures.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl1Figures.setPrefHeight(GlobalVars.secBtHeight );
        
        tfPl1Nickname = new TextField();
        tfPl1Nickname.setFocusTraversable(false);
        tfPl1Nickname.setPromptText("Meno:");
        
        //pl1 - choiceBoxes
        cbPl1Colors = new ChoiceBox();
        cbPl1Colors.getItems().addAll(colorOptions);
        cbPl1Colors.getSelectionModel().select(0);
        cbPl1Colors.setMinWidth(GlobalVars.secBtWidth);
        cbPl1Colors.setMinHeight(GlobalVars.secBtHeight);
        cbPl1Colors.setFocusTraversable(false);
        
        cbPl1Figures = new ChoiceBox();
        cbPl1Figures.getItems().addAll(figureOptions);
        cbPl1Figures.getSelectionModel().select(0);
        cbPl1Figures.setMinWidth(GlobalVars.secBtWidth);
        cbPl1Figures.setMinHeight(GlobalVars.primBtHeight);
        cbPl1Figures.setFocusTraversable(false);
        
        VBox vbPl1 = new VBox(10);
        vbPl1.setAlignment(Pos.CENTER);
        vbPl1.getChildren().addAll(lbPlay1, tfPl1Nickname, lbPl1Colors, cbPl1Colors, lbPl1Figures, cbPl1Figures);
        
        vbPl1.setMargin(lbPlay1, GlobalVars.gsupInsetMargin);
        vbPl1.setMargin(tfPl1Nickname, GlobalVars.gsupInsetMargin);
        vbPl1.setMargin(lbPl1Colors, GlobalVars.gsupInsetMargin);
        vbPl1.setMargin(cbPl1Colors, GlobalVars.gsupInsetMargin);
        vbPl1.setMargin(lbPl1Figures, GlobalVars.gsupInsetMargin);
        vbPl1.setMargin(cbPl1Figures, GlobalVars.gsupInsetMargin);
        
        //Player2
        lbPlay2 = new Label();
        lbPlay2.setStyle("-fx-background-image: url(/img/labels/lbPl2.png);");
        lbPlay2.setPrefWidth(GlobalVars.secBtWidth);
        lbPlay2.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        lbPl2Colors = new Label();
        lbPl2Colors.setStyle("-fx-background-image: url(/img/labels/lbColor.png);");
        lbPl2Colors.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl2Colors.setPrefHeight(GlobalVars.secBtHeight );
        
        lbPl2Figures = new Label();
        lbPl2Figures.setStyle("-fx-background-image: url(/img/labels/lbFigure.png);");
        lbPl2Figures.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl2Figures.setPrefHeight(GlobalVars.secBtHeight );
        
        tfPl2Nickname = new TextField();
        tfPl2Nickname.setFocusTraversable(false);
        tfPl2Nickname.setPromptText("Meno:");
        
        //pl2 - choiceBoxes
        cbPl2Colors = new ChoiceBox();
        cbPl2Colors.getItems().addAll(colorOptions);
        cbPl2Colors.getSelectionModel().select(0);
        cbPl2Colors.setMinWidth(GlobalVars.secBtWidth);
        cbPl2Colors.setMinHeight(GlobalVars.secBtHeight);
        cbPl2Colors.setFocusTraversable(false);
        
        cbPl2Figures = new ChoiceBox();
        cbPl2Figures.getItems().addAll(figureOptions);
        cbPl2Figures.getSelectionModel().select(0);
        cbPl2Figures.setMinWidth(GlobalVars.secBtWidth);
        cbPl2Figures.setMinHeight(GlobalVars.primBtHeight);
        cbPl2Figures.setFocusTraversable(false);
        
        VBox vbPl2 = new VBox(10);
        vbPl2.setAlignment(Pos.CENTER);
        vbPl2.getChildren().addAll(lbPlay2, tfPl2Nickname, lbPl2Colors, cbPl2Colors, lbPl2Figures, cbPl2Figures);
        
        vbPl2.setMargin(lbPlay2, GlobalVars.gsupInsetMargin);
        vbPl2.setMargin(tfPl2Nickname, GlobalVars.gsupInsetMargin);
        vbPl2.setMargin(lbPl2Colors, GlobalVars.gsupInsetMargin);
        vbPl2.setMargin(cbPl2Colors, GlobalVars.gsupInsetMargin);
        vbPl2.setMargin(lbPl2Figures, GlobalVars.gsupInsetMargin);
        vbPl2.setMargin(cbPl2Figures, GlobalVars.gsupInsetMargin);
        
        //Player3
        lbPlay3 = new Label();
        lbPlay3.setStyle("-fx-background-image: url(/img/labels/lbPl3.png);");
        lbPlay3.setPrefWidth(GlobalVars.secBtWidth);
        lbPlay3.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        lbPl3Colors = new Label();
        lbPl3Colors.setStyle("-fx-background-image: url(/img/labels/lbColor.png);");
        lbPl3Colors.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl3Colors.setPrefHeight(GlobalVars.secBtHeight );
        
        lbPl3Figures = new Label();
        lbPl3Figures.setStyle("-fx-background-image: url(/img/labels/lbFigure.png);");
        lbPl3Figures.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl3Figures.setPrefHeight(GlobalVars.secBtHeight );
        
        tfPl3Nickname = new TextField();
        tfPl3Nickname.setFocusTraversable(false);
        tfPl3Nickname.setPromptText("Meno:");
  
        //pl3 - choiceBoxes
        cbPl3Colors = new ChoiceBox();
        cbPl3Colors.getItems().addAll(colorOptions);
        cbPl3Colors.getSelectionModel().select(0);
        cbPl3Colors.setMinWidth(GlobalVars.secBtWidth);
        cbPl3Colors.setMinHeight(GlobalVars.secBtHeight);
        cbPl3Colors.setFocusTraversable(false);
        
        cbPl3Figures = new ChoiceBox();
        cbPl3Figures.getItems().addAll(figureOptions);
        cbPl3Figures.getSelectionModel().select(0);
        cbPl3Figures.setMinWidth(GlobalVars.secBtWidth);
        cbPl3Figures.setMinHeight(GlobalVars.primBtHeight);
        cbPl3Figures.setFocusTraversable(false);
        
        VBox vbPl3 = new VBox(10);
        vbPl3.setAlignment(Pos.CENTER);
        vbPl3.getChildren().addAll(lbPlay3, tfPl3Nickname, lbPl3Colors, cbPl3Colors, lbPl3Figures, cbPl3Figures);
        
        vbPl3.setMargin(lbPlay3, GlobalVars.gsupInsetMargin);
        vbPl3.setMargin(tfPl3Nickname, GlobalVars.gsupInsetMargin);
        vbPl3.setMargin(lbPl3Colors, GlobalVars.gsupInsetMargin);
        vbPl3.setMargin(cbPl3Colors, GlobalVars.gsupInsetMargin);
        vbPl3.setMargin(lbPl3Figures, GlobalVars.gsupInsetMargin);
        vbPl3.setMargin(cbPl3Figures, GlobalVars.gsupInsetMargin);
        
        //Player4
        lbPlay4 = new Label();
        lbPlay4.setStyle("-fx-background-image: url(/img/labels/lbPl4.png);");
        lbPlay4.setPrefWidth(GlobalVars.secBtWidth);
        lbPlay4.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        lbPl4Colors = new Label();
        lbPl4Colors.setStyle("-fx-background-image: url(/img/labels/lbColor.png);");
        lbPl4Colors.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl4Colors.setPrefHeight(GlobalVars.secBtHeight );
        
        lbPl4Figures = new Label();
        lbPl4Figures.setStyle("-fx-background-image: url(/img/labels/lbFigure.png);");
        lbPl4Figures.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPl4Figures.setPrefHeight(GlobalVars.secBtHeight );
        
        tfPl4Nickname = new TextField();
        tfPl4Nickname.setFocusTraversable(false);
        tfPl4Nickname.setPromptText("Meno:");
  
        //pl4 - choiceBoxes
        cbPl4Colors = new ChoiceBox();
        cbPl4Colors.getItems().addAll(colorOptions);
        cbPl4Colors.getSelectionModel().select(0);
        cbPl4Colors.setMinWidth(GlobalVars.secBtWidth);
        cbPl4Colors.setMinHeight(GlobalVars.secBtHeight);
        cbPl4Colors.setFocusTraversable(false);
        
        cbPl4Figures = new ChoiceBox();
        cbPl4Figures.getItems().addAll(figureOptions);
        cbPl4Figures.getSelectionModel().select(0);
        cbPl4Figures.setMinWidth(GlobalVars.secBtWidth);
        cbPl4Figures.setMinHeight(GlobalVars.primBtHeight);
        cbPl4Figures.setFocusTraversable(false);
               
        VBox vbPl4 = new VBox(10);
        vbPl4.setAlignment(Pos.CENTER);
        vbPl4.getChildren().addAll(lbPlay4, tfPl4Nickname, lbPl4Colors, cbPl4Colors, lbPl4Figures, cbPl4Figures);
        
        vbPl4.setMargin(lbPlay4, GlobalVars.gsupInsetMargin);
        vbPl4.setMargin(tfPl4Nickname, GlobalVars.gsupInsetMargin);
        vbPl4.setMargin(lbPl4Colors, GlobalVars.gsupInsetMargin);
        vbPl4.setMargin(cbPl4Colors, GlobalVars.gsupInsetMargin);
        vbPl4.setMargin(lbPl4Figures, GlobalVars.gsupInsetMargin);
        vbPl4.setMargin(cbPl4Figures, GlobalVars.gsupInsetMargin);
        
        //aktualizovanie choiceBoxov
        //farby
        updateChoiceBox(cbPl1Colors, cbPl2Colors, cbPl3Colors, cbPl4Colors);
        updateChoiceBox(cbPl2Colors, cbPl1Colors, cbPl3Colors, cbPl4Colors);
        updateChoiceBox(cbPl3Colors, cbPl1Colors, cbPl2Colors, cbPl4Colors);
        updateChoiceBox(cbPl4Colors, cbPl1Colors, cbPl2Colors, cbPl3Colors);
        
        //figurky
        updateChoiceBox(cbPl1Figures, cbPl2Figures, cbPl3Figures, cbPl4Figures);
        updateChoiceBox(cbPl2Figures, cbPl1Figures, cbPl3Figures, cbPl4Figures);
        updateChoiceBox(cbPl3Figures, cbPl1Figures, cbPl2Figures, cbPl4Figures);
        updateChoiceBox(cbPl4Figures, cbPl1Figures, cbPl2Figures, cbPl3Figures);
        
        //HBox center
        HBox hbCenter = new HBox(10);
        hbCenter.getChildren().addAll(vbPl1, vbPl2);
        hbCenter.setAlignment(Pos.CENTER);
        
        System.out.println(GlobalVars.playerCount);
        
        switch (GlobalVars.playerCount) {
            case 3:
                hbCenter.getChildren().add(vbPl3);
                break;
            case 4:
                hbCenter.getChildren().addAll(vbPl3, vbPl4);
                break;       
        }
        
        hbCenter.layout();
        
        //Region - spacer/rozdelovac - bottom
        Region bottomSpacer = new Region();
        HBox.setHgrow(bottomSpacer, Priority.ALWAYS);
        
        //HBox - Spodok obrazovky
        HBox hbBottom = new HBox(10);
        hbBottom.setAlignment(Pos.CENTER);
        hbBottom.getChildren().addAll(btBack, bottomSpacer, btPlay);
      
        //BorderPane - rozlozenie obrazovky
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-image: url(/img/menuBackground.jpg); -fx-background-size: cover; -fx-background-postition: center; -fx-background-repeat: no-repeat;");
        
        //BorderPane - Center
        bp.setCenter(hbCenter);
        bp.setAlignment(hbCenter, Pos.CENTER);
        
        //BorderPane - Bottom
        bp.setBottom(hbBottom);
        bp.setMargin(hbBottom, GlobalVars.secBtInset);
      
        scene = new Scene(bp, GlobalVars.width, GlobalVars.height);
        scene.getStylesheets().addAll(getClass().getResource("/css/GameSetUpPlayers.css").toExternalForm(), getClass().getResource("/css/Style.css").toExternalForm());
    }
  
    class ButtonPress implements EventHandler<ActionEvent> {
        public void handle(ActionEvent evt){
            Stage stage = (Stage) ((Button) evt.getSource()).getScene().getWindow();
            
            boolean nicknameError = false;
            boolean colorError = false;
            boolean figureError = false;
            boolean sameNicknameError = false;
            boolean nicknameLengthError = false;
            
            //upozornenia
            Stage alertStage = new Stage();
            
            Label lbNameError = new Label("Každý hráč musí zadať meno!");
            lbNameError.getStyleClass().add("lbError");
            Label lbColorError = new Label("Každý hráč si musí vybrať farbu!");
            lbColorError.getStyleClass().add("lbError");
            Label lbFigureError = new Label("Každý hráč si musí vybrať figurku!");
            lbFigureError.getStyleClass().add("lbError");
            Label lbSameNicknameError = new Label("Každý hráč musí mať unikátne meno!");
            lbSameNicknameError.getStyleClass().add("lbError");
            Label lbNicknameLengthError = new Label();
            lbNicknameLengthError.getStyleClass().add("lbError");
            
            Button btOk = new Button();
            btOk.getStyleClass().add("btOk");
            btOk.setPrefWidth(GlobalVars.secBtWidth);
            btOk.setPrefHeight(GlobalVars.secBtHeight);
            
            btOk.setFocusTraversable(false);
            btOk.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    alertStage.hide();
                }
            });
            
            VBox vbAlerts = new VBox();
            vbAlerts.setAlignment(Pos.CENTER);
            vbAlerts.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
            
            vbAlerts.setMargin(lbNameError, GlobalVars.cbInset);
            vbAlerts.setMargin(lbColorError, GlobalVars.cbInset);
            vbAlerts.setMargin(lbFigureError, GlobalVars.cbInset);
            vbAlerts.setMargin(lbSameNicknameError, GlobalVars.cbInset);
            vbAlerts.setMargin(lbNicknameLengthError, GlobalVars.cbInset);
            vbAlerts.setMargin(btOk, GlobalVars.cbInset);
            
            Scene alertScene = new Scene(vbAlerts, GlobalVars.width / 2, GlobalVars.height / 3);
            alertScene.getStylesheets().addAll(getClass().getClassLoader().getResource("css/Style.css").toExternalForm(), getClass().getResource("css/GameSetUpPlayers.css").toExternalForm());
            alertScene.setFill(Color.TRANSPARENT);
            
            alertStage.setScene(alertScene);
            alertStage.setResizable(false);
            alertStage.setAlwaysOnTop(true);
            alertStage.initOwner(primaryStage);
            alertStage.initStyle(StageStyle.UNDECORATED);
            alertStage.initModality(Modality.APPLICATION_MODAL);
            alertStage.setTitle("Error");
            alertStage.getIcons().add(new Image("/img/KoshiboardLogo.png"));
            alertStage.initStyle(StageStyle.TRANSPARENT);
            
            if(evt.getTarget().equals(btPlay)){
                //Generovanie objektov - hracov
                player1 = new Player("player1", "", "", 1, GlobalVars.startCash, false, GlobalVars.timer * 60, new Timer(true), 0, 0, 0);
                player2 = new Player("player2", "", "", 2, GlobalVars.startCash, false, GlobalVars.timer * 60, new Timer(true), 0, 0, 0);
                player3 = new Player("player3", "", "", 3, GlobalVars.startCash, false, GlobalVars.timer * 60, new Timer(true), 0, 0, 0);
                player4 = new Player("player4", "", "", 4, GlobalVars.startCash, false, GlobalVars.timer * 60, new Timer(true), 0 ,0, 0);
            
                //kontrola ci hraci 1 a 2 zadali meno
                if(tfPl1Nickname.getCharacters().toString().equals("") || tfPl2Nickname.getCharacters().toString().equals("")){
                    nicknameError = true;
                    System.out.println("NICKNAME ERROR");
                }else{
                    //player1
                    player1.setNickname(tfPl1Nickname.getCharacters().toString());
                        
                    //player2
                    player2.setNickname(tfPl2Nickname.getCharacters().toString());
                }
                
                //kontrola dlzky mien hracov 1 a 2
                if(tfPl1Nickname.getCharacters().toString().length() < 3 || tfPl2Nickname.getCharacters().toString().length() < 3){
                    nicknameLengthError = true;
                    lbNicknameLengthError.setText("Meno musí byť minimálne 3 znaky dlhé!");
                }
                                                 
                if(tfPl1Nickname.getCharacters().toString().length() > 15 || tfPl2Nickname.getCharacters().toString().length() > 15){
                    nicknameLengthError = true;
                    lbNicknameLengthError.setText("Meno môže byť maximálne 15 znakov dlhé!");
                }
                
                //kontrola ci hraci 1 a 2 nemaju rovnake meno
                if(tfPl1Nickname.getCharacters().toString().equals(tfPl2Nickname.getCharacters().toString()) && !nicknameError){
                    sameNicknameError = true;
                    System.out.println("SAME NICKNAME ERROR");
                }
                
                //kontrola ci hraci 1 a 2 vybrali farbu
                if(cbPl1Colors.getValue().toString().equals("Vyber si farbu:") || cbPl2Colors.getValue().toString().equals("Vyber si farbu:")){
                    colorError = true;
                    System.out.println("COLOR ERROR");
                }else{
                    //player1
                    player1.setColor(normalizeInput(cbPl1Colors.getValue().toString()));
                    System.out.println(player1.getColor());
                    
                    //player2
                    player2.setColor(normalizeInput(cbPl2Colors.getValue().toString()));
                    System.out.println(player2.getColor());
                }
                
                //kontrola ci hraci 1 a 2 vybrali figurku
                if(cbPl1Figures.getValue().toString().equals("Vyber si figurku:") || cbPl2Figures.getValue().toString().equals("Vyber si figurku:")){
                    figureError = true;
                    System.out.println("FIGURE ERROR");
                }else{
                    //player1
                    player1.setFigure(normalizeInput(cbPl1Figures.getValue().toString()));
                    System.out.println(player1.getFigure());
                    
                    //player2
                    player2.setFigure(normalizeInput(cbPl2Figures.getValue().toString()));
                    System.out.println(player2.getFigure());
                }

                if(GlobalVars.playerCount >= 3){
                    //player3
                    //kontrola ci hrac 3 zadal meno
                    if(tfPl3Nickname.getCharacters().toString().equals("")){
                        nicknameError = true;
                        System.out.println("NICKNAME ERROR");
                    }else{
                        player3.setNickname(tfPl3Nickname.getCharacters().toString());
                    }
                    
                    //kontrola dlzky mena hraca 3
                    if(tfPl3Nickname.getCharacters().toString().length() < 3){
                        nicknameLengthError = true;
                        lbNicknameLengthError.setText("Meno musí byť minimálne 3 znaky dlhé!");
                    }
                                                 
                    if(tfPl3Nickname.getCharacters().toString().length() > 15){
                        nicknameLengthError = true;
                        lbNicknameLengthError.setText("Meno môže byť maximálne 15 znakov dlhé!");
                    }
                    
                    //kontrola ci hraci 1, 2 a 3 nemaju rovnake meno
                    if((tfPl1Nickname.getCharacters().toString().equals(tfPl2Nickname.getCharacters().toString()) ||
                    tfPl1Nickname.getCharacters().toString().equals(tfPl3Nickname.getCharacters().toString()) ||
                    tfPl2Nickname.getCharacters().toString().equals(tfPl3Nickname.getCharacters().toString()))  && !nicknameError){
                        sameNicknameError = true;
                        System.out.println("SAME NICKNAME ERROR");
                    }
                    
                    //kontrola ci hrac 3 vybral farbu
                    if(cbPl3Colors.getValue().toString().equals("Vyber si farbu:")){
                        colorError = true;
                        System.out.println("COLOR ERROR");
                    }else{
                        player3.setColor(normalizeInput(cbPl3Colors.getValue().toString()));
                    }
                    
                    //kontrola ci hrac 3 vybral figurku
                    if(cbPl3Figures.getValue().toString().equals("Vyber si figurku:")){
                        figureError = true;
                        System.out.println("FIGURE ERROR");
                    }else{
                        player3.setFigure(normalizeInput(cbPl3Figures.getValue().toString()));
                    }

                    if(GlobalVars.playerCount == 4){
                        //player4
                        //kontrola ci hrac 4 zadal meno
                        if(tfPl4Nickname.getCharacters().toString().equals("")){
                            nicknameError = true;
                            System.out.println("NICKNAME ERROR");
                        }else{
                            player4.setNickname(tfPl4Nickname.getCharacters().toString());   
                        }
                        
                        //kontrola dlzky mena hraca 4
                        if(tfPl4Nickname.getCharacters().toString().length() < 3){
                            nicknameLengthError = true;
                            lbNicknameLengthError.setText("Meno musí byť minimálne 3 znaky dlhé!");
                        }
                                                     
                        if(tfPl4Nickname.getCharacters().toString().length() > 15){
                            nicknameLengthError = true;
                            lbNicknameLengthError.setText("Meno môže byť maximálne 15 znakov dlhé!");
                        }
                        
                        //kontrola ci hraci 1, 2, 3 a 4 nemaju rovnake meno
                        if((tfPl1Nickname.getCharacters().toString().equals(tfPl2Nickname.getCharacters().toString()) || 
                        tfPl1Nickname.getCharacters().toString().equals(tfPl3Nickname.getCharacters().toString()) || 
                        tfPl1Nickname.getCharacters().toString().equals(tfPl4Nickname.getCharacters().toString()) || 
                        tfPl2Nickname.getCharacters().toString().equals(tfPl3Nickname.getCharacters().toString()) || 
                        tfPl2Nickname.getCharacters().toString().equals(tfPl4Nickname.getCharacters().toString()) || 
                        tfPl3Nickname.getCharacters().toString().equals(tfPl4Nickname.getCharacters().toString()))  && !nicknameError){
                            
                        }
                        
                        //kontrola ci hrac 4 vybral farbu
                        if(cbPl4Colors.getValue().toString().equals("Vyber si farbu:")){
                            colorError = true;
                            System.out.println("COLOR ERROR");
                        }else{
                            player4.setColor(normalizeInput(cbPl4Colors.getValue().toString()));
                        }
                        
                        //kontrola ci hrac4 vybral figurku
                        if(cbPl4Figures.getValue().toString().equals("Vyber si figurku:")){
                            figureError = true;
                            System.out.println("FIGURE ERROR");
                        }else{
                            player4.setFigure(normalizeInput(cbPl4Figures.getValue().toString()));
                        }     
                    }
                }
                if(nicknameError || colorError || figureError || sameNicknameError || nicknameLengthError){
                    if(nicknameError){
                        vbAlerts.getChildren().add(lbNameError);
                    }
                    
                    if(nicknameLengthError){
                        vbAlerts.getChildren().add(lbNicknameLengthError);
                    }

                    if(sameNicknameError){
                        vbAlerts.getChildren().add(lbSameNicknameError);
                    }
                    
                    if(colorError){
                        vbAlerts.getChildren().add(lbColorError);
                    }
                    
                    if(figureError){
                        vbAlerts.getChildren().add(lbFigureError);
                    }

                    vbAlerts.getChildren().add(btOk);
                    alertStage.show();   
                }else{
                    //Vytvorenie objektu PlayScene pre dalsie potrebne pracovanie
                    PlayScene playScene = new PlayScene(titleMenuScene, primaryStage, player1, player2, player3, player4);
                    playScene.start(new Stage());
                    playScScene = playScene.getScene();
                    stage.setScene(playScScene);
                    stage.setFullScreen(true);
                }

            }
            
            if(evt.getTarget().equals(btBack)){
                Platform.runLater(() -> {
                    stage.setScene(gsuMenuScene);
                    stage.setFullScreen(true);    
                });
            }
        }
    }
      
    public Scene getScene(){
        return scene;
    }
    
    public static void main(String args[]){
        System.setProperty("file.encoding", "UTF-8");
        Application.launch(args);
    }
}