package services;

import data.models.Contact;

public interface PhonebookService {
    void register(String ownersName, String ownersPhoneNumber);
    void addContact(String ownersPhoneNumber, String firstName, String lastName, String phoneNumber );
    Contact findContact(String ownersPhoneNumber, String phoneNumberToSearchFor);
    void delete();
    void updateContact();
}
