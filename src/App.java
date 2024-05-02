import java.util.Scanner;
public class App {
    private static final double PRIS_PER_PLATS_VUXEN = 299.90;
    private static final double PRIS_PER_PLATS_BARN = 149.90;
    private static final int ANTAL_PERSONER = 20;
    private static int[] födelsedatum = new int[ANTAL_PERSONER];
    public static void main(String[] argsStrings) throws Exception {
        Scanner scanner = new Scanner(System.in);
        menyVal();
        int alternativ = Integer.parseInt(scanner.nextLine());
        while(alternativ!=8){
            switch (alternativ) {
                case 1:
                    födelsedatum = bokaPlats(scanner);
                    break;
                case 2:
                    ledigaPlatser();
                    break;
                case 3:
                    vinster(scanner);
                    break;
                case 4:
                    hittaBokning(scanner);
                    break;
                case 5:
                    födelsedatum=avboka(scanner);
                    break;
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
        System.out.println("5. Avboka bokad platts.");
        System.out.println(". Avsluta.");
    }
    public static int[] bokaPlats(Scanner scanner){
        try {
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
                }else{
                    System.out.println("Sittplats "+sittplats+" finns ej, försök igen. ");
                    sittplats = Integer.parseInt(scanner.nextLine()); 
                }
            }
        } catch (Exception e) {
            System.out.println("Fel datum, detta datum har ej varit");
        }        
        return födelsedatum;
    }
    private static void ledigaPlatser(){
        for (int index = 0; index < födelsedatum.length; index++) {
            System.out.println(födelsedatum[index]);
        }

    }
    private static void vinster(Scanner scanner){ //antalet vuxa biljätter sålda och antalet bar
        double prisVuxen = 299.90;
        double prisBarn = 149.90;
        double summa = 0;
        for(int i = 0; i<födelsedatum.length; i++){
            if(födelsedatum[i]!=0){
                if(födelsedatum[i]<20070000){
                    summa+=prisVuxen;
                }else{
                    summa+=prisBarn;
                }
            }
        }
        System.out.println("Vinsten av sålda biljätter är: "+summa);
    }
    private static void hittaBokning(Scanner scanner){
        try {
            System.out.println("Ange personnummer för att hitta bokning av sittplats.");
            int personnummer = Integer.parseInt(scanner.nextLine());  
            for(int i = 0; i<födelsedatum.length;i++){
                if(födelsedatum[i]==personnummer){
                    System.out.println("Denna person har bokat platsen: "+(i+1));
                    return;
                }
            }
            System.out.println("Det finns ingen bokning under detta personnummer.");
        } catch (Exception e) {
            System.out.println("Fel format av datum, försök (YYYYMMDD).");
        }
    }
    private static int[] avboka(Scanner scanner){
        System.out.println("Ange personnumret du vill avboka.");
        int personnummer = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < födelsedatum.length; i++) {
            if (personnummer == födelsedatum[i]) {
                födelsedatum[i] = 0;
                System.out.println("Du har avbokat plats: "+(i+1) + ".");
                return födelsedatum;
            }
        }
        System.out.println("Gick inte att hitta bokning.");
        return födelsedatum;
    }
}