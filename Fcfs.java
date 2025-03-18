package pac;
import java.util.*;

public class Fcfs{
	
	//to control the loop
static boolean isValid=true;
	
	//the array will store all the processes burst time and arrivial time
static int arrayOfProcess[][];

//arraylist to hold completion time for a process
static List<Integer> completionList=new ArrayList<>();

//arraylist to hold waiting time for a process
static List<Integer> waitList=new ArrayList<>();

//scanner obj. for taking input
static Scanner scannerObject=new Scanner(System.in);

public static void main(String args[]){
	
	while(isValid) {
		try 
		{
	System.out.print("Enter no. of processes ");
	int size=scannerObject.nextInt();
	arrayOfProcess=new int[size][2];

	//loop will take inputs in a 2-D array
	for(int i=0;i<size;i++) {
	int process=i+1;
	System.out.println("Enter arrivial time for process "+process);
	int arrivial_time=scannerObject.nextInt();
	if(arrivial_time>=0)arrayOfProcess[i][0]=arrivial_time;
	else {
		System.out.println("Please enter valid input");
	    return;
	}
	System.out.println("Enter burst time for process "+(i+1));
	int burst_time=scannerObject.nextInt();
	if(burst_time>=0)arrayOfProcess[i][1]=burst_time;
	else {
		System.out.println("Please enter valid input");
		return;
	}
	completionList.add(0);
	waitList.add(0);
	}
	isValid=false;
		}
		catch(Exception e) {
			System.out.println("Enter valid input");
			scannerObject.nextLine();
		}
	}
	
	isValid=true;
	while(isValid) {
		try {
			//Giving options to user
			System.out.println("Choose which operation to perform\n"
			+"1. Calculate completion time for each process\n"
			+"2. Calculate waiting time for each process\n"
			+"3. Calculate turn around time for each process\n"
			+"4. Calculate avg. waiting time \n"
			+"5. Max. waiting time for a process\n"
			+"6. Exit");
			int input=scannerObject.nextInt();

			//user will enter input
			switch(input) {
			
			// case 1 for calculating completion time
			case 1:
				completionList=completion(arrayOfProcess);
				System.out.println(completionList);
				break;
				
			// case 2 for calculating waiting time
			case 2:
				completionList=completion(arrayOfProcess);
				List<Integer> waitingList=waitTime(arrayOfProcess,completionList);
				System.out.println(waitingList);
				break;
				
			//case3 for calculating turnAroundTime time
			case 3:
				completionList=completion(arrayOfProcess);
				List<Integer> turnAroundTimeList=turnTime(arrayOfProcess,completionList);
				System.out.println(turnAroundTimeList);
				break;
				
			//case 4 for calculating avg. waiting time
			case 4:
				waitingList=waitTime(arrayOfProcess,completionList);
				System.out.println(avgWaitTime(waitingList));
				break;
				
			// case 5 for calculating max. waiting time
			case 5:
				waitingList=waitTime(arrayOfProcess,completionList);
				System.out.println(maxWaitTime(waitingList));
				break;
				
			//case 6 for calculating completion time
			case 6:
				isValid=false;
				break;
				
			//default test case for printing error msg.
			default:
				System.out.println("Please enter valid input");
			}
				}
			catch(Exception e) 
				{
				System.out.println("Please enter valid input");
			    scannerObject.nextLine();
				}

	}
		
	
}

//cal. completion time for each process
    static List<Integer> completion(int[][] process){
        List<Integer> completionTime=new ArrayList<>();
        int initialCompletionTime=process[0][0];
        for(int i=0;i<process.length;i++){
        	initialCompletionTime+=process[i][1];
        	completionTime.add(initialCompletionTime);
        }
        return completionTime;
    }
    
//cal. waiting time for each process
static List<Integer> waitTime(int process[][],List<Integer> completionTime){
    List<Integer> waitTime=new ArrayList<>();
        for(int i=0;i<process.length;i++){
            int turnAroundTime=completionTime.get(i)-process[i][0];
            int waitingTime=turnAroundTime-process[i][1];
            waitTime.add(waitingTime);
        }
        return waitTime;
    }

//cal. turn around time for each process
static List<Integer> turnTime(int process[][],List<Integer> completionTime){
    List<Integer> turnAroundTime=new ArrayList<>();
    for(int i=0;i<process.length;i++){
    	turnAroundTime.add(completionTime.get(i)-process[i][0]);
    }
    return turnAroundTime;
}

//cal. avg. waiting time
static double avgWaitTime(List<Integer> waitingList){
    double average;
    int total=0;
    for(int waitingListIndex=0;waitingListIndex<waitingList.size();waitingListIndex++){
        total+=waitingList.get(waitingListIndex);
       
    }
    average=total/(waitingList.size()*1.0);
    return average;
}

//cal. max. waiting time
static int maxWaitTime(List<Integer> waitingList){
    int maxWaitingTime=Integer.MIN_VALUE;
    for(int waitingListIndex=0;waitingListIndex<waitingList.size();waitingListIndex++){
        maxWaitingTime=Math.max(maxWaitingTime,waitingList.get(waitingListIndex));
    }
    return maxWaitingTime;
}
}
