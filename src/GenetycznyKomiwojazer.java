/**
 * Created by marcin on 23.01.16.
 */
public class GenetycznyKomiwojazer {
}

/*
#include<cstdlib>
#include<iostream>
#include<fstream>
#include<math.h>
        #define M 20
        #define PI 20

        using namespace std;

        void permut(char a[],char N){ //losowanie permutacji początkowej
        if(N<=1)
        return;
        char tmp=rand()%N;
        char bla=a[N-1];
        a[N-1]=a[tmp];
        a[tmp]=bla;
        permut(a,N-1);
        }

        void op(double odl[M][M],double city[M][2]){ //otwieranie pliku z miastami
        fstream bla;
        bla.open("miasta.dat");
        if(bla.is_open()){
//        char tmp;
        double a,b;
        for(int i=0;i<M;i++){
        bla>>city[i][0]>>city[i][1];
        }
        bla.close();
        }
        for(int i=0;i<M;i++)
        for(int j=0;j<M;j++)
        odl[i][j]=sqrt((city[i][0]-city[j][0])*(city[i][0]-city[j][0])+(city[i][1]-city[j][1])*(city[i][1]-city[j][1]));

        }

        double odleg(char a[],double odl[M][M]){ //liczenie długości trasy
        double bla=odl[a[0]][a[M-1]];
        for(int i=1;i<M;i++)
        bla+=odl[a[i]][a[i-1]];
        return bla;
        }

        void sort(char a[][M],double odleg[],int il){ //sortowanie populacji
        int bla;
        double tmp;
        char temp;
        for(int i=0;i<il;i++){
        bla=i;
        for(int j=i+1;j<il;j++)
        if(odleg[j]<odleg[bla])
        bla=j;
        if(bla!=i){
        tmp=odleg[bla];
        odleg[bla]=odleg[i];
        odleg[i]=tmp;
        for(int j=0;j<M;j++){
        temp=a[bla][j];
        a[bla][j]=a[i][j];
        a[i][j]=temp;
        }
        }
        }
        }

        bool check(char a[][M],int n){ //sprawdza czy przeprowadzić przymusową mutacje
        int b;
        for(int i=0;i<n;i++){
        b=1;
        for(int j=0;j<M;j++)
        if(a[i][j]!=a[n][j])
        b=0;
        if(b)
        return true;
        }
        return false;
        }

        void mutuj(char pop[]){ //mutacje
        int a=rand()%M;
        int b;
        do{
        b=rand()%M;
        }while(b==a);
        char tmp=pop[a];
        pop[a]=pop[b];
        pop[b]=tmp;
        }

        void krzyz(char pop1[],char pop2[]){// krzyżowanie populacji
        int a,b;
        b=rand()%M;
        char tmp;
        do{
        a=b;
        tmp=pop2[a];
        pop2[a]=pop1[a];
        pop1[a]=tmp;
        b=-1;
        for(int i=0;i<M;i++)
        if(pop1[i]==tmp&&i!=a)
        b=i;
        }while(b>=0);
        }

        void copy(char pop1[],char pop2[]){ //kopiowanie osobnika (funkcja pomocnicza)
        for(int i=0;i<M;i++){
        pop1[i]=pop2[i];
        }
        }

        void rysuj_trase(char pop[],double city[][2],const char*path){ //zapisanie trasy do pliku
        ofstream rys;
        rys.open(path);
        if(rys.is_open()){
        for(int i=0;i<M;i++)
        rys<<city[pop[i]][0]<<" "<<city[pop[i]][1]<<endl;
        rys<<city[pop[0]][0]<<" "<<city[pop[0]][1]<<endl;
        rys.close();
        }

        }

        void zad1(int ilosc){
static bool rys_krzyz=true;
        ofstream zad1;
        zad1.open("zad1");
        double odl[M][M];
        double city[M][2];
        char popul[ilosc][M];
        double dyst[ilosc];
        op(odl,city);
        //losowanie populacji
        for(int i=0;i<ilosc;i++)
        for(int j=0;j<M;j++)
        popul[i][j]=j;
        for(int i=0;i<ilosc;i++){
        permut(popul[i],M);
        while(check(popul,i))
        mutuj(popul[i]);
        dyst[i]=odleg(popul[i],odl);
        }
        sort(popul,dyst,ilosc);
        //wypisanie trzech najkrótszych tras populacji startowej
        rysuj_trase(popul[0],city,"startowy_0");
        cout<<dyst[0]<<endl;
        rysuj_trase(popul[1],city,"startowy_1");
        cout<<dyst[1]<<endl;
        rysuj_trase(popul[2],city,"startowy_2");
        cout<<dyst[2]<<endl;

        for(int k=0;k<500;k++){ //pętla pokoleń
        for(int i=ilosc/2;i<ilosc;i+=2){
        copy(popul[i],popul[i-ilosc/2]); //kopiowanie rodziców
        copy(popul[i+1],popul[i+1-ilosc/2]); //to co wyżej
        krzyz(popul[i],popul[i+1]); //krzyzowanie rodziców
        if(rys_krzyz){ //zapisuwanie rodziców, i ich potomstwo do pliku// wykonywane tylko raz
        rysuj_trase(popul[i-ilosc/2],city,"rodzic_1");
        rysuj_trase(popul[i+1-ilosc/2],city,"rodzic_2");
        rysuj_trase(popul[i],city,"potomek_1");
        rysuj_trase(popul[i+1],city,"potomek_2");
        rys_krzyz=false;
        } // sprawdzenie czy nie powtarzają sie osobniki, jęsli tak wykonujemy mutacje
        while(check(popul,i))
        mutuj(popul[i]);
        while(check(popul,i+1))
        mutuj(popul[i+1]);
        }
        for(int i=ilosc/2;i<ilosc;i++)
        dyst[i]=odleg(popul[i],odl);
        sort(popul,dyst,ilosc); //sortowanie populacji
        for(int i=1;i<ilosc;i++){
        if((rand()%100)<20) // mutacje z prawdopodobieństwem wystąpienia
        mutuj(popul[i]);
        while(check(popul,i))
        mutuj(popul[i]);
        }
        for(int i=1;i<ilosc;i++)
        dyst[i]=odleg(popul[i],odl);
        sort(popul,dyst,ilosc); //sortowanie populacji
        //tutaj zapisywanie min w funkcji pokolenia
        if(zad1.is_open())
        zad1<<k<<" "<<dyst[0]<<endl;
        }
        if(zad1.is_open()){ //zapisywanie najkrótszej trasy do pliku
        zad1.close();
        rysuj_trase(popul[0],city,"najkrotsza");
        cout<<dyst[0]<<endl<<endl;;
        }
        }

        int main(int argc,char*argv[])
        {
        srand(time(NULL));
        zad1(96);
        return EXIT_SUCCESS;
        }
 */
