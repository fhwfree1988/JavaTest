package Sample.JasperReport;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class CreateReport {

    public static void main(String[] args) {
        System.getProperty("user.dir");

        String masterReportFilePath = "D://Foad/Projects/JavaTest/src/Sample/JasperReport/myTestReport.jrxml";
        String subReportFilePath = "D://Foad/Projects/JavaTest/src/Sample/JasperReport/myTestSubReport.jrxml";
        //"D:\\Foad\\Projects\\JavaTest\\src\\Sample\\JasperReport\\myTestSubReport.jasper"

        String destFileName = "D://Foad/Projects/JavaTest/src/Sample/JasperReport"
                + "/myTestReport.JRprint";

        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new
                JRBeanCollectionDataSource(dataList);

        try {
            /* Compile the master and sub report */
            JasperReport jasperMasterReport = JasperCompileManager
                    .compileReport(masterReportFilePath);
            /*JasperReport jasperSubReport = JasperCompileManager
                    .compileReport(subReportFileName);*/

            Map<String, Object> parameters = new HashMap<String, Object>();
            //parameters.put("subreportParameter", jasperSubReport);
            parameters.put("subreportParameter", compileJRXmlFile(subReportFilePath));
            JasperFillManager.fillReportToFile(jasperMasterReport,destFileName, parameters, beanColDataSource);

        } catch (JRException e) {

            e.printStackTrace();
        }
        System.out.println("Done filling!!! ...");
    }

    private static String compileJRXmlFile(String subReportFilePath) {
        try {
            //String url = servletContext.getRealPath("/WEB-INF/classes") + CURRENT_PATH + fileName;
            //String url = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
            return JasperCompileManager.compileReportToFile(subReportFilePath);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}