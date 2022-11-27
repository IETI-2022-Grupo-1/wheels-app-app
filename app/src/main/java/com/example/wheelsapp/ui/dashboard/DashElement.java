package com.example.wheelsapp.ui.dashboard;

public class DashElement {
    public String route;
    public String hour;
    public String stop1;
    public String stop2;
    public String stop3;

    public DashElement(String route, String hour, String stop1, String stop2, String stop3) {
        this.route = route;
        this.hour = hour;
        this.stop1 = stop1;
        this.stop2 = stop2;
        this.stop3 = stop3;
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
}
