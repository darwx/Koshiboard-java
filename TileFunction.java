import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.Random;

public class TileFunction {                           
    static Map<String, Consumer<Player>> playerMethods = new HashMap<>();
    static Map<String, Consumer<ArrayList<Player>>> playersMethods = new HashMap<>();
    private static Random rand = new Random();
    
    static {
        //Metody ovplyvnujuce jedneho hraca
        playerMethods.put("zemetrasenie", TileFunction::zemetrasenie);
        playerMethods.put("povoden", TileFunction::povoden);
        playerMethods.put("tornado", TileFunction::tornado);
        playerMethods.put("vkv", TileFunction::vkv);
        playerMethods.put("prerabSlan", TileFunction::prerabSlan);
        playerMethods.put("strajkMhd", TileFunction::strajkMhd);
        playerMethods.put("medved", TileFunction::medved);
        playerMethods.put("arktZima", TileFunction::arktZima);
        playerMethods.put("kebab", TileFunction::kebab);
        playerMethods.put("vypadInter", TileFunction::vypadInter);
        playerMethods.put("exekutor", TileFunction::exekutor);
        playerMethods.put("stokari", TileFunction::stokari);
        playerMethods.put("bielaNoc", TileFunction::bielaNoc);
        playerMethods.put("nocMuzei", TileFunction::nocMuzei);
        playerMethods.put("detskaZelez", TileFunction::detskaZelez);
        
        //Metody ovplyvnujuce vsetkych hracov
        playersMethods.put("vianTrhy", TileFunction::vianTrhy);
        playersMethods.put("jazeroBenatky", TileFunction::jazeroBenatky);
        playersMethods.put("zdrazElek", TileFunction::zdrazElek);
        playersMethods.put("zdrazVod", TileFunction::zdrazVod);
    }

    public static void startFunction(Player player){
        //Prida hracovi 200k ak prejde cez start
        player.setMoney(player.getMoney() + 200000);
    }
    
    public static void prisonFunction(Player player){
        //hrac stoji jedno kolo
        player.setPause(1);
    }
    
    public static void mestskyPark(){
        //nic sa nedeje
        System.out.println("Nic specialne sa nedeje, oddychni si :D");
    }
    
    public static void papezTile(TileProperty property){
        //Zvysi najom pozemku o polovicu
        property.setRent((int) (property.getRent()  * 1.5));
        property.setPapez(true);
    }
    
    public static int poklad(Player player){
        //Prida hracovi bud 50000, 100000 alebo 0
        int num = rand.nextInt(3);
        int money = 0;
        
        switch(num){
            case 0:
                money = 50000;
                player.setMoney(player.getMoney() + money);
                System.out.println("Hrac zisakava 50000");
                break;
                
            case 1:
                money = 100000;
                player.setMoney(player.getMoney() + money);
                System.out.println("Hrac ziskava 100000");
                break;
                
            case 2:
                System.out.println("Hrac neziskava nic");
                break;
        }
        
        return money;
    }

    public static void zemetrasenie(Player player){
        //znizi uroven nahodneho pozemku ak je jeho uroven vacsia ako 1
        if(player.getProperties().size() > 0){
            int randomPozemok = (int)(Math.random() * player.getProperties().size());
            if(player.getProperty(randomPozemok).getLevel() > 1){
                player.getProperty(randomPozemok).setLevel(player.getProperty(randomPozemok).getLevel() - 1);   
            }    
        }     
    }
    
    public static void povoden(Player player){
        //znizi uroven nahodneho pozemku ak je jeho uroven vacsia ako 1
        if(player.getProperties().size() > 0){
            int randomPozemok = (int)(Math.random() * player.getProperties().size());
            if(player.getProperty(randomPozemok).getLevel() > 1){
                player.getProperty(randomPozemok).setLevel(player.getProperty(randomPozemok).getLevel() - 1);   
            }    
        }     
    }
    
    public static void tornado(Player player){
        //znizi uroven nahodneho pozemku ak je jeho uroven vacsia ako 1
        if(player.getProperties().size() > 0){
            int randomPozemok = (int)(Math.random() * player.getProperties().size());
            if(player.getProperty(randomPozemok).getLevel() > 1){
                player.getProperty(randomPozemok).setLevel(player.getProperty(randomPozemok).getLevel() - 1);   
            }    
        }     
    }
    
    public static void vkv(Player player){
        //znizi uroven nahodneho pozemku ak je jeho uroven vacsia ako 1
        if(player.getProperties().size() > 0){
            int randomPozemok = (int)(Math.random() * player.getProperties().size());
            if(player.getProperty(randomPozemok).getLevel() > 1){
                player.getProperty(randomPozemok).setLevel(player.getProperty(randomPozemok).getLevel() - 1);   
            }    
        }     
    }
    
    public static void prerabSlan(Player player){
        //hrac stoji 2 kola
        player.setPause(2);
    }
    
    public static void strajkMhd(Player player){
        //hrac stoji 1 kolo
        player.setPause(1);
    }
    
    public static void medved(Player player){
        //hrac stoji 1 kolo
        player.setPause(1);
    }
    
    public static void arktZima(Player player){
        //hrac stoji 1 kolo
        player.setPause(1);
    }
    
    public static void papez(Player player){
        
    }
    
