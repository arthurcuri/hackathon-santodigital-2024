import java.util.ArrayList;
import java.util.List;
/*
Dado um array de números inteiros, 
escreva uma função que retorne o par de números com a menor diferença absoluta. 
Se houver mais de um par com a mesma diferença, retorne todos eles em uma lista.
*/
public class App {
    public static void main(String[] args) throws Exception {
        int []vect = {-5, -4, -3, -2};

        List<Integer> result = menorDifAbsoluta(vect);
        System.out.println(result);
    }

    public static List<Integer> menorDifAbsoluta(int[]vect){
        List<Integer>  list = new ArrayList<>();

        for(int i = 0; i< vect.length; i++){
            for(int j=(i+1); j<vect.length; j++){
                list.add(Math.abs(vect[i]-vect[j]));
            }
        }

        int menorValor = list.get(0)+1;
        List<Integer> menorDiferenca = new ArrayList<>();

        for (Integer i : list) {
            if(i != 0 && i < menorValor){
             menorValor = i;
            }
        }

        for (Integer i : list) {
            if(i == menorValor){
            menorDiferenca.add(i);
            }
        }
    
        return menorDiferenca;
    }
}
