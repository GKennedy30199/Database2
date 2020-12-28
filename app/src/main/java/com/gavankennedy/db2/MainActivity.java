package com.gavankennedy.db2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import android.os.Bundle;

public class MainActivity extends ListActivity {
        private CommentsDataSource datasource;
        public EditText userText = null;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            userText = (EditText) findViewById(R.id.input1);
            datasource = new CommentsDataSource(this);
            datasource.open();

            List<Comment> values = datasource.getAllComments();
            ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
                    android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);
        }
        @Override
        protected void onResume() {
            datasource.open();
            super.onResume();
        }

        @Override
        protected void onPause() {
            datasource.close();
            super.onPause();
        }

}