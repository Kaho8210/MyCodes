import java.util.Arrays;

public class Graph{

	double[][] adjMatrix;
	int numOfvertices;
	
	public Graph(int v)//double[][] mat, 
	{
		
		this.numOfvertices = v;
		this.adjMatrix =new double[numOfvertices][numOfvertices];
		

	}
	
	public void addEdge(int src, int dest, double edgeWeight)
	{
		adjMatrix[src][dest] = edgeWeight;    //ex. when 5 and 2 are connected,
		adjMatrix[dest][src] = edgeWeight;    //    2,5 and 5,2 are same.
	}


    public static double getClosestVertex(double[] distance, boolean[] visited){ //find the closest unvisited node. 
	double min = Double.MAX_VALUE;
	int minIdx = -1;
	for(int i=0; i<distance.length; i++)
	{
		if((distance[i] < min) && (visited[i] == false)){           //if distance[] is smalller than "min" and if it's not visited yet
				min = distance[i];
				minIdx = i;
			}
	}
	return minIdx;
}    
	public double[] dijkstrasShortestPath(int src){
		double[] distance = new double[this.numOfvertices];      //final shortest distance array
		boolean[] visited = new boolean[this.numOfvertices];   //array to tell whether shortest distance of vertex has been found
		
		//initializing the arrays
		for(int i=0; i<this.numOfvertices; i++){
			distance[i] = Integer.MAX_VALUE;	//initial distance is infinite
			visited[i] = false;						//shortest distance for any node has not been found yet
		}
		distance[src] = 0;
		
		for(int i=0; i<this.numOfvertices; i++){
			double closestVertex = getClosestVertex(distance, visited);//get the closest node
			//if closest node is infinite distance away, it means that no other node can be reached. So 
        	//return
			
			if(closestVertex == Double.MAX_VALUE){
				return distance;
			}
			
			visited[(int)closestVertex] = true;
			for(int j=0; j<this.numOfvertices; j++){
				if(visited[j] == false){//shortest distance of the node j should not have been finalized
				
					if(this.adjMatrix[(int)closestVertex][j] != 0){
						double d = distance[(int)closestVertex] + this.adjMatrix[(int)closestVertex][j];
						if(d < distance[j])//distance via closestVertex is less than the initial distance
						distance[j] = d;
					}
				}		
			}
		}
		return distance;
	}

	public void display(){
		for (double[] x : adjMatrix)
		{
		for (double y : x)
		{
			System.out.printf("%.2f\t", y);				
		}
		System.out.println();
		}
	}
	
}

                                   









