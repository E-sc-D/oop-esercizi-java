package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

    private final double TRANSACTION_FEE = 0.1;
    public ExtendedStrictBankAccount(int id, double amount){
        super( id, amount);
    }

    private boolean isWithdrawAllowed(double amount){
        return (amount <= this.getBalance());
    }

    @Override
    public void withdraw(final int id, final double amount) {
        if(isWithdrawAllowed(amount)){
            super.withdraw(id, amount);
        }
    }
    @Override
    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + this.getTransactionsCount() * TRANSACTION_FEE;
        if (checkUser(id) && isWithdrawAllowed(feeAmount)) {
            this.setBalance(this.getBalance() - feeAmount);
            resetTransactions();
        }
    }
    
}
