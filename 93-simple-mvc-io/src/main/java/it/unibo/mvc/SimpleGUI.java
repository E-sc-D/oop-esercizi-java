package it.unibo.mvc;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;


/**
 * A very simple program using a graphical interface.
 * 
 */


public final class SimpleGUI {

    private static final String TITLE = "A very simple GUI application";
    private static final int PROPORTION = 2;
    private final JFrame frame = new JFrame(TITLE);
    private final Controller ctrl;
    public static void main(String[] args){
        new SimpleGUI(new Controller()).Display();
    }

    public SimpleGUI(Controller ctrl){
        this.ctrl = ctrl;
        final JTextField pathchooser = new JTextField("choose");
        final JTextArea textarea = new JTextArea();
        final JButton write = new JButton("Write on file");
        final JPanel canvas = new JPanel();
        final JPanel canvas2 = new JPanel();
        final LayoutManager layout2 = new BorderLayout();
        final LayoutManager layout = new BorderLayout();
        canvas.setLayout(layout);
        canvas2.setLayout(layout2);

        canvas2.add(pathchooser,BorderLayout.CENTER);
        canvas.add(textarea,BorderLayout.CENTER);
        canvas.add(write,BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.getContentPane().add(canvas2,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        write.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e){
                try {
                    ctrl.Write(textarea.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
             }
        });

        //frame.pack();
    }

    private void Display(){
         /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

   

}
