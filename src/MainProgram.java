import java.util.ArrayList;

public class MainProgram {
	
	public static ProcessesManager processesManager = new ProcessesManager();
	//here we will keep results
	public static Results results = new Results();
	
	//we change each line of text file to process
	public static void getProcessesFromFile(String path){
		TxtFileOperator txtFileOperator = new TxtFileOperator();
		Settings.allProcesses=txtFileOperator.getDataFromFile(path);
	}
	
	//checks for ready processes (one which arrival time is 
	//less than processor time in FIFO order
	public static void getReadyProcesses(){
		processesManager.chceckForReadyProcesses();
	}
	
	//For certain algorithms we need to get ready processes which are already sorted
	public static void getReadyProcessesSorted(){
		processesManager.chceckForReadyProcessesSorted();
	}
	
	public static void showProcesses(){
		System.out.println("All processess: ");
		for(Process proc: Settings.allProcesses)
		{
			System.out.println(proc.id+" "+proc.phase+" "+proc.arrivalTime+" "+proc.waitTime);
		}
		
		System.out.println("Ready processes: ");
		for(Process proc: Settings.readyProcesses)
		{
			System.out.println(proc.id+" "+proc.phase+" "+proc.arrivalTime+" "+proc.waitTime);
		}
		
		System.out.println("Done Processes");
		for(Process proc: Settings.doneProcesses)
		{
			System.out.println(proc.id+" "+proc.phase+" "+proc.arrivalTime+" "+proc.waitTime);
		}
	}
	
	public static void runFCFS(){
		FCFS fcfs = new FCFS();
		
		while(!Settings.allProcesses.isEmpty()){
			
			if(fcfs.runFCFS()&&!Settings.allProcesses.isEmpty()){
				Settings.cpuPhaseTotal=processesManager.getMinimumArrivalTime();
				getReadyProcesses();
			}
		}
		fcfs.runFCFS();
		results.FCFSdoneProcesses = (ArrayList<Process>) Settings.doneProcesses.clone();
	}
	
	public static void runSJF(){
		SJF sjf = new SJF();
		
		while(!Settings.allProcesses.isEmpty()){
			
			if(sjf.runSJF()&&!Settings.allProcesses.isEmpty()){
				Settings.cpuPhaseTotal=processesManager.getMinimumArrivalTime();
				getReadyProcesses();
			}
		}
		sjf.runSJF();
		results.SJFdoneProcesses = (ArrayList<Process>) Settings.doneProcesses.clone();
	}
	

	public static void runSJFw(){
		SJFw sjfw = new SJFw();
		
		while(!Settings.allProcesses.isEmpty()){
			
			if(sjfw.runSJFw()&&!Settings.allProcesses.isEmpty()){
				Settings.cpuPhaseTotal=processesManager.getMinimumArrivalTime();
				getReadyProcesses();
			}
		}
		sjfw.runSJFw();
		results.SJFwDoneProcesses = (ArrayList<Process>) Settings.doneProcesses.clone();
	}
	
	public static void runRR(){
		RR rr = new RR();
		rr.runRR();
		results.RRDoneProcesses = (ArrayList<Process>) Settings.doneProcesses.clone();
	}
	
	public static void analizeProcessesInFile(String path){
		//FCFS
		getProcessesFromFile(path);
		getReadyProcesses();
		runFCFS();
		Settings.clearResources();
		
		//SJF
		getProcessesFromFile(path);
		getReadyProcessesSorted();
		runSJF();
		Settings.clearResources();
		
		//SJFw
		getProcessesFromFile(path);
		getReadyProcessesSorted();
		runSJFw();
		Settings.clearResources();
		
		//RR
		getProcessesFromFile(path);
		getReadyProcessesSorted();
		runRR();
		
		Settings.clearResources();
		
		//Results
		System.out.println("Wyniki dla pliku: "+path);
		results.showResults();
	}
	
	public static void main(String[] args){
		System.out.println("First case:");
		System.out.println("Process Time: 1 - 200, Arrival Time: 0 - 1000");
		analizeProcessesInFile("processes1.txt");
		System.out.println("--------------------------------------");
		
		System.out.println("Second case:");
		System.out.println("Process Time = Arival Time = ID ");
		analizeProcessesInFile("processes2.txt");
		System.out.println("--------------------------------------");
		

		
	}

}
