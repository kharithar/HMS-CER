import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
/* Implemented using Breadth First Search for a graph.
 * Looks for adjacent states and keeps track of visited states.
 * Checks for valid states.
 */
public class RTG {
	
	/* Node stores the current state and prev node(which contains previous state)
	 */
	class Node {
		Node prev;
		State state;
		
		Node(Node prev, State state){
			this.prev = prev;
			this.state = state;
		}
	}
	
	/* State maintains the current floor and the list of items in each floor
	 */
	class State {
		int floor;
		List<Integer> items;
		
		State(int floor, List<Integer> items){
			this.floor = floor;
			this.items = items;
		}
	}
	
	/* Returns true if all the items in the current state have reached F4.
	 */
	private boolean finalStateReached(Node node) {
		List<Integer> items = node.state.items;
		for(int i=0; i< items.size();i++) {
			if(items.get(i) != 3) {
				return false;
			}
		}
		return true;
	}
	
	/*This method finds the next unvisited states and hash is calculated on the pairs which will be moved with floor.
	 * If the next state is not already visited, then hash is stored in hashMap as key and value is true
	 * And checks if the state is valid or not and will return the valid states.
	 */
	private List<State> nextValidUnVisitedStates(HashMap<String,Boolean>visitedStates, State state) {
		List<State> nextPossibleStates = nextPossibleStates(state);
		List<State> nextStates = nextPossibleStates.stream().filter(nextPossibleState -> {
			String hash = stateHash(nextPossibleState);
			if(visitedStates.get(hash) != null) {
				return false;
			}
			visitedStates.put(hash,true);
			return isValidState(nextPossibleState);
		}).collect(Collectors.toList());
		return nextStates;
	}
	
	/* A state is invalid if any microchip is not near its generator but on the same floor of another generator.
	 */
	private boolean isValidState(State state) {
		for(int i = 0; i< state.items.size(); i+=2) {
			if(state.items.get(i) != state.items.get(i+1)) {
				for(int j=0; j< state.items.size();j+=2) {
					//Compares microchip with generators (if microchip is near another generator return false)
					if(state.items.get(j+1) == state.items.get(i)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/* unvisited states hash is calculated with floor info.
	 * Pairs are added with microchip and generator
	 */
	private String stateHash(State state) {
		List<String> pairs = new ArrayList<>();
		for(int i=0; i< state.items.size(); i+=2) {
			pairs.add(String.valueOf(state.items.get(i))+String.valueOf(state.items.get(i+1)));
		}
		List<String> sortedPairs = pairs.stream().collect(Collectors.toList());
		Collections.sort(sortedPairs);
		return String.valueOf(state.floor) + String.join("", sortedPairs) ;
	}
	
	/* Next possible states are calculated by taking the elements which are in the current floor
	 * and finding the states by moving above and below the current floor.
	 * This includes moving two elements or single element.
	 */
	private List<State> nextPossibleStates(State state) {
		List<Integer> nextMovers = new ArrayList<>();
		for(int i=0; i< state.items.size(); i++) {
			if(state.items.get(i) == state.floor) {
				nextMovers.add(i);
			}
		}
		List<State> nextPossibleStates = new ArrayList<State>();
		//Increment the floor count by 1 if current floor is not final
		if(state.floor != 3) {
		    for (int i = 0; i < nextMovers.size(); i++) {
			      for (int j = i + 1; j < nextMovers.size(); j++) {
			    	  nextPossibleStates.add(movedState(state, 1, nextMovers.get(i), nextMovers.get(j)));
			      }
			      nextPossibleStates.add(movedState(state, 1, nextMovers.get(i), -1));
			    }
		}
		//Decrement the floor count by 1 if current floor is not first
		if(state.floor != 0) {
		    for (int i = 0; i < nextMovers.size(); i++) {
		    	nextPossibleStates.add(movedState(state, -1, nextMovers.get(i), -1));
			      for (int j = i + 1; j < nextMovers.size(); j++) {
			    	  nextPossibleStates.add(movedState(state, -1, nextMovers.get(i), nextMovers.get(j)));
			      }
			}
		}
		
		return nextPossibleStates;
	
	}
	
	/* Next state and floor is found by incrementing/decrementing the direction  
	 */
	private State movedState(State state, int direction, int item1, int item2) {
		State nextState  = new State(state.floor, state.items.stream().collect(Collectors.toList()));
		nextState.floor += direction;
		nextState.items.set(item1, nextState.items.get(item1)+direction);
		if(item2 != -1) {
			nextState.items.set(item2, nextState.items.get(item2)+direction);
		}
		
		return nextState;
	}
	
	/*Queue with Linked list is used to store the current state and prev state of each node
	* which in turn is used to find the number of steps. 
	* visitedStates is used to keep track of the visited paths.
	*/
	public List<State> findMinSteps(State state) throws Exception{
		Queue<Node> queue = new LinkedList<>();
		HashMap<String,Boolean> visitedStates = new HashMap<>();
		//First time add the current state with prev node as null in to queue.
		queue.add(new Node(null, state));
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			// If all items reach F4 find no. of steps taken to reach F4
			//As the temp contains the path taken so far we will traverse and store each state.
			if(finalStateReached(temp)) {
				List<State> steps = new ArrayList<>();
				while(temp != null) {
					steps.add(temp.state);
					temp = temp.prev;
				}
				Collections.reverse(steps);
				return steps;
			}
			
			//else find next valid unvisited states to move
			List<State> nextStates = nextValidUnVisitedStates(visitedStates,temp.state); 
			//Assign the current state to prevNode and add next valid state along with prev node(Node) to queue.
			final Node prevNode = temp;
			nextStates.forEach(nextState -> {
				queue.add(new Node(prevNode,nextState));
			});
		}
		throw new Exception("No solution");
	}
}
