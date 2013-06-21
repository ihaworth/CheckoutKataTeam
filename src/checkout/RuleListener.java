package checkout;

public interface RuleListener
{
    void ruleParsed(String product, int price);
    void ruleParsed(String product, int price, int quantity, int discountedPrice);
}
