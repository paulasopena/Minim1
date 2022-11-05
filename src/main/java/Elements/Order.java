package Elements;

import java.util.LinkedList;
import java.util.List;

public class Order {
    LinkedList<LP> linesOfProducts;
    public String idUser;
    public Order(String idUser){
        this.linesOfProducts=new LinkedList<>();
        this.idUser=idUser;
    }

    public void addLP(int i, String c002) {
        LP newLine= new LP(c002,i);
        linesOfProducts.add(newLine);
    }
    public List<LP> getLinesOfProducts(){
        return (linesOfProducts);
    }

    public LP getLP(int i) {
        return this.linesOfProducts.get(i);
    }
}
