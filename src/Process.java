
public class Process implements Comparable<Process>{
	public Process(int id, int arrivalTime, int phase){
		this.id=id;
		this.arrivalTime=arrivalTime;
		this.phase=phase;
		this.waitTime=0;
	}
	
	public int id;
	public int arrivalTime;
	public int phase;
	public int waitTime;
	
	//We compare processess by phase
	public int compareTo(Process ob) {
		if(phase<ob.phase){return -1;}
		else{
			if(phase==ob.phase){return 0;}
			else{
				return 1;
			}
		}
		
		
	}


}
