/*
    Name: Sparsh Bohra
    26/02/2021

    *This is my own work and have not shared it with anyone*
*/

// Importing libraries
import java.util.Scanner;
import java.util.*;

// Main class
class JAVA_Dijkstra {

    // Global Variable
    private static final int NO_PARENT = -1;

    // Function for disjkstra's algorithm
    private static void dijkstra (int[][] adjacencyMatrix, int startVertex, int endVertex) {
        int nVertices = adjacencyMatrix[0].length;
        int[] shortestDistances = new int[nVertices];
        boolean[] added = new boolean[nVertices];

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[startVertex] = 0;

        int[] parents = new int[nVertices];
        parents[startVertex] = NO_PARENT;

        for (int i = 1; i < nVertices; i++) {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;

            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        // Printing the solution
        printSolution(shortestDistances, endVertex, parents);
    }

    // Printing the final result - path and distance
    private static void printSolution (int[] distances, int endVertex, int[] parents) {
        // Print shortest path taken
        System.out.printf("Path:");
        printPath(endVertex, parents);

        // Print shortest distance
        System.out.printf("\nTotal Distance: ");
        System.out.print(distances[endVertex]);
        System.out.printf(" Km.\n");
    }

    // Function to get the path recursively
    private static void printPath (int currentVertex, int[] parents) {

        //Hash Map for cities
        Map<Integer, String> nameMap = new HashMap<Integer, String>();
            nameMap.put(0, "Ang Mo Kio");
            nameMap.put(1, "Bedok");
            nameMap.put(2, "Bukit Batok");
            nameMap.put(3, "Bukit Panjang");
            nameMap.put(4, "Bukit Timah");
            nameMap.put(5, "Clementi");
            nameMap.put(6, "Changi");
            nameMap.put(7, "Choa Chu Kang");
            nameMap.put(8, "Jurong");
            nameMap.put(9, "Mandai");
            nameMap.put(10, "Marina Bay");
            nameMap.put(11, "Nee Soon");
            nameMap.put(12, "Outram");
            nameMap.put(13, "Pasir Panjang");
            nameMap.put(14, "Punggol");
            nameMap.put(15, "Queenstown");
            nameMap.put(16, "Sembawang");
            nameMap.put(17, "Sentosa");
            nameMap.put(18, "Serangoon");
            nameMap.put(19, "Tampines");
            nameMap.put(20, "Toa Payoh");
            nameMap.put(21, "Tuas");
            nameMap.put(22, "Upper Thomson");
            nameMap.put(23, "Woodlands");

        if (currentVertex == NO_PARENT) {
            return;
        }

        String vertex = nameMap.get(currentVertex);

        printPath(parents[currentVertex], parents);
        System.out.print(" -> " + vertex);
    }

    // Main driver function
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);

