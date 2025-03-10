package pac;
import java.util.*;

public class Fcfs{
static int p[][];

//arraylist to hold completion time for a process
static List<Integer> comp=new ArrayList<>();

//arraylist to hold waiting time for a process
static List<Integer> wait=new ArrayList<>();

static Scanner sc=new Scanner(System.in);

public static void main(String args[]){
	try 
	{
System.out.print("Enter no. of processes ");
int size=sc.nextInt();
p=new int[size][2];

//loop will take inputs in a 2-D array
for(int i=0;i<size;i++) {
int process=i+1;
System.out.println("Enter arrivial time for process "+process);
int arrivial_time=sc.nextInt();
if(arrivial_time>=0)p[i][0]=arrivial_time;
else {
	System.out.println("Please enter valid input");
    return;
}
System.out.println("Enter burst time for process "+(i+1));
int burst_time=sc.nextInt();
if(burst_time>=0)p[i][1]=burst_time;
else {
	System.out.println("Please enter valid input");
	return;
}
comp.add(0);
wait.add(0);
}

//Giving options to user
System.out.println("Choose which operation to perform\n"
+"1. Calculate completion time for each process\n"
+"2. Calculate waiting time for each process\n"
+"3. Calculate turn around time for each process\n"
+"4. Calculate avg. waiting time \n"
+"5. Max. waiting time for a process");
int input=sc.nextInt();

//user will enter input
switch(input) {
case 1:
	comp=complete(p);
	System.out.println(comp);
	break;
case 2:
	comp=complete(p);
	List<Integer> wait=wait(p,comp);
	System.out.println(wait);
	break;
case 3:
	comp=complete(p);
	List<Integer> turn=turn(p,comp);
	System.out.println(turn);
	break;
case 4:
	wait=wait(p,comp);
	System.out.println(avg_wait(wait));
	break;
case 5:
	wait=wait(p,comp);
	System.out.println(max_wait(wait));
	break;
default:
	System.out.println("Please enter valid input");
}
	}
catch(Exception e) 
	{
	System.out.println("Please enter valid input");
}

}

//cal. completion for each process
    static List<Integer> complete(int[][] arr){
        List<Integer> ls=new ArrayList<>();
        int initialc=arr[0][0];
        for(int i=0;i<arr.length;i++){
            initialc+=arr[i][1];
            ls.add(initialc);
        }
        return ls;
    }
    
//cal. waiting for each process
static List<Integer> wait(int arr[][],List<Integer> ls){
    List<Integer> ls1=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int turn=ls.get(i)-arr[i][1];
            int wait=turn-arr[i][1];
            ls1.add(wait);
        }
        return ls1;
    }

//cal. turn around time for each process
static List<Integer> turn(int arr[][],List<Integer> ls){
    List<Integer> ls2=new ArrayList<>();
    for(int i=0;i<arr.length;i++){
        ls2.add(ls.get(i)-arr[i][0]);
    }
    return ls2;
}

//cal. avg. waiting time
static double avg_wait(List<Integer> l){
    double average;
    int total=0;
    for(int i=0;i<l.size();i++){
        total+=l.get(i);
       
    }
    average=total/l.size();
    return average;
}

//cal. max. waiting time
static int max_wait(List<Integer> ls){
    int max=Integer.MIN_VALUE;
    for(int i=0;i<ls.size();i++){
        max=Math.max(max,ls.get(i));
    }
    return max;
}
}
