package checkout;

public class SinglePriceRule implements PriceRule
{
    final int productPrice;

    public SinglePriceRule(String product, int price)
    {
        productPrice = price;
    }


    @Override
    public int priceProduct(String product, int quantity)
    {
        return productPrice * quantity;
    }
}
