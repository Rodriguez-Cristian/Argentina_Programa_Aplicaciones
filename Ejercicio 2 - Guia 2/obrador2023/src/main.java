
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class main {


    public static void main(String[] args)  {
        try {
            //Cargar Driver
            Class.forName("org.mariadb.jdbc.Driver");
            //Conexion a la Base de Dato
           
            //agregar un empleado
          
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/obrador2023", "root"  , null);
            //insertar
            /*String sql = "INSERT INTO empleado(dni, apellido, nombre, acceso, estado) "
                     + "VALUES (35386123,'Rodriguez','Cristian',1,true)";
            
            */
            //Actualizar
            /*String sql = "UPDATE empleado SET nombre='Colo' WHERE dni=35386123";
            */
            
            //eliminar
            /*String sql = "DELETE FROM empleado WHERE dni=35386123";
            */
            
            //consultar(Select)
            String sql = "SELECT * FROM empleado";
            // Enviar el comando         
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            //ejecutar sententencia para insert update delete
            // int registros = ps.executeUpdate();
            
            //ejecutar para select
            ResultSet resultado = ps.executeQuery();
            //System.out.println(registros);
            while (resultado.next()){
                
                System.out.print("ID: "+resultado.getInt("idEmpleado"));
                System.out.print(" |Apellido: "+resultado.getString("apellido"));
                System.out.print(" |Nombre: "+resultado.getString("nombre"));
                System.out.print(" |Estado: "+resultado.getInt("estado"));       
                
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver"+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion"+ex.getMessage());
        }
    }
}
    
