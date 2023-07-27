package co.challenge.test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem opcion1;
    private JMenuItem opcion2;
    private JMenuItem opcion3;



    public window(){
        setSize(600,400);
        setTitle("Conversor One :)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        this.mostrarMenu();
        panel.add(this.menuBar);
        add(panel);

        opcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Que pena! saliendo");
                System.exit(0);
            }
        });
    }

    public void mostrarMenu(){
        //inicializacion de los atributos
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("Elija una opcion valida");
        this.opcion1 = new JMenuItem("centimetros para metros");
        this.opcion2 = new JMenuItem("metros para centimetros");
        this.opcion3 = new JMenuItem("Salir");

        this.menu.add(opcion1);
        this.menu.add(opcion2);
        this.menu.add(opcion3);

        menuBar.add(this.menu);

    }
}
