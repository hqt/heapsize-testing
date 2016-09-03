package memory.hqt.com.heapsizetesting.servicetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import memory.hqt.com.heapsizetesting.core.InfoActivity;
import memory.hqt.com.heapsizetesting.mediumtest.MediumActivity;
import memory.hqt.com.heapsizetesting.servicetest.MediumService;

public class ServiceControllerActivity extends InfoActivity {

    private final String text = "Assigning medium memory for one activity or one service doesn't throw exception.\n" +
            "But when we allocate memory for both activity and service, total memory exceed allow memory." +
            " System will throw OutOfMemory Exception";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoTextView.setText(text);

        processButton.setText("Allocate medium memory for activity and service");
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start medium size service
                startService(new Intent(getBaseContext(), MediumService.class));

                // start medium size activity
                // exception always throw at second allocation.
                Intent intent = new Intent(getBaseContext(), MediumActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        stopService(new Intent(getBaseContext(), MediumService.class));
        super.onStop();
    }
}
