import java.awt.*;

public class DummyMain {
    public static void main(String[] args) {
        DummyWorld dummyWorld = new DummyWorld(500, 500);
        DummySpider dummySpider = new DummySpider(100,100);
        Frame frame = new Frame("Dummy World Display");
        Ghost ghost = new Ghost(40, 25);
        MoveGhost mg = new MoveGhost(40,25);
        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                dummySpider.draw(g);
                //ghost.draw(g);

                Thread ghostThread = new Thread(() -> {
                    synchronized (mg){
                        mg.move(g);
                    }
                });
                ghostThread.start();

                try {
                    ghostThread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        frame.add(canvas);

        frame.setSize(dummyWorld.getLength(), dummyWorld.getWidth());
        frame.setVisible(true);

    }
}
