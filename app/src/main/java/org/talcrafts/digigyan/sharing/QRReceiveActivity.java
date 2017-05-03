package org.talcrafts.digigyan.sharing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import org.talcrafts.digigyan.R;
import org.talcrafts.digigyan.activity.BaseAcitivity;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRReceiveActivity extends BaseAcitivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        //setContentView(R.layout.activity_qrreceive);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
//        TextView textView=(TextView)findViewById(R.id.question_text_view);
//        textView.setText(result.getText());
        Log.v("RE<", result.getText()); // Prints syncResult results
        Log.v("RE<", result.getBarcodeFormat().toString());
    }
}
