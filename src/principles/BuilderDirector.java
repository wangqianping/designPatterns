package principles;

/**
 * 建造者模式
 */
public class BuilderDirector {

    Builder builder;

    public BuilderDirector(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public House build() {

        builder.buildBasic();
        builder.buildWalls();
        builder.roofed();

        return builder.build();
    }


}

abstract class Builder {

    House house = new House();

    abstract void buildBasic();

    abstract void buildWalls();

    abstract void roofed();

    public House build(){
        return house;
    }

}

class CommonBuilder extends Builder {

    @Override
    void buildBasic() {
        house.basic="common basic";
        System.out.println("commonBuilder bulid basic");
    }

    @Override
    void buildWalls() {
        house.walls="common walls";
        System.out.println("commonBuilder bulid walls");
    }

    @Override
    void roofed() {
        house.roofed="common roofed";
        System.out.println("commonBuilder roofed");
    }
}

class GreatBuilder extends Builder {

    @Override
    void buildBasic() {
        house.basic="great basic";
        System.out.println("greatBuilder bulid basic");
    }

    @Override
    void buildWalls() {
        house.walls="great walls";
        System.out.println("greatBuilder bulid walls");
    }

    @Override
    void roofed() {
        house.roofed="great roofed";
        System.out.println("greatBuilder roofed");
    }
}

class House {
    String basic;
    String walls;
    String roofed;

    @Override
    public String toString() {
        return "House{" +
                "basic='" + basic + '\'' +
                ", walls='" + walls + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }
}

class Test{
    public static void main(String[] args) {

        BuilderDirector builderDirector = new BuilderDirector(new CommonBuilder());
        House commonHouse = builderDirector.build();
        builderDirector.setBuilder(new GreatBuilder());
        House greatHouse = builderDirector.build();
        System.out.println("普通建造者建造普通房子 "+commonHouse.toString());
        System.out.println("卓越建造者建造伟大建筑 "+greatHouse.toString());
    }
}