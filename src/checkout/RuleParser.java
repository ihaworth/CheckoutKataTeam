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
        ruleListener.ruleParsed(product, price);
    }
}