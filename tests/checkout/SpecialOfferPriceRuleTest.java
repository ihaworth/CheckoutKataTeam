package checkout;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecialOfferPriceRuleTest
{

    @Test
    public void pricesAProduct()
    {
        SpecialOfferPriceRule priceRule = new SpecialOfferPriceRule(50, 3, 130);

        assertThat(priceRule.priceProduct(1), equalTo(50));
    }

    @Test
    public void pricesAnotherProduct()
    {
        SpecialOfferPriceRule priceRule = new SpecialOfferPriceRule(30, 3, 130);

        assertThat(priceRule.priceProduct(1), equalTo(30));
    }

    @Test
    public void pricesAOfThreeQuantitySpecialOffer()
    {
        SpecialOfferPriceRule priceRule = new SpecialOfferPriceRule(50, 3, 130);

        assertThat(priceRule.priceProduct(3), equalTo(130));
    }

    @Test
    public void pricesAOfFourQuantitySpecialOffer()
    {
        SpecialOfferPriceRule priceRule = new SpecialOfferPriceRule(50, 3, 130);

        assertThat(priceRule.priceProduct(4), equalTo(180));
    }

}
