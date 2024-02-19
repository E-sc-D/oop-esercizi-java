package it.unibo.composition;

import java.util.Arrays;

public class Exam {
    
    private int id;
    private int maxStudents;
    private int registeredStudents;
    private String courseName;
    private Professor professor;
    private ExamRoom room;
    private Student[] students;

    public Exam(int id, int maxStudents, int registeredStudents, String courseName, Professor professor, ExamRoom room) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.registeredStudents = registeredStudents;
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = new Student[maxStudents];
    }
    public int getId() {
        return id;
    }
    public void setId(final int id) {
        this.id = id;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public void setMaxStudents(final int maxStudents) {
        this.maxStudents = maxStudents;
    }
    public int getRegisteredStudents() {
        return registeredStudents;
    }
    public void setRegisteredStudents(final int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(final String courseName) {
        this.courseName = courseName;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(final Professor professor) {
        this.professor = professor;
    }
    public ExamRoom getRoom() {
        return room;
    }
    public void setRoom(final ExamRoom room) {
        this.room = room;
    }
    public Student[] getStudents() {
        return students;
    }
    public void setStudents(final Student[] students) {
        this.students = students;
    }

    public void registerStudent(final Student student){
        if(this.students.length >= maxStudents){
            students[registeredStudents] = student;
            registeredStudents = registeredStudents + 1;
        }
    }

    public String toString(){

        return Arrays.toString(students);
    }
}
