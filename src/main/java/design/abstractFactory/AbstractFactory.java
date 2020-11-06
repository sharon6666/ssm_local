package design.abstractFactory;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public abstract class AbstractFactory {
    public abstract LandAnimal getCat();
    public abstract LandAnimal getDog();
    public abstract WaterAnimal getManta();
    public abstract WaterAnimal getShark();
}
