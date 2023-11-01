package com.offer.mayi;

import lombok.Data;

import java.util.*;

/**
 * Parklot class
 *
 * @author 格林
 * @date 2023-11-01
 */


@Data
class  Car {
    private Long carNo;
    // 0 小车 1 货车
    private Integer type;
    private Date startTime;
    private Date endTime;
    private Long money;


    public Car(Long carNo, Integer type, Date startTime) {
        this.carNo = carNo;
        this.type = type;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNo=" + carNo +
                ", type=" + type +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", money=" + money +
                '}';
    }
}
@Data
 class ParklotOne {
    /**
     * 一天最大金额
     */
    private  Integer maxMoney ;
    /**
     * 一小时金额
     */
    private  Integer oneHourMoney ;
    /**
     * 总金额
     */
    private Long money;
    /**
     * 进车记录
     */
    private List<Car> records;
    /**
     * 车位占用
     */
    private Map<Long, Car> carMap;
    // 最大车位
    private Integer maxSize;

     public ParklotOne(Integer maxMoney, Integer oneHourMoney, Integer maxSize ) {
         this.maxMoney = maxMoney;
         this.oneHourMoney = oneHourMoney;
         this.money = 0L;
         this.carMap = new HashMap<>();
         this.records = new LinkedList<>();
         this.maxSize = maxSize;
     }

     public int getlast() {
         return maxSize - carMap.size();
    }

 }
enum CarType {
    Car(0),
    truck(1)
    ;
    int type;

    CarType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}

@Data
public  class Parklot{
    ParklotOne cars = new ParklotOne(60, 5, 100);
    ParklotOne trucks = new ParklotOne(120, 10, 100);

    public int in(Long carNo , Integer type) {
        if(type == CarType.Car.getType()  ||  type == CarType.truck.getType() ) {
            if(cars.getlast() >= 1) {
                Car car = new Car(carNo, type, new Date());
                ParklotOne parklotOne =  type == CarType.Car.getType() ? cars : trucks;
                parklotOne.getCarMap().put(carNo, car) ;
                return parklotOne.getlast();
            }
        }

        return  - 1;
    }


    public long out(Long carNo , Integer type) {
        if(type == CarType.Car.getType()  ||  type == CarType.truck.getType() ) {
            ParklotOne parklotOne =  type == CarType.Car.getType() ? cars : trucks;
            Car car = parklotOne.getCarMap().get(carNo);
            car.setEndTime(new Date());
            long hours = (  car.getEndTime().getTime() - car.getStartTime().getTime() ) / 1000/ 3600;
            if( hours <= 0) {
                hours = 1;
            }
            car.setMoney( Math.max(parklotOne.getMaxMoney(), hours *  parklotOne.getOneHourMoney()));

            parklotOne.getRecords().add(car);
            parklotOne.setMoney( parklotOne.getMoney() + car.getMoney());
            parklotOne.getCarMap().remove(carNo);
            return car.getMoney();
        }
        return -1;
    }

    public long allMoney() {
        return cars.getMoney() + trucks.getMoney();
    }


    public static void main(String[] args) {
        Parklot parklot = new Parklot();
        int inRes = parklot.in(1L, 0);
        System.out.println("剩余当前类型车位："  + inRes);
        inRes =  parklot.in(2L, 0);
        System.out.println("剩余当前类型车位："  + inRes);
        inRes =  parklot.in(3L, 0);
        System.out.println("剩余当前类型车位："  + inRes);
        inRes = parklot.in(4L, 1);
        System.out.println("剩余当前类型车位："  + inRes);
        inRes =  parklot.in(5L, 1);
        System.out.println("剩余当前类型车位："  + inRes);
        inRes =   parklot.in(6L, 1);
        System.out.println("剩余当前类型车位："  + inRes);

        long outRes = parklot.out(1L,0);
        System.out.println("消费："  + outRes);
        outRes =parklot.out(2L,0);
        System.out.println("消费："  + outRes);
        outRes =parklot.out(3L,0);
        System.out.println("消费："  + outRes);
        outRes =parklot.out(4L,1);
        System.out.println("消费："  + outRes);
        outRes =parklot.out(5L,1);
        System.out.println("消费："  + outRes);
        outRes =parklot.out(6L,1);
        System.out.println("消费："  + outRes);

        long allMoney = parklot.allMoney();
        System.out.println("赚钱：" + allMoney);


        System.out.println("离场记录");
        for(Car  car : parklot.getCars().getRecords()) {
            System.out.println(car);
        }
        for(Car  car : parklot.getTrucks().getRecords()) {
            System.out.println(car);
        }

    }
}
