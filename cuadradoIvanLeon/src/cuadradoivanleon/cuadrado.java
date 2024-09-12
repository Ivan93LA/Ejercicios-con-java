/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuadradoivanleon;

/**
 *
 * @author IvánLeónÁlvarez
 */
public class Cuadrado { //Clases  con mayúscula SIEMPRE y funciones minúscula

    private int lado1;
    private int lado2;
    private String color;

    public Cuadrado(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Cuadrado(int lado1, int lado2, String color) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.color = color;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        if (lado1 < 0) { //Para no meter negativos
            this.lado1 = lado1;
        }
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        if (lado2 < 0) { //Esto es para decir que no se pueden poner nº negativos
            System.out.println("Error, lado2 no puede ser negativo");
            return;
        } else {
            this.lado2 = lado2;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String pinta() {
        if (lado1 <= 0 || lado2 <= 0) {
            return " ";
        }
        String dibujo = "";
        for (int i = 0; i < lado1; i++) { // LADO1 = 5
            for (int j = 0; j < lado2; j++) {
                if (i == 0 || i == (lado1 - 1)) { // se le resta 1 para no sobrepasar
                    dibujo += "-";
                } else if (j == 0 || j == (lado2 - 1)) {
                    dibujo += "|"; //la altura
                } else {
                    dibujo += " "; //el relleno del cuadrado
                }
            }
            dibujo += "\n"; // para que haya saltos de linea            
        }
        return dibujo;
    } 

    public double calculaArea() {
        if (lado1 <= 0 || lado2 <= 0) {
            return 0;
        } else {
            return lado1 * lado2;
        }
    }

    public static double calculaArea(double lado1, double lado2) {
        if (lado1 <= 0 || lado2 <= 0) {
            return 0;
        } else {
            return lado1 * lado2;
        }
    }

    public String imprimeInfo() {
        String retorno = "";
        retorno +=  "Lado1: " + this.lado1 + "lado2: " + this.lado2;
        if (color != null) { //si pongo return aqui, lo de abajo no se lee
            retorno += ", Color: " + this.color;
        } 
        return retorno;

    }

}
