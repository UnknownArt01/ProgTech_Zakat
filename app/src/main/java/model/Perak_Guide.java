package model;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.nadi.zakat.R;

public class Perak_Guide {
    private Activity activity;
    private AlertDialog dialog;

    public Perak_Guide(Activity myActivity){
        activity = myActivity;
    }
    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.perak_guide, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }
    public void dismiss(){dialog.dismiss();}
}
