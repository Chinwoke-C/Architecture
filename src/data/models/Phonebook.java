package data.models;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private String ownersName;
    private String OwnerPhoneNumber;
    private List<Contact> contacts = new ArrayList<>();

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getOwnerPhoneNumber() {
        return OwnerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.OwnerPhoneNumber = ownerPhoneNumber;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
