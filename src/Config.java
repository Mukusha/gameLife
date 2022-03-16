import java.awt.*;

public class Config {
    // задать константы
    public static final int SIZE = 10; // размер одной ячейки в пикселях
    public static final int WIDTCH = 80; // ширина поля в знакоместах
    public static final int HEIGHT = 60; // высота поля
    public static final int SLEEPMS = 100;

    public static Color getColor(Status status) {
        switch (status) {

            case NONE -> {
                return Color.BLACK;
            }
            case BORN -> {
                return Color.GRAY;
            }
            case LIVE -> {
                return Color.WHITE;
            }
            case DIED -> {
                return Color.LIGHT_GRAY;
            }
            default -> {
                return Color.RED;
            }
        }
    }
}
