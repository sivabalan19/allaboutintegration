package com.wordpress.allaboutintegration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import oracle.tip.pc.services.pipeline.AbstractValve;
import oracle.tip.pc.services.pipeline.InputStreamContext;
import oracle.tip.pc.services.pipeline.PipelineException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToCSV
        extends AbstractValve
{
    public InputStreamContext execute(InputStreamContext inputStreamContext)
            throws IOException, PipelineException
    {
        System.out.println("The valve will begin executing the inputstream");

        InputStream originalInputStream = inputStreamContext.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        XSSFWorkbook my_xls_workbook = new XSSFWorkbook(originalInputStream);

        XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);

        Iterator<Row> rowIterator = my_worksheet.iterator();

        StringBuffer data = new StringBuffer();
        while (rowIterator.hasNext())
        {
            Row row = (Row)rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext())
            {
                Cell cell = (Cell)cellIterator.next();
                switch (cell.getCellType())
                {
                    case 4:
                        data.append(cell.getBooleanCellValue() + ",");
                        break;
                    case 0:
                        data.append(cell.getNumericCellValue() + ",");
                        break;
                    case 1:
                        data.append(cell.getStringCellValue() + ",");
                        break;
                    case 3:
                        data.append(",");
                        break;
                    default:
                        System.out.println(String.format("Some other format is found: %s with %s. hence, ignored.", cell, data));
                }
            }
            data.deleteCharAt(data.length() - 1);
            data.append("\r\n");
        }
        System.out.println("snippet from stream: " + data.toString());
        ByteArrayInputStream bin = new ByteArrayInputStream(data.toString().getBytes());
        inputStreamContext.setInputStream(bin);
        System.out.println("done processing the stream in the valve");
        return inputStreamContext;
    }

    public void finalize(InputStreamContext inputStreamContext) {}

    public void cleanup()
            throws PipelineException, IOException
    {}
}

