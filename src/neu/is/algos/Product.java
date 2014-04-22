package neu.is.algos;

public class Product {

    private int quantity;
    private String category;

    public Product(String category){
        this.category = category;
        this.quantity = 0;
    }
   
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
        
}
