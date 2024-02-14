import java.awt.*;

public class Ghost implements Drawable {
    private int positionX;
    private int positionY;

    public void draw(Graphics g) {
        if (Math.random()>0.5)
            if (Math.random()>0.5)
                positionX += 20;
            else
                positionX -= 20;
        else
            if (Math.random()>0.5)
                positionY += 20;
            else
                positionY -= 20;

        if(positionX > 400) positionX = 400;
        if(positionY > 400) positionY = 400;
        if(positionX < 0) positionX = 0;
        if(positionX < 0) positionY = 0;


        g.setColor(Color.RED);
        g.fillArc(positionX, positionY, 20, 20, 0, 180);
        g.fillRect(positionX, positionY+8, 20, 15);
        int[] xPoints1 = {positionX, positionX + 4, positionX+10};
        int[] yPoints1 = {positionY + 19, positionY + 28, positionY + 20};
        g.fillPolygon(xPoints1, yPoints1, 3);
        int[] xPoints2 = {positionX + 5, positionX + 8, positionX+15};
        int[] yPoints2 = {positionY + 20, positionY + 28, positionY + 20};
        g.fillPolygon(xPoints2, yPoints2, 3);
        int[] xPoints3 = {positionX + 10, positionX + 15, positionX + 20};
        int[] yPoints3 = {positionY + 20, positionY + 28, positionY + 20};
        g.fillPolygon(xPoints3, yPoints3, 3);
        g.setColor(Color.WHITE);
        g.fillOval(positionX + 3, positionY + 6, 5, 5);
        g.fillOval(positionX + 11, positionY + 6, 5, 5);
        g.setColor(Color.BLUE);
        g.fillOval(positionX + 4, positionY + 7, 3, 3);
        g.fillOval(positionX + 12, positionY + 7, 3, 3);
    }

    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
