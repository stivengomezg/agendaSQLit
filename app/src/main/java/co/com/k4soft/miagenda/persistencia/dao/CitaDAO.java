package co.com.k4soft.miagenda.persistencia.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.k4soft.miagenda.entitiy.Cita;
import co.com.k4soft.miagenda.entitiy.Persona;

@Dao
public interface CitaDAO {

    @Insert
    void createCita(Cita cita);

    @Query("SELECT * FROM cita INNER JOIN persona ON persona.idPersona = cita.c_idPersona")
    LiveData<List<Cita>> findAllCitas();

    @Query("SELECT fecha FROM cita")
    LiveData<List<String>> findAllCitasAgendadas();

    //@Query("UPDATE cita SET is_processing=1 WHERE item_id in (:items) ")
    //public abstract void updateProcessingStatus(List<String> items);
    @Update
    void updateEstadoCita(Cita cita);
}
