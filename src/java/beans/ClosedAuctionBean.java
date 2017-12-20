package beans;

import domain.Auction;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import persistence.AuctionDAO;

@ManagedBean(name = "closedAuctionBean")
public class ClosedAuctionBean {
    
    private Auction closedAuction;
    private String message;

    public ClosedAuctionBean(){
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try{
            int auctionId = (int)req.getAttribute("auctionId");
            closedAuction = AuctionDAO.getInstance().getAuctionWithId(auctionId);
        } catch(Exception e){}
    }
    
    public String back() {
        return "homeAdmin";
    }
    
    public Auction getClosedAuction() {
        return closedAuction;
    }

    public void setClosedAuction(Auction closedAuction) {
        this.closedAuction = closedAuction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
