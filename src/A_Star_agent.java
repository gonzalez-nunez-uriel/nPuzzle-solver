

import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class A_Star_agent {
    public Stack<Candidate> frontier;
    public Set<State> explored;
    public String actions = "";

    public A_Star_agent(State initialState){
        frontier = new Stack<Candidate>();
        explored = new HashSet<State>();
        char move = 'O';
        Candidate initialCanditate = new Candidate(move,initialState);
        frontier.push(initialCanditate);

    }

    // the boolean indicates if it found a solution or not.
    // the solution is stored as class variables
    public boolean findSolution(){
        State currentState;
        Candidate[] neighboors;
        Candidate candidate;
        boolean isCurrentStateTheGoal;
        while( !(frontier.isEmpty()) ){
            candidate = frontier.pop();
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
                //HERE!!!!!!!!!!!!!!!!!
                int min = 10000;
                int maxIndex = -1;
                int score;
                for(int i = 0; i < neighboors.length; i++){
                    score = hamminDistance(neighboors[i].state);
                    if(score <= min){
                        min = score;
                        maxIndex = i;
                    }
                }
                candidate = neighboors[maxIndex];
                if(!frontier.contains(candidate) && !explored.contains(candidate.state) && explored.size() < 2){ // ignore first case to add elements to the frontier to add variability
                    frontier.push(candidate); // only add states that are not in the frontier or have been explored
                } else{
                    for(int i = 0; i < neighboors.length; i++){ // just add anything not visited
                        if( !frontier.contains(neighboors[i]) && !explored.contains(neighboors[i].state) ){
                            frontier.push(neighboors[i]);
                            //break; // adding more cnadidates in this situation prevents cycles
                        }
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

    public int hamminDistance(State state){
        int sum = 0;
        int[] goalAsArray = {0,1,2,3,4,5,6,7,8};
        for(int i = 0; i < state.size; i++){
            if(state.get(i) != goalAsArray[i]){
                sum++;
            }
        }
        return sum;
    }
}
