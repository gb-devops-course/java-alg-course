package pow;

public class PowUtil {

    public static double pow(double number, int power) {
        if (power < 0) {
            return 1.0 / number * pow(number, power + 1);
        } else if (power > 0) {
            return number * pow(number, power - 1);
        }

        return 1;
    }
}
