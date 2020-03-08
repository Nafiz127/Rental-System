import java.time.*;
public class Rental {
  
  // Field objects
  private Media media;
  private Payment payment;
  private LocalDate today;
  private double fee;
  private boolean status;
  private boolean completion = false;
  private LocalDate returnDate;
  
  // Constructor method
  public Rental(Media media, Payment payment, LocalDate today, double fee) {
    this.media = media;
    this.payment = payment;
    this.today = today;
    this.fee = fee;
  }
  
  // Getter methods
  public Media getMedia() {return this.media;}
  
  public Payment getPayment() {return this.payment;}
  
  public LocalDate getRentDate() {return this.today;}
  
  public double getFee() {return this.fee;}
  
  // ----------------------------------------
  public double dropoff(LocalDate today) {
    completion = true;  // Shows that dropoff was called
    
    if (isRented()) {    // Drop off has not been called yet
      return getTotalFee(this.today);
    }
    else {                            // If not dropped off
      returnDate = today;
      return getTotalFee(returnDate);
    }
  }
  
  public boolean isRented() {
    if (completion == false) // Dropoff has not called yet
      return true;
    else
      return false; // dropoff has been called
  }
  
  public int daysRented(LocalDate today) {
    if (isRented() == false) { // If already dropped off
      return Period.between(this.today, returnDate).getDays();
    }
    else { // If it hasn't been dropped off. 
      return Period.between(this.today, today).getDays();
  }
  }
  
  public double getTotalFee(LocalDate today) {
    return this.fee;
  }
  
  @Override
  public String toString() {
    return String.format("%s, rented on %s using %s", this.media, this.today, this.payment);
  }
 
  
}
