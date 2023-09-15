package com.example.exemplobancodados.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.OnSwipe;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoListAdapter extends
        RecyclerView.Adapter<AlunoListAdapter.ViewHolder> {

    private ArrayList<Aluno> listaAlunos;
    private Context context;

    public AlunoListAdapter(ArrayList<Aluno> listaAlunos, Context context) {
        this.listaAlunos = listaAlunos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * Método responsável em carregar o arquivo de layout na tela
         */
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_list_aluno,
                parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvRaAluno.setText(String.valueOf(listaAlunos.get(position).getRaAluno()));
        holder.tvNomeAluno.setText(listaAlunos.get(position).getNomeAluno());

    }

    @Override
    public int getItemCount() {
        return this.listaAlunos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvRaAluno;
        public TextView tvNomeAluno;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvRaAluno = itemView.findViewById(R.id.tvRaAluno);
            this.tvNomeAluno = itemView.findViewById(R.id.tvNomeAluno);
        }
    }

}
