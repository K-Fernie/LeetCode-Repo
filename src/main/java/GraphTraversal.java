import java.util.HashMap;
import java.util.Map;

public class GraphTraversal {
//    public static void main(String[] args) {
//        int[][] twoDArray = { { 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0} };
//        int n = 2;
//        System.out.println(countCellsWithinSteps(twoDArray, n));
//    }

    public static void main(String[] args) {
        int[][] twoDArray = { { 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0} };
        System.out.println(countCellsWithinSteps(twoDArray, 1));
    }

    public static int countCellsWithinSteps(int[][] arr, int n) {
            int count = 0;
            Map<String, CellNode> nodeMap = generateNodeMap(arr);
            for(Map.Entry<String, CellNode> entry: nodeMap.entrySet()){
                if(entry.getValue().val > 0){
                    count+=stepsUp(entry.getValue(), n, nodeMap, arr.length - 1);
                    count+=stepsDown(entry.getValue(),n);
                    count+=stepsRight(entry.getValue(), n);
                    count+=stepsLeft(entry.getValue(),n);
                }
            }
            return count;
    }

    public static int stepsUp(CellNode node, int n, Map<String, CellNode> nodeMap, int y){
        int count = 0;
        CellNode currNode = node;

            if(currNode.up == null){
                currNode = nodeMap.get(String.format("%s%s", currNode.x, y));
                if(!currNode.counted){
                     count++;
                     currNode.setCounted(true);
            }
        }

        for(int i = 0; i < n; i++){
            if(currNode.up!=null && !currNode.up.counted){
                count++;
                currNode.up.setCounted(true);
            }
            currNode = currNode.up;
        }
        return count;
    }

    public static int stepsDown(CellNode node, int n){
        int count = 0;
        CellNode currNode = node;

        if(currNode.down == null){
            return count;
        }

        for(int i = 0; i < n; i++){
            if(currNode.down!=null && !currNode.down.counted){
                count++;
                currNode.down.setCounted(true);
            }
            currNode = currNode.down;
        }
        return count;
    }

    public static int stepsRight(CellNode node, int n){
        int count = 0;
        CellNode currNode = node;
        if(currNode.right == null){
            return count;
        }
        for(int i = 0; i < n; i++){
            if(currNode.right!=null && !currNode.right.counted){
                count++;
                currNode.right.setCounted(true);
            }
            currNode = currNode.right;
        }
        return count;
    }

    public static int stepsLeft(CellNode node, int n){
        int count = 0;
        CellNode currNode = node;
        if(currNode.left == null){
            return count;
        }
        for(int i = 0; i < n; i++){
            if(currNode.left!=null && !currNode.left.counted){
                count++;
                currNode.left.setCounted(true);
            }
            currNode = currNode.left;
        }
        return count;
    }



    public static Map<String, CellNode> generateNodeMap(int[][] arr) {
        Map<String, CellNode> nodeMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){

                String indexString = String.format("%s%s",i,j);
                CellNode index;
                if(nodeMap.containsKey(indexString)){
                    index = nodeMap.get(indexString);
                }else {
                    index = new CellNode(i, j, arr[i][j]);
                    nodeMap.put(indexString, index);
                }


                CellNode up = i == 0 ? null: new CellNode(i - 1, j, arr[i-1][j]);
                if(up!=null)
                {
                    String upKey = String.format("%s%s",up.x, up.y);
                    if (!nodeMap.containsKey(upKey)) {
                        nodeMap.put(upKey, up);
                    }
                    index.up = nodeMap.get(upKey);
                }


                CellNode down = i == arr.length - 1? null: new CellNode(i+1, j, arr[i+1][j]);
                if(down!=null){
                    String downKey = String.format("%s%s", down.x, down.y);
                    if (!nodeMap.containsKey(downKey)) {
                        nodeMap.put(downKey, down);
                    }
                    index.down = nodeMap.get(downKey);
                }

                CellNode left = j == 0 ? null: new CellNode(i,j-1, arr[i][j-1]);
                if(left!=null){
                    String leftKey = String.format("%s%s", left.x, left.y);
                    if (!nodeMap.containsKey(leftKey)) {
                        nodeMap.put(leftKey, down);
                    }
                    index.left = nodeMap.get(leftKey);
                }

                CellNode right = j == arr[i].length - 1? null: new CellNode(i, j+1, arr[i][j+1]);
                if(right!=null){
                    String rightKey = String.format("%s%s",right.x, right.y);
                    if (!nodeMap.containsKey(rightKey)) {
                        nodeMap.put(rightKey, right);
                    }
                    index.right = nodeMap.get(rightKey);
                }
            }
        }
        return nodeMap;
    }

    private static class CellNode{
        int val;
        int x;
        int y;
        CellNode up;
        CellNode down;
        CellNode left;
        CellNode right;
        boolean counted = false;

        CellNode(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public void setCounted(boolean counted){
            this.counted = counted;
        }

        @Override
        public int hashCode(){
            final int prime = 31;
            int result = 1;
            result = prime * result + x + y;
            return result;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;
            if(obj == null)
                return false;
            if(getClass() != obj.getClass())
                return false;
            CellNode node = (CellNode) obj;
            if(node.x != this.x || node.y != this.y)
                return false;
            return true;
        }
        }
    }
