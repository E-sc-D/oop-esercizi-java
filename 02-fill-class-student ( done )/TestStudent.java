class TestStudent {

    public static void main(String[] args) {

        Student Alex = new Student();
	Student Angel = new Student();
	Student Andrea = new Student();

        Alex.build("Alex","Balducci",1015,2019);
	Angel.build("Angel","Bianchi",1016,2018);
	Andrea.build("Andrea","Bracci",1017,2017);

        Alex.printStudentInfo();
	Angel.printStudentInfo();
	Andrea.printStudentInfo();

	
    }
}
