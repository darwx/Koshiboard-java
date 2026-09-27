import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.util.ArrayList;
import javafx.stage.Screen;
import javafx.scene.Node;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.input.KeyCombination;
import javafx.beans.value.ChangeListener;
import javafx.beans.property.IntegerProperty;
import java.text.Normalizer;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Map;
import java.util.HashMap;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Animation.Status;

public class PlayScene extends Application{
    //deklaracia tlacitok
    private Button btEndMove;
    private Button btPause;
    private Button btRoll;
    
    //deklaracia labelov
    private Label lbPozemky;
    
    private Label lbNazov;
    private Label lbUroven;
    private Label lbPredaj;
    
    //Player1
    private Label lbPl1Nickname;
    private Label lbPl1Money;
    private Label lbPl1Time;
    private InputStream pl1FigIS;
    private Image pl1FigImg;
    private ImageView pl1FigIW;
    
    //Player2
    private Label lbPl2Nickname;
    private Label lbPl2Money;
    private Label lbPl2Time;
    private InputStream pl2FigIS;
    private Image pl2FigImg;
    private ImageView pl2FigIW;
    
    //Player3
    private Label lbPl3Nickname;
    private Label lbPl3Money;
    private Label lbPl3Time;
    private InputStream pl3FigIS;
    private Image pl3FigImg;
    private ImageView pl3FigIW;
    
    //Player4
    private Label lbPl4Nickname;
    private Label lbPl4Money;
    private Label lbPl4Time;
    private InputStream pl4FigIS;
    private Image pl4FigImg;
    private ImageView pl4FigIW;
    
    //Kocky
    //Kocka1
    private InputStream dice1IS;
    private Image dice1Img;
    private ImageView dice1IW;
    
    //Kocka2
    private InputStream dice2IS;
    private Image dice2Img;
    private ImageView dice2IW;
    
    //Sanca karticka
    private InputStream chanceIS;
    private Image chanceImg;
    private ImageView chanceIW;
    
    //deklaracia scen
    private Scene scene;
    private Scene titleMenuScene;
    
    //deklaracia datovej polozky hlavnej stage pre aplikaciu
    private Stage primaryStage;
    
    //hraci
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    
    ArrayList<Player> players = new ArrayList<Player>();
    
    //policka
    //pozemky
    //furca
    private TileProperty furca1;
    private Label lbFurca1Rent;
    
    private TileProperty furca2;
    private Label lbFurca2Rent;
    
    //kvp
    private TileProperty kvp1;
    private Label lbKvp1Rent;
    
    private TileProperty kvp2;
    private Label lbKvp2Rent;
    
    private TileProperty kvp3;
    private Label lbKvp3Rent;
    
    //myslava
    private TileProperty myslava1;
    private Label lbMyslava1Rent;
    
    private TileProperty myslava2;
    private Label lbMyslava2Rent;
    
    private TileProperty myslava3;
    private Label lbMyslava3Rent;
    
    //barca
    private TileProperty barca1;
    private Label lbBarca1Rent;
    
    private TileProperty barca2;
    private Label lbBarca2Rent;
    
    private TileProperty barca3;
    private Label lbBarca3Rent;
    
    //krasna
    private TileProperty krasna1;
    private Label lbKrasna1Rent;
    
    private TileProperty krasna2;
    private Label lbKrasna2Rent;
    
    private TileProperty krasna3;
    private Label lbKrasna3Rent;
    
    //centrum
    private TileProperty centrum1;
    private Label lbCentrum1Rent;
    
    private TileProperty centrum2;
    private Label lbCentrum2Rent;
    
    private TileProperty centrum3;
    private Label lbCentrum3Rent;
    
    //terasa
    private TileProperty terasa1;
    private Label lbTerasa1Rent;
    
    private TileProperty terasa2;
    private Label lbTerasa2Rent;
    
    private TileProperty terasa3;
    private Label lbTerasa3Rent;
    
    //nad jazerom
    private TileProperty nadJazerom1;
    private Label lbNadJazerom1Rent;
    
    private TileProperty nadJazerom2;
    private Label lbNadJazerom2Rent;
    
    //obchody
    private TileProperty dargov;
    private Label lbDargovRent;
    
    private TileProperty cassovia;
    private Label lbCassoviaRent;
    
    private TileProperty optima;
    private Label lbOptimaRent;
    
    private TileProperty aupark;
    private Label lbAuparkRent;
    
    //sance
    private TileChance chance1;
    private TileChance chance2;
    private TileChance chance3;
    private TileChance chance4;
    
    //start
    private TileBase start;
    
    //vazenie
    private TileBase prison;
    
    //Mestsky Park
    private TileBase mestskyPark;
    
    //papez
    private TileBase papez;
    
    //poklady
    private TileBase poklad1;
    private TileBase poklad2;
    
    //Dane
    private TileBase voda;
    private TileBase elektrina;
    private TileBase internet;
    private TileBase parkovanie;
    
    //Array list pre vsetky policka
    ArrayList<TileBase> tiles = new ArrayList<TileBase>();
    
    //Mapa pre labely najmov vsetkych policok
    Map<String, Label> rentLabels = new HashMap<>();
    
    //GridPane - topLeft
    private GridPane gpTopLeft;
    
    //Premenna pre pracovanie s hracom, ktory je akutalne na tahu
    private int onTurn;
    
    //PropertyLabels - pozemky vlastnene hracom na tahu
    private ArrayList <Label>propertyLabels = new ArrayList<Label>();
    
    //PropertyLevels - urovne pozemkov vlastnene hracom na tahu
    private ArrayList <Label>propertyLevels = new ArrayList<Label>();
    
    //sellButtons - tlacitko na predaj pozemkov hraca na tahu
    private ArrayList <Button>sellButtons = new ArrayList<Button>();
    
    //Kontrolna premenna ci hrac v aktualnom tahu hodil kockou
    private boolean diceThrow = false;
    
    //Pane - stred obrazovky
    private Pane pCenter;
    
    //Turn - pomocna premenna pre pocet tahov
    private int turn = 0;
    
    //Moved - pomocna premenna na zistenie ci sa spustila animacia pohybu
    private boolean moved = false;
    
    //RollTimer - timer pre fixnutie bugu s hadzanim kocky
    private Timer rollTimer;
        
    public PlayScene(Scene titleMenuScene, Stage primaryStage, Player player1, Player player2, Player player3, Player player4){
        this.titleMenuScene = titleMenuScene;
        this.primaryStage = primaryStage;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
    }
    
    //pauza
    public void showPauseMenu(){
        //Buttons
        Button btResume = new Button();
        btResume.setFocusTraversable(false);
        btResume.setPrefWidth(GlobalVars.primBtWidth);
        btResume.setPrefHeight(GlobalVars.primBtHeight);
        btResume.setStyle("-fx-background-size: " + GlobalVars.primBtWidth / 1.5 + " " + "auto;");
        btResume.getStyleClass().add("btResume");
        
        Button btMenu = new Button();
        btMenu.setFocusTraversable(false);
        btMenu.setPrefWidth(GlobalVars.primBtWidth);
        btMenu.setPrefHeight(GlobalVars.primBtHeight);
        btMenu.setStyle("-fx-background-size: " + GlobalVars.primBtWidth / 1.5 + " " + "auto;");
        btMenu.getStyleClass().add("btMenu");
        
        Button btQuit = new Button();
        btQuit.setFocusTraversable(false);
        btQuit.setPrefWidth(GlobalVars.primBtWidth);
        btQuit.setPrefHeight(GlobalVars.primBtHeight);
        btQuit.setStyle("-fx-background-size: " + GlobalVars.primBtWidth / 1.5 + " " + "auto;");
        btQuit.getStyleClass().add("btQuit");
        
        //Vytvorenie stage pre pauseMenu
        Stage pauseStage = new Stage();
        pauseStage.initStyle(StageStyle.TRANSPARENT);
        pauseStage.initOwner(primaryStage);
        pauseStage.initModality(Modality.APPLICATION_MODAL);
        pauseStage.setResizable(false);
        pauseStage.setAlwaysOnTop(true);
        pauseStage.setFullScreen(true);
        pauseStage.setFullScreenExitHint("");
        pauseStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        
        //Layout pauseMenu
        VBox vbPauseMenu = new VBox(20);
        vbPauseMenu.getChildren().addAll(btResume, btMenu,btQuit);
        vbPauseMenu.setAlignment(Pos.CENTER);
        vbPauseMenu.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        players.get(onTurn).getTimer().cancel();
        
        //funkcia pre btResume
        btResume.setOnAction(e -> {
            pauseStage.close();
            players.get(onTurn).setTimer(new Timer(true));
            timing(players.get(onTurn));
            primaryStage.setFullScreen(true);   
        });
        
        //funkcia pre btMenu
        btMenu.setOnAction(e -> {
            primaryStage.setScene(titleMenuScene);
            primaryStage.setFullScreen(true);
            players.get(onTurn).getTimer().cancel();
            pauseStage.close();   
        });
        
        //funkcia pre btQuit
        btQuit.setOnAction(e -> {
            pauseStage.close();
            players.get(onTurn).getTimer().cancel();
            primaryStage.close();
        });
        
        Scene pauseScene = new Scene(vbPauseMenu, GlobalVars.width / 4, GlobalVars.height / 1.3);
        pauseScene.getStylesheets().addAll(getClass().getResource("/css/PlayScene.css").toExternalForm(), getClass().getResource("/css/Style.css").toExternalForm());
        pauseScene.setFill(Color.TRANSPARENT);
        pauseStage.setScene(pauseScene);
        
        pauseStage.showAndWait();
    }
    
    //Update labelov pre financny zostatok hracov
    public void updateMoney(Player player){
        switch(onTurn){
            case 0:
                lbPl1Money.setText(Integer.toString(player.getMoney()) + "€");
                break;
            case 1:
                lbPl2Money.setText(Integer.toString(player.getMoney()) + "€");
                break;
            case 2:
                lbPl3Money.setText(Integer.toString(player.getMoney()) + "€");
                break;
            case 3:
                lbPl4Money.setText(Integer.toString(player.getMoney()) + "€");
                break;
        }
    }
    
    //Metoda na predaj majetku
    public void sellProperty(Player player, ActionEvent evt){
        int propertyIndex = sellButtons.indexOf(evt.getTarget());
        
        player.getProperty(propertyIndex).setOwner(null);
        player.getProperty(propertyIndex).setLevel(0);
        player.setMoney(player.getMoney() + player.getProperty(propertyIndex).getPrice());
        player.removeProperty(propertyIndex);
             
        gpTopLeft.getChildren().remove(propertyLabels.get(propertyIndex));
        gpTopLeft.getChildren().remove(sellButtons.get(propertyIndex));
        gpTopLeft.getChildren().remove(propertyLevels.get(propertyIndex));
        
        propertyLabels.remove(propertyIndex);
        sellButtons.remove(propertyIndex);
        propertyLevels.remove(propertyIndex);
        
        updateRentLabels();
        updateMoney(player);       
    }

    //Vypis majetkov vlastnenych hracom na tahu
    public void showProperties(){
        Player player = players.get(onTurn);
    
        for(Node node : new ArrayList<>(gpTopLeft.getChildren())){
            if(propertyLabels.contains(node) || sellButtons.contains(node) || propertyLevels.contains(node)){
                gpTopLeft.getChildren().remove(node);    
            }
        }

        propertyLabels.clear();
        propertyLevels.clear();
        sellButtons.clear();
  
        for(int i = 0; i < player.getProperties().size(); i++){
            propertyLabels.add(new Label(player.getProperty(i).getLabel()));
            propertyLabels.get(i).setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-image: url(/img/buttons/btMenu.png); -fx-background-size: 100% auto; -fx-background-repeat: no-repeat; -fx-background-position: center;");
            propertyLabels.get(i).setAlignment(Pos.CENTER);
            propertyLabels.get(i).setPrefWidth(GlobalVars.secBtWidth / 2);
            propertyLabels.get(i).setPrefHeight(GlobalVars.secBtHeight);
            gpTopLeft.add(propertyLabels.get(i), 0, i + 2);
            gpTopLeft.setMargin(propertyLabels.get(i), GlobalVars.psPropInMargin);
            
            propertyLevels.add(new Label(Integer.toString(player.getProperty(i).getLevel())));
            propertyLevels.get(i).setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
            propertyLevels.get(i).setAlignment(Pos.CENTER);
            gpTopLeft.add(propertyLevels.get(i), 1, i + 2);
            gpTopLeft.setMargin(propertyLevels.get(i), GlobalVars.psPropInMargin);
                    
            sellButtons.add(new Button());
            sellButtons.get(i).setPrefWidth(GlobalVars.secBtWidth / 3);
            sellButtons.get(i).setPrefHeight(GlobalVars.secBtHeight / 3);
            sellButtons.get(i).setStyle("-fx-background-image: url(/img/buttons/btSell.png); -fx-background-size: auto 100%; -fx-background-repeat: no-repeat; -fx-background-postion: center;");
            sellButtons.get(i).setAlignment(Pos.CENTER);
            gpTopLeft.add(sellButtons.get(i), 2, i + 2);
            gpTopLeft.setMargin(sellButtons.get(i), GlobalVars.psPropInMargin);
                    
            sellButtons.get(i).setOnAction(evt -> {
                String sellFile = new File("sound/sell.mp3").toURI().toString();
                Media sellSound = new Media(sellFile);
                MediaPlayer sellPlayer = new MediaPlayer(sellSound);
                sellPlayer.setVolume(GlobalVars.sfx);   
                sellPlayer.play();    
                sellProperty(player, evt);
            });
        }
    }
    
