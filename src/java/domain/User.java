package domain;

public class User {
    
    private String username;
    private String password;
    private boolean admin;
    
    public User(String username, String password, boolean admin){
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
    public boolean isAdmin() {
        return admin;
    }
    
}
