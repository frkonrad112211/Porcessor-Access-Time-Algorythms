import java.util.ArrayList;

//We control program by Settings Class. 

public class Settings {
	public static ArrayList<Process> allProcesses = new ArrayList<Process>() ;
	public static ArrayList<Process> readyProcesses = new ArrayList<Process>() ;
	public static ArrayList<Process> doneProcesses = new ArrayList<Process>() ;
	public static int cpuPhase=1;
	public static int cpuPhaseTotal=0;
	public static int RRCycle=100;
	
	public static void clearResources(){
		allProcesses.clear();
		readyProcesses.clear();
		doneProcesses.clear();
		cpuPhaseTotal=0;
	}
	
}
