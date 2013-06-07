package checkout;

public interface RuleCreationListener
{
    void ruleCreated(String product, PriceRule priceRule);
}