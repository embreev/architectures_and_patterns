package hw6;

import java.util.Date;

public class User {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String role;
    private String group;
    private Boolean active;
    private Boolean blocking;
    private String lastLogin;
    private String create;

    public User() {
    }

    public User(String login, String password, String name, String role, String group, Boolean active, Boolean blocking, String lastLogin, String create) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
        this.group = group;
        this.active = active;
        this.blocking = blocking;
        this.lastLogin = lastLogin;
        this.create = new Date().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getBlocking() {
        return blocking;
    }

    public void setBlocking(Boolean blocking) {
        this.blocking = blocking;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    @Override
    public String toString() {
        return String.format("{id: %d, login: %s, name: %s}", id, login, name);
    }
}
