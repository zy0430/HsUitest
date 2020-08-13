package base.base1;

import org.testng.annotations.Test;

public class Base2 {
    @Test(dataProvider="NoNameMethod",dataProviderClass=Base1.class)
    public void doTestNG(String testdatas) {
        System.out.println("未指定名称，数据源名为方法名NoNameMethod:"+testdatas);
    }

//    @Test(dataProvider="dataprovider1",dataProviderClass=Base1.class)
//    public void doTestNG1(String testdatas){
//        System.out.println("指定名称，数据源名称选择了dataprovider1:"+testdatas);
//    }
//
//    @Test(dataProvider="dataprovider2",dataProviderClass=Base1.class)
//    public void doTestNG2(String testdatas){
//        System.out.println("指定名称，数据源名称选择了dataprovider2:"+testdatas);
//    }
}
