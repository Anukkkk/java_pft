package ru.stqa.pft.addressbook;

public class ContactData {
    private final String firstName;
    private final String secondName;
    private final String surname;
    private final String nickName;

    public ContactData(String firstName, String secondName, String surname, String nickName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.nickName = nickName;
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
}
