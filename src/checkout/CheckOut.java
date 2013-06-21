package checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckOut
{
    private RuleStore ruleStore;
    private Map<String, Integer> itemsQuantity;

    public CheckOut(String rules)
    {
        itemsQuantity = new HashMap<String, Integer>();
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
        incrementItemCount(item);
    }

    private void incrementItemCount(String item)
    {
        if (!itemsQuantity.containsKey(item)){
            itemsQuantity.put(item, 0);
        }

        int currentCount = itemsQuantity.get(item);

        itemsQuantity.put(item, currentCount + 1);
    }

    public int total()
    {
        int total = 0;

        for (String item : itemsQuantity.keySet()) {

            int quantity = itemsQuantity.get(item);
            total += ruleStore.priceProduct(item, quantity);
        }

        return total;
    }
}
