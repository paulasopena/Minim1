package Elements;

import Elements.Order;

import java.util.ArrayList;
import java.util.List;


public class User {
    String userId;
    String name;
    String surname;
    public List<Order> orderList;
    public User(String id, String name, String surname){
        this.userId=id;
        this.name=name;
        this.surname=surname;
        this.orderList= new ArrayList<>();
    }
}
