import java.awt.*;
import java.awt.event.*;

public class keyboardAndMouse {
    private Frame f;
    private TextField tf ;
    private Button but;

    public keyboardAndMouse() {
        init();
    }
    public void init(){
        f=new Frame("yanshi");
        f.setBackground(Color.red);
        f.setBounds(600,400,500,200);
        f.setLayout(new FlowLayout());
        tf=new TextField(20);
        f.add(tf);
        but =new Button("anjiu");
        f.add(but);
        myEvent();
        f.setVisible(true);

    }
    private void myEvent(){
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code =e.getKeyCode();
                if (!(code>=KeyEvent.VK_0&&code<=KeyEvent.VK_9)){
                    System.out.println("number");
                    e.consume();
                }
                //System.out.println(KeyEvent.getKeyText(e.getKeyCode())+e.getKeyCode());
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        but.addMouseListener(new MouseListener() {
            private int count=0;
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2)
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("count"+count);
                tf.setText("count"+count);
                count++;
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new keyboardAndMouse();
    }
}
