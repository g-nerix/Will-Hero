package sample;

public class gameObject {
    private coordinate c;
    private coordinate boundary[] = new coordinate[4];

    public coordinate getC() {
        return c;
    }

    public void setC(coordinate c) {
        this.c = c;
    }

    public coordinate[] getBoundary() {
        return boundary;
    }

    public void setBoundary(coordinate[] boundary) {
        this.boundary = boundary;
    }
    public void printBoundary(){
        for (int i = 0; i<4;i++){
            System.out.print("("+this.boundary[i].getX()+","+this.boundary[i].getY()+") ");
        }
        System.out.println();
    }
}
