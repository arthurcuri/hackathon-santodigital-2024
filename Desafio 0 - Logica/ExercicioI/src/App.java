import java.util.List;
import java.util.ArrayList;
/*
Escreva uma função que, dado um número inteiro n, retorne uma 
lista de n strings de tal forma que a string i contém i asteriscos. 
Por exemplo, para n=5, a lista retornada seria ["*", "**", "***", "****", "*****"]
*/
public class App {
    public static void main(String[] args) throws Exception {
        List<String> list = listaDeAsteriscos(10);
        System.out.println(list);
    }

    public static List<String> listaDeAsteriscos(int n){
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            sb.append("*");
            list.add(sb.toString());
        }

        return list;
    }
}
