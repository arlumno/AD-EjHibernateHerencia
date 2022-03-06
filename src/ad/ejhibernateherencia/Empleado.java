/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author a20armandocb
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleado implements Serializable {
    
    @Id
    private String dni;
    
    private String nombre;
    private String telefono;
    private float porcentRetencion;
    private float sueldo;
    
    @ManyToOne( 
//            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)    
    @JoinColumn(name = "cifEmpresa")
    private Empresa empresa;
    
    public abstract void calculoNomina();

    public Empleado() {
    }

    public Empleado(String dni, String nombre, String telefono, float porcentRetencion, float sueldo, Empresa empresa) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.porcentRetencion = porcentRetencion;
        this.sueldo = sueldo;
        this.empresa = empresa;
    }

   
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getPorcentRetencion() {
        return porcentRetencion;
    }

    public void setPorcentRetencion(float porcentRetencion) {
        this.porcentRetencion = porcentRetencion;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "\n --- Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", porcentRetencion=" + porcentRetencion + ", sueldo=" + sueldo + '}';
    }
    
    
}
