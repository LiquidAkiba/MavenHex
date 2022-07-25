import minesweeper.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainFormTest {

@Test
void checkSize()
{
    int testWidth = MainForm.WIDTH;
    assertEquals (1,testWidth);

}

}
