public class Main {

    private int[][] adjMatrix;

    private int numVertices;

    public Main(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i , int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i , int j){
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public void addVertice(){
        int[][] newadjMatix = new int[numVertices+1][numVertices+1];

        for(int i=0;i<numVertices;i++){
            for(int j=0;j<numVertices;j++){
                newadjMatix[i][j] = adjMatrix[i][j];
            }
        }

        adjMatrix = newadjMatix;
        numVertices++;
    }

    public void deleteVertice(int vertice){
        int[][] newAdjMatix = new int[numVertices-1][numVertices-1];

        for (int i = 0, newRow = 0; i < numVertices; i++) {
            if (i == vertice) continue;
            for (int j = 0, newCol = 0; j < numVertices; j++) {
                if (j == vertice) continue;
                newAdjMatix[newRow][newCol] = adjMatrix[i][j];
                newCol++;
            }
            newRow++;
        }

        adjMatrix = newAdjMatix;
        numVertices--;
    }

    public void printGraph(){
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        Main graph = new Main(5);

        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(1,3);
        graph.addEdge(2,4);

        graph.addVertice();
        graph.printGraph();
        graph.deleteVertice(3);
        graph.printGraph();
    }
}