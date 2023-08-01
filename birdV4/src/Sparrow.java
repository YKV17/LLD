import flying_behaviour.FlyingBehaviour;

public class Sparrow extends Bird implements IFlyable{

    FlyingBehaviour flyingBehaviour;

    public Sparrow(FlyingBehaviour flyingBehaviour){
        this.flyingBehaviour = flyingBehaviour;
    }

    @Override
    public void fly() {
        flyingBehaviour.makeFly();
    }

    @Override
    public void eat() {

    }

    @Override
    public void walk() {

    }

    @Override
    public void makeSound() {

    }
}
