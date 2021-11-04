package com.palomakoba.conversordecomprimento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
  
  private EditText edtCentimetros, edtJardas;
  private boolean mudancaAutomatica;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    inicializarComponentes();
    
    edtCentimetros.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    
      }
  
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!mudancaAutomatica){
          double centimetros, jardas;
          try {
            centimetros = Double.parseDouble(s.toString());
            jardas = centimetros / 91.44;
          }catch (NumberFormatException e){
            jardas = 0;
          }
          mudancaAutomatica = true;
          edtJardas.setText(String.format(Locale.US, "%f", jardas));
        }
        else{
          mudancaAutomatica = false;
        }
      }
  
      @Override
      public void afterTextChanged(Editable s) {
      
      }
    });
    
    
    edtJardas.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    
      }
  
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!mudancaAutomatica){
          double centimetros, jardas;
  
          try {
            jardas = Double.parseDouble(s.toString());
            centimetros = jardas * 91.44;
          }catch (NumberFormatException e){
            centimetros = 0;
          }
          mudancaAutomatica = true;
          edtCentimetros.setText(String.format(Locale.US, "%f", centimetros));
        }
        else{
          mudancaAutomatica = false;
        }
      }
  
      @Override
      public void afterTextChanged(Editable s) {
    
      }
    });
  }
  
  private void inicializarComponentes() {
    edtCentimetros = findViewById(R.id.edtCompCentimetros);
    edtJardas      = findViewById(R.id.edtCompJardas);
  }
}