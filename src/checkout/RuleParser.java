package checkout;

final class RuleParser implements LineListener
{
    private RuleListener ruleListener;

    @Override
    public void lineParsed(String line)
    {
        parse(line);
    }

    public void addListener(RuleListener ruleListener)
    {
        this.ruleListener = ruleListener;
    }

    public void parse(String rule)
    {
        String[] ruleParts = rule.split("\t");

        String product = ruleParts[0];
        int price = Integer.parseInt(ruleParts[1]);

        if(ruleParts.length > 2) {
            String specialOffer = ruleParts[2];
            String[] ruleParts2 = specialOffer.split(" for ");

            int quantity = Integer.parseInt(ruleParts2[0]);
            int discountedPrice = Integer.parseInt(ruleParts2[1]);

            ruleListener.ruleParsed(product, price, quantity, discountedPrice);
        }else {
            ruleListener.ruleParsed(product, price);
        }
    }
}