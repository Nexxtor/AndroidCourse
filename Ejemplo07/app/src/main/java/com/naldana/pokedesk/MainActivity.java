package com.naldana.pokedesk;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naldana.pokedesk.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText mPokemonNumber;
    Button mSearchButton;
    TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        mSearchButton.setOnClickListener(view -> {
            String pokemonNumber = mPokemonNumber.getText().toString().trim();
            if (pokemonNumber.isEmpty()) {
                mResultText.setText(R.string.text_nothing_to_show);
            } else {
                new FetchPokemonTask().execute(pokemonNumber);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    void bindView() {
        mPokemonNumber = findViewById(R.id.et_pokemon_number);
        mSearchButton = findViewById(R.id.bt_search_pokemon);
        mResultText = findViewById(R.id.tv_result);
    }


    private class FetchPokemonTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... pokemonNumbers) {

            if (pokemonNumbers.length == 0) {
                return null;
            }

            String ID = pokemonNumbers[0];



            URL pokeAPI = NetworkUtils.buildUrl(ID);

            try {
                String result = NetworkUtils.getResponseFromHttpUrl(pokeAPI);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override
        protected void onPostExecute(String pokemonInfo) {
            if (pokemonInfo != null || !pokemonInfo.equals("")) {
                mResultText.setText(pokemonInfo);
            } else {
                mResultText.setText(getString(R.string.text_not_found_message));
            }
        }
    }
}