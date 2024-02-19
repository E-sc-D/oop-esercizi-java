package it.unibo.constructors;

class UseConstructors {

    public static void main(final String[] args) {
        // NB: Per verificare la correttezza dei costruttori implementati
        // stampare a video le informazioni relative agli studenti (metodo
        // printStudentInfo) e ai treni (a tal fine implementare un metodo
        // printTrainInfo nella classe Train).

        Student student1 = new Student("Mario", "Rossi", 1014, 2013);
        Student student2 = new Student("Luca", "Bianchi", 1018, 2010);
        Student student3 = new Student("Peppino", "Vitiello", 1019, 2012);
        Student student4 = new Student("Luca", "Verdi", 1020, 2013);

        Train treno1 = new Train(300, 100, 200);
        Train treno2 = new Train(1200, 50, 1150);
        Train treno3 = new Train(500, 0, 500);
        Train treno4 = new Train();

        student1.printStudentInfo();
        student2.printStudentInfo();
        student3.printStudentInfo();
        student4.printStudentInfo();

        treno1.printTrainInfo();
        treno2.printTrainInfo();
        treno3.printTrainInfo();
        treno4.printTrainInfo();
        
        // 1) Creare lo studente Mario Rossi, matricola 1014, anno
        // immatricolazione 2013

        // 2) Creare lo studente Luca Bianchi, matricola 1018, anno
        // immatricolazione 2010

        // 3) Creare lo studente Peppino Vitiello, matricola 1019, anno
        // immatricolazione 2012

        // 4) Creare lo studente Luca Verdi, matricola 1020, anno
        // immatricolazione 2013

        // 5) Creare un treno con 300 posti di cui 100 in prima classe 200 in
        // seconda classe

        // 6) Creare un treno con 1200 posti di cui 50 in prima classe 1050 in
        // seconda classe

        // 7) Creare un treno con 500 posti, tutti di seconda classe

        // 8) Creare un treno con numero di posti di default

        // 9) Verificare che il numero di posti
        // di default sia consistente (ossia che ci sia un numero positivo di
        // posti totali, e che la somma dei posti in prima e seconda classe dia
        // il totale dei posti sul treno).
    }
}
