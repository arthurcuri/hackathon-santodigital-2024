import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Escreva uma função que retorne todos os subconjuntos de um conjunto de números.
A função deve permitir os seguintes parâmetros opcionais:
max_size (inteiro): Limita o tamanho máximo dos subconjuntos.
min_size (inteiro): Define o tamanho mínimo dos subconjuntos.
distinct_only (booleano): Se definido como True, a função deve garantir que os 
subconjuntos não contenham elementos duplicados.
sort_subsets (booleano): Se definido como True, os subconjuntos e os elementos 
dentro dos subconjuntos devem ser retornados em ordem crescente. 
*/
public class App {
    public static void main(String[] args) throws Exception {
        int[] vect = {8, 4, 2};

        List<List<Integer>> resultado = subconjuntos(vect, 2, 2, true, true);
        System.out.println(resultado);
    }

    public static List<List<Integer>> subconjuntos(int[] vect, int min_size, int max_size, boolean distinct_only, boolean sort_subsets) {
        List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>());

        for (int num : vect) {
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();
            for (List<Integer> subconjunto : subconjuntos) {
                List<Integer> novoSubconjunto = new ArrayList<>(subconjunto);
                if (distinct_only && novoSubconjunto.contains(num)) {
                    continue;
                }
                novoSubconjunto.add(num);
                novosSubconjuntos.add(novoSubconjunto);
            }
            subconjuntos.addAll(novosSubconjuntos);
        }

        List<List<Integer>> filtrados = new ArrayList<>();
        for (List<Integer> subconjunto : subconjuntos) {
            if (subconjunto.size() >= min_size && subconjunto.size() <= max_size) {
                if (sort_subsets) {
                    Collections.sort(subconjunto);
                }
                filtrados.add(subconjunto);
            }
        }

        if (sort_subsets) {
            filtrados.sort((a, b) -> {
                for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return a.size() - b.size();
            });
        }
        return filtrados;
    }
}
