/*
    Name: Sparsh Bohra

    *This is my own work and have not shared it with anyone*
*/

// Importing libraries
#include <iostream>
#include <limits.h>
#include <stdio.h>
#include <string>
#include <map>

#define V 24  // Number of vertexes in the graph
using namespace std;

// Function to get minimum value
int minDistance(int dist[], bool sptSet[]) {
    int min = INT_MAX, min_index;

    for (int v = 0; v < V; v++) {
        if (sptSet[v] == false && dist[v] <= min)
            min = dist[v], min_index = v;
    }

    return min_index;
}

// Function to print the shortest path
void printPath (int parent[], int j) {
    if (parent[j] == -1)
        return;

    printPath(parent, parent[j]);
    printf("%d ", j);
}

// Function to print the shortest distance
void printSolution (int dist[], int destination) {
    printf("%d", dist[destination]);
}

// Dijkstra algo to get shortest path
void dijkstra (int graph[V][V], int src, int destination) {
    int dist[V];
    bool sptSet[V];

    for (int i = 0; i < V; i++) {
        dist[i] = INT_MAX;
        sptSet[i] = false;
    }

    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, sptSet);
        sptSet[u] = true;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
        }
    }

    printSolution(dist, destination);
}

// Main driver function
int main() {

    // Statically store the graph as Adjaceny Matrix
    int graph[V][V] = { {0	,	0	,	18	,	16	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	6	,	0	,	0	,	0	,	0	,	0	,	0	,	6	,	0	,	0	,	0	,	5	,	0},
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

    // Mapping integers to corresponding string values
    // Numbers to places
    map<string, int> nameMap = {
        {"Ang Mo Kio", 0},
        {"Bedok", 1},
        {"Bukit Batok", 2},
        {"Bukit Panjang", 3},
        {"Bukit Timah", 4},
        {"Clementi", 5},
        {"Changi", 6},
        {"Choa Chu Kang", 7},
        {"Jurong", 8},
        {"Mandai", 9},
        {"Marina Bay", 10},
        {"Nee Soon", 11},
        {"Outram", 12},
        {"Pasir Panjang", 13},
        {"Punggol", 14},
        {"Queenstown", 15},
        {"Sembawang", 16},
        {"Sentosa", 17},
        {"Serangoon", 18},
        {"Tampines", 19},
        {"Toa Payoh", 20},
        {"Tuas", 21},
        {"Upper Thomson", 22},
        {"Woodlands", 23}
    };

    // Index of program
    printf("1. Represent the Adjacency Matrix\n");
    printf("2. Shortest route between cities\n");
    printf("3. Quit\n\n");

    printf("Enter the number: ");
    int choice;
    cin >> choice;

    // Index made using switch case
    switch (choice) {
        case 1:
            // Print adjaceny matrix
            for (int i=0; i<24; i++) {
                for (int j=0; j<24; j++) {
                    if (graph[i][j] == 0)
                        printf("-1 ");
                    else
                        printf("%d ", graph[i][j]);
                }
                printf("\n");
            }
            printf("\n");
            break;

        case 2: {
            // Input source and destination
            string start, destination;

            printf("\nStart from: ");
            cin >> start;
            auto it1 = nameMap.find(start);

            printf("To: ");
            cin >> destination;
            auto it2 = nameMap.find(destination);

            // Print shortest distance
            printf("Total Distance: ");
            dijkstra(graph, it1->second, it2->second);
            printf(" Km.\n");
            break;
        }

        case 3:
            // Terminate the program
            return 0;
    }
}