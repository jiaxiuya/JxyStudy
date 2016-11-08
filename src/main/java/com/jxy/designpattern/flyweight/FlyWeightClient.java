package com.jxy.designpattern.flyweight;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FlyWeightClient {

    public static void main(String[] args) {
        DocumentEditorFactory def = DocumentEditorFactory.getInstance();
        DocumentEditor movie = def.getDocumentByName("movie");
        DocumentEditor movie2 = def.getDocumentByName("movie");
        DocumentEditor picture = def.getDocumentByName("picture");
        DocumentEditor animation = def.getDocumentByName("animation");
        animation.display(new LocationSize(1, 2, 3, 4));
        movie.display(new LocationSize(7, 8, 3, 4));
        movie2.display(new LocationSize(7.2, 8.3, 3.3, 4.4));
        picture.display(new LocationSize(3, 4, 5, 6));
    }

}
