import java.time.*;
public class DailyRental extends Rental {
  
  private double credit;
  
  // Constructor using super
  public DailyRental(Media media, Payment payment, LocalDate today, double fee, double credit) {
    super(media, payment, today, fee);
    this.credit = credit;
  }
  // Another constructor using super but sets credit to 0
  public DailyRental(Media media, Payment payment, LocalDate today, double fee) {
    super(media, payment, today, fee);
    this.credit = 0;
    
  }
  // Getter method
  public double getCredit() {return this.credit;}
  
  
  @Override
  public double getTotalFee(LocalDate today) {
    double price = super.getFee(); // Flat line fee
    int numDays = super.daysRented(today); // Number of days kept
    double total; // return value
    
    if (numDays < 1) {
      numDays = 1; // Less than a day will be 0
    }
    
    if ((numDays * price - this.credit) < 0)      // 0 is minimum bound
      return 0;
    else
      total = numDays * price - this.credit;
    
    return total;
    
  }
  
  
}