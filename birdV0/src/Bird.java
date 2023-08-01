public class Bird {

    private String name;
    private int age;
    private String color;
    private String type;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void fly(){
        /*Issue
         not readable,
         not maintainable,
         not understandable,
         test all cases/path/flow/branch if any thing is added,
         difficult for multiple people to work.
         code duplication
         less reuse
         ** violates S of SOLID*/

         /*S - Single responsibility principle (class/method/package) - should have exactly 1 responsibility
         * - should be having code to do 1 thing
         * - exactly one reason to change code in that unit*/

        /*O - Open/Close principle helps in testing and regression (When because of new feature existing features breaks)
        * */


        //problems due to if else
        if(name == "sparrow") {
            System.out.println(name + " is flying");
        }else if(name == "eagle"){
            System.out.println(name + " is flying");
        }
    }

    public void eat(){

    }

    public void walk(){

    }

    public void makeSound(){

    }
}
