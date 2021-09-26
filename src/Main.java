

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /*
        int[] stateArray = {0,1,2,3,4,5,6,7,8};
        State initialState = new State(stateArray);
        System.out.println(initialState);
        /*

        /*
        int[] stateArray = {2,0,1,4,5,8,7,6,3};
        State test = new State(stateArray);
        System.out.println(test.chechIfStateIsValid());
        /*

        /*
        int[] stateArray = {2,0,1,4,5,8,7,6,3};
        int[] stateArrayb = {0,1,2,3,4,5,6,7,8};
        int[] stateArrayc = {8,1,0,4,5,2,7,6,3};
        State test = new State(stateArray);
        State testb = new State(stateArrayb);
        State testc = new State(stateArrayc);
        int num = test.hashCode();
        int numb = testb.hashCode();
        int numc = testc.hashCode();

        System.out.println(num);
        System.out.println(numb);
        System.out.println(numc);
        */

        /*
        int[] stateArray = {2,0,1,4,5,8,7,6,3};
        int[] stateArrayb = {0,1,2,3,4,5,6,7,8};
        State test = new State(stateArray);
        State testb = new State(stateArrayb);
        boolean flag1 = DFS_agent.checkIfStateIsGoal(test);
        boolean flag2 = DFS_agent.checkIfStateIsGoal(testb);
        System.out.println(flag1);
        System.out.println(flag2);
        */

        /*
        int[] stateArray = {2,0,1,4,9,8,7,6,3};
        State test = new State(stateArray);
        //State b = test.moveUp();
        State b = new State(stateArray);
        System.out.println(test);
        System.out.println(b);
        boolean flag = test.equals(b);
        System.out.println(flag);
        */

        /*
        int[] stateArray = {2,0,1,4,9,8,7,6,3};
        State test = new State(stateArray);
        Candidate candidate = new Candidate('R', test);
        Candidate candidateb = new Candidate('R', test);
        Stack<Candidate> frontier = new Stack<Candidate>();
        frontier.add(candidate);
        System.out.println(frontier);
        boolean flag = frontier.contains(candidateb);
        System.out.println(flag);
        */

        /*
        int[] stateArray = {2,0,1,4,9,8,7,6,3};
        State test = new State(stateArray);
        State b;
        System.out.println(test);
        b = test.moveUp();
        System.out.println(b);
        */

        /*
        int[] stateArray = {2,0,1,4,9,8,7,6,3};
        State initialState = new State(stateArray);
        DFS_agent agent = new DFS_agent(initialState);
        boolean flag = agent.test();
        System.out.println(flag);
        */

        /*
        int[] stateArray = {3,1,2,0,4,5,6,7,8};
        State initialState = new State(stateArray);
        DFS_agent agent = new DFS_agent(initialState);
        boolean flag = agent.test();
        System.out.println("######################################################");
        flag = agent.test();
        System.out.println(flag);
        */

        /*
        //int[] stateArray = {1,0,2,3,4,5,6,7,8};
        int[] stateArray = {2,0,1,5,4,3,8,7,6};
        State initialState = new State(stateArray);
        DFS_agent agent = new DFS_agent(initialState);
        boolean flag = agent.findSolution();
        System.out.println(flag);
        int[] goalAsArray = {0,1,2,3,4,5,6,7,8};
        State goal = new State(goalAsArray);
        boolean flag2 = agent.explored.contains(goal);
        System.out.println(flag2);
        System.out.println("DONE");
        */

        /*
        //int[] stateArray = {1,0,2,3,4,5,6,7,8};
        int[] stateArray = {8,7,5,4,3,6,1,0,2};
        State initialState = new State(stateArray);
        DFS_agent agent = new DFS_agent(initialState);
        boolean flag = agent.findSolution();
        System.out.println(flag);
        System.out.println("DONE");
        */

        System.out.println("START OF PROGRAM");
        int[] stateArray1 = {1,0,2,3,4,5,6,7,8};
        int[] stateArray2 = {2,0,1,4,3,5,6,7,8};
        int[] stateArray3 = {2,0,1,4,3,6,5,8,7};
        int[] stateArray4 = {2,7,1,4,3,6,5,0,8};
        int[] stateArray5 = {8,7,5,4,3,6,1,0,2};
        State initialState1 = new State(stateArray1);
        State initialState2 = new State(stateArray2);
        State initialState3 = new State(stateArray3);
        State initialState4 = new State(stateArray4);
        State initialState5 = new State(stateArray5);

        System.out.println("\nDFS agent");
        DFS_agent dfsAgent;
        dfsAgent = new DFS_agent(initialState1);
        dfsAgent.findSolution();
        System.out.println("Number of states explored: " + dfsAgent.explored.size());

        dfsAgent = new DFS_agent(initialState2);
        dfsAgent.findSolution();
        System.out.println("Number of states explored: " + dfsAgent.explored.size());

        dfsAgent = new DFS_agent(initialState3);
        dfsAgent.findSolution();
        System.out.println("Number of states explored: " + dfsAgent.explored.size());

        dfsAgent = new DFS_agent(initialState4);
        dfsAgent.findSolution();
        System.out.println("Number of states explored: " + dfsAgent.explored.size());

        dfsAgent = new DFS_agent(initialState5);
        dfsAgent.findSolution();
        System.out.println("Number of states explored: " + dfsAgent.explored.size());

        System.out.println("\nBFS agent");
        BFS_agent bfsAgent;
        bfsAgent = new BFS_agent(initialState1);
        bfsAgent.findSolution();
        System.out.println("Number of states explored: " + bfsAgent.explored.size());

        bfsAgent = new BFS_agent(initialState2);
        bfsAgent.findSolution();
        System.out.println("Number of states explored: " + bfsAgent.explored.size());

        bfsAgent = new BFS_agent(initialState3);
        bfsAgent.findSolution();
        System.out.println("Number of states explored: " + bfsAgent.explored.size());

        bfsAgent = new BFS_agent(initialState4);
        bfsAgent.findSolution();
        System.out.println("Number of states explored: " + bfsAgent.explored.size());

        bfsAgent = new BFS_agent(initialState5);
        bfsAgent.findSolution();
        System.out.println("Number of states explored: " + bfsAgent.explored.size());

        System.out.println("\nA* with hammin heuristic agent");
        A_Star_agent starAgent;
        starAgent = new A_Star_agent(initialState1);
        starAgent.findSolution();
        System.out.println("Number of states explored: " + starAgent.explored.size());

        starAgent = new A_Star_agent(initialState2);
        starAgent.findSolution();
        System.out.println("Number of states explored: " + starAgent.explored.size());

        starAgent = new A_Star_agent(initialState3);
        starAgent.findSolution();
        System.out.println("Number of states explored: " + starAgent.explored.size());

        starAgent = new A_Star_agent(initialState4);
        starAgent.findSolution();
        System.out.println("Number of states explored: " + starAgent.explored.size());

        starAgent = new A_Star_agent(initialState5);
        starAgent.findSolution();
        System.out.println("Number of states explored: " + starAgent.explored.size());

        System.out.println("\nDONE");

        /*
        //int[] stateArray = {1,0,2,3,4,5,6,7,8};
        int[] stateArray = {8,7,5,4,3,6,1,0,2};
        State initialState = new State(stateArray);
        BFS_agent agent = new BFS_agent(initialState);
        boolean flag = agent.findSolution();
        System.out.println(flag);
        System.out.println("DONE");
        */

        /*
        // int[] stateArray = {1,0,2,3,4,5,6,7,8};
        int[] stateArray = {8,7,5,4,3,6,1,0,2};
        State initialState = new State(stateArray);
        A_Star_agent agent = new A_Star_agent(initialState);
        boolean flag = agent.findSolution();
        System.out.println(flag);
        System.out.println("DONE");
        */

        /*
        Set<State> explored = new HashSet<State>();
        int[] stateArray = {1,0,2,3,4,5,6,7,8};
        State a = new State(stateArray);
        State b = a.moveUp();
        State c = new State(stateArray);
        boolean x = explored.add(a);
        boolean y = explored.add(b);
        boolean z = explored.add(c);
        System.out.println(explored);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a.equals(c));
        */

    }
}
