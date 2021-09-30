package co.com.k4soft.miagenda.ui.citas;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import co.com.k4soft.miagenda.entitiy.Cita;
import co.com.k4soft.miagenda.entitiy.Persona;
import co.com.k4soft.miagenda.persistencia.room.DataBaseHelper;

public class CitaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CitaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Cita>> listAllCitas(Context context) {
        return DataBaseHelper.getDBMainThread(context).getCitaDAO().findAllCitas();
    }

    public Persona findByIdPersona(Context context, Integer idPersona){
        return DataBaseHelper.getDBMainThread(context).getPersonaDAO().findByIdpersona(idPersona);
    }
}