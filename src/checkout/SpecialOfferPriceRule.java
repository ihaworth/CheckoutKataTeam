package checkout;

public class SpecialOfferPriceRule implements PriceRule
{
    private int price;
    private int discountQuantity;
    private int discountedPrice;

    public SpecialOfferPriceRule(String product, int price, int quantity, int discountedPrice)
    {
        this.price = price;
        this.discountQuantity = quantity;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public int priceProduct(String product, int quantity)
    {
        return (quantity / discountQuantity) * discountedPrice +
                (quantity % discountQuantity) * price;
    }
}
