#include "prog03.h"
#include <stdio.h>

int input_planet(Planet *);

int input_planet(Planet *p){
FILE *fp;
int i;

//p[] = "planet.txt";

if((fp = fopen("planet.txt", "r"))==NULL){
    return -1;
}

else if((fp = fopen("planet.txt", "r"))!=NULL){
    for(i=0;i<NPLANETS;i++){
        //p = (Planet*) &fp;
        // p[i] =  "planet.txt";
        fscanf(fp, "%s %lf %lf %lf",p[i].name,&p[i].radius,&p[i].density,&p[i].orbital_radius);
    }
    return 0;
}


fclose(fp);
}
