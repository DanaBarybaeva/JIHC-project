package com.example.adminjihcproject;

public class Mugalim {
    String name;
    String klassKurator;
    Long phoneNumber;
    String photo;

    public Mugalim(){

    }

    public Mugalim(String name, String klassKurator, Long phoneNumber, String photo) {
        this.name = name;
        this.klassKurator = klassKurator;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKlassKurator() {
        return klassKurator;
    }

    public void setKlassKurator(String klassKurator) {
        this.klassKurator = klassKurator;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
