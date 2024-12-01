public class Empleado {
    private String cedula;
    private String nombreEmpleado;
    private UnidadDepartamental unidadDepto;
    private Cargo cargo;
    private double aporteSS;
    private double descuento;

    public Empleado(String cedula, String nombreEmpleado, UnidadDepartamental unidadDepto, Cargo cargo) {
        this.cedula = cedula;
        this.nombreEmpleado = nombreEmpleado;
        this.unidadDepto = unidadDepto;
        this.cargo = cargo;
    }

    public Empleado() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public UnidadDepartamental getUnidadDepto() {
        return unidadDepto;
    }

    public void setUnidadDepto(UnidadDepartamental unidadDepto) {
        this.unidadDepto = unidadDepto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }



    public double getAporteSS() {
        return aporteSS;
    }

    public void setAporteSS(double aporteSS) {
        this.aporteSS = aporteSS;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Empleado" +
                "Cedula=" + cedula  +
                " Nombre=" + nombreEmpleado  +
                " UnidadDepto=" + unidadDepto +
                "Cargo " + cargo +
                "Sueldo "+cargo.getSueldoMensual() +"\n";
    }


}
