import java.util.*;

class test {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        //Graph g = new Graph(N);

        point p = new point(N, M, P, Q);

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            p.setPoint(x, y);
        }

        for (int i = 0; i < M; i++) {
            int lp = sc.nextInt();
            int lq = sc.nextInt();
            p.setLine(lp, lq);
        }

        //p.ForDistance();
        p.display();

        p.getDerminent();
        p.getTotalNumofVertex();
        p.calculateXY();

        p.sort();
        p.MakeGraph();
        System.out.println("\t");
       // p.displayArray();

        // String s = sc.next();
        for (int i = 0; i < Q; i++) {
            
            p.setLocation(sc.next(), sc.next(), sc.nextInt());
        }
   
       

    }
}