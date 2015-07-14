/**
 * 
 */
package word_java;

import java.io.FileInputStream;

import org.apache.poi.poifs.eventfilesystem.POIFSReader;

/**
 * @author adalberto
 *
 */
public class AnalizadorWord {

	private int numeroCaracteres;
    private int numeroPalabras;
    private int numeroPaginas;
    private String titulo;
    private String autor;
    private String comentarios;
    private String texto;
    private String nombreFichero;

    public AnalizadorWord(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }
    
    public void analizar() throws Exception {
        POIFSReader r1 = new POIFSReader();

        FileInputStream fis=null;

        // Registramos el listener para después analizar la información.

        StandardReaderListener stdReader = new StandardReaderListener();

        stdReader.setDatos(this);

        r1.registerListener( stdReader, "\005SummaryInformation");

        try {

        // Forzamos la lectura del documento.
            fis = new FileInputStream(this.nombreFichero);
        r1.read(fis);
        } catch (Exception e) {
            System.out.println("Error->" + e.toString());
        } finally {
            if(fis!=null)
                fis.close();
        }

    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("");

     sb.append("\n TITULO DEL DOCUMENTO:"+getTitulo());
     sb.append("\n AUTOR DEL DOCUMENTO:"+getAutor());
     sb.append("\n COMENTARIOS DEL DOCUMENTO:"+getComentarios());
    sb.append("\n NUMERO DE CARACTERES:"+getNumeroCaracteres());
    sb.append("\n NUMERO DE PALABRAS:"+getNumeroPalabras());
    sb.append("\n NUMERO DE PAGINAS:"+getNumeroPaginas());
    sb.append("\n ------ TEXTO --------");
    sb.append("\n");
    sb.append(getTexto());
    sb.append("\n ------ TEXTO --------");
    return sb.toString();

    }
    
    /**
	 * @return the numeroCaracteres
	 */
	public int getNumeroCaracteres() {
		return numeroCaracteres;
	}

	/**
	 * @param numeroCaracteres the numeroCaracteres to set
	 */
	public void setNumeroCaracteres(int numeroCaracteres) {
		this.numeroCaracteres = numeroCaracteres;
	}

	/**
	 * @return the numeroPalabras
	 */
	public int getNumeroPalabras() {
		return numeroPalabras;
	}

	/**
	 * @param numeroPalabras the numeroPalabras to set
	 */
	public void setNumeroPalabras(int numeroPalabras) {
		this.numeroPalabras = numeroPalabras;
	}

	/**
	 * @return the numeroPaginas
	 */
	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * @param numeroPaginas the numeroPaginas to set
	 */
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}

	/**
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public static void main(String []args) {

    	String filename = "autentia.doc";
    	AnalizadorWord analizador = new AnalizadorWord(filename);
    	try {

    	analizador.analizar();

    	} catch (Exception e2) {
    	System.out.println("Error"+e2.toString());
    	}

    	System.out.println(analizador);

    	}

}
