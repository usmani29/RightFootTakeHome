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
            for(int frequency : distances.values()) {
                if(frequency >= 3) {
                    result += frequency;
                } else if(frequency > 1) {
                    result += (frequency - 1);
                }
            }
            distances.clear();
        }

        return result;
    }

    public static int numberOfBoomerangsBruteForce(double[][] points) {
        int result = 0;

        if(points == null || points.length == 0) {
            return result;
        }

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                for(int k = j + 1; k < points.length; k++) {
                    if(i == j) {
                        continue;
                    }
                    double distanceJ = Math.round(getDistance(points[i], points[j]));
                    double distanceK = Math.round(getDistance(points[i], points[k]));
                    if(distanceJ == distanceK) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private static double getDistance(double[] a, double[] b) {
        double x = a[0] - b[0];
        double y = a[1] - b[1];

        return x*x + y*y;
    }


}
