import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejercicioarreglo2 {
    final static int MAX=12;

    public static void main(String[]args){
        int[]original={0,4,2,2,0,3,2,0,2,2,0,0};
        int[]orden1={1,7,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[]orden2=new int[MAX];

        int posicion=obtener_posicion(original);
        eliminar_secuencia(original,posicion);
        actualizar(original,orden1);
        cargar(original,orden1,orden2);
        imprimir(original,orden1,orden2);
    }
    public static int obtener_posicion(int[]original){
        int posicion=0;
        boolean posi=false;
        BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
        while(posi==false){
            try{
                System.out.println("indroduzca posicion: ");
                posicion= new Integer(entrada.readLine());
                if((posicion<=0) || (posicion>=MAX) || (original[posicion]==0)){
                    System.out.println("Posicion ingresada fuera del alcance de secuencias");
                }else if(original[posicion-1]!=0){
                    System.out.println("Posicion ingresada no es un inicio de secuencia");
                }else{
                    posi=true;
                }
            }catch(Exception exc){
                System.out.println("ingrese un entero"+ exc);
            }
            }
        return posicion;
    }
    public static void eliminar_secuencia(int[]original, int posicion){
    int conteo=0;
    boolean eliminado=false;
    do{
        if((original[posicion]!=0) && (original[posicion-1]==0)){
        for(int i=posicion;i<MAX-1;i++){
        if(original[posicion]==0){
            conteo++;
        }
        original[i]=original[i+1];
        }
        original[MAX-1]=0;
        }
        if(conteo>=1){
            eliminado=true;
        }
    }
    while(eliminado==false);
    
    }
    public static void actualizar(int[]original,int[]orden1){
        int pos=0;
        int conteo=0;
        int suma=0;
        boolean actualizado=false;
        for(int i=0;i<MAX;i++){
            if(pos<MAX){
            for(int j=pos;j<MAX;j++){
                pos++;
                if(original[j]!=0){
                    conteo++;
                    suma+=original[j];
                }
                if((original[j]==0) && (conteo>1)){
                    if(suma%2==0){
                        orden1[i]=j-conteo;
                        conteo=0;
                        suma=0;
                        break;
                    }
                    conteo=0;
                    suma=0;
                    
                }
                if(j==MAX-1){
                    actualizado=true;
                }
            }
            }
            if(actualizado==true){
                orden1[i]=-1;
                break;
            }
        }
    }
    public static void cargar(int[]original,int[]orden1,int[]orden2){
        int conteo=0;
        int pos=0;
        for(int i=0;i<MAX;i++){
            conteo=0;
            if(orden1[pos]>-1){
            for(int j=orden1[pos];j<MAX-1;j++){
                if(original[j]!=0){
                    conteo++;
                }if(original[j+1]==0){
                    break;
                }
            }
            orden2[i]=conteo;
            pos++;
            }else{
                orden2[i]=-1;
            }
        }
        boolean ordenado=false;
        int aux=0;
        while(ordenado==false){
            for(int i=0;i<MAX;i++){
                if(orden2[i+1]==-1){
                    ordenado=true;
                    break;
                }
                if(orden2[i]>orden2[i+1]){
                    aux=orden2[i];
                    orden2[i]=orden2[i+1];
                    orden2[i+1]=aux;
                }
            }
        }
    }
    public static void imprimir(int[]original,int[]orden1, int[]orden2){
        System.out.println("Arreglo original: ");
        for(int i=0;i<MAX;i++){
            System.out.print(original[i]+ " | ");
        }
        System.out.println("\n");
        System.out.println("Arreglo orden actualizado: ");
        for(int j=0;j<MAX;j++){
            System.out.print(orden1[j]+ " | ");
        }
        System.out.println("\n");
        System.out.println("Arreglo orden por conteo actualizado: ");
        for(int k=0;k<MAX;k++){
            System.out.print(orden2[k]+ " | ");
        }
    }
}