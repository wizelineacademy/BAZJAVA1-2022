package prototype;

public class MiG28Plane implements PlaneMold, Cloneable {

    @Override
    public void createPlane() throws CloneNotSupportedException {
        try {
            Object obj = this.clone();
            System.out.println("Created plane object with id: " + obj.hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
