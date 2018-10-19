
import org.w3c.dom.Text;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.imageio.IIOException;
import javax.sound.sampled.*;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.AbstractButton;
import java.lang.String;
import  javax.sound.sampled.Clip;
import  javax.sound.sampled.DataLine;
import  javax.sound.sampled.LineUnavailableException;
/*public class Main extends JPanel {
    private JButton button1;
    public  JPanel panel1;
    private JPanel panel2;
    private JTextField textField1;
    private JPanel ee;
    static int tree = 0;
    static int check = 0;
    static Stack<Integer> si = new Stack<Integer>();
    static int i = 0;
    public void drawing(Graphics g){
        System.out.print("paint");
        repaint();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawRect(100,100,10,si.pop());
    }
    public void shape (Graphics g){
        System.out.print("paint");
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawRect(100,100,10,si.pop());

    }
    public void  gu() {



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (tree == check) {
                    tree = Integer.parseInt(textField1.getText());
                    JOptionPane.showMessageDialog(null, "hey world");
                    System.out.print(tree);
                } else {
                    si.push(Integer.parseInt(textField1.getText()));
                    System.out.print(si.peek());
                    i++;
                    if (i == tree) {
                        check=i;
                        JFrame cl = new JFrame("gu");
                        cl.setBounds(200, 200, 200, 200);
                        cl.setLocationRelativeTo(null);
                        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        Main t = new Main();
                        cl.add(t);
                        //t.drawing(Graphics );
                        cl.setVisible(true);




                    }
                }
            }
        });

        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textField1.setText(null);
            }
        });
    }

   /* public static void main(String[] args) {
        boolean b =true;
        JFrame frame = new JFrame("gu");
        frame.setBounds(200, 200, 200, 200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new Main().panel1);
//gu t=new gu();
        //frame.add(t);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        System.out.print(tree);
       /* while (b==true){
//System.out.print("tr");
            if(check>0)b=false;
while (b==false) {

    JFrame cl = new JFrame();
    cl.setBounds(200, 200, 200, 200);
    cl.setLocationRelativeTo(null);
    cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cl.setVisible(true);
    gu t = new gu();
    cl.add(t);
    t.drawing();
}

}*/
// }

public class Main extends JPanel implements ActionListener {
public static Mixer mixer;
public static Clip clip;

    private JPanel panal;
    static Stack<Integer> si = new Stack<Integer>();
private int tree;
    public Main() {
        JFrame frame = new JFrame("Swing");
       frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(800, 600);
        frame.setResizable(false);
        //JPanel pa=new JPanel();
       // pa.setLayout(new GridLayout(2,3,0,0));

        //pa.setLayout(null);
        //frame.setLocationRelativeTo(null);
        JTextField text = new JTextField(5);
        JLabel te=new JLabel("number");
        JLabel te1=new JLabel("height");
        te.setBounds(280,0,50,50);
        te1.setBounds(280,100,50,50);
        text.setBounds(100,0,50,50);
        JTextField text2 =new JTextField(5);
        text2.setBounds(100,100,50,50);
        JButton button1 = new JButton("OK");
        button1.setBounds(200,0,70,70);
        JButton button2 = new JButton("OK");
        button2.setBounds(200,100,70,70);
        JButton button3 = new JButton("Swing");
        button3.setBounds(200,200,70,70);

        //pa.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.getContentPane().add(text);
        frame.getContentPane().add(text2);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);
        frame.getContentPane().add(te);
        frame.getContentPane().add(te1);


        //frame.getContentPane().setLayout(new FlowLayout());
        //frame.add(pa);

        //JTextArea tex = new JTextArea(5, 20);
        //tex.setLineWrap(true);
        //tex.setWrapStyleWord(true);

        String b = text.getText();


        button1.addActionListener(new ActionListener() {
            @Override


            public void actionPerformed(ActionEvent e) {
                tree = Integer.parseInt(text.getText());
                System.out.printf("tree %d",tree);
            }
        });
button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     si.push(Integer.parseInt(text2.getText()));
     System.out.print("pusha");
    }
});
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        /*Mixer.Info[] mixInfos=AudioSystem.getMixerInfo();
        mixer =AudioSystem.getMixer(mixInfos[0]);
        DataLine.Info dataInfo =new DataLine.Info(Clip.class, null);
try{
    clip=(Clip)mixer.getLine(dataInfo); }catch(LineUnavailableException lue){lue.printStackTrace();

    }
        try{
            URL sr =Main.class.getResource("monkey1.wav");
            AudioInputStream audioStream=AudioSystem.getAudioInputStream(sr);
clip.open(audioStream);
        }
        catch(LineUnavailableException lue){lue.printStackTrace();

        }catch(UnsupportedAudioFileException u){
            u.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        clip.start();
        do{
            try{
                Thread.sleep(50);
            }catch(InterruptedException ie){ie.printStackTrace();

            }
        }while (clip.isActive());*/
        JFrame frames = new JFrame("result");
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames.pack();
        frames.setSize(400, 400);
        frames.getContentPane().setBackground(Color.white);
        frames.setVisible(true);

    }
});
    }




    public static void main(String[] args) {

        Main but = new Main();


        int numberOfTree = 0;
        while (numberOfTree == 0) numberOfTree = inputTree();

    }

    private static int inputTree() {

        int numberOfTree;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("#Trees : ");
            numberOfTree = scan.nextInt();
            if (numberOfTree < 0) throw new Exception();
        } catch (Exception e) {
            // e.printStackTrace();
            numberOfTree = 0;
            System.out.println("Invalid Input, Please Try Again.\n");
        }

        return numberOfTree;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("FUck ");
        System.out.print("FUck2U ");

    }
}
