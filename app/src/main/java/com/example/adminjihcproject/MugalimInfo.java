package com.example.adminjihcproject;

public class MugalimInfo {







    String MugalimEmail;
    String MugalimId;
    String MugalimName;
    String MugalimSabaq;

    public String getMugalimEmail() {
        return MugalimEmail;
    }

    public void setMugalimEmail(String mugalimEmail) {
        MugalimEmail = mugalimEmail;
    }

    public String getMugalimId() {
        return MugalimId;
    }

    public void setMugalimId(String mugalimId) {
        MugalimId = mugalimId;
    }

    public String getMugalimName() {
        return MugalimName;
    }

    public void setMugalimName(String mugalimName) {
        MugalimName = mugalimName;
    }

    public String getMugalimSabaq() {
        return MugalimSabaq;
    }

    public void setMugalimSabaq(String mugalimSabaq) {
        MugalimSabaq = mugalimSabaq;
    }

    public String getMugalimToby() {
        return MugalimToby;
    }

    public void setMugalimToby(String mugalimToby) {
        MugalimToby = mugalimToby;
    }

    public String getMugalimpassword() {
        return Mugalimpassword;
    }

    public void setMugalimpassword(String mugalimpassword) {
        Mugalimpassword = mugalimpassword;
    }

    String MugalimToby;

    public MugalimInfo(String mugalimEmail, String mugalimId, String mugalimName, String mugalimSabaq, String mugalimToby, String mugalimpassword) {
        MugalimEmail = mugalimEmail;
        MugalimId = mugalimId;
        MugalimName = mugalimName;
        MugalimSabaq = mugalimSabaq;
        MugalimToby = mugalimToby;
        Mugalimpassword = mugalimpassword;
    }

    String Mugalimpassword;




    public MugalimInfo(){}


}
