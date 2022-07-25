package utilities;

public class MathHelper
{
    public static double round(double value, int decimalPlace)
    {
        double power_of_ten = 1;
        //introduce a "fudge factor" as maths can be evil.
        double fudge_factor = 0.05;
        while (decimalPlace-- > 0) {
            power_of_ten *= 10.0d;
            fudge_factor /= 10.0d;
        }
        return Math.round((value + fudge_factor)* power_of_ten)  / power_of_ten;
    }
}
