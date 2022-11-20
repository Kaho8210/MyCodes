import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class point {
    private int x;
    private int y;
    int n;
    private int m;
    private int p;
    private int q;

    private int i = 0;
    private int j = 0;
    private int o = 0;
    private int array[][];
    private int line[][];
    private List<double[]> output_input; //this is only to read the intersections
    private double output[][];
    private int cntInter=0;//count number of intersection
    private int totalVer=0;
    private int ver=0;    //used for slope[] array. ver=totalVer-1

    private String location[][];

    private int a;
    private double s;
    private double t;

    private int p1x;
    private int p1y;

    private int q1x;
    private int q1y;

    private int p2x;
    private int p2y;

    private int q2x;
    private int q2y;
    
    private int selected_lines[];
    private List<int[]> inter_lines; //point intersected with which lines: [0] intersection point id [1] line 1 [2] line 2
    private Graph g;

    private double xs_place = 0.0;
    private double ys_place = 0.0;
    private double xd_place = 0.0;
    private double yd_place = 0.0;

    private int P1[][];
    private int Q1[][];
    private int P2[][];
    private int Q2[][];

    private int b=0; 
    private int c=0;
    private int k=0;
    private int l=0;   
    
    public int getN(){
        return this.n;
    }

    public point(int n, int m, int p, int q) {

        this.n = n;
        this.m = m;
        this.p = p;
        this.q = q;
        this.array = new int[this.n][2];
        this.line = new int[this.m][2];
       
        this.output_input=new ArrayList<double[]>(); //just used to input the intersections
        this.inter_lines=new ArrayList<int[]>();
        this.P1 = new int[line.length][2];
        this.Q1 = new int[line.length][2];
        this.P2 = new int[line.length][2];
        this.Q2 = new int[line.length][2];

        this.selected_lines=new int[2];

       // System.out.println("Array Size: " + array.length);
       // System.out.println("Line Size: " + line.length);

    }

    public point() {
    }

    public void setPoint(int x, int y) {
        this.array[this.i][0] = x;
        this.array[this.i][1] = y;
        this.i++;
    }

    public void setLine(int p, int q) {
        this.line[this.j][0] = p-1;
        this.line[this.j][1] = q-1;
        this.j++;
    }

    public void display() {

        for (int i = 0; i < this.array.length; i++) {

           // System.out.println(this.array[i][0] + "," + this.array[i][1]);

        }

        for (int i = 0; i < this.line.length; i++) {

           // System.out.println(this.line[i][0] + "," + this.line[i][1]);

        }
    }

    public double Distance(double x1,double x2,double y1, double y2){  //calculate distance between two nodes
        return Math.sqrt(((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
    }


    public void getDerminent() {
        this.p1x = 0;
        this.p1y = 0;
        this.q1x = 0;
        this.q1y = 0;


        for (int i = 0; i < line.length; i++) {

            int p1 = line[i][0];
            int q1 = line[i][1];

            for (int j = (i + 1); j < line.length; j++) {

                int p2 = line[j][0];
                int q2 = line[j][1];

                selected_lines=new int[]{i,j};

                this.p1x = this.array[p1][0];
                this.p1y = this.array[p1][1];

                this.q1x = this.array[q1][0];
                this.q1y = this.array[q1][1];

                this.p2x = this.array[p2][0];
                this.p2y = this.array[p2][1];

                this.q2x = this.array[q2][0];
                this.q2y = this.array[q2][1];

                this.a = (q1x - p1x) * (p2y - q2y) + (q2x - p2x) * (q1y - p1y);


                if (a == 0) {

                } else if (a != 0) {
                    
                    getIntersection();

                }
            }

        }

    }

    public void getIntersection() { /* calculate (6) */

        this.s = ((this.p2y - this.q2y) * (this.p2x - this.p1x) + (this.q2x - this.p2x) * (this.p2y - this.p1y));
        this.s = this.s / this.a;

        this.t = ((this.p1y - this.q1y) * (this.p2x - this.p1x) + (this.q1x - this.p1x) * (this.p2y - this.p1y));
        this.t = this.t / this.a;

        // System.out.println("s->"+this.s+"t->"+this.t);
        if ((this.s > 0 && this.s < 1) && (this.t > 0 && this.t < 1)) {
            cntInter++;      //when a intersection exists, the pointes are connected
            //System.out.println("Connected pointes coordinate->"+"\t"+"p1x->"+p1x+"\t"+"p1y->"+p1y+"\t"+"q1x->"+q1x+"\t"+"q1y->"+q1y+"\t"+"p2x->"+p2x+"\t"+"p2y->"+p2y+"\t"+"q2x->"+q2x+"\t"+"q2y->"+q2y+"\t");
            calculateXY();
           
            //System.out.println("Number of Intersection-->"+cntInter+"\t");
        } 
        else {
           // System.out.println("NA");
        }
    }

    public int getTotalNumofVertex(){ //make method to be applied to Graph(int[][] mat, int v)//
        double Distance=0;

    
        Dist dist= new Dist(this.line.length,this.p1x,this.p1y,this.q1x,this.q1y);
       
        Distance= dist.Distance();
        this.totalVer=this.cntInter+this.n;
       // System.out.println("totalNum->"+this.totalVer);

        Graph graph = new Graph();//mat

        for(int i = 0;i<this.totalVer;i++){
            for(int j=0;j<this.totalVer;j++){
                graph.addEdge(Integer.toString(i), Integer.toString(j), Distance);
            }
        }
        return this.totalVer;
    }
    


    public void calculateXY() {//calculate the coordinate of intersection
        double x, y = 0;
        // this.output = new [this.cntInter][2];
        x = this.p1x + (this.q1x - this.p1x) * this.s; // (1)     (p1x,p1y) and (q1x,q1y) are connected. then, output[x,y] is in the middle
        y = this.p1y + (this.q1y - this.p1y) * this.s; // (2)

        x = Math.round(x * Math.pow(10, 5)) / Math.pow(10, 5);
        y = Math.round(y * Math.pow(10, 5)) / Math.pow(10, 5);
        // FindSegment(p1x, p1y, q1x, q1y, x, y);                
        inter_lines.add(new int[]{this.o,this.selected_lines[0],this.selected_lines[1]});//[0]: id ,[1]: 1st line,[2]: 2nd line
        this.output_input.add(new double[]{this.o,x,y}); //[0]: id of intersection point,[1]: x,[2]: y 
        this.o++;
    }

    public void MakeGraph(){
        g=new Graph();          
        for (int[] iter : line) {             //points. For all the line[0]= first segment line[1]= second segment, iterate
            double dist=Distance(array[iter[0]][0], array[iter[1]][0], array[iter[0]][1], array[iter[1]][1]);//calculate the distance between 2 selected lines
            g.addEdge( Integer.toString(iter[0]),  Integer.toString(iter[1]), dist);
            g.addEdge( Integer.toString(iter[1]),  Integer.toString(iter[0]), dist);
        }
        int index=0;
        for (double[] iter : output_input) {//intersection . output_input has all the sorted intersection
            for (int i_line = 1; i_line < 3; i_line++) {//intersection points (considering id, starts from 1)
                for (int p_in_line = 0; p_in_line < 2; p_in_line++) {//points on line
                    double dist=Distance(array[line[inter_lines.get((int)iter[0])[i_line]][p_in_line]][0], iter[1], array[line[inter_lines.get((int)iter[0])[i_line]][p_in_line]][1], iter[2]);  //iter 0, iter 1= lines making intersection                  
                    g.addEdge( Integer.toString(line[inter_lines.get((int)iter[0])[i_line]][p_in_line]),  Integer.toString(array.length+index), dist);
                    g.addEdge( Integer.toString(array.length+index),  Integer.toString(line[inter_lines.get((int)iter[0])[i_line]][p_in_line]), dist); 
                }                
            }
            index++;
        }
        //if there are multiple intersection points on one segment, connect(add edge)them (weight= distance)
        //use line_id and intersection_id. if intersection_id shares same line_id, calculate the distance 
        for(int[] iter : inter_lines){      //search all the values in inter_lines (lines of intersection) (originarry, intersection_id has same id as line_id )
            for(int[] iter2: inter_lines){ 
                if(iter[0]!=iter2[0]){//if it doesn't share id, continue searching.
                    if(iter[1]==iter2[1] || iter[2]==iter2[1] || iter[2]==iter2[2] || iter[1]==iter2[2]){// if 2 lines are the same
                        int i1,i2; //index in the ordered list
                        for(i1=0;i1<output_input.size();i1++) if(output_input.get(i1)[0]==iter[0]) break;
                        for(i2=0;i2<output_input.size();i2++) if(output_input.get(i2)[0]==iter2[0]) break;
                        double dist=Distance(output[iter[0]][1],output[iter2[0]][1],output[iter[0]][2],output[iter2[0]][2]);   //x1,x2,y1,y2
                        g.addEdge( Integer.toString(array.length+i1),  Integer.toString(array.length+i2), dist);                      
                    }
                }
            }
        }
        //
        //g.displayAdj();        
    }

    //sort according to the asscending order of distence 
    public void sort() {
        output=output_input.toArray(new double[output_input.size()][3]); //convert the list to a normal array
        output_input.sort((o1,o2)->o1[1]<o2[1] && o1[1]!=o2[1]?1:(o1[1]==o2[1]?(o1[2]<o2[2]?1:0):0));
    }
    
    public void setLocation(String s, String d, int k) {        
        int s_int = 0;
        int d_int = 0;
        String s_intValue;
        String d_intValue;
        int src=0;
        int dst=0;

        // int[][] location = new int[this.q][3];

        if(s.charAt(0)=='C'){//if s's 0th index is "C"
            String tmp=new String();
            for (int index=1;index<s.length();index++) tmp+=s.charAt(index); //tmp = String of integer part            
            src=array.length+Integer.parseInt(tmp)-1;   //  convert String to integer            
            if(src>=array.length+output.length){  //if src size is OutOfBounds
                System.out.println("NA");                
                return;
            }
        }else{            
            src=Integer.parseInt(s)-1; // if src size is OK, convert String to integer and store the value
        }

        if(d.charAt(0)=='C'){
            String tmp=new String();
            for (int index=1;index<d.length();index++) tmp+=d.charAt(index);  //same to "s"
            dst=array.length+Integer.parseInt(tmp)-1;
            if(dst>=array.length+output.length){
                System.out.println("NA");                
                return;
            }
        }else{
            dst=Integer.parseInt(d)-1;
        }
        
        System.out.println("Computing the " + k + " shortest paths from [" + s + "] to [" + d + "] ");
        yen(Integer.toString(src),Integer.toString(dst),k);
               
    }

    public  void yen(String source, String target, int k) {
        /* Read graph from file 
        System.out.print("Reading data from file... ");
        Graph graph = new Graph(graphFilename);
        System.out.println("complete.");*/

        /* Compute the K shortest paths and record the completion time */
       
        System.out.println("using Yen's algorithm. ");
        List<Path> ksp;
        //long timeStart = System.currentTimeMillis();
        Yen yenAlgorithm = new Yen();
        ksp = yenAlgorithm.ksp(g, source, target, k);
        //long timeFinish = System.currentTimeMillis();
        //System.out.println("complete.");

        //System.out.println("Operation took " + (timeFinish - timeStart) / 1000.0 + " seconds.");

        /* Output the K shortest paths */
        //System.out.println("k) cost: [path]");
        int value;
        for (Path p : ksp) {
            int numEdges = p.size();
            System.out.println("Distance:"+p.getTotalCost());
            if (numEdges > 0) {
                for (int i = 0; i < p.size(); i++) {
                    value = Integer.parseInt(p.getEdges().get(i).getFromNode());
                    if(value<n ){

                        System.out.print(value+1);

                    }
                    else{
                        int idValue = value - n + 1;
                        System.out.print("C"+idValue);
                    }
                    
                    System.out.print("-");
                }

                int value2 = Integer.parseInt(p.getEdges().getLast().getToNode());
                if(value2<n ){

                    System.out.print(value2+1);

                }
                else{
                    int idValue = value2 - n +1 ;
                    System.out.print("C"+idValue);
                }

                System.out.println();
                
            }
        }
    }
}
