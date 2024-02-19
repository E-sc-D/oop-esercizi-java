package it.unibo.encapsulation.interfaces;

public class StriktBankAccount implements BankAccount{

    /**
     *
     */
    private static final int FIXED_COST = 5;
    private double balance;
    private int transactions;
    private static double ATM_TRANSACTION_FEE = 1;
    private static double MANAGEMENT_FEE = 5;
    private final int id;
    private int i;


    public void setTransactions(final int transactions) {
        this.transactions = transactions;
    }
    public int getId() {
        return id;
    }

    
    @Override
    public void setBalance(final double balance) {
        this.balance = balance;
    }
    
    @Override
    public void withdraw(int id, double amount) {
        if(amount <= this.getBalance()){
            deposit(id, amount);
        }
    }

    @Override
    public void deposit(int id, double amount) {
        if(id == this.id ){
            this.setTransactions( this.getTransactionsCount() + 1);
            this.setBalance(this.getBalance() + amount);
        }
    }

    @Override
    public void depositFromATM(int id, double amount) {
        
        deposit(id, amount - ATM_TRANSACTION_FEE + 0.1 );
    }

    @Override
    public void withdrawFromATM(int id, double amount) {
        withdraw(id, amount - ATM_TRANSACTION_FEE + 0.1 );
    }

    @Override
    public void chargeManagementFees(int id) {
        withdraw(id, FIXED_COST);
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public int getTransactionsCount() {
        return this.transactions;
    }
    
    public StriktBankAccount(final int id,final int balance){
        this.balance = balance;
        this.id = id;
    }


    
    
}
