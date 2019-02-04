package ca.nbcc.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count_;
    private TextView showCount_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCount_ = (TextView)findViewById(R.id.txt_count);

        if (savedInstanceState != null) {
            count_ = savedInstanceState.getInt("currentCount");
            showCount_.setText(Integer.toString(count_));
        }
    }

    public void countUp(View view) {
        ++count_;

        if (showCount_ != null) {
            showCount_.setText(Integer.toString(count_));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("currentCount", count_);
    }
}
