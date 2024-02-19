package it.unibo.composition;

public class Professor implements User{

    private String name;
    private String surname;
    private int id;
    private String password;
    private String[] courses;
    
    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public String getPassword() {
       return this.password;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public void replaceCourse(final int id, final String course){
        this.courses[id] = course; 
    }

    public void replaceAllCourses(final String[] courses ){
        this.courses = courses;
    }
    
    public Professor(String name, String surname, int id, String password, String[] courses) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.password = password;
        this.courses = courses;
    }

    
    

    
    
}
