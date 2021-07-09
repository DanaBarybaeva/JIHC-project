package com.example.adminjihcproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.adminjihcproject.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;



public class MugalimderEngizu extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase sqLiteDatabase;
    Button btnok;
    TextInputEditText nameengizu, synypengizu, numberengizu;
    FirebaseAuth fauth;
    DatabaseReference realtimeDB;
    Mugalim mugalim;
    Button SavePhoto;
    ImageButton PhotoEngizu;
    StorageReference storage;
    private Uri imageUri;
    Long childName;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mugalimder_engizu);

        nameengizu = findViewById(R.id.nameengizu);
        synypengizu = findViewById(R.id.klasengizu);
        numberengizu = findViewById(R.id.numberengizu);

        SavePhoto = findViewById(R.id.btnSave);
        PhotoEngizu = findViewById(R.id.photoengizu);
        btnok = findViewById(R.id.btnOk);
        fauth = FirebaseAuth.getInstance();
        btnok.setOnClickListener(this);
        progressBar = findViewById ( R.id.progressBar );

//        SavePhoto.setOnClickListener(this);
//        PhotoEngizu.setOnClickListener(this);

        realtimeDB = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance ().getReference ();



        PhotoEngizu.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent ();
                galleryIntent.setAction ( Intent.ACTION_GET_CONTENT );
                galleryIntent.setType ( "image/*" );
                startActivityForResult ( galleryIntent,2 );
            }
        } );

        SavePhoto.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(imageUri != null){
                    uploadToFirebase(imageUri);

                }else{
                    Toast.makeText ( MugalimderEngizu.this, "Please, select image", Toast.LENGTH_SHORT );
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode , int resultCode , @Nullable Intent data) {
        super.onActivityResult ( requestCode , resultCode , data );
//        if(requestCode == 2 && requestCode == RESULT_OK && data !=null){
//            imageUri = data.getData ();
//            addPhoto.setImageURI(imageUri);
//        }

        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Get the Uri of data
            imageUri = data.getData();
            try {
                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore.Images.Media.getBitmap ( getContentResolver (), imageUri );
                PhotoEngizu.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    private  void uploadToFirebase(Uri uri){
        progressBar.setVisibility ( View.VISIBLE );
        StorageReference storageReference = storage.child ( System.currentTimeMillis() + "." + getFileExtension(uri));
        storageReference.putFile ( uri ).addOnSuccessListener ( new OnSuccessListener<UploadTask.TaskSnapshot> () {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageReference.getDownloadUrl ().addOnSuccessListener ( new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Model model = new Model(uri.toString ());
                        String modelId = realtimeDB.push ().getKey();
                        realtimeDB.child (modelId).setValue ( model );
                        Toast.makeText ( MugalimderEngizu.this,"Uploaded successfully",Toast.LENGTH_SHORT );
                    }
                } );
            }
        }).addOnProgressListener ( new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                progressBar.setVisibility ( View.VISIBLE );
            }
        } ).addOnFailureListener ( new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText ( MugalimderEngizu.this,"Uploading failed!",Toast.LENGTH_SHORT );
                progressBar.setVisibility ( View.INVISIBLE );
            }
        } );
    }

    private String getFileExtension(Uri mUri){
        ContentResolver cr = getContentResolver ();
        MimeTypeMap mime = MimeTypeMap.getSingleton ();
        return mime.getExtensionFromMimeType ( cr.getType ( mUri ));

    }












//    public void initWidgets() {
//
//        nameengizu = findViewById(R.id.nameengizu);
//        synypengizu = findViewById(R.id.klasengizu);
//        numberengizu = findViewById(R.id.numberengizu);
//
//        SavePhoto = findViewById(R.id.btnSave);
//        PhotoEngizu = findViewById(R.id.photoengizu);
//        btnok = findViewById(R.id.btnOk);
//        fauth = FirebaseAuth.getInstance();
//
//    }

    private void insertData() {
        String nameengizuu = nameengizu.getText().toString();
        String synypengizuu = synypengizu.getText().toString();
        Long phonenumberr = Long.parseLong(numberengizu.getText().toString());


        mugalim = new Mugalim(nameengizuu,synypengizuu,phonenumberr,"url");
        childName = mugalim.getPhoneNumber();

        realtimeDB.child("realtimedata").child(String.valueOf(childName)).setValue(mugalim);
        Toast.makeText(MugalimderEngizu.this, "Success", Toast.LENGTH_SHORT).show();


    }




    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(nameengizu.getText())) {
            nameengizu.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(synypengizu.getText())) {
            synypengizu.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(numberengizu.getText())) {
            numberengizu.setError("Tolyq emes");
            return;
        }
        startActivity(new Intent(MugalimderEngizu.this,MainActivity.class));



        insertData();

    }
}
