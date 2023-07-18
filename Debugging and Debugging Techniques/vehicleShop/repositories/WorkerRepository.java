package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WorkerRepository implements Repository<Worker> {
    //депо за съхранение на работници
    private Collection<Worker> workers;

    public WorkerRepository() {
        this.workers = new ArrayList<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers);
    }

    @Override
    public void add(Worker worker) {
        this.workers.add(worker);
    }

    @Override
    public boolean remove(Worker worker) {
        return workers.remove(worker);
    }

    @Override
    public Worker findByName(String name) {
        return workers.stream()
                .filter(w -> w.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
