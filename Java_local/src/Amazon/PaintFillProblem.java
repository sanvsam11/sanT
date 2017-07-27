package Amazon;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 27/07/17.
 */
class pixel{
    int colorCode;
    private int x,y;
    pixel(int a,int b){
        x = a;
        y = b;
    }
    pixel(int a,int b,int color){
        x = a;
        y = b;
        colorCode = color;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class PaintFillProblem {
    pixel grid[][];
    PaintFillProblem(int n){
        grid = new pixel[n][n];
    }
    public void generateNewGrid(){
        Random r = new Random();
        for(int x=0;x<grid.length;x++)
            for(int y=0;y<grid.length;y++)
                grid[x][y] = new pixel(x,y,r.nextInt(4));
    }
    boolean checkXY(int x,int y){
        return x>=0&&y>=0&&x<grid.length&&y<grid.length;
    }
    void filler(int x,int y,int currentColour,int newColour){

        if(!checkXY(x,y)||grid[x][y].getColorCode()!=currentColour)
            return;
        else{
            grid[x][y].setColorCode(newColour);
            filler(x,y+1,currentColour,newColour);
            filler(x,y-1,currentColour,newColour);
            filler(x+1,y,currentColour,newColour);
            filler(x-1,y,currentColour,newColour);
        }
    }
    public void fillColourMethod(int x,int y,int colourCode){
        if(checkXY(x,y))
            filler(x,y,grid[x][y].getColorCode(),colourCode);
    }
    public void printGrid(){
        for(int x=0;x<grid.length;x++) {
            for (int y = 0; y < grid.length; y++)
                System.out.print(grid[x][y].getColorCode()+" ");
            System.out.println();
        }
    }
    public static void main(String ar[]){
        PaintFillProblem instance = new PaintFillProblem(10);
        instance.generateNewGrid();
        instance.printGrid();
        instance.fillColourMethod(0,0,(instance.grid[0][0].getColorCode()+2)%3);
        System.out.println();
        instance.printGrid();
    }
}
