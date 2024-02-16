import java.awt.*;

public class DummySpider {
    private int posX;
    private int posY;

    public DummySpider(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    public void draw(Graphics g){


        int x = this.getPosX();
        int y = this.getPosY();
        g.setColor(Color.BLACK);
        g.fillRect(x,y,5,5);
    }



}
