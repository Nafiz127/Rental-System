public class Video extends Media {
  
  // Declaring field variables
  public static final int DVD = 0;
  public static final int BLURAY = 1;
  private int runtime;
  private String rating;
  private int format;
  
  public Video(String name, int year, int runtime, String rating, int format) {
   super(name, year); // using Media constructor
   this.runtime = runtime;
   this.rating = rating;
   this.format = format;
    
  }
  
  public int getRuntime() {return this.runtime;}
  
  public String getRating() {return this.rating;}
  
  public int getFormat() {return this.format;}
  
  @Override
  public String toString() {
    if (this.format == 0)            // Using Media toString and concatenating.
       return super.toString() + String.format(" DVD [%s, %d min]", this.rating, this.runtime);
    
    else 
       return super.toString() + String.format(" BLURAY [%s, %d min]", this.rating, this.runtime);
    
  }
  

  
}