package data.repositories;

import data.models.Phonebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookRepositoryImplTest {
    PhonebookRepository phonebookRepository;
    @BeforeEach
    public void setup(){
        phonebookRepository = new PhonebookRepositoryImpl();
    }

        @Test
        public void savePhoneBookTotalPhoneBookIsOneTest(){
            //given I have a new repository
            // when I try to save a contact
            // assert equals count is 1
            PhonebookRepository phonebookRepository = new PhonebookRepositoryImpl();
            Phonebook amirah = new Phonebook();
            phonebookRepository.save(amirah);
            assertEquals(1, phonebookRepository.count());

        }
        @Test
    public void savePhoneBookFindByIdReturnSavedPhonebook(){
            //given that i have a new phone book repo
            //when I save to a new phonebook
            //and when i find by id
            //assert that phonebook is equals to saved phonebook
            Phonebook amirahPhoneBook = new Phonebook();
            amirahPhoneBook.setOwnerPhoneNumber("9900");
            amirahPhoneBook.setOwnersName("Amirah");
            phonebookRepository.save(amirahPhoneBook);
            Phonebook savedPhonebook = phonebookRepository.findById("9900");
            assertEquals(amirahPhoneBook, savedPhonebook);
            assertEquals("Amirah", savedPhonebook.getOwnersName());

        }
        @Test
        public void updatePhoneBookFindByIdReturnUpdatedPhonebook(){
            //given that i have a new phone book repo
            //when I save  a new phonebook
            //and when i update
            //assert that phonebook details has been updated
            Phonebook amirahPhoneBook = new Phonebook();
            amirahPhoneBook.setOwnerPhoneNumber("9900");
            amirahPhoneBook.setOwnersName("Amirah");
            phonebookRepository.save(amirahPhoneBook);
            Phonebook updatedPhoneBook = new Phonebook();
            updatedPhoneBook.setOwnerPhoneNumber("9900");
            updatedPhoneBook.setOwnersName("Rofiat");
            phonebookRepository.save(updatedPhoneBook);
            Phonebook savedPhonebook = phonebookRepository.findById("9900");
            assertEquals(1, phonebookRepository.count());
            assertEquals("Rofiat", savedPhonebook.getOwnersName());


    }
    @Test
    public void deletePhoneBookFindByIdReturnNullPhonebook(){
        //given that i have a new phone book repo
        //when I save  a new phonebook
        //and when i update
        //assert that phonebook details has been updated
        Phonebook amirahPhoneBook = new Phonebook();
        amirahPhoneBook.setOwnerPhoneNumber("9900");
        amirahPhoneBook.setOwnersName("Amirah");
        phonebookRepository.save(amirahPhoneBook);
        Phonebook rofiatPhoneBook = new Phonebook();
        rofiatPhoneBook.setOwnerPhoneNumber("9908");
        rofiatPhoneBook.setOwnersName("Rofiat");
        phonebookRepository.save(rofiatPhoneBook);
        phonebookRepository.delete(amirahPhoneBook);
        phonebookRepository.delete(rofiatPhoneBook);
        Phonebook savedPhonebook = phonebookRepository.findById("9908");
        assertEquals(0, phonebookRepository.count());
        assertNull(savedPhonebook);

}
}

