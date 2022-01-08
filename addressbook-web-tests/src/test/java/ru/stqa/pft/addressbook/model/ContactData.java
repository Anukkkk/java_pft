package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contacts")
public class ContactData {
    @Expose
    private String firstName;
    @Expose
    private String secondName;
    @Expose
    private String surname;
    private String nickName;
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    private int groupIndex;
    private String workPhone;
    private String homePhone;
    private String mobilePhone;
    private String phone2;
    private String email;
    private String email2;
    private String email3;
    private String postAddress;
    private String AllPhones;
    private String AllEmails;
    private File photo;

    public String getPhone2() {
        return phone2;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getAllEmails() {
        return AllEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.AllEmails = allEmails;
        return this;
    }

    public String getAllPhones() {
        return AllPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.AllPhones = allPhones;
        return this;
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

    public String getWorkPhone() { return workPhone;}

    public String getHomePhone() {return homePhone;}

    public String getMobilePhone() {return mobilePhone;}

    public String getEmail() {return email;}

    public String getPostAddress() {return postAddress;}

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

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, id);
    }

    public ContactData withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ContactData withGroupIndex(int groupIndex) {
        this.groupIndex = groupIndex;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.homePhone = home;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobilePhone = mobile;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.workPhone = work;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }



    public ContactData withPostAddress(String postAddress) {
        this.postAddress = postAddress;
        return this;
    }


}
