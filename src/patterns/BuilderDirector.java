package patterns;

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
    }

    @Override
    void buildWalls() {
        house.walls="common walls";
    }

    @Override
    void roofed() {
        house.roofed="common roofed";
    }
}

class GreatBuilder extends Builder {

    @Override
    void buildBasic() {
        house.basic="great basic";
    }

    @Override
    void buildWalls() {
        house.walls="great walls";
    }

    @Override
    void roofed() {
        house.roofed="great roofed";
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