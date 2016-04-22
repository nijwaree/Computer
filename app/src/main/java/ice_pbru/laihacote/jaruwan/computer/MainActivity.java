package ice_pbru.laihacote.jaruwan.computer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button about;
    private ListView traffic;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindwidget();

        contro();

        creatlist();
        
        
    }

    private void creatlist() {
        final int[] intIcon = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
                               R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,
                               R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,
                               R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20};

        final String[] titleStrings = new String[20];
        titleStrings[0] = "Computer";
        titleStrings[1] = "Keyboard";
        titleStrings[2] = "Mouse";
        titleStrings[3] = "Joystick";
        titleStrings[4] = "Floppy Disk";
        titleStrings[5] = "Handy drive";
        titleStrings[6] = "Speaker";
        titleStrings[7] = "Headphones";
        titleStrings[8] = "Webcam";
        titleStrings[9] = "DVD";
        titleStrings[10] = "Modem";
        titleStrings[11] = "Printer";
        titleStrings[12] = "Scanner";
        titleStrings[13] = "Mainboard";
        titleStrings[14] = "RAM";
        titleStrings[15] = "CPU";
        titleStrings[16] = "Harddisk";
        titleStrings[17] = "Display card";
        titleStrings[18] = "Power supply";
        titleStrings[19] = "Hub";


        String[] detailStrings = getResources().getStringArray(R.array.detail_short);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, intIcon, titleStrings, detailStrings);
        traffic.setAdapter(myAdapter);

        traffic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("Title", titleStrings[i]);
                intent.putExtra("Img", intIcon[i]);
                intent.putExtra("Index", i);

                startActivity(intent);
            }
        });


    }

    private void contro() {
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://fonaugust.wordpress.com/2014/05/21/"));
                startActivity(intent);
            }
        });

    }

    private void bindwidget() {
        about = (Button) findViewById(R.id.button);
        traffic = (ListView) findViewById(R.id.listView);


    }
}
