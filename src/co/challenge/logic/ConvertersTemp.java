package co.challenge.logic;

public class ConvertersTemp {

    public double getCelsiusAFahrenheit(double value){
        return ( (9*value) /5) + 32;
    }

    public double getFahrenheitToCelSius(double value){
        return (5*(value - 32) / 9);
    }

    public double getCelsiusToKelvin(double value){
        return value + 273.15;
    }
    public double getKelvinToCelsius(double value){
        return value - 273.15;
    }
    public double getKelvinToFahrenheit(double value){
        return ((9*(value - 273.15)) / 5) + 32;
    }
    public double getFahrenheitToKelvin(double value){
        return ((5*(value-32)) / 9) + 273.15;
    }

    public double getRankineToFahrenheit(double value){
        return value - 459.67;
    }
    public double getFahrenheitToRankine(double value){
        return value + 459.67;
    }
}
