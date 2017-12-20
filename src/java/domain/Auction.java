package domain;

public class Auction {
    
    private static int idCounter = 0;
    
    private int id;
    private String product;
    private int minimumBid;
    private boolean status; // true is Openned, false is Closed
    private String action;
    // BID
    private String usernameWinning;
    private int currentBid;
    
    public Auction(String product, int minBid, int curBid){
        this.id = idCounter++;
        this.product = product;
        this.minimumBid = minBid;
        this.currentBid = curBid;
        this.status = false;
        this.action = "Iniciar";
        this.usernameWinning = null;
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

    public String getUsernameWinning() {
        return usernameWinning;
    }

    public void setUsernameWinning(String usernameWinning) {
        this.usernameWinning = usernameWinning;
    }

    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }
        
    public String performAction() {
        if(currentBid != 0) {
            action = "Finalizado";
            status = false;
            return "closedAuction";
        }
        status = !status;
        action = status ? "Encerrar" : "Iniciar";
        return "";
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
