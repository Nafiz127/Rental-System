import java.time.*;
public class RentalBox {
  
  private Media[] box; // this array represents the rental box
  
  // Constructor method with rental box of capacity amount
  public RentalBox (int capacity) {
    box = new Media[capacity];
  }
  // constructor method with rental box of total capacity of 100
  public RentalBox() {
    box = new Media[100];
  }
  
  // returns the total capacity in the rental unit
  public int boxCapacity() {return box.length;}
  
  // Returns a specific media slot from the rental box
  public Media get(int i) {
    return box[i];
  }
  
  // Looks for if a specific media is in stock in the rental unit
  public boolean inStock(Media m) {
    for (int i = 0; i < box.length; i++) {
      if (box[i].equals(m)) // If they match return true
        return true;
    }
    return false; // if there are no matches return false
  }
  
  // Puts a sepcific media item in the rental unit if there's space.
  public boolean put(Media m) {
    for (int i = 0; i < box.length; i++) {
      if (box[i] == null) {
        box[i] = m;
        return true;
      }
    }
    return false;
  }
  
  //  Creates a new rental class based on parameters and availability
  public Rental rent(Media m, Payment p, LocalDate d) {
     Media temp; // placeholder
     DailyRental dRental; // return value
     double fee = 0.0;
     
     for (int i = 0; i < box.length; i++) {
       if ((box[i]).equals(m)) { // If they match
         temp = box[i]; 
         fee = getDailyFee(temp);
         dRental = new DailyRental(temp, p, d, fee);
         box[i] = null; // replace matching media with null
         return dRental;
       }
     }
     return null;
  }
  
  // Prints a message indicating how much was charged.
  public void processPayment(Payment p, double amount) {
    System.out.printf("$%.2f paid by %s\n", amount, p); 
  }
  
  // Drops off current rental in rental unit if there's space
  public boolean dropoff(Rental r, LocalDate today) {
    Media temp = r.getMedia();
    Payment tempP = r.getPayment();
    double fee;
 
    if ((!this.inStock(temp)) && (this.put(temp))) { // There's space and not returned already
      fee = r.dropoff(today);                 // Drop off method and get total fee
      this.processPayment(tempP, fee);
      return true;
     }
    else
      return false; 
  }
  
  public double getDailyFee(Media m) {
    int format; // will hold the media format value
    if (m instanceof Video) {
      Video video = (Video)m;
      format = video.getFormat();
      if (format == 0)
        return 1.50;
      else if (format == 1)
        return 2.00;
  }
    else if (m instanceof Game)
      return 3.00;
    
    else
      return 0.00;
    
    return 0.00; // if format is neither 0 or 1
  }
  
  @Override public String toString() {
    String finalS = "";
    for (int i = 0; i < box.length; i++) {
      if (box[i] != null)
        finalS += box[i] + "\n";
    }
    return finalS;
  }
  
  public static void main(String[] args) {
    RentalBox r = new RentalBox();
    
    Payment p = new Payment("1111222233334444", "test", 11, 2222);
    double a = 1.23;
    
    r.processPayment(p, a);
    
  }

}