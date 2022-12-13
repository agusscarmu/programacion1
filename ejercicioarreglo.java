import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejercicioarreglo {
    final static int MAX=10;

    public static void main(String[]args){
        char[]original={'a','b','c','d','e','f','g','h','i','u'};
        int[]orden1={0,4,8,9,-1,-1,-1,-1,-1,-1};

        int posicion=solicitar_posi();
        eliminar_letra(original,posicion);
        actualizar_orden(original,orden1);
        imprimir(original,orden1);
    }
    public static int solicitar_posi(){
        int posicion=0;
        BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("ingrese una posicion");
            posicion=new Integer(entrada.readLine());
        }catch(Exception exc){
            System.out.println(exc);
        }
        return posicion;
    }
    public static void eliminar_letra(char[]original, int posicion){
        if(posicion<MAX){
            for(int i=posicion;i<(MAX-1);i++){
                original[i]=original[i+1];
            }
            original[MAX-1]= ' ';
        }else{
            System.out.println("La posicion es mas grande que el tamaño del arreglo");
        }
    }
    public static void actualizar_orden(char[]original, int[]orden1){
        int conteo=0;
        for(int i=0;i<MAX;i++){
            if(conteo<MAX){
            for(int j=conteo;j<MAX;j++){
                conteo++;
                if(original[j]=='a' || original[j]=='e' || original[j]=='i' || original[j]=='o' || original[j]=='u'){
                    orden1[i]=j;
                    break;
                }
                orden1[i]=-1;
            }
            }
        }
    }
    public static void imprimir(char[]original,int[]orden1){
        System.out.println("Arreglo original: ");
        for(int i=0;i<MAX;i++){
            System.out.print(original[i]+ " | ");
        }
        System.out.println("\n");
        System.out.println("Arreglo orden actualizado: ");
        for(int j=0;j<MAX;j++){
            System.out.print(orden1[j]+ " | ");
        }
    }
}
