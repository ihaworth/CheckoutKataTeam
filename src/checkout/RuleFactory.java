package checkout;

public class RuleFactory implements RuleListener
{
    private RuleCreationListener listener;

    public void addListener(RuleCreationListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void ruleParsed(String product, int price)
    {
        createPriceRule(product, price);
    }

    @Override
    public void ruleParsed(String product, int price, int quantity, int discountedPrice)
    {
        createPriceRule(product, price, quantity, discountedPrice);
    }

    public void createPriceRule(String product, int price)
    {
        listener.ruleCreated(product, new SinglePriceRule(product, price));
    }

    public void createPriceRule(String product, int price, int quantity, int discountedPrice)
    {
        listener.ruleCreated(product, new SpecialOfferPriceRule(product, price, quantity, discountedPrice));
    }


}
