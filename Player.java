import java.util.ArrayList;
import javafx.scene.control.Label;
import java.util.Timer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player{
    private String nickname;
    private String color;
    private String figure;
    private int id;
    private int money;
    private boolean turn;
    private ArrayList<TileProperty> properties = new ArrayList<TileProperty>();
    private int timeLeft;
    private Timer timer;
    private IntegerProperty x;
    private IntegerProperty y;
    private int pause;
    
    public Player(String nickname, String color, String figure, int id, int money, boolean turn, int timeLeft, Timer timer, int startX, int startY, int pause){
        this.nickname = nickname;
        this.color = color;
        this.figure = figure;
        this.id = id;
        this.money = money;
        this.turn = turn;
        this.timeLeft = timeLeft;
        this.timer = timer;
        this.x = new SimpleIntegerProperty(startX);
        this.y = new SimpleIntegerProperty(startY);
        this.pause = pause;
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public String getNickname(){
        return nickname;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setFigure(String figure){
        this.figure = figure;
    }
    
    public String getFigure(){
        return figure;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
    
    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public boolean getTurn(){
        return turn;
    }
    
    public void addProperty(TileProperty property){
        properties.add(property);
    }
    
    public void removeProperty(TileProperty property){
        properties.remove(property);
    }
    
    public void removeProperty(int property){
        properties.remove(property);
    }
    
    public TileProperty getProperty(int index){
        return properties.get(index);
    }
    
    public TileProperty getProperty(Label label){
        for(TileProperty property : properties){
            if(property.getLabel().equals(label)){
                return property;
            }
        }
        return null;
    }

    public ArrayList<TileProperty> getProperties(){
        return properties;
    }
    
    public void setTimeLeft(int timeLeft){
        this.timeLeft = timeLeft;
    }
    
    public int getTimeLeft(){
        return timeLeft;
    }
    
    public void setTimer(Timer timer){
        this.timer = timer;
    }

    public Timer getTimer(){
        return timer;
    }
    
    public void setX(int x){
        this.x.set(x);
    }

    public IntegerProperty getXProperty(){
        return x;
    }
    
    public int getX(){
        return x.get();
    }
    
    public void setY(int y){
        this.y.set(y);
    }

    public IntegerProperty getYProperty(){
        return y;
    }
    
    public int getY(){
        return y.get();
    }
    
    public void setPause(int pause){
        this.pause = pause;
    }

    public int getPause(){
        return pause;
    }

    public String toString(){
        return nickname + color + figure + id + money + turn + properties + timeLeft + timer + x + y + pause + super.toString();   
    }
}