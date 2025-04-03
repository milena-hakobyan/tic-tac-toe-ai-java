import java.util.Arrays;

class ArrayOperations {
    public static int[][][] createCube() {
        int[][][] cube = new int[3][3][3];
        for(int i = 0; i < cube.length; i++){
            int l = 0;
            for (int j = 0; j < cube[i].length; j++){
                for(int k = 0; k < cube[i][j].length; k++){
                    cube[i][j][k] = l++;
                }
            }

        }
        return cube;
    }

}