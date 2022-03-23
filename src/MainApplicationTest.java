import org.junit.jupiter.api.Test;

public class MainApplicationTest {
    public MainApplication mainApplication;

    @Test
    public void shouldFindOneBoomerang() {
        double[][] points = new double[3][2];
        points[0] = new double[] {0,0};
        points[1] = new double[] {1,0};
        points[2] = new double[] {2,0};
        int result = mainApplication.numberOfBoomerangs(points);

        assert result == 1;
    }

    @Test
    public void shouldFindThreeBoomerangsEquidistant() {
        double[][] points = new double[3][2];
        points[0] = new double[] {0,0};
        points[1] = new double[] {1,Math.sqrt(3)};
        points[2] = new double[] {2,0};
        int result = mainApplication.numberOfBoomerangs(points);

        assert result == 3;
    }

    @Test
    public void shouldFindFourBoomerangs() {
        double[][] points = new double[4][2];
        points[0] = new double[] {0,0};
        points[1] = new double[] {1,0};
        points[2] = new double[] {-1,0};
        points[3] = new double[] {0,1};
        int result = mainApplication.numberOfBoomerangs(points);

        assert result == 4;
    }

    @Test
    public void shouldFindNoBoomerangs() {
        double[][] points = new double[4][2];
        points[0] = new double[] {0,0};
        points[1] = new double[] {10,0};
        points[2] = new double[] {-15,0};
        points[3] = new double[] {0,19};
        int result = mainApplication.numberOfBoomerangs(points);

        assert result == 0;
    }

    @Test
    public void shouldReturnZeroWithNoInput() {
        int result = mainApplication.numberOfBoomerangs(null);

        assert result == 0;
    }

}
