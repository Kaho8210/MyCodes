//Displays the smallest skipped value in the array which is grater than 0
#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 100000
using namespace std;

class Solution{
    private:
        int N;
    public:
    Solution(int N){
        this->N=N;
    }

    int solution(int A[]){
        int cnt=1;
        //printf("What is N-> ");
        //cout<<N<<endl;
        //printf("contents of A\n");
        for(int i=0; i<this->N;++i){
            //std::cout<<A[i]<<std::endl;
        }
        sort(A,A+N-1);
        for(int i=0; i<this->N;++i){
            if(A[i]==cnt){
                //printf("success\n");
            }
            else if(A[i]!=cnt){
                return cnt;
            }
            cnt++;
        }
        
        return cnt;
    }

    

};

int main(){
    int N;
    int A[MAX];
    int input;
    int ite=0;;
   

    printf("input num of int N\n");
        cin>>N;
        Solution sol(N);
       
    while(ite<N){
        printf("enter input");
        cin>>input;
        A[ite] = input; 
        printf("What's in A[ite]->");
        std::cout<<A[ite]<<std::endl;
        printf("\n");
        ite++;
    }
    
    std::cout<<"Min value->"<<sol.solution(A)<<std::endl;
    

    
}
