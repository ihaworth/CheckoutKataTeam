package checkout;

public interface PriceRule
{

    public abstract int priceProduct(String product, int quantity);

}