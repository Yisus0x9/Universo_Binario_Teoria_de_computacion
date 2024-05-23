import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Test {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int op=0;
        System.out.println("#####Bienvenido#####" + "\nSelecciona una Opcion");
        do {
            System.out.println("1.-Introducir una n\n2.-Generar Aleatorio\n3.-Salir");
            op=entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Introduce la n");
                    generarLenguaje(entrada.nextInt());
                    System.out.println("Universo Exitosamente calculado");
                    break;
                case 2:
                    int r=(int)(Math.random()*(100+1));
                    System.out.println("Generando E^k, con k="+r);
                    generarLenguaje(r);
                    System.out.println("Universo Exitosamente calculado");
                    break;
                case 3:
                    System.out.println("SALIENDO");
                    op=0;
                    break;
            }
        }while (op!=0);


    }

    public static void generarLenguaje(int n){
        String nombre="conjuntoDePotencias";
        Power lenguaje=new Power (n,nombre);
        System.out.println(n);
        System.out.println("Terminado");

       Grafica g= new Grafica("Grafica",lenguaje.getnUnos());
        JFrame ventana=new JFrame("GRAFICA");
        JFrame ventana2=new JFrame("Grafica de Logaritmos base 10");
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventana.setSize(1200,1000);
        ventana.add(g.graficarUnos());
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ventana2.setVisible(true);
                ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventana2.setSize(1200,1000);
                ventana2.add(g.graficarLog());
            }
        });
        }


}
