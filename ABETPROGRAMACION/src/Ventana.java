import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtFieldIDUD;
    private JTextField txtFieldNombreUD;
    private JButton crearButton;
    private JTextField txtFieldNombreCargo;
    private JButton crearCargoButton;
    private JTextArea txtAreaInfo;
    private JButton actualizarButton;
    private JTextField txtFieldIDCargo;
    private JTextField txtFieldSueldo;
    private JTextField txtFieldCedula;
    private JTextField txtFieldNombre;
    private JComboBox <UnidadDepartamental> cmboBoxUD;
    private JComboBox <Cargo> cmboBoxCargo;
    private JButton añadirButton;
    private JLabel AporteSS;
    private JLabel Descuento;
    private JTextField txtFieldCedulaModificar;
    private JButton buscarButton;
    private JTextField txtFieldCedulaM;
    private JTextField txtFieldNombreM;
    private JComboBox cmboBoxUDM;
    private JComboBox cmboBoxCargoM;
    private JButton modificarButton;
    private JButton ordenarButton;
    private JTextField txtFieldNombreBusqueda;
    private JButton busquedaButton;
    private Logica lista;
     private int c=1;
        private int c2=1;
    public Ventana() {

        lista = new Logica();
        txtFieldIDUD.setText(""+c);
        txtFieldIDCargo.setText(""+c2);


        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Se creo correctamente");
                c++;
                txtFieldIDUD.setText(""+c);
                lista.addListaUD(new UnidadDepartamental(txtFieldNombreUD.getText(),c));
                for (UnidadDepartamental aux: lista.getListaUD()){
                    cmboBoxUD.addItem(aux);
                    cmboBoxUDM.addItem(aux);
                }
            }
        });
        crearCargoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Se creo correctamente el cargo");
                c2++;
                txtFieldIDCargo.setText(""+c2);
                float sueldo= Float.parseFloat(txtFieldSueldo.getText());
                lista.addListaCargo(new Cargo(txtFieldNombreCargo.getText(),sueldo,c2));
                for (Cargo aux: lista.getListaCargo()){
                    cmboBoxCargo.addItem(aux);
                    cmboBoxCargoM.addItem(aux);
                }
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaInfo.setText(lista.listar());
                JOptionPane.showMessageDialog(null,"Informacion Actualizada");
            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cargo cargo=(Cargo) cmboBoxCargo.getSelectedItem();

                lista.addlistempleado(new Empleado(txtFieldCedula.getText(),txtFieldNombre.getText(),(UnidadDepartamental) cmboBoxUD.getSelectedItem(),(Cargo) cmboBoxCargo.getSelectedItem()));
                AporteSS.setText("Aporte al Seguro Social: "+ lista.calculoaportealsegurosocial(cargo.getSueldoMensual()));
                Descuento.setText("Impuesto a la renta: " + lista.calculoimpuestoalarenta(cargo.getSueldoMensual()));
                JOptionPane.showMessageDialog(null,"Empleado añadido");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado empleado=lista.buscar(txtFieldCedulaModificar.getText());
                txtFieldCedulaM.setText(empleado.getCedula());
                txtFieldNombreM.setText(empleado.getNombreEmpleado());
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado empleado=lista.buscar(txtFieldCedulaModificar.getText());
                empleado.setCedula(txtFieldCedulaM.getText());
                empleado.setNombreEmpleado(txtFieldCedulaM.getText());
                empleado.setCargo((Cargo) cmboBoxCargoM.getSelectedItem());
                empleado.setUnidadDepto((UnidadDepartamental)cmboBoxUDM.getSelectedItem() );
                JOptionPane.showMessageDialog(null,"Se actualizo la informacion del empleado");
            }
        });
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenar();
                JOptionPane.showMessageDialog(null,"Se ordeno la lista ");
            }
        });
        busquedaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado empleado=lista.infoempleado(txtFieldNombreBusqueda.getText());
                txtAreaInfo.setText(empleado.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
