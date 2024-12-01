import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Logica {

    private List <UnidadDepartamental> listaUD;
    private List <Cargo> listaCargo;

    private List <Empleado> listempleados;
    public Logica() {
        listempleados = new ArrayList<Empleado>();
        listaUD=new ArrayList<UnidadDepartamental>();
        listaCargo=new ArrayList<Cargo>();
    }

    //Lista Empleados

    public List<Empleado> getListempleados() {
        return listempleados;
    }

    public void setListempleados(List<Empleado> listempleados) {

        this.listempleados = listempleados;
    }

    public void addlistempleado(Empleado e){
        listempleados.add(e);
    }
    public String listar(){
        StringBuilder sb= new StringBuilder();
        if (!listempleados.isEmpty()){
            for (Empleado aux: listempleados){
                sb.append(aux.toString());
            }
        }
        return sb.toString();
    }
    public Empleado infoempleado(String nombre){
        for (Empleado aux: listempleados){
            if (aux.getNombreEmpleado().equalsIgnoreCase(nombre)){
                return aux;
            }
        }
        return null;
    }
    public Empleado buscar(String nombre){
        for (Empleado aux: listempleados){
            if (aux.getCedula().equalsIgnoreCase(nombre)){
                return aux;
            }
        }
        return null;
    }

    public void ordenar(){
    Collections.sort(listempleados, Comparator.comparingDouble(e -> e.getCargo().getSueldoMensual()));
    }

    //lista UD
    public List<UnidadDepartamental> getListaUD() {
        return listaUD;
    }

    public void setListaUD(List<UnidadDepartamental> listaUD) {
        this.listaUD = listaUD;
    }

    public void addListaUD(UnidadDepartamental a){
        listaUD.add(a);
    }




    //lista Cargos

    public List<Cargo> getListaCargo() {
        return listaCargo;
    }

    public void setListaCargo(List<Cargo> listaCargo) {
        this.listaCargo = listaCargo;
    }
    public void addListaCargo(Cargo u){
        listaCargo.add(u);
    }

    //

    public  float calculoaportealsegurosocial(float s){
        return ((9.35f*s)/100f);
    }
    public  float calculoimpuestoalarenta(float su){
        float sueldoanual=su*12;

        if (sueldoanual<=5000){
            return 0;
        }
        if (sueldoanual> 5000 && sueldoanual<=10000){
            return ((10f*5000)/100f);
        }
        if (sueldoanual> 10000 && sueldoanual<=18000){
            return ((20f*10000)/100f);
        }
        if((sueldoanual> 18000)){
            return ((30f*18000)/100f);
        }
        return 0;
    }
}