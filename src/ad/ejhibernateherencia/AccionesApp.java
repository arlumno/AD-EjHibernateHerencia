/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author a20armandocb
 */
public class AccionesApp {

	public AccionesApp() {

	}

	void altaEmpresa() {
		Empresa emp1 = new Empresa("B53170624Y", "b58", "coutadas 58", "986 378 510");
		Empresa emp2 = new Empresa("B12345678Z", "empresa2", "cualquier lugar", "986 123 456");
		Empresa emp3 = new Empresa("C123456", "SONY", "nunca jamas 42", "+43 123 456 789");

		ConexionHibernateSF.beginTransaction();
		ConexionHibernateSF.save(emp1);
		ConexionHibernateSF.save(emp2);
		ConexionHibernateSF.save(emp3);
		ConexionHibernateSF.commitAndClose();

		peticiones.SalidasGui.mensaje(
				"Grabadas Empresas: " + "\n" + emp1.toString() + "\n" + emp2.toString() + "\n" + emp3.toString());
	}

	void altaEmpleado() {
		Empresa empCargada1 = ConexionHibernateSF.getSession().get(Empresa.class, "C123456");
		Empresa empCargada2 = ConexionHibernateSF.getSession().get(Empresa.class, "B53170624Y");
		String error = "Tienes que cargar las empresas antes de realizar esta acción";

		if (objetoIsNotNull(empCargada1, error) && objetoIsNotNull(empCargada2, error)) {
			Temporal empT1 = new Temporal(LocalDate.parse("2022-02-22"), LocalDate.parse("2022-02-27"), 45F,
					"53170624Y", "Armando", "123456", 12F, 322F, empCargada1);
			Temporal empT2 = new Temporal(LocalDate.parse("2022-02-22"), LocalDate.parse("2022-02-27"), 45F,
					"12345678Z", "Pedro", "123456", 22F, 122F, empCargada2);

			Fijo empF1 = new Fijo(1200, 150, "3603769N", "Paco", "123 456 789", 10F, 1300F, empCargada1);
			Fijo empF2 = new Fijo(1200, 150, "3123322K", "Ana", "213 456 789", 12F, 1330F, empCargada2);

			ConexionHibernateSF.beginTransaction();
			ConexionHibernateSF.save(empT1);
			ConexionHibernateSF.save(empF1);
			ConexionHibernateSF.save(empT2);
			ConexionHibernateSF.save(empF2);
			ConexionHibernateSF.commitAndClose();

			peticiones.SalidasGui.mensaje("Grabados empleados: " + "\n" + empT1.toString() + "\n" + empT2.toString()
					+ "\n" + empF1.toString() + "\n" + empF2.toString());
		}
		ConexionHibernateSF.close();
	}

	void altaProducto() {
		Empresa empCargada1 = ConexionHibernateSF.getSession().get(Empresa.class, "B53170624Y");
		Empresa empCargada2 = ConexionHibernateSF.getSession().get(Empresa.class, "B12345678Z");
		String error = "Tienes que cargar las empresas antes de realizar esta acción";
		if (objetoIsNotNull(empCargada1, error) && objetoIsNotNull(empCargada2, error)) {

			Producto pr1 = new Producto("ref01", 15, empCargada1, 233F);
			Producto pr2 = new Producto("ref02", 15, empCargada2, 433F);
			Producto pr3 = new Producto("ref03", 12, empCargada1, 533F);

			ConexionHibernateSF.beginTransaction();
			ConexionHibernateSF.save(pr1);
			ConexionHibernateSF.save(pr2);
			ConexionHibernateSF.save(pr3);
			ConexionHibernateSF.commitAndClose();

			peticiones.SalidasGui.mensaje("Grabados productos: " + "\n" + pr1.toString() + "\n" + pr2.toString());
		}
		ConexionHibernateSF.close();
	}

	void altaVenta() {
		Temporal empT1 = ConexionHibernateSF.getSession().get(Temporal.class, "53170624Y");
		Temporal empT2 = ConexionHibernateSF.getSession().get(Temporal.class, "12345678Z");
		String error = "Tienes que cargar los empleados antes de realizar esta acción";

		if (objetoIsNotNull(empT1, error) && objetoIsNotNull(empT2, error)) {
			Producto pr1 = ConexionHibernateSF.getSession().get(Producto.class, "ref01");
			Producto pr2 = ConexionHibernateSF.getSession().get(Producto.class, "ref02");
			String error2 = "Tienes que cargar los productos  antes de realizar esta acción";

			if (objetoIsNotNull(pr1, error2) && objetoIsNotNull(pr2, error2)) {
				Venta venta1 = new Venta(LocalDate.parse("2022-02-23"), LocalTime.parse("11:33"), pr1, 2, 232F, empT1);
				Venta venta2 = new Venta(LocalDate.parse("2022-02-24"), LocalTime.parse("12:23"), pr2, 11, 192F, empT2);
				Venta venta3 = new Venta(LocalDate.parse("2022-02-25"), LocalTime.parse("10:53"), pr1, 5, 100000F, empT2);

				ConexionHibernateSF.beginTransaction();
				ConexionHibernateSF.save(venta1);
				ConexionHibernateSF.save(venta2);
				ConexionHibernateSF.save(venta3);
				ConexionHibernateSF.commitAndClose();

				peticiones.SalidasGui.mensaje("Grabadas Ventas: " + "\n" + venta1.toString()
																	+ "\n" + venta2.toString()
																	+ "\n" + venta3.toString());

			}
		}
		ConexionHibernateSF.close();
	}

