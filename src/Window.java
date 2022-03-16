import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {
    JFrame frame; //то в чем все будет распологаться - поле
    Box[][] boxes;

    @Override
    public void run() {
        initFrame();  //инициализируем окно
        initBoxes();   // инициализируем боксы
        initZimer(); //инициализируем таймер
    }

    //инициализируем окно
    void initFrame() {
        frame = new JFrame(); //создаем окно
        frame.getContentPane().setLayout(null); // расположение на всю форму
        frame.setSize(Config.SIZE * Config.WIDTCH + 25, Config.SIZE * Config.HEIGHT + 45); //размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна и программы по нажатию на крестик
        frame.setLocationRelativeTo(null);//окно по центру экрана
        frame.setVisible(true); // включаем
        frame.setTitle("Life Game");// название игры
    }

    void initBoxes() {
        boxes = new Box[Config.WIDTCH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTCH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }

        for (int x = 0; x < Config.WIDTCH; x++)
            for (int y = 0; y < Config.HEIGHT; y++)
                for (int sx = -1; sx<=+1; sx++)
                   for (int sy = -1; sy<=+1; sy++)
                        if (!(sx == 0 && sy == 0))
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + Config.WIDTCH) % Config.WIDTCH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);

        for (int i = 10; i <15 ; i++) {
            boxes[i][10].cell.status=Status.LIVE;
            boxes[i][10].setColor();
        }
    }

    private  void initZimer(){
        TimerListener t1=new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS,t1);
        timer.start();
    }

    private class TimerListener implements ActionListener{
boolean flop=false;
        @Override
        public void actionPerformed(ActionEvent e) {
            flop=!flop;
            for (int x = 0; x < Config.WIDTCH; x++)
                for (int y = 0; y < Config.HEIGHT; y++)
                {
                    if (flop)
                    boxes[x][y].step1();
                    else
                    boxes[x][y].step2();
                }
        }
    }
}

