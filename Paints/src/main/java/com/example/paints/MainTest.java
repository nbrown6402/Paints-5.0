package com.example.paints;

import javafx.scene.paint.Color;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MainTest {

    public MainTest() {
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

    /**
     * Test of setLineColor method, of class DrawCanvas.
     */
    @Test
    public void testSetLineColor() {
        System.out.println("setLineColor");
        Color color = Color.MAROON;
        HelloController instance = new HelloController();
        instance.setColor(color);
        System.out.println(instance.getColor());
        assertEquals(color, instance.getColor());   //if getLineColor returns value defined above, we good
    }

    /**
     * Test of setLineWidth method, of class DrawCanvas.
     */
    @Test
    public void testSetLineWidth() {
        System.out.println("setLineWidth");
        String width = "50";
        HelloController instance = new HelloController();
        instance.setBrush(width);
        //had to add a third param delta
        assertEquals("50",instance.getBrush(),"0.1"); //if getLineWidth returns value defined above, we good
    }
}
