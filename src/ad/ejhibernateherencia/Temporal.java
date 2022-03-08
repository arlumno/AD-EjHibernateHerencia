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
	float suplemento = 100;
	float pagoDia;
	final float OBJETIVO_VENTAS = 100000F;

	@OneToMany(
//            cascade = CascadeType.ALL,
			mappedBy = "temporal", fetch = FetchType.EAGER)
//    @JoinTable(
//           name = "VentasTemporal",
//            joinColumns = {
//                @JoinColumn(name = "dni")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "id")}
//    )
	Set<Venta> ventas = new HashSet();

	public Temporal() {
	}

	public Temporal(LocalDate fechaInicio, LocalDate fechaFin, float pagoDia, String dni, String nombre,
			String telefono, float porcentRetencion, float sueldo, Empresa empresa) {
		super(dni, nombre, telefono, porcentRetencion, sueldo, empresa);
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.pagoDia = pagoDia;
	}

	@Override
	public void calculoNomina() {
		float dias = fechaInicio.until(fechaFin).getDays();
		
		float importeVentas = getImporteVentas();
		
		if (importeVentas >= OBJETIVO_VENTAS) {
			setSueldo(pagoDia * dias - pagoDia * dias * getPorcentRetencion() + suplemento);
		} else {
			setSueldo(pagoDia * dias - pagoDia * dias * getPorcentRetencion());
		}
	}
	
	public float getImporteVentas() {
		float importeVentas = 0F;
		for (Venta venta : ventas) {
			if (venta.getFechaVenta().isAfter(fechaInicio) && venta.getFechaVenta().isBefore(fechaFin)) {
				importeVentas += venta.getImporte();
			}
		}
		return importeVentas;
	}
	@Override
	public float getSueldo() {
		calculoNomina();
		return super.getSueldo();
	}

	@Override
	public String toString() {
		return super.toString() + "\n |--> Temporal - fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", suplemento=" + suplemento + ", pagoDia=" + pagoDia + ", Importes Ventas: " + getImporteVentas() +'}';
	}

	public float getPagoDia() {
		return pagoDia;
	}

	public void setPagoDia(float pagoDia) {
		this.pagoDia = pagoDia;
	}

}
