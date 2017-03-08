package lapj.example2.edu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by luispo on 08/03/2017.
 */
public class Main {

    public static List<Integer> getRamdomList() {
        List<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 20;  i++) {
            numbers.add(random.nextInt(255));
        }
        return numbers;
    }

    // Method sorting in the old way
    public void oldSort() {
        List<Integer> theList = getRamdomList();
        System.out.println("The Old Way");
        System.out.println(theList);

        // Sorting in the old way
        Collections.sort(theList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(theList);
    }


    // Method to sorting with lambdas

    public void lambdasSort() {
        List<Integer> theList = getRamdomList();
        System.out.println("Lamda Way");
        System.out.println(theList);
        theList.sort((x,y) -> x.compareTo(y));
        System.out.println(theList);

    }

    public void oldFilter() {
        List<Integer> theList = getRamdomList();
        System.out.println("Old Filter");
        System.out.println(theList);
        List<Integer> filterList = new ArrayList<>();
        for (Integer number: theList
             ) {
            if (number > 50) {
                filterList.add(number);
            }
        }
        System.out.println(filterList);
    }

    public void lambdaFilter() {
        List<Integer> theList = getRamdomList();
        System.out.println("Filter lambda Way");
        System.out.println(theList);
        List<Integer> filterList = theList.stream()
                .filter(x-> x >50)
                .collect(Collectors.toList());
        System.out.println(filterList);
    }


    public static void main(String args[]) {
        // Sorting demo
        Main mainInstance = new Main();

        mainInstance.oldSort();
        mainInstance.lambdasSort();
        mainInstance.oldFilter();
        mainInstance.lambdaFilter();

        // Filtering demo


    }


}
