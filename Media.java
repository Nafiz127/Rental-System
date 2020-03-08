public class Media {
  
  private String name; // declaring field variabes
  private int year;
  
  public Media(String name, int year) {      // constructor method
    this.name = name;
    this.year = year;
    
  }
  
  public String getName() {return this.name;}
  
  public int getYear() {return this.year;}
  
  @Override 
  public boolean equals(Object other) {
    if (other instanceof Media) {
      Media media = (Media)other; // casting the object as a media if it's an instance of media
    
      if ((this.name == media.name) && (this.year == media.year)) // Are they the same?
         return true;
      else
         return false;
    }
    
    return false;      // If not an instance of media return false

  }
  
  @Override
  public int hashCode() {return getName().hashCode();}
  
  @Override
  public String toString() {
    return String.format("%s (%d)", this.name, this.year);
  }
  

  
  
}