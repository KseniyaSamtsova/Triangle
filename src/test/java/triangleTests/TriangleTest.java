package triangleTests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import triangle.Triangle;

public class TriangleTest {
    private final static String A_IS_LESS_OR_EQUALS_ZERO = "a<=0";
    private final static String B_IS_LESS_OR_EQUALS_ZERO = "b<=0";
    private final static String C_IS_LESS_OR_EQUALS_ZERO = "c<=0";
    private final static String A_PLUS_B_IS_LESS_OR_EQUALS_C = "a+b<=c";
    private final static String A_PLUS_C_IS_LESS_OR_EQUALS_B = "a+c<=b";
    private final static String B_PLUS_C_IS_LESS_OR_EQUALS_A = "b+c<=a";


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
        Triangle triangle = new Triangle(3, 1, -5);
        triangle.checkTriangle();
        Assert.assertThat(triangle.getMessage(), CoreMatchers.is(C_IS_LESS_OR_EQUALS_ZERO));
    }

    @Test
    public void test_a_plus_b_is_less_or_equals_c(){
        Triangle triangle = new Triangle(1, 2, 8);
        triangle.checkTriangle();
        Assert.assertThat(triangle.getMessage(), CoreMatchers.is(A_PLUS_B_IS_LESS_OR_EQUALS_C));
    }

    @Test
    public void test_a_plus_c_is_less_or_equals_b(){
        Triangle triangle = new Triangle(1, 22, 12);
        triangle.checkTriangle();
        Assert.assertThat(triangle.getMessage(), CoreMatchers.is(A_PLUS_C_IS_LESS_OR_EQUALS_B));
    }

    @Test
    public void test_b_plus_c_is_less_or_equals_a(){
        Triangle triangle = new Triangle(12, 8, 1);
        triangle.checkTriangle();
        Assert.assertThat(triangle.getMessage(), CoreMatchers.is(B_PLUS_C_IS_LESS_OR_EQUALS_A));
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
    public void test_is_ORDINARY(){
        Triangle triangle = new Triangle(3, 4.5, 4.6);
        Assert.assertThat(triangle.detectTriangle(), CoreMatchers.is(4));
    }

    @Test
    public void test_is_RECTANGULAR(){
        Triangle triangle = new Triangle(3, 4, 5);
        Assert.assertThat(triangle.detectTriangle(), CoreMatchers.is(8));
    }


    @Test
    public void test_square(){
        double a = 5;
        double b = 3;
        double c = 4;
        Triangle triangle = new Triangle(a,b,c);
        boolean resultOfCheck = triangle.checkTriangle();
        Assert.assertTrue(resultOfCheck);
        double p = (a + b + c) / 2;
        double expect = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        Assert.assertThat(triangle.getSquare(), CoreMatchers.is(expect));
    }
}
