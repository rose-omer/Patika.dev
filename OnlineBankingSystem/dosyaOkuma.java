import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class dosyaOkuma {

    public static void main(String[] args) {
        try {
            // JSON dosyasını oku
            Scanner scanner = new Scanner(new FileReader("OnlineBankingSystem/src/kullanicilar.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonBuilder.append(scanner.nextLine());
            }
            scanner.close();

            // JSON stringini al
            String json = jsonBuilder.toString();

            // JSON stringini işle
            // Burada JSON stringini parse ederek kullanıcı bilgilerini alabilirsiniz
            System.out.println(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
