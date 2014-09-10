package app.diogo.com.br.sunshine.model;

/**
 * Created by Diogo on 30/08/2014.
 */
public class Clima {

    private String dia;
    private String tipo;

    /**
     * Temperaturas
     */
    private double min;
    private double max;

    public Clima(String dia, String tipo, double min, double max){
        this.dia = dia;
        this.tipo = tipo;
        this.min = min;
        this.max = max;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

}
