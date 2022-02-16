/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

/**
 *
 * @author a20armandocb
 */
public abstract class Empleado {
    @Id
    private String dni;
    private String nombre;
    private String telefono;
    private float porcentRetencion;
    private float sueldo;
            
    public abstract void calculoNomina();

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
    
    
}
