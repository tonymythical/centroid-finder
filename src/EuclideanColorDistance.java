public class EuclideanColorDistance implements ColorDistanceFinder {
    /**
     * Returns the euclidean color distance between two hex RGB colors.
     * 
     * Each color is represented as a 24-bit integer in the form 0xRRGGBB, where
     * RR is the red component, GG is the green component, and BB is the blue component,
     * each ranging from 0 to 255.
     * 
     * The Euclidean color distance is calculated by treating each color as a point
     * in 3D space (red, green, blue) and applying the Euclidean distance formula:
     * 
     * sqrt((r1 - r2)^2 + (g1 - g2)^2 + (b1 - b2)^2)
     * 
     * This gives a measure of how visually different the two colors are.
     * 
     * @param colorA the first color as a 24-bit hex RGB integer
     * @param colorB the second color as a 24-bit hex RGB integer
     * @return the Euclidean distance between the two colors
     */
    @Override
    public double distance(int colorA, int colorB) {
        int bracket1 = getR(colorA) - getR(colorB);
        int bracket2 = getG(colorA) - getG(colorB);
        int bracket3 = getB(colorA) - getB(colorB);
        int bracket4 = (int) Math.sqrt(((bracket1)*(bracket1)) + ((bracket2)*(bracket2)) + ((bracket3)*(bracket3)));
        return bracket4;
    }

    public int getR(int color){
        String col = Integer.toString(color);
        int num = Character.getNumericValue(col.charAt(2) + col.charAt(3));
        return num;
    }
    public int getG(int color){
        String col = Integer.toString(color);
        int num = Character.getNumericValue(col.charAt(4) + col.charAt(5));
        return num;
    }
    public int getB(int color){
        String col = Integer.toString(color);
        int num = Character.getNumericValue(col.charAt(6) + col.charAt(7));
        return num;
    }
}
