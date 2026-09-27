import javafx.geometry.Insets;
import javafx.stage.Screen;

public class GlobalVars{
    //dimenzie obrazovky v pixeloch
    public static Double width = Screen.getPrimary().getBounds().getWidth();
    public static Double height = Screen.getPrimary().getBounds().getHeight();
      
    //dymenzie primarnych tlacitiek
    public static Double primBtWidth = width / 3;
    public static Double primBtHeight = height / 10;
      
    //dymenzie sekundarnych tlacitiek
    public static Double secBtWidth = width / 7.5;
    public static Double secBtHeight = height / 30;
      
    //velkost margin pri sekundarnych tlacitkach
    public static Insets secBtInset = new Insets(20);
    
    //velkost margin pri combo/choiceBoxoch
    public static Insets cbInset = new Insets(10);
    
    //velkost padding pri combo/choiceBoxoch
    public static Insets cbInsetPadding = new Insets(5);
    
    //velkost margin v GameSetupPlayers
    public static Insets gsupInsetMargin = new Insets(0, 100, 0, 100);
    
    //velkost margin pre vypis majetkov v PlayScene
    public static Insets psPropInMargin = new Insets(0, 15, 0, 15);
      
    //hodnoty potrebne na spustenie a priebeh hry
    //pocet hracov
    public static int playerCount = 0;
    
    //zaciatocne peniaze
    public static int startCash = 0;
    
    //penazny ciel pre vyhru
    public static int targetCash = 0;
    
    //samostatny casovac na hraca
    public static int timer = 0;
    
    //hlasitost zvuku pre zvukove efekty
    public static double sfx = 1.0;
}
