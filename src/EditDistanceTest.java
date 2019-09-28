import java.util.concurrent.ThreadLocalRandom;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class EditDistanceTest{
    private int[] M;
    private EditDistanceAlgorithm algorithm;
    private String string1, string2;

    @Before
    public void setUp() {
        StringGenerator sg = new StringGenerator();
        algorithm = new EditDistanceAlgorithm();
        int min = (int) Math.pow(2, 10);
        int max = (int) Math.pow(2, 13);
        M = new int[]{20 * min, 40 * min, 80 * min};
        int len1 = ThreadLocalRandom.current().nextInt(min, max + 1);
        int len2 = ThreadLocalRandom.current().nextInt(min, max + 1);
        string1 = sg.generateString(len1);
        string2 = sg.generateString(len2);
    }

    @Test
    public void testAlgorithm() {
        System.out.println(string1);
        System.out.println(string2);
        long startTime = System.currentTimeMillis();
        int result = algorithm.computeEditDistance(string1, string2);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(result);
    }




}