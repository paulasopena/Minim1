public class Product {
    String productId;
    String name;
    double price;
    int sales;
    public Product(String id, String name, double price){
        this.productId=id;
        this.name=name;
        this.price=price;
        this.sales=0;
    }
    public double getPrice(){
        return this.price;
    }
    public int getSales(){
        return this.sales;
    }
    public void setSales(int newSales){
        this.sales=this.sales+newSales;
    }
    public String getProductID(){
        return this.productId;

    }


}
