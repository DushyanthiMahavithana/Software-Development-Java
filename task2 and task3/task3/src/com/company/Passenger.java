package com.company;

public class Passenger {
    protected String firstname;
    protected String surname;
    protected int expenses;

    public Passenger(String firstname, String surname, int expenses) {
        this.firstname = firstname;
        this.surname = surname;
        this.expenses = expenses;
    }

    //setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    //getters
    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    public int getExpenses() {
        return expenses;
    }

    @Override
    public String toString() {
        return " firstName= "+ firstname+ ", sureName= " + surname+", expenses= " + expenses;
    }

}


