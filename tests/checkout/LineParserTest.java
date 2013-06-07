package checkout;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class LineParserTest
{
    private LineParser lineParser;
    private LineListener listener;

    @Before
    public void setUp()
    {
        lineParser = new LineParser();
        listener = mock(LineListener.class);
        lineParser.addListener(listener);
    }

    @Test
    public void aOneLineFileParsesOneLine()
    {
        lineParser.parse("One line");

        verify(listener).lineParsed("One line");
    }

    @Test
    public void aTwoLineFileParsesTwoLines()
    {
        lineParser.parse("line one\n" +
                "line two");

        verify(listener).lineParsed("line one");
        verify(listener).lineParsed("line two");
    }
}
