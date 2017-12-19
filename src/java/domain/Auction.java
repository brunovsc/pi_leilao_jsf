package domain;

import java.util.ArrayList;

public class Auction {
    
    private static int idCounter = 0;
    
    private int id;
    private String product;
    private int minimumBid;
    private int currentBid;
    private boolean status; // true is Openned, false is Closed
    private String action;
    private ArrayList<Bid> bids;
    
    public Auction(String product, int minBid, int curBid){
        this.id = idCounter++;
        this.product = product;
        this.minimumBid = minBid;
        this.currentBid = curBid;
        this.status = false;
        this.action = "Iniciar";
        this.bids = new ArrayList<>();
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    public int getId() {
        return id;
    }
    
    public int getMinimumBid() {
        return minimumBid;
    }

    public String getProduct() {
        return product;
    }
    
    public boolean getStatus() {
        return status;
    }

    public String getAction() {
        return action;
    }
    
    public void performAction() {
        status = !status;
        action = (status == true) ? "Encerrar" : "Iniciar";
    }
}
