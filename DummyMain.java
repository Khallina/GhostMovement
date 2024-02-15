import java.awt.*;

public class DummyMain {
    public static void main(String[] args) {
        DummyWorld dummyWorld = new DummyWorld(100, 50);
        DummySpider dummySpider = new DummySpider(50,30);
        Frame frame = new Frame("Dummy World Display");
        Ghost ghost = new Ghost(25, 25);

        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int x = dummySpider.getPosX();
                int y = dummySpider.getPosY();
                g.setColor(Color.BLACK);

                g.fillRect(x,y,5,5);

               // g.drawString("Length: " + dummyWorld.getLength(), 50, 100);
               // g.drawString("Width: " + dummyWorld.getWidth(), 50, 120);
            }
        };

        frame.add(canvas);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
