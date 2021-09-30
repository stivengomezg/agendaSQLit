package co.com.k4soft.miagenda.entitiy;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import co.com.k4soft.miagenda.persistencia.Tabla;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = Tabla.CITA)
@NoArgsConstructor
public class Cita {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="idCita")
    private Integer idCita;
    @ColumnInfo(name="c_idPersona")
    private Integer idPersona;
    @ColumnInfo(name="fecha")
    private String fecha;
    @ColumnInfo(name="estado")
    private Integer estado;
    @ColumnInfo(name="observacion")
    private String observacion;
}
