import java.util.ArrayList;
import java.util.List;
public class Cart {
    List<Item> items;

    public Cart(){
        this.items=new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal(){
        int sum = 0;
        for(Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }

    public int pay(IPayment paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
        return amount;
    }
}
