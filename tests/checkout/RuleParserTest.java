package checkout;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class RuleParserTest
{
    private RuleParser ruleParser;
    private RuleListener listener;

    @Before
    public void setUp(){
        ruleParser = new RuleParser();
        listener = mock(RuleListener.class);
        ruleParser.addListener(listener);
    }

    @Test
    public void canParseASinglePrice()
    {
        ruleParser.parse("A\t50");

        verify(listener).ruleParsed("A", 50);
    }

    @Test
    public void canParseAnotherSinglePrice()
    {
        ruleParser.parse("B\t30");

        verify(listener).ruleParsed("B", 30);
    }
}
