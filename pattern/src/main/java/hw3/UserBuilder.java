package hw3;

public class UserBuilder {
    private User user;

    public UserBuilder() {
        this.user = new User();
    }

    public UserBuilder login(String login) {
        user.setLogin(login);
        return this;
    }

    public UserBuilder password(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder role(String role) {
        user.setRole(role);
        return this;
    }

    public User create() {
        return user;
    }
}
