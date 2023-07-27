package co.challenge.logic;
import java.util.ArrayList;
public class Conversor {
    private final ArrayList<SaveConverters> conversiones;
    private double result;
    private final ConvertersTemp conTemp = new ConvertersTemp();
    public Conversor(){
        conversiones = new ArrayList<>();

        SaveConverters c1 = new SaveConverters(0.00025,"pesos colombianos a dolares","double");
        SaveConverters c2 = new SaveConverters(3972.98,"dolares a pesos colombianos","int");
        SaveConverters c3 = new SaveConverters(0.00023,"pesos colombianos a euros","double");
        SaveConverters c4 = new SaveConverters(4418.91,"euros a pesos colombianos","int");
        SaveConverters c5 = new SaveConverters(0.0012,"pesos colombianos a reales brasileños","double");
        SaveConverters c6 = new SaveConverters(833.51,"reales brasileños a pesos colombianos","int");
        SaveConverters c7 = new SaveConverters(824.74,"dolares a pesos chilenos","int");
        SaveConverters c8 = new SaveConverters(0.0012,"pesos chilenos a dolares","double");


        conversiones.add(c1);
        conversiones.add(c2);
        conversiones.add(c3);
        conversiones.add(c4);
        conversiones.add(c5);
        conversiones.add(c6);
        conversiones.add(c7);
        conversiones.add(c8);

    }
    public ArrayList<SaveConverters> getConvetions_money(){
        return this.conversiones;
    }
    public void make_convertion_money(Object convertion, double value){
        for (SaveConverters item : this.conversiones){
            if (item.get_name() == convertion) {
                if(item.getType() == "int") {
                    this.result = item.get_param() * value;
                }else {
                    this.result = item.get_param() * value;
                }
            }
        }
    }

    public double get_convertion_temp(String type,double value){
        switch (type) {
            case "celsius a fahrenheit" -> this.result = conTemp.getCelsiusAFahrenheit(value);
            case "fahrenheit a celsius" -> this.result = conTemp.getFahrenheitToCelSius(value);
            case "celsius a kelvin" -> this.result = conTemp.getCelsiusToKelvin(value);
            case "kelvin a celsius" -> this.result = conTemp.getKelvinToCelsius(value);
            case "kelvin a fahrenheit" -> this.result = conTemp.getKelvinToFahrenheit(value);
            case "fahrenheit a kelvin" -> this.result = conTemp.getFahrenheitToKelvin(value);
            case "rankine a fahrenheit" -> this.result = conTemp.getRankineToFahrenheit(value);
            case "fahrenheit a rankine" -> this.result = conTemp.getFahrenheitToRankine(value);
        }

        return this.result;
    }

    public double get_convertion(){
        return this.result;
    }
}
