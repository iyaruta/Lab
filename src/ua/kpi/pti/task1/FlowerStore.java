package ua.kpi.pti.task1;

import ua.kpi.pti.task1.accessory.Accessory;
import ua.kpi.pti.task1.flower.Flower;
import ua.kpi.pti.task1.flowerpot.Flowerpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlowerStore {

    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();
    private List<Flowerpot> flowerpots = new ArrayList<>();

    private Comparator<Flower> lengthComparator = new Comparator<Flower>() {
        @Override
        public int compare(Flower o1, Flower o2) {
            return o1.getLength().compareTo(o2.getLength());
        }
    };

    public List<Flower> findByDate() {
        return sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }

    public List<Flower> findByLength() {
        return sort(lengthComparator);
    }

    public List<Accessory> getAccessories() {
        return new ArrayList<>(accessories);
    }

    public List<Flowerpot> getFlowerpots() {
        return flowerpots;
    }

    public FlowersBouquet makeBouquet(List<Flower> chosenFlowers, List<Accessory> chosenAccessories) {
        FlowersBouquet bouquet = new FlowersBouquet();
        for (Flower flower : chosenFlowers) {
            bouquet.add(flower);
            flowers.remove(flower);
        }

        for (Accessory accessory : chosenAccessories) {
            bouquet.add(accessory);
            accessories.remove(accessory);
        }
        return bouquet;
    }

    private List<Flower> sort(Comparator<Flower> comparator) {
        List<Flower> result = new ArrayList<>(flowers);
        Collections.sort(result, comparator);
        return result;
    }

}