    //Metoda pre casovac jednotlivych hracov
    public void timing(Player player){
        Timer timer = player.getTimer();
  
        TimerTask task = new TimerTask(){
            public void run(){
                int remainingTime = player.getTimeLeft();
                if(player.getTimeLeft() > 0){
                    int minutes = remainingTime / 60;
                    int seconds = remainingTime % 60;
                    
                    String timeLeft = String.format("%d:%02d", minutes, seconds);
                    Platform.runLater(() -> {
                        switch(player.getId()){
                            case 1:
                                lbPl1Time.setText(timeLeft);
                                break;
                            
                            case 2:
                                lbPl2Time.setText(timeLeft);
                                break;
                            
                            case 3:
                                lbPl3Time.setText(timeLeft);
                                break;
                            
                            case 4:
                                lbPl4Time.setText(timeLeft);
                                break;
                        }
                    });

                    remainingTime--;
                }else{
                    timer.cancel();
                    players.remove(player);
                    if(player.getId() == player1.getId()){
                        lbPl1Nickname.setStyle("-fx-text-fill: gray;");
                        lbPl1Money.setStyle("-fx-text-fill: gray;");
                        lbPl1Time.setStyle("-fx-text-fill: gray;");
                    }
                    if(player.getId() == player2.getId()){
                        lbPl2Nickname.setStyle("-fx-text-fill: gray;");
                        lbPl2Money.setStyle("-fx-text-fill: gray;");
                        lbPl2Time.setStyle("-fx-text-fill: gray;");
                    }
                    if(player.getId() == player3.getId()){
                        lbPl3Nickname.setStyle("-fx-text-fill: gray;");
                        lbPl3Money.setStyle("-fx-text-fill: gray;");
                        lbPl3Time.setStyle("-fx-text-fill: gray;");
                    }
                    if(player.getId() == player4.getId()){
                        lbPl4Nickname.setStyle("-fx-text-fill: gray;");
                        lbPl4Money.setStyle("-fx-text-fill: gray;");
                        lbPl4Time.setStyle("-fx-text-fill: gray;");
                    }
                }
                player.setTimeLeft(remainingTime);
            }
        };
        
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
    
    //Metoda pre alert na kupu
    public void showBuyMenu(Player player, TileProperty property){
        //Buttons
        Button btBuy = new Button();
        btBuy.setFocusTraversable(false);
        btBuy.setPrefWidth(GlobalVars.secBtWidth);
        btBuy.setPrefHeight(GlobalVars.secBtHeight);
        btBuy.getStyleClass().add("btBuy");
    
        Button btIgnore = new Button();
        btIgnore.setFocusTraversable(false);
        btIgnore.setPrefWidth(GlobalVars.secBtWidth);
        btIgnore.setPrefHeight(GlobalVars.secBtHeight);
        btIgnore.getStyleClass().add("btIgnore");
        
        //Labels
        Label lbProperty = new Label(property.getLabel());
        lbProperty.setPrefWidth(GlobalVars.secBtWidth);
        lbProperty.setPrefHeight(GlobalVars.secBtHeight * 2);
        lbProperty.setAlignment(Pos.CENTER);
        lbProperty.getStyleClass().add("lbProperty");
        
        Label lbPrice = new Label(Integer.toString(property.getPrice()) + "€");
        lbPrice.setPrefWidth(GlobalVars.secBtWidth);
        lbPrice.setPrefHeight(GlobalVars.secBtHeight * 2);
        lbPrice.setAlignment(Pos.CENTER);
        lbPrice.getStyleClass().add("lbPrice");
        
        Label lbError = new Label("Nemáš dosť financií.");
        lbError.setAlignment(Pos.CENTER);
        lbError.getStyleClass().add("lbError");
        lbError.setPrefWidth(GlobalVars.secBtWidth);
        lbError.setPrefHeight(GlobalVars.secBtHeight * 2);

        //Vytvorenie stage pre buyMenu
        Stage buyStage = new Stage();
        buyStage.initStyle(StageStyle.TRANSPARENT);
        buyStage.initOwner(primaryStage);
        buyStage.initModality(Modality.APPLICATION_MODAL);
        buyStage.setResizable(false);
        buyStage.setAlwaysOnTop(true);
        
        //Layout buyMenu
        VBox vbBuyMenu = new VBox(20);
        vbBuyMenu.getChildren().addAll(lbProperty, lbPrice, btBuy, btIgnore);
        vbBuyMenu.setAlignment(Pos.CENTER);
        vbBuyMenu.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //funkcia pre btBuy
        btBuy.setOnAction(e -> {;
            if(player.getMoney() >= property.getPrice()){
                player.setMoney(player.getMoney() - property.getPrice());
                
                property.setOwner(player);
                player.addProperty(property);
                showProperties();
                
                updateMoney(player);
                updateRentLabels();
                
                String buyFile = "sound/buy.wav";
                Media buySound = new Media(new File(buyFile).toURI().toString());
                MediaPlayer buyPlayer = new MediaPlayer(buySound);
                buyPlayer.setVolume(GlobalVars.sfx);   
                buyPlayer.play();

                buyStage.close();    
            }else{
                String denyFile = "sound/deny.wav";
                Media denySound = new Media(new File(denyFile).toURI().toString());
                MediaPlayer denyPlayer = new MediaPlayer(denySound);   
                denyPlayer.setVolume(GlobalVars.sfx);
                denyPlayer.play();
                
                if(!vbBuyMenu.getChildren().contains(lbError)){
                    vbBuyMenu.getChildren().add(lbError);
                }
            }
        });
        
        //funkcia pre btIgnore
        btIgnore.setOnAction(e -> {
            buyStage.close();   
        });
        
        Scene buyScene = new Scene(vbBuyMenu, GlobalVars.width / 4, GlobalVars.height / 1.5);
        buyScene.getStylesheets().addAll(getClass().getResource("/css/Style.css").toExternalForm(), getClass().getResource("/css/PlayScene.css").toExternalForm());
        buyScene.setFill(Color.TRANSPARENT);
        buyStage.setScene(buyScene);
        
        buyStage.showAndWait();
    }
    
    public Robot createRobot(){
        try {
            return new Robot();
        } catch(Exception e) {
            return null;
        }
    }
    
    //Metoda na platenie najmu
    public void showPayMenu(Player player, TileProperty tile){
        //Buttons
        Button btPay = new Button();
        btPay.setFocusTraversable(false);
        btPay.setPrefWidth(GlobalVars.secBtWidth);
        btPay.setPrefHeight(GlobalVars.secBtHeight);
        btPay.getStyleClass().add("btPay");
    
        Button btReBuy = new Button();
        btReBuy.setFocusTraversable(false);
        btReBuy.setPrefWidth(GlobalVars.secBtWidth);
        btReBuy.setPrefHeight(GlobalVars.secBtHeight);
        btReBuy.getStyleClass().add("btReBuy");
        
        Button btSell = new Button();
        btSell.getStyleClass().add("btSell");
        btSell.setPrefWidth(GlobalVars.secBtWidth);
        btSell.setPrefHeight(GlobalVars.secBtHeight);
        
        //Labels
        Label lbProperty = new Label(tile.getLabel());
        lbProperty.setAlignment(Pos.CENTER);
        lbProperty.getStyleClass().add("lbProperty");
        lbProperty.setPrefWidth(GlobalVars.secBtWidth);
        lbProperty.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        Label lbRent = new Label(tile.getRent() + "€");
        lbRent.setAlignment(Pos.CENTER);
        lbRent.getStyleClass().add("lbRent");
        lbRent.setPrefWidth(GlobalVars.secBtWidth);
        lbRent.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        Label lbReBuy = new Label((tile.getPrice() + tile.getRent()) + "€");
        lbReBuy.setAlignment(Pos.CENTER);
        lbReBuy.getStyleClass().add("lbReBuy");
        lbReBuy.setPrefWidth(GlobalVars.secBtWidth);
        lbReBuy.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        Label lbError = new Label("Nemáš dosť peňazí \nna prekúpenie");
        lbError.setAlignment(Pos.CENTER);
        lbError.getStyleClass().add("lbError");
        lbError.setPrefWidth(GlobalVars.secBtWidth);
        lbError.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        //ListView - predaj pozemkov
        ObservableList<String> olPropertyLabels = FXCollections.observableArrayList(); 
                
        for(TileProperty property : player.getProperties()){
            olPropertyLabels.add(property.getLabel());
        }
        
        ListView<String> lvProperties = new ListView();
        lvProperties.setItems(olPropertyLabels);
        lvProperties.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
        lvProperties.setPrefHeight(GlobalVars.primBtHeight);
        
        System.out.println(lvProperties.getItems());
        
        //Metoda pre zobrazenie ceny pozemkov pri hoverovani
        lvProperties.setCellFactory(lv -> new ListCell<>() {
            public void updateItem(String item, boolean empty){
                super.updateItem(item, empty);
                
                if (empty || item == null) {
                    setText(null);
                    setTooltip(null);
                } else {
                    setText(item);
                    setPadding(new Insets(10, 0, 10, 0));
                    Tooltip tooltip = new Tooltip();
                    
                    for(TileProperty property : player.getProperties()){
                        if(property.getLabel().equals(item)){
                            tooltip.setText(Integer.toString(property.getPrice()) + "€");
                        }
                    }
                    
                    setTooltip(tooltip);
                }
            }        
        });
        
        //Robot nad drzanie ctrl
        Robot robot = createRobot();
        
        //Algoritmus na vybratie viacerych moznosti bez pouzitia CTRL alebo SHIFT
        lvProperties.setOnMouseEntered(event -> {
            robot.keyPress(KeyEvent.VK_CONTROL);
        });
        
        lvProperties.setOnMouseExited(event -> {
            robot.keyRelease(KeyEvent.VK_CONTROL);
        });

        //Vytvorenie stage pre payMenu
        Stage payStage = new Stage();
        payStage.initStyle(StageStyle.TRANSPARENT);
        payStage.initOwner(primaryStage);
        payStage.initModality(Modality.APPLICATION_MODAL);
        payStage.setResizable(false);
        payStage.setAlwaysOnTop(true);
        
        //Layout payMenu
        VBox vbPayMenu = new VBox(20);
        vbPayMenu.getChildren().addAll(lbProperty, lbRent, btPay, lbReBuy, btReBuy);
        vbPayMenu.setAlignment(Pos.CENTER);
        vbPayMenu.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //funkcia pre btPay
        btPay.setOnAction(e -> {
            if(player.getMoney() >= tile.getRent()){
                player.setMoney(player.getMoney() - tile.getRent());
                tile.getOwner().setMoney(tile.getOwner().getMoney()  + tile.getRent());
            
                updateMoney(player);
                updateMoney(tile.getOwner());
                
                String sellFile = new File("sound/sell.mp3").toURI().toString();
                Media sellSound = new Media(sellFile);
                MediaPlayer sellPlayer = new MediaPlayer(sellSound);
                sellPlayer.setVolume(GlobalVars.sfx);   
                sellPlayer.play();    
            
                payStage.close(); 
            }else {
                lbError.setText("Nemáš dosť peňazí \nna nájom!");
                
                String denyFile = "sound/deny.wav";
                Media denySound = new Media(new File(denyFile).toURI().toString());
                MediaPlayer denyPlayer = new MediaPlayer(denySound);   
                denyPlayer.setVolume(GlobalVars.sfx);
                denyPlayer.play();
                
                if(!vbPayMenu.getChildren().contains(lbError)){
                    vbPayMenu.getChildren().add(lbError);
                }
                
                //Pocitanie majetku hraca
                int sum = 0;
                for(TileProperty property : player.getProperties()){
                    sum += property.getPrice();
                }
                
                if(player.getProperties().size() > 0 && sum > tile.getRent()){
                    if(!vbPayMenu.getChildren().contains(lvProperties)){
                        vbPayMenu.getChildren().add(lvProperties);
                    }
                    if(!vbPayMenu.getChildren().contains(btSell)){
                        vbPayMenu.getChildren().add(btSell);
                    }
                }else {
                    lbError.setText("Nemáš dosť majetku \nna nájom!");
                    bankrotMenu(player, payStage, tile);
                }

            }
        });
                                                                                                         
        //funkcia pre btReBuy
        btReBuy.setOnAction(e -> {;
            if(player.getMoney() >= (tile.getPrice()  + tile.getRent() )){
                player.setMoney(player.getMoney() - (tile.getPrice()  + tile.getRent()));
                tile.getOwner().setMoney(tile.getOwner().getMoney() + tile.getPrice()  + tile.getRent());
                tile.getOwner().removeProperty(tile);
                tile.setOwner(player);
                player.addProperty(tile);
                
                switch(onTurn){
                    case 0:
                        lbPl1Money.setText(Integer.toString(player.getMoney()));
                        break;
                    case 1:
                        lbPl2Money.setText(Integer.toString(player.getMoney()));
                        break;
                    case 2:
                        lbPl3Money.setText(Integer.toString(player.getMoney()));
                        break;
                    case 3:
                        lbPl4Money.setText(Integer.toString(player.getMoney()));
                        break;
                }
                
                String buyFile = "sound/buy.wav";
                Media buySound = new Media(new File(buyFile).toURI().toString());
                MediaPlayer buyPlayer = new MediaPlayer(buySound);
                buyPlayer.setVolume(GlobalVars.sfx);   
                buyPlayer.play();
                
                updateRentLabels();
                showProperties();
                payStage.close();       
            }else{
                if(!vbPayMenu.getChildren().contains(lbError)){
                    vbPayMenu.getChildren().add(lbError);
                    
                    String denyFile = "sound/deny.wav";
                    Media denySound = new Media(new File(denyFile).toURI().toString());
                    MediaPlayer denyPlayer = new MediaPlayer(denySound);   
                    denyPlayer.setVolume(GlobalVars.sfx);
                    denyPlayer.play();
                }
            }
        });
        
        //Funkcia pre btSell
        btSell.setOnAction(evt -> {
            int sum = 0;
        
            //ArrayListy pre predane policka
            ArrayList<String> removeItems = new ArrayList();
            ArrayList<TileProperty> removeProperties = new ArrayList();
        
            //Predaj vybranych policok
            for(String label : lvProperties.getSelectionModel().getSelectedItems()){
                for(TileProperty property : player.getProperties()){
                    if(label.equals(property.getLabel())){
                        sum += property.getPrice();
                        removeItems.add(label);
                        player.setMoney(player.getMoney() + sum);
                        property.setOwner(null);
                        property.setLevel(0);
                        removeProperties.add(property);
                        showProperties();
                        updateRentLabels();
                        String sellFile = new File("sound/sell.mp3").toURI().toString();
                        Media sellSound = new Media(sellFile);
                        MediaPlayer sellPlayer = new MediaPlayer(sellSound);
                        sellPlayer.setVolume(GlobalVars.sfx);
                        sellPlayer.play();
                    }
                }
            }
            
            //Odstranenie predanych policok z hraca a ListView
            lvProperties.getItems().removeAll(removeItems);
            
            for(TileProperty property : removeProperties){
                player.removeProperty(property);
            }
            
            if(player.getMoney() >= tile.getRent()){
                lbError.setText("Máš dosť peňazí.");
                vbPayMenu.getChildren().removeAll(lvProperties, btSell);
            }

            showProperties();
            updateRentLabels();
        });
        
        Scene payScene = new Scene(vbPayMenu, GlobalVars.width / 4, GlobalVars.height / 1.5);
        payScene.setFill(Color.TRANSPARENT);
        payScene.getStylesheets().addAll(getClass().getResource("/css/Style.css").toExternalForm(), getClass().getResource("/css/PlayScene.css").toExternalForm());
        payStage.setScene(payScene);
        
        payStage.showAndWait();
    }
    
    //Okienko pre zbankrotovanie hraca
    public void bankrotMenu(Player player, Stage payStage, TileProperty tile){
        //Buttons
        Button btOk = new Button();
        btOk.setAlignment(Pos.TOP_CENTER);
        btOk.getStyleClass().add("btOk");
        btOk.setPrefWidth(GlobalVars.secBtWidth);
        btOk.setPrefHeight(GlobalVars.secBtHeight);
        btOk.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btOk.setFocusTraversable(false);
        
        //Labels
        Label lbBankrot = new Label();
        lbBankrot.setAlignment(Pos.CENTER);
        lbBankrot.getStyleClass().add("lbBankrot");
        lbBankrot.setPrefWidth(GlobalVars.secBtWidth);
        lbBankrot.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        //Vytvorenie stage pre bankrotMenu
        Stage bankrotStage = new Stage();
        bankrotStage.initStyle(StageStyle.TRANSPARENT);
        bankrotStage.initOwner(primaryStage);
        bankrotStage.initModality(Modality.APPLICATION_MODAL);
        bankrotStage.setResizable(false);
        bankrotStage.setAlwaysOnTop(true);
        
        //Funkcia zbankrotovania hraca
        player.getTimer().cancel();
        players.remove(player);
        System.out.println("Players: " + players);
        System.out.println("Size" + players.size());
        
        ArrayList<TileProperty> properties = new ArrayList<>();
        
        //Predaj vsetkych hracovych pozemkov
        for(TileProperty property : player.getProperties()){
            property.setOwner(null);
            property.setLevel(0);
            player.setMoney(player.getMoney() + property.getPrice());
            properties.add(property);
        }
        
        player.getProperties().removeAll(properties);
        
        tile.getOwner().setMoney(tile.getOwner().getMoney() + player.getMoney());
        
        if(player.getId() == player1.getId()){
            lbPl1Nickname.setStyle("-fx-text-fill: red;");
            lbPl1Money.setStyle("-fx-text-fill: red;");
            lbPl1Time.setStyle("-fx-text-fill: red;");
        }
        if(player.getId() == player2.getId()){
            lbPl2Nickname.setStyle("-fx-text-fill: red;");
            lbPl2Money.setStyle("-fx-text-fill: red;");
            lbPl2Time.setStyle("-fx-text-fill: red;");
        }
        if(player.getId() == player3.getId()){
            lbPl3Nickname.setStyle("-fx-text-fill: red;");
            lbPl3Money.setStyle("-fx-text-fill: red;");
            lbPl3Time.setStyle("-fx-text-fill: red;");
        }
        if(player.getId() == player4.getId()){
            lbPl4Nickname.setStyle("-fx-text-fill: red;");
            lbPl4Money.setStyle("-fx-text-fill: red;");
            lbPl4Time.setStyle("-fx-text-fill: red;");
        }
        
        updateRentLabels();
        showProperties();
        
        //Layout bankrotMenu
        VBox vbBankrotMenu = new VBox(20);
        vbBankrotMenu.getChildren().addAll(lbBankrot, btOk);
        vbBankrotMenu.setAlignment(Pos.CENTER);
        vbBankrotMenu.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //Funkcia pre btOk
        btOk.setOnAction(event -> {
            payStage.close();
            bankrotStage.close();
        });
        
        Scene bankrotScene = new Scene(vbBankrotMenu, GlobalVars.width / 4, GlobalVars.height / 1.5);
        bankrotScene.setFill(Color.TRANSPARENT);
        bankrotScene.getStylesheets().addAll(getClass().getResource("/css/Style.css").toExternalForm(), getClass().getResource("/css/PlayScene.css").toExternalForm());
        bankrotStage.setScene(bankrotScene);
        
        bankrotStage.showAndWait();
    }
    
    //Metoda pre alert na upgrade
    public void showUpgradeMenu(Player player, TileProperty property){
        //Buttons
        Button btUpgrade = new Button();
        btUpgrade.setFocusTraversable(false);
        btUpgrade.setPrefWidth(GlobalVars.secBtWidth);
        btUpgrade.setPrefHeight(GlobalVars.secBtHeight);
        btUpgrade.getStyleClass().add("btUpgrade");
    
        Button btIgnore = new Button();
        btIgnore.setFocusTraversable(false);
        btIgnore.setPrefWidth(GlobalVars.secBtWidth);
        btIgnore.setPrefHeight(GlobalVars.secBtHeight);
        btIgnore.getStyleClass().add("btIgnore");
        
        //Labels
        Label lbProperty = new Label(property.getLabel());
        lbProperty.getStyleClass().add("lbProperty");
        lbProperty.setAlignment(Pos.CENTER);
        lbProperty.setPrefWidth(GlobalVars.secBtWidth);
        lbProperty.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        Label lbPrice = new Label(property.getUpgrade() + "€");
        lbPrice.getStyleClass().add("lbPrice");
        lbPrice.setAlignment(Pos.CENTER);
        lbPrice.setPrefWidth(GlobalVars.secBtWidth);
        lbPrice.setPrefHeight(GlobalVars.secBtHeight * 2);
        
        Label lbError = new Label("Nemáš dosť peňazí!");
        lbError.setAlignment(Pos.CENTER);
        lbError.getStyleClass().add("lbError");
        lbError.setPrefWidth(GlobalVars.secBtWidth);
        lbError.setPrefHeight(GlobalVars.secBtHeight * 2.5);
        
        //Vytvorenie stage pre upgradeMenu
        Stage upgradeStage = new Stage();
        upgradeStage.initStyle(StageStyle.TRANSPARENT);
        upgradeStage.initOwner(primaryStage);
        upgradeStage.initModality(Modality.APPLICATION_MODAL);
        upgradeStage.setResizable(false);
        upgradeStage.setAlwaysOnTop(true);
        
        //Layout upgradeMenu
        VBox vbUpgradeMenu = new VBox(20);
        vbUpgradeMenu.getChildren().addAll(lbProperty, lbPrice, btUpgrade, btIgnore);
        vbUpgradeMenu.setAlignment(Pos.CENTER);
        vbUpgradeMenu.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //funkcia pre btUpgrade
        btUpgrade.setOnAction(e -> {
            if(player.getMoney() >= property.getUpgrade() && property.getLevel() < 5){
                property.setLevel(property.getLevel() + 1);
                player.setMoney(player.getMoney() - property.getUpgrade());
                
                switch(property.getGroup()){
                    case "furca":
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(7000);
                                break;
                            case 1:
                                property.setRent(15000);
                                break;
                            case 2:
                                property.setRent(30000);
                                break;
                            case 3:
                                property.setRent(50000);
                                break;
                            case 4:
                                property.setRent(60000);
                                break;
                            case 5:
                                property.setRent(80000);
                                break;
                        }
                        break;
                    case "kvp": 
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(15000);
                                break;
                            case 1:
                                property.setRent(30000);
                                break;
                            case 2:
                                property.setRent(50000);
                                break;
                            case 3:
                                property.setRent(80000);
                                break;
                            case 4:
                                property.setRent(95000);
                                break;
                            case 5:
                                property.setRent(125000);
                                break;
                        }
                        break;
                    case "myslava":
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(20000);
                                break;
                            case 1:
                                property.setRent(50000);
                                break;
                            case 2:
                                property.setRent(90000);
                                break;
                            case 3:
                                property.setRent(140000);
                                break;
                            case 4:
                                property.setRent(165000);
                                break;
                            case 5:
                                property.setRent(215000);
                                break;
                        }
                        break;
                    case "barca":
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(25000);
                                break;
                            case 1:
                                property.setRent(65000);
                                break;
                            case 2:
                                property.setRent(110000);
                                break;
                            case 3:
                                property.setRent(170000);
                                break;
                            case 4:
                                property.setRent(200000);
                                break;
                            case 5:
                                property.setRent(270000);
                                break;
                        }
                        break;
                    case "krasna": 
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(35000);
                                break;
                            case 1:
                                property.setRent(95000);
                                break;
                            case 2:
                                property.setRent(110000);
                                break;
                            case 3:
                                property.setRent(230000);
                                break;
                            case 4:
                                property.setRent(270000);
                                break;
                            case 5:
                                property.setRent(350000);
                                break;
                        }
                        break;
                    case "centrum": 
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(40000);
                                break;
                            case 1:
                                property.setRent(100000);
                                break;
                            case 2:
                                property.setRent(170000);
                                break;
                            case 3:
                                property.setRent(260000);
                                break;
                            case 4:
                                property.setRent(305000);
                                break;
                            case 5:
                                property.setRent(395000);
                                break;
                        }
                        break;
                    case "terasa":
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(50000);
                                break;
                            case 1:
                                property.setRent(125000);
                                break;
                            case 2:
                                property.setRent(210000);
                                break;
                            case 3:
                                property.setRent(320000);
                                break;
                            case 4:
                                property.setRent(375000);
                                break;
                            case 5:
                                property.setRent(485000);
                                break;
                        }
                        break;
                    case "jazero":
                        switch(property.getLevel()){
                            case 0:
                                property.setRent(65000);
                                break;
                            case 1:
                                property.setRent(160000);
                                break;
                            case 2:
                                property.setRent(250000);
                                break;
                            case 3:
                                property.setRent(370000);
                                break;
                            case 4:
                                property.setRent(430000);
                                break;
                            case 5:
                                property.setRent(550000);
                                break;
                        }
                        break;
                }
                
                showProperties();
                updateRentLabels();

                String upgradeFile = "sound/upgrade.mp3";
                Media upgradeSound = new Media(new File(upgradeFile).toURI().toString());
                MediaPlayer upgradePlayer = new MediaPlayer(upgradeSound);
                upgradePlayer.setVolume(GlobalVars.sfx);   
                upgradePlayer.play();

                upgradeStage.close();    
            }else{
                String denyFile = "sound/deny.wav";
                Media denySound = new Media(new File(denyFile).toURI().toString());
                MediaPlayer denyPlayer = new MediaPlayer(denySound);   
                denyPlayer.setVolume(GlobalVars.sfx);
                denyPlayer.play();
            
                if(!vbUpgradeMenu.getChildren().contains(lbError)){
                    vbUpgradeMenu.getChildren().add(lbError);   
                }
            }
        });
        
        //funkcia pre btIgnore
        btIgnore.setOnAction(e -> {
            upgradeStage.close();   
        });
        
        Scene upgradeScene = new Scene(vbUpgradeMenu, GlobalVars.width / 4, GlobalVars.height / 1.5);
        upgradeScene.setFill(Color.TRANSPARENT);
        upgradeScene.getStylesheets().addAll(getClass().getResource("/css/Style.css").toExternalForm(), getClass().getResource("/css/PlayScene.css").toExternalForm());
        upgradeStage.setScene(upgradeScene);
        
        if(property.getLevel() < 5){
            upgradeStage.showAndWait();
        }
    }
    
    //Metoda na aktualizovanie labelov pre najom pozemkov
    public void updateRentLabels(){
        for(TileBase tile : tiles){
            if(tile instanceof TileProperty){
                TileProperty property = (TileProperty) tile;

                rentLabels.forEach((key, label) -> {
                    if(property.getLabel() == key && property.getOwner() != null){
                        String labelColor = "";
                        String ownerColor = property.getOwner().getColor();
                            
                        switch(ownerColor){
                            case "Modra":
                                labelColor = "blue";
                                break;
                                    
                            case "Cervena":
                                labelColor =  "red";
                                break;
                                    
                            case "Zelena":
                                labelColor = "green";
                                break;
                                    
                            case "Fialova":
                                labelColor = "purple";
                                break;
                                    
                            case "Oranzova":
                                labelColor = "orange";
                                break;
                        }
                    
                        label.setText(Integer.toString(property.getRent()) + "€");
                        label.setStyle("-fx-text-fill: " + labelColor + ";");
                    }else if(property.getLabel() == key && property.getOwner() == null){
                        label.setText("");
                    }
                });
            }
        }
        
        lbPl1Money.setText(Integer.toString(player1.getMoney()) + "€"); 
        lbPl2Money.setText(Integer.toString(player2.getMoney()) + "€");
        
        switch(GlobalVars.playerCount){
            case 3:
                lbPl3Money.setText(Integer.toString(player3.getMoney()) + "€");
                break;
                
            case 4:
                lbPl3Money.setText(Integer.toString(player3.getMoney()) + "€");
                lbPl4Money.setText(Integer.toString(player4.getMoney()) + "€");
                break;
                 
        }
    }
    
    //Metoda na zobrazenie upozornenia ohladom hodu kocky
    public void diceAlert(String errorText){
        //Labels
        Label lbError = new Label(errorText);
        lbError.setPrefWidth(GlobalVars.secBtWidth * 1.5);
        lbError.setPrefHeight(GlobalVars.secBtHeight * 2.5);
        lbError.getStyleClass().add("lbError");
        lbError.setAlignment(Pos.CENTER);
        
        //Buttons
        Button btOk = new Button();
        btOk.setFocusTraversable(false);
        btOk.setPrefWidth(GlobalVars.secBtWidth);
        btOk.setPrefHeight(GlobalVars.secBtHeight);
        btOk.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btOk.getStyleClass().add("btOk");
        
        //Vytvorenie stage pre papezMenu
        Stage diceStage = new Stage();
        diceStage.initStyle(StageStyle.TRANSPARENT);
        diceStage.initOwner(primaryStage);
        diceStage.initModality(Modality.APPLICATION_MODAL);
        diceStage.setResizable(false);
        diceStage.setAlwaysOnTop(true);
        
        //Layout diceMenu
        VBox vbDiceMenu = new VBox(20);
        vbDiceMenu.getChildren().addAll(lbError, btOk);
        vbDiceMenu.setAlignment(Pos.CENTER);
        vbDiceMenu.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //funkcia pre btOk
        btOk.setOnAction(e -> {
            diceStage.close();   
        });
        
        String denyFile = "sound/deny.wav";
        Media denySound = new Media(new File(denyFile).toURI().toString());
        MediaPlayer denyPlayer = new MediaPlayer(denySound);   
        denyPlayer.setVolume(GlobalVars.sfx);
        denyPlayer.play();
        
        Scene diceScene = new Scene(vbDiceMenu, GlobalVars.width / 4, GlobalVars.height / 1.3);
        diceScene.getStylesheets().addAll(getClass().getResource("css/PlayScene.css").toExternalForm(), getClass().getResource("css/Style.css").toExternalForm());
        diceScene.setFill(Color.TRANSPARENT);
        diceStage.setScene(diceScene);
        
        diceStage.showAndWait();
    }
    
    //Metoda pre okno pre policko papeza
    public void papez(Player player){
        //Labels
        Label lbPapez = new Label();
        lbPapez.setPrefWidth(GlobalVars.secBtWidth);
        lbPapez.setPrefHeight(GlobalVars.secBtHeight * 2);
        lbPapez.getStyleClass().add("lbPapez");
        lbPapez.setAlignment(Pos.CENTER);
        
        Label lbError = new Label("Nemáš žiadne pozemky.");
        lbError.setPrefWidth(GlobalVars.secBtWidth);
        lbError.setPrefHeight(GlobalVars.secBtHeight * 2);
        lbError.getStyleClass().add("lbError");
        lbError.setAlignment(Pos.CENTER);
        
        //Buttons
        Button btOk = new Button();
        btOk.setFocusTraversable(false);
        btOk.setPrefWidth(GlobalVars.secBtWidth);
        btOk.setPrefHeight(GlobalVars.secBtHeight);
        btOk.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btOk.getStyleClass().add("btOk");
        
        //ComboBox
        ObservableList<String> olPropertyLabels = FXCollections.observableArrayList();
        
        for(TileProperty property : player.getProperties()){
            if(!property.getShop()){
                olPropertyLabels.add(property.getLabel());   
            }
        }
        
        ComboBox cbProperties = new ComboBox(olPropertyLabels);
        cbProperties.setPrefWidth(GlobalVars.secBtWidth);
        cbProperties.setPrefHeight(GlobalVars.secBtHeight);
        cbProperties.getSelectionModel().selectFirst();
        cbProperties.setFocusTraversable(false);
        cbProperties.setPadding(GlobalVars.cbInsetPadding);
        cbProperties.getStyleClass().add("cbProperties");
        
        //Obrazok papez
        InputStream papezIS = getClass().getResourceAsStream("/img/alerts/alertPapez.png");
        Image papezImg = new Image(papezIS);
        ImageView papezIW = new ImageView();
        papezIW.setImage(papezImg);
        
        VBox.setMargin(btOk, GlobalVars.secBtInset);
        VBox.setMargin(lbPapez, GlobalVars.secBtInset);
        
        //Zvuk
        String papezFile = new File("sound/papez.mp3").toURI().toString();
        Media papezSound = new Media(papezFile);
        MediaPlayer papezPlayer = new MediaPlayer(papezSound);
        papezPlayer.setAudioSpectrumNumBands(0);
        papezPlayer.setVolume(GlobalVars.sfx);   
        papezPlayer.play();
        
        //Vytvorenie stage pre papezMenu
        Stage papezStage = new Stage();
        papezStage.initStyle(StageStyle.TRANSPARENT);
        papezStage.initOwner(primaryStage);
        papezStage.initModality(Modality.APPLICATION_MODAL);
        papezStage.setResizable(false);
        papezStage.setAlwaysOnTop(true);
        
        //Layout papezMenu
        VBox vbPapezMenu = new VBox(20);
        vbPapezMenu.getChildren().addAll(lbPapez, papezIW);
        vbPapezMenu.setAlignment(Pos.CENTER);
        vbPapezMenu.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        if(player.getProperties().size() > 0){
            vbPapezMenu.getChildren().add(cbProperties);
        }else{
            vbPapezMenu.getChildren().add(lbError);
        }
        
        vbPapezMenu.getChildren().add(btOk);
        
        //funkcia pre btOk
        btOk.setOnAction(e -> {
            for(TileProperty property : player.getProperties()){
                //Odstrani navstevu papeza zo stareho policka
                if(property.getPapez()){
                    property.setRent((int) (property.getRent() / 1.5));
                    property.setPapez(false);
                }
                
                //Da navstevu papeza na nove policko
                if(property.getLabel().equals(cbProperties.getValue())){
                    TileFunction.papezTile(property);
                }
            }
        
            updateRentLabels();
        
            papezStage.close();   
        });
        
        Scene papezScene = new Scene(vbPapezMenu, GlobalVars.width / 4, GlobalVars.height / 1.3);
        papezScene.getStylesheets().addAll(getClass().getResource("css/PlayScene.css").toExternalForm(), getClass().getResource("css/Style.css").toExternalForm());
        papezScene.setFill(Color.TRANSPARENT);
        papezStage.setScene(papezScene);
        
        papezStage.showAndWait();
    }

    //Metoda na okienko pre policko poklad
    public void poklad(int money){
        //Buttons
        Button btOk = new Button();
        btOk.setAlignment(Pos.CENTER);
        btOk.getStyleClass().add("btOk");
        btOk.setPrefWidth(GlobalVars.secBtWidth);
        btOk.setPrefHeight(GlobalVars.secBtHeight);
        btOk.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btOk.setFocusTraversable(false);
        
        //Labels
        Label lbPoklad = new Label();
        lbPoklad.setAlignment(Pos.CENTER);
        lbPoklad.getStyleClass().add("lbPoklad");
        lbPoklad.setPrefWidth(GlobalVars.secBtWidth);
        lbPoklad.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        Label lbMoney = new Label();
        lbMoney.setAlignment(Pos.CENTER);
        lbMoney.getStyleClass().add("lbMoney");
        lbMoney.setPrefWidth(GlobalVars.secBtWidth);
        lbMoney.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        //Obrazok poklad
        InputStream pokladIS = getClass().getResourceAsStream("/img/alerts/alertPoklad.png");
        Image pokladImg = new Image(pokladIS);
        ImageView pokladIW = new ImageView();
        pokladIW.setImage(pokladImg);
        pokladIW.setScaleX(2);
        pokladIW.setScaleY(2);
        
        VBox.setMargin(btOk, GlobalVars.secBtInset);
        VBox.setMargin(lbPoklad, GlobalVars.secBtInset);
        
        //Zvuk
        String pokladFile = new File("sound/treasure.mp3").toURI().toString();
        Media pokladSound = new Media(pokladFile);
        MediaPlayer pokladPlayer = new MediaPlayer(pokladSound);
        pokladPlayer.setAudioSpectrumNumBands(0);
        pokladPlayer.setVolume(GlobalVars.sfx);   
        pokladPlayer.play();
        
        //Vytvorenie stage pre pokladMenu
        Stage pokladStage = new Stage();
        pokladStage.initStyle(StageStyle.TRANSPARENT);
        pokladStage.initOwner(primaryStage);
        pokladStage.initModality(Modality.APPLICATION_MODAL);
        pokladStage.setResizable(false);
        pokladStage.setAlwaysOnTop(true);
        
        //vbPoklad - VBox pre poklad
        VBox vbPoklad = new VBox();
        vbPoklad.getChildren().addAll(lbPoklad, pokladIW, lbMoney, btOk);
        vbPoklad.setAlignment(Pos.CENTER);
        vbPoklad.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        if(money > 0){
            lbMoney.setText("Získal si\n" + money + "€!");
        }else {                                                           
            lbMoney.setText("Nezískal si nič.");
        }
        
        //Funckia pre tlacitko btOk
        btOk.setOnAction(event -> {
            pokladStage.close();    
        });
        
        Scene pokladScene = new Scene(vbPoklad, GlobalVars.width / 4, GlobalVars.height / 1.3);
        pokladScene.getStylesheets().addAll(getClass().getResource("css/PlayScene.css").toExternalForm(), getClass().getResource("css/Style.css").toExternalForm());
        pokladScene.setFill(Color.TRANSPARENT);
        pokladStage.setScene(pokladScene);
        
        pokladStage.showAndWait();
    }
    
    //Metoda na okienko pre policko mestsky park
    public void mestskyPark(){
        //Buttons
        Button btOk = new Button();
        btOk.setAlignment(Pos.CENTER);
        btOk.getStyleClass().add("btOk");
        btOk.setPrefWidth(GlobalVars.secBtWidth);
        btOk.setPrefHeight(GlobalVars.secBtHeight);
        btOk.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btOk.setFocusTraversable(false);
        
        //Labels
        Label lbPark = new Label();
        lbPark.setAlignment(Pos.CENTER);
        lbPark.getStyleClass().add("lbPark");
        lbPark.setPrefWidth(GlobalVars.secBtWidth);
        lbPark.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        Label lbOddych = new Label("Nič sa nedeje,\noddýchni si.");
        lbOddych.setAlignment(Pos.CENTER);
        lbOddych.getStyleClass().add("lbOddych");
        lbOddych.setPrefWidth(GlobalVars.secBtWidth);
        lbOddych.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        //Obrazok park
        InputStream parkIS = getClass().getResourceAsStream("/img/alerts/alertPark.png");
        Image parkImg = new Image(parkIS);
        ImageView parkIW = new ImageView();
        parkIW.setImage(parkImg);
        parkIW.setScaleX(2);
        parkIW.setScaleY(2);
        
        VBox.setMargin(btOk, GlobalVars.secBtInset);
        VBox.setMargin(lbPark, GlobalVars.secBtInset);
        
        //Zvuk
        String parkFile = new File("./sound/park.mp3").toURI().toString();
        Media parkSound = new Media(parkFile);
        MediaPlayer parkPlayer = new MediaPlayer(parkSound);
        parkPlayer.setAudioSpectrumNumBands(0);
        parkPlayer.setVolume(GlobalVars.sfx);   
        parkPlayer.play();
        
        //Vytvorenie stage pre parkMenu
        Stage parkStage = new Stage();
        parkStage.initStyle(StageStyle.TRANSPARENT);
        parkStage.initOwner(primaryStage);
        parkStage.initModality(Modality.APPLICATION_MODAL);
        parkStage.setResizable(false);
        parkStage.setAlwaysOnTop(true);
        
        //vbPoklad - VBox pre mestsky park
        VBox vbPark = new VBox();
        vbPark.getChildren().addAll(lbPark, parkIW, lbOddych, btOk);
        vbPark.setAlignment(Pos.CENTER);
        vbPark.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //Funckia pre tlacitko btOk
        btOk.setOnAction(event -> {
            parkStage.close();    
        });
        
        Scene parkScene = new Scene(vbPark, GlobalVars.width / 4, GlobalVars.height / 1.3);
        parkScene.getStylesheets().addAll(getClass().getResource("css/PlayScene.css").toExternalForm(), getClass().getResource("css/Style.css").toExternalForm());
        parkScene.setFill(Color.TRANSPARENT);
        parkStage.setScene(parkScene);
        
        parkStage.showAndWait();
    }
    
    //Metoda na okienko pre policko vazenie
    public void vazenie(){
        //Buttons
        Button btOk = new Button();
        btOk.setAlignment(Pos.CENTER);
        btOk.getStyleClass().add("btOk");
        btOk.setPrefWidth(GlobalVars.secBtWidth);
        btOk.setPrefHeight(GlobalVars.secBtHeight);
        btOk.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btOk.setFocusTraversable(false);
        
        //Labels
        Label lbVazenie = new Label();
        lbVazenie.setAlignment(Pos.CENTER);
        lbVazenie.getStyleClass().add("lbLunik");
        lbVazenie.setPrefWidth(GlobalVars.secBtWidth);
        lbVazenie.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        Label lbStoj = new Label("Stojíš 1 kolo.");
        lbStoj.setAlignment(Pos.CENTER);
        lbStoj.getStyleClass().add("lbVazenie");
        lbStoj.setPrefWidth(GlobalVars.secBtWidth);
        lbStoj.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        //Obrazok vazenie
        InputStream vazenieIS = getClass().getResourceAsStream("/img/alerts/alertLunik.png");
        Image vazenieImg = new Image(vazenieIS);
        ImageView vazenieIW = new ImageView();
        vazenieIW.setImage(vazenieImg);
        vazenieIW.setScaleX(2);
        vazenieIW.setScaleY(2);
        
        VBox.setMargin(btOk, GlobalVars.secBtInset);
        VBox.setMargin(lbVazenie, GlobalVars.secBtInset);
        
        //Zvuk
        String lunikFile = new File("sound/lunik9.mp3").toURI().toString();
        Media lunikSound = new Media(lunikFile);
        MediaPlayer lunikPlayer = new MediaPlayer(lunikSound);
        lunikPlayer.setAudioSpectrumNumBands(0);
        lunikPlayer.setVolume(GlobalVars.sfx);   
        lunikPlayer.play();
        
        //Vytvorenie stage pre vazenieMenu
        Stage vazenieStage = new Stage();
        vazenieStage.initStyle(StageStyle.TRANSPARENT);
        vazenieStage.initOwner(primaryStage);
        vazenieStage.initModality(Modality.APPLICATION_MODAL);
        vazenieStage.setResizable(false);
        vazenieStage.setAlwaysOnTop(true);
        
        //vbPoklad - VBox pre vazenie
        VBox vbVazenie = new VBox();
        vbVazenie.getChildren().addAll(lbVazenie, vazenieIW, lbStoj, btOk);
        vbVazenie.setAlignment(Pos.CENTER);
        vbVazenie.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //Funckia pre tlacitko btOk
        btOk.setOnAction(event -> {
            vazenieStage.close();    
        });
        
        Scene vazenieScene = new Scene(vbVazenie, GlobalVars.width / 4, GlobalVars.height / 1.3);
        vazenieScene.getStylesheets().addAll(getClass().getResource("css/PlayScene.css").toExternalForm(), getClass().getResource("css/Style.css").toExternalForm());
        vazenieScene.setFill(Color.TRANSPARENT);
        vazenieStage.setScene(vazenieScene);
        
        vazenieStage.showAndWait();
    }
    
    //Metoda na okienko pre policka poplatkov
    public void poplatky(int id){
        //Buttons
        Button btOk = new Button();
        btOk.setAlignment(Pos.CENTER);
        btOk.getStyleClass().add("btOk");
        btOk.setPrefWidth(GlobalVars.secBtWidth);
        btOk.setPrefHeight(GlobalVars.secBtHeight);
        btOk.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btOk.setFocusTraversable(false);
        
        //Labels
        Label lbPoplatok = new Label();
        lbPoplatok.setAlignment(Pos.CENTER);
        lbPoplatok.getStyleClass().add("lbPoplatok");
        lbPoplatok.setPrefWidth(GlobalVars.secBtWidth);
        lbPoplatok.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        Label lbMoney = new Label();
        lbMoney.setAlignment(Pos.CENTER);
        lbMoney.getStyleClass().add("lbMoney");
        lbMoney.setPrefWidth(GlobalVars.secBtWidth);
        lbMoney.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        //Zvuk
        String poplatokFile = "";
        
        //Obrazok poplatok
        InputStream poplatokIS = getClass().getResourceAsStream("");
        
        switch(id){
            case 37:
                lbPoplatok.setStyle("-fx-background-image: url(/img/labels/lbVoda.png);");
                poplatokIS = getClass().getResourceAsStream("/img/alerts/alertVoda.png");
                poplatokFile = new File("./sound/water.mp3").toURI().toString(); 
                lbMoney.setText("200 000€");
                break;
            case 38:
                lbPoplatok.setStyle("-fx-background-image: url(/img/labels/lbElektrina.png);");
                poplatokIS = getClass().getResourceAsStream("/img/alerts/alertElektrina.png");
                poplatokFile = new File("./sound/electric.wav").toURI().toString();
                lbMoney.setText("150 000€");
                break;
            case 39:
                lbPoplatok.setStyle("-fx-background-image: url(/img/labels/lbInternet.png);");
                poplatokIS = getClass().getResourceAsStream("/img/alerts/alertInternet.png");
                poplatokFile = new File("./sound/internet.mp3").toURI().toString();
                lbMoney.setText("150 000€");
                break;
            case 40:
                lbPoplatok.setStyle("-fx-background-image: url(/img/labels/lbParkovanie.png);");
                poplatokIS = getClass().getResourceAsStream("/img/alerts/alertParkovanie.png");
                poplatokFile = new File("./sound/parking.mp3").toURI().toString();
                lbMoney.setText("100 000€");
                break;
        }
        
        Image poplatokImg = new Image(poplatokIS);
        ImageView poplatokIW = new ImageView();
        poplatokIW.setImage(poplatokImg);
        poplatokIW.setScaleX(2);
        poplatokIW.setScaleY(2);
        
        VBox.setMargin(btOk, GlobalVars.secBtInset);
        VBox.setMargin(lbPoplatok, GlobalVars.secBtInset);
        
        //Zvuk
        Media poplatokSound = new Media(poplatokFile);
        MediaPlayer poplatokPlayer = new MediaPlayer(poplatokSound);
        poplatokPlayer.setAudioSpectrumNumBands(0);
        poplatokPlayer.setVolume(GlobalVars.sfx);   
        poplatokPlayer.play();
        
        //Vytvorenie stage pre poplatokMenu
        Stage poplatkyStage = new Stage();
        poplatkyStage.initStyle(StageStyle.TRANSPARENT);
        poplatkyStage.initOwner(primaryStage);
        poplatkyStage.initModality(Modality.APPLICATION_MODAL);
        poplatkyStage.setResizable(false);
        poplatkyStage.setAlwaysOnTop(true);
        
        //vbPoklad - VBox pre poplatky
        VBox vbPoplatky = new VBox();
        vbPoplatky.getChildren().addAll(lbPoplatok, poplatokIW, lbMoney, btOk);
        vbPoplatky.setAlignment(Pos.CENTER);
        vbPoplatky.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //Funckia pre tlacitko btOk
        btOk.setOnAction(event -> {
            poplatkyStage.close();    
        });
        
        Scene poplatkyScene = new Scene(vbPoplatky, GlobalVars.width / 4, GlobalVars.height / 1.3);
        poplatkyScene.getStylesheets().addAll(getClass().getResource("css/PlayScene.css").toExternalForm(), getClass().getResource("css/Style.css").toExternalForm());
        poplatkyScene.setFill(Color.TRANSPARENT);
        poplatkyStage.setScene(poplatkyScene);
        
        poplatkyStage.showAndWait();
    }
    
    //Zvysovanie a znizovanie ceny obchodov podla poctu
    public void shopPrice(){
        for(Player player : players){
            ArrayList<TileProperty> shops = new ArrayList<TileProperty>();
        
            int originalRent = 50000;
            
            for(TileProperty property : player.getProperties()){
                if(property.getShop()){
                    shops.add(property);
                }
            }
            
            for(TileProperty shop : shops){
                if(shops.size() == 2){
                    shop.setRent( (int) (originalRent * 1.5));
                }
                
                if(shops.size() == 3){
                    shop.setRent(originalRent * 2);
                }
                
                if(shops.size() == 4){
                    shop.setRent( (int) (originalRent * 2.5));
                }
            }
        }
    }
    
    //Vyhra okienko
    public void winWindow(Player player){
        //Buttons
        Button btMenu = new Button();
        btMenu.setAlignment(Pos.CENTER);
        btMenu.getStyleClass().add("btMenu");
        btMenu.setPrefWidth(GlobalVars.secBtWidth);
        btMenu.setPrefHeight(GlobalVars.secBtHeight);
        btMenu.setStyle("-fx-background-size: " + GlobalVars.secBtWidth / 1.5 + " " + "auto;");
        btMenu.setFocusTraversable(false);
        
        //Labels
        Label lbWin = new Label("Výhra!");
        lbWin.setAlignment(Pos.CENTER);
        lbWin.getStyleClass().add("lbWin");
        lbWin.setPrefWidth(GlobalVars.secBtWidth);
        lbWin.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        Label lbPlayer = new Label(player.getNickname());
        lbPlayer.setAlignment(Pos.CENTER);
        lbPlayer.getStyleClass().add("lbPlayer");
        lbPlayer.setPrefWidth(GlobalVars.secBtWidth);
        lbPlayer.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        Label lbMoney = new Label("Zarobil si: ");
        lbMoney.setAlignment(Pos.CENTER);
        lbMoney.setPrefWidth(GlobalVars.secBtWidth);
        lbMoney.setPrefHeight(GlobalVars.secBtHeight);
        lbMoney.getStyleClass().add("lbWins");
        
        Label lbMoneyNum = new Label(player.getMoney() + "€");
        lbMoneyNum.setAlignment(Pos.CENTER);
        lbMoneyNum.getStyleClass().add("lbMoney");
        lbMoneyNum.setPrefWidth(GlobalVars.secBtWidth);
        lbMoneyNum.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        Label lbProperties = new Label("Toľko pozemkov si nazbieral: ");
        lbProperties.setAlignment(Pos.CENTER);
        lbProperties.setPrefWidth(GlobalVars.secBtWidth);
        lbProperties.setPrefHeight(GlobalVars.secBtHeight);
        lbProperties.getStyleClass().add("lbWins");
        
        Label lbPropertiesNum = new Label(Integer.toString(player.getProperties().size()));
        lbPropertiesNum.setAlignment(Pos.CENTER);
        lbPropertiesNum.getStyleClass().add("lbProperties");
        lbPropertiesNum.setPrefWidth(GlobalVars.secBtWidth);
        lbPropertiesNum.setPrefHeight(GlobalVars.secBtWidth * 2);
        
        //Obrazok vyhra
        InputStream winIS = getClass().getResourceAsStream("/img/alerts/trophy.png");
        Image winImg = new Image(winIS);
        ImageView winIW = new ImageView();
        winIW.setImage(winImg);
        winIW.setScaleX(2);
        winIW.setScaleY(2);
        
        VBox.setMargin(btMenu, GlobalVars.secBtInset);
        VBox.setMargin(lbWin, GlobalVars.secBtInset);
        
        //Vytvorenie stage pre vyhraMenu
        Stage winStage = new Stage();
        winStage.initStyle(StageStyle.TRANSPARENT);
        winStage.initOwner(primaryStage);
        winStage.initModality(Modality.APPLICATION_MODAL);
        winStage.setResizable(false);
        winStage.setAlwaysOnTop(true);
        
        //vbPoklad - VBox pre vyhru
        VBox vbWin = new VBox();
        vbWin.getChildren().addAll(lbWin, lbPlayer, lbMoney, lbMoneyNum, lbProperties, lbPropertiesNum, winIW, btMenu);
        vbWin.setAlignment(Pos.CENTER);
        vbWin.setStyle("-fx-background-color: rgba(230, 184, 127, 0.8); -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-border-color: black; -fx-border-width: 10px;");
        
        //Funckia pre tlacitko btMenu
        btMenu.setOnAction(event -> {
            winStage.close();
            primaryStage.setScene(titleMenuScene);
            primaryStage.setFullScreen(true);    
        });
        
        Scene winScene = new Scene(vbWin, GlobalVars.width / 4, GlobalVars.height / 1.3);
        winScene.getStylesheets().addAll(getClass().getResource("css/PlayScene.css").toExternalForm(), getClass().getResource("css/Style.css").toExternalForm());
        winScene.setFill(Color.TRANSPARENT);
        winStage.setScene(winScene);
        
        winStage.showAndWait();
    }
    
    public void winLogic(Player winner){
        for(Player player : players){
            player.getTimer().cancel();
        }
        
        String winFile = new File("sound/win.mp3").toURI().toString();
        Media winSound = new Media(winFile);
        MediaPlayer winPlayer = new MediaPlayer(winSound);
        winPlayer.setAudioSpectrumNumBands(0);
        winPlayer.setVolume(GlobalVars.sfx);   
        winPlayer.play();
        
        winWindow(winner);
    }
    
    public void finishLogic(Player player){
        //pomocne premenne na kontrolovanie vyherneho stavu hraca
        ArrayList<TileProperty> properties = player.getProperties();
        //obchody
        int shops = 0;
        
        //skupiny pozemkov
        int furca = 0;
        int kvp = 0;
        int myslava = 0;
        int barca = 0;
        int krasna = 0;
        int centrum = 0;
        int terasa = 0;
        int jazero = 0;
        
        //monopoly
        int monopoly = 0;
        
        //riadky/stlpce
        int dole = 0;
        int lavo = 0;
        int hore = 0;
        int pravo = 0;
        
        //Majetky hracov
        int pl1Money = 0;
        int pl2Money = 0;
        int pl3Money = 0;
        int pl4Money = 0;
        
        int money[] = new int[GlobalVars.playerCount];
        
        //Pocitanie monopolov/obchodnych centier/riadkov/stlpcov hraca
        for(TileProperty property : properties){
            //skupiny - monopoly
            String group = property.getGroup();
            
            switch(group){
                case "furca":
                    furca++;
                    break;
                case "kvp":
                    kvp++;
                    break;
                case "myslava":
                    myslava++;
                    break;
                case "barca":
                    barca++;
                    break;
                case "krasna":
                    krasna++;
                    break;
                case "centrum":
                    centrum++;
                    break;
                case "terasa":
                    terasa++;
                    break;
                case "jazero":
                    jazero++;
                    break;
            }
            
            //obchody
            if(property.getShop()){
                shops++;
            }
            
            //dolny riadok
            if(property.getY() == 0){
                dole++;
            }
            
            //lavy stlpcek
            if(property.getX() == 10){
                lavo++;
            }
            
            //horny riadok
            if(property.getY() == 10){
                hore++;
            }
            
            //pravy stlpcek
            if(property.getX() == 0){
                pravo++;
            }
        }
        
        if(furca == 2){
            monopoly++;
        }
        
        if(kvp == 3){
            monopoly++;
        }
        
        if(myslava == 3){
            monopoly++;
        }
        
        if(barca == 3){
            monopoly++;
        }
        
        if(krasna == 3){
            monopoly++;
        }
        
        if(centrum == 3){
            monopoly++;
        }
        
        if(terasa == 3){
            monopoly++;
        }
        
        if(jazero == 2){
            monopoly++;
        }
        
        System.out.println("Monopoly: " + monopoly);
        
        //Konrola poctu monopoly
        if(monopoly >= 3){
            winLogic(player);
        }
    
        //Kontrola ci hrac nedosiahol peniaze potrebne na vyhru
        if(player.getMoney() >= GlobalVars.targetCash){
            winLogic(player);
        }
        
        //Kontrola poctu obchodnych centier vlastnenych hracom
        if(shops == 4){
            winLogic(player);
        }
        
        //Kontrola ci hrac vlastni cely riadok/stlpec
        if(dole == 6){
            winLogic(player);
        }
        
        if(pravo == 7){
            winLogic(player);
        }
        
        if(hore == 7){
            winLogic(player);
        }
        
        if(pravo == 6){
            winLogic(player);
        }
        
        //Ak zostane iba jeden hrac(dojde cas/ bankrot)
        if(players.size() == 1){
            //player1
            pl1Money += player1.getMoney();
            
            for(TileProperty property : player1.getProperties()){
                pl1Money += property.getPrice();
            }
            
            //player2
            pl2Money += player2.getMoney();
            
            for(TileProperty property : player2.getProperties()){
                pl2Money += property.getPrice();
            }
            money[0] = pl1Money;
            money[1] = pl2Money;
            
            if(GlobalVars.playerCount >= 3){
                //player3
                pl3Money += player3.getMoney();
            
                for(TileProperty property : player3.getProperties()){
                    pl3Money += property.getPrice();
                }
                money[2] = pl3Money;
            }
            
            if(GlobalVars.playerCount == 4){
                //player4
                pl4Money += player4.getMoney();
            
                for(TileProperty property : player4.getProperties()){
                    pl4Money += property.getPrice();
                }
                money[3] = pl4Money;
            }
            
            int max = money[0];
            
            for(int i = 1; i < GlobalVars.playerCount; i++){
                if(money[i] > max){
                    max = money[i];
                }
            }
            
            if(max == pl1Money){
                winLogic(player1);
            }
            if(max == pl2Money){
                winLogic(player2);
            }
            if(max == pl3Money){
                winLogic(player3);
            }
            if(max == pl4Money){
                winLogic(player4);
            }
        }
    }
    
    public void timeRanOut(Player player){
        players.remove(player);
    }
    
    public void checkTile(Player player, int tileIndex){
        //Kontrola druhu policka, na ktorom hrac skoncil
        if(tiles.get(tileIndex) instanceof TileProperty){
            //Hrac skoncil na policku pozemku
            TileProperty tile = (TileProperty) tiles.get(tileIndex);
            if(tile.getOwner() == null){
                //Pozemok nema majitela
                showBuyMenu(player, tile);
            }else if(tile.getOwner() != player){
                //Pozemok ma majitela ale hrac na tahu neni majitelom
                showPayMenu(player, tile);
            }else if(!tile.getShop()){
                //Pozemok ma majitel, hrac na tahu je majitelom a policko nieje obchodne centrum
                showUpgradeMenu(player, tile);
            }
        }else if(tiles.get(tileIndex) instanceof TileChance){
            //Policko je sanca
            TileChance tile = (TileChance) tiles.get(tileIndex);
            String chance = TileFunction.chance(player, players);
            
            chanceIS = getClass().getResourceAsStream("/img/events/event" + Character.toUpperCase(chance.charAt(0)) + chance.substring(1) + ".png");
            Image newChanceImg = new Image(chanceIS);
            chanceIW.setImage(newChanceImg);
            System.out.println("/img/events/event" + Character.toUpperCase(chance.charAt(0)) + chance.substring(1) + ".png");
        }else if(tiles.get(tileIndex) instanceof TileBase){
            //Policko je bud rohove, poklad alebo dan
            int id = tiles.get(tileIndex).getId();
            switch(id){ 
                case 32:
                    TileFunction.prisonFunction(player);
                    vazenie();
                    break;
                    
                case 33:
                    TileFunction.mestskyPark();
                    mestskyPark();
                    break;
                    
                case 34:
                    papez(player);
                    break;
                    
                case 35:
                case 36:
                    poklad(TileFunction.poklad(player));
                    break;
                    
                case 37:
                    TileFunction.voda(player);
                    poplatky(id);
                    break;
                    
                case 38:
                    TileFunction.elektrina(player);
                    poplatky(id);
                    break;
                    
                case 39:
                    TileFunction.internet(player);
                    poplatky(id);
                    break;
                    
                case 40:
                    TileFunction.parkovanie(player);
                    poplatky(id);
                    break;                              
            }
        }
    }
    
    public void move(){
        System.out.println("Doslo tu");
        
        int throw1 = Kocka.hodKockou();
        int throw2 = Kocka.hodKockou();
            
        System.out.println("\nprva kocka:" + throw1 + " druha kocka: " + throw2);
    
        int sucet = throw1 + throw2;
    
        Player player = players.get(onTurn);
        ImageView playerFigIW = new ImageView();
        
        finishLogic(player);
        
        dice1IS = getClass().getResourceAsStream("/img/dice/d" + players.get(onTurn).getColor() + "_" + throw1 + ".png");
        Image dice1newImg = new Image(dice1IS);
        dice1IW.setImage(dice1newImg);
        
        dice2IS = getClass().getResourceAsStream("/img/dice/d" + players.get(onTurn).getColor() + "_" + throw2 + ".png");
        Image dice2newImg = new Image(dice2IS);
        dice2IW.setImage(dice2newImg);
    
        switch(onTurn){
            case 0:
                playerFigIW = pl1FigIW;
                break;
    
            case 1:
                playerFigIW = pl2FigIW;
                break;
    
            case 2:
                playerFigIW = pl3FigIW;
                break;
    
            case 3:
                playerFigIW = pl4FigIW;
                break;                
        }
        
        SequentialTransition sequence = new SequentialTransition();
        
        String moveFile = new File("./sound/figMove.mp3").toURI().toString();
        Media moveSound = new Media(moveFile);
    
        int playerStartX = player.getX();
        int playerStartY = player.getY();   
    
        int tileIndex = 0;
        while(tileIndex < tiles.size() && (tiles.get(tileIndex).getX() != player.getX()  || tiles.get(tileIndex).getY() != player.getY())){
            tileIndex++;
        }
    
        if(tileIndex < tiles.size()){  
            for(int i = 0; i < sucet; i++){
                //pohyb hraca a figurky hore
                if(player.getX() == 10 && tiles.get(tileIndex).getVertical()){
                    TranslateTransition step = new TranslateTransition(Duration.seconds(0.25), playerFigIW);
                
                    if(player.getY() == 0){
                        //playerFigIW.setLayoutY(playerFigIW.getLayoutY() - GlobalVars.height / 7.8);
                        step.setByY(-GlobalVars.height / 7.8);
                        
                    }else if(player.getY() == 9){
                        //playerFigIW.setLayoutX(GlobalVars.width / 25);
                        step.setToX(GlobalVars.width / 25 - playerFigIW.getLayoutX());
                    
                        double delta = GlobalVars.height / 40;
                    
                        double pl1Y = GlobalVars.height / 22;
                        double pl2Y = pl1Y + delta;
                        double pl3Y = pl2Y + delta;
                        double pl4Y = pl3Y + delta;
                    
                        switch(onTurn){
                            case 0:
                                //playerFigIW.setLayoutY(pl1Y);
                                step.setToY(pl1Y - playerFigIW.getLayoutY());
                                break;    
                            case 1:
                                //playerFigIW.setLayoutY(pl2Y);
                                step.setToY(pl2Y - playerFigIW.getLayoutY());
                                break;
                            case 2:
                                //playerFigIW.setLayoutY(pl3Y);
                                step.setToY(pl3Y - playerFigIW.getLayoutY());
                                break;
                            case 3:
                                //playerFigIW.setLayoutY(pl4Y);
                                step.setToY(pl4Y - playerFigIW.getLayoutY());
                                break;
                        }
                    }else{
                        //playerFigIW.setLayoutY(playerFigIW.getLayoutY() - GlobalVars.height / 13.3);
                        step.setByY(-GlobalVars.height / 13.3);    
                    }
                    
                    step.statusProperty().addListener((obs, oldStatus, newStatus) -> {
                        if (newStatus == Status.RUNNING && oldStatus != Status.RUNNING) {
                            MediaPlayer stepPlayer = new MediaPlayer(moveSound);
                            stepPlayer.setVolume(GlobalVars.sfx);
                            stepPlayer.play();
                        }
                    });
                    
                    sequence.getChildren().addAll( step);
                    player.setY(player.getY() + 1);
                }
            
                //pohyb hraca a figurky dolava
                if(!tiles.get(tileIndex).getVertical() && player.getY() == 0){
                    TranslateTransition step = new TranslateTransition(Duration.seconds(0.25), playerFigIW);
                    
                    if(player.getX() == 0){
                        //playerFigIW.setLayoutX(playerFigIW.getLayoutX() - GlobalVars.width / 15.7);
                        step.setByX(-GlobalVars.width / 15.7);
                    }else if(player.getX() == 9){
                        //playerFigIW.setLayoutY(981.8181818181818);
                        step.setToY(GlobalVars.height / 1.1 - playerFigIW.getLayoutY());
                        double pl1X = GlobalVars.width / 130;
                        double pl2X = pl1X + GlobalVars.width / 64;
                        double pl3X = pl2X + GlobalVars.width / 64;
                        double pl4X = pl3X + GlobalVars.width / 64;
    
                        switch(onTurn){
                            case 0:
                                //playerFigIW.setLayoutX(pl1X);
                                step.setToX(pl1X - playerFigIW.getLayoutX());
                                break;
    
                            case 1:
                                //playerFigIW.setLayoutX(pl2X);
                                step.setToX(pl2X - playerFigIW.getLayoutX());
                                break;
    
                            case 2:
                                //playerFigIW.setLayoutX(pl3X);
                                step.setToX(pl3X - playerFigIW.getLayoutX());
                                break;
    
                            case 3:
                                //playerFigIW.setLayoutX(pl4X);
                                step.setToX(pl4X - playerFigIW.getLayoutX());
                                break;
    
                        }   
                    }else{
                        //playerFigIW.setLayoutX(playerFigIW.getLayoutX() - GlobalVars.width / 24.5);
                        step.setByX(-GlobalVars.width / 24.5);
                    }
                    
                    step.statusProperty().addListener((obs, oldStatus, newStatus) -> {
                        if (newStatus == Status.RUNNING && oldStatus != Status.RUNNING) {
                            MediaPlayer stepPlayer = new MediaPlayer(moveSound);
                            stepPlayer.setVolume(GlobalVars.sfx);
                            stepPlayer.play();
                        }
                    });
                    
                    sequence.getChildren().addAll( step);
                    player.setX(player.getX() + 1);    
                }
            
                //pohyb hraca a figurky dole
                if(player.getX() == 0 && tiles.get(tileIndex).getVertical()){
                    TranslateTransition step = new TranslateTransition(Duration.seconds(0.25), playerFigIW);
                
                    if(player.getY() == 10){
                        //playerFigIW.setLayoutY(playerFigIW.getLayoutY() + GlobalVars.height / 7.8);
                        step.setByY(GlobalVars.height / 7.8);
                        
                    }else if(player.getY() == 1){
                        //playerFigIW.setLayoutX(GlobalVars.width / 2.03);
                        step.setToX(GlobalVars.width / 2.03 - playerFigIW.getLayoutX());
                        
                        switch(onTurn){
                            case 0:
                                //playerFigIW.setLayoutY(GlobalVars.height / 1.06);
                                step.setToY(GlobalVars.height / 1.06 - playerFigIW.getLayoutY());
                                break;
    
                            case 1:
                                //playerFigIW.setLayoutY(GlobalVars.height / 1.09);
                                step.setToY(GlobalVars.height / 1.09 - playerFigIW.getLayoutY());
                                break;
    
                            case 2:
                                //playerFigIW.setLayoutY(GlobalVars.height / 1.12);
                                step.setToY(GlobalVars.height / 1.12 - playerFigIW.getLayoutY());
                                break;
    
                            case 3:
                                //playerFigIW.setLayoutY(GlobalVars.height / 1.15);
                                step.setToY(GlobalVars.height / 1.15 - playerFigIW.getLayoutY());
                                break;
    
                        }
                    }else{
                        //playerFigIW.setLayoutY(playerFigIW.getLayoutY() + GlobalVars.height / 13.3);
                        step.setByY(GlobalVars.height / 13.3);    
                    }
                    
                    step.statusProperty().addListener((obs, oldStatus, newStatus) -> {
                        if (newStatus == Status.RUNNING && oldStatus != Status.RUNNING) {
                            MediaPlayer stepPlayer = new MediaPlayer(moveSound);
                            stepPlayer.setVolume(GlobalVars.sfx);
                            stepPlayer.play();
                        }
                    });
                    
                    sequence.getChildren().addAll( step);
                    player.setY(player.getY() - 1);
                }
    
                //pohyb hraca a figurky doprava
                if(player.getY() == 10 && !tiles.get(tileIndex).getVertical()){
                    TranslateTransition step = new TranslateTransition(Duration.seconds(0.25), playerFigIW);
                
                    if(player.getX() == 10){   
                        //playerFigIW.setLayoutX(playerFigIW.getLayoutX() + GlobalVars.width / 15.7);
                        step.setByX(GlobalVars.width / 15.7);    
                    }else if(player.getX() == 1){
                        //playerFigIW.setLayoutX(GlobalVars.width / 2);
                        //step.setToY(GlobalVars.width / 5 - playerFigIW.getLayoutY());
                        
                        double pl1X = GlobalVars.width / 2.15;
                        double pl2X = pl1X + GlobalVars.width / 64;
                        double pl3X = pl2X + GlobalVars.width / 64;
                        double pl4X = pl3X + GlobalVars.width / 64;
                        
                        System.out.println(pl1X);
                        switch(onTurn){
                            case 0:
                                step.setToX(pl1X - playerFigIW.getLayoutX());
                                break;
                            case 1:
                                step.setToX(pl2X - playerFigIW.getLayoutX());
                                break;
                            case 2:
                                step.setToX(pl3X - playerFigIW.getLayoutX());
                                break;
                            case 3:
                                step.setToX(pl4X - playerFigIW.getLayoutX());
                                break;
                        }
    
                    }else{
                        //playerFigIW.setLayoutX(playerFigIW.getLayoutX() + GlobalVars.width / 24.5);
                        step.setByX(GlobalVars.width / 24.5);       
                    }
                    
                    step.statusProperty().addListener((obs, oldStatus, newStatus) -> {
                        if (newStatus == Status.RUNNING && oldStatus != Status.RUNNING) {
                            MediaPlayer stepPlayer = new MediaPlayer(moveSound);
                            stepPlayer.setVolume(GlobalVars.sfx);
                            stepPlayer.play();
                        }
                    });
                    
                    sequence.getChildren().addAll( step);
                    player.setX(player.getX() - 1);    
                }
                tileIndex++;
                if(tileIndex > tiles.size() - 1){
                    tileIndex = 0;
                }
    
                if(player.getY() == 0 && player.getX() == 0){
                    TileFunction.startFunction(player);
                    updateMoney(player);
                }
    
                System.out.println("TileIndex: " + tileIndex);
                System.out.println("Hrac je na policku: " + tiles.get(tileIndex).getLabel() + " Vertical: " + tiles.get(tileIndex).getVertical() + " X: " + player.getX() + " Y: " + player.getY());
            }
            
            final int tileInd = tileIndex;
            
            sequence.setOnFinished(e -> {
                Platform.runLater(() -> {
                    
                    checkTile(player, tileInd);
                    btRoll.setDisable(false);
                    System.out.println("DEBUG: Transition finished, enabling btRoll.");
                });
            });
            if (sequence.getChildren().isEmpty()) {
                System.out.println("ERROR: No animations added! Enabling btRoll manually.");
                btRoll.setDisable(false);
}
            sequence.play();
            
            shopPrice();
            updateRentLabels();
            updateMoney(player);
            finishLogic(player);
        }
    }
    
    public void start(Stage stage){
        //Policka
        //Pozemky
        //Furca
        furca1 = new TileProperty(5000, null, "furca", false, false, 0, 7000, 10000, 1, "Furča 1", 1, 0, false);
        furca2 = new TileProperty(10000, null, "furca", false, false, 0, 7000, 10000, 2, "Furča 2", 3, 0, false);
        
        //KVP
        kvp1 = new TileProperty(15000, null, "kvp", false, false, 0, 15000, 15000, 3, "KVP 1", 6, 0, false);
        kvp2 = new TileProperty(15000, null, "kvp", false, false, 0, 15000, 15000, 4, "KVP 2", 8, 0, false);
        kvp3 = new TileProperty(20000, null, "kvp", false, false, 0, 15000, 15000, 5, "KVP 3", 9, 0, false);
        
        //Myslava
        myslava1 = new TileProperty(35000, null, "myslava", false, false, 0, 20000, 25000, 6, "Myslava 1", 10, 1, true);
        myslava2 = new TileProperty(35000, null, "myslava", false, false, 0, 20000, 25000, 7, "Myslava 2", 10, 2, true);
        myslava3 = new TileProperty(40000, null, "myslava", false, false, 0, 20000, 25000, 8, "Myslava 3", 10, 4, true);
        
        //Barca
        barca1 = new TileProperty(55000, null, "barca", false, false, 0, 25000, 30000, 9,  "Barca 1", 10, 6, true);
        barca2 = new TileProperty(55000, null, "barca", false, false, 0, 25000, 30000, 10, "Barca 2", 10, 8, true);
        barca3 = new TileProperty(60000, null, "barca", false, false, 0, 25000, 30000, 11, "Barca 3", 10, 9, true);
        
        //Krasna
        krasna1 = new TileProperty(80000, null, "krasna", false, false, 0, 35000, 40000, 12, "Krásna 1", 9, 10, false);
        krasna2 = new TileProperty(80000, null, "krasna", false, false, 0, 35000, 40000, 13, "Krásna 2", 7, 10, false);
        krasna3 = new TileProperty(90000, null, "krasna", false, false, 0, 35000, 40000, 14, "Krásna 3", 6, 10, false);
        
        //Centrum
        centrum1 = new TileProperty(115000, null, "centrum", false, false, 0, 40000, 45000, 15, "Centrum 1", 4, 10, false);
        centrum2 = new TileProperty(115000, null, "centrum", false, false, 0, 40000, 45000, 16, "Centrum 2", 3, 10, false);
        centrum3 = new TileProperty(120000, null, "centrum", false, false, 0, 40000, 45000, 17, "Centrum 3", 1, 10, false);
        
        //Terasa
        terasa1 = new TileProperty(145000, null, "terasa", false, false, 0, 50000, 55000, 18, "Terasa 1", 0, 9, true);
        terasa2 = new TileProperty(145000, null, "terasa", false, false, 0, 50000, 55000, 19, "Terasa 2", 0, 8, true);
        terasa3 = new TileProperty(150000, null, "terasa", false, false, 0, 50000, 55000, 20, "Terasa 3", 0, 6, true);
        
        //Nad Jazerom
        nadJazerom1 = new TileProperty(170000, null, "jazero", false, false, 0, 65000, 60000, 21, "Nad Jazerom 1", 0, 3, true);
        nadJazerom2 = new TileProperty(200000, null, "jazero", false, false, 0, 65000, 60000, 22, "Nad Jazerom 2", 0, 1, true);
        
        //Obchodne Centra
        dargov = new TileProperty(100000, null, "obchody", false, true, 0, 50000, 0, 23, "OC Dargov", 5, 0, false);
        cassovia = new TileProperty(100000, null, "obchody", false, true, 0, 50000, 0, 24, "OC Cassovia", 10, 5, true);
        optima = new TileProperty(100000, null, "obchody", false, true, 0, 50000, 0, 25, "OC Optima", 5, 10, false);
        aupark = new TileProperty(100000, null, "obchody", false, true, 0, 50000, 0, 26, "OC Aupark", 0, 5, true);
        
        //Sance
        chance1 = new TileChance(27, "Šanca", 7, 0, 0, false);
        chance2 = new TileChance(28, "Šanca", 10, 7, 0, true);
        chance3 = new TileChance(29, "Šanca", 8, 10, 0, false);
        chance4 = new TileChance(30, "Šanca", 0, 4, 0, true);
        
        //Start
        start = new TileBase(31, "Start", 0, 0, false);
        
        //Vazenie
        prison = new TileBase(32, "Väzenie", 10, 0, true);
        
        //Mestsky park
        mestskyPark = new TileBase(33, "Mestsky Park", 10, 10, false);
        
        //Papez
        papez = new TileBase(34, "Pápež", 0, 10, true);
        
        //Poklady
        poklad1 = new TileBase(35, "Poklad", 2, 0, false);
        poklad2 = new TileBase(36, "Poklad", 0, 7, true);
        
        //Dane
        voda = new TileBase(37, "Voda", 4, 0, false);
        elektrina = new TileBase(38, "Elektrina", 10, 3, true);
        internet = new TileBase(39, "Internet", 2, 10, false);
        parkovanie = new TileBase(40, "Parkovanie", 0, 2, true);
        
        //Pridanie policok do pola pre policka
        tiles.add(start);
        tiles.add(furca1);
        tiles.add(poklad1);
        tiles.add(furca2);
        tiles.add(voda);
        tiles.add(dargov);
        tiles.add(kvp1);
        tiles.add(chance1);
        tiles.add(kvp2);
        tiles.add(kvp3);
        tiles.add(prison);
        tiles.add(myslava1);
        tiles.add(myslava2);
        tiles.add(elektrina);
        tiles.add(myslava3);
        tiles.add(cassovia);
        tiles.add(barca1);
        tiles.add(chance2);
        tiles.add(barca2);
        tiles.add(barca3);
        tiles.add(mestskyPark);
        tiles.add(krasna1);
        tiles.add(chance3);
        tiles.add(krasna2);
        tiles.add(krasna3);
        tiles.add(optima);
        tiles.add(centrum1);
        tiles.add(centrum2);
        tiles.add(internet);
        tiles.add(centrum3);
        tiles.add(papez);
        tiles.add(terasa1);
        tiles.add(terasa2);
        tiles.add(poklad2);
        tiles.add(terasa3);
        tiles.add(aupark);
        tiles.add(chance4);
        tiles.add(nadJazerom1);
        tiles.add(parkovanie);
        tiles.add(nadJazerom2);
        
        //Buttons
        //btEndMove
        btEndMove = new Button();
        btEndMove.setMinWidth(GlobalVars.secBtWidth / 2);
        btEndMove.setMinHeight(GlobalVars.secBtHeight);
        btEndMove.setOnAction(new ButtonPress());
        btEndMove.setFocusTraversable(false);
        btEndMove.getStyleClass().add("btEndMove");
        btEndMove.setStyle("-fx-background-size: " + (GlobalVars.secBtWidth / 2) + " auto;");
        
        //btPause
        btPause = new Button();
        btPause.setMinWidth(GlobalVars.secBtWidth / 2);
        btPause.setMinHeight(GlobalVars.secBtHeight);
        btPause.setOnAction(new ButtonPress());
        btPause.setFocusTraversable(false);
        btPause.getStyleClass().add("btPause");
        btPause.setStyle("-fx-background-size: " + (GlobalVars.secBtWidth / 2) + " auto;");
        
        //btRoll
        btRoll = new Button();
        btRoll.setOnAction(new ButtonPress());
        btRoll.setFocusTraversable(false);
        btRoll.setPrefWidth(GlobalVars.secBtWidth - 60);
        btRoll.setPrefHeight(GlobalVars.secBtHeight + 10);
        btRoll.setOnAction(new ButtonPress());
        btRoll.getStyleClass().add("btRoll");
        btRoll.setStyle("-fx-background-size: " + (GlobalVars.secBtWidth - 60) + " auto;");
         
        //Labels
        lbPozemky = new Label();
        lbPozemky.setPrefWidth(GlobalVars.primBtWidth);
        lbPozemky.setPrefHeight(GlobalVars.primBtHeight);
        lbPozemky.getStyleClass().add("lbPozemky");
        
        lbNazov = new Label();
        lbNazov.getStyleClass().add("lbNazov");
        lbNazov.setAlignment(Pos.CENTER);
        lbNazov.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbNazov.setPrefHeight(GlobalVars.secBtHeight);
        
        lbUroven = new Label();
        lbUroven.getStyleClass().add("lbUroven");
        lbUroven.setAlignment(Pos.CENTER);
        lbUroven.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbUroven.setPrefHeight(GlobalVars.secBtHeight);
        
        lbPredaj = new Label();
        lbPredaj.getStyleClass().add("lbPredaj");
        lbPredaj.setAlignment(Pos.CENTER);
        lbPredaj.setPrefWidth(GlobalVars.secBtWidth / 2);
        lbPredaj.setPrefHeight(GlobalVars.secBtHeight);
        
        //Umiestnenie labelov pre najom
        double rentLabelDeltaX = GlobalVars.width / 24.5;
        
        double lbX1R = GlobalVars.width / 2.352;
        double lbX3R = lbX1R - (rentLabelDeltaX * 2);
        double lbX4R = lbX3R - rentLabelDeltaX;
        double lbX5R = lbX4R - rentLabelDeltaX;
        double lbX6R = lbX5R - rentLabelDeltaX;
        double lbX7R = lbX6R - rentLabelDeltaX;
        double lbX8R = lbX7R - rentLabelDeltaX;
        double lbX9R = lbX8R - rentLabelDeltaX;
        
        lbFurca1Rent = new Label();
        lbFurca1Rent.setLayoutY(GlobalVars.height / 1.037);
        lbFurca1Rent.setLayoutX(lbX1R);
        
        lbFurca2Rent = new Label();
        lbFurca2Rent.setLayoutY(GlobalVars.height / 1.037);
        lbFurca2Rent.setLayoutX(lbX3R);
        
        lbKvp1Rent = new Label();
        lbKvp1Rent.setLayoutY(GlobalVars.height / 1.037);
        lbKvp1Rent.setLayoutX(lbX6R);
        
        lbKvp2Rent = new Label();
        lbKvp2Rent.setLayoutY(GlobalVars.height / 1.037);
        lbKvp2Rent.setLayoutX(lbX8R);
        
        lbKvp3Rent = new Label();
        lbKvp3Rent.setLayoutY(GlobalVars.height / 1.037);
        lbKvp3Rent.setLayoutX(lbX9R);
        
        double rentLabelDeltaY = GlobalVars.height / 13.35;
        
        double lbY1R = GlobalVars.height / 1.2345;
        double lbY2R = lbY1R - rentLabelDeltaY;
        double lbY3R = lbY2R - rentLabelDeltaY;
        double lbY4R = lbY3R - rentLabelDeltaY;
        double lbY5R = lbY4R - rentLabelDeltaY;
        double lbY6R = lbY5R - rentLabelDeltaY;
        double lbY8R = lbY6R - (2 * rentLabelDeltaY);
        double lbY9R = lbY8R - rentLabelDeltaY;
        
        lbMyslava1Rent = new Label();
        lbMyslava1Rent.setLayoutX(GlobalVars.width / 17.4);
        lbMyslava1Rent.setLayoutY(lbY1R);
        
        lbMyslava2Rent = new Label();
        lbMyslava2Rent.setLayoutX(GlobalVars.width / 17.4);
        lbMyslava2Rent.setLayoutY(lbY2R);
        
        lbMyslava3Rent = new Label();
        lbMyslava3Rent.setLayoutX(GlobalVars.width / 17.4);
        lbMyslava3Rent.setLayoutY(lbY4R);
        
        lbBarca1Rent = new Label();
        lbBarca1Rent.setLayoutX(GlobalVars.width / 17.4);
        lbBarca1Rent.setLayoutY(lbY6R);
        
        lbBarca2Rent = new Label();
        lbBarca2Rent.setLayoutX(GlobalVars.width / 17.4);
        lbBarca2Rent.setLayoutY(lbY8R);
        
        lbBarca3Rent = new Label();
        lbBarca3Rent.setLayoutX(GlobalVars.width / 17.4);
        lbBarca3Rent.setLayoutY(lbY9R);
        
        lbKrasna1Rent = new Label();
        lbKrasna1Rent.setLayoutY(GlobalVars.height / 7.22);
        lbKrasna1Rent.setLayoutX(lbX9R);
        
        lbKrasna2Rent = new Label();
        lbKrasna2Rent.setLayoutY(GlobalVars.height / 7.22);
        lbKrasna2Rent.setLayoutX(lbX7R);
        
        lbKrasna3Rent = new Label();
        lbKrasna3Rent.setLayoutY(GlobalVars.height / 7.22);
        lbKrasna3Rent.setLayoutX(lbX6R);
        
        lbCentrum1Rent = new Label();
        lbCentrum1Rent.setLayoutY(GlobalVars.height / 7.22);
        lbCentrum1Rent.setLayoutX(lbX4R);
        
        lbCentrum2Rent = new Label();
        lbCentrum2Rent.setLayoutY(GlobalVars.height / 7.22);
        lbCentrum2Rent.setLayoutX(lbX3R);
        
        lbCentrum3Rent = new Label();
        lbCentrum3Rent.setLayoutY(GlobalVars.height / 7.22);
        lbCentrum3Rent.setLayoutX(lbX1R);
        
        lbTerasa1Rent = new Label();
        lbTerasa1Rent.setLayoutX(GlobalVars.width / 2.15);
        lbTerasa1Rent.setLayoutY(lbY9R);
        
        lbTerasa2Rent = new Label();
        lbTerasa2Rent.setLayoutX(GlobalVars.width / 2.15);
        lbTerasa2Rent.setLayoutY(lbY8R);
        
        lbTerasa3Rent = new Label();
        lbTerasa3Rent.setLayoutX(GlobalVars.width / 2.15);
        lbTerasa3Rent.setLayoutY(lbY6R);
        
        lbNadJazerom1Rent = new Label();
        lbNadJazerom1Rent.setLayoutX(GlobalVars.width / 2.15);
        lbNadJazerom1Rent.setLayoutY(lbY3R);
        
        lbNadJazerom2Rent = new Label();
        lbNadJazerom2Rent.setLayoutX(GlobalVars.width / 2.15);
        lbNadJazerom2Rent.setLayoutY(lbY1R);
        
        lbDargovRent = new Label();
        lbDargovRent.setLayoutY(GlobalVars.height / 1.037);
        lbDargovRent.setLayoutX(lbX5R);
        
        lbCassoviaRent = new Label();
        lbCassoviaRent.setLayoutX(GlobalVars.width / 17.4);
        lbCassoviaRent.setLayoutY(lbY5R);
        
        lbOptimaRent = new Label();
        lbOptimaRent.setLayoutY(GlobalVars.height / 7.22);
        lbOptimaRent.setLayoutX(lbX5R);
        
        lbAuparkRent = new Label();
        lbAuparkRent.setLayoutX(GlobalVars.width / 2.15);
        lbAuparkRent.setLayoutY(lbY5R);
        
        //Pridanie vsetkych labelov pre najom do array listu
        rentLabels.put("Furča 1", lbFurca1Rent);
        rentLabels.put("Furča 2", lbFurca2Rent);
        rentLabels.put("KVP 1", lbKvp1Rent);
        rentLabels.put("KVP 2", lbKvp2Rent);
        rentLabels.put("KVP 3", lbKvp3Rent);
        rentLabels.put("Myslava 1", lbMyslava1Rent);
        rentLabels.put("Myslava 2", lbMyslava2Rent);
        rentLabels.put("Myslava 3", lbMyslava3Rent);
        rentLabels.put("Barca 1", lbBarca1Rent);
        rentLabels.put("Barca 2", lbBarca2Rent);
        rentLabels.put("Barca 3", lbBarca3Rent);
        rentLabels.put("Krásna 1", lbKrasna1Rent);
        rentLabels.put("Krásna 2", lbKrasna2Rent);
        rentLabels.put("Krásna 3", lbKrasna3Rent);
        rentLabels.put("Centrum 1", lbCentrum1Rent);
        rentLabels.put("Centrum 2", lbCentrum2Rent);
        rentLabels.put("Centrum 3", lbCentrum3Rent);
        rentLabels.put("Terasa 1", lbTerasa1Rent);
        rentLabels.put("Terasa 2", lbTerasa2Rent);
        rentLabels.put("Terasa 3", lbTerasa3Rent);
        rentLabels.put("Nad Jazerom 1", lbNadJazerom1Rent);
        rentLabels.put("Nad Jazerom 2", lbNadJazerom2Rent);
        rentLabels.put("OC Dargov", lbDargovRent);
        rentLabels.put("OC Cassovia", lbCassoviaRent);
        rentLabels.put("OC Optima", lbOptimaRent);
        rentLabels.put("OC Aupark", lbAuparkRent);
        
        //GridPane - vrch lavej strany obrazovky
        gpTopLeft = new GridPane();
        gpTopLeft.setAlignment(Pos.TOP_CENTER);
        gpTopLeft.setVgap(10);
        
        gpTopLeft.add(lbNazov, 0, 0);
        gpTopLeft.add(lbUroven, 1, 0);
        gpTopLeft.add(lbPredaj, 2, 0);
        
        gpTopLeft.setMargin(lbNazov, GlobalVars.cbInset);
        gpTopLeft.setMargin(lbUroven, GlobalVars.cbInset);
        gpTopLeft.setMargin(lbPredaj, GlobalVars.cbInset);
        
        //ScrollPane - vrch lavej strany obrazovky
        ScrollPane spLeft = new ScrollPane();
        spLeft.setContent(gpTopLeft);
        spLeft.getStyleClass().add("spLeft");
        spLeft.setFitToHeight(true);
        spLeft.setFitToWidth(true);
        
        //HBox - spodok lavej strany obrazovky
        HBox hbBottomLeft = new HBox();
        hbBottomLeft.setAlignment(Pos.BOTTOM_LEFT);
        hbBottomLeft.setMargin(btPause, GlobalVars.secBtInset);
        hbBottomLeft.setMargin(btEndMove, GlobalVars.secBtInset);
        hbBottomLeft.getChildren().addAll(btPause, btEndMove);
        
        //Region - spacer pre lavu stranu obrazovky
        Region leftSpacer = new Region();
        VBox.setVgrow(leftSpacer, Priority.ALWAYS);
        
        //VBox - lava strana obrazovky
        VBox vbLeft = new VBox(10);
        vbLeft.getChildren().addAll(lbPozemky, spLeft, leftSpacer, hbBottomLeft);
        HBox.setHgrow(vbLeft, Priority.NEVER);
        vbLeft.setMaxWidth(GlobalVars.width / 5);
        
        //VBox - prava strana obrazovky
        VBox vbRight = new VBox(20);
        vbRight.setAlignment(Pos.TOP_CENTER);
        
        //Player1
        lbPl1Nickname = new Label(player1.getNickname());
        lbPl1Nickname.setMinWidth(GlobalVars.secBtWidth * 2);
        lbPl1Nickname.setMinHeight(GlobalVars.secBtHeight * 2);
        lbPl1Nickname.setAlignment(Pos.BOTTOM_CENTER);
        lbPl1Nickname.getStyleClass().add("statusLabel");
        lbPl1Nickname.setLayoutX(GlobalVars.width / -32);
        lbPl1Nickname.setLayoutY(GlobalVars.height / -540);
                
        lbPl1Money = new Label(Integer.toString(player1.getMoney()) + "€");
        lbPl1Money.setMinWidth(GlobalVars.secBtWidth * 2);
        lbPl1Money.setMinHeight(GlobalVars.secBtHeight * 2);
        lbPl1Money.setAlignment(Pos.CENTER);
        lbPl1Money.getStyleClass().add("statusLabel");
        lbPl1Money.setLayoutX(GlobalVars.width / -32);
        lbPl1Money.setLayoutY(GlobalVars.height / 13.2);
        
        lbPl1Time = new Label(Integer.toString(GlobalVars.timer));
        lbPl1Time.setMinWidth(GlobalVars.secBtWidth * 2);
        lbPl1Time.setMinHeight(GlobalVars.secBtHeight * 2);
        lbPl1Time.setAlignment(Pos.TOP_CENTER);
        lbPl1Time.getStyleClass().add("statusLabel");
        lbPl1Time.setLayoutX(GlobalVars.width / -32);
        lbPl1Time.setLayoutY(GlobalVars.height / 7.15);
        
        Pane pl1Pane = new Pane();
        
        InputStream pl1StatusIS = getClass().getResourceAsStream("/img/labels/status" + player1.getColor() + ".png");    
        
        Image pl1Status = new Image(pl1StatusIS);
        
        ImageView pl1StatusIW = new ImageView();
        pl1StatusIW.setImage(pl1Status);
        pl1StatusIW.setLayoutX(GlobalVars.width / 80);
        
        pl1StatusIW.setFitWidth(GlobalVars.secBtWidth * 1.3);
        pl1StatusIW.setPreserveRatio(true);
               
        pl1Pane.getChildren().addAll(pl1StatusIW, lbPl1Nickname, lbPl1Money, lbPl1Time);
        
        //Vykreslenie fugurky pre hraca1
        pl1FigIS = getClass().getResourceAsStream("/img/figures/" + player1.getFigure().toLowerCase() + "/" + player1.getFigure().toLowerCase() + player1.getColor() + ".png");
        pl1FigImg = new Image(pl1FigIS);
            
        pl1FigIW = new ImageView();
        pl1FigIW.setImage(pl1FigImg);
        
        pl1FigIW.setLayoutX(GlobalVars.width / 2.03);
        pl1FigIW.setLayoutY(GlobalVars.height / 1.15);
        
        //Player2
        lbPl2Nickname = new Label(player2.getNickname());
        lbPl2Nickname.setMinWidth(GlobalVars.secBtWidth * 2);
        lbPl2Nickname.setMinHeight(GlobalVars.secBtHeight * 2);
        lbPl2Nickname.setAlignment(Pos.BOTTOM_CENTER);
        lbPl2Nickname.getStyleClass().add("statusLabel");
        lbPl2Nickname.setLayoutX(GlobalVars.width / -32);
        lbPl2Nickname.setLayoutY(GlobalVars.height / -540);
                
        lbPl2Money = new Label(Integer.toString(player1.getMoney()) + "€");
        lbPl2Money.setMinWidth(GlobalVars.secBtWidth * 2);
        lbPl2Money.setMinHeight(GlobalVars.secBtHeight * 2);
        lbPl2Money.setAlignment(Pos.CENTER);
        lbPl2Money.getStyleClass().add("statusLabel");
        lbPl2Money.setLayoutX(GlobalVars.width / -32);
        lbPl2Money.setLayoutY(GlobalVars.height / 13.2);
        
        lbPl2Time = new Label(Integer.toString(GlobalVars.timer));
        lbPl2Time.setMinWidth(GlobalVars.secBtWidth * 2);
        lbPl2Time.setMinHeight(GlobalVars.secBtHeight * 2);
        lbPl2Time.setAlignment(Pos.TOP_CENTER);
        lbPl2Time.getStyleClass().add("statusLabel");
        lbPl2Time.setLayoutX(GlobalVars.width / -32);
        lbPl2Time.setLayoutY(GlobalVars.height / 7.15);
        
        Pane pl2Pane = new Pane();
        
        InputStream pl2StatusIS = getClass().getResourceAsStream("/img/labels/status" + player2.getColor() + ".png");    
        
        Image pl2Status = new Image(pl2StatusIS);
        
        ImageView pl2StatusIW = new ImageView();
        pl2StatusIW.setImage(pl2Status);
        pl2StatusIW.setLayoutX(GlobalVars.width / 80);
        
        pl2StatusIW.setFitWidth(GlobalVars.secBtWidth * 1.3);
        pl2StatusIW.setPreserveRatio(true);
        
        pl2Pane.getChildren().addAll(pl2StatusIW, lbPl2Nickname, lbPl2Money, lbPl2Time);
        
        //Vykreslenie fugurky pre hraca2
        pl2FigIS = getClass().getResourceAsStream("/img/figures/" + player2.getFigure().toLowerCase() + "/" + player2.getFigure().toLowerCase() + player2.getColor() + ".png");
        pl2FigImg = new Image(pl2FigIS);
            
        pl2FigIW = new ImageView();
        pl2FigIW.setImage(pl2FigImg);
        
        pl2FigIW.setLayoutX(GlobalVars.width / 2.03);
        pl2FigIW.setLayoutY(GlobalVars.height / 1.12);
        
        vbRight.getChildren().addAll(pl1Pane, pl2Pane);
        players.add(player1);
        players.add(player2);    
        
        if(GlobalVars.playerCount >= 3){
            //Player3
            lbPl3Nickname = new Label(player3.getNickname());
            lbPl3Nickname.setMinWidth(GlobalVars.secBtWidth * 2);
            lbPl3Nickname.setMinHeight(GlobalVars.secBtHeight * 2);
            lbPl3Nickname.setAlignment(Pos.BOTTOM_CENTER);
            lbPl3Nickname.getStyleClass().add("statusLabel");
            lbPl3Nickname.setLayoutX(GlobalVars.width / -32);
            lbPl3Nickname.setLayoutY(GlobalVars.height / -540);
                    
            lbPl3Money = new Label(Integer.toString(player3.getMoney()) + "€");
            lbPl3Money.setMinWidth(GlobalVars.secBtWidth * 2);
            lbPl3Money.setMinHeight(GlobalVars.secBtHeight * 2);
            lbPl3Money.setAlignment(Pos.CENTER);
            lbPl3Money.getStyleClass().add("statusLabel");
            lbPl3Money.setLayoutX(GlobalVars.width / -32);
            lbPl3Money.setLayoutY(GlobalVars.height / 13.2);
            
            lbPl3Time = new Label(Integer.toString(GlobalVars.timer));
            lbPl3Time.setMinWidth(GlobalVars.secBtWidth * 2);
            lbPl3Time.setMinHeight(GlobalVars.secBtHeight * 2);
            lbPl3Time.setAlignment(Pos.TOP_CENTER);
            lbPl3Time.getStyleClass().add("statusLabel");
            lbPl3Time.setLayoutX(GlobalVars.width / -32);
            lbPl3Time.setLayoutY(GlobalVars.height / 7.15);
            
            Pane pl3Pane = new Pane();
            
            InputStream pl3StatusIS = getClass().getResourceAsStream("/img/labels/status" + player3.getColor() + ".png");    
            
            Image pl3Status = new Image(pl3StatusIS);
            
            ImageView pl3StatusIW = new ImageView();
            pl3StatusIW.setImage(pl3Status);
            pl3StatusIW.setLayoutX(GlobalVars.width / 80);
            
            pl3StatusIW.setFitWidth(GlobalVars.secBtWidth * 1.3);
            pl3StatusIW.setPreserveRatio(true);
                   
            pl3Pane.getChildren().addAll(pl3StatusIW, lbPl3Nickname, lbPl3Money, lbPl3Time);
            
            //Vykreslenie fugurky pre hraca3
            pl3FigIS = getClass().getResourceAsStream("/img/figures/" + player3.getFigure().toLowerCase() + "/" + player3.getFigure().toLowerCase() + player3.getColor() + ".png");
            pl3FigImg = new Image(pl3FigIS);
            
            pl3FigIW = new ImageView();
            pl3FigIW.setImage(pl3FigImg);
        
            pl3FigIW.setLayoutX(GlobalVars.width / 2.03);
            pl3FigIW.setLayoutY(GlobalVars.height / 1.09);
            
            vbRight.getChildren().add(pl3Pane);
            players.add(player3);
        }
        
        if(GlobalVars.playerCount == 4){
            //Player4
            lbPl4Nickname = new Label(player4.getNickname());
            lbPl4Nickname.setMinWidth(GlobalVars.secBtWidth * 2);
            lbPl4Nickname.setMinHeight(GlobalVars.secBtHeight * 2);
            lbPl4Nickname.setAlignment(Pos.BOTTOM_CENTER);
            lbPl4Nickname.getStyleClass().add("statusLabel");
            lbPl4Nickname.setLayoutX(GlobalVars.width / -32);
            lbPl4Nickname.setLayoutY(GlobalVars.height / -540);
                    
            lbPl4Money = new Label(Integer.toString(player1.getMoney()) + "€");
            lbPl4Money.setMinWidth(GlobalVars.secBtWidth * 2);
            lbPl4Money.setMinHeight(GlobalVars.secBtHeight * 2);
            lbPl4Money.setAlignment(Pos.CENTER);
            lbPl4Money.getStyleClass().add("statusLabel");
            lbPl4Money.setLayoutX(GlobalVars.width / -32);
            lbPl4Money.setLayoutY(GlobalVars.height / 13.2);
            
            lbPl4Time = new Label(Integer.toString(GlobalVars.timer));
            lbPl4Time.setMinWidth(GlobalVars.secBtWidth * 2);
            lbPl4Time.setMinHeight(GlobalVars.secBtHeight * 2);
            lbPl4Time.setAlignment(Pos.TOP_CENTER);
            lbPl4Time.getStyleClass().add("statusLabel");
            lbPl4Time.setLayoutX(GlobalVars.width / -32);
            lbPl4Time.setLayoutY(GlobalVars.height / 7.15);
            
            Pane pl4Pane = new Pane();
            
            InputStream pl4StatusIS = getClass().getResourceAsStream("/img/labels/status" + player4.getColor() + ".png");    
            
            Image pl4Status = new Image(pl4StatusIS);
            
            ImageView pl4StatusIW = new ImageView();
            pl4StatusIW.setImage(pl4Status);
            pl4StatusIW.setLayoutX(GlobalVars.width / 80);
            
            pl4StatusIW.setFitWidth(GlobalVars.secBtWidth * 1.3);
            pl4StatusIW.setPreserveRatio(true);
                   
            pl4Pane.getChildren().addAll(pl4StatusIW, lbPl4Nickname, lbPl4Money, lbPl4Time);
            
            //Vykreslenie fugurky pre hraca4
            pl4FigIS = getClass().getResourceAsStream("/img/figures/" + player4.getFigure().toLowerCase() + "/" + player4.getFigure().toLowerCase() + player4.getColor() + ".png");
            pl4FigImg = new Image(pl4FigIS);
            
            pl4FigIW = new ImageView();
            pl4FigIW.setImage(pl4FigImg);
        
            pl4FigIW.setLayoutX(GlobalVars.width / 2.03);
            pl4FigIW.setLayoutY(GlobalVars.height / 1.06);
            
            vbRight.getChildren().add(pl4Pane);
            vbRight.setAlignment(Pos.CENTER);
            players.add(player4);
        }
        
        //nahodny vyber zacinajuceho hraca
        onTurn = (int)(Math.random() * players.size());
        players.get(onTurn).setTurn(true);
        
        //Kocka 1
        dice1IS = getClass().getResourceAsStream("/img/dice/d" + players.get(onTurn).getColor() + "_1.png");
        dice1Img = new Image(dice1IS);
        dice1IW = new ImageView();
        dice1IW.setImage(dice1Img);
        
        dice1IW.setFitWidth(GlobalVars.secBtWidth / 2);
        dice1IW.setPreserveRatio(true);
        
        dice1IW.setLayoutX(GlobalVars.width / 9);
        dice1IW.setLayoutY(GlobalVars.height / 1.52);
        
        //Kocka2
        dice2IS = getClass().getResourceAsStream("/img/dice/d" + players.get(onTurn).getColor() + "_1.png");
        dice2Img = new Image(dice2IS);
        dice2IW = new ImageView();
        dice2IW.setImage(dice2Img);
        
        dice2IW.setFitWidth(GlobalVars.secBtWidth / 2);
        dice2IW.setPreserveRatio(true);
        
        dice2IW.setLayoutX(GlobalVars.width / 2.8);
        dice2IW.setLayoutY(GlobalVars.height / 1.52);
        
        //Sanca karticka
        chanceIS = getClass().getResourceAsStream("/img/events/base/baseBack.png");
        chanceImg = new Image(chanceIS);
        chanceIW = new ImageView();
        chanceIW.setImage(chanceImg);
        
        chanceIW.setLayoutX(GlobalVars.width / 5.5);
        chanceIW.setLayoutY(GlobalVars.height / 5.5);
        
        switch(onTurn){
            case 0:
                lbPl1Nickname.setStyle("-fx-text-fill: white");
                lbPl1Money.setStyle("-fx-text-fill: white");
                lbPl1Time.setStyle("-fx-text-fill: white");
                break;
            case 1:
                lbPl2Nickname.setStyle("-fx-text-fill: white");
                lbPl2Money.setStyle("-fx-text-fill: white");
                lbPl2Time.setStyle("-fx-text-fill: white");
                break;
            case 2:
                lbPl3Nickname.setStyle("-fx-text-fill: white");
                lbPl3Money.setStyle("-fx-text-fill: white");
                lbPl3Time.setStyle("-fx-text-fill: white");
                break;
            case 3:
                lbPl4Nickname.setStyle("-fx-text-fill: white");
                lbPl4Money.setStyle("-fx-text-fill: white");
                lbPl4Time.setStyle("-fx-text-fill: white");
                break;
        }

        timing(players.get(onTurn));
        
        //vbCenter - stred obrazovky
        VBox vbCenter = new VBox();
        VBox.setVgrow(vbCenter, Priority.ALWAYS);
        HBox.setHgrow(vbCenter, Priority.ALWAYS);
        vbCenter.getStyleClass().add("bpCenter");
        
        //Pane - stred obrazovky
        pCenter = new Pane();
        pCenter.getChildren().addAll(btRoll);
        pCenter.getChildren().addAll(pl1FigIW, pl2FigIW);
        pCenter.getChildren().addAll(dice1IW, dice2IW);
        pCenter.getChildren().add(chanceIW);
            
        if(players.size() >= 3){
            pCenter.getChildren().add(pl3FigIW);
        }
        
        if(players.size() == 4){
            pCenter.getChildren().add(pl4FigIW);
        }
        
        rentLabels.forEach((key, label) -> {
            pCenter.getChildren().add(label);
            label.setStyle("-fx-font-weight: bold;");
        });
        
        //BorderPane - rozlozenie obrazovky
        BorderPane bp = new BorderPane();
        
        //BorderPane - left
        bp.setLeft(vbLeft);
        
        //StackPane - center
        StackPane spCenter = new StackPane();
        spCenter.getChildren().addAll(vbCenter, pCenter);
        spCenter.setMinWidth(GlobalVars.width / 2);
        
        btRoll.setLayoutX(GlobalVars.width / 4.45);
        btRoll.setLayoutY(GlobalVars.height / 1.4);                           
        
        //BorderPane - Center
        BorderPane.setMargin(vbCenter, new Insets(0, 10, 0, 10));
        bp.setCenter(spCenter);
        
        //BorderPane - Right
        bp.setRight(vbRight);
        bp.setMargin(vbRight, new Insets(50));
        vbRight.setPrefWidth(GlobalVars.width / 5);
                
        scene = new Scene(bp, GlobalVars.width, GlobalVars.height);
        scene.getStylesheets().addAll(getClass().getResource("/css/PlayScene.css").toExternalForm(), getClass().getResource("/css/Style.css").toExternalForm());
    }
    
    class ButtonPress implements EventHandler<ActionEvent>{
        public void handle(ActionEvent evt){
            if(evt.getTarget().equals(btPause)){
                showPauseMenu();
            }
            
            if(evt.getTarget().equals(btEndMove)){
                //Logika pre menenie hraca na tahu
                if(diceThrow){
                    diceThrow = false;
                    players.get(onTurn).setTurn(false);
                    players.get(onTurn).getTimer().cancel();
                    
                    chanceIS = getClass().getResourceAsStream("/img/events/base/baseBack.png");
                    Image newChanceImg = new Image(chanceIS);
                    chanceIW.setImage(newChanceImg);
                
                    switch(onTurn){
                        case 0:
                            lbPl1Nickname.setStyle("-fx-text-fill: black");
                            lbPl1Money.setStyle("-fx-text-fill: black");
                            lbPl1Time.setStyle("-fx-text-fill: black");
                            break;
                        case 1:
                            lbPl2Nickname.setStyle("-fx-text-fill: black");
                            lbPl2Money.setStyle("-fx-text-fill: black");
                            lbPl2Time.setStyle("-fx-text-fill: black");
                            break;
                        case 2:
                            lbPl3Nickname.setStyle("-fx-text-fill: black");
                            lbPl3Money.setStyle("-fx-text-fill: black");
                            lbPl3Time.setStyle("-fx-text-fill: black");
                            break;
                        case 3:
                            lbPl4Nickname.setStyle("-fx-text-fill: black");
                            lbPl4Money.setStyle("-fx-text-fill: black");
                            lbPl4Time.setStyle("-fx-text-fill: black");
                            break;
                    }
                    
                    if(onTurn < (players.size() - 1)){
                        onTurn += 1;
                    }else{
                        onTurn = 0;
                    }
                    
                    if(players.get(onTurn).getPause() > 0){
                        players.get(onTurn).setPause(players.get(onTurn).getPause() - 1);
                        
                        if(onTurn < (players.size() - 1)){
                            onTurn += 1;
                        }else{
                            onTurn = 0;
                        }
                    }
                    
                    switch(onTurn){
                        case 0:
                            lbPl1Nickname.setStyle("-fx-text-fill: white");
                            lbPl1Money.setStyle("-fx-text-fill: white");
                            lbPl1Time.setStyle("-fx-text-fill: white");
                            break;
                        case 1:
                            lbPl2Nickname.setStyle("-fx-text-fill: white");
                            lbPl2Money.setStyle("-fx-text-fill: white");
                            lbPl2Time.setStyle("-fx-text-fill: white");
                            break;
                        case 2:
                            lbPl3Nickname.setStyle("-fx-text-fill: white");
                            lbPl3Money.setStyle("-fx-text-fill: white");
                            lbPl3Time.setStyle("-fx-text-fill: white");
                            break;
                        case 3:
                            lbPl4Nickname.setStyle("-fx-text-fill: white");
                            lbPl4Money.setStyle("-fx-text-fill: white");
                            lbPl4Time.setStyle("-fx-text-fill: white");
                            break;
                    }
                    
                    dice1IS = getClass().getResourceAsStream("/img/dice/d" + players.get(onTurn).getColor() + "_1.png");
                    Image dice1newImg = new Image(dice1IS);
                    dice1IW.setImage(dice1newImg);
                    
                    dice2IS = getClass().getResourceAsStream("/img/dice/d" + players.get(onTurn).getColor() + "_1.png");
                    Image dice2newImg = new Image(dice2IS);
                    dice2IW.setImage(dice2newImg);
                    
                    players.get(onTurn).setTimer(new Timer(true));
                    timing(players.get(onTurn));
                    players.get(onTurn).setTurn(true);
                    System.out.println(players.get(onTurn).getNickname());
                    System.out.println(onTurn);
                    
                    showProperties();
                }else{
                    diceAlert("Ešte si nehodil kockou!");
                }
            }
            
            if(evt.getTarget().equals(btRoll)){
                if(diceThrow == false){
                    String rollFile = new File("./sound/dice.mp3").toURI().toString();
                    Media rollSound = new Media(rollFile);
                    MediaPlayer rollPlayer = new MediaPlayer(rollSound);
                    rollPlayer.setAudioSpectrumNumBands(0);   
                    
                    if(rollTimer != null){
                        rollTimer.cancel();
                    }
                    
                    rollTimer = new Timer();
                    TimerTask rollTask = new TimerTask(){
                        public void run(){
                            
                        }

                    };
                    
                    moved = false;
                    rollTimer.schedule(rollTask, (long) rollSound.getDuration().toMillis());
                    
                    rollPlayer.setOnEndOfMedia(() -> {
                        try {
                            move();
                            btRoll.setDisable(true);
                            moved = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("ERROR: Exception in move()!");
                            btRoll.setDisable(false);  // Ensure the button doesn't stay disabled
                        } finally {
                            btRoll.setDisable(false);
                        }
                    });
                    
                    rollPlayer.play();
                    diceThrow = true;
                }else{
                    diceAlert("Už si raz hodil kockou!");
                }
            }
        }
    }
    public Scene getScene(){
        return scene;
    }
} 