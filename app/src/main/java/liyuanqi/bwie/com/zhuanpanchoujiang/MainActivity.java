package liyuanqi.bwie.com.zhuanpanchoujiang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mToob = findViewById(R.id.toob);
         mToob.setLogo(R.mipmap.ic_launcher);

         setSupportActionBar(mToob);
        mToob.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bar1:
                        Toast.makeText(MainActivity.this,"Bar11点击",Toast.LENGTH_SHORT).show();

                        return true;
                    case R.id.bar2:
                        Toast.makeText(MainActivity.this,"Bar22点击",Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);

        return super.onCreateOptionsMenu(menu);
    }

}
