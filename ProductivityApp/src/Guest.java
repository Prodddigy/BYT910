import java.util.List;

public class Guest {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public Guest(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Guest() {}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Guest login(String enteredUsername, String enteredPassword, List<Guest> registeredGuests) {
        for (Guest guest : registeredGuests) {
            if (guest.getUsername().equals(enteredUsername) && guest.getPassword().equals(enteredPassword)) {
                System.out.println("Login successful");
                return guest;
            }
        }
        System.out.println("Login failed. Invalid username or password.");
        return null;
    }
    public static void register(Guest newGuest, List<Guest> registeredGuests) {
        registeredGuests.add(newGuest);
        System.out.println("Registration successful");
    }
}
