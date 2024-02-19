class Student {

	String name;	
	String surname;
	int id;
	int matriculationYear;
    // È buona pratica mettere i campi in testa alla classe

    void build(String name, String surname, int id, int matriculationYear) {

        this.name = name;
	this.surname = surname;
	this.id = id;
	this.matriculationYear = matriculationYear;

    }

    void printStudentInfo() {
        
	System.out.println("name: " + this.name + " ; surname: " + this.surname + " ; id: " + this.id + " ; matriculationYear: " + this.matriculationYear );
    }
}
