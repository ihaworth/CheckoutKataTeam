package checkout;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SinglePriceRuleTest
{
    @Test
    public void pricesAProduct()
    {
        PriceRule priceRule = new SinglePriceRule("A", 50);

        assertThat(priceRule.priceProduct("A", 1), equalTo(50));
    }

    @Test
    public void pricesAnotherProduct()
    {
        PriceRule priceRule = new SinglePriceRule("B", 30);

        assertThat(priceRule.priceProduct("B", 1), equalTo(30));
    }
}