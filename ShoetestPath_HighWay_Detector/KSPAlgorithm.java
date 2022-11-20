import java.util.List;

public interface KSPAlgorithm {
    public boolean isLoopless();

    public List<Path> ksp(Graph graph, String sourceLabel, String targetLabel, int K);
}
