package design.abstractFactory;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class AnimalFactory extends AbstractFactory {
    @Override
    public LandAnimal getCat() {
        return new Cat();
    }

    @Override
    public LandAnimal getDog() {
        return new Dog();
    }

    @Override
    public WaterAnimal getManta() {
        return new Manta();
    }

    @Override
    public WaterAnimal getShark() {
        return new Shark();
    }

    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        LandAnimal cat = factory.getCat();
        cat.crawl();


        LandAnimal dog = factory.getDog();
        dog.crawl();


        WaterAnimal manta = factory.getManta();
        manta.swim();


        WaterAnimal shark = factory.getShark();
        shark.swim();
    }
}
