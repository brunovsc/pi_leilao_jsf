package beans;

import domain.Auction;
import domain.User;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "adminBean")
public class AdminBean {

    private ArrayList<Auction> auctions;
    private User user;
    
    public String newAuction() {
        return "createAuction";
    }
    
    public String logout() {
        // TODO - terminate session
        return "index";
    }
    
    public AdminBean() {
        auctions = new ArrayList<>();
    }

    public ArrayList<Auction> getAuctions() {
        return auctions;
    }

    public User getUser() {
        return user;
    }

    public void setAuctions(ArrayList<Auction> auctions) {
        this.auctions = auctions;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
