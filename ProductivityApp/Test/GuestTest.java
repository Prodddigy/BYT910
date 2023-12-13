import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GuestTest {
    Guest guest1, guest2, guest3;
    public List<Guest> registeredGuests;
    /**
     * Setting up the components to be used in the Tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        guest1 = new Guest("Admin","Albert","Einstein","albertein@gmail.com","Emc2");
        guest2 = new Guest("tester","Luke","Skywalker","jediforce@gmail.com","yoda123");
        guest3 = new Guest("random", "John", "Doe", "johndoe@gmail.com", "killme");
        registeredGuests = new ArrayList<Guest>();
        registeredGuests.add(guest1);
        registeredGuests.add(guest2);

    }

    /**
     * Test if getter function returns the correct username of the Guest
     */
    @Test
    public void testGetUsername(){
        assertEquals("Admin",guest1.getUsername());
        assertEquals("tester",guest2.getUsername());
    }

    /**
     * Test if getter function returns the correct firstname of the Guest
     */
    @Test
    public void testGetFirstname(){
        assertEquals("Albert",guest1.getFirstname());
        assertEquals("Luke",guest2.getFirstname());
    }

    /**
     * Test if getter function returns the correct lastname of the Guest
     */
    @Test
    public void testGetLastname(){
        assertEquals("Einstein",guest1.getLastname());
        assertEquals("Skywalker",guest2.getLastname());
    }

    /**
     * Test if getter function returns the correct email of the Guest
     */
    @Test
    public void testGetEmail(){
        assertEquals("albertein@gmail.com",guest1.getEmail());
        assertEquals("jediforce@gmail.com",guest2.getEmail());
    }

    /**
     * Test if getter function returns the correct password of the User
     */
    @Test
    public void testGetPassword(){
        assertEquals("Emc2",guest1.getPassword());
        assertEquals("yoda123",guest2.getPassword());
    }

    /**
     * Test if setter function sets the correct username of the Guest
     */
    @Test
    public void testSetUsername(){
        assertEquals("Admin",guest1.getUsername());
        guest1.setUsername("Alvin");
        assertEquals("Alvin",guest1.getUsername());
    }

    /**
     * Test if setter function sets the correct firstname of the Guest
     */
    @Test
    public void testSetFirstname(){
        assertEquals("Albert",guest1.getFirstname());
        guest1.setFirstname("Alberto");
        assertEquals("Alberto",guest1.getFirstname());
    }

    /**
     * Test if setter function sets the correct lastname of the Guest
     */
    @Test
    public void testSetLastname(){
        assertEquals("Einstein",guest1.getLastname());
        guest1.setLastname("Einshtin");
        assertEquals("Einshtin",guest1.getLastname());
    }

    /**
     * Test if setter function sets the correct email of the Guest
     */
    @Test
    public void testSetEmail(){
        assertEquals("albertein@gmail.com",guest1.getEmail());
        guest1.setEmail("albertein11@gmail.com");
        assertEquals("albertein11@gmail.com",guest1.getEmail());
    }

    /**
     * Test if setter function sets the correct password of the User
     */
    @Test
    public void testSetPassword(){
        assertEquals("Emc2",guest1.getPassword());
        guest1.setPassword("Germany2");
        assertEquals("Germany2",guest1.getPassword());
    }

    /**
     * Test if the login function works properly
     * One login that uses correct data and on that uses false ones
     */
    @Test
    public void testLogin(){
        assertEquals(guest1,Guest.login("Admin","Emc2", registeredGuests));
        assertFalse(guest2.equals(Guest.login("Admin","Emc2", registeredGuests)));
    }
    /**
     * Test if register function adds Guests to registeredGuests list
     */
    @Test
    public void testRegister(){
        Guest.register(guest3, registeredGuests);
        assertTrue(guest3.equals(registeredGuests.get(2)));
        assertFalse(guest3.equals(registeredGuests.get(1)));
    }

}
