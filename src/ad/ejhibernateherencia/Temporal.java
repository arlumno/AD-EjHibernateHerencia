/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author a20armandocb
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "dni")
public class Temporal extends Empleado {

    LocalDate fechaInicio;
    LocalDate fechaFin;
    float suplemento;
    float pagoDia;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "VentasTemporal",
            joinColumns = {
                @JoinColumn(name = "dni")},
            inverseJoinColumns = {
                @JoinColumn(name = "id")}
    )
    Set<Venta> ventas = new HashSet();

    @Override
    public void calculoNomina() {
        float dias = fechaInicio.until(fechaFin).getDays();
        setSueldo(pagoDia * dias - pagoDia * dias * getPorcentRetencion() + suplemento);
    }
}
