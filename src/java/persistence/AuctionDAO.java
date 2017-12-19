package persistence;

import domain.Auction;
import java.util.ArrayList;

public class AuctionDAO {
    
    public static AuctionDAO instance;
    public static ArrayList<Auction> auctions;
    
    public static AuctionDAO getInstance() {
        if(instance == null){
            instance = new AuctionDAO();
        }
        return instance;
    }
    
    private AuctionDAO(){
        auctions = new ArrayList<>();
        auctions.add(new Auction("TV 42 HD", 50, 0));
        auctions.add(new Auction("Projetor", 20, 0));
        auctions.add(new Auction("iPhone", 100, 0));
        auctions.add(new Auction("Pen Drive 32GB", 10, 0));
    }
    
    public ArrayList<Auction> getAuctions() {
        return auctions;
    }
    
    public void addAuction(String product, int minBid, int curBid){
        auctions.add(new Auction(product, minBid, curBid));
    }
    
    
    
}
