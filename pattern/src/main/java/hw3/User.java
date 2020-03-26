package hw3;

public class User {
    private String login;
    private String password;
    private String name;
    private String role;

    public User() {
    }

    public User(String login, String password, String name, String role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("{\"name\": \"%s\", \"login\": \"%s\", \"password\": \"%s\", \"role\": \"%s\"}",
                this.name, this.login, this.password, this.role);
    }
}
