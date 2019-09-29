import java.util.concurrent.ThreadLocalRandom;

public class EditDistanceTest{
    private static int[] M;
    private static EditDistanceAlgorithm algorithm;
    private static String string1, string2;

    @BeforeClass
    public static void setUp() {
        StringGenerator sg = new StringGenerator();
        algorithm = new EditDistanceAlgorithm();
        int min = (int) Math.pow(2, 10);
        int max = (int) Math.pow(2, 13);
        M = new int[]{20 * min, 40 * min, 80 * min};
        int len1 = ThreadLocalRandom.current().nextInt(min, max + 1);
        int len2 = ThreadLocalRandom.current().nextInt(min, max + 1);
        string1 = sg.generateString(len1);
        string2 = sg.generateString(len2);
        System.out.println(String.format("String 1: %s", string1));
        System.out.println(String.format("String 2: %s", string2));
    }

    @Test
    public void testAlgorithm() {
        long startTime = System.currentTimeMillis();
        int result = algorithm.computeEditDistance(string1, string2);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Elapsed time: %d", endTime-startTime));
        System.out.println(String.format("Edit distance: %d", result));
    }




}