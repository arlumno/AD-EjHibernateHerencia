/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad.ejhibernateherencia;

import menu.Menu;
import peticiones.EntradasGui;
import textos.SalidasGui;
import utilidades.Log;

/**
 *
 * @author a20armandocb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static private Log log = Log.getInstance();

    public static void main(String[] args) {
        boolean continuar = true;
        peticiones.SalidasGui.mensaje("Importante:\n Realizar la acciones de creacion en orden para comprobar el funcionamiento.");
        Menu menu = construirMenuPrincipal();
        
        do {
            try {
                continuar = menuAcciones(menu);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (continuar);
        System.exit(0);
    }

    private static Menu construirMenuPrincipal() {
        Menu menu = new Menu();
        AccionesApp app = new AccionesApp();

        /*pruebas*/
        app.altaEmpresa();
        app.altaEmpleado();
        app.altaProducto();
        app.altaVenta();
        
        /*fin pruebas*/
        menu.setTituloMenu("Menu Ej. Hibernate");
        menu.setTextoSalir("salir");
        log.addToLog("Iniciado el programa");

        menu.addLabel("Altas");
        menu.addOpcion("Empresa", () -> {
            app.altaEmpresa();
        });
        menu.addOpcion("Empleado", () -> {
            app.altaEmpleado();
        });
        menu.addOpcion("Producto", () -> {
            app.altaProducto();
        });
        menu.addOpcion("Venta", () -> {
            app.altaVenta();
        });

        
        menu.addLabel("Bajas");
        menu.addOpcion("Empleado", () -> {
            app.bajaEmpleado();
        });
        
        menu.addLabel("Modificaciones");
        menu.addOpcion("Producto", () -> {
            app.modProducto();
        });
        menu.addOpcion("Empleado", () -> {
            app.modEmpleado();
        });

        menu.addLabel("Consultas");
        menu.addOpcion("Listado Empresas", () -> {
            app.listarEmpresas();
        });
        menu.addOpcion("Listado Productos", () -> {
            app.listarProductos();
        });        
        menu.addOpcion("Objetivos Empleado Temporal", () -> {
            app.objetivoEmpleadoTemporal();
        });
                
        
        /* Log de libreriaAr 1.4 */
        menu.addLabel("LOG");
        menu.addOpcion("Ver Log", () -> {
            peticiones.SalidasGui.bloqueTexto("Log", utilidades.Log.getInstance().getLog());
        });
        menu.addOpcion("Borrar Log", () -> {
            utilidades.Log.getInstance().borrarLog();
        });

        return menu;
    }

    private static boolean menuAcciones(Menu menu) throws Exception {
        boolean continuar = true;
        menu.mostrarGUI();
        //menu.mostrar();
        switch (menu.getSeleccion()) {
            case 0:
                //salir
                continuar = false;
                log.addToLog("finalizado el programa");
                System.out.println("Bye Bye!");
                break;
            //deprecated, ahora se asigna directamente la funcion al añadir el boton
//            case 1:
//                System.out.println(EntradasGui.pedirFecha("mensaje").toString());
//                break;

        }
        return continuar;
    }

}
