package model;

public class Orders {
    private int id;
    private int customerId;
    private  float price;

    public Orders(int id, int customerId, float price) {
        this.id = id;
        this.customerId = customerId;
        this.price = price;
    }

    public Orders(String text){
        String []path=text.split(",");
        this.id=Integer.parseInt(path[0]);
        this.customerId=Integer.parseInt(path[1]);
        this.price=Integer.parseInt(path[2]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String text ="ID: "+this.id+"\n";
        text+="Client ID: "+this.customerId+"\n";
        text+="Price : "+this.price+"\n";
        return text;
    }
}
