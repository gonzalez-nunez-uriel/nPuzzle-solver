

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class BFS_agent {
    public Queue<Candidate> frontier;
    public Set<State> explored;
    public String actions = "";

    public BFS_agent(State initialState){
        frontier = new LinkedList<Candidate>();
        explored = new HashSet<State>();
        char move = 'O';
        Candidate initialCanditate = new Candidate(move,initialState);
        frontier.add(initialCanditate);

    }

    // the boolean indicates if it found a solution or not.
    // the solution is stored as class variables
    public boolean findSolution(){
        State currentState;
        Candidate[] neighboors;
        Candidate candidate;
        boolean isCurrentStateTheGoal;
        while( !(frontier.isEmpty()) ){
            candidate = frontier.poll();
            if(!candidate.state.chechIfStateIsValid()){
                System.out.println("Found invalid candidate");
                System.out.println(candidate);
                break;
            }
            actions += candidate.move; // add the move that leads to this candidate to the list of moves taken
            //System.out.println(actions);
            currentState = candidate.state;
            isCurrentStateTheGoal = checkIfStateIsGoal(currentState);
            if(isCurrentStateTheGoal){
                //If the current state is the goal then we are done
                return true;

            } else{
                explored.add(currentState);
                neighboors = currentState.neighboors();
                for(int i = 0; i < neighboors.length; i++){
                    if(!frontier.contains(neighboors[i]) && !explored.contains(neighboors[i].state)){
                        frontier.add(neighboors[i]); // only add states that are not in the frontier or have been explored
                    }

                }
            }
        }

        // solution not found
        return false;
    }

    public boolean checkIfStateIsGoal(State candidate){
        int[] goalAsArray = {0,1,2,3,4,5,6,7,8};
        State goal = new State(goalAsArray);

        //Error checking
        if(candidate.size != goal.size){
            System.out.println("Error: While checking if a state is equal to a goal");
            System.out.println("state: " + candidate.toString() + " | goal: " + goal.toString());
        }

        for(int i = 0; i < candidate.size; i++){
            if( candidate.get(i) == goal.get(i) ){
                // good
            } else{ // at some element the two states are not equal
                return false;
            }
        }
        // if the program reaches this line then all elements are equal
        return true;

    }
}
