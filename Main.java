//package Assignmet3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Output output = new Output();

        input.admissionreader("admission.txt");
        input.clientreader("patient.txt");
        output.admissionreset();
        output.clientreset();
        output.hospitaloutputreset();
        input.reader(args[0]);
    }
}
