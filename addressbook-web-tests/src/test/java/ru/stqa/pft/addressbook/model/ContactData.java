package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String secondName;
    private final String surname;
    private final String nickName;
    private final int id;
    private int groupIndex;

    public ContactData(String firstName, String secondName, String surname, String nickName, int groupIndex) {
        this.id = 0;
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
}
