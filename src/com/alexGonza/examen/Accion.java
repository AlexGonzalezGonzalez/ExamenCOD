/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexGonza.examen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
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
       
        String outdir=JOptionPane.showInputDialog("outdir");
        String outfile=JOptionPane.showInputDialog("outfile");
        String BCategory=JOptionPane.showInputDialog("BCategory");
        String srcdir=JOptionPane.showInputDialog("srcdir");
        String srcfiles=JOptionPane.showInputDialog("srcfiles");
        String name=JOptionPane.showInputDialog("name");
        String tittle=JOptionPane.showInputDialog("tittle");
        String appclass=JOptionPane.showInputDialog("Appclass");
        
        try {
            //comando a ejecutar en el terminal
            String cmd = "javapackager -deploy -native deb"
                    +" -Bcategory "+BCategory
                    +" -outdir "+outdir
                    +" -outfile "+outfile
                    +" -srcdir "+srcdir
                    +" -srcfiles "+srcfiles
                    +" -appclass "+appclass
                    +" -name "+name
                    +" -title "+tittle;
            //ejecuta en el terminal 
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
       

    }
}
