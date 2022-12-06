package data.repositories;

import data.models.Phonebook;

public interface PhonebookRepository {


     Phonebook findById(String phoneNumber);

    Phonebook save(Phonebook phonebook);
    void delete(Phonebook phonebook);
    int count();
}
