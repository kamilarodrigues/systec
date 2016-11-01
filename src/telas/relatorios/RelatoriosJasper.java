package telas.relatorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap; 
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport; 
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import Singleton.ConexaoSingleton; 


/**
 *
 * @author Kamila
 */
public final class RelatoriosJasper {

    private String url;
    private Map parameters = new HashMap();
    private String banco;
    private String local;
    private String senha;
    String usuario;
    String porta;
    
    

    public RelatoriosJasper(String url, Map parameters) {
        carregarBancoDados();
        this.url = url;
        this.parameters = parameters;
        gerarRelatorios();
    }
     
    private void carregarBancoDados() {

        String localIni = System.getProperty("user.dir");
        localIni = localIni + "/systec.properties";
        File file = new File(localIni);
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            //lê os dados que estão no arquivo
            props.load(fis);
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(ConexaoSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        banco = props.getProperty("banco");
        local = props.getProperty("local");
        senha = props.getProperty("senha");
        usuario = props.getProperty("usuario");
        porta = props.getProperty("porta");

    }

    public void gerarRelatorios(){
        URL is = this.getClass().getClassLoader().getResource(url);
        String conexao = "jdbc:mysql://" + local + ":" + porta + "/" + banco;
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(conexao,  usuario,senha);
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", false);
            viewer.setSize(1024, 768);
            viewer.setLocationRelativeTo(null);
 
            JasperReport relatoriosJasper = (JasperReport) JRLoader.loadObject(is);
            this.parameters.put("REPORT_CONNECTION", conn);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatoriosJasper, this.parameters);
            JRViewer jrViewer = new JRViewer(jasperPrint); 
            viewer.getContentPane().add(jrViewer);
            viewer.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        } 
    } 
}
