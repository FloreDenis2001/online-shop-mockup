package model;

public class Products {
    private int id;
    private String name;
    private float price;
    private String descriptions;
    private int stock;

    public Products(int id, String name, float price, String descriptions, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.descriptions = descriptions;
        this.stock = stock;
    }


    public Products(String text){
        String [] path=text.split(",");
        this.id=Integer.parseInt(path[0]);
        this.name=path[1];
        this.price=Float.parseFloat(path[2]);
        this.descriptions=path[3];
        this.stock=Integer.parseInt(path[4]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){
//        String text = "Id"+this.id+"\n";
        String text="Name : "+this.name+"\n";
        text+="Price : "+this.price+" /buc \n";
        text+="Description : "+this.descriptions+"\n";
//        text+="Stock  : "+this.stock+"\n";
        return text;
    }

    public String toSave() {
        String text =this.id+","+this.name+","+this.price+","+this.descriptions+","+this.stock;
        return text;
    }
}
