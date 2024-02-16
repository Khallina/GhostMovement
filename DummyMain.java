import javax.swing.*;
import java.awt.*;

public class DummyMain {
    public static void main(String[] args) {
        DummyWorld dummyWorld = new DummyWorld(100, 50);
        Frame frame = new Frame("Dummy World Display");
        frame.setSize(300, 200);
        Ghost ghost = new Ghost(40, 25);
        DummySpider dummySpider = new DummySpider(50, 30);

        frame.setVisible(true);
    }

    class dummyWorld extends JPanel {
        private Ghost ghost;
        private DummySpider spider;

        public dummyWorld(Ghost ghost) {
            this.ghost = ghost;
        }

        public dummyWorld(DummySpider spider) {
            this.spider = spider;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ghost.draw(g);
            spider.draw(g);
        }
    }
}
