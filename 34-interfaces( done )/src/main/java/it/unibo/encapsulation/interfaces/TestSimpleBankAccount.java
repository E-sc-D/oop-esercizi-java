package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        AccountHolder user1 = new AccountHolder("Andrea", "rossi", 1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        AccountHolder user2 = new AccountHolder("Alex", "Bianchi", 2);

        // 3) Creare i due SimpleBankAccount corrispondenti
        SimpleBankAccount user1BankAccount = new SimpleBankAccount(1, 0);
        SimpleBankAccount user2BankAccount = new SimpleBankAccount(2, 0);
        // 4) Effettuare una serie di depositi e prelievi
        user1BankAccount.depositFromATM(1, 200);
        user2BankAccount.depositFromATM(1, 600);
        user1BankAccount.withdraw(1,300);
        user2BankAccount.depositFromATM(2,400);
        user1BankAccount.deposit(1,500);


        System.out.println("IL conto dell'utente con id " + user1BankAccount.getId() + " e uguale a : "+user1BankAccount.getBalance());
        System.out.println("IL conto dell'utente con id " + user2BankAccount.getId() + " e uguale a : "+user2BankAccount.getBalance());
        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        user1BankAccount.withdraw(2,200);
        System.out.println("IL conto dell'utente con id " + user2BankAccount.getId() + " e uguale a : "+user2BankAccount.getBalance());

        // 6) Provare a prelevare fornendo un id utente sbagliato

        // 7) Controllare nuovamente l'ammontare
    }
}
