import java.util.ArrayList;


/*
* Clase que genera la unión de las potencias del alfabeto binarios desde 0 hasta n, es decir, Σ^0 U Σ^1 U Σ^2 U Σ^3 ... UΣ^K
* donde Σ={0,1}
* */
public class Power {

    // Variables para escribir en archivo, guardar datos a graficar y dar formato
     private ArchivoServicio datos;
     private ArrayList<Integer> nUnos=new ArrayList<>();
     int i;


     /*
      *Constructor que recibe n que es el número de conjuntos a obtener y
      *el nombre del archivo donde se guardaran los datos.
      */
     public Power(int n,String nombre){
            datos= new ArchivoServicio(nombre).ArchivoBufferedW("∑={ ε ,");
            generateEk(n,"");
     }


    /*
     *Funciona recursiva que verifica si ya se han generado  las cadenas binarias checando
     * si la longitud de la cadena ya tiene los n bits
     * @Parametros:
     *      @n--> es el exponente que indica la longitud máxima de las cadenas a generar
     *      @cad--> inicialmente recibe la caden vacía, despues las cadenas que se van generando
     */
    public void generateEk(int n,String cad){
        if (cad.length() < n) {
            generateEk(n,escribiryconcat(1,cad));
            generateEk(n, escribiryconcat(0,cad));
        }
    }

    /* Función que añade  a las cadenas recibidas 1 y 0, además de escribirlas en el archivo,
     * de esta forma, así como se van generando se van escribiendo, lo escribe en el archivo
     * y les va dando formato.Aunque se puede hacer mas legible calculando cada Σ^k , escribiéndolo
     * en el archivo y generar el Σ^k+1 haciendo lo mismo, de esta forma se optimiza más el código
     * puesto que no espera ha que se detenga la pila de llamadas recursivas para obtener la cadena,
     * cada que se añada 1 o 0 , esa cadena pertenece al conjunto por lo tanto se escribe de una vez.
     * @Parametros:
     *      @ref->indica si se añade 1 o 0
     *      @temp->cadena vacía o cadena binaria a la que añade un bit
     */
    public String escribiryconcat(int ref,String temp){
        if(ref==1){
            i++;
            temp+='0';
            numeroUnos(temp);
            datos.ArchivoBufferedW(temp+",");
            if(i%10==0){datos.ArchivoBufferedW("\n");}
        }else {
            i++;
            if(i%10==0){datos.ArchivoBufferedW("\n");}
            temp+='1';
            numeroUnos(temp);
            datos.ArchivoBufferedW(temp+",");
        }
            return temp;
    }
       /***********************FUNCION QUE VA OBTENIENDO EL #1´S DE CADA CADENA ***********************/
        private void numeroUnos(String cadena){
            nUnos.add((int)cadena.chars().filter(ch -> ch =='1').count());
        }

        public ArrayList<Integer> getnUnos(){
            return nUnos;
        }
}