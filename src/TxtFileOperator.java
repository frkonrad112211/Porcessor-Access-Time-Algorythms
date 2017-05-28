import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TxtFileOperator {
	public Process createProcess(String line){
		//Take token by token every time
		StringTokenizer st = new StringTokenizer(line, "\t");
		int id = Integer.parseInt(st.nextToken());
		int phase = Integer.parseInt(st.nextToken());
		int arrivalTime = Integer.parseInt(st.nextToken());
		Process process = new Process(id, arrivalTime, phase);
		return process;
	}
	
	//it changes lines of text files into proceeses and saves them in allProcesses.
	public ArrayList<Process> getDataFromFile(String path){
		FileReader fr;
		BufferedReader br;
		Process process;
		ArrayList<Process> allProcesses = new ArrayList<Process> ();
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line;
			while(br.ready()){
				line=br.readLine();
				process = createProcess(line);
				allProcesses.add(process);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return allProcesses;
		
	}

}
