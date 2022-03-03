/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;

/**
 *
 * @author a20armandocb
 */
@Entity
@Table(name = "Ventas")
public class Venta implements Serializable {

    @Id
    LocalDate fechaVenta;

    @Id
    LocalTime hora;

    @Id
    @ManyToOne(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducto")
    Producto producto;

    int numeroUnidades;
    float importe;

    @Id
    @ManyToOne(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmpleadoTemporal")
    private Temporal temporal;

    public Venta() {
    }

    public Venta(LocalDate fechaVenta, LocalTime hora, Producto producto, int numeroUnidades, float importe, ad.ejhibernateherencia.Temporal temporal) {
        this.fechaVenta = fechaVenta;
        this.hora = hora;
        this.producto = producto;
        this.numeroUnidades = numeroUnidades;
        this.importe = importe;
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "Venta{" + "fechaVenta=" + fechaVenta + ", hora=" + hora + ", producto=" + producto + ", numeroUnidades=" + numeroUnidades + ", importe=" + importe + '}';
    }


}
