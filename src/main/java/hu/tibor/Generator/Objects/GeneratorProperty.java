package hu.tibor.Generator.Objects;

public class GeneratorProperty {
    public GeneratorType type;
    public GeneratorObject[][] generatorObjects;
    public float[] BrakeTime;

    public GeneratorProperty(GeneratorType type, GeneratorObject[][] objects, float[] BrakeTime){
        this.type = type;
        this.generatorObjects = objects;
        this.BrakeTime = BrakeTime;
    }
}
