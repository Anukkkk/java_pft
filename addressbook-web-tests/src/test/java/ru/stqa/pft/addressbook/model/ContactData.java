package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String secondName;
    private final String surname;
    private final String nickName;
    private int group;

    public ContactData(String firstName, String secondName, String surname, String nickName, int group) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.nickName = nickName;
        this.group = group;
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

    public int getGroup() {
        return group;
    }
}
