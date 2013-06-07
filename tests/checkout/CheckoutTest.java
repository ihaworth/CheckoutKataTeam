package checkout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTest
{
    public final static String RULES =
            "A\t50\t3 for 130\n" +
                    "B\t30\t2 for 45\n" +
                    "C\t20\n" +
                    "D\t15\n";

    private CheckOut co;

    public int price(String goods)
    {
        co = new CheckOut(RULES);

        for (int i = 0; i < goods.length(); i++)
        {
            String item = goods.charAt(i) + "";
            co.scan(item);
        }

        return co.total();
    }

    @Test
    public void testTotals()
    {
        assertEquals(  0, price(""));
        assertEquals( 50, price("A"));
        //        assertEquals( 80, price("AB"));
        //        assertEquals(115, price("CDBA"));
        //
        //        assertEquals(100, price("AA"));
        //        assertEquals(130, price("AAA"));
        //        assertEquals(180, price("AAAA"));
        //        assertEquals(230, price("AAAAA"));
        //        assertEquals(260, price("AAAAAA"));
        //
        //        assertEquals(160, price("AAAB"));
        //        assertEquals(175, price("AAABB"));
        //        assertEquals(190, price("AAABBD"));
        //        assertEquals(190, price("DABABA"));
    }

    @Test
    public void testIncremental()
    {
        co = new CheckOut(RULES);

        //        assertEquals(0, co.total());
        //        co.scan("A");  assertEquals( 50, co.total());
        //        co.scan("B");  assertEquals( 80, co.total());
        //        co.scan("A");  assertEquals(130, co.total());
        //        co.scan("A");  assertEquals(160, co.total());
        //        co.scan("B");  assertEquals(175, co.total());
    }
}
