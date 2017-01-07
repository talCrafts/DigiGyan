package org.talcrafts.digigyan.sharing;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import org.talcrafts.digigyan.R;
import org.talcrafts.digigyan.activity.BaseAcitivity;

import java.util.EnumMap;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class QRSendActivity extends BaseAcitivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrsend);
        ImageView imageView = (ImageView) findViewById(R.id.qrCode);
        imageView.setImageBitmap(encode("Anaya Ashish"));
    }

    private Bitmap encode(String data) {
        BarcodeFormat format = BarcodeFormat.QR_CODE;
        EnumMap<EncodeHintType, Object> hint = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
        hint.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix result = null;
        try {
            result = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500, hint);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }
        Bitmap bit = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bit.setPixels(pixels, 0, w, 0, 0, w, h);
        ImageView imageView = (ImageView) findViewById(R.id.qrCode);
        imageView.setImageBitmap(bit);
        return bit;
    }
}
