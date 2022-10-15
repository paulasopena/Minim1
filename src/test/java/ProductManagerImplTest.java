import Structures.EmptyQueueException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProductManagerImplTest {

    ProductManager pm;

    @Before
    public void setUp() {
        pm = new ProductManagerImp();
        pm.addUser("U01", "Alberto", "Cruz");
        pm.addUser("U02",  "Paula", "Sopena");
        pm.addUser("U03",  "Marina", "Coello");

        pm.addProduct("P01", "Coca-Cola", 2);
        pm.addProduct("P02", "Coffee", 1.5);
        pm.addProduct("P03", "Donut", 2.25);
        pm.addProduct("P04", "Brocoli", 1.25);
        Order o1 =new Order(pm.getUser("U01"),pm.getProduct("P01"),3);
        Order o2 =new Order(pm.getUser("U01"),pm.getProduct("P02"),2);
        Order o3 =new Order(pm.getUser("U01"),pm.getProduct("P03"),1);
        pm.addOrder(o1);
        pm.addOrder(o2);
        pm.addOrder(o3);


        prepareOrders();
    }

    @After
    public void tearDown() {
        this.pm = null;
    }

    private void prepareOrders() {
        ProductManagerImp pm1 = new ProductManagerImp();
        Product p1= new Product("A01","oil",2);
        Order o1 =new Order(pm.getUser("U01"),p1,3);
        pm.addOrder(o1);
        Assert.assertEquals(4, this.pm.numOrders());
    }

    @Test
    public void testAddOrder() {
        Assert.assertEquals(3, this.pm.numUsers());
        Assert.assertEquals(4, this.pm.numProducts());
        Assert.assertEquals(4, this.pm.numOrders());
    }

    @Test
    public void processOrderTest() throws EmptyQueueException {
        Assert.assertEquals(3, this.pm.numUsers());
        Assert.assertEquals(4, this.pm.numProducts());
        Assert.assertEquals(4, this.pm.numOrders());

        Order orderProcessed = this.pm.processOrder();
        Assert.assertEquals(3, this.pm.numOrders());

    }
    @Test
    public void productsSortByPrice() {
        List<Product> products = this.pm.productsByPrice();

        Assert.assertEquals("P04", products.get(0).getProductID());
        Assert.assertEquals(1.25, products.get(0).getPrice(), 0);

        Assert.assertEquals("P02", products.get(1).getProductID());
        Assert.assertEquals(1.5, products.get(1).getPrice(), 0);

        Assert.assertEquals("P01", products.get(2).getProductID());
        Assert.assertEquals(2, products.get(2).getPrice(), 0);

        Assert.assertEquals("P03", products.get(3).getProductID());
        Assert.assertEquals(2.25, products.get(3).getPrice(), 0);
    }
    @Test
    public void productsSortByNumSales() throws EmptyQueueException {
        Order orderProcessed = pm.processOrder();
        Assert.assertEquals(3,pm.getProduct(orderProcessed.product.productId).getSales());
        Order orderProcessed2 = pm.processOrder();
        Assert.assertEquals(2,pm.getProduct(orderProcessed2.product.productId).getSales());
        List<Product> productsBySales = this.pm.productsBySales();

        Assert.assertEquals("P01", productsBySales.get(0).getProductID());
        Assert.assertEquals(3, productsBySales.get(0).getSales(), 0);

        Assert.assertEquals("P02", productsBySales.get(1).getProductID());
        Assert.assertEquals(2, productsBySales.get(1).getSales(), 0);

        Assert.assertEquals("P03", productsBySales.get(2).getProductID());
        Assert.assertEquals(0, productsBySales.get(2).getSales(), 0);

    }
    @Test
    public void ordersByUserTest() throws EmptyQueueException {
        productsSortByNumSales();
        List<Order> ordersOfUser1 = this.pm.ordersByUser("U01");
        Assert.assertEquals(2, ordersOfUser1.size());
    }




}
