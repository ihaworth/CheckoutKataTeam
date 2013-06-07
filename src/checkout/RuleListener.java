package checkout;

public interface RuleListener
{
    void ruleParsed(String product, int price);
}
