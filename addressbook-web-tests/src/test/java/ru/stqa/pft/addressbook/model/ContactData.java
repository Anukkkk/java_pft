package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firstName;
    private final String secondName;
    private final String surname;
    private final String nickName;
    private int id;
    private int groupIndex;

    public ContactData(String firstName, String secondName, String surname, String nickName, int groupIndex) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.nickName = nickName;
        this.groupIndex = groupIndex;
    }

    public ContactData(int id, String firstname, String surname) {
        this.id = id;
        this.firstName = firstname;
        this.surname = surname;
        this.nickName = null;
        this.secondName = null;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickName() {
        return nickName;
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", nickName='" + nickName + '\'' +
                ", id=" + id +
                ", groupIndex=" + groupIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname);
    }

    public void setId(int id) {
        this.id = id;
    }
}
