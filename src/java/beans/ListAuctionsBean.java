package beans;

import domain.Auction;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import persistence.AuctionDAO;

@ManagedBean(name = "createAuctionBean")
public class ListAuctionsBean {
    
    private ArrayList<Auction> auctions;
    
    @ManagedProperty(value = "#{participantBean}")
    private ParticipantBean participant;

    public ParticipantBean getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantBean participant) {
        this.participant = participant;
    }

    public ArrayList<Auction> getAuctions() {
        auctions = AuctionDAO.getInstance().getAuctions();
        return auctions;
    }

    public void setAuctions(ArrayList<Auction> auctions) {
        this.auctions = auctions;
    }
    
    
    
}
