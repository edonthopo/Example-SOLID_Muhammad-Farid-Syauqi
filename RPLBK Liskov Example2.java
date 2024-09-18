
class File {

    public void write(String content) {

        System.out.println("Writing: " + content);

    }



    public void read() {

        System.out.println("Reading file...");

    }

}



class ReadOnlyFile extends File {

    @Override

    public void write(String content) {

        throw new UnsupportedOperationException("Cannot write to a read-only file.");

    }

}



public class Main {

    public static void main(String[] args) {

        File file = new File();

        file.write("This is a normal file");

        file.read();

        

        File readOnlyFile = new ReadOnlyFile();

        readOnlyFile.read();

        

        try {

            readOnlyFile.write("This will throw an exception"); // Pelanggaran LSP

        } catch (UnsupportedOperationException e) {

            System.out.println("Error: " + e.getMessage());

        }

    }
}