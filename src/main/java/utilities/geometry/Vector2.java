package utilities.geometry;

public class Vector2
{
    public float x;
    public float y;

    public Vector2()
    {
        set(0,0);
    }
    public Vector2(float x,float y)
    {
        set(x,y);
    }
    public void set(float x,float y)
    {
        this.x = x;
        this.y = y;
    }
    public void set(int  x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
