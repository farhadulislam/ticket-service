package Model;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final Account accountTestObj = new Account(1L);

    void accountIdNotNullTest(){
        assertNotNull( accountTestObj.getAccountId());
    }




}