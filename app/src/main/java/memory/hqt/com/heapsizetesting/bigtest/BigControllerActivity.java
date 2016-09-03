package memory.hqt.com.heapsizetesting.bigtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import memory.hqt.com.heapsizetesting.core.InfoActivity;

/**
 * Created by Huynh Quang Thao on 8/16/16.
 */
public class BigControllerActivity extends InfoActivity {

    private final String text = "When assigning large memory, system will throw OutOfMemory Exception";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoTextView.setText(text);

        processButton.setText("Allocated Large Memory");
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BigControllerActivity.this, BigActivity.class);
                startActivity(intent);
            }
        });
    }
}
