package com.example.adminjihcproject;

public class Zhinalys {
    String data;
    String time;
    String participants;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Zhinalys(String data, String time, String place, String participants) {
        this.data = data;
        this.time = time;
        this.place = place;
        this.participants = participants;
    }
    public Zhinalys(){}

    String place;
}
