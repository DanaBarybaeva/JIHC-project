package com.example.adminjihcproject;

public class StudentsUser {
    String nameStudent;

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getKuratorStudent() {
        return kuratorStudent;
    }

    public void setKuratorStudent(String kuratorStudent) {
        this.kuratorStudent = kuratorStudent;
    }

    public Long getIinStudent() {
        return iinStudent;
    }

    public void setIinStudent(Long iinStudent) {
        this.iinStudent = iinStudent;
    }

    public String getTobyStudent() {
        return tobyStudent;
    }

    public void setTobyStudent(String tobyStudent) {
        this.tobyStudent = tobyStudent;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public StudentsUser(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentsUser(String nameStudent, Long idStudent, String kuratorStudent, Long iinStudent, String tobyStudent, String email, String password) {
        this.nameStudent = nameStudent;
        this.idStudent = idStudent;
        this.kuratorStudent = kuratorStudent;
        this.iinStudent = iinStudent;
        this.tobyStudent = tobyStudent;
        this.password = password;
        this.email = email;
    }



    Long idStudent;
    String kuratorStudent;
    Long iinStudent;
    String tobyStudent;
    String email;
    String password;
}
