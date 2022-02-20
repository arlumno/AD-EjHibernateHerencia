/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;


/**
 *
 * @author a20armandocb
 */
@Entity
@Table(name = "Empresas")
public class Empresa{
   
    @Id
    String cif;
    
//    @OneToMany(mappedBy = "empresa")    
    
    String nombre;
    String direccion;
    String telefono;
//    Set<Producto> productos =  new HashSet();
//    Set<Empleado> empleados =  new HashSet();

    public Empresa(String cif, String nombre, String direccion, String telefono) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//    public Set<Producto> getProductos() {
//        return productos;
//    }
//
//    public void setProductos(Set<Producto> productos) {
//        this.productos = productos;
//    }
//
//    public Set<Empleado> getEmpleados() {
//        return empleados;
//    }
//
//    public void setEmpleados(Set<Empleado> empleados) {
//        this.empleados = empleados;
//    }

}
