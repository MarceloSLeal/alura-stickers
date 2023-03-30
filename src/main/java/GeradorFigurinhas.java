import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradorFigurinhas {

    public void criar(InputStream inputStream, String texto, String nomeArquivo) throws IOException {

        //leitura imagem
//        InputStream inputStream = new URL("https://image.tmdb.org/t/p/w500/tmU7GeKVybMWFButWEGl2M4GeiP.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        if (imagemOriginal == null) {
            return;
        }

        //cria imagem em memória com tranparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // escrever uma frase na nova imagem
        centralizarTexto(texto, largura, novaAltura + (novaAltura /2), graphics );

        //escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

    private void centralizarTexto(String s, int w, int h, Graphics2D g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }

}
