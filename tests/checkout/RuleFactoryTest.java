package checkout;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class RuleFactoryTest
{

    private RuleCreationListener listener;
    private RuleFactory ruleFactory;

    @Before
    public void setup()
    {
        listener = mock(RuleCreationListener.class);
        ruleFactory = new RuleFactory();
        ruleFactory.addListener(listener);
    }

    @Test
    public void canCreateASimplePriceRule()
    {
        ruleFactory.createPriceRule("Baked Beans", 50);
        verify(listener).ruleCreated(eq("Baked Beans"), any(SinglePriceRule.class));
    }

    @Test
    public void canCreateASpecialOfferPriceRule()
    {
        ruleFactory.createPriceRule("Baked Beans", 50, 3, 30);
        verify(listener).ruleCreated(eq("Baked Beans"), any(SpecialOfferPriceRule.class));
    }

}
