import java.util.Scanner;
public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] argsStrings) throws Exception {
       // double prisVuxen = 299.90;
        int antalPersoner = 19;
        int[] födelsedatum = new int[antalPersoner];
      //  String[] personNamn = new String[antalPersoner];  
        menyVal();
        int alternativ = Integer.parseInt(scanner.nextLine());
        while(alternativ!=5){
            switch (alternativ) {
                case 1:
                    födelsedatum = bokaPlats(födelsedatum);
                    break;
                case 2:
                    ledigaPlatser(födelsedatum);
                    break;
                case 3:
                   // vinster(prisVuxen);
                    break;
                case 4:

                default:
                    break;
            }
            menyVal();
            alternativ = Integer.parseInt(scanner.nextLine());
        }

    }
    private static void menyVal(){
        System.out.println("Valj alternativ");
        System.out.println("1. Boka en obokad plats");
        System.out.println("2. Visa bokade platser");
        System.out.println("3. Beräkna vinster");
        System.out.println("4. Hitta bokning");
        System.out.println("5. Avsluta.");
    }
    public static int[] bokaPlats(int[] födelsedatum){
        
        System.out.println("Välj sittplats nummer för bussresa. Plattser 1-20.");
        int sittplats = Integer.parseInt(scanner.nextLine());   
        while(true){
            if (sittplats<21 && sittplats>0) {
                System.out.println("För in födelsedatum");
                int datum = Integer.parseInt(scanner.nextLine());
                if (datum>20240501) {
                    System.out.println("Detta datum finns ej, skriv in giltig födelsedatum");
                    datum = Integer.parseInt(scanner.nextLine());
                }
                if(födelsedatum[sittplats-1]==0){
                    födelsedatum[sittplats-1]=datum;
                    System.out.println("Du har bokat sittpaltsen "+sittplats);
                    break;
                }
              //  System.out.println("Skriv in namn för bokning. För och Efternamn.");
             //   String namn = scanner.nextLine();
                //personNamn[sittplats-1]=namn;
                //bokaPlats(födelsedatum, personNamn);
            }else{
                System.out.println("Sittplats "+sittplats+" finns ej, försök igen. ");
                sittplats = Integer.parseInt(scanner.nextLine()); 
            }
        }
        return födelsedatum;
    }
    private static void ledigaPlatser(int[] födelsedatum){
        for (int index = 0; index < födelsedatum.length; index++) {
            System.out.println(födelsedatum[index]);
        }

    }
   // private static double vinster(int vuxnabiljättSålda, int barnbiljättSålda){ //antalet vuxa biljätter sålda och antalet bar
    //    double prisVuxen = 299.90;
      //  double prisBarn = 199.90;
      //  }
  //  }
   // public static String[] namnSparande(String[] personNamn){
       // System.out.println("Skriv in ditt fullständiga namn");
      //  double fulltNamn = Integer.parseInt(scanner.nextLine());
      //  System.out.println("Du har skrivit in namnet "+fulltNamn);
      //  return personNamn;
    //}
}
