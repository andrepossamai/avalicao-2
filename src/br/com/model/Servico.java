
package br.com.model;

public class Servico {
    
   private int id;
    private String lavar;
    private String secar;
    private String amaciar;
    private String estilizar;

    public Servico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLavar() {
        return lavar;
    }

    public void setLavar(String lavar) {
        this.lavar = lavar;
    }

    public String getSecar() {
        return secar;
    }

    public void setSecar(String secar) {
        this.secar = secar;
    }

    public String getAmaciar() {
        return amaciar;
    }

    public void setAmaciar(String amaciar) {
        this.amaciar = amaciar;
    }

    public String getEstilizar() {
        return estilizar;
    }

    public void setEstilizar(String estilizar) {
        this.estilizar = estilizar;
    }

}
