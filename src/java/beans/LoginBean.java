package beans;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private String message;

    public String login(){
        if(username.equals("admin")){
            if(password.equals("admin")){
                return "homeAdmin";
            } else {
                message = "Senha inválida!";
            }
        } else { // TODO - get user from database and verify its password
            message = "Usuário inválido!";
        }
        return "";
    }
    
    public String signup(){
        return "signup";
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
