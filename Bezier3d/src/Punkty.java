import java.io.*;
import java.util.Scanner;

public class Punkty {
    File fileBefore = new File("czajnik.txt");
    File fileAfter = new File("czajnikAfter.txt");
    Scanner scanner = new Scanner(fileBefore);
    BufferedWriter plik = new BufferedWriter(new FileWriter(fileAfter));
    Czajnik[][] Punkt = new Czajnik[4][4];
    //konstruktor obsługujący wyjątek braku pliku
    public Punkty() throws IOException {
    }


    public void PunktyBeziera() throws IOException {
        double x,y,z;
        //wczytujemy ilosc plaszczyzn
        int iloscPlaszczyzn = scanner.nextInt();

        //dopisek do kolejnego pliku na początek by nie robic tego potem w paraview
        plik.write("x, y, z"+System.lineSeparator());
        //for po ilosci plaszczyzn
        for(int ilosc=0;ilosc<iloscPlaszczyzn;ilosc++){
            //przechodzmy po punktach kontrolnych
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    double tempx = Double.parseDouble(scanner.next());
                    double tempy = Double.parseDouble(scanner.next());
                    double tempz = Double.parseDouble(scanner.next());
                    Punkt[i][j] = new Czajnik(tempx,tempy,tempz);
                }
            }
            //tworzymy 100 punktów dla każdego koordynatu
            for(double v=0.0;v<=1.0;v+=0.01) {
                for(double w=0.0;w<=1.0;w+=0.01){
                    x=0.0;
                    y=0.0;
                    z=0.0;
                    for (int i=0;i<4;i++){
                        for(int j=0; j<4 ;j++){
                            //wzór przepisany z języka matematycznego na język programowania
                            x += Punkt[i][j].x * Czajnik.berstein(3,i,w) * Czajnik.berstein(3,j,v);
                            y += Punkt[i][j].y * Czajnik.berstein(3,i,w) * Czajnik.berstein(3,j,v);
                            z += Punkt[i][j].z * Czajnik.berstein(3,i,w) * Czajnik.berstein(3,j,v);
                        }
                    }
                    plik.write(x+","+y+","+z+System.lineSeparator());
                }
            }
        }
        plik.close();


    }



}
