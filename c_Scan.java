package os;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c_Scan {
    public static void main(String[] args) {
        List<Integer> requests = new ArrayList<>();
        requests.add(98);
        requests.add(183);
        requests.add(37);
        requests.add(122);
        requests.add(14);
        requests.add(124);
        requests.add(65);
        requests.add(67);

        int headPosition = 53;
        int totalCylinder = 200;

        cScan(requests, headPosition, totalCylinder);
    }

    private static void cScan(List<Integer> requests, int headPosition, int totalCylinder) {
        List<Integer> sortedRequests = new ArrayList<>(requests);
        Collections.sort(sortedRequests);

        int totalSeekOperations = 0;
        int currentHeadPosition = headPosition;

        int startIndex = 0;
        int endIndex = sortedRequests.indexOf(headPosition);

        if (endIndex == -1) {
            for (int i = 0; i < sortedRequests.size(); i++) {
                if (sortedRequests.get(i) > headPosition) {
                    endIndex = i;
                    break;
                }
            }
            if (endIndex == -1)
                endIndex = sortedRequests.size();
        }

        for (int i = endIndex; i < sortedRequests.size(); i++) {
            int currentRequest = sortedRequests.get(i);
            System.out.println("Processing request: " + currentRequest);
            totalSeekOperations += Math.abs(currentRequest - currentHeadPosition);
            currentHeadPosition = currentRequest;
        }

        if (startIndex != 0) {
            System.out.println("Moving head to 0");
            totalSeekOperations += Math.abs(0 - currentHeadPosition);
            currentHeadPosition = 0;
        }

        for (int i = startIndex; i < endIndex; i++) {
            int currentRequest = sortedRequests.get(i);
            System.out.println("Processing request: " + currentRequest);
            totalSeekOperations += Math.abs(currentRequest - currentHeadPosition);
            currentHeadPosition = currentRequest;
        }

        System.out.println("Total seek operations: " + totalSeekOperations);
    }
}

