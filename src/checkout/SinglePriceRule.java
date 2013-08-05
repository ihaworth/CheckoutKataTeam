package checkout;

public class SinglePriceRule implements PriceRule
{
    final int productPrice;

    public SinglePriceRule(int price)
    {
        productPrice = price;
    }

    @Override
    public int priceProduct(int quantity)
    {
        return productPrice * quantity;
    }
}
