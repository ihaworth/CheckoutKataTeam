package checkout;

public class CheckOut
{
    private int total = 0;
    private String rules;
    private RuleStore ruleStore;

    public CheckOut(String rules)
    {
        this.rules = rules;

        LineParser lineParser = new LineParser();
        RuleParser ruleParser = new RuleParser();
        RuleFactory ruleFactory = new RuleFactory();
        ruleStore = new RuleStore();

        lineParser.addListener(ruleParser);
        ruleParser.addListener(ruleFactory);
        ruleFactory.addListener(ruleStore);

        lineParser.parse(rules);
    }

    public void scan(String item)
    {
        total = ruleStore.priceProduct(item);
    }

    public int total()
    {
        return total;
    }
}
