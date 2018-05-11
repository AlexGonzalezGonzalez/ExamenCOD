/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexGonza.examen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.alexGonza.examen.Accion"
)
@ActionRegistration(
        iconBase = "com/alexGonza/examen/iconoExamen.png",
        displayName = "#CTL_Accion"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 0)
    ,
  @ActionReference(path = "Toolbars/File", position = 0)
})
@Messages("CTL_Accion=Accion")
public final class Accion implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //pedimos los datos
        String outdir = JOptionPane.showInputDialog("outdir");
        String outfile = JOptionPane.showInputDialog("outfile");
        String bcategory = JOptionPane.showInputDialog("category");
        String srcdir = JOptionPane.showInputDialog("srcdir");
        String srcfiles = JOptionPane.showInputDialog("srcfiles");
        String appclass = JOptionPane.showInputDialog("appclass");
        String nametitle = JOptionPane.showInputDialog("Titulo y nombre");

       //Comando  que se ejecuta
        
                    String cmd = "javapackager -deploy -native deb "
                    + "-Bcategory="+bcategory 
                    + " -outdir " +outdir
                    + " -outfile "+ outfile
                    + " -srcdir "+srcdir
                    + " -srcfiles "+srcfiles
                    + " -appclass "+appclass
                    + " -name "+nametitle
                    + " -title "+nametitle;
                    
        try {
            
            //Ejecuta el comando en el terminal
            
            Runtime rt = Runtime.getRuntime();
            
            Process pr = rt.exec(cmd);
            
           

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
