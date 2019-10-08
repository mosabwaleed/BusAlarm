package com.example.gl_zarqa_imac8.busalarm;

public class Profile {
    private String password;
    private String fullName;
    private String s_no;
    private String major;
    private String city;

    public Profile(String password, String fullName, String s_no, String major, String city) {
        this.password = password;
        this.fullName = fullName;
        this.s_no = s_no;
        this.major = major;
        this.city = city;
    }

    public String getPassword() {
        return password;
    }
    public String getFullName() {
        return fullName;
    }
    public String getS_no() {
        return s_no;
    }
    public String getMajor() {
        return major;
    }
    public String getCity() {
        return city;
    }
}
