import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class sprinto_darbas_1 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Įveskite savo vardą");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Įveskite savo pavardę");
        String userSurname = myObj.nextLine();
        System.out.println("Įveskite savo amžių");
        String userAge = myObj.nextLine();

        


        // ... writting to files
        File relativeFile2 = new File("./data/import.csv");
        FileWriter fw = null;
        try {
            fw = new FileWriter(relativeFile2);
            BufferedWriter bw = new BufferedWriter(fw);
            // writting file with newline
            String fileLine2 = userName;
            bw.write(fileLine2 + " " + userSurname + " " + userAge);
//            bw.write("\n");
//
//            bw.write(userSurname);
//            bw.newLine();
//
//            bw.write(userAge);
//            bw.write("\n");

            // bw.flush();
            bw.close(); // close automatically flushes the buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Skaitome 'import.csv' faile irasytus duomenis ir juos isvedame i console.");

        // ... skaitome failą, kuriame daug eilučių (vieną po kitos)
        File relativeFileMultiLine = new File("./data/import.csv");
        try {
            FileReader fileReader = new FileReader(relativeFileMultiLine);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) { // žiūrome ar perskaityta eilutė nėra tuščia
                // System.out.println(fileLine); // spausdiname visą eilutę
                // String[] splitString = fileLine.split(" ");
                String[] splitString = fileLine.split("\\s;|\\s|;");
                System.out.println(Arrays.toString(splitString));
                fileLine = bufferedReader.readLine(); // skaitome sekančią eilutę
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("Jūsų vardas yra: " + userName);  // Output user input
//        System.out.println("Jūsų pavardė yra: " + userSurname);  // Output user input
//        System.out.println("Jūsų amžius yra: " + userAge);  // Output user input
    }
}

