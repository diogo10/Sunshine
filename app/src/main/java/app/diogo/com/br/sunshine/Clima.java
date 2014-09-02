package app.diogo.com.br.sunshine;

/**
 * Created by Diogo on 30/08/2014.
 */
public class Clima {

    private String dia;
    private String tipo;
    private String icon;


    public Clima(String dia, String tipo){
        this.dia = dia;
        this.tipo = tipo;
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
}
