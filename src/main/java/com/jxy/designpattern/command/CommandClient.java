package com.jxy.designpattern.command;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/14 10:01]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CommandClient {
    public static void main(String[] args) {
        MenuItem menuItemCreate = new MenuItem();
        menuItemCreate.setName("创建");
        menuItemCreate.setAbstractCommand(new CreateAbstractCommand());

        MenuItem menuItemOpen = new MenuItem();
        menuItemOpen.setName("打开");
        menuItemOpen.setAbstractCommand(new OpenAbstractCommand());

        MenuItem menuItemEdit = new MenuItem();
        menuItemEdit.setName("编辑");
        menuItemEdit.setAbstractCommand(new EditAbstractCommand());

        Menu menu =new Menu();
        menu.addMenuItem(menuItemCreate);
        menu.addMenuItem(menuItemEdit);
        menu.addMenuItem(menuItemOpen);

        menu.display();


    }
}
