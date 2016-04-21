/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.controller;

import abd.p1.bd.UsuarioDAO;
import abd.p1.model.Usuario;
import abd.p1.view.ModificarPerfilUsuario;
import java.util.ArrayList;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jhersy Nolasco y Roberto Barrasus
 */
public class Controlador {
    
    private SessionFactory sf;
    public Controlador(SessionFactory sf) {
        this.sf = sf;
    }   
    
    public boolean busquedaUsuario(Usuario usuario){
        boolean encontrado = false;
        UsuarioDAO ud = new UsuarioDAO(sf);
        //consultar usuario
        // si el usuario inserta mal la contraseña, ventana con mensahje de error
        ud.comprobarUsuario(usuario.getCorreo(), usuario.getContrasena());               
        // llamaria a modificarPerfilUsuario pasandole false en edicion
        return encontrado;
    }
    
    public void nuevoUsuario(Usuario usuario){
        UsuarioDAO ud = new UsuarioDAO(sf);
     
        System.out.println("sale el nombre " + usuario.getNombre());
     //   ud.insertarUsuario(usuario);
        
        // lanzar la vista principal
        
        
        
    }
    
    public ArrayList obtenerUsuarios(){
        UsuarioDAO ud = new UsuarioDAO(sf);
        return ud.obtenerUsuarios();
    }
    
    
}
