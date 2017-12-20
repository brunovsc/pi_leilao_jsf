package beans;

import javax.faces.bean.ManagedBean;
import persistence.AuctionDAO;

@ManagedBean(name = "createAuctionBean")
public class CreateAuctionBean {

    private String product;
    private int minimumBid;
    private String message;

    public void createAuction() {
        AuctionDAO.getInstance().addAuction(product, minimumBid, 0);
        message = "Leilão criado com sucesso!";
    }
    
    public String back() {
        return "homeAdmin";
    }

    public String getMessage() {
        return message;
    }
    
    public int getMinimumBid() {
        return minimumBid;
    }

    public String getProduct() {
        return product;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMinimumBid(int minimumBid) {
        this.minimumBid = minimumBid;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
