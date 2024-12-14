/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Rene Jose
 */
public class UpperCasePlainDocument extends javax.swing.text.PlainDocument {
      @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offs, str.toUpperCase(), a);
    }
}
