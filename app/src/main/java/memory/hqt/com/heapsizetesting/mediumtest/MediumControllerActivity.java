package memory.hqt.com.heapsizetesting.mediumtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import memory.hqt.com.heapsizetesting.bigtest.BigActivity;
import memory.hqt.com.heapsizetesting.core.InfoActivity;

/**
 * Created by Huynh Quang Thao on 8/16/16.
 */
public class MediumControllerActivity extends InfoActivity {
    private final String text = "When assigning medium memory, system won't throw OutOfMemory Exception. We can try as many as we want.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoTextView.setText(text);

        processButton.setText("Allocated Medium Memory");
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediumControllerActivity.this, MediumActivity.class);
                startActivity(intent);
            }
        });
    }
}
