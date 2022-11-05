public class Product {
    String productId;
    String description;
    double price;
    int sales;
    public Product(String id, String name, double price){
        this.productId=id;
        this.description =name;
        this.price=price;
        this.sales=0;
    }
    public double getPrice(){
        return this.price;
    }

    public void setSales(int newSales){
        this.sales=this.sales+newSales;
    }



    public String getProductId() {
        return this.productId;
    }

    public int getNumSales() {
        return this.sales;
    }

    public String getDescription() {
        return this.description;
    }
}
