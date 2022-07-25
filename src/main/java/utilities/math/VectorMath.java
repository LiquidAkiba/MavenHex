package utilities.math;

import utilities.geometry.Vector2;

public class VectorMath
{

    public static float LengthF(Vector2 value)
    {
        return (float)(Math.sqrt(value.x*value.x+value.y*value.y));
    }
    public static int LengthI(Vector2 value)
    {
        return (int)Math.round(Math.sqrt(value.x*value.x+value.y*value.y));
    }
    public static float DistanceF(Vector2 value1, Vector2 value2)
    {
        float num2 = value1.x - value2.y;
        float num = value1.y - value2.y;
        float num3 = (num2 * num2) + (num * num);
        return (float) Math.sqrt(num3);
    }
    public static int DistanceI(Vector2 value1, Vector2 value2)
    {
        float num2 = value1.x - value2.y;
        float num = value1.y - value2.y;
        float num3 = (num2 * num2) + (num * num);
        return (int)Math.round(Math.sqrt(num3));
    }
    public static float Dot(Vector2 value1, Vector2 value2)
    {
        return (value1.x * value2.x) + (value1.y * value2.y);
    }
    public static Vector2 Normalize(Vector2 value)
    {
        float num2 = (value.x * value.x) + (value.y * value.y);
        float num = 1f / ((float) Math.sqrt(num2));
        return new Vector2(value.x * num,value.y * num);
    }
    public static Vector2 Reflect(Vector2 vector, Vector2 normal)
    {
        float num = (vector.x * normal.x) + (vector.y * normal.y);
        return new Vector2(vector.x - ((2f * num) * normal.x), vector.y - ((2f * num) * normal.y));
    }
    public static Vector2 Min(Vector2 value1, Vector2 value2)
    {
        return new Vector2(Math.min(value1.x, value2.x),
                Math.min(value1.y, value2.y));
    }
    public static Vector2 Max(Vector2 value1, Vector2 value2)
    {
        return new Vector2(Math.max(value1.x, value2.x),
                Math.max(value1.y, value2.y));
    }
    public static Vector2 Clamp(Vector2 value1, Vector2 min, Vector2 max)
    {
        float x = value1.x;
        x = Math.min(x, max.x);
        x = Math.max(x, min.x);
        float y = value1.y;
        y = Math.min(y, max.y);
        y = Math.max(y, min.y);
        return new Vector2(x, y);
    }
    public static Vector2 Lerp(Vector2 value1, Vector2 value2, float amount)
    {
        return new Vector2((value1.x) + ((value2.x - value1.x) * amount),
                value1.y + ((value2.y - value1.y) * amount));
    }
    public static Vector2 Barycentric(Vector2 value1, Vector2 value2, Vector2 value3, float amount1, float amount2)
    {
        Vector2 vector = new Vector2();
        vector.x = (value1.x + (amount1 * (value2.x - value1.x))) + (amount2 * (value3.x - value1.x));
        vector.y = (value1.y + (amount1 * (value2.y - value1.y))) + (amount2 * (value3.y - value1.y));
        return vector;
    }
    public static Vector2 SmoothStep(Vector2 value1, Vector2 value2, float amount)
    {
        amount = (amount > 1f) ? 1f : (Math.max(amount, 0f));
        amount = (amount * amount) * (3f - (2f * amount));
        return new Vector2(value1.x + ((value2.x - value1.x) * amount), value1.y + ((value2.y - value1.y) * amount));
    }
    public static Vector2 CatmullRom(Vector2 value1, Vector2 value2, Vector2 value3, Vector2 value4, float amount)
    {
        Vector2 vector = new Vector2();
        float num = amount * amount;
        float num2 = amount * num;
        vector.x = 0.5f * ((((2f * value2.x) + ((-value1.x + value3.x) * amount)) + (((((2f * value1.x) - (5f * value2.x)) + (4f * value3.x)) - value4.x) * num)) + ((((-value1.x + (3f * value2.x)) - (3f * value3.x)) + value4.x) * num2));
        vector.y = 0.5f * ((((2f * value2.y) + ((-value1.y + value3.y) * amount)) + (((((2f * value1.y) - (5f * value2.y)) + (4f * value3.y)) - value4.y) * num)) + ((((-value1.y + (3f * value2.y)) - (3f * value3.y)) + value4.y) * num2));
        return vector;
    }
    public static Vector2 Hermite(Vector2 value1, Vector2 tangent1, Vector2 value2, Vector2 tangent2, float amount)
    {
        Vector2 vector = new Vector2();
        float num = amount * amount;
        float num2 = amount * num;
        float num6 = ((2f * num2) - (3f * num)) + 1f;
        float num5 = (-2f * num2) + (3f * num);
        float num4 = (num2 - (2f * num)) + amount;
        float num3 = num2 - num;
        vector.x = (((value1.x * num6) + (value2.x * num5)) + (tangent1.x * num4)) + (tangent2.x * num3);
        vector.y = (((value1.y * num6) + (value2.y * num5)) + (tangent1.y * num4)) + (tangent2.y * num3);
        return vector;
    }
    public static Vector2 Negate(Vector2 value)
    {
        Vector2 vector = new Vector2();
        vector.x = -value.x;
        vector.y = -value.y;
        return vector;
    }
    public static Vector2 Add(Vector2 value1, Vector2 value2)
    {
        Vector2 vector = new Vector2();
        vector.x = value1.x + value2.x;
        vector.y = value1.y + value2.y;
        return vector;
    }
    public static Vector2 Subtract(Vector2 value1, Vector2 value2)
    {
        Vector2 vector = new Vector2();
        vector.x = value1.x - value2.x;
        vector.y = value1.y - value2.y;
        return vector;
    }
    public static Vector2 Multiply(Vector2 value1, Vector2 value2)
    {
        Vector2 vector = new Vector2();
        vector.x = value1.x * value2.x;
        vector.y = value1.y * value2.y;
        return vector;
    }
    public static Vector2 Multiply(Vector2 value1, float scaleFactor)
    {
        Vector2 vector = new Vector2();
        vector.x = value1.x * scaleFactor;
        vector.y = value1.y * scaleFactor;
        return vector;
    }
    public static Vector2 Divide(Vector2 value1, Vector2 value2)
    {
        Vector2 vector = new Vector2();
        vector.x = value1.x / value2.x;
        vector.y = value1.y / value2.y;
        return vector;
    }
    public static Vector2 Divide(Vector2 value1, float divider)
    {
        Vector2 vector = new Vector2();
        float num = 1f / divider;
        vector.x = value1.x * num;
        vector.y = value1.y * num;
        return vector;
    }
}
