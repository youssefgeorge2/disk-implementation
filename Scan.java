package os;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scan {
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

        scan(requests, headPosition);
    }

    private static void scan(List<Integer> requests, int headPosition) {
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

        for (int i = endIndex; i >= startIndex; i--) {
            int currentRequest = sortedRequests.get(i);
            System.out.println("Processing request: " + currentRequest);
            totalSeekOperations += Math.abs(currentRequest - currentHeadPosition);
            currentHeadPosition = currentRequest;
        }

        if (startIndex != 0) {
            System.out.println("Processing request: " + sortedRequests.get(startIndex - 1));
            totalSeekOperations += Math.abs(sortedRequests.get(startIndex - 1) - currentHeadPosition);
            currentHeadPosition = sortedRequests.get(startIndex - 1);
        }

        System.out.println("Total seek operations: " + totalSeekOperations);
    }
}
