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

//    public static void demo() {
//
//        Autor a1 = new Autor("53170624Y", "Armando", "Española", new Telefono("53170624Y", "986 123 456"));
//        Autor a2 = new Autor("12345678Z", "Marcos", "Española", new Telefono("12345678Z", "986 333 444"));
//        Autor a3 = new Autor("83271544Z", "Elena", "Española", new Telefono("83271544Z", "986 123 456"));
//
//        Libro lib1 = new Libro("Un Tutorial de Ejemplo", 9.95F);
//        Libro lib2 = new Libro("Las Disculpas", 4.95F);
//        Libro lib3 = new Libro("Los TRes", 14.95F);
//        Libro lib4 = new Libro("Los Cuatro", 44.95F);
//
//        a1.getLibros().add(lib1);
//        lib1.getAutores().add(a1);
//
//        a1.getLibros().add(lib2);
//        lib2.getAutores().add(a1);
//
//        a2.getLibros().add(lib3);
//        lib3.getAutores().add(a2);
//
//        a3.getLibros().add(lib4);
//        lib4.getAutores().add(a3);
//
//
//        ConexionHibernateSF.getSession().beginTransaction();
//
//        ConexionHibernateSF.getSession().save(a1);
//        ConexionHibernateSF.getSession().save(a2);
//        ConexionHibernateSF.getSession().save(a3);
//
//        ConexionHibernateSF.getSession().getTransaction().commit();
//        ConexionHibernateSF.getSession().close();
//    }
//
//    public static void consultarAutor() {
//
//        String dni = EntradasGui.pedirString("indica el dni del autor");
//        if (dni != null) {
//            System.out.println("Buscado dni: " + dni);
//
//            Autor autor = (Autor) (ConexionHibernateSF.getSession().get(Autor.class, dni));
//            if (autor != null) {
//                System.out.println("---------------------");
//                System.out.println(autor.toString());
//                System.out.println("---------------------");
//            } else {
//                System.out.println("No se ha encontrado el autor con dni: " + dni);
//            }
//
//            ConexionHibernateSF.close();
//
//        }
//
//    }
//
//    public static void listarAutores() {
//
//        List<Autor> autores = ConexionHibernateSF.getSession().createQuery("SELECT b FROM Autor b", Autor.class).list();
//
//        if (!autores.isEmpty()) {
//            for (Autor autor : autores) {
//                System.out.println("---------------------");
//                System.out.println(autor.toString());
//                System.out.println("---------------------");
//            }
//        } else {
//            System.out.println("No hay libros");
//        }
//        ConexionHibernateSF.close();
//    }
//
//    public static void listarLibros() {
//
//        List<Libro> libros = ConexionHibernateSF.createQueryList("SELECT b FROM Libro b", Libro.class);
//
//        if (!libros.isEmpty()) {
//            for (Libro libro : libros) {
//                System.out.println("---------------------");
//                System.out.println(libro.toString());
//                System.out.println("---------------------");
//            }
//        } else {
//            System.out.println("No hay libros");
//        }
//        ConexionHibernateSF.close();
//    }
//
//    public static void consultarLibro() {
//        String titulo = EntradasGui.pedirString("indica parte del titulo del autor");
//        if (titulo != null) {
//
//            
//            //con Like
//            List<Libro> libros = ConexionHibernateSF.getSession().createQuery("SELECT b FROM Libro b WHERE b.titulo LIKE :titulo", Libro.class
//                                                         ).setParameter("titulo", "%" + titulo + "%").list();
//
//            if (!libros.isEmpty()) {
//                for (Libro libro : libros) {
//                    System.out.println("---------------------");
//                    System.out.println(libro.toString());
//                    System.out.println("---------------------");
//                }
//            } else {
//                System.out.println("No hay concordancias para libros con: " + titulo);
//            }
//            ConexionHibernateSF.close();
//        }
//
//    }
//
//    public static void modificar() {
//        Autor a1 = (Autor) (ConexionHibernateSF.getSession().get(Autor.class,
//                "53170624Y"));
//        a1.setNombre("Fernando");
//        a1.setTelefono(new Telefono(a1.getDni(), "111 222 333"));
//        ConexionHibernateSF.getSession().beginTransaction();
//        ConexionHibernateSF.getSession().update(a1);
//        ConexionHibernateSF.getSession().getTransaction().commit();
//        ConexionHibernateSF.close();
//    }
//
//    public static void eliminar() {
//        Autor a1 = (Autor) (ConexionHibernateSF.getSession().get(Autor.class, "53170624Y"));
//        ConexionHibernateSF.getSession().beginTransaction();
//        ConexionHibernateSF.getSession().delete(a1);
//        ConexionHibernateSF.getSession().getTransaction().commit();
//    }
//
//    public static void eliminarAutores() {
//        List<Autor> autores = ConexionHibernateSF.createQueryList("SELECT b FROM Autor b", Autor.class);
//
//        if (!autores.isEmpty()) {
//            ConexionHibernateSF.getSession().beginTransaction();
//            for (Autor autor : autores) {
//                System.out.println(autor.getNombre() + " ---- Borrando....");
//                ConexionHibernateSF.getSession().delete(autor);
//            }
//            ConexionHibernateSF.getSession().getTransaction().commit();
//            System.out.println("- - - - elementos eliminados - - -");
//        } else {
//            System.out.println("No hay libros");
//        }
//        ConexionHibernateSF.close();
//    }

    void altaEmpresa() {
        Empresa emp1 = new Empresa("53170624Y", "b58", "coutadas 58", "986 378 510");
        Empresa emp2 = new Empresa("12345678Z", "empresa2", "cualquier lugar", "986 123 456");
        Empresa emp3 = new Empresa("C123456", "SONY", "nunca jamas 42", "+43 123 456 789");
        ConexionHibernateSF.beginTransaction();
        ConexionHibernateSF.save(emp1);
        ConexionHibernateSF.save(emp2);
        ConexionHibernateSF.save(emp3);
        ConexionHibernateSF.commitAndClose();
    }

    void altaEmpleado() {
        Empresa empCargada1 = ConexionHibernateSF.getSession().get(Empresa.class, "C123456");
        Temporal empT1 = new Temporal(LocalDate.parse("2022-02-22"), LocalDate.parse("2022-02-27"), 4F, 45F,"53170624Y","Armando","123456",12F,322F,empCargada1);           
        Fijo empF1 = new Fijo(1200, 150, "3603769N", "Pedro", "123 456 789", 10F, 1300F, empCargada1);
        Venta venta1 =  new Venta(LocalDate.parse("2022-02-23"), LocalTime.parse("11:33"), "AADS", 2, 232F, empT1);
        Venta venta2 =  new Venta(LocalDate.parse("2022-02-24"), LocalTime.parse("12:23"), "jlpll", 11, 192F, empT1);
        empT1.guardarVenta(venta1);
        empT1.guardarVenta(venta2);
        
        ConexionHibernateSF.beginTransaction();
        ConexionHibernateSF.save(empT1);        
        ConexionHibernateSF.save(empF1);        
        ConexionHibernateSF.commitAndClose();
    }

    void altaProducto() {
        Empresa empCargada1 = ConexionHibernateSF.getSession().get(Empresa.class, "C123456");
        Producto pr1 = new Producto("aads", 15,empCargada1, 233F);
        
        ConexionHibernateSF.beginTransaction();
        ConexionHibernateSF.save(pr1);
        ConexionHibernateSF.commitAndClose();
        
    }

    void altaVenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void bajaEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void modProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void modEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void listarEmpresas() {
        Empresa empCargada1 = ConexionHibernateSF.getSession().get(Empresa.class, "C123456");
        List<Empresa> empresas = ConexionHibernateSF.getSession().createQuery("SELECT b FROM Empresa b", Empresa.class).list();
         if (!empresas.isEmpty()) {
             System.out.println("Numero de empresas: " + empresas.size());
            for (Empresa empresa : empresas) {
                System.out.println("---------------------");
                System.out.println("---------------------\n" + empresa.toString() + "\n---------------------");
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No hay empresas");
        }
        ConexionHibernateSF.close();

    }

    void listarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void objetivoEmpleadoTemporal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
}