    public static void vianTrhy(ArrayList<Player> players){
        //kazdy hrac dostane 100k
        for(Player player : players){
            player.setMoney(player.getMoney() + 100000);
        }
    }
    
    public static void jazeroBenatky(ArrayList<Player> players){
        //kazdy hrac dostane 50k
        for(Player player : players){
            player.setMoney(player.getMoney() + 50000);
        }
    }
    
    public static void kebab(Player player){
        //hrac dostane 50k
        player.setMoney(player.getMoney() + 50000);
    }
    
    public static void vypadInter(Player player){
        //hrac pride o 50k
        if(player.getMoney() >= 50000){
            player.setMoney(player.getMoney() - 50000);    
        }else {
            player.setMoney(0);
        }
    }
    
    public static void zdrazElek(ArrayList<Player> players){
        //vsetci hraci pridu o pocet penazi rovny ich poctu pozemkov * 15k
        for(Player player : players){
            int minus = player.getProperties().size() * 15000;
            if(minus <= player.getMoney()){
                player.setMoney(player.getMoney() - minus);         
            }else{
                player.setMoney(0);
            }
        }
    }
    
    public static void zdrazVod(ArrayList<Player> players){
        //vsetci hraci pridu o pocet penazi rovny ich poctu pozemkov * 10k
        for(Player player : players){
            int minus = player.getProperties().size() * 10000;
            if(minus <= player.getMoney()){
                player.setMoney(player.getMoney() - minus);         
            }else{
                player.setMoney(0);
            }
        }
    }
    
    public static void exekutor(Player player){
        //hrac pride o nahodny pozemok
        if(player.getProperties().size() != 0){
            int randomPozemok = (int)Math.random() * player.getProperties().size();
            player.getProperty(randomPozemok).setOwner(null);
            player.removeProperty(randomPozemok);
        }
    }
    
    public static void stokari(Player player){
        //hrac dostane 50000 a stoji 1 kolo
        player.setMoney(player.getMoney() + 50000);
        player.setPause(1);    
    }
    
    public static void bielaNoc(Player player){
        //hrac dostane 50000 a stoji 1 kolo
        player.setMoney(player.getMoney() + 50000); 
        player.setPause(1);   
    }
    
    public static void nocMuzei(Player player){
        //hrac dostane 50000 a stoji 1 kolo
        player.setMoney(player.getMoney() + 50000);  
        player.setPause(1);  
    }
    
    public static void detskaZelez(Player player){
        //hrac dostane 100000 a stoji jedno kolo
        player.setMoney(player.getMoney() + 100000);  
        player.setPause(1);  
    }
    
    public static void voda(Player player){
        //hrac pride o 200k
        if(player.getMoney() >= 200000){
            player.setMoney(player.getMoney() - 200000);    
        }else {
            player.setMoney(0);
        }
        System.out.println("voda");
    }
    
    public static void elektrina(Player player){
        //hrac pride o 150k
        if(player.getMoney() >= 150000){
            player.setMoney(player.getMoney() - 150000);    
        }else {
            player.setMoney(0);
        }
        System.out.println("elektrina");
    }
    
    public static void internet(Player player){
        //hrac pride o 150k
        if(player.getMoney() >= 150000){
            player.setMoney(player.getMoney() - 150000);    
        }else {
            player.setMoney(0);
        }
        System.out.println("internet");
    }
    
    public static void parkovanie(Player player){
        //hrac pride o 100k
        if(player.getMoney() >= 100000){
            player.setMoney(player.getMoney() - 100000);    
        }else {
            player.setMoney(0);
        }
        System.out.println("parkovanie");
    }
    
    //Metoda na spustenie nahodnej metody(sance) ak hrac stupi na policko sanca
    public static String chance(Player player, ArrayList<Player> players){
        int section = (int) (Math.random() * 2);
        String key = new String();
        
        switch(section){
            case 0:
                Object[] playerKeys = playerMethods.keySet().toArray();
                 
                String randomKeyPlayer = "";
                
                do{
                    int playerChance = (int) (Math.random() * playerKeys.length);
                    randomKeyPlayer = (String) playerKeys[playerChance];
                
                
                    System.out.println("randomKeyPlayer");
                    key = randomKeyPlayer;
                }while(player.getProperties().size() == 0 && (randomKeyPlayer.equals("zemetrasenie") || randomKeyPlayer.equals("povoden") || randomKeyPlayer.equals("tornado") || randomKeyPlayer.equals("vkv") || randomKeyPlayer.equals("exekutor")));
                playerMethods.get(randomKeyPlayer).accept(player);
                break;
            case 1:
                Object[] playersKeys = playersMethods.keySet().toArray();
                
                int playersChance = (int) (Math.random() * playersKeys.length);
                
                String randomKeyPlayers = (String) playersKeys[playersChance];
                
                playersMethods.get(randomKeyPlayers).accept(players);
                
                System.out.println("randomKeyPlayers");
                key = randomKeyPlayers;
                break;
        }
        
        String alertFile = new File("./sound/alert.wav").toURI().toString();
        Media alertSound = new Media(alertFile);
        MediaPlayer alertPlayer = new MediaPlayer(alertSound);
        alertPlayer.setAudioSpectrumNumBands(0);
        alertPlayer.setVolume(GlobalVars.sfx);   
        alertPlayer.play();
        
        return key;
    }
}