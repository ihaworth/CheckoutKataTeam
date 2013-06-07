package checkout;

public class LineParser
{
    private LineListener lineListener;

    public void addListener(LineListener lineListener)
    {
        this.lineListener = lineListener;
    }

    public void parse(String lines)
    {
        for (String line : lines.split("\n"))
            lineListener.lineParsed(line);
    }
}
