package com.mobigic.cloud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Model> list;

    private MyAdapter adapter;
    private FirebaseStorage mStorage;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("Image");
    private ValueEventListener  mDBListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.seetOnitemClickListener(ShowActivity.this);
        mStorage=FirebaseStorage.getInstance();
        mDBListener = root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Model model = dataSnapshot.getValue(Model.class);
                    model.setMkey(dataSnapshot.getKey());
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void back(View view) {
        startActivity(new Intent(ShowActivity.this, MainActivity.class));
        finishAffinity();
    }

    //on back button press stop
    @Override
    public void onBackPressed() {

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(ShowActivity.this, "click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWhatEverClick(int position) {
        Toast.makeText(ShowActivity.this, "ehateveer", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClick(int position) {
        Model selectedItem = list.get(position);
        String selectedkey = selectedItem.getMkey();
        StorageReference imageRef = mStorage.getReferenceFromUrl(selectedItem.getImageUrl());
        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                root.child(selectedkey).removeValue();
                Toast.makeText(ShowActivity.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected  void onDestroy(){{
    super.onDestroy();
    root.removeEventListener(mDBListener);
    }
    }
}
