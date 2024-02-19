package it.unibo.encapsulation.interfaces;

public class SimpleBankAccount implements BankAccount {

    private double balance;
    private int transactions;
    private static double ATM_TRANSACTION_FEE = 1;
    private static double MANAGEMENT_FEE = 5;
    private final int id;

    /*
     * Creare un costruttore pubblico che prenda in ingresso un intero (ossia l'id
     * dell'utente) ed un double (ossia, l'ammontare iniziale del conto corrente).
     */

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public int getTransactionsCount() {
        return transactions;
    }

    public void setTransactions(final int transactions) {
        this.transactions = transactions;
    }
    public int getId() {
        return id;
    }

    public SimpleBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
    }

    /*
     * Si aggiungano selettori per:
     * - ottenere l'id utente del possessore del conto
     * - ottenere il numero di transazioni effettuate
     * - ottenere l'ammontare corrente del conto.
     */
    

    public void deposit(final int id, final double amount) {

        if(id == this.id){
            this.setTransactions( this.getTransactionsCount() + 1);
            this.setBalance(this.getBalance() + amount);
        }
        
        
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto Nota: il deposito va a buon fine solo se l'id utente
         * corrisponde
         */
    }

    public void withdraw(final int id, final double amount) {

        deposit(id, -amount);
        /*
         * Incrementa il numero di transazioni e rimuove amount al totale del
         * conto. Note: - Il conto puo' andare in rosso (ammontare negativo) -
         * Il prelievo va a buon fine solo se l'id utente corrisponde
         */
    }

    public void depositFromATM(final int id, final double amount) {

        deposit(id, amount - ATM_TRANSACTION_FEE); 
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto detraendo le spese (costante ATM_TRANSACTION_FEE) relative
         * all'uso dell'ATM (bancomat) Nota: il deposito va a buon fine solo se
         * l'id utente corrisponde
         */
    }

    public void withdrawFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount + le spese
         * (costante ATM_TRANSACTION_FEE) relative all'uso dell'ATM (bancomat)
         * al totale del conto. Note: - Il conto puo' andare in rosso (ammontare
         * negativo) - Il prelievo va a buon fine solo se l'id utente
         * corrisponde
         */

        deposit(id, -amount - ATM_TRANSACTION_FEE);
    }

    public void chargeManagementFees(final int id) {
        /*
         * Riduce il bilancio del conto di un ammontare pari alle spese di gestione
         */

    }
}
