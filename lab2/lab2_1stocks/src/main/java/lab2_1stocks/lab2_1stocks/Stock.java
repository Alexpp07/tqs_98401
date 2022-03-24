package lab2_1stocks.lab2_1stocks;

public class Stock {
    private String label;
    private Integer quantity;

    public Stock(String s, Integer i){
        this.label = s;
        this.quantity = i;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
