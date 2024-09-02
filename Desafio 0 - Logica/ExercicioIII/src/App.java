/*
Escreva uma função que retorne todos os subconjuntos de um conjunto de números. 
Por exemplo, se a entrada for [1, 2], a saída deve ser [[], [1], [2], [1, 2]]. 
*/

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        int[] vect = {1, 2};

        List<List<Integer>> list = new ArrayList<>();
        list = subconjuntos(vect);
        System.out.println(list);
    }

    public static List<List<Integer>> subconjuntos(int[] vect){
        List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>());

        for (int num : vect) {
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();
            for (List<Integer> subconjunto : subconjuntos) {
                List<Integer> novoSubconjunto = new ArrayList<>(subconjunto);
                novoSubconjunto.add(num);
                novosSubconjuntos.add(novoSubconjunto);
            }
        subconjuntos.addAll(novosSubconjuntos);
        }
    return subconjuntos;
    }
}
