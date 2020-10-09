package com.example.firstassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.firstassigment.module.IMoviesDa;
import com.example.firstassigment.module.Movies;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner Yspinner;
    private Spinner Gspinner;
    private EditText editText;
    private EditText Tsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gspinner = findViewById(R.id.Gspinner);
        editText=findViewById(R.id.EDresult);
        Yspinner=findViewById(R.id.Yspinner);
        Tsearch=findViewById(R.id.EDsearch);
        GpopulateSpinner();
        YpopulateSpinner();
    }

    private void GpopulateSpinner() {
        MoviesFac factory = new MoviesFac();
        IMoviesDa objBook = factory.getModel();

        String[] cats = objBook.getGenre();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cats);

        Gspinner.setAdapter(adapter);



    }
    private void YpopulateSpinner() {
        MoviesFac factory = new MoviesFac();
        IMoviesDa objBook = factory.getModel();

        String[] cats = objBook.getyears();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cats);

        Yspinner.setAdapter(adapter);



    }

    public void BtnSearchOnclick(View view) {
        MoviesFac factory = new MoviesFac();
        IMoviesDa objmovies = factory.getModel();
        String ress ="";
        String genre  = "";

        String title  = "";

        String year  = "";
        title = String.valueOf(Tsearch.getText());
        if(title.matches("")){
            Toast.makeText(this, "nothing is entered in the title search", Toast.LENGTH_LONG).show();
        }else {
            List<Movies> t =objmovies.getMovieByTitile(title);
            ress+="\n"+"Title result :"+t.toString();
        }
        genre = Gspinner.getSelectedItem().toString();
        List<Movies> gm= objmovies.getMovieByGenre(genre);
//        editText.setText(gm.toString());
        ress+="\n"+"Genre result :"+ gm.toString();
        year = Yspinner.getSelectedItem().toString();
        List<Movies> y= objmovies.getMovieByYear(Integer.parseInt(year));
        ress+= "\n"+"Year res :"+y.toString();


       editText.setText(ress);

        //        year = String.valueOf(Ysearch.getText());
//       List<Movies> y= objmovies.getMovieByYear(Integer.parseInt(year));
//       String res = y.toString();
//        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();

        }
}