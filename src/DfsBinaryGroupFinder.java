import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DfsBinaryGroupFinder implements BinaryGroupFinder {
   /**
    * Finds connected pixel groups of 1s in an integer array representing a binary image.
    * 
    * The input is a non-empty rectangular 2D array containing only 1s and 0s.
    * If the array or any of its subarrays are null, a NullPointerException
    * is thrown. If the array is otherwise invalid, an IllegalArgumentException
    * is thrown.
    *
    * Pixels are considered connected vertically and horizontally, NOT diagonally.
    * The top-left cell of the array (row:0, column:0) is considered to be coordinate
    * (x:0, y:0). Y increases downward and X increases to the right. For example,
    * (row:4, column:7) corresponds to (x:7, y:4).
    *
    * The method returns a list of sorted groups. The group's size is the number 
    * of pixels in the group. The centroid of the group
    * is computed as the average of each of the pixel locations across each dimension.
    * For example, the x coordinate of the centroid is the sum of all the x
    * coordinates of the pixels in the group divided by the number of pixels in that group.
    * Similarly, the y coordinate of the centroid is the sum of all the y
    * coordinates of the pixels in the group divided by the number of pixels in that group.
    * The division should be done as INTEGER DIVISION.
    *
    * The groups are sorted in DESCENDING order according to Group's compareTo method.
    * 
    * @param image a rectangular 2D array containing only 1s and 0s
    * @return the found groups of connected pixels in descending order
    */
    @Override
    public List<Group> findConnectedGroups(int[][] image) {
        //Inputs: Rectangular array of 1s and 0s
        if(image == null) throw new NullPointerException("Error: Image passed into findConnectedGroups was read as null");

        boolean[][] visited = new boolean[image.length][image[0].length];
        List<Group> groups = new LinkedList<>();

        for(int row = 0; row < image.length; row++) {
            if(image[row] == null) throw new NullPointerException("Error: Image passed into findConnectedGroups read a pixel as null");
            for(int col = 0; col < image[row].length; col++) {
                for(Group n : constructGroupFromConnected(image, new int[]{row, col}, visited)){
                    groups.add(n);
                }        
            }
        }

        Collections.sort(groups, Collections.reverseOrder());
        return groups;
    }

    private List<Group> constructGroupFromConnected(int[][] image, int[] current, boolean[][] visited){
        if(visited[current[0]][current[1]] == true || image[current[0]][current[1]] == 0) return new LinkedList<>();
        visited[current[0]][current[1]] = true;

        List<Group> groups = new LinkedList<>();
        Group madeGroup = makeGroupFromCoordinate(image, new Coordinate(current[1], current[0]), visited);
        groups.add(madeGroup);
        return groups;
    }

    private Group makeGroupFromCoordinate(int[][] image, Coordinate current, boolean[][] visited) {
        boolean[][] visitedMap = collectVisited(image, new boolean[image.length][image[0].length], current);

        for (int i = 0; i < visitedMap.length; i++) {
            for(int j = 0; j < visitedMap[0].length; j++) {
                if(visitedMap[i][j]) visited[i][j] = true;
            }
        }

        int spaceCount = countTrues(visitedMap);
        Coordinate centroid = getCentroid(visitedMap);
        Group result = new Group(spaceCount, centroid);
        return result;
    }

    private boolean[][] collectVisited(int[][] image, boolean[][] visited, Coordinate current){
        if(visited[current.y()][current.x()] == true) return visited;
        visited[current.y()][current.x()] = true;

        int[][] directions = {
            {current.x() + 1, current.y()},
            {current.x(), current.y() - 1},
            {current.x() - 1, current.y()},
            {current.x(), current.y() + 1},
        };

        for(int[] direction : directions){
            if(direction[0] < 0 || direction[0] >= image[0].length
                || direction[1] < 0 || direction[1] >= image.length
                || image[direction[1]][direction[0]] == 0) continue;
            visited = collectVisited(image, visited, new Coordinate(direction[0], direction[1]));
        }
        return visited;
    }

    private int countTrues(boolean[][] visited){
        int total = 0;
        for(boolean[] n : visited){
            for(boolean i : n){
                if(i == true) total++;
            }
        }
        return total;
    }

    private Coordinate getCentroid(boolean[][] visited){
        int sumX = 0;
        int sumY = 0;
        int totalCount = 0;

        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++){
                if(visited[i][j] == true){
                  sumX += j;
                  sumY += i;
                  totalCount++;  
                }
            }
        }
        return new Coordinate(sumX / totalCount, sumY / totalCount);
    }
}
