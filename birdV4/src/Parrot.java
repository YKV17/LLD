import flying_behaviour.FlyingBehaviour;

public class Parrot extends Bird implements IFlyable{

    FlyingBehaviour flyingBehaviour;

    public Parrot(FlyingBehaviour flyingBehaviour){
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
