package memory.hqt.com.heapsizetesting.core;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import memory.hqt.com.heapsizetesting.R;

/**
 * Get information about heap size of memory
 */
public class InfoActivity extends AppCompatActivity {

    private final String text = "Max Allow Memory: " + HeapTestApplication.getMaxAllowMemory() + " MB\n" +
                                "Real Allow Memory: " + HeapTestApplication.getRealAllowMemory() + " MB\n" +
                                "Available Memory: " + HeapTestApplication.getAvailableMemory() + " MB\n" +
                                "Total Memory: " + HeapTestApplication.getTotalMemory() + " MB";

    protected Button processButton;
    protected TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        processButton = (Button) findViewById(R.id.process_button);
        infoTextView = (TextView) findViewById(R.id.infor_text_view);

        infoTextView.setText(text);

        processButton.setText("Back To main screen");
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void displayAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        InfoActivity.this.finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
