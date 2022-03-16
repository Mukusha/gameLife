import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JPanel { //панельки

    Cell cell;

    public Box(int x, int y){
        super();
        cell= new Cell();
        setBounds(x*Config.SIZE, y*Config.SIZE,Config.SIZE,Config.SIZE); // размеры бокса
        setBackground(Config.getColor(Status.NONE));// цвет бокса
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.turn();
            }
        }); //слушатель мышки
    }

    public void initColls(int x, int y){

    }

    public void setColor(){
        setBackground(Config.getColor(cell.status));
    }

    void step1(){
        cell.step1();
        setColor();
    }

    void step2(){
        cell.step2();
        setColor();
    }

}
