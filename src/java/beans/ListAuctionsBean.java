package beans;

import domain.Auction;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import persistence.AuctionDAO;

@ManagedBean(name = "listAuctionsBean")
public class ListAuctionsBean {
    
    private ArrayList<Auction> auctions;
    private String message;
    
    @ManagedProperty(value = "#{participantBean}")
    private ParticipantBean participant;

    public String watchAuction(int auctionId){
        ArrayList<Auction> userAuctions = participant.getAuctions();
        for(Auction a: userAuctions){
            if(a.getId() == auctionId){
                message = "O leilão selecionado já está sendo acompanhado.";
                return "";
            }
        }
        for(Auction auction: auctions){
            if(auction.getId() == auctionId){
                userAuctions.add(auction);
                break;
            }
        }
        participant.setAuctions(userAuctions);
        return "homeParticipant";
    }
    
    public String back() {
        return "homeParticipant";
    }
    
    public ParticipantBean getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantBean participant) {
        this.participant = participant;
    }

    public ArrayList<Auction> getAuctions() {
        auctions = new ArrayList<>(); 
        ArrayList<Auction> allAuctions = AuctionDAO.getInstance().getAuctions();
        ArrayList<Auction> userAuctions = participant.getAuctions();
        boolean isWatching = false;
        for(Auction allAuction: allAuctions){
            isWatching = false;
            for(Auction userAuction: userAuctions){
                if(userAuction.getId() == allAuction.getId()){
                    isWatching = true;
                    break;
                }
            }
            if(!isWatching){
                auctions.add(allAuction);
            }
        }
        return auctions;
    }

    public void setAuctions(ArrayList<Auction> auctions) {
        this.auctions = auctions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