        // Adjacency Matrix
        int[][] adjacencyMatrix = { {0	,	0	,	18	,	16	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	6	,	0	,	0	,	0	,	0	,	0	,	0	,	6	,	0	,	0	,	0	,	5	,	0},
                                    {0	,	0	,	0	,	0	,	22	,	0	,	0	,	0	,	0	,	0	,	16	,	0	,	16	,	0	,	0	,	0	,	0	,	0	,	0	,	5	,	13	,	0	,	16	,	0},
                                    {18	,	0	,	0	,	7	,	5	,	7	,	0	,	6	,	19	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	16	,	0	,	0},
                                    {16	,	0	,	7	,	0	,	6	,	0	,	0	,	4	,	0	,	15	,	0	,	16	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	14	,	11},
                                    {0	,	22	,	5	,	6	,	0	,	5	,	0	,	0	,	25	,	0	,	0	,	0	,	0	,	0	,	0	,	9	,	0	,	0	,	0	,	0	,	10	,	0	,	11	,	0},
                                    {0	,	0	,	7	,	0	,	5	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	7	,	0	,	5	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0},
                                    {0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	16	,	5	,	18	,	0	,	0	,	0},
                                    {0	,	0	,	6	,	4	,	0	,	0	,	0	,	0	,	22	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	15	,	0	,	11},
                                    {0	,	0	,	19	,	0	,	25	,	0	,	0	,	22	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	19	,	0	,	0},
                                    {0	,	0	,	0	,	15	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	3	,	0	,	0	,	0	,	0	,	6	,	0	,	0	,	0	,	0	,	0	,	0	,	8},
                                    {0	,	16	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	2	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	10	,	0	,	0	,	0},
                                    {6	,	0	,	0	,	16	,	0	,	0	,	0	,	0	,	0	,	3	,	0	,	0	,	0	,	0	,	0	,	0	,	5	,	0	,	0	,	0	,	0	,	0	,	0	,	9},
                                    {0	,	16	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	2	,	0	,	0	,	0	,	0	,	5	,	0	,	6	,	0	,	0	,	8	,	0	,	0	,	0},
                                    {0	,	0	,	0	,	0	,	0	,	7	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	6	,	0	,	8	,	0	,	0	,	0	,	0	,	0	,	0},
                                    {0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	8	,	0	,	0	,	0	,	0	,	0},
                                    {0	,	0	,	0	,	0	,	9	,	5	,	0	,	0	,	0	,	0	,	0	,	0	,	5	,	6	,	0	,	0	,	0	,	10	,	0	,	0	,	9	,	0	,	10	,	0},
                                    {0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	6	,	0	,	5	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	5},
                                    {0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	6	,	8	,	0	,	10	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0},
                                    {6	,	0	,	0	,	0	,	0	,	0	,	16	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	8	,	0	,	0	,	0	,	0	,	12	,	6	,	0	,	8	,	0},
                                    {0	,	5	,	0	,	0	,	0	,	0	,	5	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	12	,	0	,	15	,	0	,	0	,	0},
                                    {0	,	13	,	0	,	0	,	10	,	0	,	18	,	0	,	0	,	0	,	10	,	0	,	8	,	0	,	0	,	9	,	0	,	0	,	6	,	15	,	0	,	0	,	6	,	0},
                                    {0	,	0	,	16	,	0	,	0	,	0	,	0	,	15	,	19	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0},
                                    {5	,	16	,	0	,	14	,	11	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	10	,	0	,	0	,	8	,	0	,	6	,	0	,	0	,	0},
                                    {0	,	0	,	0	,	11	,	0	,	0	,	0	,	11	,	0	,	8	,	0	,	9	,	0	,	0	,	0	,	0	,	5	,	0	,	0	,	0	,	0	,	0	,	0	,	0}
                                };

        // Hashmap for cities
        Map<String, Integer> nameMap = new HashMap<String, Integer>();
            nameMap.put("Ang Mo Kio", 0);
            nameMap.put("Bedok", 1);
            nameMap.put("Bukit Batok", 2);
            nameMap.put("Bukit Panjang", 3);
            nameMap.put("Bukit Timah", 4);
            nameMap.put("Clementi", 5);
            nameMap.put("Changi", 6);
            nameMap.put("Choa Chu Kang", 7);
            nameMap.put("Jurong", 8);
            nameMap.put("Mandai", 9);
            nameMap.put("Marina Bay", 10);
            nameMap.put("Nee Soon", 11);
            nameMap.put("Outram", 12);
            nameMap.put("Pasir Panjang", 13);
            nameMap.put("Punggol", 14);
            nameMap.put("Queenstown", 15);
            nameMap.put("Sembawang", 16);
            nameMap.put("Sentosa", 17);
            nameMap.put("Serangoon", 18);
            nameMap.put("Tampines", 19);
            nameMap.put("Toa Payoh", 20);
            nameMap.put("Tuas", 21);
            nameMap.put("Upper Thomson", 22);
            nameMap.put("Woodlands", 23);

        // Index of program
        System.out.printf("1. Represent the Adjacency Matrix\n");
        System.out.printf("2. Shortest route between cities\n");
        System.out.printf("3. Quit\n\n");

        System.out.printf("Enter the number: ");
        int choice = input.nextInt();
        System.out.println();

        input.nextLine();
        // Index made using switch case
        switch (choice) {
            case 1:
                // Print adjaceny matrix
                for (int i=0; i<24; i++) {
                    for (int j=0; j<24; j++) {
                        if (adjacencyMatrix[i][j] == 0)
                            System.out.printf("-1 ");
                        else
                            System.out.printf("%d ", adjacencyMatrix[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
                break;

            case 2:
                // Input source and destination
                String start, destination;

                System.out.printf("Start from: ");
                start = input.nextLine();
                Integer startInt = nameMap.get(start);

                System.out.printf("To: ");
                destination = input.nextLine();
                Integer destinationInt = nameMap.get(destination);

                dijkstra(adjacencyMatrix, startInt, destinationInt);
                break;

            case 3:
                // Terminate the program
                System.exit(0);
        }
    }
}