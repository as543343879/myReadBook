package com.designPatterns.factory.o1;

//step1:创建抽象产品类，定义具体产品的公共接口
public abstract class Shirt{
    public abstract void Show();
}

//step2:创建具体产品类（继承抽象产品类），定义生产的具体产品
//具体产品类A，女款衬衫
 class WomenShirt extends Shirt{
    @Override
    public void Show(){
        System.out.println("展示女款衬衫");
    }
}
//具体产品类B，男款
 class MenShirt extends Shirt{
    @Override
    public void Show(){
        System.out.println("展示男款衬衫")；
        }
}

//step3:创建工厂类，通过静态方法处理不同传入参数，从而创建不同具体产品类的实例
 class Factory{
    public static Shirt Exhibit(String ShirtName){
        switch(ShirtName){
            case "女款衬衫":
                return new WomenShirt();
            case "男款衬衫":
                return new MenShirt();
            default:
                return null;
        }
    }
}

//step4:外界调用工厂类的静态方法，传入不同参数创建不同具体产品类的实例
 class SimpleFactoryPattern{
    public static void main(String[] args){
        Factory exhibitFactory = new Factory();
        //用户搜索女款衬衫
        try{
            //调用工厂类的静态方法，传入参数并创建实例
            exhibitFactory.Exhibit("女款衬衫").Show();
        }catch(NullPointerException e){
            System.out.println("没有找到商品");
        }
        //用户搜索男款裤子
        try{
            exhibitFactory.Exhibit("男款裤子").Show();
        }catch(NullPointerException e){
            System.out.println("没有找到商品");
        }
        //用户搜索男款衬衫
        try{
            exhibitFactory.Exhibit("男款衬衫").Show();
        }catch(NullPointerException e){
            System.out.println("没有找到商品");
        }
    }
}