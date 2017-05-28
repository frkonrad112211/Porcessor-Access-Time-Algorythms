
public class FCFS {

	public ProcessesManager processesManager = new ProcessesManager();
	
	public boolean runFCFS(){
		int i = 0;
		while(!Settings.readyProcesses.isEmpty()){
			//we take first in row process which is ready
			Process nextProcess = Settings.readyProcesses.get(i);
			Settings.readyProcesses.remove(nextProcess);
			//we process it until its phase is less than 0
			while(nextProcess.phase>0){
				
				if(nextProcess.phase<Settings.cpuPhase){
					for(Process proc: Settings.readyProcesses){
						proc.waitTime+=nextProcess.phase;
					}
					Settings.cpuPhaseTotal+=nextProcess.phase;
					processesManager.chceckForReadyProcesses();
					nextProcess.phase=0;
				}else{
					nextProcess.phase-=Settings.cpuPhase;
					Settings.cpuPhaseTotal+=Settings.cpuPhase;
					for(Process proc: Settings.readyProcesses){
						proc.waitTime+=Settings.cpuPhase;
					}
					processesManager.chceckForReadyProcesses();
				}
			}
			Settings.doneProcesses.add(nextProcess);
		}
		return true;
	}
}
