package br.com.up.zapzap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputLayoutTelefone;
    private TextInputLayout inputLayoutMensagem;
    private TextInputEditText inputTextTelefone;
    private TextInputEditText inputTextMensagem;

    private Button buttonEnviarMensagem;

    private Uri linkParaZapZap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutTelefone = findViewById(R.id.input_layout_telefone);
        inputLayoutMensagem= findViewById(R.id.input_layout_mensagem);

        inputTextTelefone = findViewById(R.id.input_text_telefone);
        inputTextMensagem = findViewById(R.id.input_text_mensagem);

        buttonEnviarMensagem = findViewById(R.id.button_enviar_mensagem);

        buttonEnviarMensagem.setOnClickListener(view -> enviarMensagem());
    }

    private void enviarMensagem() {
        String numero = inputTextTelefone.getText().toString();
        String mensagem = inputTextMensagem.getText().toString();

        if(numero.isEmpty()){
            inputLayoutTelefone.setError("Favor inserir o número.");
            return;
        }

        if(mensagem.isEmpty()){
            inputLayoutMensagem.setError("Favor inserir a mensagem");
            return;
        }

        linkParaZapZap = Uri.parse("https://wa.me/55" + numero + "?text=" + mensagem);
        Intent zapZapIntent = new Intent(Intent.ACTION_VIEW, linkParaZapZap);
        startActivity(zapZapIntent);

    }
}