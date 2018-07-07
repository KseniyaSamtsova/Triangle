package triangleTests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import triangle.Triangle;

public class TriangleMessageTest {
    private final static String A_IS_LESS_OR_EQUALS_ZERO = "a<=0";
    private final static String B_IS_LESS_OR_EQUALS_ZERO = "b<=0";
    private final static String C_IS_LESS_OR_EQUALS_ZERO = "c<=0";
    private final static String A_PLUS_B_IS_LESS_OR_EQUALS_C = "a+b<=c";

    @Test
    public void test_a_is_less_or_equals_zero(){
        Triangle triangle = new Triangle(0, 1, 2);
        triangle.checkTriangle();
        Assert.assertThat(triangle.getMessage(), CoreMatchers.is(A_IS_LESS_OR_EQUALS_ZERO));
    }
    @Test
    public void test_b_is_less_or_equals_zero(){
        Triangle triangle = new Triangle(3, -1, 2);
        triangle.checkTriangle();
        Assert.assertThat(triangle.getMessage(), CoreMatchers.is(B_IS_LESS_OR_EQUALS_ZERO));
    }
    @Test
    public void test_c_is_less_or_equals_zero(){
        Triangle triangle = new Triangle(3, 1, 0);
        triangle.checkTriangle();
        Assert.assertThat(triangle.getMessage(), CoreMatchers.is(C_IS_LESS_OR_EQUALS_ZERO));
    }
    @Test
    public void test_is_EQUILATERAL(){
        Triangle triangle = new Triangle(1, 1, 1);
        Assert.assertThat(triangle.detectTriangle(), CoreMatchers.is(1));
    }
    @Test
    public void test_is_ISOSCELES(){
        Triangle triangle = new Triangle(1, 2, 2);
        Assert.assertThat(triangle.detectTriangle(), CoreMatchers.is(2));
    }

    @Test
    public void test_square(){
        double a = 0.2356;
        double b = 0.2356;
        double c = 0.235612121212122212121;
        Triangle triangle = new Triangle(a,b,c);
        double p = (a+b+c)/2;
        double expect = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        Assert.assertThat(triangle.getSquare(), CoreMatchers.is(expect));
    }
   /* @Test
    public void test_square2(){
        double a = -0.2356;
        double b = -0.2356;
        double c = -0.2356;
        Triangle triangle = new Triangle(a,b,c);
        double p = (a+b+c)/2;
        double expect = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        //Assert.assertThat(triangle.getSquare(), CoreMatchers.is(expect));
        Assert.assertTrue(triangle.getSquare()>0);
    }*/
}
