import java.util.Scanner;
public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        double prisVuxen = 299.90;
        int antalPersoner = 19;
        int[] födelsedatum = new int[antalPersoner];
        //String[] personNamn = new String[antalPersoner];
        menyVal();
        int alternativ = Integer.parseInt(scanner.nextLine());
        while(alternativ!=4){
            switch (alternativ) {
                case 1:
                    födelsedatum = bokaPlats(födelsedatum);
                    break;
                case 2:
                    ledigaPlatser(födelsedatum);

                    break;
                case 3:

                    break;

                default:
                    break;
            }
            menyVal();
            alternativ = Integer.parseInt(scanner.nextLine());
        }

        //while(true){
        //    System.out.println("Välj sittplats nummer för bussresa. Plattser 1-20.");
        //    int sittplats = Integer.parseInt(scanner.nextLine());
         //   if (sittplats<21 && sittplats>0) {
        //        System.out.println("Skriv in namn för bokning. För och Efternamn.");
        //        String namn = scanner.nextLine();
         //       System.out.println("För in födelsedatum");
         //       int datum = Integer.parseInt(scanner.nextLine());
         //       födelsedatum[sittplats]=datum;
         //       personNamn[sittplats]=namn;
        //        break;
        //    }else{
        //        System.out.println("Sittplats "+sittplats+" finns ej, försök igen. ");
        //    }
       // }
        //bussBokning(födelsedatum,personNamn);
    }
    private static void menyVal(){
        System.out.println("Valj alternativ");
        System.out.println("1. Boka en obokad plats:");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4. Avsluta.");
    }
    private static int[] bokaPlats(int[] födelsedatum){
        
        System.out.println("Välj sittplats nummer för bussresa. Plattser 1-20.");
        int sittplats = Integer.parseInt(scanner.nextLine());   
        while(true){
            if (sittplats<21 && sittplats>0) {
                System.out.println("För in födelsedatum");
                int datum = Integer.parseInt(scanner.nextLine());
                if(födelsedatum[sittplats-1]==0){
                    födelsedatum[sittplats-1]=datum;
                    System.out.println("Du har bokat sittpaltsen "+sittplats);
                    break;
                }
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
    private static int bussBokning(int[] födelsedatum){
        
        return 0;
    }
    private static int namnSparande(String[] personNamn){
        
        return 0;
    }
}