package com.job.portal;
/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import lombok.Builder;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        LinkedHashMap<Integer, Integer> hashMapInput = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            hashMapInput.put(sc.nextInt(), sc.nextInt());
        }
        hashMapInput.forEach((key, value) -> System.out.println(getResult(key.intValue(), value.intValue())));
//          for (Map.Entry<Integer,  Integer> entry: hashMapInput.entrySet()) {
//             System.out.println("[Key: "+entry.getKey()+ " , "+"Value: "+entry.getValue() +"] ");
//
//         }
    }

    public static int getResult(int numOne, int numTwo) {
        List primeList = getListOfPrimeNos(numOne, numTwo);
        int maxdiffis = getMaxDifference(primeList);
        System.out.println(maxdiffis);
        return getMaxDifference(primeList);
    }

    public static int getMaxDifference(List<Integer> primeNos) {
        if (primeNos == null) {
            return -1;
        } else {
            Integer maxNo = Collections.max(primeNos);
            Integer minNo = Collections.min(primeNos);
            return maxNo - minNo;
        }
    }

    public static List getListOfPrimeNos(int begin, int end) {
        List primeList = new ArrayList();
        for (int i = begin; i < end; i++) {


            if (!isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public static boolean isPrime(int number) {
        boolean flag = false;
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}

class A {
    public int i = 2;

    public void m1() {
        System.out.println("m1 from A");
    }
}

class B extends A {
    public int i = 3;

    public void m1() {
        System.out.println("m1 from B");
    }
}

class HelloWorld {

    public static void main(String[] args) {
        A a = new B();
        a.m1();

        System.out.println(a.i);
    }
}


class Result {

    /*
     * Complete the 'constructSequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER lo
     *  3. INTEGER hi
     */

    public static List<Integer> constructSequence(int n, int lo, int hi) {
        List<Integer> resultList = new ArrayList<Integer>();
        resultList.add(hi);
        int numberTobeAddedBefore = hi--;
        int numberTobeAddedAfter = hi--;
        while (resultList.size() < n) {
            if (numberTobeAddedAfter > lo) {
                resultList.add(numberTobeAddedAfter);
                numberTobeAddedAfter--;
            }
            if (numberTobeAddedAfter == lo && numberTobeAddedBefore > lo) {
                resultList.add(0, numberTobeAddedBefore);
                numberTobeAddedBefore--;
            }
        }
        return resultList;
    }
}

//@Getter
//@Entity
//class Employee {
//    Long empId;
//    String name;
//    String location;
//}

class Main {
    public static void main(String[] args) throws IOException {
//        List<Integer> result = Result.constructSequence(5, 7, 11);
//        result.stream().forEach(p-> System.out.println(p));
//       String firstString =  "abbdd";
//        char result = ' ';
//        for (int i = 0; i < firstString.length(); i++) {
//            for (int j = i + 1; j < firstString.length(); j++) {
//                if (firstString.charAt(i) == firstString.charAt(j)) {
//                    break;
//                }
//                else{
//                    result = firstString.charAt(i);
//                    System.out.println("HI " + result);
//                    return;
//                }
//            }
//        }


    }



}



class Solution_Node {

    public static int findNetworkEndpoint(int startNodeId ,int[] fromIds,int[] toIds) {

        //Constraints of the statement
        if((toIds.length<= 0)||(toIds.length > 10000))
        {
            return 0;
        }

        //conversion for manipulation of list () which contains the IndexOf () method
        List<Integer> toIdsList = new ArrayList<Integer>() {{ for (int i : toIds) add(i); }};
        List<Integer> fromIdsList = new ArrayList<Integer>() {{ for (int i : fromIds) add(i); }};

        boolean endFound = false;      // my boolean if I have an end of a node
        boolean lapEnded = false;      // my boolean if my search goes in circles
        boolean startSearch = true;    // my boolean to indicate that I am at the start of my search

        int startingNode;
        int node = startNodeId;
        int indexNode = Integer.MIN_VALUE;   //because index 0 exists
        int oldIndex = Integer.MIN_VALUE;   //because index 0 exists

        while (!endFound && !lapEnded)  // as long as i haven't found the end node
        {                               // or that I did not do a full tour
            if (!startSearch && (node == startNodeId)) // if I am not at the start of my research
            {                                           // and that I find the same node,
                lapEnded = true;                        // is that I made a turn
                indexNode = oldIndex;
                break;
            }
            if(startSearch)             //research has started
            {
                startSearch = false;
            }

            if(fromIdsList.contains(node))
            {
                oldIndex = indexNode;
                indexNode = fromIdsList.indexOf(node);
                node = toIdsList.get(indexNode); //Line 3
            }
            else
            {
                endFound = true;
            }
        }
        return indexNode;
    }

    public static void main(String[] args) {
//        int startNodeId = 6;
//        int n = 4;
//
//        int[] fromIds = new int[] { 4, 9, 6, 1 };
//        int[] toIds = new int[] { 9, 5, 1, 4 };
//        System.out.println((startNodeId));
//        System.out.println(n);
//
//        for (int i = 0; i < n; i++)
//        {
//            System.out.println("from : " + fromIds[i] + " -> " + toIds[i]);
//        }
//
//        int endPointId = findNetworkEndpoint(startNodeId, fromIds, toIds);
//        System.out.println("End Point Node is : " + endPointId);

        HashMap<Long, Employee> employeeHashMap = new HashMap<>();
        employeeHashMap.put(1L,Employee.builder().name("A").age(19).salary(1000.0).build());
        employeeHashMap.put(2L,Employee.builder().name("B").age(20).salary(700.0).build());
        employeeHashMap.put(3L,Employee.builder().name("C").age(19).salary(500.0).build());
        List<Map.Entry<Long, Employee>> entryList = new ArrayList<>(employeeHashMap.entrySet());
        Comparator<Map.Entry<Long, Employee>> compareByAge = Comparator.comparing(p -> p.getValue().getAge());
        Comparator<Map.Entry<Long, Employee>> compareByName = Comparator.comparing( p -> p.getValue().getName() );
        Comparator<Map.Entry<Long, Employee>> compareByFullName = compareByAge.thenComparing(compareByName);
        Collections.sort(entryList, compareByFullName);
        entryList.forEach(p-> System.out.println(p.getValue().getName()));
    }

}
@Getter
@Builder
class Employee {
    String name;
    int age;
    double salary;
}