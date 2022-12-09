package services;

import data.models.Contact;
import data.models.Phonebook;
import data.repositories.PhonebookRepository;
import data.repositories.PhonebookRepositoryImpl;

public class PhonebookServiceImpl  implements PhonebookService {
    PhonebookRepository phonebookRepository = new PhonebookRepositoryImpl();

    @Override
    public void register(String ownersName, String ownersPhoneNumber) {
        Phonebook savedPhonebook = phonebookRepository.findById(ownersPhoneNumber);
        if (savedPhonebook != null) throw new IllegalArgumentException("User already exist");
        Phonebook newPhonebook = new Phonebook();
        newPhonebook.setOwnerPhoneNumber(ownersPhoneNumber);
        newPhonebook.setOwnersName(ownersName);
        phonebookRepository.save(newPhonebook);
    }

    @Override
    public void addContact(String ownersPhoneNumber, String firstName, String lastName, String phoneNumber) {

    }

    @Override
    public Contact findContact(String ownersPhoneNumber, String phoneNumberToSearchFor) {
        return null;
    }

    @Override
    public int countNumberOfUser() {
        return phonebookRepository.count();
    }
}
