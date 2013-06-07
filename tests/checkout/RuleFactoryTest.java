package checkout;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class RuleFactoryTest
{

    @Test
    public void canCreateASimplePriceRule()
    {
        RuleCreationListener listener = mock(RuleCreationListener.class);
        RuleFactory ruleFactory = new RuleFactory();
        ruleFactory.addListener(listener);

        ruleFactory.createPriceRule("Baked Beans", 50);

        verify(listener).ruleCreated(eq("Baked Beans"), any(PriceRule.class));
    }

}
