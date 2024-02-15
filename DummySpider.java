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

    public void move(int newX, int newY) {
        this.posX = newX;
        this.posY = newY;
    }
}
