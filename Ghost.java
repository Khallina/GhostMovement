import java.awt.*;
import java.util.List;
import java.util.Observable;

public class Ghost extends Observable implements Drawable {
    private static int positionX;
    private static int positionY;
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    public Ghost(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void draw(Graphics g) {
        if (positionX > 400) positionX = 400;
        if (positionY > 400) positionY = 400;
        if (positionX < 0) positionX = 0;
        if (positionX < 0) positionY = 0;


        g.setColor(Color.RED);
        g.fillArc(positionX, positionY, 20, 20, 0, 180);
        g.fillRect(positionX, positionY + 8, 20, 15);
        int[] xPoints1 = {positionX, positionX + 4, positionX + 10};
        int[] yPoints1 = {positionY + 19, positionY + 28, positionY + 20};
        g.fillPolygon(xPoints1, yPoints1, 3);
        int[] xPoints2 = {positionX + 5, positionX + 8, positionX + 15};
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

    public void move(Graphics g) {
        while (true) { // Continuously move until the ghost reaches the spider (or some other termination condition)
            Point spiderPosition = new Point(DummySpider.getPosX(), DummySpider.getPosY());
            Point ghostPosition = new Point(positionX, positionY);

            // Check if ghost has reached spider
            if (ghostPosition.equals(spiderPosition)) {
                break; // Exit the loop if the ghost reaches the spider
            }

            g.setColor(BACKGROUND_COLOR);
            g.fillRect(positionX, positionY, 30, 30);

            // Move ghost towards spider
            if (ghostPosition.getX() < spiderPosition.getX()) {
                positionX++;
            } else if (ghostPosition.getX() > spiderPosition.getX()) {
                positionX--;
            }

            if (ghostPosition.getY() < spiderPosition.getY()) {
                positionY++;
            } else if (ghostPosition.getY() > spiderPosition.getY()) {
                positionY--;
            }

            draw(g);

            // Notify any waiting threads that the position has changed
            synchronized (this) {
                notifyAll();
            }
            //movement algorithm
            //positionX++; positionY++;
            //if (positionX>500) positionX = 0;
            //if (positionY>500) positionY = 0;

            try {
                // Wait for some time before updating again
                Thread.sleep(500); // Adjust the delay as needed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


    }
}