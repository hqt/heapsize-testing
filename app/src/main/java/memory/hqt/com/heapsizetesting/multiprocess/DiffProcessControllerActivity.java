package memory.hqt.com.heapsizetesting.multiprocess;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import memory.hqt.com.heapsizetesting.R;
import memory.hqt.com.heapsizetesting.core.InfoActivity;
import memory.hqt.com.heapsizetesting.mediumtest.MediumActivity;
import memory.hqt.com.heapsizetesting.servicetest.MediumService;

public class DiffProcessControllerActivity extends InfoActivity {

    private final String text = "Assigning medium memory for both activity and service will throw exception.\n" +
            "But when we allocate memory for activity and service on different process, " +
            " each component memory is less than allow memory for each process, so system doesn't throw OutOfMemoryException" +
            " We can try this example as many as we want";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoTextView.setText(text);

        processButton.setText("Allocate medium memory for activity and service on different process");
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start medium size service on different process
                startService(new Intent(getBaseContext(), DifferentProcessService.class));

                // start medium size activity
                Intent intent = new Intent(getBaseContext(), MediumActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        stopService(new Intent(getBaseContext(), DifferentProcessService.class));
        super.onStop();
    }
}
