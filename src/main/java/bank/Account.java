package bank;

import bank.exceptions.AmountException;

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

  public void deposit(Double amount) throws AmountException {
    if(amount < 1) {
      throw new AmountException("The minimum deposit is $1.00");
    }
    else {
      double newBalance = balance + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

  public void withdraw(Double amount) throws AmountException {
    if (amount < 0) {
      throw new AmountException("The withdrawal amount must be greater than $0.");
    }
    else if(amount > getBalance()) {
      throw new AmountException("You do not have sufficient funds for this withdrawal.");
    }
    else {
      double newBalance = balance - amount;
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

  public Account(int id, double balance, String accountType) {
    this.id = id;
    this.balance = balance;
    this.type = accountType;
  }
  
}
