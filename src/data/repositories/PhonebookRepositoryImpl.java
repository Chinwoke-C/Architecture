package data.repositories;

import data.models.Phonebook;

import java.util.ArrayList;

public class PhonebookRepositoryImpl implements PhonebookRepository{
    private ArrayList<Phonebook> phonebooks = new ArrayList<>();

    @Override
    public Phonebook findById(String phoneNumber) {
        for (Phonebook phonebook: phonebooks){
            String storedPhoneNumber = phonebook.getOwnerPhoneNumber();
            boolean phoneNumberMatches = storedPhoneNumber.equals(phoneNumber);
            if (phoneNumberMatches) return phonebook;
        }
        return null;
    }

    @Override
    public Phonebook save(Phonebook phonebook) {
        //check for phonebook
        //if it exist
        // else i want to create
        Phonebook savedPhonebook = findById(phonebook.getOwnerPhoneNumber());
        if(savedPhonebook == null) phonebooks.add(phonebook);
        else updateSavedPhoneBook(phonebook, savedPhonebook);
        return phonebook;
//        phonebooks.add(phonebook);
//
//        return phonebook;
    }

    private void updateSavedPhoneBook(Phonebook phonebook, Phonebook savedPhonebook) {
        savedPhonebook.setOwnersName(phonebook.getOwnersName());
        savedPhonebook.setContacts(phonebook.getContacts());
        savedPhonebook.setOwnerPhoneNumber(phonebook.getOwnerPhoneNumber());
    }

    @Override
    public void delete(Phonebook phonebook) {
        //check for phonebook
        //if it exists, I want to delete
        // else, it doesn't exist
        Phonebook savedPhoneBook = findById(phonebook.getOwnerPhoneNumber());
        if (savedPhoneBook != null) phonebooks.remove(phonebook);
        else throw new IllegalArgumentException("Contact does not exist");

    }

    @Override
    public int count() {
        return phonebooks.size();
    }
}
