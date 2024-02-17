package it.unibo.bank.impl;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static it.unibo.bank.impl.SimpleBankAccount.MANAGEMENT_FEE;
import static it.unibo.bank.impl.StrictBankAccount.TRANSACTION_FEE;

public class TestStrictBankAccount {

    private final static int INITIAL_AMOUNT = 100;
    private final static int NEGATIVE_AMOUNT = -100;
    private final static int DEFAULT_ID = 1;
    // 1. Create a new AccountHolder and a StrictBankAccount for it each time tests are executed.
    private AccountHolder mRossi;
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        mRossi = new AccountHolder("Mario", "rossi", DEFAULT_ID);
        bankAccount = new StrictBankAccount(mRossi, INITIAL_AMOUNT);
    }

    // 2. Test the initial state of the StrictBankAccount
    @Test
    public void testInitialization() {
        Assertions.assertEquals(mRossi, bankAccount.getAccountHolder());
        Assertions.assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
        Assertions.assertEquals(0, bankAccount.getTransactionsCount());
    }


    // 3. Perform a deposit of 100€, compute the management fees, and check that the balance is correctly reduced.
    @Test
    public void testManagementFees() {
        bankAccount.chargeManagementFees(mRossi.getUserID());
        Assertions.assertEquals(
            INITIAL_AMOUNT - (MANAGEMENT_FEE + bankAccount.getTransactionsCount() * TRANSACTION_FEE),
            bankAccount.getBalance()
        );
    }

    // 4. Test the withdraw of a negative value
    @Test
    public void testNegativeWithdraw() {
        try{
            bankAccount.withdraw(mRossi.getUserID(),NEGATIVE_AMOUNT);
            Assertions.fail("should throw a ( Cannot withdraw a negative amount ) exception");
        } catch(IllegalArgumentException e){
            Assertions.assertEquals("Cannot withdraw a negative amount", e.getMessage());
        }
        
    }

    // 5. Test withdrawing more money than it is in the account
    @Test
    public void testWithdrawingTooMuch() {
        try {
            bankAccount.withdraw(mRossi.getUserID(), INITIAL_AMOUNT);
            Assertions.fail("should throw an Insufficient balance exception");
        } catch (Exception e) {
            Assertions.assertEquals("Insufficient balance", e.getMessage());
        }
    }
}
