import java.util.ArrayList;
import java.util.List;
/*
Dado um array de números inteiros, escreva uma função que retorne o 
par de números com a menor diferença absoluta. Se houver mais de um par com a mesma diferença, 
retorne todos eles em uma lista. Além disso, a função deve permitir os seguintes parâmetros opcionais: 
allow_duplicates (booleano)
Se definido como False, os pares de números não podem conter valores duplicados.
sorted_pairs (booleano)
Se definido como True, os pares no resultado devem estar ordenados em ordem crescente.
unique_pairs (booleano)
Se definido como True, a função deve retornar apenas
pares únicos (ou seja, (a, b) e (b, a) são considerados o mesmo par). 
*/
public class App {
    public static void main(String[] args) throws Exception {
        int[] vect = {-5, -4, -3, -2};

        List<int[]> result = menorDifAbsoluta(vect, false, true, true);
        for (int[] pair : result) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }

    public static List<int[]> menorDifAbsoluta(int[] vect, boolean allowDuplicates, boolean sortedPairs, boolean uniquePairs) {
        List<int[]> list = new ArrayList<>();
        List<int[]> menorDiferenca = new ArrayList<>();

        for (int i = 0; i < vect.length; i++) {
            for (int j = i + 1; j < vect.length; j++) {
                if (!allowDuplicates && vect[i] == vect[j]) {
                    continue;
                }

                int a = vect[i];
                int b = vect[j];

                if (sortedPairs && a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }

                list.add(new int[]{a, b, Math.abs(a - b)});
            }
        }

        int menorValor = list.get(0)[2] + 1;

        for (int[] pair : list) {
            if (pair[2] != 0 && pair[2] < menorValor) {
                menorValor = pair[2];
            }
        }

        for (int[] pair : list) {
            if (pair[2] == menorValor) {
                if (uniquePairs) {
                    boolean alreadyExists = false;
                    for (int[] existingPair : menorDiferenca) {
                        if (existingPair[0] == pair[0] && existingPair[1] == pair[1]) {
                            alreadyExists = true;
                            break;
                        }
                    }
                    if (!alreadyExists) {
                        menorDiferenca.add(new int[]{pair[0], pair[1]});
                    }
                } else {
                    menorDiferenca.add(new int[]{pair[0], pair[1]});
                }
            }
        }
        return menorDiferenca;
    }
}
