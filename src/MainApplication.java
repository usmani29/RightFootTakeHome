import java.util.HashMap;
import java.util.Map;

public class MainApplication {

    public static int numberOfBoomerangs(double[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        int result = 0;
        Map<Double, Integer> map = new HashMap<>();

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j)
                    continue;

                double d = Math.round(getDistance(points[i], points[j]));
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for(int val : map.values()) {
                if(val >= 3) {
                    result += val;
                } else if(val > 1) {
                    result += (val - 1);
                }
            }
            map.clear();
        }

        return result;
    }

    private static double getDistance(double[] a, double[] b) {
        double dx = a[0] - b[0];
        double dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }


}
