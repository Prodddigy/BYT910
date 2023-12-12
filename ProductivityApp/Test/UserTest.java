import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    User user1, user2;

    /**
     * Setting up the components to be used in the Tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        user1=new User("Admin","Albert","Einstein","albertein@gmail.com","Emc2");
        user2=new User("tester","Luke","Skywalker","jediforce@gmail.com","yoda123");
    }

    /**
     * Test if getter function returns the correct username of the User
     */
    @Test
    public void testGetUsername(){
        assertEquals("Admin",user1.getUsername());
        assertEquals("tester",user2.getUsername());
    }

    /**
     * Test if getter function returns the correct firstname of the User
     */
    @Test
    public void testGetFirstname(){
        assertEquals("Albert",user1.getFirstname());
        assertEquals("Luke",user2.getFirstname());
    }

    /**
     * Test if getter function returns the correct lastname of the User
     */
    @Test
    public void testGetLastname(){
        assertEquals("Einstein",user1.getLastname());
        assertEquals("Skywalker",user2.getLastname());
    }

    /**
     * Test if getter function returns the correct email of the User
     */
    @Test
    public void testGetEmail(){
        assertEquals("albertein@gmail.com",user1.getEmail());
        assertEquals("jediforce@gmail.com",user2.getEmail());
    }

    /**
     * Test if getter function returns the correct password of the User
     */
    @Test
    public void testGetPassword(){
        assertEquals("Emc2",user1.getPassword());
        assertEquals("yoda123",user2.getPassword());
    }

}
