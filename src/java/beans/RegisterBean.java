package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "registerBean")
public class RegisterBean {
    
    private String username;
    private String password;
    private String message;

    public String register() {
        // TODO - validate fields and save to the database
        return "homeParticipant";
    }
    
    public String back() {
        return "index";
    }
    
    public String getMessage() {
        return message;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
