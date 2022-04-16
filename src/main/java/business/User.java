package business;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private Role role;

    public User (String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = Role.setRole(role);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
