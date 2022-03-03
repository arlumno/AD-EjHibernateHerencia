/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import javax.persistence.Entity;
import javax.persistence.*;


/**
 *
 * @author a20armandocb
 */
@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    String codigo;
    
    int stockActualAlmacen;
    
    @ManyToOne(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)    
    @JoinColumn(name = "cifEmpresa")
    private Empresa empresa;
    
    final int stockMinimo = 30;
    float precioUnidad;

    public Producto() {
    }

    
    public Producto(String codigo, int stockActualAlmacen, Empresa empresa, float precioUnidad) {
        this.codigo = codigo;
        this.stockActualAlmacen = stockActualAlmacen;
        this.empresa = empresa;
        this.precioUnidad = precioUnidad;
    }

    @Override
    public String toString() {
        return "\n --- Producto{" + "codigo=" + codigo + ", stockActualAlmacen=" + stockActualAlmacen + ", empresa=" + empresa.nombre + ", stockMinimo=" + stockMinimo + ", precioUnidad=" + precioUnidad + '}';
    }

   
   
    

}
