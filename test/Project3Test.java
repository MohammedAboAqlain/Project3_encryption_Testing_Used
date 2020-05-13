/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import project3.Project3;

/**
 *
 * @author Soma
 */
public class Project3Test {
    
    public Project3Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testHexadecimalCiphering(){
        assertEquals("4A 41 56 41 20 50 52 4F 47 52 41 4D 4D 49 4E 47"
                , project3.Project3.HexadecimalCiphering("JAVA PROGRAMMING"));
    }
    @Test
    public void testHexadecimalDeciphering(){
        assertEquals("JAVA PROGRAMMING"
        , project3.Project3.HexadecimalDeciphering("4A 41 56 41 20 50 52 4F 47 52 41 4D 4D 49 4E 47"));
    }
    @Test
    public void testATBASH_Ciphering(){
        assertEquals("QZEZ KILTIZNNRMT"
                , project3.Project3.ATBASH("JAVA PROGRAMMING"));
    }
    @Test
    public void testATBASH_Deciphering(){
        assertEquals("JAVA PROGRAMMING"
                , project3.Project3.ATBASH("QZEZ KILTIZNNRMT"));
    }
    @Test
    public void testVigenereCiphering(){
        assertEquals("BEXR TKGKTRQFARI"
                , project3.Project3.VigenereCiphering("JAVA PROGRAMMING"));
    }
    @Test
    public void testVigenereDeciphering(){
        assertEquals("JAVA PROGRAMMING"
                , project3.Project3.VigenereDeciphering("BEXR TKGKTRQFARI"));
    }
    @Test
    public void test1HexToDecimal(){
        String s = "4A";
        int result = 74;
        assertEquals(result, project3.Project3.hexToDecimal(s));
    }
    @Test
    public void test2HexToDecimal(){
        String s = "";
        int result = 0;
        assertEquals(result, project3.Project3.hexToDecimal(s));
    }
    @Test
    public void test1HexCharToDecimal(){
        char s = 'D';
        int result = 13;
        assertEquals(result, project3.Project3.hexCharToDecimal(s));
    }
    @Test
    public void test2HexCharToDecimal(){
        char s = '7';
        int result = 7;
        assertEquals(result, project3.Project3.hexCharToDecimal(s));
    }
    @Test
    public void testkey(){
        String result = "Hexadecimal";
        assertEquals(result, project3.Project3.key(2));
    }
    @Test
    public void testletterRank(){
        int result = 2;
        assertEquals(result, project3.Project3.letterRank('B'));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
