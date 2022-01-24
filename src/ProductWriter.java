import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {

    String ID = "";
    String Name = "";
    String Description = "";
    Double Cost = 0.0;
    String AddToArray = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Product> recs = new ArrayList<>();

        boolean done = false;
        do {
            String ID = SafeInput.getRegExString(in, "What is the product's ID? ", "^00000\\d$");
            String Name = SafeInput.getNonZeroLenString(in, "What is the product's name? ");
            String Description = SafeInput.getNonZeroLenString(in, "What is the product's description? ");
            Double Cost = SafeInput.getDouble(in, "What is the product's cost? ");
            Product x = new Product(ID, Name, Description, Cost);

            recs.add(x);
            done = SafeInput.getYNConfirm(in, "Are you done?");
        } while (!done);

        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\ProductTestData.txt");

        // use the toolkit to get the current working directory of the IDE
        // will create the file within the Netbeans project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product rec : recs)
            {
                String r = rec.toCSVDataRecord();
                writer.write(r, 0, r.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
