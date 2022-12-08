class Fibonacci { 
    public static void main( String args[] ){ 
        int max = 1000; 
        int bajo = 1;
        int alto = 0; 

        System.out.println( bajo ); 
        while( alto < max ) { 
            System.out.println( alto ); 
            int temp = alto; 
            alto += bajo; 
            bajo = temp; 
            } 
        } 
    } 