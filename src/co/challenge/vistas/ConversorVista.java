package co.challenge.vistas;

import co.challenge.logic.Conversor;
import co.challenge.logic.SaveConverters;

import javax.swing.*;

import java.awt.*;


public class ConversorVista extends JFrame{
    private JComboBox<String> select;
    private JComboBox<String> convertir;
    private JTextField input1;
    private JTextField input2;
    private JButton button;
    private boolean moneda;
    private final JLabel label1;
    private final JLabel label2;

    private JOptionPane alert_error;

    private final Conversor con = new Conversor();

    public ConversorVista(){
        this.setTitle("Conversor One");

        this.setSize(400,240);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png"));
        this.setIconImage(icon);
        this.getContentPane().setBackground(new Color(34, 34, 34));


        this.mostrarSelect();
        this.mostrarEntrys();
        this.mostrarTipo();
        this.label1 = new JLabel("Conversor de tipo: ");
        this.label1.setForeground(Color.white);
        this.label1.setBounds(80,5,200,20);
        this.label2 = new JLabel("de x a x");
        this.label2.setForeground(Color.white);
        this.label2.setBounds(80,50,200,20);

        add(label1);
        add(label2);
        add(this.select);
        add(this.convertir);
        add(this.input1);
        add(this.input2);
        add(this.button);
        this.select.addActionListener(e -> {
            if(select.getItemAt(select.getSelectedIndex()) == "Conversor de moneda") {
                moneda = true;
                this.convertir.removeAllItems();
                for (SaveConverters item : this.con.getConvetions_money()){
                    this.convertir.addItem(item.get_name());
                }
                label1.setText("Conversor de tipo: Moneda");
            } else if(select.getItemAt(select.getSelectedIndex()) == "Conversor de temperatura"){
                this.moneda = false;

                String[] temp = {
                        "Seleccione","celsius a fahrenheit","fahrenheit a celsius","celsius a kelvin",
                        "kelvin a celsius","kelvin a fahrenheit","fahrenheit a kelvin","rankine a fahrenheit",
                        "fahrenheit a rankine"
                };
                this.convertir.removeAllItems();
                for (String s : temp) {
                    this.convertir.addItem(s);
                }

                label1.setText("Conversor de tipo: Temperatura");
            }

        });

        this.convertir.addActionListener(e -> {

            String text = convertir.getItemAt(convertir.getSelectedIndex());

            label2.setText(text);

        });

        this.button.addActionListener(e -> {

                if(this.moneda){
                    try{
                        String texto =  input1.getText();
                        con.make_convertion_money(convertir.getItemAt(convertir.getSelectedIndex()),Double.parseDouble(texto));




                        double value = con.get_convertion();


                        String result = String.valueOf(value);

                        input2.setText(result);


                    } catch (NumberFormatException err){
                        alert_error = new JOptionPane();
                        JOptionPane.showMessageDialog(new JFrame(),"El valor ingresado debe ser un numero","Error",JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try
                    {
                        String texto =input1.getText();
                        double value = con.get_convertion_temp(convertir.getItemAt(convertir.getSelectedIndex()),Integer.parseInt(texto));

                        String result = String.valueOf(value);

                        input2.setText(result);

                    }catch (NumberFormatException err){
                        alert_error = new JOptionPane();
                        JOptionPane.showMessageDialog(new JFrame(),"El valor ingresado debe ser un numero","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            if(select.getItemAt(select.getSelectedIndex()) == "Seleccione"){
                alert_error = new JOptionPane();
                JOptionPane.showMessageDialog(new JFrame(),"seleccione el tipo de conversion","Info",JOptionPane.INFORMATION_MESSAGE);
            }

        });


        setLayout(null);
    }

    public void mostrarSelect(){
        String[] tipo = {"Seleccione","Conversor de moneda","Conversor de temperatura"};
        this.select = new JComboBox<>(tipo);

        this.select.setBounds(80,30,200,20);
        this.select.setBackground(new Color(255, 255, 255));
        this.select.setBorder(null);

    }

    public void mostrarTipo() {
        this.convertir = new JComboBox<>();
        this.convertir.setBounds(80,70,200,20);
    }

    public void mostrarEntrys(){
        this.input1 = new JTextField();
        this.input2 = new JTextField();
        this.button = new JButton("Convertir");
        this.button.setBorder(null);
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR) );
        //set styles
        this.button.setBackground(new Color(51, 51, 51, 255));
        this.button.setForeground(new Color(255, 255, 255));
        this.input1.setBounds(40,120,140,20);
        this.input2.setBounds(200,120,140,20);
        this.button.setBounds(150,160,90,30);

    }
}
