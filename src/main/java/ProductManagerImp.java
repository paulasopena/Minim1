import Structures.EmptyQueueException;
import Structures.Queue;
import Structures.QueueImplementation;

import java.util.*;


public class ProductManagerImp implements ProductManager {
    List<Product> products;
    Queue<Order> orders;
    List<Order> processedOrders;
    Hashtable<String, User> users;


    public ProductManagerImp(){
        this.products=new ArrayList<>();
        this.orders=new QueueImplementation<Order>();
        this.processedOrders=new ArrayList<>();
        this.users=new Hashtable<>();

    }

    @Override
    public List<Product> productsByPrice() {
        this.products.sort((p1,p2)->Double.compare(p1.getPrice(), p2.getPrice()));
        return products;
    }

    @Override
    public List<Product> productsBySales() {
        this.products.sort((p1,p2)->Integer.compare(p2.getSales(), p1.getSales()));
        return products;
    }

    @Override
    public void addOrder(Order o){
        orders.push(o);
    }

    @Override
    public Order processOrder() throws EmptyQueueException {
        Order orderPopped=orders.pop();
        processedOrders.add(orderPopped);
        Product newSale =this.getProduct(orderPopped.product.productId);
        newSale.setSales(orderPopped.cuantity);
        return orderPopped;
    }


    @Override
    public List<Order> ordersByUser(String userId) {
        List<Order> ordersOfUser = new ArrayList<>();
        for(int i=0; i<processedOrders.size();i++){
            if(Objects.equals(processedOrders.get(i).user.userId, userId)){
                ordersOfUser.add(processedOrders.get(i));
            }
        }
        return ordersOfUser;

    }

    @Override
    public void addUser(String s, String name, String surname) {
        User u = new User(s,name,surname);
        this.users.put(s,u);
    }

    @Override
    public void addProduct(String productId, String name, double price) {
        this.products.add(new Product(productId,name,price));

    }

    @Override
    public Product getProduct(String productId) {
        int i =0;
        boolean found=false;
        while(!found && i<this.products.size()){
            if(Objects.equals(this.products.get(i).getProductID(), productId)){
                found=true;
            }
            else{
                i=i+1;
            }
        }
        return this.products.get(i);
    }

    @Override
    public int numUsers() {
        return this.users.size();
    }

    @Override
    public int numProducts() {
        return this.products.size();
    }

    @Override
    public int numOrders() {
        return this.orders.size();
    }

    @Override
    public int numSales(String b001) {
        return(this.getProduct(b001).getSales());
    }
    @Override
    public User getUser(String id){
        return this.users.get(id);
    }
}
