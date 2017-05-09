package pe.edu.ulima.hilosapp;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class TareaComplejaTask
        extends AsyncTask<Integer, Void, Boolean>{
    TextView tviMensaje;
    public TareaComplejaTask(TextView tviMensaje){
        this.tviMensaje = tviMensaje;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Siempre se ejecuta en el Hilo Principal o de UI
        tviMensaje.setText("Iniciando Tarea compleja...");
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        // Va a ejecutarse en un hilo alterno (background)
        procesoPesado();
        return null;
    }

    @Override
    protected void onPostExecute(Boolean error) {
        super.onPostExecute(error);
        // Va a ejecutarse en un hilo Principal o de UI
        tviMensaje.setText("Proceso terminado");
    }

    private void procesoPesado(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
