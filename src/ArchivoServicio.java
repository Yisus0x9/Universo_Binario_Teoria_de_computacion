import java.io.*;
/*
* Clase que ofrece la funcionalidad para escribir en un archivo
* */
    public class ArchivoServicio {
        File archivo;
        String nombre;

        public ArchivoServicio(String nombre){
            archivo= new File(nombre);
            if(archivo.exists()){archivo.delete();}
            this.nombre=nombre;
        }


        public ArchivoServicio ArchivoBufferedW(String cads){
            try(BufferedWriter buffer=new BufferedWriter(new FileWriter(archivo,true))){
                buffer.append(cads);
            }catch(IOException e){
                System.out.println("Error al escribir archivo con BufferWriter");
                e.printStackTrace();
            }
            return this;
        }
    }


