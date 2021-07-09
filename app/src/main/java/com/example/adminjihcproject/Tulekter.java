package com.example.adminjihcproject;

public class Tulekter {
    String name;
    String prof;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Tulekter(String name, String prof, String year) {
        this.name = name;
        this.prof = prof;
        this.year = year;
    }
    public Tulekter(){}

    String year;
}
