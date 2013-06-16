package checkout;

public class PriceRule
{
    final int productPrice;

    public PriceRule(String product, int price)
    {
        productPrice = price;
    }

    public int priceProduct(String product, int quantity)
    {
        return productPrice * quantity;
    }



}
