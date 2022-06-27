/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author davidmizrahi
 */
public class Articulo<T> {

    private String titulo;
    private Lista<String> autores;
    private String cuerpo;
    private Lista<String> palabrasClave;

    public Articulo() {

        this.titulo = "";
        this.cuerpo = "";
        this.palabrasClave = new Lista<>();
        this.autores = new Lista<>();
    }

    public void mostrarInfo() {

        String autoresconcatenados = this.autores.concatenarValores(this.autores);
        String palabrasconcatenadas = this.palabrasClave.concatenarValores(this.palabrasClave);
        String aux = "Titulo: " + this.titulo + "\n" + "\n" + "Autores: " + autoresconcatenados + "\n" + "\n" + "Resumen: " + this.cuerpo + "\n" + "\n" + "Palabras Claves: " + palabrasconcatenadas + "\n";

        //Interfaz
        JFrame frame = new JFrame(this.titulo);
        frame.setSize(500, 500);
        frame.setResizable(false);
        JTextArea textArea = new JTextArea(aux);
        textArea.setSize(400, 400);

        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        frame.setVisible(true);

//        JOptionPane.showMessageDialog(null, autoresconcatenados);
//        JOptionPane.showMessageDialog(null, palabrasconcatenadas);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Lista<String> getAutores() {
        return autores;
    }

    public void setAutores(Lista<String> autores) {
        this.autores = autores;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Lista<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(Lista<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

}
