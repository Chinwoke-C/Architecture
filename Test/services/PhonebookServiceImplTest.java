package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookServiceImplTest {
    @Test
    public void registerUserTest(){
        PhonebookService phonebookService = new PhonebookServiceImpl();
        phonebookService.register("Amirah Jeshe","1234");
        }
    }

