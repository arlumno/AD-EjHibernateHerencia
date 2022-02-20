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

    @Override
    public void calculoNomina() {
        setSueldo((salarioBase + trienios) - (salarioBase+trienios) * getPorcentRetencion());
    }
    
   
}
