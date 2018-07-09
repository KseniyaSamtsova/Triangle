package triangleTests;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import triangle.Triangle;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;

@RunWith(Parameterized.class)
public class TrinagleQualityTest {
    private Triangle triangle;
    public TrinagleQualityTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
    };

    @Parameterized.Parameters
    public static Collection<Object[]> triangleDate(){
        return Arrays.asList(new Object[][]{
                {0,5,3},{1,0,1}, {1,1,0}, {-1, 1, 2}, {2, -2, 3}, {3, 2, -5}, {1,1,2}, {3,1,1}, {1,2, Double.MAX_VALUE},
        });
    };
    @Test
    public void checkTriangleTest(){
        Assert.assertThat(triangle.checkTriangle(), CoreMatchers.is(false));
    }
}
