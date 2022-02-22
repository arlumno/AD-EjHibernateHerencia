/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import javax.persistence.*;

/**
 *
 * @author a20armandocb
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "dni")
public class Fijo extends Empleado{
    int salarioBase;
    int trienios;

    public Fijo() {
    }

    
    public Fijo(int salarioBase, int trienios, String dni, String nombre, String telefono, float porcentRetencion, float sueldo, Empresa empresa) {
        super(dni, nombre, telefono, porcentRetencion, sueldo, empresa);
        this.salarioBase = salarioBase;
        this.trienios = trienios;
    }

    @Override
    public void calculoNomina() {
        setSueldo((salarioBase + trienios) - (salarioBase+trienios) * getPorcentRetencion());
    }

    @Override
    public String toString() {
        return super.toString() + "\n |--> Fijo{" + "salarioBase=" + salarioBase + ", trienios=" + trienios + '}';
    }
    
   
}
