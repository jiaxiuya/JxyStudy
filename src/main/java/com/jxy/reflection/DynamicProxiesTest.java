package com.jxy.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DynamicProxiesTest {

    public static void main(String[] args) {
        // an invocation handler for our needs
        InvocationHandler myHandler = new HandlerImpl();

        // we can create dynamic proxy clases using the Proxy class
        InformationInterface proxy = (InformationInterface)
                Proxy.newProxyInstance(InformationInterface.class.getClassLoader(),
                        new Class[]{InformationInterface.class},
                        myHandler);

        // all calls to the proxy will be passed to the handler -> the handler 	implementation can be
        // decided on runtime as well
        System.out.println(proxy.getInfo());
    }


    static class HandlerImpl implements InvocationHandler {

        @Override
        public Object invoke(Object obj, Method method, Object[] arguments) throws Throwable {
            System.out.println("using proxy " + obj.getClass().getName());
            System.out.println("method " + method.getName() + " from interface " + method.getDeclaringClass().getName());

            // we can check dynamically the interface and load the implementation that we want
            if (method.getDeclaringClass().getName().equals("com.jxy.reflection.DynamicProxiesTest$InformationInterface")) {
                InformationClass informationImpl = InformationClass.class.newInstance();
                return method.invoke(informationImpl, arguments);
            }

            return null;
        }
    }


    interface InformationInterface {
        String getInfo();
    }

    static class InformationClass implements InformationInterface {

        @Override
        public String getInfo() {
            System.out.println("调用真实方法！");
            return "代理成功";
        }
    }
}
