import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
    User user1, user2, user3;
    LaunchingTask launchedTask;

    public List<User> registeredUsers;

    /**
     * Setting up the components to be used in the Tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        user1=new User("Admin","Albert","Einstein","albertein@gmail.com","Emc2");
        user2=new User("tester","Luke","Skywalker","jediforce@gmail.com","yoda123");
        user3 = new User("random", "John", "Doe", "johndoe@gmail.com", "killme");
        launchedTask = new LaunchingTask("10h");

        registeredUsers = new ArrayList<User>();
        registeredUsers.add(user1);
        registeredUsers.add(user2);
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

    /**
     * Test if setter function sets the correct username of the User
     */
    @Test
    public void testSetUsername(){
        assertEquals("Admin",user1.getUsername());
        user1.setUsername("Alvin");
        assertEquals("Alvin",user1.getUsername());
    }

    /**
     * Test if setter function sets the correct firstname of the User
     */
    @Test
    public void testSetFirstname(){
        assertEquals("Albert",user1.getFirstname());
        user1.setFirstname("Alberto");
        assertEquals("Alberto",user1.getFirstname());
    }

    /**
     * Test if setter function sets the correct lastname of the User
     */
    @Test
    public void testSetLastname(){
        assertEquals("Einstein",user1.getLastname());
        user1.setLastname("Einshtin");
        assertEquals("Einshtin",user1.getLastname());
    }

    /**
     * Test if setter function sets the correct email of the User
     */
    @Test
    public void testSetEmail(){
        assertEquals("albertein@gmail.com",user1.getEmail());
        user1.setEmail("albertein11@gmail.com");
        assertEquals("albertein11@gmail.com",user1.getEmail());
    }

    /**
     * Test if setter function sets the correct password of the User
     */
    @Test
    public void testSetPassword(){
        assertEquals("Emc2",user1.getPassword());
        user1.setPassword("Germany2");
        assertEquals("Germany2",user1.getPassword());
    }

    /**
     * Test if method adds and gets launching task properly
     */
    @Test
    public void testAddGetLaunchingTask(){
        user1.addLaunchingTask(launchedTask);
        assertEquals(launchedTask,user1.getLaunchingTask(0));
    }

    /**
     * Test if the login function works properly
     * One login that uses correct data and on that uses false ones
     */
    @Test
    public void testLogin(){
        assertEquals(user1,User.login("Admin","Emc2", registeredUsers));
        assertFalse(user2.equals(User.login("Admin","Emc2", registeredUsers)));
    }
    /**
     * Test if register function adds Guests to registeredGuests list
     */
    @Test
    public void testRegister(){
        User.register(user3, registeredUsers);
        assertTrue(user3.equals(registeredUsers.get(2)));
        assertFalse(user3.equals(registeredUsers.get(1)));
    }


}
