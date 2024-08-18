package edu.eci.arsw.blacklistvalidator;

public class Distribution {
    //reparticion de la cadena en el N
    private int[] array;
    private int cant;
    private int Num;

    public Distribution(int cant, int N){
        this.cant = cant;
        this.Num = N;
        this.array = new int [N]; //Reparicion de los elementos de acuerdo a N

        //operaciones
        int div = cant / N;
        int mod = cant % N;
        int sum = div;

        for(int i = 0; i < N ; i++){
            if(i+1 == N){
                this.array[i]=sum+mod;
            }else{
                this.array[i]=sum;
            }

        }
    }

    public int[] getArray() {
        return array;
    }
}

