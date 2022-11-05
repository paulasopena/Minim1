package Elements;

public class LP {
    String idProduct;
    int cuantity;
    public LP (String idProduct, int cuantity){
        this.idProduct=idProduct;
        this.cuantity=cuantity;
    }
    public int getCuantity(){
        return this.cuantity;

    }
    public String getIDLP(){
        return idProduct;
    }
}
