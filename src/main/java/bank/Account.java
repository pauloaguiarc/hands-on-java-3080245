package bank;

public class Account {
  
  private int id;
  private double balance;
  private String type;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String accountType) {
    this.type = accountType;
  }

  public Account(int id, double balance, String accountType) {
    this.id = id;
    this.balance = balance;
    this.type = accountType;
  }
  
}
