package data.repositories;

import data.models.Contact;

public interface ContactRepository {
    Contact findById(String name);
    Contact save(Contact contact);
    void delete(Contact contact);
    int count();
}
