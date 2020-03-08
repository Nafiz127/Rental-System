public class Game extends Media {
  
  // Field variables
  private String platform;
  private String rating;
  private int discs;
  private boolean online;
  
  // Constructor method
  public Game(String name, int year, String platform, String rating, int discs, boolean online) {
    super(name, year);
    this.platform = platform;
    this.rating = rating;
    this.discs = discs;
    this.online = online;
    
  }
  
  // Getter methods
  public String getPlatform() {return this.platform;}
  
  public String getRating() {return this.rating;}
  
  public int getDiscs() {return this.discs;}
  
  public boolean isOnline() {return this.online;}
  
  @Override
  public String toString() {
    // Using Media's toString
    if (this.online == false)
      return super.toString() + String.format(" %s [%s, %d discs]", this.platform, this.rating, this.discs);
    else
      return super.toString() + String.format(" %s [%s, %d discs, online]", this.platform, this.rating, this.discs);
                                      
  }
  
  
}