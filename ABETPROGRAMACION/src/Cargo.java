public class Cargo{
    private String nombre;
    private float sueldoMensual;
    private int IDcargo;

    public Cargo(String nombre, float sueldoMensual,int IDcargo) {
        this.nombre = nombre;
        this.sueldoMensual = sueldoMensual;
        this.IDcargo = IDcargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(float sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public int getIDcargo(){
        return IDcargo;
    }

    @Override
    public String toString() {
        return  nombre;
    }

    public void setIDcargo(int IDcargo){
        this.IDcargo = IDcargo;
    }
}
