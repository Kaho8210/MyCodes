public class Dist{
    double x1; // x coordinate of p1
    double y1; // y coordinate of p1
    double x2; // x coordinate of q1
    double y2;  // y coordinate of q1
    int m;
    int i=0;
    double distance=0.0;
    double arr[];
    
    
    public Dist(int m,double x1,double y1,double x2,double y2){
        this.m=m;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        arr= new double[m];
    }

    public double Distance(){  //calculate distance between two nodes

        distance = ((this.x1-this.x2)*(this.x1-this.x2) + (this.y1-this.y2)*(this.y1-this.y2));
            //Math.sqrt(distance);
           this.arr[this.i]=Math.sqrt(distance); 
           //System.out.println("distance arr[i]-->"+ this.arr[this.i]);
           this.i++;

          // System.out.println("distance->"+ Math.sqrt(distance));

            return distance;
        }
       
    
    }
