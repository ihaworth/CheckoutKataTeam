package checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class RuleStoreTest
{
    private final static String PRODUCT_A_NAME = "Product A";
    private static final String PRODUCT_B_NAME = "product B";

    RuleStore ruleStore;

    private PriceRule productAPriceRule;
    private PriceRule productBPriceRule;

    @Before
    public void setup()
    {
        ruleStore = new RuleStore();
        productAPriceRule = mock(PriceRule.class);
        productBPriceRule = mock(PriceRule.class);
    }

    @Test
    public void delegatesPricingOfAProductToAProductPriceRule()
    {
        ruleStore.ruleCreated(PRODUCT_A_NAME, productAPriceRule);

        ruleStore.priceProduct(PRODUCT_A_NAME);

        verify(productAPriceRule).priceProduct(PRODUCT_A_NAME);
    }

    @Test
    public void productIsPricedIfRuleAvaliable()
    {
        when(productAPriceRule.priceProduct(PRODUCT_A_NAME)).thenReturn(50);

        ruleStore.ruleCreated(PRODUCT_A_NAME, productAPriceRule);

        assertThat(ruleStore.priceProduct(PRODUCT_A_NAME), equalTo(50));
    }

    @Test
    public void inCaseOfMultipleProductsUsesCorrectRule(){

        ruleStore.ruleCreated(PRODUCT_A_NAME, productAPriceRule);
        ruleStore.ruleCreated(PRODUCT_B_NAME, productBPriceRule);

        ruleStore.priceProduct(PRODUCT_A_NAME);

        verify(productAPriceRule).priceProduct(PRODUCT_A_NAME);
    }
}