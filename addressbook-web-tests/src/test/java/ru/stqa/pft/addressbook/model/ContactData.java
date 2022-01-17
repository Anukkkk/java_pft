package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contacts")
@Entity
@Table(name = "addressbook")
public class ContactData{

    @Expose
    @Column(name = "firstname")
    private String firstName;
    @Expose
    @Transient
    private String secondName;
    @Expose
    @Column(name = "lastname")
    private String surname;
    private String nickName;
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;


   // @Transient
   // private int groupIndex;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Transient
    private String phone2;
    @Transient
    private String email;
    @Transient
    private String email2;
    @Transient
    private String email3;
    @Transient
    private String postAddress;

    @Transient
    private String AllPhones;

    @Transient
    @Type(type = "text")
    private String AllEmails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public Groups getGroups() {
        return new Groups(groups);
    }

    public String getPhone2() {
        return phone2;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
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

    public String getWorkPhone() { return workPhone;}

    public String getHomePhone() {return homePhone;}

    public String getMobilePhone() {return mobilePhone;}

    public String getEmail() {return email;}

    public String getPostAddress() {return postAddress;}

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

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return surname != null ? surname.equals(that.surname) : that.surname == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public ContactData withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }

    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withNickName(String nickName) {
        this.nickName = nickName;
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
