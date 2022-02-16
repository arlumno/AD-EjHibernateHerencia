/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

/**
 *
 * @author a20armandocb
 */
public class Fijo extends Empleado{
    int salarioBase;
    int trienios;

    @Override
    public void calculoNomina() {
        setSueldo((salarioBase + trienios) - (salarioBase+trienios) * getPorcentRetencion());
    }
    
   
}
