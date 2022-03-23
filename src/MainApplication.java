import java.util.HashMap;
import java.util.Map;

public class MainApplication {

    public static int numberOfBoomerangs(double[][] points) {
        int result = 0;

        if(points == null || points.length == 0) {
            return result;
        }

        Map<Double, Integer> distances = new HashMap<>();

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j)
                    continue;

                double distance = Math.round(getDistance(points[i], points[j]));
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }
            for(int frequencies : distances.values()) {
                if(frequencies >= 3) {
                    result += frequencies;
                } else if(frequencies > 1) {
                    result += (frequencies - 1);
                }
            }
            distances.clear();
        }

        return result;
    }

    private static double getDistance(double[] a, double[] b) {
        double x = a[0] - b[0];
        double y = a[1] - b[1];

        return x*x + y*y;
    }


}
