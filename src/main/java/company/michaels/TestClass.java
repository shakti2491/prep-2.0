package company.michaels;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nString = s.nextLine();

        Integer N = Integer.parseInt(nString);
        String arrString = s.nextLine();

        String[] arr = arrString.split(" ");

        Integer i = Arrays.stream(arr).map(str -> Integer.parseInt(str)).min(Comparator.comparingInt(a -> a)).get();
        System.out.println(N);
    }

}
