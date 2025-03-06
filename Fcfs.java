import java.util.*;

public class Fcfs{
int p[][];


public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    Fcfs f=new Fcfs();
System.out.print("Enter  no. of processes");
int size=sc.nextInt();
f.p=new int[size][2];
for(int i=0;i<size;i++) {
int process=i+1;
    System.out.println("Enter arrivial time for process"+process);
f.p[i][0]=sc.nextInt();
System.out.println("Enter burst time for process"+(i+1));
f.p[i][1]=sc.nextInt();
}
}
    List<Integer> complete(int[] arr){
        List<Integer> ls=new ArrayList<>();
        int initialc=0;
        for(int i=0;i<arr.length;i++){
            initialc+=p[i][1];
            ls.add(initialc);
        }
        return ls;
    }
List<Integer>   wait(int arr[],List<Integer> ls){
    List<Integer> ls1=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int turn=ls.get(i)-p[i][1];
            int wait=turn-p[i][1];
            ls1.add(wait);
        }
        return ls1;
    }
List<Integer> turn(int arr[][],List<Integer> ls){
    List<Integer> ls2=new ArrayList<>();
    for(int i=0;i<arr.length;i++){
        ls2.add(ls.get(i)-arr[i][0]);
    }
    return ls2;
}
double avg(List<Integer> l){
    double average;
    int total=0;
    for(int i=0;i<l.size();i++){
        total+=l.get(i);
       
    }
    average=total/l.size();
    return average;
}
int max_wait(List<Integer> ls){
    int max=Integer.MIN_VALUE;
    for(int i=0;i<ls.size();i++){
        max=Math.max(max,ls.get(i));
    }
    return max;
}
}
