package beans;

import domain.Auction;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "participantBean")
@SessionScoped
public class ParticipantBean {

    private String username;
    private ArrayList<Auction> auctions;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean login;
    
    public ParticipantBean() {}
    
    @PostConstruct
    public void init() {
        username = login.getUsername();
    }
    
    public void submitBid(int auctionId) {
        
    }
    
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
    
    public String listAuctions() {
        return "listAuctions";
    }
    
    public ArrayList<Auction> getAuctions() {
        return auctions;
    }

    public String getUsername() {
        return username;
    }

    public void setAuctions(ArrayList<Auction> auctions) {
        this.auctions = auctions;
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
