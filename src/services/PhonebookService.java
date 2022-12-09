package services;

import data.models.Contact;

public interface PhonebookService {
    void register();
    void addContact();
    Contact findContact();
    void delete();
    void updateContact();
}
