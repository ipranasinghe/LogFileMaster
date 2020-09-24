package lk.slt.security.logfilemaster.utilities;

import lk.slt.security.logfilemaster.model.ErrorEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ErrorExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ErrorEntity> errors;

    public ErrorExcelExporter(List<ErrorEntity> errors){

        this.errors = errors;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Errors");
    }

    private void writeHeaderRow(){
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Payload ID");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Order Number");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("Error Description");
        cell.setCellStyle(style);
    }

    private void writeDataRows(){
        int rowNumber = 1;

        for (ErrorEntity error :
                errors) {
            Row row = sheet.createRow(rowNumber++);

            Cell cell = row.createCell(0);
            cell.setCellValue(error.getId());
            sheet.autoSizeColumn(0);

            cell = row.createCell(1);
            cell.setCellValue(error.getPayloadID());
            sheet.autoSizeColumn(1);

            cell = row.createCell(2);
            cell.setCellValue(error.getOrderNumber());
            sheet.autoSizeColumn(2);

            cell = row.createCell(3);
            cell.setCellValue(error.getErrorDescription());
            sheet.autoSizeColumn(3);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRows();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }

}
