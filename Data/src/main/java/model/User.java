package model;

import java.util.UUID;

public class User extends AbstractEntity {
    private String role;

    private String login;
    private String email;
    private String hashPassword;
    private String firstName;
    private String lastName;
    private Address address;

    public User(UUID uuid, String firstName, String lastName, Address address) {
        super(uuid);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


}
