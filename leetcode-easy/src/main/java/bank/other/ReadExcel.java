package bank.other;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.*;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;

/**
 * @author jiaoxian
 * @name bank.other
 * @date 2024/1/5 15:02
 * @description TODO
 */
public class ReadExcel {

    public static List<String[]> readExcel(InputStream input, boolean isExcel07, int startRow, int length) {
        List<String[]> data = new ArrayList<String[]>();
        Workbook wb = null;
        try {
            //根据文件格式(2003或者2007)来初始化
            if (isExcel07) {
                wb = new XSSFWorkbook(input);
            } else {
                wb = new HSSFWorkbook(input);
            }
            Sheet sheet = wb.getSheetAt(0);                //获得第一个表单
            Iterator<Row> rows = sheet.rowIterator();    //获得第一个表单的迭代器
            String[] str = null;

            sheet.getLastRowNum();
            while (rows.hasNext()) {
                Row row = rows.next();//获得行数据

                if (startRow > 0) {
                    startRow--;
                    continue;
                }

                int cellCount = row.getLastCellNum();
                str = new String[length];
                for (int i = 0; i < cellCount; i++) {
                    Cell cell = row.getCell(i);
                    if (cell == null) {
                        str[i] = "";
                        continue;
                    }
                    //根据cell中的类型来输出数据
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            int x = cell.getCellStyle().getDataFormat();
//                            if (DateUtil.isCellDateFormatted(cell)) {
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                //处理日期格式、时间格式
                                if (null != cell.getCellStyle().getDataFormatString() && "yyyymmdd".equals(cell.getCellStyle().getDataFormatString())) {
                                    str[i] = DateFormatUtils.format(cell.getDateCellValue(), "yyyyMMdd");
                                } else if (null != cell.getCellStyle().getDataFormatString() && "hhmmss".equals(cell.getCellStyle().getDataFormatString())) {
                                    str[i] = DateFormatUtils.format(cell.getDateCellValue(), "HHmmss");
                                }
                            } else if (cell.getCellStyle().getDataFormat() == 58) {
                                //处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                                final double value = cell.getNumericCellValue();
                                final Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                                str[i] = DateFormatUtils.format(date, "yyyy-MM-dd");
                            } else if (cell.getCellStyle().getDataFormat() == 176) {
                                //处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                                final double value = cell.getNumericCellValue();
                                final Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                                str[i] = DateFormatUtils.format(date, "yyyy-MM-dd");
                            } else if (cell.getCellStyle().getDataFormat() == 0) {
                                DecimalFormat df = new DecimalFormat("0");
                                String value = df.format(cell.getNumericCellValue());
                                str[i] = value;
                            } else {
                                //数值
                                if (StringUtils.isNotBlank(cell.getNumericCellValue() + "")) {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    str[i] = String.valueOf(cell.getStringCellValue());
                                    if (str[i] != null && !"".equals(str[i]) && str[i].indexOf(",") != -1) {
                                        str[i] = str[i].replaceAll(",", "");
                                    }
                                }
                            }
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            str[i] = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            if (StringUtils.isNotBlank(cell.getBooleanCellValue() + "")) {
                                str[i] = String.valueOf(cell.getBooleanCellValue());
                            }
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            str[i] = cell.getCellFormula();
                            break;
                        default:
                            str[i] = "";
                            //logger.info("UnSuported Cell Type " + ">> " + i);
                            break;
                    }//end switch
                }
                //结果集组装
                data.add(str);
            }//end while
        } catch (IOException ex) {
        } finally {
            if (wb != null) {
                try {
                    ((FileInputStream) input).close();
                } catch (IOException e) {
                }
            }
        }
        return data;
    }

    public static List<Map<String, String>> deal(List<String[]> data, int colnum) {
        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
        for (int i = 0; i < data.size(); i++) {
            Map<String, String> resultMap = new HashMap<String, String>();
            String[] data1 = data.get(i);
//            for(int j=0; j<data1.length; j++){
            for (int j = 0; j < colnum; j++) {

                String key = "id" + j;
                if (null != data1[j]) {
                    resultMap.put(key, data1[j]);
                } else {
                    resultMap.put(key, "");
                }
            }
            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                String value = entry.getValue();
                if (value != null && value != "") {
                    resultList.add(resultMap);
                    break;
                }
            }
        }
        return resultList;
    }


    public static void main(String[] args) throws FileNotFoundException {

        String sth = null;
        if ("0".contains(sth)) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
        System.out.println(sth.substring(0,5));


        String content = "hello1234";
        String keys = "key123";
        String charset = "utf-8";
        String sign = "";
        content = content + keys;
        try {

            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(content.getBytes(charset));
            sign = new String(Base64.encodeBase64(md.digest()), charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("sign:" + sign);

        String fileName = "D:\\document\\jiaoxian\\国机私有化\\集票宝\\202334_20240105\\tx_20240105090509_2024-01-04.xlsx";
        String fileColumn = "24";
        String startRow = "3";
        FileInputStream inputStream = new FileInputStream(fileName);
        List<String[]> listData = readExcel(inputStream, true, Integer.valueOf(startRow), Integer.valueOf(fileColumn));
        System.out.println("listData.size = " + listData.size());
        List<Map<String, String>> resultList = deal(listData, Integer.valueOf(fileColumn));
        System.out.println("resultList.size = " + resultList);
    }


}
