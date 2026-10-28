import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void main(String[] args) {

        String text = "https://www.google.com";

        String filePath = "myqr.png";

        int width = 300;
        int height = 300;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(
                    text,
                    BarcodeFormat.QR_CODE,
                    width,
                    height);

            Path path = FileSystems.getDefault().getPath(filePath);

            MatrixToImageWriter.writeToPath(
                    bitMatrix,
                    "PNG",
                    path);

            System.out.println("QR Code generated successfully!");
            System.out.println("Saved as: " + filePath);

        } catch (WriterException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
