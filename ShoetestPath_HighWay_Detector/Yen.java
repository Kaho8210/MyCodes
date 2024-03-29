import java.util.*;

public final class Yen implements KSPAlgorithm {

    public Yen() {};

    public boolean isLoopless() {
        return true;
    }

    /**
     * Computes the K shortest paths in a graph from node s to node t using Yen's algorithm
     *
     * @param graph         the graph on which to compute the K shortest paths from s to t
     * @param sourceLabel   the starting node for all of the paths
     * @param targetLabel   the ending node for all of the paths
     * @param K             the number of shortest paths to compute
     * @return              a list of the K shortest paths from s to t, ordered from shortest to longest
     */
    public List<Path> ksp(Graph graph, String sourceLabel, String targetLabel, int K) {
        // Initialize containers for candidate paths and k shortest paths
        ArrayList<Path> ksp = new ArrayList<Path>();
        PriorityQueue<Path> candidates = new PriorityQueue<Path>();

        try {
            /* Compute and add the shortest path */
            Path kthPath = Dijkstra.shortestPath(graph, sourceLabel, targetLabel);
            ksp.add(kthPath);

            /* Iteratively compute each of the k shortest paths */
            for (int k = 1; k < K; k++) {
                // Get the (k-1)st shortest path
                Path previousPath = ksp.get(k-1);

                /* Iterate over all of the nodes in the (k-1)st shortest path except for the target node; for each node,
                   (up to) one new candidate path is generated by temporarily modifying the graph and then running
                   Dijkstra's algorithm to find the shortest path between the node and the target in the modified
                   graph */
                for (int i = 0; i < previousPath.size(); i++) {
                    // Initialize a container to store the modified (removed) edges for this node/iteration
                    LinkedList<Edge> removedEdges = new LinkedList<Edge>();

                    // Spur node = currently visited node in the (k-1)st shortest path
                    String spurNode = previousPath.getEdges().get(i).getFromNode();

                    // Root path = prefix portion of the (k-1)st path up to the spur node
                    Path rootPath = previousPath.cloneTo(i);

                    /* Iterate over all of the (k-1) shortest paths */
                    for(Path p:ksp) {
                        Path stub = p.cloneTo(i);
                        // Check to see if this path has the same prefix/root as the (k-1)st shortest path
                        if (rootPath.equals(stub)) {
                            /* If so, eliminate the next edge in the path from the graph (later on, this forces the spur
                               node to connect the root path with an un-found suffix path) */
                            Edge re = p.getEdges().get(i);
                            graph.removeEdge(re.getFromNode(),re.getToNode());
                            removedEdges.add(re);
                        }
                    }

                    /* Temporarily remove all of the nodes in the root path, other than the spur node, from the graph */
                    for(Edge rootPathEdge : rootPath.getEdges()) {
                        String rn = rootPathEdge.getFromNode();
                        if (!rn.equals(spurNode)) {
                            removedEdges.addAll(graph.removeNode(rn));
                        }
                    }

                    // Spur path = shortest path from spur node to target node in the reduced graph
                    Path spurPath = Dijkstra.shortestPath(graph, spurNode, targetLabel);

                    // If a new spur path was identified...
                    if (spurPath != null) {
                        // Concatenate the root and spur paths to form the new candidate path
                        Path totalPath = rootPath.clone();
                        totalPath.addPath(spurPath);

                        // If candidate path has not been generated previously, add it
                        if (!candidates.contains(totalPath))
                            candidates.add(totalPath);
                    }

                    // Restore all of the edges that were removed during this iteration
                    graph.addEdges(removedEdges);
                }

                /* Identify the candidate path with the shortest cost */
                boolean isNewPath;
                do {
                    kthPath = candidates.poll();
                    isNewPath = true;
                    if (kthPath != null) {
                        for (Path p : ksp) {
                            // Check to see if this candidate path duplicates a previously found path
                            if (p.equals(kthPath)) {
                                isNewPath = false;
                                break;
                            }
                        }
                    }
                } while(!isNewPath);

                // If there were not any more candidates, stop
                if (kthPath == null)
                    break;

                // Add the best, non-duplicate candidate identified as the k shortest path
                ksp.add(kthPath);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        // Return the set of k shortest paths
        return ksp;
    }

    /**
     * An in-progress alternative implementation of Yen's algorithm.
     *
     * @param graph         the graph on which to compute the K shortest paths from s to t
     * @param sourceLabel   the starting node for all of the paths
     * @param targetLabel   the ending node for all of the paths
     * @param K             the number of shortest paths to compute
     * @return              a list of the K shortest paths from s to t, ordered from shortest to longest
     */
    public static  List<Path> ksp_v2(Graph graph, String sourceLabel, String targetLabel, int K) {
        // Initialize containers for candidate paths and k shortest paths
        ArrayList<Path> ksp = new ArrayList<Path>();
        PriorityQueue<Path> candidates = new PriorityQueue<Path>();

        try {
            /* Compute and add the shortest path */
            Path kthPath = Dijkstra.shortestPath(graph, sourceLabel, targetLabel);
            ksp.add(kthPath);

            /* Iteratively compute each of the k shortest paths */
            for (int k = 1; k < K; k++) {
                // Get the (k-1)st shortest path
                Path previousPath = ksp.get(k-1);

                /* Iterate over all of the nodes in the (k-1)st shortest path except for the target node; for each node,
                   (up to) one new candidate path is generated by temporarily modifying the graph and then running
                   Dijkstra's algorithm to find the shortest path between the node and the target in the modified
                   graph */
                LinkedList<Edge> rootPathEdges = new LinkedList<Edge>();
                Iterator<Edge> it = previousPath.getEdges().iterator();
                for (int i = 0; i < previousPath.size(); i++) {
                    if (i > 0) {
                        rootPathEdges.add(it.next());
                    }

                    // Initialize container to store the edited (removed) edges
                    LinkedList<Edge> removedEdges = new LinkedList<Edge>();

                    // Spur node = currently visited node in the (k-1)st shortest path
                    String spurNode = previousPath.getEdges().get(i).getFromNode();

                    // Root path = prefix portion of the (k-1)st path up to the spur node
                    // REFACTOR THIS
                    Path rootPath = previousPath.cloneTo(i);

                    /* Iterate over all of the (k-1) shortest paths */
                    for(Path p:ksp) {
                        int pSize = p.size();
                        if (pSize < i)
                            continue;
                        boolean rootMatch = true;
                        for (int rootPos = 0; rootPos < i; rootPos++) {
                            if (!p.getEdges().get(rootPos).equals(rootPathEdges.get(rootPos))) {
                                rootMatch = false;
                                break;
                            }
                        }
                        // Check to see if this path has the same prefix/root as the (k-1)st shortest path
                        if (rootMatch) {
                            /* If so, eliminate the next edge in the path from the graph (later on, this forces the spur
                               node to connect the root path with an un-found suffix path) */
                            Edge re = p.getEdges().get(i);
                            graph.removeEdge(re.getFromNode(),re.getToNode());
                            removedEdges.add(re);
                        }
                    }

                    /* Temporarily remove all of the nodes in the root path, other than the spur node, from the graph */
                    for(Edge rootPathEdge : rootPathEdges) {
                        String rn = rootPathEdge.getFromNode();
                        if (!rn.equals(spurNode)) {
                            removedEdges.addAll(graph.removeNode(rn));
                        }
                    }

                    // Spur path = shortest path from spur node to target node in the reduced graph
                    Path spurPath = Dijkstra.shortestPath(graph, spurNode, targetLabel);

                    // If a new spur path was identified...
                    if (spurPath != null) {
                        // Concatenate the root and spur paths to form the new candidate path
                        // REFACTOR THIS?
                        Path totalPath = rootPath.clone();
                        //Path totalPath2 = new Path(rootPathEdges);
                        totalPath.addPath(spurPath);

                        // If candidate path has not been generated previously, add it
                        //if (!candidates.contains(totalPath))
                        candidates.add(totalPath);
                    }

                    // Restore removed edges
                    graph.addEdges(removedEdges);
                }

                /* Identify the candidate path with the shortest cost */
                boolean isNewPath;
                do {
                    kthPath = candidates.poll();
                    isNewPath = true;
                    if (kthPath != null) {
                        for (Path p : ksp) {
                            // Check to see if this candidate path duplicates a previously found path
                            if (p.equals(kthPath)) {
                                isNewPath = false;
                                break;
                            }
                        }
                    }
                } while(!isNewPath);

                // If there were not any more candidates, stop
                if (kthPath == null)
                    break;

                // Add the best, non-duplicate candidate identified as the k shortest path
                ksp.add(kthPath);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        // Return the set of k shortest paths
        return ksp;
    }
}