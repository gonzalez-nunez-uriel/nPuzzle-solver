

public class Candidate {
    public char move;
    public State state;

    public Candidate(char move, State state){
        this.move = move;
        this.state = state;
    }

    public String toString(){
        String msg = "\n";
        msg += ">> " + move + "\n";
        msg += state;
        return msg;
    }

    public boolean equals(Object other){ // this is the first time I deal with an Object variable :D

        if ((other == null) || !(other instanceof Candidate)) {
            return false;
        }

        Candidate otherCandidate = (Candidate) other;

        if(otherCandidate.move == this.move){
            if(otherCandidate.state.equals(this.state)){
                return true;
            }
        }

        return false;
    }
}
