import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException {
        String inPath = "input.txt";
        String outPath = "output.txt";

        FileInputStream input = new FileInputStream(inPath);
        InputStreamReader reader = new InputStreamReader(input);        //read from file
        BufferedReader buff = new BufferedReader(reader);

        FileWriter output = new FileWriter(outPath); // write to file

        while (buff.ready()) {
            String[] str = buff.readLine().split(",");

            switch (str[0]) {
                case "u" ->    // updates
                        Action.update(str[3], str[1], str[2]);   // update(action, price, size)
                case "o" ->  // operations
                        Action.operation(str[1], str[2]);        // update(action, price, size)
                case "q" -> {  //questions

                    if (str[1].equals("size")) {
                        Action.questionSize(str[2], output);
                    } else Action.question(str[1], output);
                }
            }
        }
        output.close();
    }

}
