/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuadradoivanleon;

/**
 *
 * @author IvánLeónÁlvarez
 */
public class CuadradoIvanLeon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
     Cuadrado c1 = new Cuadrado (4, 6);
     Cuadrado c2 = new Cuadrado (10,15, "rojo");
     double sumaAreas = c1.calculaArea () + c2.calculaArea();
        System.out.println(sumaAreas);
        System.out.println(c1.pinta());
    }
    
}
