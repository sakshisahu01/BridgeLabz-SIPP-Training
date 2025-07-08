package StackAndQueues;

public class CircularTourProblem {
	
	

	    // Function to return starting point index
	    public static int findStartingPump(int[] petrol, int[] distance) {
	        int n = petrol.length;

	        int total_surplus = 0;  // total petrol - distance
	        int current_surplus = 0;
	        int start = 0;

	        for (int i = 0; i < n; i++) {
	            int diff = petrol[i] - distance[i];
	            total_surplus += diff;
	            current_surplus += diff;

	            // If current surplus goes negative, reset start point
	            if (current_surplus < 0) {
	                start = i + 1;
	                current_surplus = 0;
	            }
	        }

	        // If total petrol is enough to cover total distance
	        return (total_surplus >= 0) ? start : -1;
	    }

	    public static void main(String[] args) {
	        int[] petrol =  {4, 6, 7, 4};
	        int[] distance = {6, 5, 3, 5};

	        int start = findStartingPump(petrol, distance);
	        if (start == -1)
	            System.out.println("No possible tour");
	        else
	            System.out.println("Start at pump: " + start);
	    }
	}


