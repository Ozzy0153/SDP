public class Item {
    private String upcCode;
    private String pname;
    private int price;


    public Item(String upc,String name, int cost){
        this.upcCode=upc;
        this.pname=name;
        this.price=cost;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public int getPrice() {
        return price;
    }
}
