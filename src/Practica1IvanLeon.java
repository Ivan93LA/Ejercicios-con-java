
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ivan_leon
 */
public class Practica1IvanLeon {

    public static void main(String[] args) {

        menu();
    }
// Creamos una función que va a ser el menú principal, con un switch 

    public static void menu() {
        int elemento = 0;
        double historial = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.calculadora\n2.Historial\n3.numeroPrimo "
                    + "\n4.Cuadrícula\n5.Pirámide de numeros"
                    + "\n6 info app\n0 Fin");
            System.out.println("\n INTRODUCE UN NÚMERO DEL MENÚ");
            elemento = sc.nextInt();
            switch (elemento) {
                case 0:
                    Fin();
                    break;
                case 1:
                    historial = calculadora();
                    System.out.println();
                case 2:
                    System.out.println(historial);
                    break;       //En el menú, al poner un número, se elige que ejercicio hacer
                case 3:
                    menuPrimo();
                    break;
                case 4:
                    cuadricula();
                    break;
                case 5:
                    piramide();
                    break;
                case 6:
                    InfoApp();
                    break;

                default:
                    System.out.println("");
            }
        } while (elemento != 0);
    }

//ejercicio 1
    public static double calculadora() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Primer Número");
        double num1 = sc.nextDouble();
        System.out.println("Segundo número");
        double num2 = sc.nextDouble();
        System.out.println("¿Que operación quieres?");
        String o = sc.next();
        double resultado = 0;
        switch (o) {       //Creamos el switch con los casos de las operaciones 
            //que queremos hacer
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;    //Declaramos los operandos
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
            default:
        }
        return resultado;    //devolvemos el resultado final de la operación
    }

//ejercicio 2-3
    public static void menuPrimo() {
        Scanner sc = new Scanner(System.in);
        int respuesta;
        boolean salir = false;
        do {
            System.out.println("¿Que quieres hacer?\n\t1.Ver si es primo\n\t2.Ver Los numeros Primos\n\t3.Salir");
            respuesta = sc.nextInt();
            switch (respuesta) {
                case 1:
                    System.out.println("Introduce un numero");
                    int num = sc.nextInt();
                    System.out.println(numeroPrimo(num));
                    break;
                case 2:
                    System.out.println("Introduce un numero");
                    int num2 = sc.nextInt();
                    mostrarNumprimos(num2);
                    break;
                case 3:    //Otro switch reutilizado para crear los casos de números
                    salir = true;
                    break;
                default:
                    System.out.println("No esta en la lista");
            }

        } while (salir != true);
    }

    public static void mostrarNumprimos(int num) {
        for (int i = 1; i <= num; i++) {
            //System.out.println("Los resultados son..."); 
            if (numeroPrimo(i) == true) {
                System.out.println(i);
            }
        } //Que enseñe los números

    }

    //submenu Primo
    public static boolean numeroPrimo(int numero) {
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        if (numero == 1) {
            return false;
        }              //He metido el if porque el 1 no es primo, sino si lo disparaba
        return true;
    }

//Ejercicio 4
    public static void cuadricula() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de filas");
        int fila = sc.nextInt(); // declaro columnas y filas
        System.out.println("Introduce el Número de columnas");
        int columna = sc.nextInt();
        System.out.println("Introduce el carácter de relleno");
        String c = sc.next();   //declaro las variables dentro de los escáneres
        for (int i = 0; i < fila; i++) { //condición de filas
            System.out.println("");
            for (int j = 0; j < columna; j++) {  //condicion de columnas
                System.out.print(c);
            }
        }
        System.out.println("\n");
    }

//Ejercicio 5
    public static void piramide() {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        System.out.println("Introduce el tamaño de la pirámide\nPositivo es de una forma, "
                + "negativo es de otra");
        numero = sc.nextInt();  //Enunciados
        System.out.println("\n");
        if (numero > 0) {
            for (int i = 0; i <= numero; i++) {  //Elegimos el número de filas
                for (int j = 0; j < i; j++) { //Que vaya sumando las columnas
                    System.out.print(i);
                }
                System.out.println("");
            }
        } else { //Si metemos otro número, un negativo, hace la distinta
            for (int i = numero; i < 0; i++) {
                for (int j = i; j < 0; j++) {
                    System.out.print(i);
                }                 // Si es if, hace la positiva, ELSE c
                //uando es negativa
                System.out.println("");
            }
        }

    }

//Ejercicio 6 //Mensajes de muestras
    public static void InfoApp() {
        System.out.println("-------ESTE ES MI PROGRAMA-------");
        System.out.println("***Iván León****");
        System.out.println("Se introducen los números en el menú y "
                + "ya realizan los ejercicios");
        System.out.println("\n");
    }

//ejercicio 0 
    public static void Fin() {
        System.out.println("Fin del programa");
    }
}  //Un simple mensaje
