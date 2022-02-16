/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author a20armandocb
 */
public class Temporal extends Empleado{
    LocalDate fechaInicio;
    LocalDate fechaFin;
    float suplemento;
    float pagoDia;
    
    Set<Venta> ventas;
    
    @Override
    public void calculoNomina() {
        float dias = fechaInicio.until(fechaFin).getDays();
        setSueldo(pagoDia * dias - pagoDia* dias * getPorcentRetencion()+ suplemento);
    }
}
