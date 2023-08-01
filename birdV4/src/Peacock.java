import flying_behaviour.FlyingBehaviour;

public class Peacock extends Bird implements IFlyable{

    FlyingBehaviour flyingBehaviour;

    public Peacock(FlyingBehaviour flyingBehaviour){
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
