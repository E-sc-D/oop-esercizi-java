package it.unibo.inheritance.impl;
import it.unibo.inheritance.api.AbstractBankAccount;
import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount{


    public ClassicBankAccount(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected boolean isWithDrawAllowed(double amount) {
        return false;
    }

    @Override
    protected double computeFee() {
        return MANAGEMENT_FEE;
    }
    
}
