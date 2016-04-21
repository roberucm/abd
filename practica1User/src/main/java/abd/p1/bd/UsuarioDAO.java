/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.bd;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import abd.p1.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rober y Jhersy
 */
public class UsuarioDAO {
    private SessionFactory sf;
    private Session s;
    public UsuarioDAO(SessionFactory sf){
        this.sf = sf;
    }    
    
    public boolean comprobarUsuario(String user, String password){
        String sql = "SELECT * FROM usuarios WHERE correo = " + user + " AND contrasena = " + password;
        Session session = sf.openSession();
        Query query = session.createQuery(sql);
        List<Usuario> users = (List<Usuario>) query.list();
        if(users.isEmpty())
            return false;
        else return true;
    }
    
    public void insertarUsuario(Usuario user){        
        String sql = "INSERT INTO usuarios ( correo , contraseña , genero , busca , fecha_nac , "
                + "foto , descripcion , aficiones, amigos , completa , recibidos , enviados )"
                + " VALUES (" + user.getCorreo() + user.getContrasena() + user.getGenero()+
                user.getBusca() + user.getFecha_nac() + user.getFoto() + user.getDescripcion()
                + user.getAficiones() + user.getAmigos() + user.getCompleta() + user.getRecibidos()
                + user.getEnviados() + " )";
        
        Session session = sf.openSession();
        Query query = session.createSQLQuery(sql);
        int result = query.executeUpdate();
    }
    
    public ArrayList obtenerUsuarios(){
        String sql = "SELECT nombre, fecha_nac, foto FROM usuarios";
        Session sesion = sf.openSession();
        Query consulta = sesion.createQuery(sql);
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) consulta.list();
        return usuarios;
    }
    
}
