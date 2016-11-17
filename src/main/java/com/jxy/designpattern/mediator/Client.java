package com.jxy.designpattern.mediator;

class Client {
    public static void main(String args[]) {  
        //定义中介者对象  
        ConcreteMediator mediator;  
        mediator = new ConcreteMediator();  

        //定义同事对象  
        TextPane textPane = new TextPane();
        ListPane listPane = new ListPane();
        GraphicPane graphicPane = new GraphicPane();

        textPane.setMediator(mediator);
        listPane.setMediator(mediator);
        graphicPane.setMediator(mediator);

        mediator.textPane = textPane;
        mediator.listPane = listPane;
        mediator.graphicPane = graphicPane;

        textPane.change();
        System.out.println(".......................................");
        graphicPane.change();
    }
}