package Observer;

import java.util.ArrayList;
import java.util.List;

class BitcoinExchangeRate implements Subject {
    double rate;
    final List<Observer> observers = new ArrayList<>();

    public void setRate(double newRate) {
        this.rate = newRate;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(rate);
        }
    }
}
