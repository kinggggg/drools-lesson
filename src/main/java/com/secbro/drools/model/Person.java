package com.secbro.drools.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuzs on 2017/8/12.
 */
public class Person implements Serializable{

    //年龄
    private int age;

    //工资
    private long salary;

    //租金
    private float rent;

    //余额
    private double balance;

    //是否成年 '0' 未成年 '1' 已成年
    private char adult;

    //性别 0 男 1 女
    private byte gender;

    //是否结婚 true 结婚 false 未婚
    private boolean marry;

    //姓名
    private String name;

    //出生日期
    private Date bornDate;

    private String test$;

    public String getTest$() {
        return test$;
    }

    public void setTest$(String test$) {
        this.test$ = test$;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public float getRent() {
        return rent;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public char getAdult() {
        return adult;
    }

    public void setAdult(char adult) {
        this.adult = adult;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public boolean isMarry() {
        return marry;
    }

    public void setMarry(boolean marry) {
        this.marry = marry;
    }
}