	void bajaEmpleado() {
		Empleado empTemporal = ConexionHibernateSF.getSession().get(Empleado.class, "53170624Y");
		Empleado empFijo = ConexionHibernateSF.getSession().get(Empleado.class, "3603769N");
		String error = "No se ha podido encontrar ningÃºn empleado con el dni 53170624Y";
		if (objetoIsNotNull(empTemporal, error)) {
			ConexionHibernateSF.beginTransaction();

			ConexionHibernateSF.getSession().delete(empTemporal);
			ConexionHibernateSF.commitAndClose();
			peticiones.SalidasGui.mensaje("Eliminado empleado:" + "\n" + empTemporal.toString());

		}
		error = "No se ha podido encontrar ningÃºn empleado con el dni 3603769N";
		if (objetoIsNotNull(empFijo, error)) {
			ConexionHibernateSF.beginTransaction();
			ConexionHibernateSF.getSession().delete(empFijo);
			ConexionHibernateSF.commitAndClose();
			peticiones.SalidasGui.mensaje("Eliminado empleado:" + "\n" + empFijo.toString());

		}
		ConexionHibernateSF.close();
	}

	void modProducto() {
		Producto producto = ConexionHibernateSF.getSession().get(Producto.class, "ref03");
		String error = "Tienes que cargar los productos antes de realizar esta acción";
		if (objetoIsNotNull(producto, error)) {
			float precioAnterior = producto.getPrecioUnidad();
			producto.setPrecioUnidad((float) Math.random() * 1000);
			ConexionHibernateSF.beginTransaction();
			ConexionHibernateSF.getSession().update(producto);
			ConexionHibernateSF.commitAndClose();
			peticiones.SalidasGui.mensaje("Modificado precio producto de " + precioAnterior + " a "
					+ producto.getPrecioUnidad() + "\n" + producto.toString());

		}

	}

	void modEmpleado() {
		Fijo empFijo = ConexionHibernateSF.getSession().get(Fijo.class, "3123322K");
		String error = "Tienes que cargar los empleados antes de realizar esta acción";
		if (objetoIsNotNull(empFijo, error)) {
			float sueldoAnterior = empFijo.getSueldo();
			empFijo.setSueldo((float) Math.random() * 1000);
			float porcentajeAnterior = empFijo.getPorcentRetencion();
			empFijo.setPorcentRetencion((float) Math.random() * 100);
			ConexionHibernateSF.beginTransaction();
			ConexionHibernateSF.getSession().update(empFijo);
			ConexionHibernateSF.commitAndClose();
			peticiones.SalidasGui.mensaje("Modificado sueldo del empleado de " + sueldoAnterior + " a "
					+ empFijo.getSueldo() + "\n" + "Modificado porcentaje del empleado de " + porcentajeAnterior + " a "
					+ empFijo.getPorcentRetencion() + "\n" + empFijo.toString());

		}

		Temporal empTemporal = ConexionHibernateSF.getSession().get(Temporal.class, "12345678Z");
		if (objetoIsNotNull(empTemporal, error)) {
			float importeAnterior = empTemporal.getPagoDia();
			empTemporal.setPagoDia((float) Math.random() * 100);

			ConexionHibernateSF.beginTransaction();
			ConexionHibernateSF.getSession().update(empTemporal);
			ConexionHibernateSF.commitAndClose();

			peticiones.SalidasGui.mensaje("Modificado pagoDia del empleado de " + importeAnterior + " a "
					+ empTemporal.getPagoDia() + "\n" + empTemporal.toString());

		}
	}

	void listarEmpresas() {

		List<Empresa> empresas = ConexionHibernateSF.getSession().createQuery("SELECT b FROM Empresa b", Empresa.class)
				.list();
		StringBuilder lista = new StringBuilder();
		if (!empresas.isEmpty()) {
			peticiones.SalidasGui.mensaje("Numero de empresas: " + empresas.size());
			for (Empresa empresa : empresas) {
				lista.append("-> " + empresa.toString() + "\n");
			}
		} else {
			lista.append("No hay empresas");
		}
		peticiones.SalidasGui.mensaje(lista.toString());
		ConexionHibernateSF.close();

	}

	void listarProductos() {
		Empresa empCargada1 = ConexionHibernateSF.getSession().get(Empresa.class, "B53170624Y");
		String error = "Tienes que cargar las empresas antes de realizar esta acción";
		if (objetoIsNotNull(empCargada1, error)) {
			peticiones.SalidasGui.mensaje("Empresa: \n" + empCargada1.toString());
			peticiones.SalidasGui.mensaje("Lista de productos: " + "\n" + empCargada1.getProductos().toString());
		}
		ConexionHibernateSF.close();
	}

	void objetivoEmpleadoTemporal() {
		Temporal empTemporal = ConexionHibernateSF.getSession().get(Temporal.class, "12345678Z");
		String error = "Tienes que cargar los empleados antes de realizar esta acción";
//-Dado un empleado temporal ,visualizar su nómina, comprobando  que si en su período de contratación, 
// vende un importe superior a 100.000 euros ,cobrará un suplemento de 100 euros.


		if (objetoIsNotNull(empTemporal, error)) {			
			peticiones.SalidasGui.mensaje("Nomina del empleado: " + empTemporal.getSueldo()
										+"\nImporte Ventas: " + empTemporal.getImporteVentas());

		}
	}

	boolean objetoIsNotNull(Object objeto, String error) {
		if (objeto == null) {
			peticiones.SalidasGui.mensaje(error);
			return false;
		} else {
			return true;
		}
	}

}
