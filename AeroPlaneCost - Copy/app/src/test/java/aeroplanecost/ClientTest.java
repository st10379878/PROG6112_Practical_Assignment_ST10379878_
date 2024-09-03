package aeroplanecost;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aeroplanecost.Client.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {    
    @Test
    public void testCheckEmail_ValidEmail() {
        String email = "test@example.com";
        assertTrue(Client.checkEmail(email));
    }

    @Test
    public void testCheckEmail_InValidEmail() {
        String email = "test.com";
        assertFalse(Client.checkEmail(email));
    }

    @Test
    public void testDeleteBanker_SuccessfulDeletion() {
        boolean result = Client.deleteBanker("123", true);
        assertTrue(result);
        assertEquals(1, Client.getBanker().size());
        assertNull(Client.findStudentIndexById("123", Client.getBanker()));
    }

    @Test
    public void testDeleteBanker_DeletionNotConfirmed() {
        boolean result = Client.deleteBanker("123", false);
        assertFalse(result);
        assertEquals(2, Client.getBanker().size());
    }

    @Test
    public void testDeleteBanker_BankerNotFound() {
        boolean result = Client.deleteBanker("999", true);
        assertFalse(result);
        assertEquals(2, Client.getBanker().size());
    }
}
