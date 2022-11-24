package com.example.wheelsapp.ui.home;

public class ListElement {
    public String route,hour,stop1,stop2,stop3,driverName,model;

    public ListElement(String route, String hour, String stop1, String stop2, String stop3, String driverName, String model) {
        this.route = route;
        this.hour = hour;
        this.stop1 = stop1;
        this.stop2 = stop2;
        this.stop3 = stop3;
        this.driverName = driverName;
        this.model = model;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getStop1() {
        return stop1;
    }

    public void setStop1(String stop1) {
        this.stop1 = stop1;
    }

    public String getStop2() {
        return stop2;
    }

    public void setStop2(String stop2) {
        this.stop2 = stop2;
    }

    public String getStop3() {
        return stop3;
    }

    public void setStop3(String stop3) {
        this.stop3 = stop3;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
