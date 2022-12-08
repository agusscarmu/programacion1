import java.util.Random;

public class intentoescrito {
    final static int M=4;
    final static int N=3;
    public static void main(String[]args){
        int[][]nros=new int[M][N];
        generar_matriz(nros);
        imprmir(nros);
        buscar_ceros(nros);
        ordenar_columna(nros);
        System.out.println("\n acomodado \n");
        imprmir(nros);
    }
    public static void generar_matriz(int[][]nros){
        Random r = new Random();
        for(int fil=0;fil<M;fil++){
            for(int col=0;col<N;col++){
                nros[fil][col]=r.nextInt(3);
            }
        }
    }
    public static void imprmir(int[][]nros){
        for(int fil=0;fil<M;fil++){
            for(int col=0;col<N;col++){
                System.out.print(nros[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
    public static void buscar_ceros(int[][]nros){
        int posfil=0;
        int poscol=0;
        for(int col=0;col<N;col++){
            for(int fil=0;fil<M;fil++){
                if(nros[fil][col]==0){
                    posfil=fil;
                    poscol=col;
                    correr_cero(nros,posfil,poscol);
                }
            }
        }
    }
    public static void correr_cero(int[][]nros,int posfil, int poscol){
        int aux=nros[posfil][poscol];
        for(int fil=posfil;fil<(M-1);fil++){
            nros[fil][poscol]=nros[fil+1][poscol];
        }
        nros[M-1][poscol]=aux;
    }
    public static void ordenar_columna(int[][]nros){
        int conteo=0;
        int poscol=0;
        int conteomayor=0;
        for(int i=0;i<N;i++){
            for(int col=0;col<N;col++){
                conteo=0;
                for(int fil=M-1;fil>-1;fil--){
                    if(nros[fil][col]==0){
                        conteo=conteo+1;
                    }else{
                        break;
                    }
                }
                if(conteo<conteomayor){
                    poscol=col;
                    if(col>0){
                        correr_columna(nros,poscol);
                    }
                }
                if (conteo>conteomayor){
                conteomayor=conteo;
                }
            }
        }
    }
    public static void correr_columna(int[][]nros, int poscol){
        int aux=0;
        int lastaux=0;
        for(int i=0;i<M;i++){
            lastaux=nros[M-1][poscol];
            for(int col=poscol;col>-1;col--){
                aux=nros[M-1][col];
                for(int fil=M-1;fil>0;fil--){
                    nros[fil][col]=nros[fil-1][col];
                }
                if(col<poscol){
                    nros[0][col+1]=aux;
                }
            }
            nros[0][0]=lastaux;
        }
    }
}
