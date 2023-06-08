package org.example.endterm;

import java.util.ArrayList;
import java.util.List;

public class HunterProblem {
    enum Item {
        HUNTER, WOLF, SHEEP, CABBAGE
    }

    enum Bank {
        LEFT, RIGHT
    }

    static class State {
        Bank hunterBank;
        Bank wolfBank;
        Bank sheepBank;
        Bank cabbageBank;

        public State(Bank hunterBank, Bank wolfBank, Bank sheepBank, Bank cabbageBank) {
            this.hunterBank = hunterBank;
            this.wolfBank = wolfBank;
            this.sheepBank = sheepBank;
            this.cabbageBank = cabbageBank;
        }

        public boolean isGoalState() {
            return hunterBank == Bank.RIGHT && wolfBank == Bank.RIGHT && sheepBank == Bank.RIGHT && cabbageBank == Bank.RIGHT;
        }

        public boolean isValidState() {
            if (wolfBank == sheepBank && hunterBank != wolfBank)
                return false;
            if (sheepBank == cabbageBank && hunterBank != sheepBank)
                return false;
            return true;
        }

        public List<State> getValidNextStates() {
            List<State> nextStates = new ArrayList<>();

            if (hunterBank == Bank.LEFT) {
                nextStates.add(new State(Bank.RIGHT, wolfBank, sheepBank, cabbageBank));
                nextStates.add(new State(Bank.RIGHT, wolfBank, cabbageBank, sheepBank));
                nextStates.add(new State(Bank.RIGHT, sheepBank, wolfBank, cabbageBank));
                nextStates.add(new State(Bank.RIGHT, cabbageBank, wolfBank, sheepBank));
            } else {
                nextStates.add(new State(Bank.LEFT, wolfBank, sheepBank, cabbageBank));
                nextStates.add(new State(Bank.LEFT, cabbageBank, wolfBank, sheepBank));
                nextStates.add(new State(Bank.LEFT, sheepBank, wolfBank, cabbageBank));
                nextStates.add(new State(Bank.LEFT, wolfBank, cabbageBank, sheepBank));
            }

            if (hunterBank == Bank.LEFT)
                nextStates.add(new State(Bank.RIGHT, wolfBank, sheepBank, cabbageBank));
            else
                nextStates.add(new State(Bank.LEFT, wolfBank, sheepBank, cabbageBank));

            return nextStates;
        }

        @Override
        public String toString() {
            return "State{" +
                    "hunterBank=" + hunterBank +
                    ", wolfBank=" + wolfBank +
                    ", sheepBank=" + sheepBank +
                    ", cabbageBank=" + cabbageBank +
                    '}';
        }
    }

    public static void main(String[] args) {
        State initialState = new State(Bank.LEFT, Bank.LEFT, Bank.LEFT, Bank.LEFT);
        List<State> path = findSolution(initialState);
        if (path != null) {
            for (State state : path) {
                System.out.println(state);
            }
        } else {
            System.out.println("No solution found.");
        }
    }

    public static List<State> findSolution(State initialState) {
        List<State> path = new ArrayList<>();
        path.add(initialState);
        return dfs(initialState, path);
    }

    public static List<State> dfs(State currentState, List<State> path) {
        if (currentState.isGoalState()) {
            return path;
        }

        List<State> nextStates = currentState.getValidNextStates();

        for (State nextState : nextStates) {
            if (!path.contains(nextState)) {
                List<State> newPath = new ArrayList<>(path);
                newPath.add(nextState);
                List<State> result = dfs(nextState, newPath);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }
}
