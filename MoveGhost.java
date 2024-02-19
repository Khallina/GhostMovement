import java.awt.*;

public class MoveGhost {

    private int positionX;
    private int positionY;
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    public MoveGhost(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public void move(Graphics g) {
        Ghost ghost = new Ghost(40, 25);
        while (true) { // Continuously move until the ghost reaches the spider (or some other termination condition)
            Point spiderPosition = new Point(DummySpider.getPosX(), DummySpider.getPosY());
            Point ghostPosition = new Point(positionX, positionY);

            // Check if ghost has reached spider
            if (ghostPosition.equals(spiderPosition)) {
                break; // Exit the loop if the ghost reaches the spider
            }

            g.setColor(BACKGROUND_COLOR);
            g.fillRect(ghostPosition.x, ghostPosition.y, 30, 30);

            // Move ghost towards spider
            if (ghostPosition.x < spiderPosition.x) {
                ghost.setPositionX(positionX++);

            } else if (ghostPosition.x > spiderPosition.x) {
                ghost.setPositionX(positionX--);

            }

            if (ghostPosition.y < spiderPosition.y) {
                ghost.setPositionY(positionY++);

            } else if (ghostPosition.y > spiderPosition.y) {
                ghost.setPositionY(positionY--);

            }

            ghost.draw(g);

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
