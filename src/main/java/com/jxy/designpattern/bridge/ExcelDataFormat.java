package com.jxy.designpattern.bridge;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ExcelDataFormat extends DataFormat {

    @Override
    public void transformData() {
        String data = databaseReadInterface.readData();
        System.out.println("转换数据为Excel格式" + data);
    }
}
