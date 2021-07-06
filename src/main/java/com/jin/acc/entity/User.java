package com.jin.acc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String profile;
    private String sex;
    private String nickname;

    public User() {

    }

    public User(int id, String username, String password, String email, String phone, Date birthday, String profile, String sex,String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.profile = profile;
        this.sex = sex;
        this.nickname=nickname;
    }

    public String formatBirthday(){
        String FormatDate=null;
        DateFormat dFormat = new SimpleDateFormat("YYYY-MM-dd");
        FormatDate=dFormat.format(birthday);
        if(birthday==null||FormatDate==null)System.out.println("birthday:"+birthday+",formatDate="+FormatDate);
        return  FormatDate;
    }

    public void sets(User temp){
        this.profile=temp.getProfile();
        this.nickname=temp.getNickname();
        this.password=temp.getPassword();
        this.email=temp.getEmail();
        this.phone=temp.getPhone();
        this.birthday=temp.getBirthday();
        this.sex=temp.getSex();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
