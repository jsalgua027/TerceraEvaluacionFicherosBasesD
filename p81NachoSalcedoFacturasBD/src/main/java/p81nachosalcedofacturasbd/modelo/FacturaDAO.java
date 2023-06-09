/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81nachosalcedofacturasbd.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nacho
 */
public class FacturaDAO implements IFactura {

    private Connection con = null;

    public FacturaDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<FacturaVO> getAll() throws SQLException {
        List<FacturaVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try ( Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from facturas");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                FacturaVO f = new FacturaVO();
                // Recogemos los datos de la factura, guardamos en un objeto

//               
                f.setCodigoUnico(res.getInt("CodigoUnico"));
                f.setFechaEmision(res.getDate("FechaEmision").toLocalDate());
                f.setDescripcion(res.getString("Descripcion"));
                f.setTotalImporteFactura(res.getDouble("TotalImporte"));

                //Añadimos el objeto a la lista
                lista.add(f);
            }
        }

        return lista;
    }

    @Override
    public FacturaVO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        FacturaVO factura = new FacturaVO();

        String sql = "select * from facturas where codigoUnico=?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                factura.setCodigoUnico(res.getInt("CodigoUnico"));
                factura.setFechaEmision(res.getDate("FechaEmision").toLocalDate());
                factura.setDescripcion(res.getString("Descripcion"));
                factura.setTotalImporteFactura(res.getDouble("TotalImporte"));

                return factura;
            }

            return null;
        }
    }

    @Override
    public int insertFactura(FacturaVO factura) throws SQLException {

        int numFilas = 0;
        String sql = "insert into facturas values (?,?,?,?)";

        if (findByPk(factura.getCodigoUnico()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, factura.getCodigoUnico());
                prest.setDate(2, Date.valueOf(factura.getFechaEmision()));
                prest.setString(3, factura.getDescripcion());
                prest.setDouble(4, factura.getTotalImporteFactura());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    @Override
    public int insertFacturaVarios(List<FacturaVO> lista) throws SQLException {
        int numFilas = 0;

        for (FacturaVO tmp : lista) {
            numFilas += insertFactura(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteFactura() throws SQLException {

        String sql = "delete from facturas";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try ( Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    @Override
    public int deleteFactura(FacturaVO factura) throws SQLException {
        int numFilas = 0;

        String sql = "delete from facturas where codigoUnico= ?";

        // Sentencia parametrizada
        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, factura.getCodigoUnico());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updateFactura(int pk, FacturaVO factura) throws SQLException {

        int numFilas = 0;
        String sql = "update facturas set  fechaEmision = ?, descripcion = ?, totalImporte=? where codigoUnico=?";

        if (findByPk(pk) == null) {
            // La factura a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(4, factura.getCodigoUnico());
                prest.setDate(1, Date.valueOf(factura.getFechaEmision()));
                prest.setString(2, factura.getDescripcion());
                prest.setDouble(3, factura.getTotalImporteFactura());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

}
