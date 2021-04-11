public class Czajnik {
    double x,y,z;
    //konstruktor przypisujący koordynaty x y z do danego punktu figury
    public Czajnik(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    // funkcja obsługująca newtona rekurencyjnie
    static int symbolNewtona(int n, int k)
    {
        if (k == 0 || k == n)
            return 1;
        else
            return symbolNewtona(n-1, k-1) + symbolNewtona(n-1, k);
    }
    //bernstein przepisany z wzoru matematycznego na język programowania
    static Double berstein(int m, int i, double v){
        return symbolNewtona(m,i) * Math.pow(v,i) * Math.pow(1-v,m-i);
    }
    @Override
    public String toString(){
        return "("+x+","+y+","+z+")";
    }
}
