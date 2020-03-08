public class Payment {
  
  // Field variables
  private String cardNo;
  private String name;
  private int expMonth;
  private int expYear;
  
  //Constructor Method
  public Payment(String cardNo, String name, int expMonth, int expYear) {
    this.cardNo = cardNo;
    this.name = name;
    this.expMonth = expMonth;
    this.expYear = expYear;
  }
  
  // Getter methods
  public String getCardNo() {return this.cardNo;}
  
  public String getName() {return this.name;}
  
  public int getExpMonth() {return this.expMonth;}
  
  public int getExpYear() {return this.expYear;}
  
  // toString method
  @Override
  public String toString() {
    return String.format("#%s (%s), exp %d/%d", this.cardNo, this.name, this.expMonth, this.expYear);
  }
  

  
}