package Racig;

import transport.Bus;
import transport.Transport;

import java.util.LinkedList;
import java.util.Queue;


public class ServiceStation<S extends Transport> {
    private Queue<S> queue = new LinkedList<>();

    public ServiceStation() {
    }

    public void addTransportToServiceStation(S transport) {
        if (transport instanceof Bus) {
            System.out.println("Автобусам не требуется проходить тех.осмотр!");
        } else {
            queue.offer(transport);
            System.out.println(transport.getModel() + " добавлен в очередь на тех. осмотр");
        }
    }

    public void passService() {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().getModel() + " прошел тех. осмотр");
        }
        System.out.println("Очередь на тех. осмотр пуста");

    }

    public Queue<S> getQueue() {
        return queue;
    }


}
