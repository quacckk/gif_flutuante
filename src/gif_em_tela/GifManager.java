package gif_em_tela;

import javax.swing.JOptionPane;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GifManager {

    private List<gifAtivar> gifs = new ArrayList<>();
    private int velocidadeAtual = 2;

    // Método para adicionar GIFs de arquivos locais (via JFileChooser)
    public void adicionarGif(String caminhoDoGif) {
        File file = new File(caminhoDoGif);
        if (file.exists() && caminhoDoGif.toLowerCase().endsWith(".gif")) {
            gifAtivar novoGif = new gifAtivar(caminhoDoGif);
            novoGif.ajustarVelocidade(velocidadeAtual);
            gifs.add(novoGif);
        } else {
            JOptionPane.showMessageDialog(null, "Caminho ou arquivo inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // NOVO MÉTODO: para adicionar GIFs de recursos internos (via URL)
    public void adicionarGifPadrao(URL gifUrl) {
        gifAtivar novoGif = new gifAtivar(gifUrl);
        novoGif.ajustarVelocidade(velocidadeAtual);
        gifs.add(novoGif);
    }

    public void pararTodos() {
        for (gifAtivar gif : gifs) {
            gif.pararExecucao();
        }
        gifs.clear();
    }

    public void aumentarVelocidade() {
        velocidadeAtual = Math.max(1, velocidadeAtual - 20);
        for (gifAtivar gif : gifs) {
            gif.ajustarVelocidade(velocidadeAtual);
        }
    }

    public void diminuirVelocidade() {
        velocidadeAtual += 2;
        for (gifAtivar gif : gifs) {
            gif.ajustarVelocidade(velocidadeAtual);
        }
    }

    public void fecharTodosGifs() {
        for (gifAtivar gif : gifs) {
            gif.dispose();
        }
        gifs.clear();
    }
}