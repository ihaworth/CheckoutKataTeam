package checkout;

public class RuleFactory implements RuleListener
{
    private RuleCreationListener listener;

    public void addListener(RuleCreationListener listener)
    {
        this.listener = listener;
    }

    public void createPriceRule(String product, int price)
    {
        listener.ruleCreated(product, new PriceRule(product, price));
    }

    @Override
    public void ruleParsed(String product, int price)
    {
        createPriceRule(product, price);
    }
}
