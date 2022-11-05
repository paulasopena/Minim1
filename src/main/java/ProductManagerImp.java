import Elements.LP;
import Elements.Order;
import Elements.User;

import java.util.*;


public class ProductManagerImp implements ProductManager {
    List<Product> products;
    Queue<Order> orders;

    List<Order> processedOrders;
    HashMap<String, User> users;


    public ProductManagerImp(){
        this.products=new ArrayList<>();
        this.orders=new LinkedList<Order>();
        this.processedOrders=new ArrayList<>();
        this.users=new HashMap<>();

    }

    @Override
    public List<Product> productsByPrice() {
        this.products.sort((p1,p2)->Double.compare(p1.getPrice(), p2.getPrice()));
        return products;
    }

    @Override
    public List<Product> productsBySales() {
        this.products.sort((p1,p2)->Double.compare(p1.getNumSales(), p2.getNumSales()));
        return products;
    }

    @Override
    public void addOrder(Order o){
        orders.add(o);
    }

    @Override
    public Order processOrder() {
        Order orderPopped=orders.poll();
        processedOrders.add(orderPopped);
        assert orderPopped != null;
        User userMadeOrder = users.get(orderPopped.idUser);
        userMadeOrder.orderList.add(orderPopped);
        List<LP> processedLP=orderPopped.getLinesOfProducts();
        for (LP lp : processedLP) {
            boolean found = false;
            int j = 0;
            while (!found && j < products.size()) {
                if (Objects.equals(lp.getIDLP(), products.get(j).productId)) {
                    products.get(j).setSales(lp.getCuantity());
                    found = true;
                } else {
                    j++;
                }
            }
        }
        return orderPopped;


    }


    @Override
    public List<Order> ordersByUser(String userId) {
        List<Order> ordersOfUser = new ArrayList<>();
        User user=users.get(userId);
        ordersOfUser=user.orderList;
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
            if(Objects.equals(this.products.get(i).getProductId(), productId)){
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
        return(this.getProduct(b001).getNumSales());
    }
    @Override
    public User getUser(String id){
        return this.users.get(id);
    }
}
