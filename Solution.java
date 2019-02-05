import java.util.Arrays;
import java.util.List;
public class Solution {
	
	public static void main(String[] args) throws Exception{
		RTG rtg = new RTG();
		RTG.State state = rtg.new State(0, Arrays.asList(
		0,0, //strontium
		0,0, //plutonium
		2,1, // thulium
		1,1, // ruthenium
		1,1,// curium
		0,0,
		0,0
		
		));
		//RTG.State state = rtg.new State(0, Arrays.asList(0,1,0,2));
		try{
		List<RTG.State> steps = rtg.findMinSteps(state);
		//visualizeSolution(steps);
		System.out.println("No. of steps taken to reach F4: "+ (steps.size()-1));
		}catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void visualizeSolution(List<RTG.State> steps) {
	    steps.forEach(state -> {
	        try {
				Thread.sleep(150);
				System.out.println("Current elevator position : "+ state.floor + " State : "+state.items);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    });
	}
	
}
