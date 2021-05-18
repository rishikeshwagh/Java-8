package com.java.programs;

import java.util.ArrayList;
import java.util.List;


public class SolutionNode {

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
        int startNodeId = 6;
        int n = 4;

        int[] fromIds = new int[]{4, 9, 6, 1};
        int[] toIds = new int[]{9, 5, 1, 4};
        System.out.println((startNodeId));
        System.out.println(n);

        for (int i = 0; i < n; i++) {
            System.out.println("from : " + fromIds[i] + " -> " + toIds[i]);
        }

        int endPointId = findNetworkEndpoint(startNodeId, fromIds, toIds);
        System.out.println("End Point Node is : " + endPointId);
    }
}
