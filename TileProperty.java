 public class TileProperty extends TileBase {
    private int price;
    private Player owner;
    private String group;
    private boolean papez;
    private boolean shop;
    private int level;
    private int rent;
    private int upgrade;
    
    public TileProperty(int price, Player owner, String group,  boolean papez, boolean shop, int level, int rent, int upgrade, int id, String label, int x, int y, boolean vertical){
        super(id, label, x, y, vertical);
        this.price = price;
        this.owner = owner;
        this.group = group;
        this.papez = papez;
        this.shop = shop;
        this.level = level;
        this.rent = rent;
        this.upgrade = upgrade;
    }

    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public Player getOwner(){
        return owner;
    }
    
    public void setOwner(Player owner){
        this.owner = owner;
    }
    
    public String getGroup(){
        return group;
    }

    public void setGroup(String group){
        this.group = group;
    }
    
    public boolean getPapez(){
        return papez;
    }

    public void setPapez(boolean papez){
        this.papez = papez;
    }
    
    public boolean getShop(){
        return shop;
    }

    public void setShop(boolean shop){
        this.shop = shop;
    }
    
    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
    
    public int getRent(){
        return rent;
    }

    public void setRent(int rent){
        this.rent = rent;
    }
    
    public int getUpgrade(){
        return upgrade;
    }
    
    public void setUpgrade(int upgrade){
        this.upgrade = upgrade;
    }

    public String toString(){
        if(owner != null){
            return price + owner.getId() + group  + papez + shop + level + rent + super.toString();    
        } 
        return price + "null" + group  + papez + shop + level + rent + super.toString();
    }    
}
