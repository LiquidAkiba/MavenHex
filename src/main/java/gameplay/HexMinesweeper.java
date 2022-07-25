package gameplay;

import java.awt.Point;
import java.util.ArrayList;

public class HexMinesweeper extends Minesweeper
{
    public HexMinesweeper()
    {
        super();
    }

    @Override
    public ArrayList<Point> GetSurroundCells(int x, int y)
    {
        ArrayList<Point> p = new ArrayList<>();
        if(InRange(x-1,y))
            p.add(new Point(x-1, y));
        if(InRange(x+1,y))
            p.add(new Point(x+1,y));
        if(InRange(x,y-1))
            p.add(new Point(x,y-1));
        if (InRange(x,y+1))
            p.add(new Point(x,y+1));

        if (x%2 == 0)
        {
            if(InRange(x-1,y-1))
                p.add(new Point(x-1,y-1));
            if(InRange(x+1,y-1))
                p.add(new Point(x+1,y-1));
        }else
        {
            if(InRange(x-1,y+1))
                p.add(new Point(x-1,y+1));
            if(InRange(x+1,y+1))
                p.add(new Point(x+1,y+1));
        }
        return p;
    }
    public float  WidthInOuterRadius()
    {
        return (float)(width * 1.5 + 0.5);
    }
    public float HeightInInnerRadius()
    {
        return (float)(height * 2 + 1);
    }

    public float HeightInOuterRadius()
    {
        return (float)((Math.sqrt(3)*HeightInInnerRadius())/2);
    }
}
