import java.util.Collections;

public class SJFw {

	public ProcessesManager processesManager = new ProcessesManager();

	public boolean runSJFw(){
		int i = 0;
		while(!Settings.readyProcesses.isEmpty()){
			Process nextProcess = Settings.readyProcesses.get(i);
			Settings.readyProcesses.remove(nextProcess);
			while(nextProcess.phase>0){
				if(nextProcess.phase<Settings.cpuPhase){
					
					for(Process proc: Settings.readyProcesses){
						proc.waitTime+=nextProcess.phase;
					}
					Settings.cpuPhaseTotal+=nextProcess.phase;
					processesManager.chceckForReadyProcessesSorted();
					nextProcess.phase=0;
					
				}else{
					if(!Settings.readyProcesses.isEmpty()){
						if(nextProcess.phase>Settings.readyProcesses.get(0).phase){
							Settings.readyProcesses.add(nextProcess);
							nextProcess=Settings.readyProcesses.get(0);
							Settings.readyProcesses.remove(nextProcess);
							Collections.sort(Settings.readyProcesses);
						}
					}
					nextProcess.phase-=Settings.cpuPhase;
					Settings.cpuPhaseTotal+=Settings.cpuPhase; 
					for(Process proc: Settings.readyProcesses){
						proc.waitTime+=Settings.cpuPhase;
					}
					processesManager.chceckForReadyProcessesSorted();
					
					
				}
			}
			Settings.doneProcesses.add(nextProcess);
			
		}
		return true;
	}
}
