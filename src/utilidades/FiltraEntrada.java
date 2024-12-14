package utilidades;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Rene Jose
 */
    public class FiltraEntrada extends DocumentFilter{

    public static final char SOLO_NUMEROS = 'N';
    public static final char SOLO_LETRAS = 'L';
    public static final char NUM_LETRAS = 'M';
    public static final char DEFAULT = '*';
    
    private char tipoEntrada;
    private int longitudCadena=0;
    private boolean permitirEspacioEnBlanco = false;
    private int longitudActual=0;

    public FiltraEntrada() {
        tipoEntrada = DEFAULT;
        permitirEspacioEnBlanco = true;
    }

    public FiltraEntrada(char tipoEntrada,boolean espacioEnBlanco) {
        this.tipoEntrada = tipoEntrada;
        permitirEspacioEnBlanco = espacioEnBlanco;
    }

    public FiltraEntrada(char tipoEntrada,int longitudCadena,boolean espacioEnBlanco) {
        this.tipoEntrada = tipoEntrada;
        this.longitudCadena = longitudCadena;
        permitirEspacioEnBlanco = espacioEnBlanco;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if(string == null)
            return;
        else{
            Document dc = fb.getDocument();
            longitudActual = dc.getLength();
            if(esValido(string))
            {
                if(this.longitudCadena == 0 || longitudActual<longitudCadena)
                    fb.insertString(offset, string, attr);
            }
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if(text == null)
            return;       
        Document dc = fb.getDocument();
            longitudActual = dc.getLength();            
        if(esValido(text))
            {
                if(this.longitudCadena == 0 || longitudActual<longitudCadena)
                    fb.replace(offset, length, text, attrs);;
            }  
    }
    
    private boolean esValido(String valor)
    {
        char[] letras = valor.toCharArray();
        boolean valido = false;
        for(int i=0;i<letras.length;i++)
        {
            switch(tipoEntrada)
            {
                case SOLO_NUMEROS:
                    if(Character.isDigit(letras[i]))
                        valido = true;
                    break;
                case SOLO_LETRAS:
                    if(Character.isLetter(letras[i]))
                    {  
                       valido = true; 
                    }                        
                    break;
                case NUM_LETRAS:
                    if(Character.isLetterOrDigit(letras[i]))
                        valido = true;
                    break;
                case DEFAULT:                    
                    valido = true;
                    break; 
                default:
                    valido = false;
            }
            
            
            if(this.permitirEspacioEnBlanco && tipoEntrada != SOLO_NUMEROS)
            {
               if(Character.isSpaceChar(letras[i]) && longitudActual>1)
                {
                    valido = true;
                } 
            }
            
            if(letrasNoPermitidas(letras[i]))
            {
               valido=false; 
            }
            
            if(valido)
                break;
        }       
        
        return valido;
    }
    
    private boolean letrasNoPermitidas(char cr)
    {
      
         char[] noPermitidas={};                      
        for(int i=0;i<noPermitidas.length;i++)
        {
            if(cr==noPermitidas[i])
                return true;
        }
        
        return false;
    }
    
    //crear una funcion que solo acepte el punto y numeros
    public void validar_importe(){
        
    }
    
    
}
