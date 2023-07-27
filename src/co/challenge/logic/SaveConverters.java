package co.challenge.logic;

public class SaveConverters {
    private double param;
    private String name;
    private String type;


    public SaveConverters(double value, String name, String type){
        this.name = name;
        this.param = value;
        this.type = type;
    }

    public void set_param(double value){
        this.param = value;
    }

    public void set_name(String name){
        this.name = name;
    }

    public String get_name(){
        return this.name;
    }

    public double get_param(){
        return this.param;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
