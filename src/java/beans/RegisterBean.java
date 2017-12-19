package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import persistence.UserDAO;

@ManagedBean(name = "registerBean")
public class RegisterBean {
    
    private String username;
    private String password;
    private String message;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean login;
    
    public String register() {
        // TODO - validate fields and save to the database
        UserDAO.getInstance().addUser(username, password, false);
        login.setUsername(username);
        login.setPassword(password);
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
    
    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }
    
}
