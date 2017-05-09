package pe.edu.ulima.hilosapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{
    Button butClick;
    TextView tviMensaje;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tviMensaje = (TextView) findViewById(R.id.tviMensaje);
        butClick = (Button) findViewById(R.id.butClick);
        butClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // proceso altamente pesado (computacionalmente hablando)
        Thread hilo = new Thread(){
            @Override
            public void run() {
                // se va a ejecutar en un hilo alterno
                procesoPesado();

            }
        };
        hilo.start();
    }

    private void procesoPesado(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                tviMensaje.setText("Proceso terminado");
            }
        });
    }
}
