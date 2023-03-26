package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    final Account accountTestObj = new Account(1L);
    @Test
    void accountIdNotNullTest(){
        assertNotNull( accountTestObj.getAccountId());
    }

    @Test
    void accountIdGreaterThanZero(){
        assertTrue( accountTestObj.getAccountId()>0);
    }




}