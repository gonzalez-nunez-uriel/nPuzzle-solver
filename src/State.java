

import java.lang.Math;

public class State {

    public int size;
    public int[] state;
    public int k;
    public int zerothIndex;


    public State(int[] inputState){
        this.state = inputState;
        this.size = state.length;
        this.k = (int) Math.sqrt(this.size);
        this.zerothIndex = findIndexOfZeroth();
    }

    public int get(int index){
        return state[index]; // let array handle out of bounds
    }

    public int[] getArray(){
        return state.clone();
    }

    public int findIndexOfZeroth(){
        for(int i = 0; i < size;i++){
            if(state[i] == 0){
                return i;
            }
        }
        System.out.println("Something whent wrong. The zeroth of this state could not be found");
        System.out.println(toString()); // is this correct?
        return -1; // something whent wrong
    }

    public String toString(){
        String msg = "---------\n";

        int count;
        int row = k-1;
        while(row >= 0){
            count = k*row;
            msg += "| ";
            for(int i = 0; i < k; i++){
                msg += state[count] + " ";
                count++;
            }
            msg += "|\n";
            row--;
        }

        msg += "---------\n";
        return msg;
    }

    public Candidate[] neighboors(){
        String possibleMoves = possibleMoves();
        Candidate[] neighboors = new Candidate[possibleMoves.length()]; // every possible move results in a neighboor
        char move;
        State neighboor;
        for(int i = 0; i < possibleMoves.length(); i++){
            move = possibleMoves.charAt(i);
            if(move == 'U'){
                neighboor = moveUp();
            } else if(move == 'D'){
                neighboor = moveDown();
            } else if(move == 'R'){
                neighboor = moveRight();
            } else {
                neighboor = moveLeft();
            }
            neighboors[i] = new Candidate(move, neighboor);
        }
        return neighboors;
    }

    public String possibleMoves(){

        if(zerothIndex == 0){ // bottom left corner
            return "UR";
        } else if(zerothIndex == k*(k-1)){ // top left corner
            return "DR";
        } if(zerothIndex == k-1){ // bottom right corner
            return "UL";
        } else if(zerothIndex == k*k-1){ // top right corner
            return "DL";
        } else if(zerothIndex % k == 0){ // left side
            return "UDR";
        } else if(zerothIndex % k == k-1){ // right side
            return "UDL";
        } else if(zerothIndex > 0 && zerothIndex < k-1){ // bottom side
            return "URL";
        } else if(zerothIndex > k*(k-1) && zerothIndex < k*k-1){ // top side
            return "DRL";
        } else{ // interior
            return "UDRL";
        }
    }

    public State moveUp(){
        int[] stateArray = getArray();
        State result = new State(stateArray); // makes a copy of this state
        result.swap(zerothIndex,zerothIndex + k);
        return result;

    }

    public State moveDown(){
        State result = new State(getArray()); // makes a copy of this state
        result.swap(zerothIndex,zerothIndex - k);
        return result;
    }

    public State moveRight(){
        State result = new State(getArray()); // makes a copy of this state
        result.swap(zerothIndex,zerothIndex + 1);
        return result;
    }

    public State moveLeft(){
        State result = new State(getArray()); // makes a copy of this state
        result.swap(zerothIndex,zerothIndex - 1);
        return result;
    }

    public void swap(int i, int j){
        int temp = state[i];
        state[i] = state[j];
        state[j] = temp;
        zerothIndex = findIndexOfZeroth();
    }

    public boolean equals(Object other){ // this is the first time I deal with an Object variable :D

        if ((other == null) || !(other instanceof State)) {
            return false;
        }

        State otherState = (State) other;

        int[] otherArray = otherState.state;
        for(int i = 0; i < size; i++){
            if(otherArray[i] != state[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode(){
        double sum = 0;
        int result;
        for(int i = 0; i < size; i++){
            sum += (double)state[i] * Math.pow( 10.0, (double)i );
        }

        result = (int) sum;
        return result;
    }

    public boolean chechIfStateIsValid() {
        int sum = 0;
        int maxValue = k * k - 1;
        int correct = (maxValue) * (maxValue + 1) / 2; // sum of the natural numbers up to maxValue
        for (int i = 0; i < size; i++) {
            sum += state[i];
        }

        if(sum == correct){
            return true;
        } else {
            return false;
        }
    }
}
