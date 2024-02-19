package it.unibo.inheritance.impl;
import it.unibo.inheritance.api.AbstractBankAccount;
import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount{

    public RestrictedBankAccount(AccountHolder holder, double balance) {
        super(holder, balance);
    }


    @Override
    protected boolean isWithDrawAllowed(double amount) {
        return (this.getBalance() >= amount);
    }

    @Override
    protected double computeFee() {
        return MANAGEMENT_FEE;
    }

    
}
