package model;

public class OrderDetails {
    private int id;
    private int orderId;
    private int productId;
    private float price;
    private int cantitate;

    public OrderDetails(int id, int orderId, int productId,float price,int cantitate) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price=price;
        this.cantitate=cantitate;
    }


    public OrderDetails(String text){
        String []path=text.split(",");
        this.id=Integer.parseInt(path[0]);
        this.orderId=Integer.parseInt(path[1]);
        this.productId=Integer.parseInt(path[2]);
        this.price=Float.parseFloat(path[3]);
        this.cantitate=Integer.parseInt(path[4]);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String toString() {
        String text = "Id : " + this.id + "\n";
        text+="Id Comanda : "+this.orderId+"\n";
        text+="Id Produs : "+this.productId+"\n";
        text+="Price : "+this.price+"\n";
        text+="Cantitate : "+this.cantitate+"\n";
        return text;
    }
}
