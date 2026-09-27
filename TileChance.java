import java.util.ArrayList;

public class TileChance extends TileBase{
    private int playerId;
    private static ArrayList<String> chanceList = new ArrayList<String>();
    
    public TileChance(int id, String label, int x, int y, int playerId, boolean vertical){
        super(id, label, x, y, vertical);
        this.playerId = playerId;
    }
    
    public void initializeChanceList(){
        chanceList.add("zemetrasenie");
        chanceList.add("povoden");
        chanceList.add("tornado");
        chanceList.add("vkv");
        chanceList.add("prerabSlan");
        chanceList.add("strajkMhd");
        chanceList.add("medved");
        chanceList.add("arktZima");
        //chanceList.add("papez");
        chanceList.add("vianTrhy");
        chanceList.add("jazeroBenatky");
        chanceList.add("kebab");
        chanceList.add("vypadInter");
        chanceList.add("zdrazElk");
        chanceList.add("zdrazVod");
        chanceList.add("exekutor");
        chanceList.add("stokari");
        chanceList.add("bielaNoc");
        chanceList.add("nocMuzei");
        chanceList.add("detskaZelez");
        //chanceList.add("lesnyDuch");
    }
    
    public static ArrayList<String> getChanceList(){
        return chanceList;
    }
    
    public int getPlayerId(){
        return playerId;
    }

    public void setPlayerId(){
        this.playerId = playerId;
    }
    
    public String toString(){
        return playerId + super.toString();
    }

}
