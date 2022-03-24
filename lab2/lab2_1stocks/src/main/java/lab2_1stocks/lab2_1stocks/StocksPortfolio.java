package lab2_1stocks.lab2_1stocks;

import java.util.ArrayList;

public class StocksPortfolio {
    private ArrayList<Stock> stocks = new ArrayList<Stock>();
    private IStockmarketService stockmarket;

    public StocksPortfolio(IStockmarketService smService){
        this.stockmarket = smService;
    }

    public void addStock(Stock s){
        this.stocks.add(s);
    }

    public double getTotalValue(){
        double totalValue = 0;
        for (Stock s : stocks){
            totalValue += stockmarket.lookUpPrice(s.getLabel())*s.getQuantity();
        }
        return totalValue;
    }
}
