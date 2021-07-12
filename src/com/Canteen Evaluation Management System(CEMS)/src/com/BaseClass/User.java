package com.BaseClass;

import com.DAO.BaseDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class User {
    private String uId;
    private String uName;
    private int uPms;
    private String passWord;
    private String uQuestion;
    private String uAnswer;

    public User(String uId, String uName, int uPms, String passWord, String uQuestion, String uAnswer) {
        this.uId = uId;
        this.uName = uName;
        this.uPms = uPms;
        this.passWord = passWord;
        this.uQuestion = uQuestion;
        this.uAnswer = uAnswer;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuPms() {
        return uPms;
    }

    public void setuPms(int uPms) {
        this.uPms = uPms;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getuQuestion() {
        return uQuestion;
    }

    public void setuQuestion(String uQuestion) {
        this.uQuestion = uQuestion;
    }

    public String getuAnswer() {
        return uAnswer;
    }

    public void setuAnswer(String uAnswer) {
        this.uAnswer = uAnswer;
    }
}