package lk.slt.soa.logfilesmaster.utility;

import lk.slt.soa.logfilesmaster.models.LogError;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExportImpl implements ExcelExport{

    public static ByteArrayInputStream excelFileConverter(List<LogError> errorData ) {

        try{
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Logfile_Error_Sheet");


            Font headerFont = workbook.createFont();
            ((Font) headerFont).setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.RED.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);


            errorData.forEach((errorEntity)-> {
                int RowNum=sheet.getLastRowNum()+1;
                Row row = sheet.createRow(RowNum);

                row.createCell(0)
                        .setCellValue(errorEntity.getPayloadID());
                row.createCell(1)
                        .setCellValue(errorEntity.getOrderNumber());
                row.createCell(2)
                        .setCellValue(errorEntity.getErrorDescription());
            });

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        }catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
