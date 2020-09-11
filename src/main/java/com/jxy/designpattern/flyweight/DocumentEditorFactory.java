package com.jxy.designpattern.flyweight;

import java.util.Hashtable;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DocumentEditorFactory {
    private static DocumentEditorFactory instance = new DocumentEditorFactory();
    private static Hashtable<String, DocumentEditor> ht;

    private DocumentEditorFactory() {
        ht = new Hashtable<>();
        ht.put("picture", new Picture());
        ht.put("animation", new Animation());
        ht.put("movie", new Movie());
    }

    public static DocumentEditorFactory getInstance() {
        return instance;
    }

    public  DocumentEditor getDocumentByName(String name) {
        return ht.get(name);
    }

}
