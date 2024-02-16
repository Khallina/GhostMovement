import java.awt.*;

public class DummySpider {
    private static int posX;
    private static int posY;

    public DummySpider(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public static int getPosX() {
        return posX;
    }

    public static int getPosY() {
        return posY;
    }


    public void draw(Graphics g){


        int x = this.getPosX();
        int y = this.getPosY();
        g.setColor(Color.BLACK);
        g.fillRect(x,y,5,5);
    }



}
