import java.util.Collections;

public class ProcessesManager {
	
	public int getMinimumArrivalTime(){
		int minimum =Settings.allProcesses.get(0).arrivalTime;
		for(Process proc: Settings.allProcesses){
			if(proc.arrivalTime<minimum){
				minimum=proc.arrivalTime;
			}
		}
		return minimum;
	}
	
	//Checks process one by one if its phase is less or equal to processor time.
	public void chceckForReadyProcesses(){
		if(!(Settings.allProcesses.isEmpty())){
			for(Process process: Settings.allProcesses){
				if(process.arrivalTime<=Settings.cpuPhaseTotal){
					Settings.readyProcesses.add(process);
				}
			}
			if(!Settings.readyProcesses.isEmpty()){
				for(Process process: Settings.readyProcesses){
					if(Settings.allProcesses.contains(process)){
						Settings.allProcesses.remove(process);
					}
				}
			}
			
		}
	}
	public void chceckForReadyProcessesSorted(){
		chceckForReadyProcesses();
		Collections.sort(Settings.readyProcesses);
	}
}
