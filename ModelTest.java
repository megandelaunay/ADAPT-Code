

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ModelTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ModelTest
{
    /**
     * Default constructor for test class ModelTest
     */
    public ModelTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test public void testDigits()
    {
        Model m0 = new Model("two");
        String out0 = m0.transcode();
        assertEquals("2", out0);
        
        Model m1 = new Model("six");
        String out1 = m1.transcode();
        assertEquals("6", out1);
        
        Model m2 = new Model("nine");
        String out2 = m2.transcode();
        assertEquals("9", out2);
    }
    
    @Test public void testTeens()
    {
        Model m0 = new Model("twelve");
        String out0 = m0.transcode();
        assertEquals("12", out0);
        
        Model m1 = new Model("fourteen");
        String out1 = m1.transcode();
        assertEquals("14", out1);
        
        Model m2 = new Model("seventeen");
        String out2 = m2.transcode();
        assertEquals("17", out2);
    }
    
    @Test public void testDecades()
    {
        Model m0 = new Model("twenty four");
        String out0 = m0.transcode();
        assertEquals("24", out0);
        
        Model m1 = new Model("eighty");
        String out1 = m1.transcode();
        assertEquals("80", out1);
        
        Model m2 = new Model("ten");
        String out2 = m2.transcode();
        assertEquals("10", out2);
    }
    
    @Test public void testHundred()
    {
        Model m0 = new Model("six hundred eleven");
        String out0 = m0.transcode();
        assertEquals("611", out0);
        
        Model m1 = new Model("nine hundred forty");
        String out1 = m1.transcode();
        assertEquals("940", out1);
        
        Model m2 = new Model("three hundred five");
        String out2 = m2.transcode();
        assertEquals("305", out2);
        
        Model m3 = new Model("one hundred");
        String out3 = m3.transcode();
        assertEquals("100", out3);
    }
    
    @Test public void testThousands()
    {
        Model m0 = new Model("five thousand four hundred thirty two");
        String out0 = m0.transcode();
        assertEquals("5432", out0);
        
        Model m1 = new Model("nine thousand six hundred ten");
        String out1 = m1.transcode();
        assertEquals("9610", out1);
        
        Model m2 = new Model("eight thousand seven hundred six");
        String out2 = m2.transcode();
        assertEquals("8706", out2);
        
        Model m3 = new Model("two thousand forty seven");
        String out3 = m3.transcode();
        assertEquals("2047", out3);
        
        Model m4 = new Model("one thousand two hundred");
        String out4 = m4.transcode();
        assertEquals("1200", out4);
        
        Model m5 = new Model("four thousand eighty");
        String out5 = m5.transcode();
        assertEquals("4080", out5);
        
        Model m6 = new Model("seven thousand six");
        String out6 = m6.transcode();
        assertEquals("7006", out6);
        
        Model m7 = new Model("three thousand");
        String out7 = m7.transcode();
        assertEquals("3000", out7);
    }
    
    
    
    @Test public void testTenThousands()
    {
        Model m0 = new Model("twelve thousand four hundred thirty two");
        String out0 = m0.transcode();
        assertEquals("12432", out0);
        
        Model m1 = new Model("forty thousand six hundred ten");
        String out1 = m1.transcode();
        assertEquals("40610", out1);
    }
   
    
    @Test public void testHundredThousands()
    {
        Model m0 = new Model("five hundred eighty two thousand six hundred eleven");
        String out0 = m0.transcode();
        assertEquals("582611", out0);
        
        Model m1 = new Model("nine hundred seventy thousand four hundred eighty two");
        String out1 = m1.transcode();
        assertEquals("970482", out1);
        
        Model m2 = new Model("one hundred six thousand five hundred twenty seven");
        String out2 = m2.transcode();
        assertEquals("106527", out2);
        
        Model m3 = new Model("four hundred thousand nine hundred fifteen");
        String out3 = m3.transcode();
        assertEquals("400915", out3);
    }
    
    
    
    @Test public void testMillions()
    {
        Model m0 = new Model("eight million four hundred thirty thousand six hundred eight");
        String out0 = m0.transcode();
        assertEquals("8430608", out0);      
    }
    
    /*
    
    @Test public void testTenMillions()
    {
        Model m0 = new Model("forty three million nine hundred twelve thousand six hundred eighty one");
        String out0 = m0.transcode();
        assertEquals("43912681", out0);
        
        Model m1 = new Model("thiry million six thousand four hundred twenty one");
        String out1 = m1.transcode();
        assertEquals("30006421", out1);
    }
    
    @Test public void testHundredMillions()
    {
        Model m0 = new Model("four hundred million two hundred forty five thousand six hundred twelve");
        String out0 = m0.transcode();
        assertEquals("400245612", out0);
        
        Model m1 = new Model("six hundred eighty million");
        String out1 = m1.transcode();
        assertEquals("680000000", out1);
        
        Model m2 = new Model("five hundred fifty five million eight hundred sixteen thousand nine hundred thirty seven");
        String out2 = m2.transcode();
        assertEquals("555816937", out2);
        
        Model m3 = new Model("six hundred two million forty five thousand eight");
        String out3 = m3.transcode();
        assertEquals("602045008", out3);
    }
    
    */
}
