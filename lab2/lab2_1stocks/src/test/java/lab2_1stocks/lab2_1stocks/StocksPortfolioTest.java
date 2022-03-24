package lab2_1stocks.lab2_1stocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {
    @Mock
    IStockmarketService smService;

    @InjectMocks
    StocksPortfolio sPortfolio;

    @DisplayName("Checking if getTotalValue() is working")
    @Test
    public void getTotalValueTest(){
        Stock s1 = new Stock("Galp",3);
        Stock s2 = new Stock("Express",5);

        Mockito.when(smService.lookUpPrice("Galp")).thenReturn(15.0);
        Mockito.when(smService.lookUpPrice("Express")).thenReturn(10.0);

        sPortfolio.addStock(s1);
        sPortfolio.addStock(s2);

        double totalPrice = sPortfolio.getTotalValue();
        assertThat(totalPrice,is(95.0));
        Mockito.verify(smService,Mockito.times(2)).lookUpPrice(Mockito.anyString());
    }
}
