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

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "temporal",
            fetch = FetchType.LAZY
    )
//    @JoinTable(
//            name = "VentasTemporal",
//            joinColumns = {
//                @JoinColumn(name = "dni")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "id")}
//    )

    Set<Venta> ventas = new HashSet();

    public Temporal() {
    }

    
    public Temporal(LocalDate fechaInicio, LocalDate fechaFin, float suplemento, float pagoDia, String dni, String nombre, String telefono, float porcentRetencion, float sueldo, Empresa empresa) {
        super(dni, nombre, telefono, porcentRetencion, sueldo, empresa);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.suplemento = suplemento;
        this.pagoDia = pagoDia;
    }

    public void guardarVenta(Venta venta) {
        ventas.add(venta);
    }

    @Override
    public void calculoNomina() {
        float dias = fechaInicio.until(fechaFin).getDays();
        setSueldo(pagoDia * dias - pagoDia * dias * getPorcentRetencion() + suplemento);
    }

    @Override
    public String toString() {
        return super.toString() + "\n |--> Temporal - fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", suplemento=" + suplemento + ", pagoDia=" + pagoDia + ", ventas=" + ventas + '}';
    }
    
}
