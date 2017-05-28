
public class RR {
	public ProcessesManager processesManager = new ProcessesManager();
	
	public void runRR(){
		int i=0;
		
		
		while(!Settings.allProcesses.isEmpty()||!Settings.readyProcesses.isEmpty()){
			if(Settings.readyProcesses.isEmpty()){
				Settings.cpuPhaseTotal++;
				processesManager.chceckForReadyProcessesSorted();
				
			}else
			{
				processesManager.chceckForReadyProcessesSorted();
				Process nextProcess = Settings.readyProcesses.get(i);
				if(nextProcess.phase<Settings.RRCycle){
					
					for(Process process: Settings.readyProcesses){
						if(process!=nextProcess){
							process.waitTime+=nextProcess.phase;
						}
					}
					nextProcess.phase=0;
					Settings.cpuPhaseTotal+=nextProcess.phase;
					
				}else{
					nextProcess.phase-=Settings.RRCycle;
					Settings.cpuPhaseTotal+=Settings.RRCycle;
					for(Process process: Settings.readyProcesses){
						
						if(process!=nextProcess){
							process.waitTime+=Settings.RRCycle;
						}
					}
				}
				
				if(nextProcess.phase<=0){
					Settings.doneProcesses.add(nextProcess);
					Settings.readyProcesses.remove(nextProcess);
				}
				
				
				i++;
				if(i>=Settings.readyProcesses.size()){
					i=0;
				}
				
				
			}
			
		}
		
	}

}
