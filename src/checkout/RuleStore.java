package checkout;

import java.util.HashMap;
import java.util.Map;

public class RuleStore implements RuleCreationListener
{
    private Map<String, PriceRule> ruleMap = new HashMap<String, PriceRule>();

    @Override
    public void ruleCreated(String product, PriceRule priceRule)
    {
        ruleMap.put(product, priceRule);
    }

    public int priceProduct(String product)
    {
        return ruleMap.get(product).priceProduct(product);
    }
}
