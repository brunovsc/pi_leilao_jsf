package beans;

import domain.User;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import persistence.UserDAO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private String message;

    public String login(){
        User user = UserDAO.getInstance().getUserWithUsername(username);
        if(user == null){
            message = "Usuário inválido!";
            return "";
        } else {
            if(user.getPassword().equals(password)){
                if(user.isAdmin()){
                    return "homeAdmin";
                } else {
                    return "homeParticipant";
                }
            } else {
                message = "Senha inválida!";
                return "";
            }
        }
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
