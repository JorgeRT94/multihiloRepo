public class Hilo implements Runnable{

    private int valor;
    private int id;

    public Hilo(int id, int valor) {
        this.valor = valor;
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        setValor((int) (Math.random() * 10));
        }
}
