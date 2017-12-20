package beans;

import domain.Auction;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import persistence.AuctionDAO;

@ManagedBean(name = "participantBean")
@SessionScoped
public class ParticipantBean {

    private String username;
    private ArrayList<Auction> auctions;
    private String message;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean login;
    
    public ParticipantBean() {
    }
    
    @PostConstruct
    public void init() {
        username = login.getUsername();
        auctions = new ArrayList<>();
    }
    
    public void submitBid(int auctionId) {
        Auction selectedAuction = null;
        for(Auction a: auctions){
            if(a.getId() == auctionId){
                selectedAuction = a;
                break;
            }
        }
        if(selectedAuction == null){
            message = "Leilão não encontrado.";
            return;
        }
        int currentBid = selectedAuction.getCurrentBid();
        int newBid = (currentBid == 0) ? selectedAuction.getMinimumBid() : (currentBid + 10);
        selectedAuction.setCurrentBid(newBid);
        selectedAuction.setUsernameWinning(username);
        
    }
    
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
    
    public String reload() {
        return "homeParticipant";
    }
    
    public String listAuctions() {
        return "listAuctions";
    }
    
    public ArrayList<Auction> getAuctions() {
        ArrayList<Auction> allAuctions = AuctionDAO.getInstance().getAuctions();
        for(Auction allAuction: allAuctions){
            for(Auction userAuction: auctions){
                if(allAuction.getId() == userAuction.getId()){
                    userAuction.setStatus(allAuction.getStatus());
                    break;
                }
            }
        }
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
