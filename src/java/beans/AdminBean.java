package beans;

import domain.Auction;
import domain.User;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import persistence.AuctionDAO;

@ManagedBean(name = "adminBean")
public class AdminBean {

    private ArrayList<Auction> auctions;
    private User user;
    
    public String newAuction() {
        return "createAuction";
    }
    
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
    
    public void performAction(int auctionId) {
        for(Auction a: auctions){
            if(a.getId() == auctionId){
                a.performAction();
            }
        }
    }
    
    public AdminBean() {
        auctions = AuctionDAO.getInstance().getAuctions();
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
