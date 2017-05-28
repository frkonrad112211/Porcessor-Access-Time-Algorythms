import java.util.ArrayList;
import java.util.Collections;

public class Results {
	public ArrayList<Process> FCFSdoneProcesses = new ArrayList<Process>();
	public ArrayList<Process> SJFdoneProcesses = new ArrayList<Process>();
	public ArrayList<Process> SJFwDoneProcesses = new ArrayList<Process>();
	public ArrayList<Process> RRDoneProcesses = new ArrayList<Process>();
	
	public double FCFSResult(){
		double average=0;
		double sum=0;
		int quantity = FCFSdoneProcesses.size();
		for (Process process: FCFSdoneProcesses){
			sum+=process.waitTime;
		}
		average=sum/quantity;
		return average;
	}
	
	public double SJFResult(){
		double average=0;
		double sum=0;
		int quantity = SJFdoneProcesses.size();
		for (Process process: SJFdoneProcesses){
			sum+=process.waitTime;
		}
		average=sum/quantity;
		return average;
	}
	
	public double SJFwResult(){
		double average=0;
		double sum=0;
		int quantity = SJFwDoneProcesses.size();
		for (Process process: SJFwDoneProcesses){
			sum+=process.waitTime;
		}
		average=sum/quantity;
		return average;
	}
	
	public double RRResult(){
		double average=0;
		double sum=0;
		int quantity = RRDoneProcesses.size();
		for (Process process: RRDoneProcesses){
			sum+=process.waitTime;
		}
		average=sum/quantity;
		return average;
	}
	public class rObiect implements Comparable<rObiect>{
		public double result;
		public String type;
		public rObiect(double tResult, String tType){
			result=tResult;
			type=tType;
		}
		
		public int compareTo(rObiect ob) {
			if(result<ob.result){
				return -1;
			}
			else{
				if(result==ob.result){
					return 0;
				}
				else{
					return 1;
				}
			}
		}
	}
		
	public void showResults(){
		rObiect ob1 =  new rObiect(FCFSResult(),"FCFS");
		rObiect ob2 =  new rObiect(SJFResult(),"SJF");
		rObiect ob3 =  new rObiect(SJFwResult(),"SJFw");
		rObiect ob4 =  new rObiect(RRResult(),"RR");
		ArrayList<rObiect> resultList = new ArrayList<rObiect>();
		resultList.add(ob1);
		resultList.add(ob2);
		resultList.add(ob3);
		resultList.add(ob4);
		Collections.sort(resultList);
		for(rObiect ob: resultList){
			System.out.println(ob.type+":"+ob.result);
		}
		
	}
}
