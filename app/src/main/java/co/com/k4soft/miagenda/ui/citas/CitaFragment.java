package co.com.k4soft.miagenda.ui.citas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import co.com.k4soft.miagenda.databinding.FragmentSlideshowBinding;
import co.com.k4soft.miagenda.entitiy.Cita;
import co.com.k4soft.miagenda.entitiy.Persona;

public class CitaFragment extends Fragment {

    private CitaViewModel citaViewModel;
    private FragmentSlideshowBinding binding;
    private Persona persona;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        citaViewModel =
                new ViewModelProvider(this).get(CitaViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        final ListView listViewCitas = binding.listCitas;
        citaViewModel.getText().observe(getViewLifecycleOwner(),s -> textView.setText(s));
     /*   citaViewModel.findByIdPersona(getContext(), cita.getIdPersona()).observe(getViewLifecycleOwner(),persona -> {

        });*/
        citaViewModel.listAllCitas(getContext()).observe(getViewLifecycleOwner(), lista ->  {
            List<String> citasArray = new ArrayList<>(lista.size());
            for(Cita cita : lista){
                persona = citaViewModel.findByIdPersona(getContext(), cita.getIdPersona());
                citasArray.add(cita.getFecha()+" "+cita.getObservacion()+ " " + cita.getEstado() + " " + persona.getNombres() + " " + persona.getDocumento() );
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.select_dialog_item, citasArray);
            listViewCitas.setAdapter(arrayAdapter);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}